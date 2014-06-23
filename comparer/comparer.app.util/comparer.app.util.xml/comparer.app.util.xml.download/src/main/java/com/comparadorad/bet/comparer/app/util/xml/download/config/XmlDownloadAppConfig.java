/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.app.util.xml.download.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.config.SynchroReaderDatasourceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class XmlDownloadAppConfig.
 */
@Configuration
@ComponentScan("com.comparadorad.bet.comparer.app.util.xml.download.app.task")
@Import({ ConfigRepositoryConfig.class, SynchroReaderDatasourceConfig.class })
@Profile(ProfileConstant.DEV)
public class XmlDownloadAppConfig {

	/**
	 * The Class XmlDownloadAppConfigDev.
	 */
	@Configuration
	@ImportResource("classpath*:/application-context-download-app.xml")
	@Import(ConfigRepositoryConfig.class)
	@Profile(ProfileConstant.DEV)
	public static class XmlDownloadAppConfigDev {

	}

}
