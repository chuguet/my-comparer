/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.log.service.config.LogServiceConfig;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;
import com.comparadorad.bet.comparer.synchro.reader.model.config.ReaderXmlModelConfigTest;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.config.ConvertReaderBookmakerConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SynchroReaderReaderbookmakerConfigTest.
 */
@Configuration
@Import(value = { LogServiceConfig.class, ConvertReaderBookmakerConfig.class,
		ReaderXmlModelConfigTest.class, SpringSynchroLogConfig.class })
@Profile(value = { ProfileConstant.TEST })
public class SynchroReaderReaderbookmakerConfigTest extends
		AbstractSynchroReaderReaderbookmakerConfig {

}
