/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.config;

import org.springframework.context.annotation.Configuration;

/**
 * The Class SpringCacheConfiguration.
 */
@Configuration
abstract class AbstractCacheConfiguration {

	/**
	 * Gets the name file config.
	 * 
	 * @return the name file config
	 */
	public abstract String getNameFileConfig();
}
