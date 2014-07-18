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

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.server.mvc.match.beans.BookmakerBets;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor;
import com.comparadorad.bet.comparer.web.server.redirection.factory.IUrlFactory;

/**
 * The Class AbstractMakeTableEvent.
 */
public abstract class AbstractMakeTableEvent implements IMakeTableEvent {

	/** The Constant DECIMAL_0. */
	protected static final Integer DECIMAL_0 = 0;

	/** The Constant DECIMAL_1. */
	protected static final Integer DECIMAL_1 = 1;

	/** The Constant DECIMAL_2. */
	protected static final Integer DECIMAL_2 = 2;

	/** The url conversor. */
	protected IUrlConversor urlConversor;

	/** The url factory. */
	@Inject
	protected IUrlFactory urlFactory;

	/**
	 * Calcular media.
	 * 
	 * @param column
	 *            the column
	 * @return the double
	 */
	private Double calcularMedia(List<Double> column) {
		Double result = 0.0;
		for (Double odd : column) {
			result += odd;
		}

		return result / column.size();
	}

	/**
	 * Calcular valor alto.
	 * 
	 * @param column
	 *            the column
	 * @return the double
	 */
	private Double calcularValorAlto(List<Double> column) {
		Double result = 0.0;
		for (Double odd : column) {
			if (odd > result) {
				result = odd;
			}
		}
		return result;
	}

	/**
	 * Calculate payout medio.
	 * 
	 * @param columnLocal
	 *            the column local
	 * @param columnEmpate
	 *            the column empate
	 * @param columnVisitante
	 *            the column visitante
	 * @return the double
	 */
	protected Double calculatePayoutMedio(List<Double> columnLocal,
			List<Double> columnEmpate, List<Double> columnVisitante) {
		Double result = 0.0;
		if (columnEmpate != null) {
			result = 1 / ((1 / columnLocal.get(0)) + (1 / columnEmpate.get(0)) + (1 / columnVisitante
					.get(0)));
		} else {
			result = 1 / ((1 / columnLocal.get(0)) + (1 / columnVisitante
					.get(0)));
		}
		return result;
	}

	/**
	 * Calculate payout valor alto.
	 * 
	 * @param columnLocal
	 *            the column local
	 * @param columnEmpate
	 *            the column empate
	 * @param columnVisitante
	 *            the column visitante
	 * @return the double
	 */
	protected Double calculatePayoutValorAlto(List<Double> columnLocal,
			List<Double> columnEmpate, List<Double> columnVisitante) {
		Double result = 0.0;
		if (columnEmpate != null) {
			result = 1 / ((1 / columnLocal.get(1)) + (1 / columnEmpate.get(1)) + (1 / columnVisitante
					.get(1)));
		} else {
			result = 1 / ((1 / columnLocal.get(1)) + (1 / columnVisitante
					.get(1)));
		}
		return result;
	}

