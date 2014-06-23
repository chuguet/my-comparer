/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.model.repository.dbinit;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmakerAuthorization;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.CfgNormalizerConversionTable;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgResource;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportActive;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.dbcore.dbinit.AbstractMongoDataInitializerPlugin;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerAuthorizationRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgMasterRepository;
import com.comparadorad.bet.comparer.model.repository.CfgNormalizerConversionTableRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgRegionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgRegionSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgResourceRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportActiveRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportSynonymsRepository;

/**
 * The Class ConfigRepositoryMongoDataInitializerPlugin.
 * 
 * @author jgpelaez
 */
@Component
public class ConfigRepositoryMongoDataInitializerPlugin extends
		AbstractMongoDataInitializerPlugin {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ConfigRepositoryMongoDataInitializerPlugin.class);

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/** The cfg bet type repository. */
	@Inject
	private CfgBetTypeEventRepository cfgBetEventTypeRepository;

	/** The cfg bet type synonyms repository. */
	@Inject
	private CfgBetTypeEventSynonymsRepository cfgBetTypeEventSynonymsRepository;

	/** The cfg bet type repository. */
	@Inject
	private CfgBetTypeRepository cfgBetTypeRepository;

	/** The cfg bookmaker authorization repository. */
	@Inject
	private CfgBookmakerAuthorizationRepository cfgBookmakerAuthorizationRepository;

	/** The bookmaker configuration repository. */
	@Inject
	private CfgBookmakerRepository cfgBookmakerRepository;

	/** The cfg competition event repository. */
	@Inject
	private CfgCompetitionEventRepository cfgCompetitionEventRepository;

	/** The cfg competition event synonyms. */
	@Inject
	private CfgCompetitionEventSynonymsRepository cfgCompetitionEventSynonymsRepository;

	/** The cfg competition repository. */
	@Inject
	private CfgCompetitionRepository cfgCompetitionRepository;

	/** The cfg competition synonyms repository. */
	@Inject
	private CfgCompetitionSynonymsRepository cfgCompetitionSynonymsRepository;

	/** The cfg master repository. */
	@Inject
	private CfgMasterRepository cfgMasterRepository;

	/** The cfg team repository. */
	@Inject
	private CfgParticipantRepository cfgParticipantRepository;

	/** The cfg team synonyms repository. */
	@Inject
	private CfgParticipantSynonymsRepository cfgParticipantSynonymsRepository;

	/** The cfg sport repository. */
	@Inject
	private CfgSportRepository cfgSportRepository;

	/** The cfg sport synonyms repository. */
	@Inject
	private CfgSportSynonymsRepository cfgSportSynonymsRepository;

	/** The master repository. */
	@Inject
	private CfgMasterRepository masterRepository;

	/** The normalizer conversion table repository. */
	@Inject
	private CfgNormalizerConversionTableRepository normalizerConversionTableRepository;

	/** The region repository. */
	@Inject
	private CfgRegionRepository regionRepository;

	/** The region synonyms repository. */
	@Inject
	private CfgRegionSynonymsRepository regionSynonymsRepository;

	/** The resource repository. */
	@Inject
	private CfgResourceRepository resourceRepository;

	/** The sport active repository. */
	@Inject
	private CfgSportActiveRepository sportActiveRepository;

	/**
	 * Gets the drop collection list.
	 * 
	 * @return the drop collection list {@inheritDoc}
	 */
	// @Override
	// public Iterable<Class<? extends IDocument>> getDropCollectionList() {
	// final List<Class<? extends IDocument>> classes = new ArrayList<Class<?
	// extends IDocument>>();
	// if (!ProfileUtil.containsProfile(ProfileConstant.PRODUCTION,
	// applicationContext.getEnvironment().getActiveProfiles())
	// && !ProfileUtil
	// .containsProfile(ProfileConstant.PREPRODUCTION,
	// applicationContext.getEnvironment()
	// .getActiveProfiles())) {
	// classes.add(CfgBetType.class);
	// classes.add(CfgBetTypeEvent.class);
	// classes.add(CfgBetTypeEventSynonyms.class);
	// classes.add(CfgBookmaker.class);
	// classes.add(CfgBookmakerAuthorization.class);
	// classes.add(CfgCompetition.class);
	// classes.add(CfgCompetitionSynonyms.class);
	// classes.add(CfgCompetitionEvent.class);
	// classes.add(CfgCompetitionEventSynonyms.class);
	// classes.add(CfgMaster.class);
	// classes.add(CfgSport.class);
	// classes.add(CfgSportSynonyms.class);
	// classes.add(CfgParticipant.class);
	// classes.add(CfgParticipantSynonyms.class);
	// classes.add(CfgToolbarElement.class);
	// classes.add(CfgResource.class);
	// classes.add(CfgMaster.class);
	// classes.add(CfgNormalizerConversionTable.class);
	// classes.add(CfgRegion.class);
	// classes.add(CfgRegionSynonyms.class);
	// classes.add(CfgSportActive.class);
	// }
	//
	// return classes;
	// }

	/**
	 * Initialize database.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void loadDbCollection() {
		LOG.info("Initialize database in: " + getClass().getSimpleName());
		saveToRepository(CfgBookmaker.class, cfgBookmakerRepository);
		saveToRepository(CfgBookmakerAuthorization.class,
				cfgBookmakerAuthorizationRepository);
		saveToRepository(CfgSport.class, cfgSportRepository);
		saveToRepository(CfgSportSynonyms.class, cfgSportSynonymsRepository);
		saveToRepository(CfgCompetition.class, cfgCompetitionRepository);
		saveToRepository(CfgMaster.class, cfgMasterRepository);
		saveToRepository(CfgParticipant.class, cfgParticipantRepository);
		saveToRepository(CfgBetType.class, cfgBetTypeRepository);
		saveToRepository(CfgBetTypeEvent.class, cfgBetEventTypeRepository);
		saveToRepository(CfgCompetitionSynonyms.class,
				cfgCompetitionSynonymsRepository);
		saveToRepository(CfgBetTypeEventSynonyms.class,
				cfgBetTypeEventSynonymsRepository);
		saveToRepository(CfgCompetitionEvent.class,
				cfgCompetitionEventRepository);
		saveToRepository(CfgCompetitionEventSynonyms.class,
				cfgCompetitionEventSynonymsRepository);
		saveToRepository(CfgParticipantSynonyms.class,
				cfgParticipantSynonymsRepository);
		saveToRepository(CfgResource.class, resourceRepository);
		saveToRepository(CfgMaster.class, masterRepository);
		saveToRepository(CfgNormalizerConversionTable.class,
				normalizerConversionTableRepository);
		saveToRepository(CfgRegion.class, regionRepository);
		saveToRepository(CfgRegionSynonyms.class, regionSynonymsRepository);
		saveToRepository(CfgSportActive.class, sportActiveRepository);

	}
}
