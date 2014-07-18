/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;

/**
 * The Class SortDescendingTableResponseRowToByOdd.
 */
public class SortRowsByOdd implements Comparator<TableResponseRowTo> {

	/** {@inheritDoc} */
	@Override
	public int compare(TableResponseRowTo o1, TableResponseRowTo o2) {
		return Float.valueOf(
				o1.getCellList().get(2).getValueTo().getValueStr()
						.replace(",", ".")).compareTo(
				Float.valueOf(o2.getCellList().get(2).getValueTo()
						.getValueStr().replace(",", ".")));
	}

}