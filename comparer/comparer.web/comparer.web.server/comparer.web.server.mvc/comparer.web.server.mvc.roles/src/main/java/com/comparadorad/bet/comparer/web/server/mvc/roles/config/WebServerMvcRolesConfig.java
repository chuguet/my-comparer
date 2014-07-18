/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.roles.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreConfig;

/**
 * The Class WebServerMvcRolesConfig.
 */
@Configuration
@Import(value = { WebServerMvcCoreConfig.class })
@ComponentScan("com.comparadorad.bet.comparer.web.server.mvc.roles.control")
@PropertySource(value = { "classpath:/groups.properties" })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class WebServerMvcRolesConfig {

	
	
	/**
	 * Property sources placeholder configurer.
	 *
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	/** The level_1. */
	@Value("${level.1}")
	private int level_1;
	
	/** The level_2. */
	@Value("${level.2}")
	private int level_2;
	
	/** The level_3. */
	@Value("${level.3}")
	private int level_3;
	
	/** The free. */
	@Value("${free}")
	private int free;

	/**
	 * Gets the level_1.
	 *
	 * @return the level_1
	 */
	public int getLevel_1() {
		return level_1;
	}

	/**
	 * Sets the level_1.
	 *
	 * @param level_1 the new level_1
	 */
	public void setLevel_1(int level_1) {
		this.level_1 = level_1;
	}

	/**
	 * Gets the level_2.
	 *
	 * @return the level_2
	 */
	public int getLevel_2() {
		return level_2;
	}

	/**
	 * Sets the level_2.
	 *
	 * @param level_2 the new level_2
	 */
	public void setLevel_2(int level_2) {
		this.level_2 = level_2;
	}

	/**
	 * Gets the level_3.
	 *
	 * @return the level_3
	 */
	public int getLevel_3() {
		return level_3;
	}

	/**
	 * Sets the level_3.
	 *
	 * @param level_3 the new level_3
	 */
	public void setLevel_3(int level_3) {
		this.level_3 = level_3;
	}

	/**
	 * Gets the free.
	 *
	 * @return the free
	 */
	public int getFree() {
		return free;
	}

	/**
	 * Sets the free.
	 *
	 * @param free the new free
	 */
	public void setFree(int free) {
		this.free = free;
	}
	
	
}