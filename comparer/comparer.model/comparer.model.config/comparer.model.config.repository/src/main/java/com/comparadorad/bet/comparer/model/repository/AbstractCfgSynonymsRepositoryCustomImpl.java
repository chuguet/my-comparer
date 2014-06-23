/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepository;
import com.comparadorad.bet.comparer.util.commons.lang.TokenWordUtil;

/**
 * The Class AbstractCfgRepository.
 * 
 * @param <T>
 *            the generic type
 */
abstract class AbstractCfgSynonymsRepositoryCustomImpl<T extends ICfgSynonyms>
		extends AbstractRepository<T> implements ISynonymsRepository<T> {

	private static final Log LOG = LogFactory
			.getLog(AbstractCfgSynonymsRepositoryCustomImpl.class);

	/**
	 * Custom find by key words.
	 * 
	 * @param keywords
	 *            the keywords
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<T> customFindByKeyWords(String[] keywords) {
		Query q1 = new Query(where("synonimWords._keywords").in(keywords)
				.and(getActiveAndCondition()).ne("false"));
		LOG.info(q1.getQueryObject());
		return getMongoTemplate().find(q1, getModelClass());
	}

	/** {@inheritDoc} */
	@Override
	public List<T> customFindByname(String name) {
		Query query1 = new Query(where("synonimWords.word").is(name)
				.and(getActiveAndCondition()).ne("false"));
		LOG.info(query1.getQueryObject());
		return getMongoTemplate().find(query1, getModelClass());
	}

	@Override
	public List<T> customFindAll() {
		return getMongoTemplate().findAll(getModelClass());
	}
	
	/**
	 * Gets the model class.
	 * 
	 * @return the model class
	 */
	protected abstract Class<T> getModelClass();

	/**
	 * Save.
	 * 
	 * @param <S>
	 *            the generic type
	 * @param entities
	 *            the entities
	 * @return the iterable
	 */
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		for (S s : entities) {
			save(s);
		}
		return entities;
	}

	/**
	 * Save.
	 * 
	 * @param entity
	 *            the entity {@inheritDoc}
	 */
	public void save(T entity) {
		if (entity instanceof ICfgSynonyms) {
			List<AbstractCfgSynonymWord> synonymWords = ((ICfgSynonyms) entity)
					.getSynonimWords();
			if (synonymWords != null) {
				for (AbstractCfgSynonymWord synonymWord : synonymWords) {
					String[] tokens = TokenWordUtil.createTokens(synonymWord
							.getWord());
					synonymWord.setKeywords(tokens);
				}
			}
		}
		super.save(entity);
	}

}
