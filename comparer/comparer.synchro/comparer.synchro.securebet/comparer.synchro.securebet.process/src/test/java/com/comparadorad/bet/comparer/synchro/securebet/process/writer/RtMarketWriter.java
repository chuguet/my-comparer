package com.comparadorad.bet.comparer.synchro.securebet.process.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

public class RtMarketWriter extends AbstractWriterXML<List<RtMarket>> {

	@Override
	protected boolean isExtended() {
		return false;
	}

	@Override
	protected List<RtMarket> makeObject() {
		List<RtMarket> result = new ArrayList<RtMarket>();
		CfgBookmaker bookmaker;
		RtBet rtBet;
		RtMarket market;
		
		market = new RtMarket();
		
		
		bookmaker = makeCfgBookmaker("1");
		rtBet = makeRtBet(bookmaker, makeRtBetOdd("1","1","1"));
		market.add(rtBet);
		
		bookmaker = makeCfgBookmaker("2");
		rtBet = makeRtBet(bookmaker, makeRtBetOdd("1","1","1"));
		market.add(rtBet);
		
		bookmaker = makeCfgBookmaker("3");
		rtBet = makeRtBet(bookmaker, makeRtBetOdd("1","1","1"));
		market.add(rtBet);
		
		result.add(market);
		
		return result;
	}
	
	private CfgBookmaker makeCfgBookmaker(String id){
		CfgBookmaker result = new CfgBookmaker();
		result.setObjectId(new BigInteger(id));
		return result;
	}
	
	private RtBet makeRtBet(CfgBookmaker bookmaker,RtBetOdd rtBetOdd ){
		RtBet result = new RtBet();		
		result.setBookmaker(bookmaker);
		result.setBetOdd(rtBetOdd);
		return result;
	}
	
	private RtBetOdd makeRtBetOdd(String americanOdds, String fraOdds, String odds){
		RtBetOdd result = new RtBetOdd();
		result.setAmericanOdds(americanOdds);
		result.setFraOdds(fraOdds);
		result.setOdds(odds);
		return result;
	}

}
