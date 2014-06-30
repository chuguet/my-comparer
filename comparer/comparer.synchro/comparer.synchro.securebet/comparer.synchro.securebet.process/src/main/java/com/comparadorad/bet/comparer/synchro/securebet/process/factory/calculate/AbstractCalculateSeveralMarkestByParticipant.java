package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.IHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;

public abstract class AbstractCalculateSeveralMarkestByParticipant extends
		AbstractCalculateSecureBet {

	public SureBetsMatch calculateSecureBetForRtMarket(
			RtMatch rtMatch, RtMarket rtMarket) {
		SureBetsMatch result = new SureBetsMatch();
		SureBetsMatch calculateSecureBetBean;
		List<RtMarket> rtMarkets;

		rtMarkets = rtMarketForAttribute(rtMarket);

		for (RtMarket market : rtMarkets) {
			calculateSecureBetBean = super.calculateSecureBetForRtMarket(
					rtMatch, market);
			for (SureBetsMarket secureBetBean : calculateSecureBetBean
					.getSureBetsMarket()) {
				result.add(secureBetBean);
			}
		}
		return result;
	}

	protected List<RtMarket> rtMarketForAttribute(RtMarket market) {

		List<RtMarket> result = new ArrayList<RtMarket>();
		Map<AttributeWrapper, Set<RtBet>> map = new HashMap<AttributeWrapper, Set<RtBet>>();
		Set<RtBet> rtbets;
		RtMarket rtMarket;

		for (RtBet rtBet : market.getBets()) {
			if(rtBet.getAttribute().isValidForSurebet()){
				AttributeWrapper attribute = new AttributeWrapper(
						(IHandicapAttribute) rtBet.getAttribute());
				if (map.containsKey(attribute)) {
					rtbets = map.get(attribute);
				} else {
					rtbets = new HashSet<RtBet>();
				}
				rtbets.add(rtBet);
				map.put(attribute, rtbets);
			}
		}

		for (AttributeWrapper attribute : map.keySet()) {
			rtMarket = (RtMarket) market.clone();
			rtbets = map.get(attribute);
			rtMarket.setBets(rtbets);
			result.add(rtMarket);
		}

		return result;

	}

	protected class AttributeWrapper {

		private final IHandicapAttribute attribute;

		public AttributeWrapper(IHandicapAttribute attribute) {
			this.attribute = attribute;
		}

		@Override
		public int hashCode() {
			return 31;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AttributeWrapper other = (AttributeWrapper) obj;
			if (attribute == null) {
				if (other.attribute != null)
					return false;
			} else if (!attribute.getFinalValue().equals(
					other.attribute.getFinalValue())) {
				return false;
			}
			return true;
		}

		public IHandicapAttribute getAttribute() {
			return attribute;
		}

	}

}
