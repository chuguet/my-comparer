package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;

public class SortTableByValueStr implements Comparator<TableResponseRowTo> {

	@Override
	public int compare(TableResponseRowTo row1, TableResponseRowTo row2) {
		return Double.valueOf(
				row1.getCellList().get(2).getValueTo().getValueStr())
				.compareTo(
						Double.valueOf(row2.getCellList().get(2).getValueTo()
								.getValueStr()));
	}
}
