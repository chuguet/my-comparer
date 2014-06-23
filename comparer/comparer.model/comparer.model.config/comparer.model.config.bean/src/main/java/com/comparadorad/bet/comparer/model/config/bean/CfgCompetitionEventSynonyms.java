/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class CfgCompetitionEventSynonyms.
 */
@SuppressWarnings("serial")
@Document
public class CfgCompetitionEventSynonyms
		extends
		AbstractCfgSynonyms<CfgCompetitionEventSynonymWord, CfgCompetitionEvent> {

	/** The competition event. */
	@DBRef
	private CfgCompetitionEvent competitionEvent;

	/**
	 * Gets the competition event.
	 * 
	 * @return the competition event
	 */
	public CfgCompetitionEvent getCompetitionEvent() {
		return competitionEvent;
	}

	/** {@inheritDoc} */
	@Override
	public CfgCompetitionEvent getRelatedDocument() {
		return getCompetitionEvent();
	}

	/**
	 * New abstract cfg synonim word.
	 * 
	 * @return the abstract cfg synonym word {@inheritDoc}
	 */
	@Override
	public AbstractCfgSynonymWord newAbstractCfgSynonimWord() {
		return new CfgCompetitionEventSynonymWord();
	}

	/**
	 * Sets the competition event.
	 * 
	 * @param pCompetitionEvent
	 *            the new competition event
	 */
	public void setCompetitionEvent(CfgCompetitionEvent pCompetitionEvent) {
		competitionEvent = pCompetitionEvent;
	}

	/** {@inheritDoc} */
	@Override
	public void setRelatedDocument(CfgCompetitionEvent pRelatedDocument) {
		setCompetitionEvent(pRelatedDocument);
	}
	@Override
	public String getParent() {
		return this.getObjectId().toString();
	}

}
