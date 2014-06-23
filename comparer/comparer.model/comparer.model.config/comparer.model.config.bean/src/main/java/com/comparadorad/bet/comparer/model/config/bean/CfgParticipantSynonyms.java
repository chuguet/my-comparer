/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
public class CfgParticipantSynonyms extends
		AbstractCfgSynonyms<CfgParticipantSynonymWord, CfgParticipant> {

	/** The competition xml name. */
	@Field
	private String competitionXmlName;

	/** The participant. */
	@DBRef
	@NotNull
	@Valid
	private CfgParticipant participant;

	/** The sport xml name. */
	@Field
	private String sportXmlName;

	/**
	 * Instantiates a new cfg participant synonyms.
	 */
	public CfgParticipantSynonyms() {
		super();

	}

	/**
	 * Count.
	 * 
	 * @param pSynonymWord
	 *            the synonym word
	 * @return the integer
	 */
	public Integer count(AbstractCfgSynonymWord pSynonymWord) {
		Integer result = 0;
		for (AbstractCfgSynonymWord synonymWord : this.getSynonimWords()) {
			if (synonymWord.equals(pSynonymWord)) {
				result++;
			}
		}
		return result;
	}

	/**
	 * Instantiates a new cfg participant synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgParticipantSynonyms(BigInteger pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg participant synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgParticipantSynonyms(IObjectIdEnum pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg participant synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgParticipantSynonyms(String pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg participant synonyms.
	 * 
	 * @param pCfgParticipantSynonyms
	 *            the cfg participant synonyms
	 */
	public CfgParticipantSynonyms(CfgParticipantSynonyms pCfgParticipantSynonyms) {
		super(pCfgParticipantSynonyms.getObjectId());
		this.setCompetitionXmlName(pCfgParticipantSynonyms
				.getCompetitionXmlName());
		this.setCoreActiveElement(pCfgParticipantSynonyms
				.getCoreActiveElement());
		this.setHistoric(pCfgParticipantSynonyms.getHistoric());
		this.setNameId(pCfgParticipantSynonyms.getNameId());
		this.setParticipant(pCfgParticipantSynonyms.getParticipant());
		this.setSportXmlName(pCfgParticipantSynonyms.getSportXmlName());
		this.setSynonimWords(pCfgParticipantSynonyms.getSynonimWords());
	}

	/**
	 * Gets the competition xml name.
	 * 
	 * @return the competition xml name
	 */
	public String getCompetitionXmlName() {
		return competitionXmlName;
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

	/**
	 * Gets the participant.
	 * 
	 * @return the participant
	 */
	public CfgParticipant getParticipant() {
		return participant;
	}

	/**
	 * Gets the related document.
	 * 
	 * @return the related document {@inheritDoc}
	 */
	@Override
	public CfgParticipant getRelatedDocument() {
		return getParticipant();
	}

	/**
	 * Gets the sport xml name.
	 * 
	 * @return the sport xml name
	 */
	public String getSportXmlName() {
		return sportXmlName;
	}

	/**
	 * New abstract cfg synonim word.
	 * 
	 * @return the cfg participant synonym word {@inheritDoc}
	 */
	@Override
	public CfgParticipantSynonymWord newAbstractCfgSynonimWord() {
		return new CfgParticipantSynonymWord();
	}

	/**
	 * Sets the competition xml name.
	 * 
	 * @param competitionXmlName
	 *            the new competition xml name
	 */
	public void setCompetitionXmlName(String competitionXmlName) {
		this.competitionXmlName = competitionXmlName;
	}

	/**
	 * Sets the participant.
	 * 
	 * @param pTeam
	 *            the new participant
	 */
	public void setParticipant(CfgParticipant pTeam) {
		participant = pTeam;
	}

	/**
	 * Sets the related document.
	 * 
	 * @param pRelatedDocument
	 *            the new related document {@inheritDoc}
	 */
	@Override
	public void setRelatedDocument(CfgParticipant pRelatedDocument) {
		setParticipant(pRelatedDocument);
	}

	/**
	 * Sets the sport xml name.
	 * 
	 * @param sportXmlName
	 *            the new sport xml name
	 */
	public void setSportXmlName(String sportXmlName) {
		this.sportXmlName = sportXmlName;
	}

	/**
	 * Removes the synonym word.
	 * 
	 * @param pSynonymWord
	 *            the synonym word
	 */
	public void removeSynonymWord(AbstractCfgSynonymWord pSynonymWord) {
		List<AbstractCfgSynonymWord> result = new ArrayList<AbstractCfgSynonymWord>();
		for (AbstractCfgSynonymWord synonymWord : this.getSynonimWords()) {
			if (!synonymWord.equals(pSynonymWord)) {
				result.add(synonymWord);
			}
		}
		this.setSynonimWords(result);
	}
}