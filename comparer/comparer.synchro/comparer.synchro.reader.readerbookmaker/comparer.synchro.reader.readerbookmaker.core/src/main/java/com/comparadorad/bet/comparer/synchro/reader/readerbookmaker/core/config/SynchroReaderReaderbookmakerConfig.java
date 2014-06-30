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

import com.comparadorad.bet.comparer.model.bet.config.BetBeanConfig;
import com.comparadorad.bet.comparer.model.log.service.config.LogServiceConfig;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;
import com.comparadorad.bet.comparer.synchro.reader.model.config.ReaderXmlModelConfig;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.config.ConvertReaderBookmakerConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;

/**
 * The Class SynchroReaderReaderConfig.
 */
@Configuration
@Import(value = { LogServiceConfig.class, ConvertReaderBookmakerConfig.class,
		ReaderXmlModelConfig.class, StringUtil.class, SpringSynchroLogConfig.class, BetBeanConfig.class })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class SynchroReaderReaderbookmakerConfig extends
		AbstractSynchroReaderReaderbookmakerConfig {

}
