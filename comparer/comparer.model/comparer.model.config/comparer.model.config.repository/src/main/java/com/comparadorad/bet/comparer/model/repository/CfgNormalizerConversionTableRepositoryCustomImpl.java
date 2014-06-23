/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgNormalizerConversionTable;

/**
 * The Class CfgCompetitionSynonymsRepositoryCustomImpl.
 */
class CfgNormalizerConversionTableRepositoryCustomImpl extends
		AbstractCfgRepository<CfgNormalizerConversionTable>
		implements
		CfgNormalizerConversionTableRepositoryCustom<CfgNormalizerConversionTable> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.
	 * CfgNormalizerConversionTableRepositoryCustom
	 * #customFindByKey(java.lang.String)
	 */
	@Override
	public CfgNormalizerConversionTable customFindByKey(String key) {
		List<CfgNormalizerConversionTable> result = new ArrayList<CfgNormalizerConversionTable>();
		CfgNormalizerConversionTable salida = new CfgNormalizerConversionTable();
		Query query1 = new Query(where("key").is(key));
		result = getMongoTemplate().find(query1,
				CfgNormalizerConversionTable.class);
		if (result != null && !result.isEmpty()) {
			salida = result.get(0);
		} else {
			salida = null;
		}
			
		return salida;
			
	}

}
