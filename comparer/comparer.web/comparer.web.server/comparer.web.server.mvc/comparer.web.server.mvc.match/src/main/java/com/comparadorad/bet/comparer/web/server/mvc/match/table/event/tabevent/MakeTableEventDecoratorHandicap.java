/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.beans.AttributeBets;
import com.comparadorad.bet.comparer.web.server.mvc.match.beans.BookmakerBets;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.SortByHandicap;

/**
 * The Class AbstractMakeTableEvent.
 */
public abstract class MakeTableEventDecoratorHandicap extends
		AbstractMakeTableEvent {

	/**
	 * Contains handicap.
	 * 
	 * @param attributesBets
	 *            the attributes bets
	 * @param handicap
	 *            the handicap
	 * @return true, if successful
	 */
	private boolean containsHandicap(List<AttributeBets> attributesBets,
			String handicap) {
		boolean result = false;

		for (AttributeBets attributeBets : attributesBets) {
			if (attributeBets.getHandicap().equals(handicap)) {
				result = true;
			}
		}

		return result;
	}

	/**
	 * Creates the content table.
	 * 
	 * @param market
	 *            the market
	 * @param locale
	 *            the locale
	 * @return the list
	 */
	private List<TableResponseTo> createContentTable(RtMarket market,
			Locale locale, String categoryAnalytics) {
		List<TableResponseTo> result = new ArrayList<TableResponseTo>();
		TableResponseTo table;

		List<AttributeBets> attributesBets = sortBetsByAttribute(market
				.getBets());

		for (AttributeBets attributeBets : attributesBets) {
			table = createTableByAttribute(attributeBets, locale, categoryAnalytics);
			result.add(table);
		}

		return result;
	}

	/**
	 * Creates the rows odds.
	 * 
	 * @param bets
	 *            the bets
	 * @return the list
	 */
	protected abstract List<TableResponseCellTo> createRowsOdds(List<RtBet> bets, String categoryAnalytics);

	/**
	 * Creates the rows odds.
	 * 
	 * @param handicap
	 *            the handicap
	 * @param bookmakersBets
	 *            the bookmakers bets
	 * @param locale
	 *            the locale
	 * @return the list
	 */
	private List<TableResponseRowTo> createRowsOdds(String handicap,
			List<BookmakerBets> bookmakersBets, Locale locale, String categoryAnalytics) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		TableResponseCellTo cell;
		List<TableResponseCellTo> cells;
		TableResponseRowTo row;

		for (BookmakerBets bookmakerBets : bookmakersBets) {
			row = new TableResponseRowTo();
			row.setObjectToId(new ObjectToId(bookmakerBets.getBookmaker()
					.getObjectId().toString()));
			cell = super.createBookmakerCell(bookmakerBets.getBets(), locale, categoryAnalytics);
			row.add(cell);
			cell = super.createCellValueStr(handicap);
			row.add(cell);
			cells = createRowsOdds(bookmakerBets.getBets(), categoryAnalytics);
			row.addAll(cells);
			result.add(row);
		}

		return result;
	}

	/**
	 * Creates the rows probability.
	 * 
	 * @param rowsOdds
	 *            the rows odds
	 * @return the list
	 */
	protected abstract List<TableResponseRowTo> createRowsProbability(
			List<TableResponseRowTo> rowsOdds);

	/**
	 * Creates the table by attribute.
	 * 
	 * @param attributeBets
	 *            the attribute bets
	 * @param locale
	 *            the locale
	 * @return the table response to
	 */
	private TableResponseTo createTableByAttribute(AttributeBets attributeBets,
			Locale locale, String categoryAnalytics) {
		TableResponseTo result = new TableResponseTo();

		String handicap = attributeBets.getHandicap();

		result.setObjectToId(new ObjectToId(handicap));

		List<BookmakerBets> bookmakersBets = super
				.getBetsByBookmaker(attributeBets.getBets());

		List<TableResponseRowTo> rowsOdds = createRowsOdds(handicap,
				bookmakersBets, locale, categoryAnalytics);

		List<TableResponseRowTo> rowsProbability = createRowsProbability(rowsOdds);

		List<TableResponseRowTo> rows = new ArrayList<TableResponseRowTo>();
		rows.addAll(rowsOdds);
		rows.addAll(rowsProbability);
		result.setRows(rows);

		return result;
	}

	/**
	 * Gets the attribute bets.
	 * 
	 * @param attributesBets
	 *            the attributes bets
	 * @param handicap
	 *            the handicap
	 * @return the attribute bets
	 */
	private AttributeBets getAttributeBets(List<AttributeBets> attributesBets,
			String handicap) {
		AttributeBets result = null;

		for (AttributeBets attributeBets : attributesBets) {
			if (attributeBets.getHandicap().equals(handicap)) {
				result = attributeBets;
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent
	 * .IMakeTableEvent
	 * #makeTable(com.comparadorad.bet.comparer.model.bet.bean.RtMatch,
	 * com.comparadorad
	 * .bet.comparer.web.server.mvc.core.beans.InformationWindow,
	 * java.lang.String)
	 */
	@Override
	public List<TableResponseTo> makeTable(RtMatch match,
			InformationWindow informationWindow, String betTypeEventId) {
		List<TableResponseTo> result = new ArrayList<TableResponseTo>();

		for (RtMarket market : match.getRtMarkets()) {
			if (market.getBetType().getNameId().equals(getBetTypeId().nameId())
					&& market.getBetTypeEvent().getBetTypeEvent().getObjectId()
							.toString().equals(betTypeEventId)) {
				String categoryAnalytics = match.getMatchId().getCompetition().getSport().getName(null)+match.getMatchId().getCompetition().getName(null)+match.getName(null)+market.getBetType().getNameId();
				result = createContentTable(market, informationWindow
						.getUserData().getLocale(), categoryAnalytics);
			}
		}
		return result;
	}

	/**
	 * Sort bets by attribute.
	 * 
	 * @param bets
	 *            the bets
	 * @return the list
	 */
	private List<AttributeBets> sortBetsByAttribute(Set<RtBet> bets) {
		List<AttributeBets> result = new ArrayList<AttributeBets>();
		String handicap;
		AttributeBets attributeBets;

		for (RtBet bet : bets) {
			handicap = FormatterUtil.formatBetHandicap(bet.getAttribute()
					.getFinalValue());
			if (containsHandicap(result, handicap)) {
				attributeBets = getAttributeBets(result, handicap);
				attributeBets.getBets().add(bet);
			} else {
				attributeBets = new AttributeBets();
				Set<RtBet> betsAttribute = new HashSet<RtBet>();
				betsAttribute.add(bet);
				attributeBets.setBets(betsAttribute);
				attributeBets.setAttribute(bet.getAttribute());
				attributeBets.setHandicap(handicap);
				result.add(attributeBets);
			}
		}
		Collections.sort(result, new SortByHandicap());

		return result;
	}

}
