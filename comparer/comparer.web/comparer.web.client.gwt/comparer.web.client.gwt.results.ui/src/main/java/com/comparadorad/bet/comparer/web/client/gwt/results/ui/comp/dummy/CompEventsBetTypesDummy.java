/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseDataTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;

/**
 * The Class CompEventsBetTypesDummy.
 */
public class CompEventsBetTypesDummy extends GenericDummy {

	/**
	 * Gets the tab data.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the tab data
	 */
	public TabResponseTo getTabData(String competitionId) {

		TabResponseTo tabResponseTo = new TabResponseTo();
		if (competitionId.equalsIgnoreCase("ligaBBVA")) {
			TabResponseDataTo tab1 = new TabResponseDataTo(new ObjectToId(
					BetType.UNO_X_DOS.getId()), "1X2");
			TabResponseDataTo tab2 = new TabResponseDataTo(new ObjectToId(
					BetType.GANADOR.getId()), "Ganador");
			TabResponseDataTo tab3 = new TabResponseDataTo(new ObjectToId(
					BetType.GANADOR_DE_PARTIDO.getId()), "Ganador partido");
			tabResponseTo.addTab(tab2);
			tabResponseTo.addTab(tab3);
			tabResponseTo.addTab(tab1);
		}

		return tabResponseTo;
	}
}
