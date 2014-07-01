/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseDataTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetTypeEvent;

/**
 * The Class BetTypeEventsDummy.
 */
public class BetTypeEventsDummy {

	/**
	 * Gets the tab data.
	 * 
	 * @param eventId
	 *            the event id
	 * @param betTypeId
	 *            the bet type id
	 * @return the tab data
	 */
	public TabResponseTo getTabData(String eventId, String betTypeId) {
		TabResponseTo tabResponseTo = new TabResponseTo();
		if (eventId.equalsIgnoreCase("RealMadridVsBarcelona")) {
			if (betTypeId.equalsIgnoreCase(BetType.UNO_X_DOS.getId())) {
				TabResponseDataTo tab1 = new TabResponseDataTo(new ObjectToId(
						BetTypeEvent.FINAL_PARTIDO.getId()), "Final partido");
				TabResponseDataTo tab2 = new TabResponseDataTo(new ObjectToId(
						BetTypeEvent.FINAL_PRIMERA_PARTE.getId()),
						"Final primera parte");
				TabResponseDataTo tab3 = new TabResponseDataTo(new ObjectToId(
						BetTypeEvent.FINAL_SEGUNDA_PARTE.getId()),
						"Final segunda parte");
				tabResponseTo.addTab(tab1);
				tabResponseTo.addTab(tab2);
				tabResponseTo.addTab(tab3);
			} else if (betTypeId.equalsIgnoreCase(BetType.GANADOR.getId())) {
				tabResponseTo = new TabResponseTo();
			} else if (betTypeId.equalsIgnoreCase(BetType.GANADOR_DE_PARTIDO
					.getId())) {
				tabResponseTo = new TabResponseTo();
			} else if (betTypeId.equalsIgnoreCase(BetType.HANDICAP_ASIATICO
					.getId())) {
				TabResponseDataTo tab1 = new TabResponseDataTo(new ObjectToId(
						BetTypeEvent.FINAL_PARTIDO.getId()), "Final partido");
				TabResponseDataTo tab2 = new TabResponseDataTo(new ObjectToId(
						BetTypeEvent.FINAL_PRIMERA_PARTE.getId()),
						"Final primera parte");
				TabResponseDataTo tab3 = new TabResponseDataTo(new ObjectToId(
						BetTypeEvent.FINAL_SEGUNDA_PARTE.getId()),
						"Final segunda parte");
				tabResponseTo.addTab(tab1);
				tabResponseTo.addTab(tab2);
				tabResponseTo.addTab(tab3);
			} else if (betTypeId.equalsIgnoreCase(BetType.MAS_MENOS.getId())) {
				tabResponseTo = new TabResponseTo();
			} else if (betTypeId.equalsIgnoreCase(BetType.MAXIMO_GOLEADOR
					.getId())) {
				tabResponseTo = new TabResponseTo();
			} else if (betTypeId.equalsIgnoreCase(BetType.UNO_X_DOS_HANDICAP
					.getId())) {
				tabResponseTo = new TabResponseTo();
			}
		} else if (eventId.equalsIgnoreCase("100mlisos")) {
			if (betTypeId.equalsIgnoreCase(BetType.GANADOR.getId())) {
				tabResponseTo = new TabResponseTo();
			} else if (betTypeId.equalsIgnoreCase(BetType.MAXIMO_GOLEADOR
					.getId())) {
				tabResponseTo = new TabResponseTo();
			}
		}
		return tabResponseTo;
	}

}
