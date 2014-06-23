/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.IObjectIdEnum;

/**
 * The Class SynonymsWord.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
@Document
public class CfgCompetitionSynonyms extends
		AbstractCfgSynonyms<CfgCompetitionSynonymWord, CfgCompetition> {

	/** The competition. */
	@DBRef
	@NotNull
	@Valid
	private CfgCompetition competition;

	/** The participant names. */
	@Field
	private Set<String> participantNames;

	/**
	 * Gets the participant names.
	 * 
	 * @return the participant names
	 */
	public Set<String> getParticipantNames() {
		return participantNames;
	}

	/**
	 * Sets the participant names.
	 * 
	 * @param participantNames
	 *            the new participant names
	 */
	public void setParticipantNames(Set<String> participantNames) {
		this.participantNames = participantNames;
	}

	/**
	 * Instantiates a new cfg competition synonyms.
	 */
	public CfgCompetitionSynonyms() {
		super();
	}

	/**
	 * Instantiates a new cfg competition synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgCompetitionSynonyms(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg competition synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgCompetitionSynonyms(IObjectIdEnum pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg competition synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgCompetitionSynonyms(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * Gets the competition.
	 * 
	 * @return the competition
	 */
	public CfgCompetition getCompetition() {
		return competition;
	}

	/**
	 * Gets the related document.
	 * 
	 * @return the related document {@inheritDoc}
	 */
	@Override
	public CfgCompetition getRelatedDocument() {
		return getCompetition();
	}

	/**
	 * New abstract cfg synonim word.
	 * 
	 * @return the cfg competition synonym word {@inheritDoc}
	 */
	@Override
	public CfgCompetitionSynonymWord newAbstractCfgSynonimWord() {
		return new CfgCompetitionSynonymWord();
	}

	/**
	 * Sets the competition.
	 * 
	 * @param pCompetition
	 *            the new competition
	 */
	public void setCompetition(CfgCompetition pCompetition) {
		competition = pCompetition;
	}

	/**
	 * Sets the related document.
	 * 
	 * @param pRelatedDocument
	 *            the new related document {@inheritDoc}
	 */
	@Override
	public void setRelatedDocument(CfgCompetition pRelatedDocument) {
		setCompetition(pRelatedDocument);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms#getParent()
	 */
	@Override
	public String getParent() {
		return this.getObjectId().toString();
	}

}