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
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;

/**
 * The Class MakeTableEventHandicapAsiatico.
 */
@Component
public final class MakeTableEventHandicapAsiatico extends
		MakeTableEventDecoratorHandicap {

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.HANDICAP_ASIATICO;
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

		cell = createCellLocalAsiatico(bets, categoryAnalytics);
		result.add(cell);
		cell = createCellVisitanteAsiatico(bets, categoryAnalytics);
		result.add(cell);
		cell = super.createCellPago(bets);
		result.add(cell);

		return result;
	}

	/**
	 * Creates the cell visitante asiatico.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellVisitanteAsiatico(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (isVisitanteAsianAttribute(bet.getAttribute())) {
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
	 * Creates the cell local asiatico.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellLocalAsiatico(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (isLocalAsianAttribute(bet.getAttribute())) {
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
	 * Checks if is visitante asian attribute.
	 * 
	 * @param pAttribute
	 *            the attribute
	 * @return true, if is visitante asian attribute
	 */
	private boolean isVisitanteAsianAttribute(AbstractRtAttribute pAttribute) {
		boolean result = false;
		RtAsianHandicapAttribute attribute = (RtAsianHandicapAttribute) pAttribute;
		if (attribute.getAsianResult().nameId()
				.equals(AsianResult.TWO.nameId())) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks if is local asian attribute.
	 * 
	 * @param pAttribute
	 *            the attribute
	 * @return true, if is local asian attribute
	 */
	private boolean isLocalAsianAttribute(AbstractRtAttribute pAttribute) {
		boolean result = false;
		RtAsianHandicapAttribute attribute = (RtAsianHandicapAttribute) pAttribute;
		if (attribute.getAsianResult().nameId()
				.equals(AsianResult.ONE.nameId())) {
			result = true;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent
	 * .MakeTableEventDecoratorHandicap#createRowsProbability(java.util.List)
	 */
	@Override
	protected List<TableResponseRowTo> createRowsProbability(
			List<TableResponseRowTo> rowsOdds) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		TableResponseRowTo row;

		List<Double> columnLocal = getColumn(rowsOdds, 2);
		List<Double> columnVisitante = getColumn(rowsOdds, 3);

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
}
