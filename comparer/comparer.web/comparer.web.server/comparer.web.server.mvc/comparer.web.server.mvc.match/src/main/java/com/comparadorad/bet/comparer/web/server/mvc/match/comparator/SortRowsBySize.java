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
 * The Class SortRowsBySize.
 */
public class SortRowsBySize implements Comparator<TableResponseRowTo> {

	/**
	 * Compare.
	 * 
	 * @param row1
	 *            the row1
	 * @param row2
	 *            the row2
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int compare(TableResponseRowTo row1, TableResponseRowTo row2) {
		return Integer.valueOf(row2.getCellList().size()).compareTo(
				Integer.valueOf(row1.getCellList().size()));
	}
}
