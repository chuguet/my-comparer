/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.comparadorad.bet.comparer.synchro.valuebet.historic.config.SynchroValueBetHistoricConfig;
import com.comparadorad.bet.comparer.synchro.valuebet.process.config.SynchroValueBetProcessConfig;
import com.comparadorad.bet.comparer.synchro.valuebet.reader.config.SynchroValueBetReaderConfig;
import com.comparadorad.bet.comparer.synchro.valuebet.writer.config.SynchroValueBetWriterConfig;
import com.comparadorad.bet.comparer.util.batch.config.AbstractBatchAppConfig;

/**
 * The Class AbstractSynchroValueBetBatchAppConfig.
 */
@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.valuebet.app" })
@ImportResource({ "classpath*:/SynchroValueBetAppConfig.xml",
		"classpath*:/SynchroValueBetAppConfig-job-repository.xml",
		"classpath*:/SynchroValueBetAppConfig-repository-data-test.xml" })
@Import({ SynchroValueBetWriterConfig.class, SynchroValueBetReaderConfig.class,
		SynchroValueBetProcessConfig.class, SynchroValueBetHistoricConfig.class })
public abstract class AbstractSynchroValueBetBatchAppConfig extends
		AbstractBatchAppConfig {

}
