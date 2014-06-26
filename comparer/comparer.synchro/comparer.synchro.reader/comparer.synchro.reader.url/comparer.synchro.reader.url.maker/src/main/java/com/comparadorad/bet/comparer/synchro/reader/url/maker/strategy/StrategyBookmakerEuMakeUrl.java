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
 * The Class StrategyBookmakerMakeUrl.
 */
@Component
public class StrategyBookmakerEuMakeUrl extends
		AbstractStrategyBookmakerEuDecorator {

	/** The date start. */
	private Date dateStart;

	/** The lastupdate. */
	private final Map<String, Date> lastupdate;

	/**
	 * Instantiates a new strategy bookmaker make url.
	 */
	public StrategyBookmakerEuMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
	}

	/**
	 * Gets the date start.
	 * 
	 * @return the date start {@inheritDoc}
	 */
	@Override
	protected Date getDateStart() {
		return dateStart;
	}

	/**
	 * Gets the lastupdate.
	 * 
	 * @return the lastupdate {@inheritDoc}
	 */
	@Override
	protected Map<String, Date> getLastupdate() {
		return lastupdate;
	}

	/**
	 * Gets the strategy type.
	 * 
	 * @return the strategy type {@inheritDoc}
	 */
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.BOOKMAKER_EU;
	}

}
