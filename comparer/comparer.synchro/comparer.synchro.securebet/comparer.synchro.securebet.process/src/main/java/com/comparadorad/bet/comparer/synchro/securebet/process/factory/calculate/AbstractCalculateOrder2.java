package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

public abstract class AbstractCalculateOrder2 extends
		AbstractCalculateSecureBet {

	private static final Integer ORDER_COMBINATION = 2;

	@Override
	protected Integer getOrderCombinations(Integer numParticipantes) {
		return ORDER_COMBINATION;
	}
}
