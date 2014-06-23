/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.math.BigInteger;
import java.util.Map;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface CfgCompetitionRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
public interface CfgBookmakerRepositoryCustom<T extends CfgBookmaker> extends
		IGenericCustomRepository<T> {

	/**
	 * Gets the active bookmakers.
	 * 
	 * @return the active bookmakers
	 */
	Long getActiveBookmakers();

	/**
	 * Find all times for delete bets. Return a map which contains a
	 * key (idBookmaker) and a value (minutes past to delete bets)
	 * 
	 * @return the map
	 */
	Map<BigInteger, Long> findAllTimesForDeleteBets();

}