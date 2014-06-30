/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.copy.mongodb;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.WriteResultChecking;

import com.comparadorad.bet.comparer.model.config.service.config.ConfigServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class BetRepositoryConfig.
 * 
 */
@Configuration
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
@Import({ ConfigServiceConfig.class, SpringSynchroLogConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.util.participants.copy" })
public class CopyParticipantsConfig {

	/** The mongo template. */
	@Inject
	private MongoTemplate mongoTemplate;

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
	}

}