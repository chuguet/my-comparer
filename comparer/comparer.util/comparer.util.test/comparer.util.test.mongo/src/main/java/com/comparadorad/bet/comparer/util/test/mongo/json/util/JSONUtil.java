/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.test.mongo.json.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils.FileContent;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONParseException;

/**
 * The Class JSONUtil.
 */
public class JSONUtil {

	/** The Constant FILE_EXTENSION_POJO_TO_JSON. */
	private static final String FILE_EXTENSION_POJO_TO_JSON = "pojoread.json";

	/** The Constant JSON_ELEMENT_SEPERATOR. */
	private static final String JSON_ELEMENT_SEPERATOR = "/\\*.*?\\*/";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(JSONUtil.class);

	/** The Constant MONGO_CONVERTER_FRIENDLY_ID. */
	private static final String MONGO_CONVERTER_FRIENDLY_ID = "_id";

	/** The Constant MONGO_CONVERTER_FRIENDLY_REF. */
	private static final String MONGO_CONVERTER_FRIENDLY_REF = "_ref";

	/** The Constant MONGO_DB_JSON_CORRECT_DATE_END. */
	private static final String MONGO_DB_JSON_CORRECT_DATE_END = "Z\"}";

	/** The Constant MONGO_DB_JSON_CORRECT_DATE_START. */
	private static final String MONGO_DB_JSON_CORRECT_DATE_START = "\\{ \"\\$date\" : \"";

	/** The Constant MONGO_DB_JSON_CORRECT_OBJECT_ID. */
	private static final String MONGO_DB_JSON_CORRECT_OBJECT_ID = "\\{ \"\\$oid\" : \"";

	/** The Constant MONGO_DB_JSON_CORRECT_OBJECT_ID_END. */
	private static final String MONGO_DB_JSON_CORRECT_OBJECT_ID_END = "\"}";

	/** The Constant REGEX_$_ID. */
	private static final String REGEX_$_ID = "\\$id";

	/** The Constant REGEX_$_REF. */
	private static final String REGEX_$_REF = "\\$ref";

	/** The Constant REGEX_ISO_DATE_END. */
	private static final String REGEX_ISO_DATE_END = "Z\"\\)";

	/** The Constant REGEX_ISO_DATE_START. */
	private static final String REGEX_ISO_DATE_START = "ISODate\\(\"";

	/** The Constant REGEX_NUMBER_LONG_END. */
	private static final String REGEX_NUMBER_LONG_END = "\\)";

	/** The Constant REGEX_NUMBER_LONG_START. */
	private static final String REGEX_NUMBER_LONG_START = "NumberLong\\(";

	/** The Constant REGEX_OBJECT_ID_END. */
	private static final String REGEX_OBJECT_ID_END = "\"\\)";

	/** The Constant REGEX_OBJECT_ID_START. */
	private static final String REGEX_OBJECT_ID_START = "ObjectId\\(\"";

	/**
	 * Gets the file elements.
	 * 
	 * @param json
	 *            the json
	 * @return the file elements
	 */
	public static String[] getFileElements(String json) {
		return json.split(JSON_ELEMENT_SEPERATOR);
	}

	/**
	 * Gets the file extension.
	 * 
	 * @return the file extension
	 */
	private static String getFileExtension() {
		return FILE_EXTENSION_POJO_TO_JSON;
	}

	/**
	 * Parses the iso date to mongo db date format. El parseador
	 * com.mongodb.util.JSON.parse(String json) no sabe interpretar una fecha de
	 * tipo ISODate: ISODate("2013-07-30T23:01:24.141Z"). Para que esa fecha se
	 * de de alta como DateTime en la BD hay que pasarla a la siguente forma:
	 * {"$date" : "2012-08-31T17:30:01.882Z"}
	 * https://jira.mongodb.org/browse/JAVA-565
	 * 
	 * @param fileContentStr
	 *            the file content str
	 * @return the string
	 */
	private static String parseISODateToBSONDateFormat(String fileContentStr) {

		fileContentStr = fileContentStr.replaceAll(REGEX_ISO_DATE_START,
				MONGO_DB_JSON_CORRECT_DATE_START);

		fileContentStr = fileContentStr.replaceAll(REGEX_ISO_DATE_END,
				MONGO_DB_JSON_CORRECT_DATE_END);

		return fileContentStr;
	}

	/**
	 * Parses the json to db object.
	 * 
	 * @param json
	 *            the json
	 * @return the dB object
	 */
	public static DBObject parseJSONToDbObject(String json) {

		json = translateJSONDataTypesToBSONDataTypes(json);
		DBObject dbObject = (DBObject) JSON.parse(json);

		return dbObject;
	}

