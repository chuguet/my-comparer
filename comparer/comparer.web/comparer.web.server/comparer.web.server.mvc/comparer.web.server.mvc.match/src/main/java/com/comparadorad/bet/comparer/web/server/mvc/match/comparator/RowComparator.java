/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import org.apache.commons.lang.StringUtils;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;

/**
 * The Class TableResponseToComparator.
 */
public class RowComparator implements Comparator<TableResponseRowTo> {

	/** {@inheritDoc} */
	@Override
	public int compare(TableResponseRowTo row1, TableResponseRowTo row2) {
		int result;
		String date1 = row1.getCellList().get(0).getValueTo().getDate();
		String date2 = row2.getCellList().get(0).getValueTo().getDate();
		if (StringUtils.isNotEmpty(date1) && StringUtils.isNotEmpty(date2)) {
			result = date1.compareTo(date2);
		} else {
			result = 0;
		}
		return result;
	}
}