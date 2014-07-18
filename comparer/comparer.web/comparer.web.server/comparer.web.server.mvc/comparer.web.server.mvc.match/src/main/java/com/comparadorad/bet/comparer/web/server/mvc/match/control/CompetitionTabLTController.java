/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

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
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.SortRowsByLinkText;
import com.comparadorad.bet.comparer.web.server.mvc.match.factory.IObjectResponseFactory;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.tablongterm.IMakeTableCompetitionLT;

/**
 * The Class CompetitionTabLTController.
 */
@Controller
@RequestMapping("/competitionLongTermController")
public class CompetitionTabLTController extends AbstractHeadAndCellsCreator {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CompetitionTabLTController.class);

	/** The factory. */
	@Inject
	private IObjectResponseFactory factory;

	/**
	 * Gets the bet odds.
	 * 
	 * @param competitionRequestTo
	 *            the competition request to
	 * @param userData
	 *            the user data
	 * @return the bet odds
	 */
	@AsynchronousCacheable(CacheRegion.BETODDS_COMPETITIONTABLTCONTROLLER)
	@RequestMapping(value = "/getBetOdds", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getBetOdds(
			@RequestBody final CompetitionRequestTo competitionRequestTo,
			final UserData userData) {
		LOG.debug(new StringBuffer(
				"Se inicia el controlador CompetitionTabLTController la peticion getBetOdds")
				.toString());
		InformationWindow informationWindow = new InformationWindow();
		informationWindow.setUserData(userData);

		RtMatch match = getMatchService().findOneCustom(
				competitionRequestTo.getEventId().getId());

		String pId = competitionRequestTo.getBetTypeIdFirstLevel().getId();
		CfgBetType betType = findCfgBetTypeById(pId, match);

		IMakeTableCompetitionLT makeTable = factory.makeTableCompetitionLT(
				betType, informationWindow);
		TableResponseTo result = makeTable.makeTable(filterLongTerm(match),
				informationWindow);
		LOG.debug(new StringBuffer(
				"Se finaliza el controlador CompetitionTabLTController la peticion getBetOdds")
				.toString());
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
	@AsynchronousCacheable(CacheRegion.BETTYPES_COMPETITIONTABLTCONTROLLER)
	@RequestMapping(value = "/getBetTypes", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getBetTypes(
			@RequestBody final CompetitionRequestTo competitionRequestTo,
			final UserData userData) {
		LOG.debug(new StringBuffer(
				"Se inicia el controlador CompetitionTabLTController la peticion getBetTypes")
				.toString());
		TableResponseTo result = new TableResponseTo();

		RtMatch match = getMatchService().findOneCustom(
				competitionRequestTo.getEventId().getId());
		for (RtMarket market : match.getRtMarkets()) {
			if (isBetTypeForCompetitionLT(market)) {
				ObjectToId idBetType = new ObjectToId(market.getBetType()
						.getObjectId().toString());
				String nameBetType = market.getBetType().getName(
						userData.getLocale());
				String nodeId = new StringBuffer()
						.append(competitionRequestTo.getEventId().getId())
						.append(idBetType.getId()).toString();
				result.add(createTreeRow(null, nodeId, competitionRequestTo
						.getEventId().getId(), idBetType.getId(), nameBetType,
						userData.getTimeZone()));
			}
		}
		LOG.debug(new StringBuffer(
				"Se finaliza el controlador CompetitionTabLTController la peticion getBetTypes")
				.toString());
		return result;
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
	@AsynchronousCacheable(CacheRegion.HEAD_COMPETITIONTABLTCONTROLLER)
	@RequestMapping(value = "/getHead", method = RequestMethod.POST)
	@ResponseBody
	public HeadResponseTo getHead(
			@RequestBody final CompetitionRequestTo competitionRequestTo,
			final UserData userData) {
		LOG.debug(new StringBuffer(
				"Se inicia el controlador CompetitionTabLTController la peticion getHead")
				.toString());
		HeadResponseTo result = super.getCompetitionHead(competitionRequestTo,
				userData);
		LOG.debug(new StringBuffer(
				"Se finaliza el controlador CompetitionTabLTController la peticion getHead")
				.toString());
		return result;
	}

	/**
	 * Gets the matchs.
	 * 
	 * @param competitionRequestTo
	 *            the competition request to
	 * @param userData
	 *            the user data
	 * @return the matchs
	 */
	@AsynchronousCacheable(CacheRegion.MATCHS_COMPETITIONTABLTCONTROLLER)
	@RequestMapping(value = "/getMatchs", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getMatchs(
			@RequestBody final CompetitionRequestTo competitionRequestTo,
			final UserData userData) {
		LOG.debug(new StringBuffer(
				"Se inicia el controlador CompetitionTabLTController la peticion getMatchs")
				.toString());
		TableResponseTo result = new TableResponseTo();

		List<RtMatch> matchs = getMatchService()
				.getMatchsByCompetitionFilteredByBetType(
						competitionRequestTo.getCompetitionId().getId());
		LOG.debug(new StringBuffer(
				"Se recuperan los matchs de base de datos, un total de ")
				.append(matchs.size()).append(" matchs.").toString());

		for (RtMatch match : matchs) {
			if (containsBetTypeForCompetitionLT(match)
					&& super.isLongTerm(match)) {
				result.add(createTreeRow(match.getMatchId().getCompetition()
						.getRegion().getResource().getLocation(), match
						.getObjectId().toString(), match.getObjectId()
						.toString(), null, match.getName(userData.getLocale()),
						userData.getTimeZone(), getNumBetType(match)));
			}
		}

		if (result != null && result.getRows() != null) {
			Collections.sort(result.getRows(), new SortRowsByLinkText());
		}

		LOG.debug(new StringBuffer(
				"Se finaliza de crear todas las filas para el TableResponseTo.")
				.toString());
		LOG.debug(new StringBuffer(
				"Se finaliza el controlador CompetitionTabLTController la peticion getMatchs")
				.toString());
		return result;
	}

}
