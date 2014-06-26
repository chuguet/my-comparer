/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;

/**
 * The Class CfgParticipantWriter.
 */
public class CfgParticipantWriter extends
		AbstractSynonymsWriterXML<List<CfgParticipant>, CfgParticipantSynonyms> {

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<CfgParticipant> makeObject() {
		List<CfgParticipant> result = new ArrayList<CfgParticipant>();
		addParticipant("3", "30000", "222333", "R. Federer", result, Boolean.TRUE);
		return result;
	}

	/**
	 * Adds the participant.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param competitionId
	 *            the competition id
	 * @param participantId
	 *            the participant id
	 * @param participiantName
	 *            the participiant name
	 * @param result
	 *            the result
	 */
	public void addParticipant(String sportId, String competitionId,
			String participantId, String participiantName,
			List<CfgParticipant> result, Boolean active) {
		CfgParticipant cfgParticipant = new CfgParticipant(participantId);
		CoreActiveElement coreActiveElement = new CoreActiveElement(active);
		cfgParticipant.setName(participiantName);
		CfgCompetition cfgCompetition = new CfgCompetition(competitionId);
		CfgSport cfgSport = new CfgSport(sportId);
		cfgParticipant.setSport(cfgSport);
		cfgParticipant.setCompetition(cfgCompetition);
		cfgParticipant.setCoreActiveElement(coreActiveElement);
		
		addParticipant(cfgParticipant, result, coreActiveElement);
	}

	/**
	 * Adds the participant.
	 * 
	 * @param pCfgParticipant
	 *            the cfg participant
	 * @param result
	 *            the result
	 */
	public void addParticipant(CfgParticipant pCfgParticipant,
			List<CfgParticipant> result, CoreActiveElement active) {
		CfgParticipantSynonyms synonyms = new CfgParticipantSynonyms(
				pCfgParticipant.getObjectId());
		synonyms.setParticipant(new CfgParticipant(pCfgParticipant.getObjectId()));
		synonyms.addSynonimWord(pCfgParticipant.getName(Locale.ENGLISH),
				getWriterAppUser());
		synonyms.setCoreActiveElement(active);
		getSynonymsList().add(synonyms);
		result.add(pCfgParticipant);
	}

}
