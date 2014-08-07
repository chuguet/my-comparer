/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.core.util.IUtilBets;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.RowComparator;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class AbstractMakeTableCore.
 */
public abstract class AbstractMakeTableShortTerm implements IMakeTableShortTerm {

	/** The NUMBE r_ digit s_ be t_ format. */
	protected static int NUMBER_DIGITS_BET_FORMAT = 2;

	/** The sdf. */
	private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"dd/MM/yyyy");

	/** The url conversor. */
	protected IUrlConversor urlConversor;

	/** The url factory. */
	@Inject
	protected IUrlFactory urlFactory;

	/** The util bets. */
	@Inject
	private IUtilBets utilBets;

	/**
	 * Clasify matchs by date.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param pInformationWindow
	 * @return the map
	 */
	protected Map<String, List<RtMatch>> clasifyMatchsByDate(
			List<RtMatch> matchs, UserData userData) {
		Map<String, List<RtMatch>> map = new HashMap<String, List<RtMatch>>();
		Date date;
		for (RtMatch match : matchs) {
			date = match.getMatchId().getStartDate().getZeroGmtMatchDate();
			date = DateUtilJava.convertSistemDependentDateToDesiredTimeZone(
					date, userData.getTimeZone());

			String strDate = DATE_FORMATTER.format(date);

			if (map.containsKey(strDate)) {
				matchs = map.get(strDate);
			} else {
				matchs = new ArrayList<RtMatch>();
			}
			if (matchHasSomeBetType(match, getBetTypeId())) {
				matchs.add(match);
			}
			if (!matchs.isEmpty()) {
				map.put(strDate, matchs);
			}
		}
		return map;
	}

	/**
	 * Creates the cell date.
	 * 
	 * @param betType
	 *            the bet type
	 * @param locale
	 *            the locale
	 * @return the table response cell to
	 */

	protected TableResponseCellTo createCellBetType(CfgBetType betType,
			Locale locale) {
		TableResponseCellTo result = new TableResponseCellTo();

		result.setId(new ObjectToId(betType.getObjectId().toString()));

		ValueTo value = new ValueTo();
		value.setValueStr(betType.getName(locale));
		result.setValueTo(value);

		return result;
	}

	/**
	 * Creates the cell date.
	 * 
	 * @param date
	 *            the date
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createCellDate(String date) {
		TableResponseCellTo result = new TableResponseCellTo();

		ValueTo value = new ValueTo();
		value.setDate(date);
		result.setValueTo(value);

		return result;
	}

	/**
	 * Creates the cell name match.
	 * 
	 * @param nameMatch
	 *            the name match
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellNameMatch(String nameMatch,
			ObjectToId idMatch, ObjectToId idBetType, ObjectToId idBetTypeEvent) {
		TableResponseCellTo result = new TableResponseCellTo();

		LinkTo link = new LinkTo(nameMatch, idMatch, idBetType);
		if(idBetTypeEvent!=null) {
			link.setObjectToIdAux2(idBetTypeEvent);
		}
		result.setLinkTo(link);

		return result;
	}

	/**
	 * Creates the one table by common date matchs.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param informationWindow
	 *            the information window
	 * @return the table response to {@inheritDoc}
	 */
	protected TableResponseTo createOneTableByCommonDateMatchs(
			List<RtMatch> matchs, InformationWindow informationWindow) {
		TableResponseTo table = new TableResponseTo();

		TableResponseRowTitleTo title = getTitle(matchs, informationWindow
				.getUserData().getTimeZone(), informationWindow.getUserData()
				.getLocale());
		table.setTitle(title);

		ObjectToId idTable = getIdTable(matchs);
		table.setObjectToId(idTable);

		List<TableResponseRowTo> rows = getRowsFromMatchs(matchs,
				informationWindow);
		Collections.sort(rows, new RowComparator());
		table.setRows(rows);

		return table;
	}

	/**
	 * Creates the tables.
	 * 
	 * @param map
	 *            the map
	 * @param informationWindow
	 *            the information window
	 * @return the list
	 */
	protected List<TableResponseTo> createTables(
			Map<String, List<RtMatch>> map, InformationWindow informationWindow) {
		TableResponseTo tableResponseTo;
		List<RtMatch> listMatchs;
		List<TableResponseTo> result = new ArrayList<TableResponseTo>();

		for (String itDate : map.keySet()) {
			listMatchs = map.get(itDate);
			tableResponseTo = createOneTableByCommonDateMatchs(listMatchs,
					informationWindow);
			result.add(tableResponseTo);
		}

		return result;
	}

	/**
	 * Gets the bets to show.
	 * 
	 * @param bets
	 *            the bets
	 * @param locale
	 *            the locale
	 * @return the bets to show
	 */
	protected abstract List<TableResponseCellTo> getBetsToShow(Set<RtBet> bets,
			Locale locale, String categoryAnalytics);

	/**
	 * Gets the bet type.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param betTypeId
	 *            the bet type id
	 * @return the bet type
	 */
	protected CfgBetType getBetType(List<RtMatch> matchs, CfgBetTypeId betTypeId) {
		CfgBetType result = null;

		for (RtMatch match : matchs) {
			for (RtMarket market : match.getRtMarkets()) {
				if (market.getBetType().getNameId().equals(betTypeId.nameId())) {
					result = market.getBetType();
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Gets the fecha.
	 * 
	 * @param match
	 *            the match
	 * @param timeZone
	 *            the time zone
	 * @return the fecha
	 */
	protected String getFecha(RtMatch match, TimeZone timeZone) {
		Date dateAux = DateUtilJava
				.convertSistemDependentDateToDesiredTimeZone(match.getMatchId()
						.getStartDate().getZeroGmtMatchDate(), timeZone);
		return DateUtilJava.dateToString(dateAux);
	}

	/**
	 * Gets the fecha hora.
	 * 
	 * @param date
	 *            the date
	 * @param timeZone
	 *            the time zone
	 * @param locale
	 *            the locale
	 * @return the fecha hora
	 */
	protected abstract String getFechaHora(Date date, TimeZone timeZone,
			Locale locale);

	/**
	 * Gets the id table.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the id table
	 */
	private ObjectToId getIdTable(List<RtMatch> matchs) {
		ObjectToId result = new ObjectToId();
		if (matchs != null && !matchs.isEmpty()) {
			result.setId(matchs.get(0).getMatchId().getStartDate()
					.getZeroGmtMatchDate().toString());
		}
		return result;
	}

	/**
	 * Gets the row from match.
	 * 
	 * @param match
	 *            the match
	 * @param informationWindow
	 *            the information window
	 * @return the row from match
	 */
	private TableResponseRowTo getRowFromMatch(RtMatch match,
			InformationWindow informationWindow) {
		TableResponseRowTo result = new TableResponseRowTo();
		TableResponseCellTo cell;

		List<TableResponseCellTo> cells = new ArrayList<TableResponseCellTo>();

		// HORA
		String hora = getFechaHora(match.getMatchId().getStartDate()
				.getZeroGmtMatchDate(), informationWindow.getUserData()
				.getTimeZone(), informationWindow.getUserData().getLocale());
		cell = createCellDate(hora);
		cells.add(cell);

		// NOMBRE DEL MATCH
		Iterator<RtMarket> iteMarketsMatch =match.getRtMarkets().iterator();
		ObjectToId betTypeEventId =null;
		if(iteMarketsMatch.hasNext()) {
			RtMarket oneOnlyMarket = iteMarketsMatch.next();
			RtBetTypeEvent rtBetTypeEvent = oneOnlyMarket.getBetTypeEvent();
			betTypeEventId = new ObjectToId(rtBetTypeEvent.getBetTypeEvent().getObjectId().toString());
		}
		
		cell = createCellNameMatch(match.getName(informationWindow
				.getUserData().getLocale()), new ObjectToId(match.getObjectId()
				.toString()), new ObjectToId(getBetTypeId().id()), betTypeEventId);
		cells.add(cell);

		// APUESTAS
		RtMarket market = null;
		CfgBetTypeId cfgBetTypeId = getBetTypeId();
		if(!cfgBetTypeId.nameId().equals(CfgBetTypeId.UNO_X_DOS.nameId())) {
			market = utilBets.getMarketByIdAndBetTypeEvent(match,
					getBetTypeId(), CfgBetTypeEventId.PARTIDO_COMPLETO);
			if(market==null) {
				market = utilBets.getMarketByIdAndBetTypeEvent(match,
						getBetTypeId(), CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA);
			}
		} else {
			market = utilBets.getMarketByIdAndBetTypeEvent(match,
					getBetTypeId(), null);
		}
			
		if (market != null) {
			String categoryAnalytics = match.getMatchId().getCompetition().getSport().getName(null)+match.getMatchId().getCompetition().getName(null)+match.getName(null)+market.getBetType().getNameId();
			Set<RtBet> bets = market.getBets();
			List<TableResponseCellTo> cellsBets = getBetsToShow(bets,
					informationWindow.getUserData().getLocale(), categoryAnalytics);
			cells.addAll(cellsBets);

			result.setObjectToId(new ObjectToId(match.getObjectId().toString()));
			result.setCellList(cells);
		}
		return result;
	}

	/**
	 * Gets the rows from matchs.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param informationWindow
	 *            the information window
	 * @return the rows from matchs
	 */
	private List<TableResponseRowTo> getRowsFromMatchs(List<RtMatch> matchs,
			InformationWindow informationWindow) {
		List<TableResponseRowTo> rows = new ArrayList<TableResponseRowTo>();
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		TableResponseRowTo row;
		for (RtMatch match : matchs) {
			row = getRowFromMatch(match, informationWindow);
			rows.add(row);
		}
		for (TableResponseRowTo auxRow : rows) {
			if (auxRow.getObjectToId() != null) {
				result.add(auxRow);
			}
		}
		return result;
	}

	/**
	 * Gets the title.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param timeZone
	 *            the time zone
	 * @param locale
	 *            the locale
	 * @return the title
	 */
	protected abstract TableResponseRowTitleTo getTitle(List<RtMatch> matchs,
			final TimeZone timeZone, Locale locale);

	/**
	 * Make table.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param informationWindow
	 *            the information window
	 * @return the list {@inheritDoc}
	 */
	public List<TableResponseTo> makeTable(List<RtMatch> matchs,
			InformationWindow informationWindow) {
		List<TableResponseTo> listTableResponseTo;
		Map<String, List<RtMatch>> map;

		map = clasifyMatchsByDate(matchs, informationWindow.getUserData());

		listTableResponseTo = createTables(map, informationWindow);

		listTableResponseTo = formatterOdds(listTableResponseTo);

		listTableResponseTo = sortTables(listTableResponseTo, informationWindow
				.getUserData().getLocale());

		return listTableResponseTo;
	}

	/**
	 * Formatter odds.
	 * 
	 * @param tables
	 *            the tables
	 * @return the list
	 */
	private List<TableResponseTo> formatterOdds(List<TableResponseTo> tables) {
		for (TableResponseTo table : tables) {
			for (TableResponseRowTo row : table.getRows()) {
				for (TableResponseCellTo cell : row.getCellList()) {
					if (cell.getExternalLinkTo() != null
							&& cell.getExternalLinkTo().getLinkText() != null) {
						Double odd = Double.valueOf(cell.getExternalLinkTo()
								.getLinkText());
						cell.getExternalLinkTo().setLinkText(
								FormatterUtil.formatBet(odd,
										NUMBER_DIGITS_BET_FORMAT));
					}
				}
			}
		}

		return tables;
	}

	/**
	 * Sort tables.
	 * 
	 * @param listTableResponseTo
	 *            the list table response to
	 * @param locale
	 *            the locale
	 * @return the list
	 */
	protected abstract List<TableResponseTo> sortTables(
			List<TableResponseTo> listTableResponseTo, Locale locale);

	/**
	 * Match has some bet type.
	 * 
	 * @param match
	 *            the match
	 * @param betTypeId
	 *            the bet type id
	 * @return true, if successful
	 */
	protected boolean matchHasSomeBetType(RtMatch match, CfgBetTypeId betTypeId) {
		boolean result = false;

		for (RtMarket market : match.getRtMarkets()) {
			if (market.getBetType().getNameId().equals(betTypeId.nameId())) {
				result = true;
				break;
			}
		}

		return result;
	}
}
