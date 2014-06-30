/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.test.mongo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.CrudRepository;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.dbcore.dbinit.MongoInitializerParams;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils.FileContent;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;
import com.comparadorad.bet.comparer.util.test.mongo.exception.TestMongoException;

/**
 * The Class AbstractTestMongo.
 */
public abstract class AbstractTestMongo {

	/** The Constant FILE_EXTENSION_JSON. */
	private static final String FILE_EXTENSION_JSON = "dbread.json";

	/** The Constant FILE_EXTENSION. */
	private static final String FILE_EXTENSION_XML = "dbread.xml";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractTestMongo.class);

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/** The initializer params. */
	@Inject
	private MongoInitializerParams initializerParams;

	/** The mongo template. */
	@Inject
	protected MongoTemplate mongoTemplate;

	/**
	 * Creates the.
	 * 
	 * @throws TestMongoException
	 *             the test mongo exception
	 */
	@Before
	public void create() throws TestMongoException {
		if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.TEST)) {

			if ((!initializerParams.isDefaultBehavior() && initializerParams
					.isDropDatabase()) || initializerParams.isDefaultBehavior()) {
				LOG.info("Se borra la BBDD");
				mongoTemplate.getDb().dropDatabase();
			}
			if ((!initializerParams.isDefaultBehavior() && initializerParams
					.isCreateData()) || initializerParams.isDefaultBehavior()) {
				LOG.info("Se inicia la creacion de la BBDD");
				if (getFileExtension().equalsIgnoreCase(FILE_EXTENSION_XML)) {
					createDB();
				} else if (getFileExtension().equalsIgnoreCase(
						FILE_EXTENSION_JSON)) {
					createDB();
				}
				LOG.info("Se finaliza la creacion de la BBDD");
			}
		} else {
			LOG.info("El perfil indicado en el test no es correcto");
		}

	}

	/**
	 * Creates the db.
	 * 
	 * @throws TestMongoException
	 *             the test mongo exception
	 */
	public void createDB() throws TestMongoException {
		for (@SuppressWarnings("rawtypes")
		Entry<Class<? extends IDocument>, CrudRepository> element : getRepository()
				.entrySet()) {
			LOG.debug(new StringBuffer().append("Se va a procesar: ")
					.append(element.getKey().getSimpleName()).toString());
			saveToRepository(element.getKey(), element.getValue());
		}
	}

	/**
	 * Drop.
	 */
	@After
	public void drop() {
		if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.TEST)) {
			if ((!initializerParams.isDefaultBehavior() && initializerParams
					.isDropDatabase()) || initializerParams.isDefaultBehavior()) {
				LOG.info("Se inicia el borrado de la BBDD");
				mongoTemplate.getDb().dropDatabase();
				LOG.info("Se finaliza el borrado de la BBDD");
			}
		} else {
			LOG.info("El perfil indicado en el test no es correcto");
		}
	}

	/**
	 * Gets the aditional name for load.
	 * 
	 * @return the aditional name for load
	 */
	protected String getAditionalNameForLoad() {
		return "";
	}

	/**
	 * Gets the file contents.
	 * 
	 * @param pClass
	 *            the class
	 * @return the file contents
	 * @throws TestMongoException
	 *             the test mongo exception
	 */
	protected List<FileContent> getFileContents(
			Class<? extends IDocument> pClass) throws TestMongoException {
		List<FileContent> result;
		try {
			result = JarFileUtils.listFilesFromClassDir(pClass.getSimpleName()
					+ getAditionalNameForLoad(), getFileExtension(),
					getLoaderClass());
			if (result == null || result.isEmpty()) {
				throw new TestMongoException("No existen datos para:"
						+ pClass.getSimpleName());
			}
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw new TestMongoException("Error en la carga de:"
					+ pClass.getSimpleName(), e);
		}
		return result;
	}

	/**
	 * Gets the file extension.
	 * 
	 * @return the file extension
	 */
	protected String getFileExtension() {
		return FILE_EXTENSION_XML;
	}

	/**
	 * Gets the loader class.
	 * 
	 * @return the loader class
	 */
	protected abstract Class<?> getLoaderClass();

	/**
	 * Gets the repository.
	 * 
	 * @return the repository
	 */
	@SuppressWarnings("rawtypes")
	protected abstract HashMap<Class<? extends IDocument>, CrudRepository> getRepository();

	/**
	 * Save to repository.
	 * 
	 * @param pClass
	 *            the class
	 * @param crudRepository
	 *            the crud repository
	 * @throws TestMongoException
	 *             the test mongo exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void saveToRepository(Class<? extends IDocument> pClass,
			CrudRepository crudRepository) throws TestMongoException {

		try {

			List<FileContent> fileContents = getFileContents(pClass);
			for (FileContent fileContent : fileContents) {
				String fileContentStr = new String(fileContent.getFileContent());
				if (fileContentStr.contains(pClass.getName())) {
					LOG.debug("Se va a convertir de xml");
					List result = (List) XStreamUtil.fromXML(fileContentStr);
					if (result != null && !result.isEmpty()) {
						if (result.get(0).getClass().getName()
								.equals(pClass.getName())) {
							crudRepository.save(result);
							LOG.debug(new StringBuffer("Se ha insertado ")
									.append(crudRepository.count())
									.append(" elementos en el repository ")
									.append(pClass.getSimpleName()).toString());
						}
					}
				}
			}
		} catch (RuntimeException e) {
			LOG.error(e.getMessage(), e);
			throw new TestMongoException("Error en la carga de:"
					+ pClass.getSimpleName(), e);
		}
	}

}
