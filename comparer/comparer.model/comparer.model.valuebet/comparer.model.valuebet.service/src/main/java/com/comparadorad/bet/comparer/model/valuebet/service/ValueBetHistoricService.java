/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;
import com.comparadorad.bet.comparer.model.valuebet.repository.ValueBetHistoricRepository;

/**
 * The Class ValueBetHistoricService.
 */
@Service
class ValueBetHistoricService extends
		AbstractGenericCrudService<ValueBetHistoricData> implements
		IValueBetHistoricService {

	/** The secure bet historic repository. */
	@Inject
	private ValueBetHistoricRepository valueBetHistoricRepository;

	/** {@inheritDoc} */
	public List<ValueBetHistoricData> exist(String idMatch,
			String marketHashKey, String betHashKey) {
		return valueBetHistoricRepository.exist(idMatch, marketHashKey,
				betHashKey);
	}

	/** {@inheritDoc} */
	public List<ValueBetHistoricData> exist(ValueBetData valueBetData) {
		return valueBetHistoricRepository.exist(valueBetData);
	}

	/** {@inheritDoc} */
	public List<ValueBetHistoricData> exist(
			ValueBetHistoricData valueBetHistoricData) {
		return valueBetHistoricRepository.exist(valueBetHistoricData);
	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<ValueBetHistoricData> getCrudRepository() {
		return valueBetHistoricRepository;
	}

}
