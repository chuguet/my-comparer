/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.tablongterm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.core.util.IUtilBets;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.SortTableByValueStr;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class AbstractMakeTableCompetitionLT.
 */
public abstract class AbstractMakeTableCompetitionLT implements IMakeTableCompetitionLT {

	/** The util bets. */
	@Inject
	private IUtilBets utilBets;

	/** The Constant LIMITE_APUESTAS. */
	private static final Integer LIMITE_APUESTAS = 5;

	/** The Constant NUMBER_DIGITS_BET_FORMAT. */
	private final static int NUMBER_DIGITS_BET_FORMAT = 2;

	/** The url conversor. */
	private IUrlConversor urlConversor;

	/** The url factory. */
	@Inject
	private IUrlFactory urlFactory;

	/**
	 * Creates the cell bookmaker.
	 * 
	 * @param bet
	 *            the bet
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellBookmaker(RtBet bet, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		ExternalLinkTo externalLinkTo = new ExternalLinkTo();
		urlConversor = urlFactory.makeUrlConversor(bet.getBookmaker().getObjectId().toString());
		externalLinkTo.setLinkImgLocation(bet.getBookmaker().getResourceSmallImg().getLocation());
		externalLinkTo.setUrl(urlConversor
				.makeUrl(bet.getWebUrl().getUrl(), bet.getBookmaker().getBookmakerConfiguration().getIdAfiliado()));
		externalLinkTo.setActionAnalytics(bet.getBookmaker().getNameId());
		externalLinkTo.setCategoryAnalytics(categoryAnalytics);
		result.setExternalLinkTo(externalLinkTo);
		return result;
	}

	/**
	 * Creates the cell mean odd.
	 * 
	 * @param bets
	 *            the bets
	 * @param pBet
	 *            the bet
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellMeanOdd(Set<RtBet> bets, RtBet pBet) {
		TableResponseCellTo result = new TableResponseCellTo();
		Double mean = 0.0;
		Double numerador = 0.0;
		Double denominador = 0.0;
		for (RtBet bet : bets) {
			if (bet.getParticipant().getCfgParticipant().getObjectId().toString()
					.equals(pBet.getParticipant().getCfgParticipant().getObjectId().toString())) {
				denominador++;
				numerador += Double.valueOf(bet.getBetOdd().getOdds());
			}
		}
		mean = numerador / denominador;
		ValueTo value = new ValueTo();
		value.setValueStr(FormatterUtil.formatBet(mean, NUMBER_DIGITS_BET_FORMAT));
		result.setValueTo(value);
		return result;
	}

	/**
	 * Creates the cell odd.
	 * 
	 * @param bet
	 *            the bet
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellOdd(RtBet bet) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo value = new ValueTo();
		value.setValueStr(FormatterUtil.formatBet(bet.getBetOdd().getOdds(), NUMBER_DIGITS_BET_FORMAT));
		result.setValueTo(value);
		return result;
	}

	/**
	 * Creates the cell participant.
	 * 
	 * @param bet
	 *            the bet
	 * @param locale
	 *            the locale
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellParticipant(RtBet bet, Locale locale) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo value = new ValueTo();
		value.setValueStr(bet.getParticipant().getCfgParticipant().getName(locale));
		result.setValueTo(value);
		return result;
	}

	/**
	 * Creates the cells bookmaker.
	 * 
	 * @param bets
	 *            the bets
	 * @param pBet
	 *            the bet
	 * @return the list
	 */
	private List<TableResponseCellTo> createCellsBookmaker(Set<RtBet> bets, RtBet pBet, String categoryAnalytics) {
		List<TableResponseCellTo> result = new ArrayList<TableResponseCellTo>();
		TableResponseCellTo cell;
		for (RtBet bet : bets) {
			if (!containsSameBookmaker(result, bet.getBookmaker().getResourceSmallImg().getLocation())
					&& bet.getParticipant().getCfgParticipant().getObjectId().toString()
							.equals(pBet.getParticipant().getCfgParticipant().getObjectId().toString())
					&& bet.getBetOdd().getOdds().equals(pBet.getBetOdd().getOdds()) && result.size() < 3) {
				cell = createCellBookmaker(bet, categoryAnalytics);
				result.add(cell);
			}
		}
		return result;
	}

	private boolean containsSameBookmaker(List<TableResponseCellTo> cells, String location) {
		boolean result = false;
		for (TableResponseCellTo cell : cells) {
			if (cell.getExternalLinkTo().getLinkImgLocation().equals(location)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.
	 * tablongterm
	 * .IMakeTableCompetitionLT#makeTable(com.comparadorad.bet.comparer
	 * .model.bet.bean.RtMatch,
	 * com.comparadorad.bet.comparer.web.server.mvc.core
	 * .beans.InformationWindow)
	 */
	@Override
	public TableResponseTo makeTable(RtMatch match, InformationWindow informationWindow) {
		TableResponseTo result = new TableResponseTo();
		TableResponseRowTo row;
		TableResponseCellTo cell;
		List<TableResponseCellTo> cellsBookmaker;

		RtMarket market = utilBets.getMarketByIdAndBetTypeEvent(match, getBetTypeId(), CfgBetTypeEventId.PARTIDO_COMPLETO);
		List<RtBet> listBets = utilBets.getGreaterBetsLimit(market.getBets(), LIMITE_APUESTAS);
		String categoryAnalytics = match.getMatchId().getCompetition().getSport().getName(null)
				+ match.getMatchId().getCompetition().getName(null) + match.getName(null) + market.getBetType().getNameId();
		for (RtBet bet : listBets) {
			row = new TableResponseRowTo();
			row.setObjectToId(new ObjectToId(bet.getParticipant().getCfgParticipant().getObjectId().toString()));

			cell = createCellParticipant(bet, informationWindow.getUserData().getLocale());
			row.add(cell);

			cell = createCellMeanOdd(market.getBets(), bet);
			row.add(cell);

			cell = createCellOdd(bet);
			row.add(cell);

			cellsBookmaker = createCellsBookmaker(market.getBets(), bet, categoryAnalytics);
			row.getCellList().addAll(cellsBookmaker);

			result.add(row);
		}

		Collections.sort(result.getRows(), new SortTableByValueStr());

		return result;
	}
}
