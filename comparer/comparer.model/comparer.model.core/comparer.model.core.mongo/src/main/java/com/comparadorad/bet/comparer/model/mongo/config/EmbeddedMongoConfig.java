/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.mongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.model.mongo.EmbeddedMongo;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class EmbededMongoConfig.
 */
@Configuration
@Profile(value = { ProfileConstant.TEST })
@ComponentScan("com.comparadorad.bet.comparer.model.mongo.prop")
@PropertySource("classpath:/embeddedmongo.test.jenkins.properties")
public class EmbeddedMongoConfig {

	/** The proxy host. */
	@Value("${db.embedded.active}")
	private boolean active = true;

	/** The mongo config port. */
	private MongoConfigPort mongoConfigPort;

	/** The mongo port. */
	private @Value("${db.embedded.mongoPort}")
	Integer mongoPort;

	/** The proxy host. */
	@Value("${db.embedded.proxyHost}")
	private String proxyHost;

	/** The proxy password. */
	@Value("${db.embedded.proxyPassword}")
	private String proxyPassword;

	/** The proxy port. */
	@Value("${db.embedded.proxyPort}")
	private int proxyPort;

	/** The proxy user. */
	@Value("${db.embedded.proxyUser}")
	private String proxyUser;

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * Embedded mongo.
	 * 
	 * @return the embedded mongo
	 */
	@Bean(initMethod = "start", destroyMethod = "stop")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EmbeddedMongo embeddedMongo() {
		if (this.isActive()) {
			return new EmbeddedMongo(this);
		}
		return null;
	}

	/**
	 * Gets the mongo port.
	 * 
	 * @return the mongo port
	 */
	public int getMongoPort() {
		if (mongoPort == null) {
			mongoPort = mongoConfigPort().getPort();
		}
		return mongoPort;
	}

	/**
	 * Gets the proxy host.
	 * 
	 * @return the proxy host
	 */
	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * Gets the proxy password.
	 * 
	 * @return the proxy password
	 */
	public String getProxyPassword() {
		return proxyPassword;
	}

	/**
	 * Gets the proxy port.
	 * 
	 * @return the proxy port
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * Gets the proxy user.
	 * 
	 * @return the proxy user
	 */
	public String getProxyUser() {
		return proxyUser;
	}

	/**
	 * Checks if is active.
	 * 
	 * @return true, if is active
	 */
	public boolean isActive() {
		if (System.getProperty("jenkins") != null) {
			return true;
		}
		return active;
	}

	/**
	 * Mongo config port.
	 * 
	 * @return the mongo config port
	 */
	@Bean
	public MongoConfigPort mongoConfigPort() {
		this.mongoConfigPort = new MongoConfigPort();
		return mongoConfigPort;
	}

	/**
	 * Sets the mongo port.
	 * 
	 * @param pMongoPort
	 *            the new mongo port
	 */
	public void setMongoPort(final int pMongoPort) {
		mongoPort = pMongoPort;
	}

	/**
	 * Sets the proxy host.
	 * 
	 * @param pProxyHost
	 *            the new proxy host
	 */
	public void setProxyHost(final String pProxyHost) {
		proxyHost = pProxyHost;
	}

	/**
	 * Sets the proxy password.
	 * 
	 * @param pProxyPassword
	 *            the new proxy password
	 */
	public void setProxyPassword(final String pProxyPassword) {
		proxyPassword = pProxyPassword;
	}

	/**
	 * Sets the proxy port.
	 * 
	 * @param pProxyPort
	 *            the new proxy port
	 */
	public void setProxyPort(final int pProxyPort) {
		proxyPort = pProxyPort;
	}

	/**
	 * Sets the proxy user.
	 * 
	 * @param pProxyUser
	 *            the new proxy user
	 */
	public void setProxyUser(final String pProxyUser) {
		proxyUser = pProxyUser;
	}

}
