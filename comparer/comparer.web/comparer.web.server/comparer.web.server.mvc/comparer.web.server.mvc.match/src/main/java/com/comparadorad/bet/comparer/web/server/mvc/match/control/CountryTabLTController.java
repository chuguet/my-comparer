/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService;
import com.comparadorad.bet.comparer.model.config.service.ICfgRegionService;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.SortRowsByLinkText;
import com.comparadorad.bet.comparer.web.server.mvc.match.factory.IObjectResponseFactory;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.country.tablongterm.IMakeTableCountryLT;

/**
 * The Class CountryLongTermController.
 */
@Controller
@RequestMapping("/countryLongTermController")
public class CountryTabLTController extends AbstractHeadAndCellsCreator {

	/** The factory. */
	@Inject
	private IObjectResponseFactory factory;

	@Inject
	private ICfgRegionService regionService;

	@Inject
	private ICfgCompetitionService competitionService;

	/**
	 * Gets the bet type.
	 * 
	 * @param countryRequestTo
	 *            the country request to
	 * @param userData
	 *            the user data
	 * @return the bet type
	 */
	@AsynchronousCacheable(CacheRegion.COUNTRYLONGTERMBETTYPE_COUNTRYTABLTCONTROLLER)
	@RequestMapping(value = "/getCountryLongTermBetType", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getCountryLongTermBetType(
			@RequestBody final CountryRequestTo countryRequestTo,
			final UserData userData) {
		TableResponseTo result = new TableResponseTo();

		List<RtMatch> matchs = getMatchService()
				.getLongTermCompetition(
						new BigInteger(countryRequestTo.getCompetitionId()
								.getId()));

		List<CfgBetType> betTypes = getBetTypes(matchs);

		for (CfgBetType cfgBetType : betTypes) {
			String nodeId = new StringBuffer()
					.append(countryRequestTo.getCompetitionId().getId())
					.append(cfgBetType.getObjectId().toString()).toString();
			result.add(createTreeRow(null, nodeId, countryRequestTo
					.getCompetitionId().getId(), cfgBetType.getObjectId()
					.toString(), cfgBetType.getName(userData.getLocale()),
					userData.getTimeZone()));
		}
		return result;
	}

	/**
	 * Gets the competition long term.
	 * 
	 * @param countryRequestTo
	 *            the country request to
	 * @param userData
	 *            the user data
	 * @return the competition long term
	 */
	@AsynchronousCacheable(CacheRegion.COUNTRYLONGTERMCOMPETITION_COUNTRYTABLTCONTROLLER)
	@RequestMapping(value = "/getCountryLongTermCompetition", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getCountryLongTermCompetition(
			@RequestBody final CountryRequestTo countryRequestTo,
			final UserData userData) {
		TableResponseTo response = new TableResponseTo();
		BigInteger sportId = new BigInteger(countryRequestTo.getSportId()
				.getId());
		BigInteger countryId = new BigInteger(countryRequestTo.getCountryId()
				.getId());

		CfgRegion region = regionService.findOne(countryId);
		String location = region.getResource().getLocation();

		List<CountryCompetitionEvent> countryCompetitionEvents = competitionService
				.mapReduceGetLevelCountryCompetitionEventLT(sportId, countryId);

		for (CountryCompetitionEvent countryCompetitionEvent : countryCompetitionEvents) {
			Long numEventos = countryCompetitionEvent.getValue().getCounter()
					.longValue();
			String competitionName = countryCompetitionEvent.getValue()
					.getI18n().getI18nField(userData.getLocale()).getString();
			response.add(createTreeRow(location,
					countryCompetitionEvent.getId(),
					countryCompetitionEvent.getId(), null, competitionName,
					userData.getTimeZone(), numEventos.toString()));
		}
		
		if (response != null && response.getRows() != null){
			Collections.sort(response.getRows(), new SortRowsByLinkText());	
		}
		
		return response;
	}

	/**
	 * Gets the competition long term event.
	 * 
	 * @param countryRequestTo
	 *            the country request to
	 * @param userData
	 *            the user data
	 * @return the competition long term event
	 */
	@AsynchronousCacheable(CacheRegion.COUNTRYLONGTERMEVENT_COUNTRYTABLTCONTROLLER)
	@RequestMapping(value = "/getCountryLongTermEvent", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getCountryLongTermEvent(
			@RequestBody final CountryRequestTo countryRequestTo,
			final UserData userData) {

		TableResponseTo result = new TableResponseTo();

		List<RtMarket> markets = getMatchService()
				.getLongTermMarket(
						new BigInteger(countryRequestTo.getCompetitionId()
								.getId()),
						new BigInteger(countryRequestTo.getBetTypeId().getId()));
		InformationWindow info = new InformationWindow();
		info.setUserData(userData);

		if (markets.size() > 0) {
			IMakeTableCountryLT table = factory.makeTableCountryLT(
					markets.get(0).getBetType(), info);
			result = table.makeTable(markets, userData);
		}

		return result;
	}

	/**
	 * Gets the head.
	 * 
	 * @param countryRequestTo
	 *            the country request to
	 * @param userData
	 *            the user data
	 * @return the head
	 */
	@AsynchronousCacheable(CacheRegion.HEAD_COUNTRYTABLTCONTROLLER)
	@RequestMapping(value = "/getHead", method = RequestMethod.POST)
	@ResponseBody
	public HeadResponseTo getHead(
			@RequestBody final CountryRequestTo countryRequestTo,
			final UserData userData) {
		return super.getCountryHead(countryRequestTo, userData);
	}
}
