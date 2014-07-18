/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService;
import com.comparadorad.bet.comparer.model.config.service.ICfgRegionService;
import com.comparadorad.bet.comparer.model.config.service.ICfgSportService;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.IUtilCache;
import com.comparadorad.bet.comparer.util.cache.aop.ICacheUpdateAsync;
import com.comparadorad.bet.comparer.util.cache.config.CacheConfig;
import com.comparadorad.bet.comparer.util.cache.exception.AsynchronousCacheException;
import com.comparadorad.bet.comparer.util.cache.exception.ElemementNotFoundException;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.EventRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.SportRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;

/**
 * The Class AbstractHeadAndCellsCreator.
 */
public class AbstractHeadAndCellsCreator extends AbstractOdds {

	/** The region service. */
	@Inject
	private ICfgRegionService regionService;

	/** The sport service. */
	@Inject
	private ICfgSportService sportService;

	/** The util cache */
	@Inject
	private IUtilCache utilCache;

	/** The cache config. */
	@Inject
	private CacheConfig cacheConfig;

	@Inject
	private ICfgCompetitionService competitionService;

	/** The cache update async. */
	@Inject
	private ICacheUpdateAsync cacheUpdateAsync;

	@Inject
	private EventAsyncBean eventAsyncBean;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractHeadAndCellsCreator.class);

	/**
	 * Contains bet type event.
	 * 
	 * @param betTypesEvents
	 *            the bet types events
	 * @param pBetTypeEvent
	 *            the bet type event
	 * @return true, if successful
	 */
	protected boolean containsBetTypeEvent(
			List<CfgBetTypeEvent> betTypesEvents, CfgBetTypeEvent pBetTypeEvent) {
		boolean result = false;
		for (CfgBetTypeEvent betTypeEvent : betTypesEvents) {
			if (pBetTypeEvent.getObjectId().toString()
					.equals(betTypeEvent.getObjectId().toString())) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Contains bet type for competition lt.
	 * 
	 * @param match
	 *            the match
	 * @return true, if successful
	 */
	protected boolean containsBetTypeForCompetitionLT(RtMatch match) {
		boolean result = false;

		for (RtMarket market : match.getRtMarkets()) {
			if (isBetTypeForCompetitionLT(market)) {
				result = true;
				break;
			}
		}

		return result;
	}

	/**
	 * Contains market.
	 * 
	 * @param markets
	 *            the markets
	 * @param pMarket
	 *            the market
	 * @return true, if successful
	 */
	private boolean containsMarket(Set<RtMarket> markets, RtMarket pMarket) {
		boolean result = false;
		for (RtMarket market : markets) {
			if (market.getBetType().getObjectId().toString()
					.equals(pMarket.getBetType().getObjectId().toString())) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Creates the cell competition.
	 * 
	 * @param nameCompetition
	 *            the name competition
	 * @param idCompetition
	 *            the id competition
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellCompetition(String nameCompetition,
			String idCompetition) {
		TableResponseCellTo cell = new TableResponseCellTo();
		cell.setId(new ObjectToId(idCompetition));
		ValueTo valueTo = new ValueTo();
		valueTo.setValueStr(nameCompetition);
		cell.setValueTo(valueTo);
		return cell;
	}

	/**
	 * Creates the cell empty.
	 * 
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellEmpty() {
		TableResponseCellTo cell = new TableResponseCellTo();
		return cell;
	}

	/**
	 * Creates the cell eventos.
	 * 
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellEventos() {
		TableResponseCellTo cell = new TableResponseCellTo();
		return cell;
	}

	/**
	 * Creates the cell location.
	 * 
	 * @param location
	 *            the location
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellLocation(String location) {
		TableResponseCellTo cell = new TableResponseCellTo();
		cell.add(new ResourceTo(location));
		return cell;
	}

	/**
	 * Creates the cell match name.
	 * 
	 * @param match
	 *            the match
	 * @param locale
	 *            the locale
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createCellMatchName(RtMatch match,
			Locale locale) {
		TableResponseCellTo cell = new TableResponseCellTo();
		cell.setLinkTo(new LinkTo(match.getName(locale), new ObjectToId(match
				.getObjectId().toString())));
		return cell;
	}

	/**
	 * Creates the cell num bet types.
	 * 
	 * @param match
	 *            the match
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createCellNumBetTypes(RtMatch match) {
		TableResponseCellTo cell = new TableResponseCellTo();
		ValueTo value = new ValueTo();
		String numBetTypes = getNumBetType(match);
		value.setValueStr(numBetTypes);
		cell.setValueTo(value);
		return cell;
	}

	/**
	 * Creates the cell num eventos.
	 * 
	 * @param numEventos
	 *            the num eventos
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellNumEventos(String numEventos) {
		TableResponseCellTo cell = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();
		valueTo.setValueStr(numEventos);
		cell.setValueTo(valueTo);
		return cell;
	}

	/**
	 * Creates the cell region location.
	 * 
	 * @param match
	 *            the match
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createCellRegionLocation(RtMatch match) {
		TableResponseCellTo cell = new TableResponseCellTo();
		cell.add(new ResourceTo(match.getMatchId().getCompetition().getRegion()
				.getResource().getLocation()));
		return cell;
	}

	/**
	 * Creates the new row competition long term.
	 * 
	 * @param location
	 *            the location
	 * @param nameCompetition
	 *            the name competition
	 * @param idCompetition
	 *            the id competition
	 * @param numEventos
	 *            the num eventos
	 * @return the table response row to
	 */
	protected TableResponseRowTo createNewRowCompetitionLongTerm(
			String location, String nameCompetition, String idCompetition,
			String numEventos) {
		TableResponseRowTo result = new TableResponseRowTo();
		List<TableResponseCellTo> cells = new ArrayList<TableResponseCellTo>();
		TableResponseCellTo cell;

		cell = createCellLocation(location);
		cells.add(cell);
		cell = createCellCompetition(nameCompetition, idCompetition);
		cells.add(cell);
		cell = createCellEmpty();
		cells.add(cell);
		cell = createCellEmpty();
		cells.add(cell);
		cell = createCellNumEventos(numEventos);
		cells.add(cell);
		cell = createCellEventos();
		cells.add(cell);

		result.setCellList(cells);
		return result;
	}

	/**
	 * Creates the row.
	 * 
	 * @param numCompetitions
	 *            the num competitions
	 * @param numEventos
	 *            the num eventos
	 * @param location
	 *            the location
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param timeZone
	 *            the time zone
	 * @return the table response row to
	 */
	protected TableResponseRowTo createRow(final String numCompetitions,
			final String numEventos, final String location,
			final BigInteger id, final String name, final TimeZone timeZone) {
		TableResponseRowTo row = getNewRow();
		row.add(getNewCell(null, null, location, null, null, null, null,
				timeZone));
		row.add(getNewCell(new ObjectToId(id.toString()), name, null, null,
				null, null, null, timeZone));
		if (numCompetitions != null) {
			row.add(getNewCell(null, numCompetitions.toString(), null, null,
					null, null, null, timeZone));
			row.add(getNewCell(null, null, null, null, null, null, null,
					timeZone));
		} else {
			row.add(getNewCell(null, null, null, null, null, null, null,
					timeZone));
			row.add(getNewCell(null, null, null, null, null, null, null,
					timeZone));
		}
		if (numEventos != null) {
			row.add(getNewCell(null, numEventos.toString(), null, null, null,
					null, null, timeZone));
			row.add(getNewCell(null, null, null, null, null, null, null,
					timeZone));
		} else {
			row.add(getNewCell(null, null, null, null, null, null, null,
					timeZone));
			row.add(getNewCell(null, null, null, null, null, null, null,
					timeZone));
		}
		return row;
	}

	/**
	 * Creates the row id.
	 * 
	 * @param match
	 *            the match
	 * @return the table response row to
	 */
	protected TableResponseRowTo createRowId(RtMatch match) {
		TableResponseRowTo row = new TableResponseRowTo();
		row.setObjectToId(new ObjectToId(match.getObjectId().toString()));
		return row;
	}

	/**
	 * Creates the tree row.
	 * 
	 * @param location
	 *            the location
	 * @param nodeId
	 *            the node id
	 * @param linkId
	 *            the link id
	 * @param linkIdAux
	 *            the link id aux
	 * @param name
	 *            the name
	 * @param timeZone
	 *            the time zone
	 * @param num
	 *            the num
	 * @return the table response row to
	 */
	protected TableResponseRowTo createTreeRow(final String location,
			final String nodeId, final String linkId, final String linkIdAux,
			final String name, final TimeZone timeZone, final String... num) {
		TableResponseRowTo row = getNewRow();
		row.setObjectToId(new ObjectToId(nodeId));

		if (location != null) {
			row.add(getNewCell(null, null, location, null, null, null, null,
					timeZone));
		}

		LinkTo link = new LinkTo(name, new ObjectToId(linkId), new ObjectToId(
				linkIdAux));
		row.add(getNewCell(null, null, null, null, link, null, null, timeZone));

		for (String n : num) {
			row.add(getNewCell(null, n, null, null, null, null, null, timeZone));
		}

		return row;
	}

	/**
	 * Gets the bet types.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the bet types
	 */
	protected List<CfgBetType> getBetTypes(List<RtMatch> matchs) {
		List<CfgBetType> result = new ArrayList<CfgBetType>();
		boolean found = false;
		for (RtMatch rtMatch : matchs) {
			for (RtMarket rtMarket : rtMatch.getRtMarkets()) {
				for (CfgBetType cfgBetType : result) {
					if (cfgBetType.getObjectId().equals(
							rtMarket.getBetType().getObjectId())) {
						found = true;
						break;
					}
				}
				if (!found) {
					result.add(rtMarket.getBetType());
				}
				found = false;
			}
		}

		return result;
	}

	/**
	 * Gets the competition head.
	 * 
	 * @param competitionRequestTo
	 *            the competition request to
	 * @param userData
	 *            the user data
	 * @return the competition head
	 */
	protected HeadResponseTo getCompetitionHead(
			@RequestBody final CompetitionRequestTo competitionRequestTo,
			final UserData userData) {
		HeadResponseTo result = new HeadResponseTo();

		CfgCompetition competition = competitionService.findOne(new BigInteger(
				competitionRequestTo.getCompetitionId().getId()));

		result.setResourceTo(new ResourceTo(competition.getRegion()
				.getResource().getLocation()));
		result.setTitle(competition.getName(userData.getLocale()));

		LinkTo linkSport = new LinkTo(competition.getSport().getName(
				userData.getLocale()), new ObjectToId(competition.getSport()
				.getObjectId().toString()));
		result.add(linkSport);
		LinkTo linkCountry = new LinkTo(competition.getRegion().getName(
				userData.getLocale()), new ObjectToId(competition.getRegion()
				.getObjectId().toString()), new ObjectToId(competition
				.getSport().getObjectId().toString()));
		result.add(linkCountry);
		LinkTo linkCompetition = new LinkTo(competition.getName(userData
				.getLocale()), new ObjectToId(competition.getObjectId()
				.toString()));
		result.add(linkCompetition);

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
	protected HeadResponseTo getCountryHead(
			@RequestBody final CountryRequestTo countryRequestTo,
			final UserData userData) {
		HeadResponseTo result = new HeadResponseTo();
		LinkTo linkTo;
		CfgSport sport = sportService.findOne(new BigInteger(countryRequestTo
				.getSportId().getId()));
		CfgRegion region = regionService.findOne(new BigInteger(
				countryRequestTo.getCountryId().getId()));

		linkTo = new LinkTo();
		linkTo.setName(sport.getName(userData.getLocale()));
		linkTo.setObjectToId(new ObjectToId(sport.getObjectId().toString()));
		result.add(linkTo);

		linkTo = new LinkTo();
		linkTo.setName(region.getName(userData.getLocale()));
		result.add(linkTo);

		result.setResourceTo(new ResourceTo(region.getResource().getLocation()));
		result.setTitle(region.getName(userData.getLocale()));

		return result;
	}

	/**
	 * Gets the head.
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param userData
	 *            the user data
	 * @return the head {@inheritDoc}
	 */
	protected HeadResponseTo getEventHead(
			@RequestBody final EventRequestTo eventRequestTo,
			final UserData userData) {
		HeadResponseTo result = new HeadResponseTo();

		// Reduce query version
		// RtMatch match =
		// getMatchService().findNameAndCompetition(eventRequestTo.getEventId().getId());
		// Reduce query version

		RtMatch match = (RtMatch) getCacheRtMatch(eventRequestTo.getEventId()
				.getId());

		result.setTitle(match.getName(userData.getLocale()));
		result.setResourceTo(new ResourceTo(match.getCompetition().getRegion()
				.getResource().getLocation()));
		Date dateAux = DateUtilJava
				.convertSistemDependentDateToDesiredTimeZone(match.getMatchId()
						.getStartDate().getZeroGmtMatchDate(),
						userData.getTimeZone());
		result.setDate(DateUtilJava.dateTimeToString(dateAux));

		LinkTo linkSport = new LinkTo(match.getCompetition().getSport()
				.getName(userData.getLocale()), new ObjectToId(match
				.getCompetition().getSport().getObjectId().toString()));
		result.add(linkSport);
		LinkTo linkCountry = new LinkTo(match.getCompetition().getRegion()
				.getName(userData.getLocale()), new ObjectToId(match
				.getCompetition().getRegion().getObjectId().toString()),
				new ObjectToId(match.getCompetition().getSport().getObjectId()
						.toString()));
		result.add(linkCountry);
		LinkTo linkCompetition = new LinkTo(match.getCompetition().getName(
				userData.getLocale()), new ObjectToId(match.getCompetition()
				.getObjectId().toString()));
		result.add(linkCompetition);
		LinkTo linkMatch = new LinkTo(match.getName(userData.getLocale()),
				new ObjectToId(match.getCompetition().getObjectId().toString()));
		result.add(linkMatch);

		return result;
	}

	/**
	 * Gets the num bet type.
	 * 
	 * @param match
	 *            the match
	 * @return the num bet type
	 */
	protected String getNumBetType(RtMatch match) {
		Set<RtMarket> markets = new HashSet<RtMarket>();
		for (RtMarket market : match.getRtMarkets()) {
			if (!containsMarket(markets, market) && isLongTermBetType(market)) {
				markets.add(market);
			}
		}
		return String.valueOf(markets.size());
	}

	/**
	 * Gets the sport head.
	 * 
	 * @param sportRequestTo
	 *            the sport request to
	 * @param userData
	 *            the user data
	 * @return the sport head
	 */
	protected HeadResponseTo getSportHead(
			@RequestBody final SportRequestTo sportRequestTo,
			final UserData userData) {
		HeadResponseTo result = new HeadResponseTo();
		LinkTo linkTo;

		CfgSport sport = sportService.findOne(new BigInteger(sportRequestTo
				.getSportId().getId()));

		result.setTitle(sport.getName(userData.getLocale()));

		linkTo = new LinkTo();
		linkTo.setName(sport.getName(userData.getLocale()));
		result.add(linkTo);

		return result;
	}

	/**
	 * Checks if is bet type for competition lt.
	 * 
	 * @param market
	 *            the market
	 * @return true, if is bet type for competition lt
	 */
	protected boolean isBetTypeForCompetitionLT(RtMarket market) {
		boolean result = false;
		if (market.getBetType().getNameId()
				.equals(CfgBetTypeId.GANADOR.nameId())
				|| market.getBetType().getNameId()
						.equals(CfgBetTypeId.MAXIMO_GOLEADOR.nameId())) {
			result = true;
		}
		return result;
	}

	/**
	 * Gets the rtMatch and add it to cache if necessary
	 * 
	 * @param eventRequestTo
	 *            the event request to
	 * @param userData
	 *            the user data
	 * @return the rtMatch
	 */
	protected Object getCacheRtMatch(final String rtMatchId) {
		Object matchResult = null;

		List<Object> keys = Arrays.asList((Object) rtMatchId);
		CacheRegion[] regions = { CacheRegion.RTMATCH_EVENTTABEVENTCONTROLLER };

		try {
			// Search for key
			matchResult = utilCache.find(keys, regions).getObjectValue();

			// Si no se llegó al limite de procesos encolados para
			// actualización,
			// se añade. En caso contrario se ejecuta directamente el método
			LOG.info("Procesos encolados para actualizacion cache AbstractHeadAndCell: "
					+ cacheUpdateAsync.executionSize());
			if (cacheUpdateAsync.executionSize() < cacheConfig
					.getAsyncExecutorBean().getQueueCapacity()) {
				// Update cache
				eventAsyncBean.asyncUpdateRtMatchCache(keys, regions,
						rtMatchId, this, matchResult);
			} else {
				LOG.info("RtMatch not found in asynchronous cache");
				matchResult = getMatchService().findOneCustom(rtMatchId);
				utilCache.add(keys, matchResult, regions);
				LOG.info("RtMatch caching object: " + matchResult.toString());
			}

		} catch (ElemementNotFoundException e) {
			try {
				LOG.info("RtMatch not found in asynchronous cache");
				matchResult = getMatchService().findOneCustom(rtMatchId);
				utilCache.add(keys, matchResult, regions);
				LOG.info("RtMatch caching object: " + matchResult.toString());
			} catch (Throwable e1) {
				LOG.error(e1.getMessage());
			}
		} catch (AsynchronousCacheException e) {
			LOG.error(e.getMessage());
		}

		return matchResult;
	}

}
