/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;

/**
 * The Class StrategyGenericMakeUrl.
 */
@Component
final class StrategyGenericMakeUrl extends AbstractStrategyGenericMakeUrl {
	
	/** The date start. */
	private Date dateStart;
	
	/** The lastupdate. */
	private final Map<String, Date> lastupdate;
	
	/**
	 * Instantiates a new strategy generic make url.
	 */
	public StrategyGenericMakeUrl(){
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
	}

	/** {@inheritDoc} */ 
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.GENERIC;
	}

	/** {@inheritDoc} */ 
	@Override
	protected Date getDateStart() {
		return dateStart;
	}

	/** {@inheritDoc} */ 
	@Override
	protected Map<String, Date> getLastupdate() {
		return lastupdate;
	}

}
