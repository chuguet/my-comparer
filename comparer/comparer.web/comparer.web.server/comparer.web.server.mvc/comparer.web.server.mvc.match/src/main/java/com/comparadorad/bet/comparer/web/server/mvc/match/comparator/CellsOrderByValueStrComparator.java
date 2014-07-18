package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;

public class CellsOrderByValueStrComparator implements
		Comparator<TableResponseCellTo> {

	@Override
	public int compare(TableResponseCellTo cell1, TableResponseCellTo cell2) {
		return Double.valueOf(cell1.getValueTo().getValueStr()).compareTo(
				Double.valueOf(cell2.getValueTo().getValueStr()));
	}

}
