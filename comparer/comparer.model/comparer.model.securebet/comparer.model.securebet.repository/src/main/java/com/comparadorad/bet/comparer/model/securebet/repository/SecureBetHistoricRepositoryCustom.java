/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.repository;

import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;

/**
 * The Interface SecureBetHistoricRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface SecureBetHistoricRepositoryCustom<T extends SecureBeanHistoricData>
		extends IGenericCustomRepository<T> {

	public void saveWithOutValidation(SecureBeanHistoricData entity);
}
