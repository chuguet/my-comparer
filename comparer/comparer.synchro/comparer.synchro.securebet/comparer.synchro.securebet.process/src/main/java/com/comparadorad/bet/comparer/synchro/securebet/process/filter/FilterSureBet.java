/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.filter;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.securebet.process.beans.SureBetConfiguration;

/**
 * The Class FilterSureBet.
 */
@Component
public class FilterSureBet implements IFilterSureBet {

	@Inject
	private SureBetConfiguration sureBetConfiguration;

	@Override
	public Boolean filterMeetsRanges(Double benefit) {
		Double min = sureBetConfiguration.getMinBenefit();
		Double max = sureBetConfiguration.getMaxBenefit();
		
		return benefit >= min && benefit <= max;
	}
}
