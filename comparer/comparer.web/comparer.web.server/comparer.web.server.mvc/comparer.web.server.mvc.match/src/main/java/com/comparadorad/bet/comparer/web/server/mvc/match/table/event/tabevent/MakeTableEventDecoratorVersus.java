/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.beans.BookmakerBets;

/**
 * The Class MakeTableEventDecoratorNoList.
 */
public abstract class MakeTableEventDecoratorVersus extends
		AbstractMakeTableEvent {

	/**
	 * Creates the cell local.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createCellLocal(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (bet.getParticipant().isAwayParticipant() == false
					&& bet.getParticipant().isHomeParticipant() == true) {
				
				String urlBookmaker = getUrlBookmaker(bet.getBookmaker()
						.getObjectId().toString(), /*bet.getWebUrl().getUrl()*/getUrl(bet),
						bet.getBookmaker().getBookmakerConfiguration()
								.getIdAfiliado());

				ExternalLinkTo externalLinkTo = new ExternalLinkTo();
				externalLinkTo.setUrl(urlBookmaker);
				externalLinkTo.setLinkText(FormatterUtil.formatBet(
						Double.valueOf(bet.getBetOdd().getOdds()), DECIMAL_2));
				externalLinkTo.setActionAnalytics(bet.getBookmaker().getNameId());
				externalLinkTo.setCategoryAnalytics(categoryAnalytics);
				result.setExternalLinkTo(externalLinkTo);
			}
		}
		return result;
	}

	/**
	 * Creates the cell visitante.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createCellVisitante(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (bet.getParticipant().isAwayParticipant() == true
					&& bet.getParticipant().isHomeParticipant() == false) {
				
				String urlBookmaker = getUrlBookmaker(bet.getBookmaker()
						.getObjectId().toString(), /*bet.getWebUrl().getUrl()*/ getUrl(bet),
						bet.getBookmaker().getBookmakerConfiguration()
								.getIdAfiliado());

				ExternalLinkTo externalLinkTo = new ExternalLinkTo();
				externalLinkTo.setUrl(urlBookmaker);
				externalLinkTo.setLinkText(FormatterUtil.formatBet(
						Double.valueOf(bet.getBetOdd().getOdds()), DECIMAL_2));
				externalLinkTo.setActionAnalytics(bet.getBookmaker().getNameId());
				externalLinkTo.setCategoryAnalytics(categoryAnalytics);
				result.setExternalLinkTo(externalLinkTo);
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
	private List<TableResponseRowTo> createContentTable(RtMarket market,
			Locale locale, String categoryAnalytics) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		List<BookmakerBets> bookmakerBets = getBetsByBookmaker(market.getBets());

		List<TableResponseRowTo> rowsOdds = createRowsOdds(bookmakerBets,
				locale, categoryAnalytics);
		result.addAll(rowsOdds);

		List<TableResponseRowTo> rowsProbability = createRowsProbability(rowsOdds);
		result.addAll(rowsProbability);

		return result;
	}

	/**
	 * Creates the rows odds.
	 * 
	 * @param bookmakersBets
	 *            the bookmakers bets
	 * @param locale
	 *            the locale
	 * @return the list
	 */
	protected abstract List<TableResponseRowTo> createRowsOdds(
			List<BookmakerBets> bookmakersBets, Locale locale, String categoryAnalytics);

	/**
	 * Creates the rows probability.
	 * 
	 * @param rowsOdds
	 *            the rows odds
	 * @return the list
	 */
	protected abstract List<TableResponseRowTo> createRowsProbability(
			List<TableResponseRowTo> rowsOdds);

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
		TableResponseTo table = new TableResponseTo();
		table.setObjectToId(new ObjectToId(match.getObjectId().toString()));
		List<TableResponseRowTo> rows;

		for (RtMarket market : match.getRtMarkets()) {
			if (market.getBetType().getNameId().equals(getBetTypeId().nameId())
					&& market.getBetTypeEvent().getBetTypeEvent().getObjectId()
							.toString().equals(betTypeEventId)) {
				String categoryAnalytics = match.getMatchId().getCompetition().getSport().getName(null)+match.getMatchId().getCompetition().getName(null)+match.getName(null)+market.getBetType().getNameId();
				rows = createContentTable(market, informationWindow
						.getUserData().getLocale(), categoryAnalytics);
				table.setRows(rows);
				result.add(table);
			}
		}
		return result;
	}
}
