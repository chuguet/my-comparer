/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;

/**
 * The Interface CfgSportRepository.
 */
public interface CfgSportRepository extends IGenericRepository<CfgSport>,
		CfgSportRepositoryCustom<CfgSport> {

}
