/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.repository;

import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;

/**
 * The Interface SecureBetHistoricRepository.
 */
public interface SecureBetHistoricRepository extends
		SecureBetHistoricRepositoryCustom<SecureBeanHistoricData>,
		IGenericRepository<SecureBeanHistoricData> {

	public void saveWithOutValidation(SecureBeanHistoricData entity);
}
