/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.dbcore.dbinit;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.CrudRepository;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.dbcore.exception.DbcoreRuntimeException;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils.FileContent;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class AbstractMongoDataInitializerPlugin.
 */
public abstract class AbstractMongoDataInitializerPlugin implements
		IMongoDataInitializerPlugin {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractMongoDataInitializerPlugin.class);
	/** The mongo template. */
	@Inject
	private MongoTemplate mongoTemplate;

	/**
	 * Gets the mongo template.
	 * 
	 * @return the mongo template
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/** {@inheritDoc} */
	public void initializeDatabase() {
		loadDbCollection();
	}

	/**
	 * Load db collection.
	 */
	public abstract void loadDbCollection();

	/**
	 * Save to repository.
	 * 
	 * @param pClass
	 *            the class
	 * @param crudRepository
	 *            the crud repository
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void saveToRepository(Class<? extends IDocument> pClass,
			CrudRepository crudRepository) {
		try {
			List<FileContent> fileContents = JarFileUtils
					.listFilesFromClassDir(pClass.getSimpleName(),
							".dbread.xml", getClass());
			if (fileContents == null || fileContents.isEmpty()) {
				throw new DbcoreRuntimeException("No existen datos para:"
						+ pClass.getSimpleName());
			}
			for (FileContent fileContent : fileContents) {
				String fileContentStr = new String(fileContent.getFileContent());
				// Esta comprobación se hace porque hay casos que el fichero
				// puede empezar igual el nombre,
				// por ejemplo LogEvents y LogEventsBookmaker
				if (fileContentStr.contains(pClass.getName())) {
					List result = (List) XStreamUtil.fromXML(fileContentStr);
					if (result != null && !result.isEmpty()) {
						// Esta comprobación se hace porque hay casos que el
						// fichero
						// puede empezar igual el nombre,
						// por ejemplo LogEvents y LogEventsBookmaker
						if (result.get(0).getClass().getName()
								.equals(pClass.getName())) {
							crudRepository.save(result);
						}
					}
				}
			}
		} catch (RuntimeException e) {
			LOG.error(e.getMessage(), e);
			throw new DbcoreRuntimeException("Error en la carga de:"
					+ pClass.getSimpleName(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw new DbcoreRuntimeException("Error en la carga de:"
					+ pClass.getSimpleName(), e);
		}
	}
}
