/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.dbcore.dbinit;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * The Class MongoInitializer.
 */
public class MongoInitializer {

	/** The mongo data initializer plugins. */
	@Autowired(required = false)
	private List<IMongoDataInitializerPlugin> mongoDataInitializerPlugins;

	/** The mongo template. */
	@Inject
	private MongoTemplate mongoTemplate;

	@Inject
	private MongoInitializerParams mongoInitializerParams;

	/**
	 * Initialize database.
	 */
	public void initializeDatabase() {

		if (mongoDataInitializerPlugins != null) {
			if (mongoInitializerParams.isDropDatabase()) {
				mongoTemplate.getDb().dropDatabase();
			}
			if (mongoInitializerParams.isCreateData()) {
				for (IMongoDataInitializerPlugin dataInitializerPlugin : mongoDataInitializerPlugins) {
					dataInitializerPlugin.initializeDatabase();
				}
			}
		}
	}
}
