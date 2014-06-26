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
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;

/**
 * The Interface LogXmlEventRepository.
 */
public interface LogEventBookmakerMasterWordsRepository extends
		IGenericRepository<LogEventBookmakerMasterWords>,
		LogEventBookmakerMasterWordsRepositoryCustom<LogEventBookmakerMasterWords> {

}
