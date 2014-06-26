package com.comparadorad.bet.comparer.model.dbcore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@PropertySource("classpath:/database.preprod.properties")
@Profile(value = { ProfileConstant.PREPRODUCTION })
public class SpringMongoPreProdConfig extends AbstractSpringMongoConfig {
	
	@Override
	public String getNamePropertyFile() {
		return "database.preprod.properties";
	}

	@Override
	public String getPathPropertyFile() {
		return "file:D:/";
	}

}
