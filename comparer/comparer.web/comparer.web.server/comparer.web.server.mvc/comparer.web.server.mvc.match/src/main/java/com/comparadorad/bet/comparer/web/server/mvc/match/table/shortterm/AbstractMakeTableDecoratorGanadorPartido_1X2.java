/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;

/**
 * The Class AbstractMakeTableDecoratorGanadorPartido_1X2.
 */
public abstract class AbstractMakeTableDecoratorGanadorPartido_1X2 extends
		AbstractMakeTableShortTerm {

	/**
	 * Creates the cell bet.
	 * 
	 * @param urlBookmaker
	 *            the url bookmaker
	 * @param odd
	 *            the odd
	 * @param imageLocation
	 *            the image location
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellBet(String urlBookmaker, String odd,
			String imageLocation, String bookmakerName, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();

		ExternalLinkTo externalLink = new ExternalLinkTo(urlBookmaker, odd,
				imageLocation, bookmakerName, categoryAnalytics);
		result.setExternalLinkTo(externalLink);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.
	 * tabevent.AbstractMakeTableCompetition#getBetsToShow(java.util.Set,
	 * java.util.Locale)
	 */
	@Override
	protected List<TableResponseCellTo> getBetsToShow(Set<RtBet> bets,
			Locale locale, String categoryAnalytics) {
		List<RtBet> listBets = getGreatestBets(bets);
		List<TableResponseCellTo> result = new ArrayList<TableResponseCellTo>();
		TableResponseCellTo cell;

		for (RtBet bet : listBets) {
			urlConversor = urlFactory.makeUrlConversor(bet.getBookmaker()
					.getObjectId().toString());
			String formattedOdd = FormatterUtil.formatBet(bet.getBetOdd()
					.getOdds(), NUMBER_DIGITS_BET_FORMAT);
			
			// Blindar que pueda venir webUrl a null.
			String theWebUrl = "";			
			if(bet.getWebUrl()==null || bet.getWebUrl().getUrl()==null) {
				Set<CfgBookmakerWebUrl> webUrl = bet.getBookmaker().getBookmakerConfiguration().getBookmakerWebUrl();
				if(webUrl!=null) {
					Iterator<CfgBookmakerWebUrl> iteWebUrl = webUrl.iterator();
					if(iteWebUrl.hasNext()) {
						CfgBookmakerWebUrl cfgWeb = iteWebUrl.next();
						theWebUrl = cfgWeb.getUrl();
					}
				}
			} else {
				theWebUrl = bet.getWebUrl().getUrl();
			}		
			
			cell = createCellBet(
					urlConversor.makeUrl(theWebUrl, bet
							.getBookmaker().getBookmakerConfiguration()
							.getIdAfiliado()), formattedOdd, bet.getBookmaker()
							.getResourceSmallImg().getLocation(), bet.getBookmaker().getNameId(), categoryAnalytics);
			result.add(cell);
		}

		return result;
	}

	/**
	 * Gets the bets.
	 * 
	 * @param bets
	 *            the bets
	 * @return the bets
	 */
	protected abstract List<RtBet> getGreatestBets(Set<RtBet> bets);

	/**
	 * Greater bet.
	 * 
	 * @param pSet
	 *            the set
	 * @return the rt bet
	 */
	protected RtBet greaterBet(Set<RtBet> pSet) {
		RtBet mayor = pSet.iterator().next();
		for (RtBet bet : pSet) {
			if (Double.valueOf(mayor.getBetOdd().getOdds()) < Double
					.valueOf(bet.getBetOdd().getOdds())) {
				mayor = bet;
			}
		}
		return mayor;
	}
}
