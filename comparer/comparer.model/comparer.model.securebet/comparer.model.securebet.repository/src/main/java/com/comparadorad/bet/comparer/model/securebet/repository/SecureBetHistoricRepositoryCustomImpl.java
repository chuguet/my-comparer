/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.repository;

import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;

/**
 * The Class SecureBetHistoricRepositoryCustomImpl.
 * 
 * @param <T>
 *            the generic type
 */
class SecureBetHistoricRepositoryCustomImpl<T extends SecureBeanHistoricData>
extends AbstractCfgRepository<T> implements
SecureBetHistoricRepositoryCustom<T> {


	public void saveWithOutValidation(SecureBeanHistoricData entity) {
		getMongoTemplate().save(entity);
	}

}
