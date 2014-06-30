/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ProfileDevCache.
 */
@Configuration
@Profile(value = ProfileConstant.DEV)
@PropertySource("classpath:/asynchronous.dev.properties")
class DevCacheConfig extends AbstractCacheConfiguration {

	/** The Constant FILE_CONFIG_CACHE. */
	private static final String FILE_CONFIG_CACHE = "ehcacheDev.xml";
	
	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.util.cache.config.AbstractCacheConfiguration#getNameFileConfig()
	 */
	@Bean(name = "nameFileDevConfig")
	@Override
	public String getNameFileConfig(){
		return FILE_CONFIG_CACHE;
	}

}
