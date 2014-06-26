/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.dbcore.config;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.comparadorad.bet.comparer.model.dbcore.dbinit.MongoInitializer;
import com.comparadorad.bet.comparer.model.dbcore.dbinit.MongoInitializerParams;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractSpringMongoConfig.
 */
abstract class AbstractSpringMongoConfig extends AbstractMongoConfig {

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/**
	 * Mongo initializer.
	 * 
	 * @return the mongo initializer
	 */
	@Bean(initMethod = "initializeDatabase")
	public MongoInitializer mongoInitializer() {
		return new MongoInitializer();
	}

	/**
	 * Mongo initializer params.
	 * 
	 * @return the mongo initializer params
	 * @throws Exception
	 *             the exception
	 */
	@Bean
	public MongoInitializerParams mongoInitializerParams() throws Exception {
		MongoInitializerParams result = null;
		if (getMongoInitializerParamsDefault()) {
			result = getDefaultMongoInitializerParams();
		} else {
			result = new MongoInitializerParams(
					getMongoInitializerParamsDrop(),
					getMongoInitializerParamsCreateData(),
					getMongoInitializerParamsDefault());
		}
		return result;

	}

	private MongoInitializerParams getDefaultMongoInitializerParams() {
		Boolean createData = Boolean.FALSE;
		if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.TEST_NO_CREATE_DATA)) {
			createData = Boolean.FALSE;
		} else if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.CREATE_TEST_DATA)
				|| ArrayUtils.contains(applicationContext.getEnvironment()
						.getActiveProfiles(), ProfileConstant.DEV)
				|| ArrayUtils.contains(applicationContext.getEnvironment()
						.getActiveProfiles(), ProfileConstant.TEST)) {
			createData = Boolean.TRUE;
		}
		return new MongoInitializerParams(createData, createData,
				getMongoInitializerParamsDefault());
	}

}