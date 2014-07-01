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
 * The Class SportCountriesDummy.
 */
public class SportCountriesDummy extends GenericDummy {

	/**
	 * Gets the sport countries countries.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the sport countries countries
	 */
	public TableResponseTo getSportCountriesCountries(String sportId) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		// if (sportId.equalsIgnoreCase("futbol")) {
		tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
				"espana", "espana", "sport", "España", "4", "2"));
		tableResponseTo.add(getTreeNodeRow("comparer/country/small/de.png",
				"alemania", "alemania", "sport", "Alemania", "2", "4"));
		tableResponseTo.add(getTreeNodeRow("comparer/country/small/it.png",
				"italia", "italia", "sport", "Italia", "4", "5"));
		tableResponseTo.add(getTreeNodeRow("comparer/country/small/se.png",
				"suecia", "suecia", "sport", "Suecia", "6", "3"));
		// }
		return tableResponseTo;
	}

}
