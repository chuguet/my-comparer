/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
/**
 * The Class CfgCompetitionSynonymsRepositoryCustomImpl.
 */
class CfgRegionRepositoryCustomImpl extends
AbstractCfgRepository<CfgRegion> implements
CfgRegionRepositoryCustom<CfgRegion> {

	 /**
 	 * Gets the competition by id.
 	 *
 	 * @param id the id
 	 * @return the competition by id
 	 * {@inheritDoc}
 	 */ 
	@Override
	public CfgRegion getRegionById(BigInteger id) {
		CfgRegion result;
		
		Query query = new Query(where("_id").is(id));
		
		result = getMongoTemplate().findOne(query,
				CfgRegion.class);
		
		return result;
	}

	@Override
	public ArrayList<CfgRegion> getRegionByName(String regionName) {
		List<CfgRegion> result = new ArrayList<CfgRegion>();
		
		Query query = new Query(where("i18n.i18nFields.string").is(regionName));
		
		result = getMongoTemplate().find(query,
				CfgRegion.class);
		
		return (ArrayList<CfgRegion>) result;
	}

}
