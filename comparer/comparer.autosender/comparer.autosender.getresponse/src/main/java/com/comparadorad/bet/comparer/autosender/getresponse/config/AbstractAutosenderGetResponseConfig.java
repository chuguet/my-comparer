/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.comparadorad.bet.comparer.autosender.core.config.AutosenderCoreConfig;

/**
 * The Class AbstractAutosenderGetResponseConfig.
 */
@Configuration
@PropertySource(value = { "classpath:/getresponse.properties",
		"classpath:/proxy.properties", "classpath:/message.properties" })
@Import({ AutosenderCoreConfig.class })
public abstract class AbstractAutosenderGetResponseConfig {

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
	 * Gets the local validator factory bean config.
	 * 
	 * @return the local validator factory bean config
	 */
	@Bean(name = "ValidatorGetResponse")
	public LocalValidatorFactoryBean getLocalValidatorFactoryBeanConfig() {
		return new LocalValidatorFactoryBean();
	}

	/** The key. */
	@Value("${getresponse.key}")
	private String key;

	/** The base uri. */
	@Value("${getresponse.base.uri}")
	private String baseUri;

	/** The proxy active. */
	@Value("${proxy.active}")
	private boolean proxyActive;

	/** The host. */
	@Value("${proxy.host}")
	private String host;

	/** The port. */
	@Value("${proxy.port}")
	private Integer port;

	/** The user. */
	@Value("${proxy.user}")
	private String user;

	/** The password. */
	@Value("${proxy.password}")
	private String password;

	/** The message char set. */
	@Value("${content.charset}")
	private String messageCharSet;

	/**
	 * Gets the message char set.
	 * 
	 * @return the message char set
	 */
	public String getMessageCharSet() {
		return messageCharSet;
	}

	/**
	 * Sets the message char set.
	 * 
	 * @param messageCharSet
	 *            the new message char set
	 */
	public void setMessageCharSet(String messageCharSet) {
		this.messageCharSet = messageCharSet;
	}

	/**
	 * Gets the message content type.
	 * 
	 * @return the message content type
	 */
	public String getMessageContentType() {
		return messageContentType;
	}

	/**
	 * Sets the message content type.
	 * 
	 * @param messageContentType
	 *            the new message content type
	 */
	public void setMessageContentType(String messageContentType) {
		this.messageContentType = messageContentType;
	}

	/** The message content type. */
	@Value("${content.contentType}")
	private String messageContentType;

	/**
	 * Gets the base uri.
	 * 
	 * @return the base uri
	 */
	public String getBaseUri() {
		return baseUri;
	}

	/**
	 * Checks if is proxy active.
	 * 
	 * @return true, if is proxy active
	 */
	public boolean isProxyActive() {
		return proxyActive;
	}

	/**
	 * Sets the proxy active.
	 * 
	 * @param proxyActive
	 *            the new proxy active
	 */
	public void setProxyActive(boolean proxyActive) {
		this.proxyActive = proxyActive;
	}

	/**
	 * Gets the host.
	 * 
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Sets the host.
	 * 
	 * @param host
	 *            the new host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Gets the port.
	 * 
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 * 
	 * @param port
	 *            the new port
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the base uri.
	 * 
	 * @param baseUri
	 *            the new base uri
	 */
	public void setBaseUri(String baseUri) {
		this.baseUri = baseUri;
	}

	/**
	 * Gets the key.
	 * 
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 * 
	 * @param key
	 *            the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
