package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;

public class SortRowsByLinkText implements Comparator<TableResponseRowTo> {

	@Override
	public int compare(TableResponseRowTo o1, TableResponseRowTo o2) {
		int result = 0;
		if (o1.getCellList().get(1).getLinkTo() != null
				&& o2.getCellList().get(1).getLinkTo() != null) {
			return o1.getCellList().get(1).getLinkTo().getName()
					.compareTo(o2.getCellList().get(1).getLinkTo().getName());
		}
		return result;
	}

}
