/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;

/**
 * The Interface ISynonymsRepository.
 * 
 * @param <T>
 *            the generic type
 */
public interface ISynonymsRepository<T extends ICfgSynonyms> {
	/**
	 * Custom find all.
	 * 
	 * @return the list
	 */
	List<T> customFindAll();

	/**
	 * Custom find by key words.
	 * 
	 * @param keywords
	 *            the keywords
	 * @return the list
	 */
	List<T> customFindByKeyWords(String[] keywords);

	/**
	 * Custom find byname.
	 * 
	 * @param pName
	 *            the name
	 * @return the list
	 */
	List<T> customFindByname(String pName);

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<T> findAllLimit(Integer limit, Integer skip);
}
