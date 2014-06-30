/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.server.dummy.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.comparadorad.bet.comparer.synchro.server.dummy.XmlBetDummyServer;
import com.comparadorad.bet.comparer.synchro.server.dummy.XmlBetDummyServerParams;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SynchroReaderDatasourceConfig.
 */
@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.server.dummy" })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV })
public class SynchroReaderServerDummyConfig {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(SynchroReaderServerDummyConfig.class);

	/**
	 * Xml bet dummy server.
	 * 
	 * @return the xml bet dummy server
	 */
	@Bean(initMethod = "initServer", destroyMethod = "stopServer")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public XmlBetDummyServer xmlBetDummyServer() {
		return new XmlBetDummyServer();
	}

	/**
	 * Xml bet dummy server params.
	 * 
	 * @return the xml bet dummy server params
	 */
	@Bean
	public XmlBetDummyServerParams xmlBetDummyServerParams() {
		XmlBetDummyServerParams xmlBetDummyServerParams = new XmlBetDummyServerParams();
		try {
			Properties prop = new Properties();
			prop.load(getClass().getResourceAsStream(
					SynchroReaderServerDummyConfig.class.getSimpleName()
							+ ".properties"));
			xmlBetDummyServerParams.setProperties(prop);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
		return xmlBetDummyServerParams;
	}
}