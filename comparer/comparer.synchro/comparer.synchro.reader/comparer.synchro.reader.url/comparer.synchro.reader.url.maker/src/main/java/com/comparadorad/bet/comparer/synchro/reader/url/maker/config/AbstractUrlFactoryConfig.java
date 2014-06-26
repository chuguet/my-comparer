/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class AbstractUrlFactoryConfig.
 */
@Configuration
@Import(value = { SpringSynchroLogConfig.class })
@ComponentScan(basePackages = "com.comparadorad.bet.comparer.synchro.reader.url.maker", excludeFilters = { @ComponentScan.Filter(Configuration.class)})
@PropertySource({ "classpath:/config-urlmaker.properties" })
public abstract class AbstractUrlFactoryConfig {

}
