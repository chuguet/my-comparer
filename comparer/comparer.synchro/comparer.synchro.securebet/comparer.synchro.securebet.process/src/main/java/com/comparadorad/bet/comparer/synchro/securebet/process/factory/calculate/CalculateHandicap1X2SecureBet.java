/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import org.springframework.stereotype.Component;

/**
 * The Class CalculateHandicap1X2SecureBet.
 */
@Component
public class CalculateHandicap1X2SecureBet extends
		AbstractCalculateSeveralMarkestByParticipant {

	private static final Integer ORDER_COMBINATION = 3;

	/** {@inheritDoc} */
	@Override
	public CalculateSecureBetEnum getTipeCalculateSecureBet() {
		return CalculateSecureBetEnum.UNO_X_DOS_HANDICAP;
	}

	@Override
	protected Integer getOrderCombinations(Integer numParticipants) {
		return ORDER_COMBINATION;
	}

}
