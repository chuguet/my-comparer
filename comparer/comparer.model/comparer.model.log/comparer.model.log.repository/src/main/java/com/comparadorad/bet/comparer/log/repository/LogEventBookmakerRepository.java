/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.log.repository;

import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmaker;

/**
 * The Interface LogXmlEventRepository.
 */
public interface LogEventBookmakerRepository extends
		IGenericRepository<LogEventBookmaker>,
		LogEventBookmakerRepositoryCustom<LogEventBookmaker> {

}
