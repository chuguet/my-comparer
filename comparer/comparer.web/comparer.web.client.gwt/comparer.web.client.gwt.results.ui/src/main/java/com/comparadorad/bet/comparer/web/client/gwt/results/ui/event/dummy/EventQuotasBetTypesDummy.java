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
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;

/**
 * The Class EventQuotasBetTypesDummyService.
 */
public class EventQuotasBetTypesDummy extends GenericDummy {

	/**
	 * Gets the tab data.
	 * 
	 * @param eventId
	 *            the event id
	 * @return the tab data
	 */
	public TabResponseTo getTabData(String eventId) {

		TabResponseTo tabResponseTo = new TabResponseTo();
		if (eventId.equalsIgnoreCase("RealMadridVsBarcelona")) {
			TabResponseDataTo tab1 = new TabResponseDataTo(new ObjectToId(
					BetType.UNO_X_DOS.getId()), "1X2");
			TabResponseDataTo tab2 = new TabResponseDataTo(new ObjectToId(
					BetType.GANADOR.getId()), "Ganador");
			TabResponseDataTo tab3 = new TabResponseDataTo(new ObjectToId(
					BetType.GANADOR_DE_PARTIDO.getId()), "Ganador partido");
			TabResponseDataTo tab4 = new TabResponseDataTo(new ObjectToId(
					BetType.UNO_X_DOS_HANDICAP.getId()), "1x2 Hándicap");
			TabResponseDataTo tab5 = new TabResponseDataTo(new ObjectToId(
					BetType.HANDICAP_ASIATICO.getId()), "Hándicap asiático");
			TabResponseDataTo tab6 = new TabResponseDataTo(new ObjectToId(
					BetType.MAS_MENOS.getId()), "Mas/Menos");
			TabResponseDataTo tab7 = new TabResponseDataTo(new ObjectToId(
					BetType.MAXIMO_GOLEADOR.getId()), "Maximo goleador");
			tabResponseTo.addTab(tab1);
			tabResponseTo.addTab(tab2);
			tabResponseTo.addTab(tab3);
			tabResponseTo.addTab(tab4);
			tabResponseTo.addTab(tab5);
			tabResponseTo.addTab(tab6);
			tabResponseTo.addTab(tab7);
		} else if (eventId.equalsIgnoreCase("100mLisos")) {
			TabResponseDataTo tab1 = new TabResponseDataTo(new ObjectToId(
					BetType.GANADOR.getId()), "Ganador");
			tabResponseTo.addTab(tab1);
			TabResponseDataTo tab2 = new TabResponseDataTo(new ObjectToId(
					BetType.MAXIMO_GOLEADOR.getId()), "Máximo goleador");
			tabResponseTo.addTab(tab2);
		}

		return tabResponseTo;
	}

}
