/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import com.comparadorad.bet.comparer.model.config.bean.CfgNormalizerConversionTable;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface CfgMasterRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface CfgNormalizerConversionTableRepositoryCustom<T extends CfgNormalizerConversionTable> extends
		IGenericCustomRepository<T> {

	
	/**
	 * Custom find by key.
	 *
	 * @param key the key
	 * @return the list
	 */
	CfgNormalizerConversionTable customFindByKey(String key);

	
}
