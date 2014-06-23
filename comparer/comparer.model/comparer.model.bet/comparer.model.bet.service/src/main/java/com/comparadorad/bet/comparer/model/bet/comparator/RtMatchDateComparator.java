package com.comparadorad.bet.comparer.model.bet.comparator;

import java.util.Comparator;
import java.util.Date;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

public class RtMatchDateComparator implements Comparator<RtMatch> {

	@Override
	public int compare(RtMatch o1, RtMatch o2) {
		Date d1 = ((RtMatch) o1).getMatchId().getStartDate()
				.getZeroGmtMatchDate();
		Date d2 = ((RtMatch) o2).getMatchId().getStartDate()
				.getZeroGmtMatchDate();
		return d1.compareTo(d2);
	}

}
