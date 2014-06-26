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
 * The Class StrategyBetcrisMakeUrl.
 */
@Component
public class StrategyBetcrisMakeUrl extends AbstractStrategyBookmakerEuDecorator {

	/** The date start. */
	private Date dateStart;

	/** The lastupdate. */
	private final Map<String, Date> lastupdate;

	/**
	 * Instantiates a new strategy betcris make url.
	 */
	public StrategyBetcrisMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
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

	/** {@inheritDoc} */
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.BETCRIS_COM_ID;
	}

}
