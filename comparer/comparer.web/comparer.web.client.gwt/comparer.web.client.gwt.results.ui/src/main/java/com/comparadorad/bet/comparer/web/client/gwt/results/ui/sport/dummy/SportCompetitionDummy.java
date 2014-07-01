/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.dummy;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;

/**
 * The Class SportCompetitionDummy.
 */
public class SportCompetitionDummy extends GenericDummy {

	/**
	 * Gets the sport countries competitions.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the sport countries competitions
	 */
	public TableResponseTo getSportCountriesCompetitions(String sportId,
			String countryId) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		// if (sportId.equalsIgnoreCase("futbol")
		// && countryId.equalsIgnoreCase("espana")) {
		tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
				"ligaBBVA", "ligaBBVA", null, "Liga BBVA", "2", null));
		tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
				"supercopa", "supercopa", null, "Supercopa de España", "4",
				null));
		tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
				"copaDelRey", "copaDelRey", null, "Copa del Rey", "5", null));
		tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
				"ligaAdelante", "ligaAdelante", null, "Liga Adelante", "3",
				null));
		for (int i = 1; i <= 5; i++) {
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"comp" + Integer.toString(i), "comp" + Integer.toString(i),
					null, Integer.toString(i), Integer.toString(i), null));
		}

		// }
		return tableResponseTo;
	}

}
