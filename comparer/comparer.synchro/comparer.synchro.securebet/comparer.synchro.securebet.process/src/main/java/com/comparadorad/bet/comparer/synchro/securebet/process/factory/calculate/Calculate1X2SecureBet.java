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
 * The Class Calculate1X2SecureBet.
 */
@Component
public class Calculate1X2SecureBet extends AbstractCalculateOrder3 {

	@Override
	public CalculateSecureBetEnum getTipeCalculateSecureBet() {
		return CalculateSecureBetEnum.UNO_X_DOS;
	}
}
