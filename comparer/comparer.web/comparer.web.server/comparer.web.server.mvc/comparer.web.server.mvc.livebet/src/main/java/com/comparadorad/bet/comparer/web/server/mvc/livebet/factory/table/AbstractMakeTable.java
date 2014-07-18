/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.livebet.factory.table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.beans.UserDataCover;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class AbstractMakeTable.
 */
public abstract class AbstractMakeTable implements IMakeTable {

	/** The MULTIPLIER. */
	private final int MULTIPLIER = 10;

	/** The url factory. */
	@Inject
	private IUrlFactory urlFactory;

	/** The NUMBE r_ digit s_ be t_ format. */
	protected static int NUMBER_DIGITS_BET_FORMAT = 2;

	/**
	 * Gets the mULTIPLIER.
	 * 
	 * @return the mULTIPLIER
	 */
	public int getMULTIPLIER() {
		return MULTIPLIER;
	}

	/**
	 * Make table.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @param uData
	 *            the u data
	 * @param rtmarket
	 *            the rtmarket
	 * @return the table response to {@inheritDoc}
	 */
	public TableResponseTo makeTable(RtMatch rtMatch, UserDataCover uData,
			RtMarket rtmarket) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		tableResponseTo.setObjectToId(new ObjectToId(rtMatch.getObjectId()
				.toString()));
		tableResponseTo.add(makeFirstRow(rtMatch, uData, rtmarket));
		tableResponseTo.add(makeSecondRow(rtMatch, uData));
		String categoryAnalytics = rtMatch.getMatchId().getCompetition().getSport().getName(null)+rtMatch.getMatchId().getCompetition().getName(null)+rtMatch.getName(null);
		for (TableResponseRowTo to : makeBet(rtmarket, uData, categoryAnalytics)) {
			tableResponseTo.add(to);
		}
		return tableResponseTo;
	}

	/**
	 * Gets the table response cell to empty.
	 * 
	 * @return the table response cell to empty
	 */
	protected TableResponseCellTo getTableResponseCellToEmpty() {
		TableResponseCellTo result = new TableResponseCellTo();
		result.setValueTo(new ValueTo());
		return result;
	}

	/**
	 * Gets the table response row to empty.
	 * 
	 * @return the table response row to empty
	 */
	protected TableResponseRowTo getTableResponseRowToEmpty() {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		tableResponseRowTo.setCellList(new ArrayList<TableResponseCellTo>());
		return tableResponseRowTo;
	}

	/**
	 * Make first row.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @param uData
	 *            the u data
	 * @param rtmarket
	 *            the rtmarket
	 * @return the table response row to
	 */
	protected TableResponseRowTo makeFirstRow(RtMatch rtMatch,
			UserDataCover uData, RtMarket rtmarket) {
		TableResponseRowTo result = new TableResponseRowTo();
		result.setCellList(new ArrayList<TableResponseCellTo>());
		TableResponseCellTo cell = getTableResponseCellToEmpty();

		Date dateAux = DateUtilJava
				.convertSistemDependentDateToDesiredTimeZone(rtMatch
						.getMatchId().getStartDate().getZeroGmtMatchDate(),
						uData.getUserData().getTimeZone());
		String date = DateUtilJava.dateToString(dateAux);

		cell.getValueTo().setDate(date);
		result.getCellList().add(cell);
		cell = getTableResponseCellToEmpty();

		Date timeAux = DateUtilJava
				.convertSistemDependentDateToDesiredTimeZone(rtMatch
						.getMatchId().getStartDate().getZeroGmtMatchDate(),
						uData.getUserData().getTimeZone());
		String time = DateUtilJava.timeToString(timeAux);

		cell.getValueTo().setDate(time);
		result.getCellList().add(cell);
		cell = getTableResponseCellToEmpty();
		if (rtmarket.getBetType() != null) {
			cell.getValueTo().setValueStr(
					rtmarket.getBetType().getName(
							uData.getUserData().getLocale()));
		}

		result.getCellList().add(cell);
		return result;
	}

	/**
	 * Make second row.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @param uData
	 *            the u data
	 * @return the table response row to
	 */
	protected TableResponseRowTo makeSecondRow(RtMatch rtMatch,
			UserDataCover uData) {
		TableResponseRowTo result = new TableResponseRowTo();
		result.setCellList(new ArrayList<TableResponseCellTo>());
		TableResponseCellTo cell = getTableResponseCellToEmpty();
		LinkTo link = new LinkTo();
		if (rtMatch.getName(uData.getUserData().getLocale()) != null) {
			StringBuffer nextEventName = new StringBuffer()
					.append(rtMatch.getName(uData.getUserData().getLocale()))
					.append(" - ")
					.append(rtMatch.getMatchId().getCompetition().getSport()
							.getName(uData.getUserData().getLocale()))
					.append(" - ")
					.append(rtMatch.getMatchId().getCompetition()
							.getName(uData.getUserData().getLocale()));
			link.setName(nextEventName.toString());
			link.setObjectToId(new ObjectToId(rtMatch.getObjectId().toString()));
			link.setObjectToIdAux(new ObjectToId(getBetType().id()));
			cell.setLinkTo(link);
			result.getCellList().add(cell);
		}

		return result;
	}

	/**
	 * Make bet.
	 * 
	 * @param rtmarket
	 *            the rtmarket
	 * @param userDataCover
	 *            the user data cover
	 * @return the list
	 */
	protected abstract List<TableResponseRowTo> makeBet(RtMarket rtmarket,
			UserDataCover userDataCover, String categoryAnalytics);

	/**
	 * Adds the empty cells.
	 * 
	 * @param row
	 *            the row
	 * @param number
	 *            the number
	 */
	protected void addEmptyCells(List<TableResponseCellTo> row, int number) {
		for (int i = 0; i < number; i++) {
			row.add(getTableResponseCellToEmpty());
		}
	}

	/**
	 * Adds the cell.
	 * 
	 * @param value
	 *            the value
	 * @param literal
	 *            the literal
	 * @param location
	 *            the location
	 * @param externalLinkTo
	 *            the external link to
	 * @return the table response cell to
	 */
	protected TableResponseCellTo addCell(String value, String literal,
			String location, ExternalLinkTo externalLinkTo) {
		TableResponseCellTo cell = getTableResponseCellToEmpty();
		cell.getValueTo().setValueStr(value);
		if (literal != null) {
			cell.getValueTo().setLiteral(literal);
		}
		if (location != null) {
			List<ResourceTo> resources = new ArrayList<ResourceTo>();
			resources.add(new ResourceTo(location));
			cell.setResources(resources);
		}
		if (externalLinkTo != null) {
			cell.setExternalLinkTo(externalLinkTo);
		}
		return cell;
	}

	/**
	 * Adds the row.
	 * 
	 * @param rtmarket
	 *            the rtmarket
	 * @param participant
	 *            the participant
	 * @param home
	 *            the home
	 * @param away
	 *            the away
	 * @return the table response row to
	 */
	protected TableResponseRowTo addRow(RtMarket rtmarket, String participant,
			boolean home, boolean away, String categoryAnalytics) {
		TableResponseRowTo row = getTableResponseRowToEmpty();
		row.add(addCell(null, participant, null, null));
		RtBet bet = findBestOdd(home, away, rtmarket);
		categoryAnalytics=categoryAnalytics+rtmarket.getBetType().getNameId();
		if (bet != null && bet.getBookmaker() != null
				&& bet.getBetOdd().getOdds() != null) {
			ExternalLinkTo link = new ExternalLinkTo();
			link.setLinkImgLocation(bet.getBookmaker().getResourceMeduimImg()
					.getLocation());
			IUrlConversor conversor = urlFactory.makeUrlConversor(bet
					.getBookmaker().getObjectId().toString());
			link.setUrl(conversor
					.makeUrl(bet.getWebUrl().getUrl(), bet.getBookmaker()
							.getBookmakerConfiguration().getIdAfiliado()));
			link.setActionAnalytics(bet.getBookmaker().getNameId());
			link.setCategoryAnalytics(categoryAnalytics);
			String odd = bet.getBetOdd().getOdds();
			String formattedBet = FormatterUtil.formatBet(odd,
					NUMBER_DIGITS_BET_FORMAT);
			row.add(addCell(formattedBet, null, null, null));
			row.add(addCell(null, null, null, link));
			Float fodd = Float.parseFloat(odd);
			fodd = fodd * getMULTIPLIER();
			row.add(addCell(FormatterUtil.formatBet(fodd.toString(),
					NUMBER_DIGITS_BET_FORMAT), null, null, null));

		}

		return row;
	}

	/**
	 * Find best odd.
	 * 
	 * @param home
	 *            the home
	 * @param away
	 *            the away
	 * @param rtmarket
	 *            the rtmarket
	 * @return the rt bet
	 */
	protected RtBet findBestOdd(boolean home, boolean away, RtMarket rtmarket) {
		RtBet greatestBet = new RtBet();
		boolean firtstime = true;
		for (RtBet betIterator : rtmarket.getBets()) {
			if (betIterator.getParticipant().isAwayParticipant() == away
					&& betIterator.getParticipant().isHomeParticipant() == home) {
				if (firtstime) {
					greatestBet = betIterator;
					firtstime = false;
				} else {
					if (Double.parseDouble(betIterator.getBetOdd().getOdds()) > Double
							.parseDouble(greatestBet.getBetOdd().getOdds())) {
						greatestBet = betIterator;
					}
				}

			}
		}
		return greatestBet;
	}
}
