/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.repository;

import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

/**
 * The Interface SecureBetRepository.
 */
public interface SecureBetRepository extends
		SecureBetRepositoryCustom<SecureBeanData>,
		IGenericRepository<SecureBeanData> {

	void update(SecureBeanData surebetDB, Set<RtBet> bets,
			SecureBeanBenefit benefit);
	
	
}
