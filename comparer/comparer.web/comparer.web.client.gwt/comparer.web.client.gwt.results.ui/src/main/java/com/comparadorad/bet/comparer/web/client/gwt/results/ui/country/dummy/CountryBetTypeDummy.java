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
 * The Class CountryBetTypeDummy.
 */
public class CountryBetTypeDummy extends GenericDummy {

	/**
	 * Gets the country long term bet type.
	 * 
	 * @param compId
	 *            the comp id
	 * @return the country long term bet type
	 */
	public TableResponseTo getCountryLongTermBetType(String compId) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		// if (compId.equalsIgnoreCase("LigaBBVA")) {
		tableResponseTo.add(getTreeNodeRow(null, compId + "3", compId, "3",
				"Ganador", null, "3"));
		tableResponseTo.add(getTreeNodeRow(null, compId + "7", compId, "7",
				"Maximo Goleador", null, "3"));
		// }
		return tableResponseTo;
	}

}
