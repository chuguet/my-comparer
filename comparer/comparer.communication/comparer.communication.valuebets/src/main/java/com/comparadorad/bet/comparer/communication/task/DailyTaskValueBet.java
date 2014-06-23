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
 * The Class DailyTaskValueBet.
 */
@Service
public class DailyTaskValueBet extends AbstractTaskValueBet {
	
	
	private static final Log LOG = LogFactory
			.getLog(DailyTaskValueBet.class);

	/**
	 * Process.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Scheduled(cron = "00 00 10 * * *")
	public void process() {
		LOG.info("Se inicia el proceso diario de valuebet");
		super.process();
		LOG.info("Se finaliza el proceso diario de valuebet");
	}

	 /** {@inheritDoc} */ 
	@Override
	public Integer getNumDays() {
		return NumDays.DAILY.getNumDays();
	}

}
