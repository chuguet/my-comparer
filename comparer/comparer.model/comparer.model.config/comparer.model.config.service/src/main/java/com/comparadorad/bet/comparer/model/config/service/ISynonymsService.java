/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICfgBetTypeSynonymsService.
 * 
 * @param <T>
 *            the generic type
 */
public interface ISynonymsService<T extends ICfgSynonyms> extends
		IGenericCrudService<T> {

	/**
	 * Find by synonyms.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	@Cacheable(value = { "customFindByname" })
	List<T> customFindByname(String name);

	/**
	 * Custom find by key words.
	 * 
	 * @param keywords
	 *            the keywords
	 * @return the list
	 */
	@Cacheable(value = { "customFindByKeyWords" })
	List<T> customFindByKeyWords(String[] keywords);
	
	/**
	 * Custom find all.
	 *
	 * @return the list
	 */
	@Cacheable(value = { "customFindAll" })
	List<T> customFindAll();
	
	
	/**
	 * Custom find all tournament.
	 *
	 * @param string the string
	 * @param bigInteger the big integer
	 * @return the list
	 */
	@Cacheable(value = { "customFindAllTournament" })
	List<T> customFindAllTournament(String string, BigInteger bigInteger);
	
	
	/**
	 * Custom find all participant.
	 *
	 * @param participantName the participant name
	 * @param competitionId the competition id
	 * @param sportId the sport id
	 * @return the list
	 */
	List<T> customFindAllParticipant(BigInteger competitionId);
}
