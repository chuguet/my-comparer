/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step2;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepository;

/**
 * The Class NameService.
 */
@SuppressWarnings("rawtypes")
@Component
public class NameService extends AbstractRepository {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(NameService.class);

	/**
	 * Custom find by sport name.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	public List<CfgSport> customFindBySportName(String name) {
		Query q1 = new Query(where("i18n.i18nFields.string").is(name));
		LOG.info(q1.getQueryObject());
		return this.getMongoTemplate().find(q1, CfgSport.class);
	}

	/**
	 * Custom find by competition name.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	public List<CfgCompetition> customFindByCompetitionName(String name) {
		Query q1 = new Query(where("i18n.i18nFields.string").is(name));
		LOG.info(q1.getQueryObject());
		return this.getMongoTemplate().find(q1, CfgCompetition.class);
	}

	/**
	 * Custom find by participant name.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	public List<CfgParticipant> customFindByParticipantName(String name) {
		Query q1 = new Query(where("i18n.i18nFields.string").is(name));
		LOG.info(q1.getQueryObject());
		return this.getMongoTemplate().find(q1, CfgParticipant.class);
	}

	/**
	 * Custom find by region name.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	public List<CfgRegion> customFindByRegionName(String name) {
		Query q1 = new Query(where("i18n.i18nFields.string").is(name));
		LOG.info(q1.getQueryObject());
		return this.getMongoTemplate().find(q1, CfgRegion.class);
	}

}
