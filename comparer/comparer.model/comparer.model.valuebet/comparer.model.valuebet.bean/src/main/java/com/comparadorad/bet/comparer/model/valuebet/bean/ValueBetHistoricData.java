package com.comparadorad.bet.comparer.model.valuebet.bean;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class ValueBetHistoric.
 */
@SuppressWarnings("serial")
public class ValueBetHistoricData extends AbstractValueBetData {

	/**
	 * Instantiates a new value bet historic data.
	 */
	public ValueBetHistoricData() {
		super();
	}

	/**
	 * Instantiates a new value bet historic data.
	 * 
	 * @param match
	 *            the match
	 * @param attribute
	 *            the attribute
	 * @param bet
	 *            the bet
	 * @param probability
	 *            the probability
	 * @param mathematicalExpectation
	 *            the mathematical expectation
	 */
	public ValueBetHistoricData(InfoMatch infoMatch,
			AbstractRtAttribute attribute, RtBet bet,
			ValueBetProbability probability,
			ValueBetMathematicalExpectation mathematicalExpectation,
			RtBetTypeEvent betTypeEvent) {
		super(infoMatch, bet, probability, mathematicalExpectation,
				betTypeEvent);
	}

}
