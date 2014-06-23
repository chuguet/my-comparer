/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Class SynonymsWord.
 * 
 * @author imayoral
 * @version 1.0
 */
@Document
public class CfgSportSynonyms extends
		AbstractCfgSynonyms<CfgSportSynonymWord, CfgSport> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The sport. */
	@DBRef
	@NotNull
	@Valid
	private CfgSport sport;

	/** {@inheritDoc} */
	@Override
	public CfgSport getRelatedDocument() {
		return getSport();
	}

	/**
	 * Gets the sport.
	 * 
	 * @return the sport
	 */
	public CfgSport getSport() {
		return sport;
	}

	/**
	 * New abstract cfg synonim word.
	 * 
	 * @return the cfg sport synonym word {@inheritDoc}
	 */
	@Override
	public CfgSportSynonymWord newAbstractCfgSynonimWord() {
		return new CfgSportSynonymWord();
	}

	/** {@inheritDoc} */
	@Override
	public void setRelatedDocument(CfgSport pRelatedDocument) {
		setSport(pRelatedDocument);
	}

	/**
	 * Sets the sport.
	 * 
	 * @param pSport
	 *            the new sport
	 */
	public void setSport(CfgSport pSport) {
		sport = pSport;
	}

	/**
	 * To string.
	 * 
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("historic", this.getHistoric())
				.append("objectId", this.getObjectId())
				.append("nameId", this.getNameId())
				.append("updated", this.isUpdated())
				.append("sport", this.sport)
				.append("synonimWords", this.getSynonimWords()).toString();
	}
	
	@Override
	public String getParent() {
		return this.getObjectId().toString();
	}

}