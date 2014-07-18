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

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;

/**
 * The Class MakeTableEventUnoXDosHandicap.
 */
@Component
public final class MakeTableEventUnoXDosHandicap extends
		MakeTableEventDecoratorHandicap {

	/**
	 * Creates the cell empate handicap.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellEmpateHandicap(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (isEmpateHandicapAttribute(bet.getAttribute())) {
				String urlBookmaker = getUrlBookmaker(bet.getBookmaker()
						.getObjectId().toString(), bet.getWebUrl().getUrl(),
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
	 * Creates the cell local handicap.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellLocalHandicap(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (isLocalHandicapAttribute(bet.getAttribute())) {
				String urlBookmaker = getUrlBookmaker(bet.getBookmaker()
						.getObjectId().toString(), bet.getWebUrl().getUrl(),
						bet.getBookmaker().getBookmakerConfiguration()
								.getIdAfiliado());

				ExternalLinkTo externalLinkTo = new ExternalLinkTo();
				externalLinkTo.setUrl(urlBookmaker);
				externalLinkTo.setLinkText(FormatterUtil.formatBet(bet
						.getBetOdd().getOdds(), DECIMAL_2));
				externalLinkTo.setActionAnalytics(bet.getBookmaker().getNameId());
				externalLinkTo.setCategoryAnalytics(categoryAnalytics);
				result.setExternalLinkTo(externalLinkTo);
			}
		}
		return result;
	}

	/**
	 * Creates the cell visitante handicap.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellVisitanteHandicap(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (isVisitanteHandicapAttribute(bet.getAttribute())) {
				String urlBookmaker = getUrlBookmaker(bet.getBookmaker()
						.getObjectId().toString(), bet.getWebUrl().getUrl(),
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent
	 * .MakeTableEventDecoratorHandicap#createRowsOdds(java.util.List)
	 */
	@Override
	protected List<TableResponseCellTo> createRowsOdds(List<RtBet> bets, String categoryAnalytics) {
		List<TableResponseCellTo> result = new ArrayList<TableResponseCellTo>();
		TableResponseCellTo cell;

		cell = createCellLocalHandicap(bets, categoryAnalytics);
		result.add(cell);
		cell = createCellEmpateHandicap(bets, categoryAnalytics);
		result.add(cell);
		cell = createCellVisitanteHandicap(bets, categoryAnalytics);
		result.add(cell);
		cell = super.createCellPago(bets);
		result.add(cell);

		return result;
	}

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.UNO_X_DOS_HANDICAP;
	}

	/**
	 * Checks if is empate handicap attribute.
	 * 
	 * @param pAttribute
	 *            the attribute
	 * @return true, if is empate handicap attribute
	 */
	private boolean isEmpateHandicapAttribute(AbstractRtAttribute pAttribute) {
		boolean result = false;
		Rt1X2HandicapAttribute attribute = (Rt1X2HandicapAttribute) pAttribute;
		if (attribute.getResult().nameId().equals(Result.DRAW.nameId())) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks if is local handicap attribute.
	 * 
	 * @param pAttribute
	 *            the attribute
	 * @return true, if is local handicap attribute
	 */
	private boolean isLocalHandicapAttribute(AbstractRtAttribute pAttribute) {
		boolean result = false;
		Rt1X2HandicapAttribute attribute = (Rt1X2HandicapAttribute) pAttribute;
		if (attribute.getResult().nameId().equals(Result.ONE.nameId())) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks if is visitante handicap attribute.
	 * 
	 * @param pAttribute
	 *            the attribute
	 * @return true, if is visitante handicap attribute
	 */
	private boolean isVisitanteHandicapAttribute(AbstractRtAttribute pAttribute) {
		boolean result = false;
		Rt1X2HandicapAttribute attribute = (Rt1X2HandicapAttribute) pAttribute;
		if (attribute.getResult().nameId().equals(Result.TWO.nameId())) {
			result = true;
		}
		return result;
	}

	@Override
	protected List<TableResponseRowTo> createRowsProbability(
			List<TableResponseRowTo> rowsOdds) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		TableResponseRowTo row;

		List<Double> columnLocal = getColumn(rowsOdds, 2);
		List<Double> columnEmpate = getColumn(rowsOdds, 3);
		List<Double> columnVisitante = getColumn(rowsOdds, 4);

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
