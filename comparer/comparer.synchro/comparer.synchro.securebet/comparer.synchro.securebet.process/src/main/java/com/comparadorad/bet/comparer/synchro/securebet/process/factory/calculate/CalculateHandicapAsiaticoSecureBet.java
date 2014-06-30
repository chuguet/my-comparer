package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import org.springframework.stereotype.Component;

@Component
public class CalculateHandicapAsiaticoSecureBet extends
		AbstractCalculateSeveralMarkestByParticipant {

	@Override
	public CalculateSecureBetEnum getTipeCalculateSecureBet() {
		return CalculateSecureBetEnum.HANDICAP_ASIATICO;
	}

	private static final Integer ORDER_COMBINATION = 2;

	@Override
	protected Integer getOrderCombinations(Integer numParticipantes) {
		return ORDER_COMBINATION;
	}

}
