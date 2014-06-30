/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.test.mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.repository.CrudRepository;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils.FileContent;
import com.comparadorad.bet.comparer.util.test.mongo.exception.TestMongoException;
import com.comparadorad.bet.comparer.util.test.mongo.json.util.JSONUtil;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSONParseException;

/**
 * The Class AbstractTestMongoJSON.
 */
public abstract class AbstractTestMongoJSON extends AbstractTestMongo {

	/** The Constant FILE_EXTENSION_JSON. */
	private static final String FILE_EXTENSION_JSON = "dbread.json";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractTestMongoJSON.class);

	/** {@inheritDoc} */
	@Override
	public void createDB() throws TestMongoException {
		for (Entry<Class<? extends IDocument>, DBCollection> element : getCollections()
				.entrySet()) {
			LOG.debug(new StringBuffer().append("Se va a procesar: ")
					.append(element.getKey().getSimpleName()).toString());
			saveToCollection(element.getKey(), element.getValue());
		}

	}

	/**
	 * Gets the collections.
	 * 
	 * @return the collections
	 */
	protected abstract HashMap<Class<? extends IDocument>, DBCollection> getCollections();

	/** {@inheritDoc} */
	@Override
	public String getFileExtension() {
		return FILE_EXTENSION_JSON;
	}

	/** {@inheritDoc} */
	@SuppressWarnings("rawtypes")
	@Override
	public HashMap<Class<? extends IDocument>, CrudRepository> getRepository() {
		return new HashMap<Class<? extends IDocument>, CrudRepository>();
	}

	/**
	 * Save to collection.
	 * 
	 * @param pClass
	 *            the class
	 * @param collection
	 *            the collection
	 * @throws TestMongoException
	 *             the test mongo exception
	 */
	private void saveToCollection(Class<? extends IDocument> pClass,
			DBCollection collection) throws TestMongoException {
		try {
			List<FileContent> fileContents = getFileContents(pClass);
			DBObject dbObject;
			String[] jsonElements;

			for (FileContent fileContent : fileContents) {
				String fileContentStr = new String(fileContent.getFileContent());
				if (fileContentStr.contains(pClass.getName())) {

					jsonElements = JSONUtil.getFileElements(fileContentStr);

					int numElem = 0;
					for (String element : jsonElements) {
						if (element.contains("{")) { // Hmmm...
							dbObject = JSONUtil.parseJSONToDbObject(element);
							collection.insert(dbObject);
							numElem++;
						}
					}
					LOG.debug(new StringBuffer("Se ha insertado ")
							.append(numElem)
							.append(" elementos en la collecion ")
							.append(collection.getName()).toString());
				}
			}
		} catch (JSONParseException e) {
			LOG.error(e.getMessage(), e);
			throw new TestMongoException("Error parseando json de:"
					+ pClass.getSimpleName(), e);
		} catch (RuntimeException e) {
			LOG.error(e.getMessage(), e);
			throw new TestMongoException("Error en la carga de:"
					+ pClass.getSimpleName(), e);
		}

	}

}
