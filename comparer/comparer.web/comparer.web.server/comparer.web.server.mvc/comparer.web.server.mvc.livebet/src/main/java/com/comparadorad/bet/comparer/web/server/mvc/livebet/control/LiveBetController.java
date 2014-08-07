/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.livebet.control;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.bean.request.LiveBetRequestTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.control.AbstractComparerController;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.beans.UserDataCover;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.factory.ITableFactory;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.factory.table.IMakeTable;
import com.comparadorad.bet.comparer.web.server.util.bookmaker.ActiveBookmakers;

/**
 * The Class LiveBetController.
 */
@Controller
@RequestMapping("/liveBetController")
public class LiveBetController extends AbstractComparerController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(LiveBetController.class);

	/** The rt match service. */
	@Inject
	private IRtMatchService rtMatchService;

	/** The active bookmakers. */
	@Inject
	private ActiveBookmakers activeBookmakers;

	/** The factory. */
	@Inject
	private ITableFactory factory;

	/** The NUMBE r_ da y_ range. */
	private final Integer NUMBER_HOUR_RANGE = 12;

	/** The percent of valid events. */
	private static Integer percentOfValidEvents = 25;

	/**
	 * Gets the live bet.
	 * 
	 * @param userData
	 *            the user data
	 * @return the live bet
	 * @throws ParseException
	 *             the parse exception
	 */
	@AsynchronousCacheable(CacheRegion.LIVEBET_LIVEBETCONTROLLER)
	@RequestMapping(value = "/getLiveBet", method = RequestMethod.POST)
	@ResponseBody
	public List<TableResponseTo> getLiveBet(
			@RequestBody final LiveBetRequestTo request, final UserData userData) {
		LOG.debug("Comienzo el controlador de proximos eventos.");
		List<TableResponseTo> result = new ArrayList<TableResponseTo>();
		final Date currentTime;
		if (request != null && request.getDate() != null) {
			currentTime = request.getDate();
		} else {
			currentTime = new Date();
		}

		Integer minimalNumberOfBookmakers = activeBookmakers
				.getMinimalNumberOfBookmakers(percentOfValidEvents);

		LOG.debug("Comienzo de obtencion de partidos");
		List<RtMatch> matchs = rtMatchService.getUpcomingEvents(currentTime,
				NUMBER_HOUR_RANGE, minimalNumberOfBookmakers);
		LOG.debug(new StringBuffer("Partidos obtenidos: ")
				.append(matchs.size()).toString());

		UserDataCover uData = new UserDataCover();
		uData.setUserData(userData);
		IMakeTable makeTable = null;

		RtMarket market;

		for (RtMatch rtMatch : matchs) {
			if (rtMatch.getRtMarkets() != null) {
				market = getRtMarketByOrder(rtMatch.getRtMarkets());
				if (market != null) {
					makeTable = factory.makeTable(market.getBetType());
					result.add(makeTable.makeTable(rtMatch, uData, market));
				}
			}
		}
		LOG.debug("Finalizo el controlador de proximos eventos.");
		return result;
	}

	/**
	 * Gets the rt market by order.
	 * 
	 * @param rtMarkets
	 *            the rt markets
	 * @return the rt market by order
	 */
	private RtMarket getRtMarketByOrder(Set<RtMarket> rtMarkets) {
		RtMarket result = null;
		for (RtMarket rtMarket : rtMarkets) {
			if (validMarket(rtMarket)) {
				result = rtMarket;
				break;
			}
		}
		return result;
	}

	/**
	 * Valid market.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @return true, if successful
	 */
	private Boolean validMarket(RtMarket market) {
		Boolean valid = Boolean.FALSE;
		if ((market.getBetTypeEvent().getBetTypeEvent().getNameId()
				.equals(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId()) && (market
				.getBetType().getNameId().equals(CfgBetTypeId.GANADOR.nameId()) || market
				.getBetType().getNameId()
				.equals(CfgBetTypeId.UNO_X_DOS.nameId())))
				|| (market
						.getBetTypeEvent()
						.getBetTypeEvent()
						.getNameId()
						.equals(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA
								.nameId()) && market.getBetType().getNameId()
						.equals(CfgBetTypeId.GANADOR.nameId()))) {
			valid = Boolean.TRUE;
		}

		return valid;
	}
}
