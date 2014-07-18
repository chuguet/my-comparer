/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.server.mvc.match.beans.BookmakerBets;

/**
 * The Class MakeTableEventUnoXDos.
 */
@Component
public final class MakeTableEventUnoXDos extends MakeTableEventDecoratorVersus {

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.UNO_X_DOS;
	}

	private TableResponseCellTo createCellEmpate(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (bet.getParticipant().isAwayParticipant() == false
					&& bet.getParticipant().isHomeParticipant() == false) {
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

	@Override
	protected List<TableResponseRowTo> createRowsOdds(
			List<BookmakerBets> bookmakersBets, Locale locale, String categoryAnalytics) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		TableResponseRowTo row;

		for (BookmakerBets bookmakerBets : bookmakersBets) {
			row = new TableResponseRowTo();
			row.setObjectToId(new ObjectToId(bookmakerBets.getBookmaker()
					.getObjectId().toString()));
			row.add(createBookmakerCell(bookmakerBets.getBets(), locale, categoryAnalytics));
			row.add(createCellLocal(bookmakerBets.getBets(), categoryAnalytics));
			row.add(createCellEmpate(bookmakerBets.getBets(), categoryAnalytics));
			row.add(createCellVisitante(bookmakerBets.getBets(), categoryAnalytics));
			row.add(createCellValueStr(getPayout(row)));
			result.add(row);
		}

		return result;
	}

	@Override
	protected List<TableResponseRowTo> createRowsProbability(
			List<TableResponseRowTo> rowsOdds) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		TableResponseRowTo row;

		List<Double> columnLocal = getColumn(rowsOdds, 1);
		List<Double> columnEmpate = getColumn(rowsOdds, 2);
		List<Double> columnVisitante = getColumn(rowsOdds, 3);

		List<Double> oddColumnLocal = createColumnProbability(columnLocal);
		List<Double> oddColumnEmpate = createColumnProbability(columnEmpate);
		List<Double> oddColumnVisitante = createColumnProbability(columnVisitante);

		Double payoutMedio = calculatePayoutMedio(oddColumnLocal,
				oddColumnEmpate, oddColumnVisitante);
		Double payoutValorAlto = calculatePayoutValorAlto(oddColumnLocal,
				oddColumnEmpate, oddColumnVisitante);

		row = createRowProbability(oddColumnLocal, oddColumnEmpate,
				oddColumnVisitante, 0, payoutMedio);
		result.add(row);

		row = createRowProbability(oddColumnLocal, oddColumnEmpate,
				oddColumnVisitante, 1, payoutValorAlto);
		result.add(row);

		row = createRowProbability(oddColumnLocal, oddColumnEmpate,
				oddColumnVisitante, 2, payoutMedio);
		result.add(row);

		return result;
	}


}
