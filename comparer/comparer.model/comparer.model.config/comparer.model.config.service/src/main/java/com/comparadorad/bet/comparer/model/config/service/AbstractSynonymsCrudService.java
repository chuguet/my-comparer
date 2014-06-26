/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.ISynonymsRepository;

/**
 * The Class AbstractSynonymsCrudService.
 * 
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
abstract class AbstractSynonymsCrudService<T extends ICfgSynonyms>
		extends AbstractGenericCrudService<T> implements ISynonymsService<T> {

	/**
	 * Find by synonyms.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<T> customFindByname(String name) {
		return ((ISynonymsRepository) getCrudRepository())
				.customFindByname(name);
	}

	/**
	 * Custom find by key words.
	 *
	 * @param keywords the keywords
	 * @return the list
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> customFindByKeyWords(String[] keywords) {
		return ((ISynonymsRepository) getCrudRepository())
				.customFindByKeyWords(keywords);

	}
	
	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.config.service.ISynonymsService#customFindAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> customFindAll() {
		return ((ISynonymsRepository) getCrudRepository())
				.customFindAll();
	}

}
