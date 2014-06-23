/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

import com.comparadorad.bet.comparer.model.core.bean.AbstractDocumentFieldHistoricChange;

/**
 * The Class AbstractCfgSynonymWord.
 */
@SuppressWarnings("serial")
public abstract class AbstractCfgSynonymWord extends
		AbstractDocumentFieldHistoricChange implements ICfgSynonymWord {

	/**
	 * The Class CfgSynonymWordHistoricData.
	 */
	public static class CfgSynonymWordHistoricData implements Serializable {

		/** The algorithm. */
		@Field
		private AbstractStringMetric algorithm;

		/** The phrase strike. */
		@Field
		private Double phraseStrike;

		/**
		 * Instantiates a new cfg synonym word historic data.
		 */
		public CfgSynonymWordHistoricData() {
			super();
		}

		/**
		 * Instantiates a new cfg synonym word historic data.
		 * 
		 * @param pPhraseStrike
		 *            the phrase strike
		 * @param pAlgorithm
		 *            the p algorithm
		 */
		public CfgSynonymWordHistoricData(Double pPhraseStrike,
				AbstractStringMetric pAlgorithm) {
			super();
			phraseStrike = pPhraseStrike;
			algorithm = pAlgorithm;
		}

		/**
		 * Gets the algorithm.
		 * 
		 * @return the algorithm
		 */
		public AbstractStringMetric getAlgorithm() {
			return algorithm;
		}

		/**
		 * Gets the phrase strike.
		 * 
		 * @return the phrase strike
		 */
		public Double getPhraseStrike() {
			return phraseStrike;
		}

		/**
		 * Sets the algorithm.
		 * 
		 * @param algorithm
		 *            the algorithm
		 */
		public void setAlgorithm(AbstractStringMetric algorithm) {
			this.algorithm = algorithm;
		}

		/**
		 * Sets the phrase strike.
		 * 
		 * @param pPhraseStrike
		 *            the new phrase strike
		 */
		public void setPhraseStrike(Double pPhraseStrike) {
			phraseStrike = pPhraseStrike;
		}
	}

	/** The candidate synonyms. */
	@Field
	private List<String> candidateSynonyms;

	/**
	 * The keywords. see:
	 * http://www.mongodb.org/display/DOCS/Full+Text+Search+in+Mongo
	 */
	@Field(value = "_keywords")
	private String[] keywords;

	/** The participant list. */
	@Field
	private Set<String> participantNames;

	/** The synonym bookmaker. */
	@Field
	private CfgBookmaker synonymBookmaker;

	/** The word. */
	@Field
	private String word;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractCfgSynonymWord other = (AbstractCfgSynonymWord) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	/**
	 * Gets the candidate synonyms.
	 * 
	 * @return the candidate synonyms
	 */
	public List<String> getCandidateSynonyms() {
		return candidateSynonyms;
	}

	/**
	 * Gets the keywords.
	 * 
	 * @return the keywords
	 */
	public String[] getKeywords() {
		return keywords;
	}

	/**
	 * Gets the participant list.
	 * 
	 * @return the participant list
	 */
	public Set<String> getParticipantNames() {
		return participantNames;
	}

	/**
	 * Gets the synonym bookmaker.
	 * 
	 * @return the synonym bookmaker
	 */
	public CfgBookmaker getSynonymBookmaker() {
		return synonymBookmaker;
	}

	/**
	 * Gets the word.
	 * 
	 * @return the word {@inheritDoc}
	 */
	@Override
	public String getWord() {
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	/**
	 * Sets the candidate synonyms.
	 * 
	 * @param candidateSynonyms
	 *            the new candidate synonyms
	 */
	public void setCandidateSynonyms(List<String> candidateSynonyms) {
		this.candidateSynonyms = candidateSynonyms;
	}

	/**
	 * Sets the keywords.
	 * 
	 * @param pKeywords
	 *            the new keywords
	 */
	public void setKeywords(String[] pKeywords) {
		keywords = pKeywords;
	}

	/**
	 * Sets the participant list.
	 * 
	 * @param participantList
	 *            the new participant list
	 */
	public void setParticipantNames(Set<String> participantNames) {
		this.participantNames = participantNames;
	}

	/**
	 * Sets the synonym bookmaker.
	 * 
	 * @param synonymBookmaker
	 *            the new synonym bookmaker
	 */
	public void setSynonymBookmaker(CfgBookmaker synonymBookmaker) {
		this.synonymBookmaker = synonymBookmaker;
	}

	/**
	 * Sets the word.
	 * 
	 * @param pWord
	 *            the new word {@inheritDoc}
	 */
	@Override
	public void setWord(String pWord) {
		this.word = pWord;
	}

	/**
	 * To string.
	 * 
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("keywords", this.keywords)
				.append("word", this.word).toString();
	}
}