	/**
	 * Contains bookmaker.
	 * 
	 * @param bookmakersBets
	 *            the bookmakers bets
	 * @param bookmaker
	 *            the bookmaker
	 * @return true, if successful
	 */
	private boolean containsBookmaker(List<BookmakerBets> bookmakersBets,
			CfgBookmaker bookmaker) {
		boolean result = false;
		for (BookmakerBets bookmakerBets : bookmakersBets) {
			if (bookmaker
					.getObjectId()
					.toString()
					.equals(bookmakerBets.getBookmaker().getObjectId()
							.toString())) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Creates the bookmaker cell.
	 * 
	 * @param bets
	 *            the bets
	 * @param locale
	 *            the locale
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createBookmakerCell(List<RtBet> bets,
			Locale locale, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		RtBet bet = bets.get(0);
				
		String urlBookmaker = getUrlBookmaker(bet.getBookmaker().getObjectId()
				.toString(), /*bet.getWebUrl().getUrl()*/getUrl(bet), bet.getBookmaker()
				.getBookmakerConfiguration().getIdAfiliado());
		ExternalLinkTo externalLinkTo = new ExternalLinkTo(urlBookmaker, bet
				.getBookmaker().getName(locale), bet.getBookmaker()
				.getResourceSmallImg().getLocation(), bet.getBookmaker().getNameId() ,categoryAnalytics);
		result.setExternalLinkTo(externalLinkTo);
		return result;
	}

	/**
	 * Creates the cell pago.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createCellPago(List<RtBet> bets) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo value = new ValueTo();
		Double beneficio = 0.0;
		for (RtBet bet : bets) {
			beneficio += 1 / Double.valueOf(bet.getBetOdd().getOdds());
		}
		String payout = new StringBuffer(FormatterUtil.formatBet(
				Double.valueOf(100 / beneficio), DECIMAL_0)).append("%")
				.toString();
		value.setValueStr(payout);
		result.setValueTo(value);
		return result;
	}

	/**
	 * Creates the cell value str.
	 * 
	 * @param valueStr
	 *            the value str
	 * @return the table response cell to
	 */
	protected TableResponseCellTo createCellValueStr(String valueStr) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo value = new ValueTo();
		value.setValueStr(valueStr);
		result.setValueTo(value);
		return result;
	}

	/**
	 * Creates the row probability.
	 * 
	 * @param column
	 *            the column
	 * @return the table response row to
	 */
	protected List<Double> createColumnProbability(List<Double> column) {
		Double media;
		Double valorAlto;
		Double probabilidad;
		List<Double> result = new ArrayList<Double>();

		media = calcularMedia(column);
		result.add(media);

		valorAlto = calcularValorAlto(column);
		result.add(valorAlto);

		probabilidad = 1 / media;
		result.add(probabilidad);

		return result;
	}

	/**
	 * Creates the row probability.
	 * 
	 * @param columnLocal
	 *            the column local
	 * @param columnEmpate
	 *            the column empate
	 * @param columnVisitante
	 *            the column visitante
	 * @param numberRow
	 *            the number row
	 * @param extraValue
	 *            the extra value
	 * @return the table response row to
	 */
	protected TableResponseRowTo createRowProbability(List<Double> columnLocal,
			List<Double> columnEmpate, List<Double> columnVisitante,
			Integer numberRow, Double extraValue) {
		TableResponseRowTo result = new TableResponseRowTo();
		List<Double> values = new ArrayList<Double>();
		String local = null;
		String empate = null;
		String visitante = null;

		if (numberRow == 2) {
			local = new StringBuffer(roundProbability(100 * extraValue
					* columnLocal.get(numberRow))).append("%").toString();
			values.add(columnLocal.get(numberRow));
			if (columnEmpate != null) {
				empate = new StringBuffer(roundProbability(100 * extraValue
						* columnEmpate.get(numberRow))).append("%").toString();
				values.add(columnEmpate.get(numberRow));
			}
			visitante = new StringBuffer(roundProbability(100 * extraValue
					* columnVisitante.get(numberRow))).append("%").toString();
			values.add(columnVisitante.get(numberRow));
		} else {
			local = FormatterUtil.formatBet(columnLocal.get(numberRow),
					DECIMAL_2);
			values.add(columnLocal.get(numberRow));
			if (columnEmpate != null) {
				empate = FormatterUtil.formatBet(columnEmpate.get(numberRow),
						DECIMAL_2);
				values.add(columnEmpate.get(numberRow));
			}
			visitante = FormatterUtil.formatBet(columnVisitante.get(numberRow),
					DECIMAL_2);
			values.add(columnVisitante.get(numberRow));
		}

		result.add(createCellValueStr(local));
		if (columnEmpate != null) {
			result.add(createCellValueStr(empate));
		}
		result.add(createCellValueStr(visitante));

		if (numberRow == 0) {
			result.add(createCellValueStr(new StringBuffer(FormatterUtil
					.formatBet(100 * extraValue, DECIMAL_0)).append("%")
					.toString()));
		}

		return result;
	}

	/**
	 * Gets the bets by bookmaker.
	 * 
	 * @param bets
	 *            the bets
	 * @return the bets by bookmaker
	 */
	protected List<BookmakerBets> getBetsByBookmaker(Set<RtBet> bets) {
		List<BookmakerBets> result = new ArrayList<BookmakerBets>();
		List<RtBet> betsBookmaker;
		BookmakerBets bookmakerBets;
		for (RtBet bet : bets) {
			if (containsBookmaker(result, bet.getBookmaker())) {
				bookmakerBets = getBookmakerBets(result, bet.getBookmaker());
				bookmakerBets.getBets().add(bet);
			} else {
				bookmakerBets = new BookmakerBets();
				bookmakerBets.setBookmaker(bet.getBookmaker());
				betsBookmaker = new ArrayList<RtBet>();
				betsBookmaker.add(bet);
				bookmakerBets.setBets(betsBookmaker);
				result.add(bookmakerBets);
			}
		}
		return result;
	}

	/**
	 * Gets the bookmaker bets.
	 * 
	 * @param bookmakersBets
	 *            the bookmakers bets
	 * @param bookmaker
	 *            the bookmaker
	 * @return the bookmaker bets
	 */
	private BookmakerBets getBookmakerBets(List<BookmakerBets> bookmakersBets,
			CfgBookmaker bookmaker) {
		BookmakerBets result = null;
		for (BookmakerBets bookmakerBets : bookmakersBets) {
			if (bookmaker
					.getObjectId()
					.toString()
					.equals(bookmakerBets.getBookmaker().getObjectId()
							.toString())) {
				result = bookmakerBets;
				break;
			}
		}
		return result;
	}

	/**
	 * Gets the column.
	 * 
	 * @param rowsOdds
	 *            the rows odds
	 * @param indexColumn
	 *            the index column
	 * @return the column
	 */
	protected List<Double> getColumn(List<TableResponseRowTo> rowsOdds,
			int indexColumn) {
		List<Double> result = new ArrayList<Double>();
		for (TableResponseRowTo row : rowsOdds) {
			int i = 0;
			for (TableResponseCellTo cell : row.getCellList()) {
				if (i == indexColumn) {
					result.add(Double.valueOf(cell.getExternalLinkTo()
							.getLinkText()));
				}
				i++;
			}
			i = 0;
		}
		return result;
	}

	/**
	 * Gets the payout.
	 * 
	 * @param row
	 *            the row
	 * @return the payout
	 */
	protected String getPayout(TableResponseRowTo row) {
		String payout;
		Double beneficio = 0.0;
		int i = 0;
		for (TableResponseCellTo cell : row.getCellList()) {
			if (i != 0) {
				beneficio += 1 / Double.valueOf(cell.getExternalLinkTo()
						.getLinkText());
			}
			i++;
		}
		payout = new StringBuffer(FormatterUtil.formatBet(100 / beneficio,
				DECIMAL_0)).append("%").toString();
		return payout;
	}

	/**
	 * Gets the url bookmaker.
	 * 
	 * @param idBookmaker
	 *            the id bookmaker
	 * @param url
	 *            the url
	 * @param idAfiliado
	 *            the id afiliado
	 * @return the url bookmaker
	 */
	protected String getUrlBookmaker(String idBookmaker, String url,
			String idAfiliado) {
		urlConversor = urlFactory.makeUrlConversor(idBookmaker);
		String result = urlConversor.makeUrl(url, idAfiliado);
		return result;
	}

	/**
	 * Round probability.
	 * 
	 * @param probabilidad
	 *            the probabilidad
	 * @return the string
	 */
	protected String roundProbability(Double probabilidad) {
		String result;
		if (probabilidad < 1) {
			result = FormatterUtil.formatBet(probabilidad, DECIMAL_2);
		} else if (probabilidad >= 1 && probabilidad <= 9) {
			result = FormatterUtil.formatBet(probabilidad, DECIMAL_1);
		} else {
			result = FormatterUtil.formatBet(probabilidad, DECIMAL_0);
		}
		return result;
	}

	/**
	 * Gets the Url
	 * @return
	 */
	protected static String getUrl(RtBet bet) {
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
		
		return theWebUrl;
	}
}
