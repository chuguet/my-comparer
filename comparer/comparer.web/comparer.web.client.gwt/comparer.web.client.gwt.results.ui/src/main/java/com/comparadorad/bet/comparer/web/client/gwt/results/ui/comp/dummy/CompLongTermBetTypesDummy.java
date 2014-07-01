/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;

/**
 * The Class CompLongTermBetTypesDummy.
 */
public class CompLongTermBetTypesDummy extends GenericDummy {

	/**
	 * Gets the table data.
	 * 
	 * @param eventId
	 *            the competition id
	 * @return the table data
	 */
	public TableResponseTo getTableData(String eventId) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		tableResponseTo.add(getTreeNodeRow(null, eventId + "3", eventId, "3",
				"Ganador", null, "3"));
		tableResponseTo.add(getTreeNodeRow(null, eventId + "7", eventId, "7",
				"Maximo Goleador", null, "7"));
		return tableResponseTo;
	}

}
