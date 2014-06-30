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
 * The Class CalculateGanadorSecureBet.
 */
@Component
public class CalculateGanadorSecureBet extends AbstractCalculateOrderN {
	
	/** {@inheritDoc} */ 
	@Override
	protected Boolean isActive(){
		return Boolean.FALSE;
	}

	/** {@inheritDoc} */ 
	@Override
	public CalculateSecureBetEnum getTipeCalculateSecureBet() {
		return CalculateSecureBetEnum.GANADOR;
	}

}
