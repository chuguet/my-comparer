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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgCompetitionWriter.
 */
public class CfgParticipantSynonymsWriter extends
		AbstractWriterXML<List<CfgParticipantSynonyms>> {
	/**
	 * Gets the competition1.
	 * 
	 * @return the competition1
	 */
	private CfgCompetition getCompetition1() {
		CfgCompetition cfgCompetition = new CfgCompetition();
		CfgSport cfgSport = new CfgSport();
		cfgSport.setObjectId("1");
		cfgSport.setName("Futbol");
		cfgCompetition.setObjectId("1");
		cfgCompetition.setName("Liga Española");
		cfgCompetition.setSport(cfgSport);
		cfgCompetition.setHistoricCreationData("testUser");
		return cfgCompetition;
	}

	/** {@inheritDoc} */
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
	protected List<CfgParticipantSynonyms> makeObject() {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();
		CfgParticipantSynonyms synonyms = new CfgParticipantSynonyms();

		CfgParticipant team = new CfgParticipant();
		team.setObjectId("1");
		team.setName("F.C. Barcelona");
		team.setCompetition(getCompetition1());
		synonyms.setObjectId("1");
		synonyms.setRelatedDocument(team);
		synonyms.addSynonimWord("F.C. Barcelona");
		synonyms.addSynonimWord("FC Barcelona");
		synonyms.addSynonimWord("BarÃ§a");
		synonyms.addSynonimWord("Barcelona");
		result.add(synonyms);
		return result;
	}

}
