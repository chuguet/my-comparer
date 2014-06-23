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
 * The Class CfgBetTypeEventSynonyms.
 */
@SuppressWarnings("serial")
@Document
public class CfgBetTypeEventSynonyms extends
		AbstractCfgSynonyms<CfgBetTypeEventSynonymWord, CfgBetTypeEvent> {

	/** The bet type. */
	@DBRef
	private CfgBetTypeEvent betTypeEvent;

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public CfgBetTypeEvent getBetTypeEvent() {
		return betTypeEvent;
	}

	/**
	 * Gets the related document.
	 * 
	 * @return the related document {@inheritDoc}
	 */
	@Override
	public CfgBetTypeEvent getRelatedDocument() {
		return getBetTypeEvent();
	}

	/**
	 * New abstract cfg synonim word.
	 * 
	 * @return the cfg bet type event synonym word {@inheritDoc}
	 */
	@Override
	public CfgBetTypeEventSynonymWord newAbstractCfgSynonimWord() {
		return new CfgBetTypeEventSynonymWord();
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param pBetType
	 *            the new bet type
	 */
	public void setBetTypeEvent(CfgBetTypeEvent pBetType) {
		betTypeEvent = pBetType;
	}

	/** {@inheritDoc} */
	@Override
	public void setRelatedDocument(CfgBetTypeEvent pRelatedDocument) {
		setBetTypeEvent(pRelatedDocument);
	}
	
	@Override
	public String getParent() {
		return this.getObjectId().toString();
	}

}