/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.dbcore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SpringMongoTestConfig.
 */
@Configuration
@PropertySource("classpath:/database.test.properties")
@Profile(value = { ProfileConstant.TEST })
public class SpringMongoTestConfig extends AbstractSpringMongoConfig {
	
	
	
	@Override
	public String getNamePropertyFile() {
		return "database.test.properties";
	}

	@Override
	public String getPathPropertyFile() {
		return "file:D:/";
	}

	/** {@inheritDoc} */
	@Override
	public String getHost() {
		if (System.getProperty("jenkins") != null) {
			// si estamos en jenkins usamos la m�quina URANIO para hacer
			// los test
			return "uranio";
		} else {
			return super.getHost();
		}
	}

	/** {@inheritDoc} */
	@Override
	public int getPort() {
		if (System.getProperty("jenkins") != null) {
			// si estamos en jenkins usamos la m�quina URANIO para hacer
			// los test
			return 27017;
		} else {
			return super.getPort();
		}
	}
}
