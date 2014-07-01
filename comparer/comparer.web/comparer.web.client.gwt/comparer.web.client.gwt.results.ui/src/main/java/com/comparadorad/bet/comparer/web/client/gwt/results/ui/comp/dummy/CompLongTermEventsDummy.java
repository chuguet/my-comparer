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
 * The Class CompLongTermEventsDummy.
 */
public class CompLongTermEventsDummy extends GenericDummy {

	/**
	 * Gets the table data.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the table data
	 */
	public TableResponseTo getTableData(String competitionId) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		if (competitionId.equalsIgnoreCase("ligaBBVA")) {
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"100mlisos", "100mlisos", null, "100 m lisos", null, "2"));
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"200mlisos", "200mlisos", null, "200 m lisos", null, "4"));
			tableResponseTo
					.add(getTreeNodeRow("comparer/country/small/es.png",
							"110mvallas", "110mvallas", null, "110 m vallas",
							null, "5"));
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"saltoDeLongitud", "saltoDeLongitud", null,
					"Salto de longitud", null, "3"));
		} else if (competitionId.equalsIgnoreCase("JuegosOlimpicos")) {
			tableResponseTo.add(getTreeNodeRow("comparer/country/small/es.png",
					"Final", "Final", null, "100 m lisos", null, "2"));
		}
		return tableResponseTo;
	}

}
