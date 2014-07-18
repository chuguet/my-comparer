/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.control.filters.RtMatchFilterManager;
import com.comparadorad.bet.comparer.web.server.mvc.match.control.filters.RtMatchReduceByPCAndPCPFilter;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.BetTypesView;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.factory.IObjectResponseFactory;
import com.comparadorad.bet.comparer.web.server.mvc.match.factory.ITabsFactory;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.IMakeTableShortTerm;
import com.comparadorad.bet.comparer.web.server.mvc.match.tabs.IMakeTabs;

/**
 * The Class EventResultController.
 */
@Controller
@RequestMapping("/competitionEventController")
public class CompetitionTabEventController extends AbstractHeadAndCellsCreator {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CompetitionTabEventController.class);

	@Inject
	private IObjectResponseFactory factory;

	@Inject
	private ITabsFactory factoryTabs;

	@AsynchronousCacheable(CacheRegion.BETODDS_COMPETITIONEVENTCONTROLLER)
	@RequestMapping(value = "/getBetOdds", method = RequestMethod.POST)
	@ResponseBody
	public List<TableResponseTo> getBetOdds(
			@RequestBody final CompetitionRequestTo competitionRequestTo,
			final UserData userData) {
		LOG.info("Comienzo parte servidora");
		List<TableResponseTo> result;
		InformationWindow informationWindow;
		List<RtMatch> matchs;

		informationWindow = new InformationWindow();
		informationWindow.setUserData(userData);

		String idBetType = competitionRequestTo.getBetTypeIdFirstLevel()
				.getId();

		BigInteger idCompetition = new BigInteger(competitionRequestTo
				.getCompetitionId().getId());
		
		matchs = getMatchService()
				.mapReduceGetMatchsByCompetition(idCompetition, idBetType,
						CfgBetTypeEventId.PARTIDO_COMPLETO.objectId(), 
						CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.objectId());

		matchs = new RtMatchFilterManager<RtMatch>()
				.addFilter(new RtMatchReduceByPCAndPCPFilter())
				.applyFiltersChain(matchs);			
		
		CfgBetType betType = findCfgBetTypeById(idBetType, matchs);

		IMakeTableShortTerm makeTableShortTerm = factory.makeTableShortTerm(
				betType, LevelType.COMPETITION, informationWindow);

		result = makeTableShortTerm.makeTable(filterShortTerm(matchs),
				informationWindow);
		LOG.info("Fin parte servidora");
		return result;
	}

	/**
	 * Gets the bet types.
	 * 
	 * @param competitionRequestTo
	 *            the competition request to
	 * @param userData
	 *            the user data
	 * @return the bet types
	 */
	@AsynchronousCacheable(CacheRegion.BETTYPES_COMPETITIONTABEVENTCONTROLLER)
	@RequestMapping(value = "/getBetTypes", method = RequestMethod.POST)
	@ResponseBody
	public TabResponseTo getBetTypes(
			@RequestBody final CompetitionRequestTo competitionRequestTo,
			final UserData userData) {
		List<RtMatch> matchs = getMatchService()
				.getBetTypesCompetitionMatchs(
						new CfgCompetition(competitionRequestTo
								.getCompetitionId().getId()));
		IMakeTabs makeTabs = factoryTabs.getMakeTabs(BetTypesView.COMPETITION);
		return makeTabs.makeTabBetType(super.filterShortTerm(matchs), userData);
	}

	/**
	 * Gets the head.
	 * 
	 * @param competitionRequestTo
	 *            the competition request to
	 * @param userData
	 *            the user data
	 * @return the head
	 */
	@AsynchronousCacheable(CacheRegion.HEAD_COMPETITIONTABEVENTCONTROLLER)
	@RequestMapping(value = "/getHead", method = RequestMethod.POST)
	@ResponseBody
	public HeadResponseTo getHead(
			@RequestBody final CompetitionRequestTo competitionRequestTo,
			final UserData userData) {
		return super.getCompetitionHead(competitionRequestTo, userData);
	}

}
