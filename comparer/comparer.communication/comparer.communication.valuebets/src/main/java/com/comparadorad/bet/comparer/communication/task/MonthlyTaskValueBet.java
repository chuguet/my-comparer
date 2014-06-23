/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.enums.NumDays;

/**
 * The Class MonthlyTaskValueBet.
 */
@Service
public class MonthlyTaskValueBet extends AbstractTaskValueBet {

	private static final Log LOG = LogFactory
			.getLog(MonthlyTaskValueBet.class);
	/**
	 * Process.
	 * 
	 * {@inheritDoc}
	 */
	@Scheduled(cron = "00 00 10 1 * *")
	public void process() {
		LOG.info("Se inicia el proceso mensual de valuebet");
		super.process();
		LOG.info("Se finaliza el proceso mensual de valuebet");
	}

	 /** {@inheritDoc} */ 
	public Integer getNumDays() {
		return NumDays.MONTHLY.getNumDays();
	}

}
