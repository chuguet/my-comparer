/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.reader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.synchro.valuebet.bean.DataConfiguration;
import com.comparadorad.bet.comparer.synchro.valuebet.filter.IFilterValueBet;

/**
 * The Class ReaderValueBet.
 */
@Service
class ReaderValueBet implements IReaderValueBet {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ReaderValueBet.class);

	/** The matchs. */
	private static List<RtMatch> matchs = new ArrayList<RtMatch>();

	/** The skip. */
	private static Integer skip;

	/**
	 * Gets the matchs.
	 * 
	 * @return the matchs
	 */
	public static List<RtMatch> getMatchs() {
		return matchs;
	}

	/**
	 * Gets the skip.
	 * 
	 * @return the skip
	 */
	public static Integer getSkip() {
		return skip;
	}

	/** The data configuration. */
	@Inject
	private DataConfiguration dataConfiguration;

	/** The bet filter. */
	@Inject
	private List<IFilterValueBet> filters;

	/** The match service. */
	@Inject
	private IRtMatchService matchService;

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
		if (skip == null) {
			skip = 0;
		} else {
			skip += limitQuery;
			if (skip > totalElements) {
				skip = 0;
			}
		}
		return skip;
	}

	/** {@inheritDoc} */
	@Override
	public RtMatch read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		LOG.debug("------------------------ Inicio reader valuebet ---------------------------------");
		RtMatch result = null;

		if (matchs.isEmpty()) {
			skip = calculateSkip(skip, matchService.count(),
					dataConfiguration.getQuantityLimitMatchs());
			LOG.debug("------------------------ Obtención de matchs de BBDD ---------------------------------");
			LOG.debug(new StringBuffer().append("Se va a recuperar ")
					.append(dataConfiguration.getQuantityLimitMatchs())
					.append(" RtMatchs empezando con RtMatch numero ")
					.append(skip).toString());
			matchs = matchService.getEventsForValueBetLimit(
					dataConfiguration.getQuantityLimitMatchs(), skip,
					dataConfiguration.getQuantityLimitBets());
			LOG.debug(new StringBuffer("Matchs obtenidos: ").append(matchs
					.size()));
			LOG.debug("------------------------ Fin de obtención de matchs de BBDD --------------------------");

			matchs = valueBetFilter(matchs);

		}
		for (RtMatch match : matchs) {
			result = (RtMatch) match.clone();
			matchs.remove(match);
			match = null;
			break;
		}

		LOG.debug("------------------------ Fin reader valuebet ---------------------------------");
		return result;
	}

	/**
	 * Value bet filter.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the list
	 */
	private List<RtMatch> valueBetFilter(List<RtMatch> matchs) {

		LOG.debug("--------------------------- Inicio filtro valubet ------------------------------------");
		for (IFilterValueBet filter : filters) {
			matchs = filter.matchFilter(matchs);
		}
		LOG.debug("----------------------------- Fin filtro valubet -------------------------------------");

		return matchs;
	}

}