	/**
	 * Parses the json to pojo.
	 * 
	 * @param pojoClass
	 *            the pojo class
	 * @param callingClass
	 *            the calling class
	 * @param additionalFileName
	 *            the additional file name
	 * @param mongoTemplate
	 *            the mongo template
	 * @return the list
	 * @throws JSONParseException
	 *             the jSON parse exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static List<IDocument> parseJSONToPOJO(
			Class<? extends IDocument> pojoClass, Class<?> callingClass,
			String additionalFileName, MongoTemplate mongoTemplate)
			throws JSONParseException, IOException {

		LOG.debug(new StringBuffer().append(
				"Se inicia el parseo de JSON a POJO. Se va a procesar: ")
				.append(pojoClass.getSimpleName()));

		List<IDocument> pojos = new ArrayList<IDocument>();

		String fileId = new StringBuffer().append(pojoClass.getSimpleName())
				.append(additionalFileName).toString();
		List<FileContent> fileContents = JarFileUtils.listFilesFromClassDir(
				fileId, getFileExtension(), callingClass);

		String fileContentStr;
		for (FileContent fileContent : fileContents) {
			fileContentStr = new String(fileContent.getFileContent());
			pojos = parseJSONToPOJO(fileContentStr, pojoClass, mongoTemplate);
			// pojos.add(pojo);
		}

		LOG.debug(new StringBuffer()
				.append("Se finaliza el parseo de JSON a POJO. Numero de ")
				.append(pojoClass.getSimpleName()).append(" obtenidos: ")
				.append(pojos.size()));

		return pojos;
	}

	/**
	 * Parses the json to pojo.
	 * 
	 * @param json
	 *            the json
	 * @param pClass
	 *            the class
	 * @param mongoTemplate
	 *            the mongo template
	 * @return the list
	 * @throws JSONParseException
	 *             the jSON parse exception
	 */
	private static List<IDocument> parseJSONToPOJO(String json,
			Class<? extends IDocument> pClass, MongoTemplate mongoTemplate)
			throws JSONParseException {

		List<IDocument> pojos = new ArrayList<IDocument>();

		for (String js : getFileElements(json)) {

			if (js.contains("{")) {

				String jsonWithValidBsonDataTypes = translateJSONDataTypesToBSONDataTypes(js);

				String jsonWithValidMongoConverterSymbols = translateJSONSymbolsToMongoConverterFriendlySymbols(jsonWithValidBsonDataTypes);

				DBObject dbObject = (DBObject) JSON
						.parse(jsonWithValidMongoConverterSymbols);

				IDocument object = mongoTemplate.getConverter().read(pClass,
						dbObject);

				pojos.add(object);
			}

		}

		// String jsonWithValidBsonDataTypes =
		// translateJSONDataTypesToBSONDataTypes(json);
		//
		// String jsonWithValidMongoConverterSymbols =
		// translateJSONSymbolsToMongoConverterFriendlySymbols(jsonWithValidBsonDataTypes);
		//
		// DBObject dbObject = (DBObject) JSON
		// .parse(jsonWithValidMongoConverterSymbols);
		//
		// IDocument object = mongoTemplate.getConverter().read(pClass,
		// dbObject);

		return pojos;
	}

	/**
	 * Parses the number long to bson number format.
	 * 
	 * @param fileContentStr
	 *            the file content str
	 * @return the string
	 */
	private static String parseNumberLongToBSONNumberFormat(
			String fileContentStr) {

		fileContentStr = fileContentStr.replaceAll(REGEX_NUMBER_LONG_START, "");

		fileContentStr = fileContentStr.replaceAll(REGEX_NUMBER_LONG_END, "");

		return fileContentStr;
	}

	/**
	 * Parses the object id to mongo db id format.
	 * ObjectId("528ca0b9b503dec2bda9f7ae") {$oid: "4e942f36de3eda51d5a7436c"}
	 * 
	 * @param fileContentStr
	 *            the file content str
	 * @return the string
	 */
	private static String parseObjectIdToBSONIdFormat(String fileContentStr) {

		fileContentStr = fileContentStr.replaceAll(REGEX_OBJECT_ID_START,
				MONGO_DB_JSON_CORRECT_OBJECT_ID);

		fileContentStr = fileContentStr.replaceAll(REGEX_OBJECT_ID_END,
				MONGO_DB_JSON_CORRECT_OBJECT_ID_END);

		return fileContentStr;
	}

	/**
	 * Translate json data types to bson data types.
	 * 
	 * @param json
	 *            the json
	 * @return the string
	 */
	private static String translateJSONDataTypesToBSONDataTypes(String json) {

		String result;

		result = parseISODateToBSONDateFormat(json);
		result = parseObjectIdToBSONIdFormat(result);
		result = parseNumberLongToBSONNumberFormat(result);

		return result;
	}

	/**
	 * Translate json symbols to mongo converter friendly symbols.
	 * 
	 * @param json
	 *            the json
	 * @return the string
	 */
	private static String translateJSONSymbolsToMongoConverterFriendlySymbols(
			String json) {

		String result;
		result = json.replaceAll(REGEX_$_REF, MONGO_CONVERTER_FRIENDLY_REF);
		result = result.replaceAll(REGEX_$_ID, MONGO_CONVERTER_FRIENDLY_ID);

		return result;
	}

}
