/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.util.IUtilBets;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.CellsOrderByOddComparator;

/**
 * The Class AbstractMakeTableDecoratorGanador.
 */
public abstract class AbstractMakeTableDecoratorGanador extends
		AbstractMakeTableShortTerm {

	/** The util bets. */
	@Inject
	private IUtilBets utilBets;

	/** The Constant LIMIT_BETS. */
	private static final Integer LIMIT_BETS = 3;

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
		List<RtBet> listBets = utilBets.getGreaterBetsLimit(bets, LIMIT_BETS);
		List<TableResponseCellTo> result = new ArrayList<TableResponseCellTo>();
		TableResponseCellTo cell;

		for (RtBet bet : listBets) {
			urlConversor = urlFactory.makeUrlConversor(bet.getBookmaker()
					.getObjectId().toString());
			String formattedOdd = FormatterUtil.formatBet(bet.getBetOdd()
					.getOdds(), NUMBER_DIGITS_BET_FORMAT);
			cell = createCellBet(
					urlConversor.makeUrl(bet.getWebUrl().getUrl(), bet
							.getBookmaker().getBookmakerConfiguration()
							.getIdAfiliado()), formattedOdd, bet.getBookmaker()
							.getResourceSmallImg().getLocation(),
					bet.getParticipant().getCfgParticipant().getName(locale), bet.getBookmaker().getNameId(), categoryAnalytics);
			result.add(cell);
		}
		Collections.sort(result, new CellsOrderByOddComparator());
		return result;
	}

	/**
	 * Creates the cell bet.
	 * 
	 * @param urlBookmaker
	 *            the url bookmaker
	 * @param odd
	 *            the odd
	 * @param imageLocation
	 *            the image location
	 * @param nameParticipant
	 *            the name participant
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellBet(String urlBookmaker, String odd,
			String imageLocation, String nameParticipant, String bookmakerName, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();

		ExternalLinkTo externalLink = new ExternalLinkTo(urlBookmaker, odd,
				imageLocation, bookmakerName, categoryAnalytics);
		result.setExternalLinkTo(externalLink);
		ValueTo value = new ValueTo();
		value.setValueStr(nameParticipant);
		result.setValueTo(value);

		return result;
	}

}
