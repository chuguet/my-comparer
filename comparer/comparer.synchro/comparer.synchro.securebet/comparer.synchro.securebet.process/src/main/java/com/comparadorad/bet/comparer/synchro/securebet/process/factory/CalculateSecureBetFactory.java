package com.comparadorad.bet.comparer.synchro.securebet.process.factory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate.ICalculateSecureBet;

@Service
public class CalculateSecureBetFactory extends
		AbstractCalculateSecureBetFactory {

	@Inject
	private List<ICalculateSecureBet> calculateSecureBets;

	@Override
	public ICalculateSecureBet calculateSecureBet(CfgBetType cfgBetType) {
		ICalculateSecureBet result = null;
		for (ICalculateSecureBet calculateSecureBet : calculateSecureBets) {
			if (calculateSecureBet.getTipeCalculateSecureBet().getBetTypeId()
					.nameId().equals(cfgBetType.getNameId().toString())) {
				result = calculateSecureBet;
				break;
			}
		}
		return result;
	}

}
