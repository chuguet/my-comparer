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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgCompetitionEventSynonymsWriter.
 */
public class CfgCompetitionEventSynonymsWriter extends
AbstractWriterXML<List<CfgCompetitionEventSynonyms>> {

	/** {@inheritDoc} */ 
	@Override
	protected boolean isExtended() {
		return false;
	}

	/** {@inheritDoc} */ 
	@Override
	protected List<CfgCompetitionEventSynonyms> makeObject() {
		
		List<CfgCompetitionEventSynonyms> result = new ArrayList<CfgCompetitionEventSynonyms>();
		CfgCompetitionEventSynonyms competitionEventSynonyms;
		
		competitionEventSynonyms = new CfgCompetitionEventSynonyms();
		competitionEventSynonyms.addSynonimWord("Real Madrid - Barcelona : Cuartos de final");
		result.add(competitionEventSynonyms);
		
		competitionEventSynonyms = new CfgCompetitionEventSynonyms();
		competitionEventSynonyms.addSynonimWord("Valencia - Osasuna : Semifinal");
		result.add(competitionEventSynonyms);
		
		competitionEventSynonyms = new CfgCompetitionEventSynonyms();
		competitionEventSynonyms.addSynonimWord("At. Madrid - Sevilla : Final");
		result.add(competitionEventSynonyms);
		
		
		return result;
	}

}
