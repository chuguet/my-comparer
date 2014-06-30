/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.calculate;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

@Component
class CalculateValueBetMaximoGoleador extends
		AbstractDecoratorCalculateValueBetNoListBets {

	/** {@inheritDoc} */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.MAXIMO_GOLEADOR;
	}

}
