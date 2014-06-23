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
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord.CfgSynonymWordHistoricData;
import com.comparadorad.bet.comparer.model.core.bean.AbstractHistoricChangeActivable;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.bean.IObjectIdEnum;

/**
 * The Class AbstractCfgSynonyms.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
@SuppressWarnings("serial")
public abstract class AbstractCfgSynonyms<T extends AbstractCfgSynonymWord, I extends IDocument>
		extends AbstractHistoricChangeActivable implements ICfgSynonyms {

	/** The synonim words. */
	@Field
	@NotNull
	@Valid
	private List<AbstractCfgSynonymWord> synonimWords;

	/**
	 * Instantiates a new abstract cfg synonyms.
	 */
	public AbstractCfgSynonyms() {
		super();
	}

	/**
	 * Instantiates a new abstract cfg synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractCfgSynonyms(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new abstract cfg synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractCfgSynonyms(IObjectIdEnum pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new abstract cfg synonyms.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractCfgSynonyms(String pObjectId) {
		super(pObjectId);

	}

	/**
	 * Adds the synonim word.
	 * 
	 * @param pCfgSynonyms
	 *            the cfg synonyms {@inheritDoc}
	 */
	@Override
	public void addSynonimWord(AbstractCfgSynonymWord pCfgSynonyms) {
		if (synonimWords == null) {
			synonimWords = new ArrayList<AbstractCfgSynonymWord>();
		}
		synonimWords.add(pCfgSynonyms);
	}

	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word {@inheritDoc}
	 */
	@Override
	public void addSynonimWord(String word) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		addSynonimWord(abstractCfgSynonymWord);
	}

	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word {@inheritDoc}
	 */
	@Override
	public void addSynonimWord(String word, CfgBookmaker synonymBookmaker) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		addSynonimWord(abstractCfgSynonymWord);
	}
	
	@Override
	public void addSynonimWord(String word, CfgBookmaker synonymBookmaker, String historicUser) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser);
		addSynonimWord(abstractCfgSynonymWord);
	}
	
	@Override
	public void addSynonimWord(String word, CfgBookmaker synonymBookmaker, String historicUser, Object historicData) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser,
				historicData);
		addSynonimWord(abstractCfgSynonymWord);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms#addSynonimWord
	 * (java.lang.String, java.util.List)
	 */
	@Override
	public void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setCandidateSynonyms(candidateSynonyms);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		addSynonimWord(abstractCfgSynonymWord);
	}
	
	@Override
	public void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, Set<String> participantSynonyms) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setCandidateSynonyms(candidateSynonyms);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		abstractCfgSynonymWord.setParticipantNames(participantSynonyms);
		addSynonimWord(abstractCfgSynonymWord);
	}
	
	@Override
	public void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, Set<String> participantSynonyms, String historicUser) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setCandidateSynonyms(candidateSynonyms);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		abstractCfgSynonymWord.setParticipantNames(participantSynonyms);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser);
		addSynonimWord(abstractCfgSynonymWord);
	}

	@Override
	public void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, Set<String> participantSynonyms, String historicUser, Object historicData) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setCandidateSynonyms(candidateSynonyms);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		abstractCfgSynonymWord.setParticipantNames(participantSynonyms);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser,
				historicData);
		
		addSynonimWord(abstractCfgSynonymWord);
	}

	
	@Override
	public void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, String historicUser) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setCandidateSynonyms(candidateSynonyms);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser);
		addSynonimWord(abstractCfgSynonymWord);
	}
	
	@Override
	public void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, String historicUser, Object historicData) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setCandidateSynonyms(candidateSynonyms);
		abstractCfgSynonymWord.setSynonymBookmaker(synonymBookmaker);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser,
				historicData);
		addSynonimWord(abstractCfgSynonymWord);
	}
	
	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word
	 * @param historicUser
	 *            the historic user {@inheritDoc}
	 */
	@Override
	public void addSynonimWord(String word, String historicUser) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser);
		addSynonimWord(abstractCfgSynonymWord);
	}

	@Override
	public void addSynonimWord(String word, String historicUser,
			CfgBookmaker bookmaker, Set<String> participantNames) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();

		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setSynonymBookmaker(bookmaker);
		abstractCfgSynonymWord.setParticipantNames(participantNames);
		addSynonimWord(abstractCfgSynonymWord);
	}

	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word
	 * @param historicUser
	 *            the historic user
	 * @param historicData
	 *            the historic data {@inheritDoc}
	 */
	@Override
	public void addSynonimWord(String word, String historicUser,
			Object historicData) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();
		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser,
				historicData);
		addSynonimWord(abstractCfgSynonymWord);
	}

	@Override
	public void addSynonimWord(String word, String historicUser,
			Object historicData, Set<String> participantNames) {
		AbstractCfgSynonymWord abstractCfgSynonymWord = newAbstractCfgSynonimWord();

		abstractCfgSynonymWord.setWord(word);
		abstractCfgSynonymWord.setHistoricCreationData(historicUser,
				historicData);
		abstractCfgSynonymWord.setParticipantNames(participantNames);
		addSynonimWord(abstractCfgSynonymWord);
	}
	
	/**
	 * Contains synonim word.
	 * 
	 * @param synonim
	 *            the synonim
	 * @return true, if successful
	 */
	public boolean containsSynonimWord(final String synonim) {
		for (AbstractCfgSynonymWord synonymWord : synonimWords) {
			if (synonim.equals(synonymWord.getWord())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the synonim word index.
	 *
	 * @param synonim the synonim
	 * @return the synonim word index
	 */
	public Integer getSynonymWordIndex(final String synonim) {
		Integer result = 0;
		for (AbstractCfgSynonymWord synonymWord : synonimWords) {
			if (synonim.equals(synonymWord.getWord())) {
				return result;
			}
			result++;
		}
		return -1;
	}

	/**
	 * Gets the related document.
	 * 
	 * @return the related document
	 */
	public abstract I getRelatedDocument();

	/**
	 * Gets the synonim words.
	 * 
	 * @return the synonim words {@inheritDoc}
	 */
	@Override
	public List<AbstractCfgSynonymWord> getSynonimWords() {
		return synonimWords;
	}

	/**
	 * New abstract cfg synonim word.
	 * 
	 * @return the abstract cfg synonym word
	 */
	public abstract AbstractCfgSynonymWord newAbstractCfgSynonimWord();

	/**
	 * Sets the related document.
	 * 
	 * @param relatedDocument
	 *            the new related document
	 */
	public abstract void setRelatedDocument(I relatedDocument);

	/**
	 * Sets the synonim words.
	 * 
	 * @param pCfgSynonyms
	 *            the new synonim words {@inheritDoc}
	 */
	@Override
	public void setSynonimWords(List<AbstractCfgSynonymWord> pCfgSynonyms) {
		this.synonimWords = pCfgSynonyms;
	}
}
