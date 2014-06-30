package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;

public interface ICalculateSecureBet {

	SureBetsMatch calculateSecureBetForRtMarket(RtMatch rtMatch,
			RtMarket rtMarket);

	public CalculateSecureBetEnum getTipeCalculateSecureBet();

}
