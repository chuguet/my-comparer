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
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;

/**
 * The Class MakeTableEventMasMenos.
 */
@Component
public final class MakeTableEventMasMenos extends
		MakeTableEventDecoratorHandicap {

	/**
	 * Creates the cell mas.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellMas(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (isMasAttribute(bet.getAttribute())) {
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
	 * Creates the cell menos.
	 * 
	 * @param bets
	 *            the bets
	 * @return the table response cell to
	 */
	private TableResponseCellTo createCellMenos(List<RtBet> bets, String categoryAnalytics) {
		TableResponseCellTo result = new TableResponseCellTo();
		for (RtBet bet : bets) {
			if (isMenosAttribute(bet.getAttribute())) {
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

		cell = createCellMas(bets, categoryAnalytics);
		result.add(cell);
		cell = createCellMenos(bets, categoryAnalytics);
		result.add(cell);
		cell = super.createCellPago(bets);
		result.add(cell);

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

		List<Double> columnMas = getColumn(rowsOdds, 2);
		List<Double> columnMenos = getColumn(rowsOdds, 3);

		List<Double> oddColumnMas = createColumnProbability(columnMas);
		List<Double> oddColumnMenos = createColumnProbability(columnMenos);

		Double payoutMedio = calculatePayoutMedio(oddColumnMas, null,
				oddColumnMenos);
		Double payoutValorAlto = calculatePayoutValorAlto(oddColumnMas, null,
				oddColumnMenos);

		row = createRowProbability(oddColumnMas, null, oddColumnMenos, 0,
				payoutMedio);
		result.add(row);

		row = createRowProbability(oddColumnMas, null, oddColumnMenos, 1,
				payoutValorAlto);
		result.add(row);

		row = createRowProbability(oddColumnMas, null, oddColumnMenos, 2,
				payoutMedio);
		result.add(row);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.table.IMakeTable#
	 * getBetTypeId()
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.MAS_MENOS;
	}

	/**
	 * Checks if is mas attribute.
	 * 
	 * @param pAttribute
	 *            the attribute
	 * @return true, if is mas attribute
	 */
	private boolean isMasAttribute(AbstractRtAttribute pAttribute) {
		boolean result = false;
		RtMasMenosAttribute attribute = (RtMasMenosAttribute) pAttribute;
		if (attribute.getMasMenos().nameId().equals(MasMenos.MAS.nameId())) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks if is menos attribute.
	 * 
	 * @param pAttribute
	 *            the attribute
	 * @return true, if is menos attribute
	 */
	private boolean isMenosAttribute(AbstractRtAttribute pAttribute) {
		boolean result = false;
		RtMasMenosAttribute attribute = (RtMasMenosAttribute) pAttribute;
		if (attribute.getMasMenos().nameId().equals(MasMenos.MENOS.nameId())) {
			result = true;
		}
		return result;
	}

}
