/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.comparadorad.bet.comparer.model.core.bean.IObjectIdEnum;

/**
 * The Class SynonymsWord.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
@Document
public class CfgRegionSynonyms extends
		AbstractCfgSynonyms<CfgRegionSynonymWord, CfgRegion> {

	/** The competition. */
	@DBRef
	@NotNull
	@Valid
	private CfgRegion region;

	/**
	 * Instantiates a new cfg competition synonyms.
	 */
	public CfgRegionSynonyms() {
		super();
	}

	/**
	 * Instantiates a new cfg competition synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgRegionSynonyms(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg competition synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgRegionSynonyms(IObjectIdEnum pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg competition synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgRegionSynonyms(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * Gets the competition.
	 * 
	 * @return the competition
	 */
	public CfgRegion getRegion() {
		return region;
	}

	/**
	 * Gets the related document.
	 * 
	 * @return the related document {@inheritDoc}
	 */
	@Override
	public CfgRegion getRelatedDocument() {
		return getRegion();
	}

	/**
	 * New abstract cfg synonim word.
	 * 
	 * @return the cfg competition synonym word {@inheritDoc}
	 */
	@Override
	public CfgRegionSynonymWord newAbstractCfgSynonimWord() {
		return new CfgRegionSynonymWord();
	}

	/**
	 * Sets the competition.
	 * 
	 * @param pCompetition
	 *            the new competition
	 */
	public void setRegion(CfgRegion pRegion) {
		region = pRegion;
	}

	/**
	 * Sets the related document.
	 * 
	 * @param pRelatedDocument
	 *            the new related document {@inheritDoc}
	 */
	@Override
	public void setRelatedDocument(CfgRegion pRelatedDocument) {
		setRegion(pRelatedDocument);
	}

	
	@Override
	public String getParent() {
		return this.getObjectId().toString();
	}
}