/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord.CfgSynonymWordHistoricData;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Interface ICfgSynonyms.
 */
public interface ICfgSynonyms extends IDocument {

	/**
	 * Adds the cfg synonim.
	 * 
	 * @param pCfgSynonyms
	 *            the cfg synonim
	 */
	void addSynonimWord(AbstractCfgSynonymWord pCfgSynonyms);

	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word
	 * @param synonymBookmaker
	 *            the synonym bookmaker
	 */
	void addSynonimWord(String word);

	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word
	 * @param synonymBookmaker
	 *            the synonym bookmaker
	 */
	void addSynonimWord(String word, CfgBookmaker synonymBookmaker);

	void addSynonimWord(String word, CfgBookmaker synonymBookmaker,
			String historicUser);

	void addSynonimWord(String word, CfgBookmaker synonymBookmaker,
			String historicUser, Object historicData);


	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word
	 * @param candidateSynonyms
	 *            the candidate synonyms
	 * @param synonymBookmaker
	 *            the synonym bookmaker
	 */
	void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker);

	void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, String historicUser);
	
	void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, String historicUser, Object historicData);


	void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, Set<String> participantSynonyms);

	void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, Set<String> participantSynonyms,
			String historicUser);

	void addSynonimWord(String word, List<String> candidateSynonyms,
			CfgBookmaker synonymBookmaker, Set<String> participantSynonyms,
			String historicUser,
			Object historicData);

	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word
	 * @param historicUser
	 *            the historic user
	 */
	void addSynonimWord(String word, String historicUser);

	/**
	 * Adds the synonim word.
	 * 
	 * @param word
	 *            the word
	 * @param historicUser
	 *            the historic user
	 * @param historicData
	 *            the historic data
	 */
	void addSynonimWord(String word, String historicUser, Object historicData);

	/**
	 * Gets the cfg synonims.
	 * 
	 * @return the cfg synonims
	 */
	List<AbstractCfgSynonymWord> getSynonimWords();

	/**
	 * Sets the cfg synonims.
	 * 
	 * @param pCfgSynonyms
	 *            the new cfg synonims
	 */
	void setSynonimWords(List<AbstractCfgSynonymWord> pCfgSynonyms);

	String getParent();

	void addSynonimWord(String word, String historicUser, Object historicData,
			Set<String> participantNames);
	
	void addSynonimWord(String word, String historicUser, CfgBookmaker bookmaker,
			Set<String> participantNames);

}
