package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

public abstract class AbstractCalculateOrderN extends
		AbstractCalculateSecureBet {
	@Override
	protected Integer getOrderCombinations(Integer numParticipantes) {
		return numParticipantes;
	}
}
