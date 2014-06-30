package com.comparadorad.bet.comparer.synchro.securebet.process.factory;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate.ICalculateSecureBet;

public interface ICalculateSecureBetFactory {
	
	ICalculateSecureBet calculateSecureBet(CfgBetType cfgBetType);
}
