package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.securebet.process.combination.RtBetCombination;
import com.comparadorad.bet.comparer.synchro.securebet.process.convert.IListRtBetToSecureBetBeanConverter;

@Component
public final class CalculateMasMenosSecureBet extends AbstractCalculateOrder2 {

	@Inject
	private IListRtBetToSecureBetBeanConverter<List<List<RtBet>>, SureBetsMarket> convert;

	@Override
	public CalculateSecureBetEnum getTipeCalculateSecureBet() {
		return CalculateSecureBetEnum.MAS_MENOS;
	}

	@Override
	public SureBetsMatch calculateSecureBetForRtMarket(
			RtMatch rtMatch, RtMarket rtMarket) {
		SureBetsMatch result = new SureBetsMatch();
		List<RtMarket> rtMarkets;

		rtMarkets = rtMarketForAttribute(rtMarket);

		for (RtMarket market : rtMarkets) {
			List<List<RtBet>> findSecureBet = findBetSecure(market.getBets());
			result.add(convert.convert(rtMatch, rtMarket, findSecureBet));
		}

		return result;
	}

	private List<List<RtBet>> findBetSecure(Set<RtBet> rtbets) {
		Map<MasMenos, Set<RtBet>> rtBetForMasMenos;
		List<List<RtBet>> rtBetCombinations;
		List<List<RtBet>> secureBet;

		rtBetForMasMenos = rtbetsForMasMenos(rtbets);
		rtBetCombinations = getRtBetCombinations(rtBetForMasMenos);
		secureBet = searchBetsecure(rtBetCombinations);

		return secureBet;

	}

	private List<List<RtBet>> getRtBetCombinations(Map<MasMenos, Set<RtBet>> map) {
		List<RtBet[]> groupbets = new ArrayList<RtBet[]>();
		List<RtBet> bets;
		RtBetCombination combination;

		for (MasMenos masMenos : map.keySet()) {
			bets = new ArrayList<RtBet>();
			for (RtBet rtBet : map.get(masMenos)) {
				bets.add(rtBet);
			}
			groupbets.add(bets.toArray(new RtBet[bets.size()]));
		}
		combination = new RtBetCombination(groupbets);

		return combination.getCombinations(getOrderCombinations(2));
	}

	private Map<MasMenos, Set<RtBet>> rtbetsForMasMenos(Set<RtBet> aRtbets) {

		Map<MasMenos, Set<RtBet>> result = new HashMap<MasMenos, Set<RtBet>>();
		MasMenos masMenos;
		Set<RtBet> rtbets;

		for (RtBet rtBet : aRtbets) {
			masMenos = ((RtMasMenosAttribute) rtBet.getAttribute())
					.getMasMenos();
			if (result.containsKey(masMenos)) {
				rtbets = result.get(masMenos);
			} else {
				rtbets = new HashSet<RtBet>();
			}
			rtbets.add(rtBet);
			result.put(masMenos, rtbets);

		}

		return result;

	}


	private List<RtMarket> rtMarketForAttribute(RtMarket market) {

		List<RtMarket> result = new ArrayList<RtMarket>();
		Map<AttributeWrapper, Set<RtBet>> map = new HashMap<AttributeWrapper, Set<RtBet>>();
		Set<RtBet> rtbets;
		RtMarket rtMarket;

		for (RtBet rtBet : market.getBets()) {
			if(rtBet.getAttribute().isValidForSurebet()){
				AttributeWrapper attribute = new AttributeWrapper(
						(RtMasMenosAttribute) rtBet.getAttribute());

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

	public class AttributeWrapper {

		private final RtMasMenosAttribute attribute;

		public AttributeWrapper(RtMasMenosAttribute attribute) {
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
			int totalGoal = attribute.getFinalValue().compareTo(
					(other.attribute.getFinalValue()));
			if (attribute == null || other.attribute == null) {
				return false;
			} else if (totalGoal != 0) {
				return false;
			}
			return true;
		}

		public RtMasMenosAttribute getAttribute() {
			return attribute;
		}

	}

}
