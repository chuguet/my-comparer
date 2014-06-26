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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgCompetitionEventWriter.
 */
public class CfgCompetitionEventWriter extends
		AbstractWriterXML<List<CfgCompetitionEvent>> {
	
	/** {@inheritDoc} */
	@Override
	protected boolean isExtended() {
		return false;
	}
	
	/**
	 * Make object.
	 *
	 * @return the list
	 * {@inheritDoc}
	 */
	@Override
	protected List<CfgCompetitionEvent> makeObject() {

		List<CfgCompetitionEvent> result = new ArrayList<CfgCompetitionEvent>();
		CfgCompetitionEvent cfgCompetitionEvent;
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		
		//Evento Cuartos de final
		cfgCompetitionEvent = new CfgCompetitionEvent();
		cfgCompetitionEvent.setObjectId("1");
		cfgCompetitionEvent.setName("Competicion Corto Plazo");
		cfgCompetitionEvent.setLongTerm(longTerm);
		result.add(cfgCompetitionEvent);
		
		//Evento marcado como de Largo Tiempo
		cfgCompetitionEvent = new CfgCompetitionEvent();
		
		longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);
		cfgCompetitionEvent.setObjectId("2");
		cfgCompetitionEvent.setName("Competicion Largo Plazo");
		cfgCompetitionEvent.setLongTerm(longTerm);
		result.add(cfgCompetitionEvent);
		
		
		
		return result;
	}
}
