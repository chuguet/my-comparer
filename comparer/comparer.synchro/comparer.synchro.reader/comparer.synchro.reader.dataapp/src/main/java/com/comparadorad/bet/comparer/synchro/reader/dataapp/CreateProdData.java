/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.model.config.service.config.ConfigServiceConfig;
import com.comparadorad.bet.comparer.model.log.service.config.LogServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class CreatePreprodData.
 */
public class CreateProdData extends AbstractCreateData {

	private static final String PRODUCTION = ProfileConstant.PRODUCTION;

	/**
	 * The Class CreatePreprodDataConfig.
	 */
	@Configuration
	@Import({ ConfigServiceConfig.class, BetServiceConfig.class,
			LogServiceConfig.class })
	@Profile(value = { PRODUCTION })
	public static class CreateProdDataConfig {

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		CreateProdData createProdData = new CreateProdData();
		createProdData.launch();
	}

	/** {@inheritDoc} */
	@Override
	protected Class<?> getConfigClass() {
		return CreateProdDataConfig.class;
	}

	/** {@inheritDoc} */
	@Override
	protected String getProfile() {
		return PRODUCTION;
	}
}
