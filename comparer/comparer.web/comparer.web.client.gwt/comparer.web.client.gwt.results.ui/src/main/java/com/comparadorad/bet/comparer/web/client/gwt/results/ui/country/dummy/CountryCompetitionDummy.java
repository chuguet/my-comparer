/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.dummy;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;

/**
 * The Class CountryCompetitionDummy.
 */
public class CountryCompetitionDummy extends GenericDummy {

	/**
	 * Gets the country events competition.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the country events competition
	 */
	public TableResponseTo getCountryEventsCompetition(String sportId,
			String countryId) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		if (sportId.equalsIgnoreCase("futbol")
				&& countryId.equalsIgnoreCase("espana")) {
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"ligaBBVA", "ligaBBVA", null, "Liga BBVA", null, "2"));
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"supercopa", "supercopa", null, "Supercopa de España",
					null, "4"));
			tableResponseTo
					.add(getTreeNodeRow("comparer/country/small/es.png",
							"copaDelRey", "copaDelRey", null, "Copa del Rey",
							null, "5"));
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"ligaAdelante", "ligaAdelante", null, "Liga Adelante",
					null, "3"));
		}
		return tableResponseTo;
	}

	/**
	 * Gets the country long term competition.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the country long term competition
	 */
	public TableResponseTo getCountryLongTermCompetition(String sportId,
			String countryId) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		if (sportId.equalsIgnoreCase("futbol")
				&& countryId.equalsIgnoreCase("espana")) {
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"ligaBBVA", "ligaBBVA", null, "Liga BBVA", null, "2"));
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"supercopa", "supercopa", null, "Supercopa de España",
					null, "4"));
			tableResponseTo
					.add(getTreeNodeRow("comparer/country/small/es.png",
							"copaDelRey", "copaDelRey", null, "Copa del Rey",
							null, "5"));
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"ligaAdelante", "ligaAdelante", null, "Liga Adelante",
					null, "3"));
		}
		return tableResponseTo;
	}

}
