/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.historic;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.valuebet.bean.HistoricInfo.Cause;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;
import com.comparadorad.bet.comparer.model.valuebet.converter.ValueBetToHistoricConverter;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetHistoricService;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetService;
import com.comparadorad.bet.comparer.synchro.valuebet.historic.beans.DataConfigurationHistoricValueBet;

/**
 * The Class ValueBetHistoric.
 */
@Service
class ValueBetHistoric implements IValueBetHistoric {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ValueBetHistoric.class);

	/** The data configuration. */
	@Inject
	private DataConfigurationHistoricValueBet dataConfiguration;

	/** The match service. */
	@Inject
	private IRtMatchService matchService;

	/** The skip value bet. */
	private Integer skipValueBet = 0;

	/** The value bet historic service. */
	@Inject
	private IValueBetHistoricService valueBetHistoricService;

	/** The value bet service. */
	@Inject
	private IValueBetService valueBetService;

	/**
	 * Calculate skip.
	 * 
	 * @param skip
	 *            the skip
	 * @param totalElements
	 *            the total elements
	 * @param limitQuery
	 *            the limit query
	 * @return the integer
	 */
	private Integer calculateSkip(Integer skip, Long totalElements,
			Integer limitQuery) {
		skip += limitQuery;
		if (skip > totalElements) {
			skip = 0;
		}
		return skip;
	}

	/**
	 * Execute.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Scheduled(fixedDelay = 5000)
	public void execute() {

		ValueBetHistoricData valueBetHistoricData;
		Long numValueBets;
		Boolean passToHistoric;
		Cause cause = null;
		RtMatch match;

		LOG.debug("------------------------ Inicio historic valuebet ---------------------------------");

		numValueBets = valueBetService.count();
		this.skipValueBet = calculateSkip(this.skipValueBet, numValueBets,
				dataConfiguration.getLimitValueBets());
		List<ValueBetData> valueBetsData = valueBetService.findAllLimit(
				dataConfiguration.getLimitValueBets(), this.skipValueBet);

		int numValueBetsPassedToHistoric = 0;
		for (ValueBetData valueBetData : valueBetsData) {

			passToHistoric = Boolean.FALSE;

			if (pastEvent(valueBetData.getInfoMatch())) {
				passToHistoric = Boolean.TRUE;
				cause = Cause.MATCH_ENDED;
			} else {
				match = matchService.findOne(valueBetData.getInfoMatch()
						.getObjectId());
				if (match == null) {
					passToHistoric = Boolean.TRUE;
					cause = Cause.MATCH_NO_LONGER_EXISTS;
				}
			}

			if (passToHistoric) {
				LOG.debug(new StringBuffer(
						"Se mueven al historico el valuebet: ")
						.append(valueBetData.getObjectId().toString())
						.append(". Causa: ").append(cause));
				valueBetHistoricData = ValueBetToHistoricConverter
						.convertToHistoric(valueBetData, cause);

				valueBetHistoricService.save(valueBetHistoricData);
				valueBetService.delete(valueBetData);
				numValueBetsPassedToHistoric++;
			}

		}

		LOG.debug(new StringBuffer("Se mueven al historico ").append(
				numValueBetsPassedToHistoric).append(" ValueBets."));

		LOG.debug("------------------------ Fin historic valuebet ---------------------------------");
	}

	/**
	 * Past event.
	 * 
	 * @param match
	 *            the match
	 * @return true, if successful
	 */
	private boolean pastEvent(InfoMatch match) {
		return Calendar.getInstance().getTime().after(match.getDate());
	}
}
