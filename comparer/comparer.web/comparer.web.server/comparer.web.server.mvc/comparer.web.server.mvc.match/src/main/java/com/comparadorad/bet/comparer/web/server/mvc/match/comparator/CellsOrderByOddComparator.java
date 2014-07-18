package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;

public class CellsOrderByOddComparator implements
		Comparator<TableResponseCellTo> {

	@Override
	public int compare(TableResponseCellTo o1, TableResponseCellTo o2) {
		return Double.valueOf(o1.getExternalLinkTo().getLinkText()).compareTo(
				Double.valueOf(o2.getExternalLinkTo().getLinkText()));
	}

}
