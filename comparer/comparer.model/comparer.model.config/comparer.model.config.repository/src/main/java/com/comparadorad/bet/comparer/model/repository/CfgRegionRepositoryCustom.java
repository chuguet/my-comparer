/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.math.BigInteger;
import java.util.ArrayList;

import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface CfgCompetitionRepositoryCustom.
 *
 * @param <T> the generic type
 */
public interface CfgRegionRepositoryCustom<T extends CfgRegion>
extends IGenericCustomRepository<T> {

	/**
	 * Gets the competition by id.
	 *
	 * @param id the id
	 * @return the competition by id
	 */
	CfgRegion getRegionById(BigInteger id);
	
	/**
	 * Gets the competition by name.
	 *
	 * @param competitionName the competition name
	 * @return the competition by name
	 */
	ArrayList<CfgRegion> getRegionByName(String regionName);
}