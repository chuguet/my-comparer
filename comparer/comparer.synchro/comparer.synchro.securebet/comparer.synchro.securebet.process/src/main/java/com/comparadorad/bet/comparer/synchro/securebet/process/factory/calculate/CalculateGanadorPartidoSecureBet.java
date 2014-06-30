package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import org.springframework.stereotype.Component;

@Component
public class CalculateGanadorPartidoSecureBet extends AbstractCalculateOrder2 {

	@Override
	public CalculateSecureBetEnum getTipeCalculateSecureBet() {
		return CalculateSecureBetEnum.GANADOR_PARTIDO;
	}

}
