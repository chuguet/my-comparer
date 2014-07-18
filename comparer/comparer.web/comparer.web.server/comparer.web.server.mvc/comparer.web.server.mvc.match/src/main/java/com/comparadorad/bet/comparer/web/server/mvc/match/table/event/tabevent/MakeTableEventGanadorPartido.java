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

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.server.mvc.match.beans.BookmakerBets;

/**
 * The Class MakeTableEventGanadorPartido.
 */
@Component
public final class MakeTableEventGanadorPartido extends
		MakeTableEventDecoratorVersus {

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.GANADOR_PARTIDO;
	}

	@Override
	protected List<TableResponseRowTo> createRowsProbability(
			List<TableResponseRowTo> rowsOdds) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		TableResponseRowTo row;

		List<Double> columnLocal = getColumn(rowsOdds, 1);
		List<Double> columnVisitante = getColumn(rowsOdds, 2);

		List<Double> oddColumnLocal = createColumnProbability(columnLocal);
		List<Double> oddColumnVisitante = createColumnProbability(columnVisitante);

		Double payoutMedio = calculatePayoutMedio(oddColumnLocal, null,
				oddColumnVisitante);
		Double payoutValorAlto = calculatePayoutValorAlto(oddColumnLocal, null,
				oddColumnVisitante);

		row = createRowProbability(oddColumnLocal, null, oddColumnVisitante, 0,
				payoutMedio);
		result.add(row);

		row = createRowProbability(oddColumnLocal, null, oddColumnVisitante, 1,
				payoutValorAlto);
		result.add(row);

		row = createRowProbability(oddColumnLocal, null, oddColumnVisitante, 2,
				payoutMedio);
		result.add(row);

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
			row.add(createCellVisitante(bookmakerBets.getBets(), categoryAnalytics));
			row.add(createCellValueStr(getPayout(row)));
			result.add(row);
		}

		return result;
	}

}
