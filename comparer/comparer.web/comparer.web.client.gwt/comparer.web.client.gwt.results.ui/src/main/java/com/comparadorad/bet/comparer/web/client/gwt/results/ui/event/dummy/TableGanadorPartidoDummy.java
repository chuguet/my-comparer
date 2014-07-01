/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;

/**
 * The Class TableGanadorPartidoDummy.
 */
public class TableGanadorPartidoDummy extends GenericDummy {

	/**
	 * Gets the table data.
	 * 
	 * @param pBetTypeEventId
	 *            the bet type event id
	 * @return the table data
	 */
	public List<TableResponseTo> getTableData(String pBetTypeEventId) {
		List<TableResponseTo> list = new ArrayList<TableResponseTo>();

		if (pBetTypeEventId == null) {
			TableResponseTo tableResponseTo = new TableResponseTo();
			tableResponseTo.setObjectToId(new ObjectToId("11"));
			tableResponseTo.add(getRow("betFred",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com",
					new String[] { "3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com", getRandomUrl() }, "98%"));
			tableResponseTo.add(getRow(new String[] { getRandom(10, 99), "1.2",
					"93%" }));
			tableResponseTo.add(getRow(new String[] { getRandom(10, 99), "1.2",
					"93%" }));
			tableResponseTo
					.add(getRow(new String[] { getRandom(10, 99), "1.2" }));
			list.add(tableResponseTo);
		}
		return list;
	}

}
