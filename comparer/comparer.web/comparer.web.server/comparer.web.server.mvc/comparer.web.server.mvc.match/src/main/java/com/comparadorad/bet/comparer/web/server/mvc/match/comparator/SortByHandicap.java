package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.web.server.mvc.match.beans.AttributeBets;

public class SortByHandicap implements Comparator<AttributeBets> {

	@Override
	public int compare(AttributeBets o1, AttributeBets o2) {
		return o1.getAttribute().getFinalValue()
				.compareTo(o2.getAttribute().getFinalValue());
	}

}
