/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class RtBetWriter.
 */
public class RtBetWriter extends AbstractWriterXML<List<RtBet>>  {

	 /** {@inheritDoc} */ 
	@Override
	protected boolean isExtended() {	
		return false;
	}

	 /** {@inheritDoc} */ 
	@Override
	protected List<RtBet> makeObject() {
		List<RtBet> bets = new ArrayList<RtBet>();
		CfgBookmaker bookmaker = new CfgBookmaker();
		
		bookmaker.setObjectId(BigInteger.ONE);
		bets.add( makeRtBet( bookmaker , makeRtBetOdd("","","") ) );
		bets.add( makeRtBet( bookmaker , makeRtBetOdd("","","") ) );
		
		
		
		return bets;
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
