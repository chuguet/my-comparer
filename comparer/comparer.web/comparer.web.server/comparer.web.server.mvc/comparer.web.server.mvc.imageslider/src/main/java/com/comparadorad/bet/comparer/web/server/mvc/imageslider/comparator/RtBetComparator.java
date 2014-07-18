package com.comparadorad.bet.comparer.web.server.mvc.imageslider.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

public class RtBetComparator implements Comparator<RtBet> {

	@Override
	public int compare(RtBet bet1, RtBet bet2) {
		return Double.valueOf(bet1.getBetOdd().getOdds()).compareTo(
				Double.valueOf(bet2.getBetOdd().getOdds()));
	}

}
