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
import java.util.Locale;
import java.util.TimeZone;

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
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportCountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService;
import com.comparadorad.bet.comparer.model.config.service.ICfgRegionService;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.aop.AsynchronousCacheable;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.SportRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.SortRowsByLinkText;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.factory.IObjectResponseFactory;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.IMakeTableShortTerm;

/**
 * The Class SportCountriesController.
 */
@Controller
@RequestMapping("/sportCountriesController")
public class SportTabEventController extends AbstractHeadAndCellsCreator {

	/** The Constant COUNTRY_SMALL_IMG_PATH. */
	public static final String COUNTRY_SMALL_IMG_PATH = "comparer/country/small/";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(SportTabEventController.class);

	/** The competition service. */
	@Inject
	private ICfgCompetitionService competitionService;

	/** The factory. */
	@Inject
	private IObjectResponseFactory factory;

	/** The region service. */
	@Inject
	private ICfgRegionService regionService;

	/**
	 * Gets the head.
	 * 
	 * @param sportRequestTo
	 *            the sport request to
	 * @param userData
	 *            the user data
	 * @return the head
	 */
	@AsynchronousCacheable(CacheRegion.HEAD_SPORTTABEVENTCONTROLLER)
	@RequestMapping(value = "/getHead", method = RequestMethod.POST)
	@ResponseBody
	public HeadResponseTo getHead(
			@RequestBody final SportRequestTo sportRequestTo,
			final UserData userData) {
		return super.getSportHead(sportRequestTo, userData);
	}

	/**
	 * Gets the sport countries competitions.
	 * 
	 * @param sportRequestTo
	 *            the sport request to
	 * @param userData
	 *            the user data
	 * @return the sport countries competitions
	 */
	@AsynchronousCacheable(CacheRegion.SPORTCOUNTRIESCOMPETITIONS_SPORTTABEVENTCONTROLLER)
	@RequestMapping(value = "/getSportCountriesCompetitions", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getSportCountriesCompetitions(
			@RequestBody final SportRequestTo sportRequestTo,
			final UserData userData) {
		LOG.debug("Se inicia el controlador de deporte nivel competiciones");
		TableResponseTo response = new TableResponseTo();
		BigInteger sportId = new BigInteger(sportRequestTo.getSportId().getId());
		BigInteger countryId = new BigInteger(sportRequestTo.getCountryId()
				.getId());

		CfgRegion region = regionService.findOne(countryId);
		String location = region.getResource().getLocation();

		List<CountryCompetitionEvent> countryCompetitionEvents = competitionService
				.mapReduceGetLevelCountryCompetitionEvent(sportId, countryId);

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

		LOG.debug("Se finaliza el controlador de deporte nivel competiciones");
		return response;
	}

	/**
	 * Gets the sport countries countries.
	 * 
	 * @param sportRequestTo
	 *            the sport request to
	 * @param userData
	 *            the user data
	 * @return the sport countries countries
	 */
	@AsynchronousCacheable(CacheRegion.SPORTCOUNTRIESCOUNTRIES_SPORTTABEVENTCONTROLLER)
	@RequestMapping(value = "/getSportCountriesCountries", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getSportCountriesCountries(
			@RequestBody final SportRequestTo sportRequestTo,
			final UserData userData) {
		LOG.debug("Se inicia el controlador de deporte nivel paises");
		
		// Mostrará los países, pero por dentro, esos países deberán tener competiciones 
		// válidas:
		TimeZone timeZone = userData.getTimeZone();
		Locale locale = userData.getLocale();
		TableResponseTo response = new TableResponseTo();
		BigInteger sportId = new BigInteger(sportRequestTo.getSportId().getId());
		List<SportCountryCompetitionEvent> resultMapReduce = competitionService
				.mapReduceGetLevelSportCountryCompetitionEvent(sportId);

		for (SportCountryCompetitionEvent sportCountryCompetitionEvent : resultMapReduce) {
			String location = new StringBuffer(COUNTRY_SMALL_IMG_PATH)
					.append(sportCountryCompetitionEvent.getValue().getRegion()
							.getLocation().toLowerCase()).append(".png")
					.toString();
			response.add(createTreeRow(location, sportCountryCompetitionEvent
					.getId(), sportCountryCompetitionEvent.getId(),
					sportRequestTo.getSportId().getId(),
					sportCountryCompetitionEvent.getValue().getRegion()
							.getI18n().getI18nField(locale).getString(),
					timeZone, String.valueOf(sportCountryCompetitionEvent
							.getValue().getCounterCompetitions().intValue()),
					String.valueOf(sportCountryCompetitionEvent.getValue()
							.getCounterEvents().intValue())));
		}
		
		if (response != null && response.getRows() != null){
			Collections.sort(response.getRows(), new SortRowsByLinkText());	
		}
		
		LOG.debug("Se finaliza el controlador de deporte nivel paises");
		return response;
	}

	/**
	 * Gets the sport countries events.
	 * 
	 * @param sportRequestTo
	 *            the sport request to
	 * @param userData
	 *            the user data
	 * @return the sport countries events
	 */
	@AsynchronousCacheable(CacheRegion.SPORTCOUNTRIESEVENTS_SPORTTABEVENTCONTROLLER)
	@RequestMapping(value = "/getSportCountriesEvents", method = RequestMethod.POST)
	@ResponseBody
	public List<TableResponseTo> getSportCountriesEvents(
			@RequestBody final SportRequestTo sportRequestTo,
			final UserData userData) {
		LOG.debug("Se inicia el controlador de deporte nivel eventos");
		InformationWindow info = new InformationWindow();
		info.setUserData(userData);
		BigInteger idCompetition = new BigInteger(sportRequestTo
				.getCompetitionId().getId());
		String idBetTypeEvent = CfgBetTypeEventId.PARTIDO_COMPLETO.objectId();
		String idBetTypeEventPCP = CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.objectId();
		String idBetType;

		idBetType = CfgBetTypeId.UNO_X_DOS.id();
		List<RtMatch> matchs = getMatchService()
				.mapReduceGetMatchsByCompetition(idCompetition, idBetType,
						idBetTypeEvent, idBetTypeEventPCP);
		if (matchs == null || matchs.isEmpty()) {
			idBetType = CfgBetTypeId.GANADOR_PARTIDO.id();
			matchs = getMatchService()
					.mapReduceGetMatchsByCompetition(idCompetition,
							idBetType, idBetTypeEvent, idBetTypeEventPCP);
			if (matchs == null || matchs.isEmpty()) {
				idBetType = CfgBetTypeId.GANADOR.id();
				matchs = getMatchService()
						.mapReduceGetMatchsByCompetition(idCompetition,
								idBetType, idBetTypeEvent, idBetTypeEventPCP);
			}
		}

		CfgBetType betType = findCfgBetTypeById(idBetType, matchs);

		IMakeTableShortTerm makeTableShortTerm = factory.makeTableShortTerm(
				betType, LevelType.SPORT, info);

		List<TableResponseTo> result = makeTableShortTerm.makeTable(
				super.filterShortTerm(matchs), info);

		LOG.debug("Se finaliza el controlador de deporte nivel eventos");
		return result;
	}

}
