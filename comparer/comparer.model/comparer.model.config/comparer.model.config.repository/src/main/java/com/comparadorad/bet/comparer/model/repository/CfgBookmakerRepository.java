/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import org.springframework.stereotype.Repository;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;

/**
 * The Interface CfgBookmakerRepository.
 */
@Repository
public interface CfgBookmakerRepository extends
		IGenericRepository<CfgBookmaker>,
		CfgBookmakerRepositoryCustom<CfgBookmaker> {

	Long getActiveBookmakers();

}
