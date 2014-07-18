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
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.CellsOrderByValueStrComparator;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.SortRowsBySize;

/**
 * The Class MakeTableEventDecoratorParticipants.
 */
public abstract class MakeTableEventDecoratorPart extends
		AbstractMakeTableEvent {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(MakeTableEventGanador.class);

	/**
	 * Calculate payout probabilities rows.
	 * 
	 * @param row
	 *            the row
	 * @return the string
	 */
	private String calculatePayoutProbabilitiesRows(TableResponseRowTo row) {
		Double payout = 0.0;
		for (TableResponseCellTo cell : row.getCellList()) {
			payout += 1 / Double.valueOf(cell.getValueTo().getValueStr());
		}
		return FormatterUtil.formatBet(100 / payout, DECIMAL_0);
	}

	/**
	 * Creates the cell bet.
	 * 
	 * @param bet
	 *            the bet
	 * @param pUrl
	 *            the url
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellBet(RtBet bet, String pUrl, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();

		result.setId(new ObjectToId(bet.getParticipant().getCfgParticipant()
				.getObjectId().toString()));

		ExternalLinkTo externalLinkTo = new ExternalLinkTo();
		externalLinkTo.setUrl(pUrl);
		String formattedOdd = FormatterUtil.formatBet(
				Double.valueOf(bet.getBetOdd().getOdds()), DECIMAL_2);
		externalLinkTo.setLinkText(formattedOdd);
		externalLinkTo.setActionAnalytics(bet.getBookmaker().getNameId());
		externalLinkTo.setCategoryAnalytics(categoryAnalytics);

		result.setExternalLinkTo(externalLinkTo);
		return result;
	}

	/**
	 * Creates the cell bookmaker.
	 * 
	 * @param pUrl
	 *            the url
	 * @param bookmaker
	 *            the bookmaker
	 * @param locale
	 *            the locale
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellBookmaker(String pUrl,
			CfgBookmaker bookmaker, Locale locale, String categoryAnalytics) {
		ExternalLinkTo externalLinkTo = new ExternalLinkTo();
		externalLinkTo.setUrl(pUrl);
		externalLinkTo.setLinkText(bookmaker.getName(locale));
		externalLinkTo.setLinkImgLocation(bookmaker.getResourceSmallImg()
				.getLocation());
		externalLinkTo.setActionAnalytics(bookmaker.getNameId());
		externalLinkTo.setCategoryAnalytics(categoryAnalytics);
		TableResponseCellTo cell = new TableResponseCellTo();
		cell.setExternalLinkTo(externalLinkTo);
		return cell;
	}

	/**
	 * Creates the cell media.
	 * 
	 * @param participant
	 *            the participant
	 * @param rows
	 *            the rows
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellMedia(CfgParticipant participant,
			List<TableResponseRowTo> rows) {
		TableResponseCellTo result = new TableResponseCellTo();
		Double media = new Double(0);
		int contadorPart = 0;
		for (TableResponseRowTo row : rows) {
			for (TableResponseCellTo cell : row.getCellList()) {
				if (cell.getExternalLinkTo() != null
						&& cell.getExternalLinkTo().getLinkImgLocation() == null
						&& cell.getId().getId()
								.equals(participant.getObjectId().toString())) {
					media = Double.valueOf(cell.getExternalLinkTo()
							.getLinkText()) + media;
					contadorPart++;
				}
			}
		}
		media = media / contadorPart;
		result.setId(new ObjectToId(participant.getObjectId().toString()));
		ValueTo valueTo = new ValueTo();
		valueTo.setValueStr(FormatterUtil.formatBet(media, DECIMAL_2));
		result.setValueTo(valueTo);
		return result;
	}

	/**
	 * Creates the cell title.
	 * 
	 * @param objectToId
	 *            the object to id
	 * @param name
	 *            the name
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellTitle(ObjectToId objectToId,
			String name) {
		TableResponseCellTo result = new TableResponseCellTo();
		result.setId(objectToId);
		ValueTo valueTo = new ValueTo();
		valueTo.setValueStr(name);
		result.setValueTo(valueTo);
		return result;
	}

	/**
	 * Creates the cell valor mas alto.
	 * 
	 * @param participant
	 *            the participant
	 * @param rows
	 *            the rows
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellValorMasAlto(
			CfgParticipant participant, List<TableResponseRowTo> rows) {
		TableResponseCellTo result = new TableResponseCellTo();
		Double valorMasAlto = new Double(0);
		for (TableResponseRowTo row : rows) {
			for (TableResponseCellTo cell : row.getCellList()) {
				if (cell.getExternalLinkTo() != null
						&& cell.getExternalLinkTo().getLinkImgLocation() == null
						&& cell.getId().getId()
								.equals(participant.getObjectId().toString())
						&& Double.valueOf(cell.getExternalLinkTo()
								.getLinkText()) > valorMasAlto) {
					valorMasAlto = Double.valueOf(cell.getExternalLinkTo()
							.getLinkText());
				}
			}
		}
		result.setId(new ObjectToId(participant.getObjectId().toString()));
		ValueTo valueTo = new ValueTo();
		valueTo.setValueStr(FormatterUtil.formatBet(valorMasAlto, DECIMAL_2));
		result.setValueTo(valueTo);
		return result;
	}

	/**
	 * Creates the media row.
	 * 
	 * @param rows
	 *            the rows
	 * @param participants
	 *            the participants
	 * @return the table response row to
	 */
	private TableResponseRowTo createMediaRow(List<TableResponseRowTo> rows,
			List<CfgParticipant> participants) {
		TableResponseRowTo result = new TableResponseRowTo();
		TableResponseCellTo cell;

		for (CfgParticipant participant : participants) {
			cell = createCellMedia(participant, rows);
			result.add(cell);
		}
		String payoutMedio = new StringBuffer(
				calculatePayoutProbabilitiesRows(result)).append("%")
				.toString();
		result.add(createCellValueStr(payoutMedio));

		return result;
	}

	/**
	 * Creates the probabilidad row.
	 * 
	 * @param media
	 *            the media
	 * @return the table response row to
	 */
	private TableResponseRowTo createProbabilidadRow(TableResponseRowTo media) {
		TableResponseRowTo result = new TableResponseRowTo();
		TableResponseCellTo cell;
		List<TableResponseCellTo> cells = new ArrayList<TableResponseCellTo>();

		int i = 0;
		for (TableResponseCellTo cellMedia : media.getCellList()) {
			if (i != media.getCellList().size() - 1) {
				cell = new TableResponseCellTo();
				cell.setId(cellMedia.getId());
				ValueTo valueTo = new ValueTo();
				Double payoutMedio = Double
						.valueOf(media
								.getCellList()
								.get(media.getCellList().size() - 1)
								.getValueTo()
								.getValueStr()
								.substring(
										0,
										media.getCellList()
												.get(media.getCellList().size() - 1)
												.getValueTo().getValueStr()
												.length() - 1)) / 100;
				Double probabilidad = Double.valueOf(cellMedia.getValueTo()
						.getValueStr());
				probabilidad = (1 / probabilidad) * payoutMedio * 100;
				String roundProbability = roundProbability(probabilidad);
				valueTo.setValueStr(new StringBuffer(roundProbability).append(
						"%").toString());
				cell.setValueTo(valueTo);

				cells.add(cell);
				i++;
			}
		}
		result.setCellList(cells);
		return result;
	}

	/**
	 * Creates the row bookmaker.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @param bets
	 *            the bets
	 * @param locale
	 *            the locale
	 * @return the table response row to
	 */
	private TableResponseRowTo createRowBookmaker(CfgBookmaker bookmaker,
			List<RtBet> bets, Locale locale, String categoryAnalytics) {
		TableResponseRowTo result = new TableResponseRowTo();
		result.setObjectToId(new ObjectToId(bookmaker.getObjectId().toString()));
		TableResponseCellTo cell;
		String payout;
		String url = getUrl(bets, bookmaker);

		cell = createCellBookmaker(url, bookmaker, locale, categoryAnalytics);
		result.add(cell);
		for (RtBet bet : bets) {
			if (bet.getBookmaker().equals(bookmaker)) {
				cell = createCellBet(bet, url, categoryAnalytics);
				result.add(cell);
			}
		}
		payout = getPayout(result);
		cell = createCellValueStr(payout);
		result.add(cell);

		return result;
	}

	/**
	 * Creates the valor mas alto row.
	 * 
	 * @param rows
	 *            the rows
	 * @param participants
	 *            the participants
	 * @return the table response row to
	 */
	private TableResponseRowTo createValorMasAltoRow(
			List<TableResponseRowTo> rows, List<CfgParticipant> participants) {
		TableResponseRowTo result = new TableResponseRowTo();
		TableResponseCellTo cell;

		for (CfgParticipant participant : participants) {
			cell = createCellValorMasAlto(participant, rows);
			result.add(cell);
		}
		String payoutValorMasAlto = new StringBuffer(
				calculatePayoutProbabilitiesRows(result)).append("%")
				.toString();
		result.add(createCellValueStr(payoutValorMasAlto));

		return result;
	}

	/**
	 * Gets the bets.
	 * 
	 * @param match
	 *            the match
	 * @param betTypeId
	 *            the bet type id
	 * @return the bets
	 */
	private List<RtBet> getBets(final RtMatch match,
			final CfgBetTypeId betTypeId) {
		List<RtBet> result = new ArrayList<RtBet>();

		for (RtMarket market : match.getRtMarkets()) {
			if (market.getBetType().getNameId().equals(betTypeId.nameId())) {
				for (RtBet bet : market.getBets()) {
					result.add(bet);
				}
			}
		}

		return result;
	}

	/**
	 * Gets the bookmakers.
	 * 
	 * @param bets
	 *            the bets
	 * @return the bookmakers
	 */
	private List<CfgBookmaker> getBookmakers(List<RtBet> bets) {
		List<CfgBookmaker> bookmakers = new ArrayList<CfgBookmaker>();
		for (RtBet bet : bets) {
			if (!bookmakers.contains(bet.getBookmaker())) {
				bookmakers.add(bet.getBookmaker());
			}
		}
		return bookmakers;
	}

	/**
	 * Sets the content.
	 * 
	 * @param participants
	 *            the participants
	 * @param match
	 *            the match
	 * @param locale
	 *            the locale
	 * @return the content
	 */
	private List<TableResponseRowTo> getContent(
			final List<CfgParticipant> participants, final RtMatch match,
			final Locale locale) {
		TableResponseRowTo row;
		List<TableResponseRowTo> rows = new ArrayList<TableResponseRowTo>();

		List<RtBet> bets = getBets(match, getBetTypeId());
		List<CfgBookmaker> bookmakers = getBookmakers(bets);
		for (CfgBookmaker bookmaker : bookmakers) {
			String categoryAnalytics = match.getMatchId().getCompetition().getSport().getName(null)+match.getMatchId().getCompetition().getName(null)+match.getName(null)+getBetTypeId().nameId();
			row = createRowBookmaker(bookmaker, bets, locale, categoryAnalytics);
			rows.add(row);
		}
		LOG.debug("Se crean las filas de las cuotas");
		TableResponseRowTo media = createMediaRow(rows, participants);
		LOG.debug("Se crea la fila de las medias de las cuotas");
		TableResponseRowTo valorMasAlto = createValorMasAltoRow(rows,
				participants);
		LOG.debug("Se crea la fila de los valores mas altos de las cuotas");
		TableResponseRowTo probabilidad = createProbabilidadRow(media);
		LOG.debug("Se crea la fila de las probablidades de las cuotas");
		rows.add(media);
		rows.add(valorMasAlto);
		rows.add(probabilidad);

		return rows;
	}

	/**
	 * Gets the ordered particpants.
	 * 
	 * @param meanCells
	 *            the mean cells
	 * @param allParticipants
	 *            the all participants
	 * @return the ordered particpants
	 */
	private List<CfgParticipant> getOrderedParticpants(
			List<TableResponseCellTo> meanCells,
			List<CfgParticipant> allParticipants) {
		List<CfgParticipant> result = new ArrayList<CfgParticipant>();

		for (TableResponseCellTo meanCell : meanCells) {
			result.add(getParticipantById(allParticipants, meanCell.getId()
					.getId().toString()));
		}

		return result;
	}

	/**
	 * Gets the participant by id.
	 * 
	 * @param allParticipants
	 *            the all participants
	 * @param idParticipant
	 *            the id participant
	 * @return the participant by id
	 */
	private CfgParticipant getParticipantById(
			List<CfgParticipant> allParticipants, String idParticipant) {
		CfgParticipant result = null;
		for (CfgParticipant participant : allParticipants) {
			if (participant.getObjectId().toString().equals(idParticipant)) {
				result = participant;
				break;
			}
		}
		return result;
	}

	/**
	 * Gets the participants.
	 * 
	 * @param match
	 *            the match
	 * @return the participants
	 */
	private List<CfgParticipant> getParticipants(final RtMatch match) {
		List<CfgParticipant> result = new ArrayList<CfgParticipant>();

		for (RtMarket market : match.getRtMarkets()) {
			if (market.getBetType().getNameId().equals(getBetTypeId().nameId())) {
				for (RtBet bet : market.getBets()) {
					if (!result.contains(bet.getParticipant()
							.getCfgParticipant())) {
						result.add(bet.getParticipant().getCfgParticipant());
					}
				}
			}
		}
		return result;
	}

	/**
	 * Sets the title.
	 * 
	 * @param participants
	 *            the participants
	 * @param locale
	 *            the locale
	 * @return the title
	 */
	private TableResponseRowTitleTo getTitle(
			final List<CfgParticipant> participants, final Locale locale) {
		TableResponseRowTitleTo title = new TableResponseRowTitleTo();
		List<TableResponseCellTo> cells = new ArrayList<TableResponseCellTo>();

		for (CfgParticipant participant : participants) {
			TableResponseCellTo cell = createCellTitle(new ObjectToId(
					participant.getObjectId().toString()),
					participant.getName(locale));
			cells.add(cell);
		}

		title.setCellList(cells);
		LOG.debug("Se crea el titulo de la tabla");
		return title;
	}

	/**
	 * Gets the url.
	 * 
	 * @param bets
	 *            the bets
	 * @param bookmaker
	 *            the bookmaker
	 * @return the url
	 */
	private String getUrl(List<RtBet> bets, CfgBookmaker bookmaker) {
		RtBet betUrl = null;
		for (RtBet bet : bets) {
			if (bet.getBookmaker().equals(bookmaker)) {
				betUrl = bet;
			}
		}
		urlConversor = urlFactory.makeUrlConversor(betUrl.getBookmaker()
				.getObjectId().toString());
		String url = urlConversor.makeUrl(betUrl.getWebUrl().getUrl(),
				bookmaker.getBookmakerConfiguration().getIdAfiliado());
		return url;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent
	 * .AbstractMakeTableEvent
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
		List<CfgParticipant> participants = getParticipants(match);

		List<TableResponseRowTo> rows = getContent(participants, match,
				informationWindow.getUserData().getLocale());

		// Ordenamos rows descendentemente por tamaño de su cellList
		List<TableResponseRowTo> rowsSortedBySize = rows.subList(0,
				rows.size() - 3);
		Collections.sort(rowsSortedBySize, new SortRowsBySize());

		// Ordenamos el primer row ascendentemente por los odds
		List<TableResponseCellTo> rowMean = rows.get(rows.size() - 2)
				.getCellList()
				.subList(0, rows.get(rows.size() - 2).getCellList().size() - 1);
		Collections.sort(rowMean, new CellsOrderByValueStrComparator());

		// Se ordenan los participantes por el criterio de media
		List<CfgParticipant> orderedParticipants = getOrderedParticpants(
				rowMean, participants);

		TableResponseRowTitleTo title = getTitle(orderedParticipants,
				informationWindow.getUserData().getLocale());

		table.setObjectToId(new ObjectToId(match.getObjectId().toString()));
		table.setTitle(title);
		table.setRows(rows);
		result.add(table);
		return result;
	}

}
