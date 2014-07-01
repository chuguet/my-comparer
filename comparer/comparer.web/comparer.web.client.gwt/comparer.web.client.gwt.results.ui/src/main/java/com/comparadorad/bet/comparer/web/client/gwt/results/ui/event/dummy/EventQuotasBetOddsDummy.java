/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy;

import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;

/**
 * The Class EventQuotasBetOddsDummyService.
 */
public class EventQuotasBetOddsDummy {

	/**
	 * Gets the table data.
	 * 
	 * @param eventId
	 *            the event id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEventId
	 *            the bet type event id
	 * @return the table data
	 */
	public List<TableResponseTo> getTableData(String eventId, String betTypeId,
			String betTypeEventId) {

		List<TableResponseTo> list = null;
		;
		if (eventId.equalsIgnoreCase("RealMadridVsBarcelona")) {
			if (betTypeId.equalsIgnoreCase(BetType.UNO_X_DOS.getId())) {
				TableUnoXDosDummy dummy = new TableUnoXDosDummy();
				list = dummy.getTableData(betTypeEventId);
			} else if (betTypeId.equalsIgnoreCase(BetType.GANADOR.getId())
					|| betTypeId.equalsIgnoreCase(BetType.MAXIMO_GOLEADOR
							.getId())) {
				TableGanadorYMaximoGoleadorDummy dummy = new TableGanadorYMaximoGoleadorDummy();
				list = dummy.getTableData(betTypeEventId);
			} else if (betTypeId.equalsIgnoreCase(BetType.GANADOR_DE_PARTIDO
					.getId())) {
				TableGanadorPartidoDummy dummy = new TableGanadorPartidoDummy();
				list = dummy.getTableData(betTypeEventId);
			} else if (betTypeId.equalsIgnoreCase(BetType.HANDICAP_ASIATICO
					.getId())) {
				TableHandicapAsiaticoDummy dummy = new TableHandicapAsiaticoDummy();
				list = dummy.getTableData(betTypeEventId);
			} else if (betTypeId.equalsIgnoreCase(BetType.MAS_MENOS.getId())) {
				TableMasMenosDummy dummy = new TableMasMenosDummy();
				list = dummy.getTableData(betTypeEventId);
			} else if (betTypeId.equalsIgnoreCase(BetType.UNO_X_DOS_HANDICAP
					.getId())) {
				TableUnoXDosHandicapDummy dummy = new TableUnoXDosHandicapDummy();
				list = dummy.getTableData(betTypeEventId);
			}
		} else if (eventId.equalsIgnoreCase("100mLisos")) {
			if (betTypeId.equalsIgnoreCase(BetType.GANADOR.getId())
					|| betTypeId.equalsIgnoreCase(BetType.MAXIMO_GOLEADOR
							.getId())) {
				TableLTGanadorYMaximoGoleadorDummy dummy = new TableLTGanadorYMaximoGoleadorDummy(
						0);
				list = dummy.getTableData(eventId, betTypeId);
			}
		}
		return list;
	}
}
