/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.EventRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseDataTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.BetTypeEventPriorityComparator;
import com.comparadorad.bet.comparer.web.server.mvc.match.control.filters.RtMatchFilterManager;
import com.comparadorad.bet.comparer.web.server.mvc.match.control.filters.RtMatchFilterShortTerm;
import com.comparadorad.bet.comparer.web.server.mvc.match.control.filters.RtMatchReduceByPCAndPCPFilter;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.BetTypesView;
import com.comparadorad.bet.comparer.web.server.mvc.match.factory.IObjectResponseFactory;
import com.comparadorad.bet.comparer.web.server.mvc.match.factory.ITabsFactory;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent.IMakeTableEvent;
import com.comparadorad.bet.comparer.web.server.mvc.match.tabs.IMakeTabs;

/**
 * The Class DetailEventController.
 */
@Controller
@RequestMapping("/eventEventController")
public class EventTabEventController extends AbstractHeadAndCellsCreator {

	/** The tab factory. */
	@Inject
	private ITabsFactory tabFactory;

	/** The factory. */
	@Inject
	private IObjectResponseFactory factory;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(EventTabEventController.class);

	/**
	 * Gets the bet odds.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param userData
	 *            the user data
	 * @return the bet odds
	 */
	//@AsynchronousCacheable(CacheRegion.BETODDS_EVENTTABEVENTCONTROLLER)
	@RequestMapping(value = "/getBetOdds", method = RequestMethod.POST)
	@ResponseBody
	public List<TableResponseTo> getBetOdds(
			@RequestBody final EventRequestTo eventRequestTo,
			final UserData userData) {
		LOG.debug("Se comienza el controlador EventTabEventController peticion getBetOdds");
		List<TableResponseTo> result;
		RtMatch match;
		InformationWindow informationWindow;
		IMakeTableEvent makeTable;
		CfgBetType betType;
		
		// Reduce query version
//		match = getMatchService().findMarketByBetTypeBetTypeEvent(
//			eventRequestTo.getEventId().getId(),
//			eventRequestTo.getBetTypeId().getId(),
//			eventRequestTo.getBetTypeEventId().getId());
		// Reduce query version			
		
		match = (RtMatch) getCacheRtMatch(eventRequestTo.getEventId().getId());

		informationWindow = new InformationWindow();
		informationWindow.setUserData(userData);

		String betTypeId = eventRequestTo.getBetTypeId().getId();
		String betTypeEventId = eventRequestTo.getBetTypeEventId().getId();
		betType = findCfgBetTypeById(betTypeId, match);
		makeTable = factory.makeTableEvent(betType, informationWindow);
		result = makeTable.makeTable(match, informationWindow, betTypeEventId);
		LOG.debug("Se finaliza el controlador EventTabEventController peticion getBetOdds");
		return result;
	}

	/**
	 * Gets the event competition.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param userData
	 *            the user data
	 * @return the event competition
	 */
	//@AsynchronousCacheable(CacheRegion.BETTYPESEVENT_EVENTTABEVENTCONTROLLER)
	@RequestMapping(value = "/getBetTypeEvent", method = RequestMethod.POST)
	@ResponseBody
	public TabResponseTo getBetTypeEvent(
			@RequestBody final EventRequestTo eventRequestTo,
			final UserData userData) {
		LOG.debug("Se comienza el controlador EventTabEventController peticion getBetTypeEvent");
		TabResponseTo result = new TabResponseTo();

		// Reduce query version
		// RtMatch match = getMatchService().findMarketByBetType(
		// eventRequestTo.getEventId().getId(),
		// eventRequestTo.getBetTypeId().getId());
		// Reduce query version

		RtMatch match = (RtMatch) getCacheRtMatch(eventRequestTo.getEventId()
				.getId());

		List<CfgBetTypeEvent> betTypesEvents = new ArrayList<CfgBetTypeEvent>();
		for (RtMarket market : match.getRtMarkets()) {
			if (market.getBetType().getObjectId().toString()
					.equals(eventRequestTo.getBetTypeId().getId())
					&& !containsBetTypeEvent(betTypesEvents, market
							.getBetTypeEvent().getBetTypeEvent())) {
				betTypesEvents.add(market.getBetTypeEvent().getBetTypeEvent());
			}
		}
		Collections.sort(betTypesEvents, new BetTypeEventPriorityComparator());
		TabResponseDataTo tab;
		for (CfgBetTypeEvent cfgBetTypeEvent : betTypesEvents) {
			tab = new TabResponseDataTo();

			tab.setId(new ObjectToId(cfgBetTypeEvent.getObjectId().toString()));
			if (cfgBetTypeEvent.getName(userData.getLocale()) != null) {
				tab.setName(cfgBetTypeEvent.getName(userData.getLocale()));
			} else {
				tab.setName(cfgBetTypeEvent.getNameId());
			}
			result.addTab(tab);
		}

		LOG.debug("Se finaliza el controlador EventTabEventController peticion getBetTypeEvent");
		return result;
	}

	/**
	 * Gets the bet types.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param userData
	 *            the user data
	 * @return the bet types
	 */
	//@AsynchronousCacheable(CacheRegion.BETTYPES_EVENTTABEVENTCONTROLLER)
	@RequestMapping(value = "/getBetTypes", method = RequestMethod.POST)
	@ResponseBody
	public TabResponseTo getBetTypes(
			@RequestBody final EventRequestTo eventRequestTo,
			final UserData userData) {
		LOG.debug("Se comienza el controlador EventTabEventController peticion getBetTypes");

		TabResponseTo result = new TabResponseTo();

		// Reduce query version
		// RtMatch match =
		// getMatchService().findMarketAndBetType(eventRequestTo.getEventId().getId());
		// Reduce query version

		RtMatch match = (RtMatch) getCacheRtMatch(eventRequestTo.getEventId()
				.getId());

		LOG.debug("getBetTypes - Get factoria tabs. start");
		IMakeTabs makeTabs = tabFactory.getMakeTabs(BetTypesView.EVENT);
		LOG.debug("getBetTypes - Get factoria tabs. end");

		LOG.debug("getBetTypes - make tabs. start");
		result = makeTabs.makeTabBetType(match, userData);
		LOG.debug("getBetTypes - make tabs. end");

		LOG.debug("Se finaliza el controlador EventTabEventController peticion getBetTypes");
		return result;
	}

	/**
	 * Gets the head.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param userData
	 *            the user data
	 * @return the head
	 */
	//@AsynchronousCacheable(CacheRegion.HEAD_EVENTTABEVENTCONTROLLER)
	@RequestMapping(value = "/getHead", method = RequestMethod.POST)
	@ResponseBody
	public HeadResponseTo getHead(
			@RequestBody final EventRequestTo eventRequestTo,
			final UserData userData) {
		LOG.debug("Se Comienza el controlador EventTabEventController peticion getHead");
		HeadResponseTo result = super.getEventHead(eventRequestTo, userData);
		LOG.debug("Se finaliza el controlador EventTabEventController peticion getHead");
		return result;
	}

}
