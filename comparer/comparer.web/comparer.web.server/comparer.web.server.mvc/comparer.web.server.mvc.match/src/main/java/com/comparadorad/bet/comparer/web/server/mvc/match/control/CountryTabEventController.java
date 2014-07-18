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

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
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
import com.comparadorad.bet.comparer.web.server.mvc.match.control.filters.RtMatchFilterManager;
import com.comparadorad.bet.comparer.web.server.mvc.match.control.filters.RtMatchFilterShortTerm;
import com.comparadorad.bet.comparer.web.server.mvc.match.control.filters.RtMatchReduceByPCAndPCPFilter;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.factory.IObjectResponseFactory;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.IMakeTableShortTerm;

/**
 * The Class CountryOddsController.
 */
@Controller
@RequestMapping("/countryEventsController")
public class CountryTabEventController extends AbstractHeadAndCellsCreator {

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
	 * Gets the country competition.
	 * 
	 * @param countryRequestTo
	 *            the country request to
	 * @param userData
	 *            the user data
	 * @return the country competition
	 */
	@AsynchronousCacheable(CacheRegion.COUNTRYEVENTSCOMPETITION_COUNTRYTABEVENTCONTROLLER)
	@RequestMapping(value = "/getCountryEventsCompetition", method = RequestMethod.POST)
	@ResponseBody
	public TableResponseTo getCountryEventsCompetition(
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

		return response;
	}

	/**
	 * Gets the country event.
	 * 
	 * @param countryRequestTo
	 *            the country request to
	 * @param userData
	 *            the user data
	 * @return the country event
	 */
	@AsynchronousCacheable(CacheRegion.COUNTRYEVENTSEVENT_COUNTRYTABEVENTCONTROLLER)
	@RequestMapping(value = "/getCountryEventsEvent", method = RequestMethod.POST)
	@ResponseBody
	public List<TableResponseTo> getCountryEventsEvent(
			@RequestBody final CountryRequestTo countryRequestTo,
			final UserData userData) {
		InformationWindow info = new InformationWindow();
		info.setUserData(userData);
		BigInteger idCompetition = new BigInteger(countryRequestTo
				.getCompetitionId().getId());
		String idBetTypeEventPC = CfgBetTypeEventId.PARTIDO_COMPLETO.objectId();
		String idBetTypeEventPCP = CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA
				.objectId();
		
		String idBetType;

		CfgBetTypeId cfgBetTypeId = CfgBetTypeId.UNO_X_DOS;
		idBetType = CfgBetTypeId.UNO_X_DOS.id();
		List<RtMatch> matchs = getMatchService()
				.mapReduceGetMatchsByCompetition(idCompetition, idBetType,
						idBetTypeEventPC, idBetTypeEventPCP);
		if (matchs == null || matchs.isEmpty()) {
			cfgBetTypeId = CfgBetTypeId.GANADOR_PARTIDO;
			idBetType = CfgBetTypeId.GANADOR_PARTIDO.id();
			matchs = getMatchService()
					.mapReduceGetMatchsByCompetition(idCompetition,
							idBetType, idBetTypeEventPC, idBetTypeEventPCP);
			if (matchs == null || matchs.isEmpty()) {
				idBetType = CfgBetTypeId.GANADOR.id();
				matchs = getMatchService()
						.mapReduceGetMatchsByCompetition(idCompetition,
								idBetType, idBetTypeEventPC, idBetTypeEventPCP);
			}
		}
		
		// Aplicar los Filtros:
		matchs = new RtMatchFilterManager<RtMatch>()
				.addFilter(new RtMatchReduceByPCAndPCPFilter())
				.addFilter(new RtMatchFilterShortTerm())
				.applyFiltersChain(matchs);	
		
		//CfgBetType betType = findCfgBetTypeById(idBetType, matchs); // No hace falta buscar, 
		// porque se ha filtrado antes con los if's.
		CfgBetType betType = new CfgBetType();
		betType.setObjectId(cfgBetTypeId.id());
		betType.setNameId(cfgBetTypeId.nameId());

		// Se elige la factoria (devolviendo la interfaz)
		IMakeTableShortTerm makeTableShortTerm = factory.makeTableShortTerm(
				betType, LevelType.COUNTRY, info);

		// Elegida la factoria se construye la tabla con la información:
		List<TableResponseTo> result = makeTableShortTerm.makeTable(
				/*super.filterShortTerm(matchs)*/matchs, info);

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
	@AsynchronousCacheable(CacheRegion.HEAD_COUNTRYTABEVENTCONTROLLER)
	@RequestMapping(value = "/getHead", method = RequestMethod.POST)
	@ResponseBody
	public HeadResponseTo getHead(
			@RequestBody final CountryRequestTo countryRequestTo,
			final UserData userData) {
		return super.getCountryHead(countryRequestTo, userData);
	}

}
