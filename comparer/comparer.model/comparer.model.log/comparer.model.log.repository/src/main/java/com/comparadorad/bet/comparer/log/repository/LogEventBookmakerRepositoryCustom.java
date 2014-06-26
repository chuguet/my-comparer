/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.log.repository;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmaker;

/**
 * The Interface LogEventBookmakerRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface LogEventBookmakerRepositoryCustom<T extends LogEventBookmaker>
		extends IGenericCustomRepository<T> {

	/**
	 * Custom find by bookmaker and state.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @param pLogState
	 *            the log state
	 * @return the list
	 */
	List<LogEventBookmaker> customFindByBookmakerAndState(
			CfgBookmaker bookmaker, LogState pLogState);
}
