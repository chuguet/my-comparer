/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster.CfgMasterId;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.service.ICfgParticipantService;
import com.comparadorad.bet.comparer.model.config.service.ICfgParticipantSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ISynonymsService;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;

/**
 * The Class CfgParticipantCreator.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CfgParticipantCreator extends AbstractCfgCreator<CfgParticipant, CfgParticipantSynonyms> implements
		ICfgFromXmlCreator<XmlMatchParticipant, CfgParticipant, CfgParticipantSynonyms> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(CfgParticipantCreator.class);

	/** The sport service. */
	@Inject
	private ICfgParticipantService teamService;

	/** The sport synonyms service. */
	@Inject
	private ICfgParticipantSynonymsService teamSynonymsService;

	/**
	 * Creates the.
	 * 
	 * @param xmlMatchParticipant
	 *            the xml match participant
	 * @param dataBookmaker
	 *            the data bookmaker
	 * @param logEventBookmaker
	 *            the log event bookmaker
	 * @return the cfg creator data {@inheritDoc}
	 */
	@Override
	public CfgCreatorData<CfgParticipant, CfgParticipantSynonyms> create(XmlMatchParticipant xmlMatchParticipant,
			CfgBookmaker dataBookmaker, LogEventBookmakerMasterWords logEventBookmaker) {
		CfgCreatorData<CfgParticipant, CfgParticipantSynonyms> creatorData = new CfgCreatorData<CfgParticipant, CfgParticipantSynonyms>();
		creatorData.setLogEventBookmakerMasterWords(logEventBookmaker);
		CfgParticipantSynonyms synonymsDb = getSynonyms(xmlMatchParticipant, dataBookmaker);
		CfgCompetition competition = new CfgCompetition();
		CfgSport sport = new CfgSport();
		CfgRegion region = new CfgRegion(new BigInteger("1"));
		region.setName("Otros");
		sport.setName(xmlMatchParticipant.getXmlTournament().getXmlSport().getName());
		sport.setObjectId(xmlMatchParticipant.getXmlTournament().getXmlSport().getCfgObjectId());
		competition.setName(xmlMatchParticipant.getXmlTournament().getName());
		competition.setObjectId(xmlMatchParticipant.getXmlTournament().getCfgObjectId());
		competition.setSport(sport);
		competition.setRegion(region);
		competition.setParticipantNames(xmlMatchParticipant.getXmlTournament().getParticipantNames());
		if (synonymsDb != null) {
			LOG.debug("Hemos encontrado sinonimos con lo que solo damos de alta estos");
			synonymsDb.setCompetitionXmlName(xmlMatchParticipant.getXmlTournament().getName());
			synonymsDb.setSportXmlName(xmlMatchParticipant.getXmlTournament().getXmlSport().getName());
			creatorData.setSynonyms(synonymsDb);
			if (!StringUtils.isNotEmpty(synonymsDb.getRelatedDocument().getCfgName())) {
				LOG.debug("El padre no tenia cfgName por lo que se lo seteamos con el i18n");
				synonymsDb.getRelatedDocument().setCfgName(synonymsDb.getRelatedDocument().getI18n().getI18nField(null).getString());
			}
			creatorData.setModelData(synonymsDb.getRelatedDocument());
		} else {
			LOG.debug("No se ha encontrado ningun sinonimo con lo que damos de alta tanto el participante como su sinonimo asociado");
			CfgParticipant participant = new CfgParticipant();
			participant.setCompetitionXmlName(xmlMatchParticipant.getXmlTournament().getName());
			participant.setSportXmlName(xmlMatchParticipant.getXmlTournament().getXmlSport().getName());
			participant.setCompetition(competition);
			setNewObjectId(participant);
			creatorData.setModelData(participant);
			participant.setName(xmlMatchParticipant.getName().trim());
			participant.setCfgName(xmlMatchParticipant.getName().trim());

			CfgParticipantSynonyms teamSynonyms = new CfgParticipantSynonyms();
			teamSynonyms.setObjectId(getNewObjectDictionaryId(participant.getObjectId()));
			teamSynonyms.addSynonimWord(xmlMatchParticipant.getName().trim(), dataBookmaker);
			teamSynonyms.setRelatedDocument(participant);
			creatorData.setSynonyms(teamSynonyms);

		}

		return creatorData;
	}

	/**
	 * Gets the cfg master id.
	 * 
	 * @return the cfg master id {@inheritDoc}
	 */
	@Override
	protected CfgMasterId getCfgMasterId() {
		return CfgMasterId.PARTICIPANT;
	}

	/**
	 * Gets the crud service.
	 * 
	 * @return the crud service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgParticipant> getCrudService() {
		return teamService;
	}

	/**
	 * Gets the synonyms crud service.
	 * 
	 * @return the synonyms crud service {@inheritDoc}
	 */
	@Override
	protected ISynonymsService<CfgParticipantSynonyms> getSynonymsCrudService() {
		return teamSynonymsService;
	}
}
