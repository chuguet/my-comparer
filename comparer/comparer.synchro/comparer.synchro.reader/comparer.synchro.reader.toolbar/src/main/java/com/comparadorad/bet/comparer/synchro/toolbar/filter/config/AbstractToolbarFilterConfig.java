/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.toolbar.filter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractReaderFilterConfig.
 */
@Configuration
@PropertySource({ "classpath:/toolbar-filter-config.properties" })
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.toolbar.filter" })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public abstract class AbstractToolbarFilterConfig {
	
	
	/** The hashkey type. */
	@Value("${config.hashkey}")
	private String hashkeyType;
	
	/** The codification. */
	@Value("${config.codification}")
	private String codification;	

	/**
	 * Gets the hashkey type.
	 *
	 * @return the hashkey type
	 */
	public final String getHashkeyType() {
		return hashkeyType;
	}

	/**
	 * Sets the hashkey type.
	 *
	 * @param hashkeyType the new hashkey type
	 */
	public final void setHashkeyType(String hashkeyType) {
		this.hashkeyType = hashkeyType;
	}

	/**
	 * Gets the codification.
	 *
	 * @return the codification
	 */
	public final String getCodification() {
		return codification;
	}

	/**
	 * Sets the codification.
	 *
	 * @param codification the new codification
	 */
	public final void setCodification(String codification) {
		this.codification = codification;
	}
	
	

}
