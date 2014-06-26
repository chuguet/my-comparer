/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.test;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.integration.consumer.config.IntegrationConsumerConfiguration;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfig;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventRepository;
import com.comparadorad.bet.comparer.synchro.betclean.config.BetCleanTaskConfiguration;
import com.comparadorad.bet.comparer.synchro.betclean.config.BetCleanTaskConfigurationTest;
import com.comparadorad.bet.comparer.synchro.betclean.util.IModifyBets;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo;
import com.comparadorad.bet.comparer.util.test.mongo.config.TestMongoConfigTest;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationConsumerConfiguration.class,
		BetCleanTaskConfigurationTest.class, TestMongoConfigTest.class,
		BetRepositoryConfig.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractTest extends AbstractTestMongo {
	
	
	/** The rt match repository. */
	@Inject
	private RtMatchRepository rtMatchRepository;

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	/** The bet type repository. */
	@Inject
	private CfgBetTypeRepository betTypeRepository;

	/** The bet type event repository. */
	@Inject
	private CfgBetTypeEventRepository betTypeEventRepository;
	
	@Inject
	private CfgCompetitionEventRepository cfgCompetitionEventRepository;

	/**
	 * Gets the repository.
	 * 
	 * @return the repository {@inheritDoc}
	 */
	@Override
	protected HashMap<Class<? extends IDocument>, CrudRepository> getRepository() {
		HashMap<Class<? extends IDocument>, CrudRepository> result = new HashMap<Class<? extends IDocument>, CrudRepository>();
		result.put(RtMatch.class, rtMatchRepository);
		result.put(CfgBookmaker.class, bookmakerRepository);
		result.put(CfgBetType.class, betTypeRepository);
		result.put(CfgBetTypeEvent.class, betTypeEventRepository);
		result.put(CfgCompetitionEvent.class, cfgCompetitionEventRepository);
		return result;
	}
	

	/**
	 * Gets the loader class.
	 * 
	 * @return the loader class {@inheritDoc}
	 */
	@Override
	protected Class<?> getLoaderClass() {
		return BetCleanTaskConfiguration.class;
	}

	public RtMatchRepository getRtMatchRepository() {
		return rtMatchRepository;
	}
	
	

}
