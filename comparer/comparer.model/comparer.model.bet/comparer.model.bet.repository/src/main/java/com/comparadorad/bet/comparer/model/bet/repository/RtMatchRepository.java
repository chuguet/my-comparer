/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;

/**
 * The Interface RtMatchRepository.
 */
public interface RtMatchRepository extends IGenericRepository<RtMatch>,
		RtMatchRepositoryCustom<RtMatch> {

}
