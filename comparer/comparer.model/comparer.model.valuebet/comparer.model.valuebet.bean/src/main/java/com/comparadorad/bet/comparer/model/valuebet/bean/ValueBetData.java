package com.comparadorad.bet.comparer.model.valuebet.bean;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class ValueBet.
 */
@SuppressWarnings("serial")
public class ValueBetData extends AbstractValueBetData {

	/**
	 * Instantiates a new value bet data.
	 */
	public ValueBetData() {
		super();
	}

	/**
	 * Instantiates a new value bet data.
	 * 
	 * @param match
	 *            the match
	 * @param bet
	 *            the bet
	 * @param probability
	 *            the probability
	 * @param betHope
	 *            the bet hope
	 */
	public ValueBetData(InfoMatch infoMatch, RtBet bet,
			ValueBetProbability probability,
			ValueBetMathematicalExpectation betHope, RtBetTypeEvent betTypeEvent) {
		super(infoMatch, bet, probability, betHope, betTypeEvent);
	}

}
