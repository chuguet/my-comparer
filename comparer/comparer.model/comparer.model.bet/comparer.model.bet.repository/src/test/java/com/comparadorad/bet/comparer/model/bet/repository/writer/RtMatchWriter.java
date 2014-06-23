/**
 *

 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgCompetitionWriter.
 */
public class RtMatchWriter extends AbstractWriterXML<List<RtMatch>> {

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<RtMatch> makeObject() {

		List<RtMatch> result = new ArrayList<RtMatch>();
		RtMatch rtMatch;
		RtMarket rtMarket = new RtMarket();
		RtBet rtBet = new RtBet();
		RtBetOdd rtBetOdd = new RtBetOdd();
		RtGanadorAttribute attribute = new RtGanadorAttribute();
		
		
		// ////////////////////////////////////////////////		
		CfgCompetition competition;
		CfgBetType betType = new CfgBetType();
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setName("casaApuestas");
		bookmaker.setObjectId(BigInteger.ONE);

		betType.setObjectId(BigInteger.ONE);
		betType.setName("tipoApuesta");
		rtMarket.setBetType(betType);
		rtMarket.setObjectId(BigInteger.ONE);

		rtBetOdd.setAmericanOdds("americanOdds");
		rtBetOdd.setObjectId(BigInteger.ONE);
		attribute.setBetName("Apuesta segura");
		rtBet.setAttribute(attribute);
		rtBet.setBetOdd(rtBetOdd);
		rtBet.setBetType(betType);
		rtBet.setBookmaker(bookmaker);

		rtMarket.add(rtBet);

		rtMatch = new RtMatch();
		
		rtMatch.setCoreActiveElement(new CoreActiveElement(true));		
		rtMatch.add("1haskey");
		
		// String hashKey = rtMatch.getHashKey();
		RtParticipant participant = new RtParticipant();

		CoreDate date = new CoreDate();
		date.setZeroGmtMatchDate(Calendar.getInstance().getTime());

		rtMatch.addParticipiant(participant);
		rtMatch.setStartDate(date);
		rtMatch.setLive(false);

		competition = new CfgCompetition();
		competition.setObjectId(BigInteger.ONE);
		rtMatch.setCompetition(competition);

		// pInternalId.setRtBmInternalId(rtBmInternalId);

		rtMatch.setHashKey("wefwefomewf");
		rtMatch.add(rtMarket);
		result.add(rtMatch);
		// //////////////////////////////////////////////

		/*
		 * Test for competition Windows
		 */

		CfgParticipant cfgParticipant;
		rtMatch = new RtMatch();
		RtMatchId rtMatchId = new RtMatchId();

		rtMatch.setObjectId(new BigInteger("1001"));
		/*
		 * Add competition
		 */
		rtMatchId.setCompetition(competition);

		/*
		 * Add participant "Real Madrid"
		 */
		RtParticipant homeParticipant = new RtParticipant();
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(new BigInteger("11"));
		homeParticipant.setCfgParticipant(cfgParticipant);
		rtMatchId.addParticipiant(homeParticipant);

		/*
		 * Add participant "Barcelona"
		 */
		RtParticipant awayparticipant = new RtParticipant();
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(new BigInteger("12"));
		awayparticipant.setCfgParticipant(cfgParticipant);
		rtMatchId.addParticipiant(awayparticipant);

		/*
		 * Add rtMatchId
		 */
		rtMatch.setMatchId(rtMatchId);

		rtMarket = new RtMarket();


		/*
		 * Add betType
		 */
		betType = new CfgBetType();
		betType.setObjectId(new BigInteger("2"));
		rtMarket.setBetType(betType);

		/*
		 * Add bet "Real Madrid"
		 */
		rtBet = new RtBet();
		rtBet.setBetType(betType);
		rtBet.setBookmaker(bookmaker);
		rtBet.setMarket(rtMarket);
		rtBet.setParticipant(homeParticipant);

		/*
		 * Add Odds "Real Madrid"
		 */
		rtBetOdd = new RtBetOdd();
		rtBetOdd.setFraOdds("1/2");
		rtBetOdd.setOdds("1.5");
		rtBetOdd.setFraOdds("1.4");
		rtBet.setBetOdd(rtBetOdd);
		rtBet.setActualizeDate(new Date());
		rtMarket.add(rtBet);

		/*
		 * Add bet "Barcelona"
		 */
		rtBet = new RtBet();
		rtBet.setBetType(betType);
		rtBet.setBookmaker(bookmaker);
		rtBet.setMarket(rtMarket);
		rtBet.setParticipant(awayparticipant);

		/*
		 * Add Odds "Real Madrid"
		 */
		rtBetOdd = new RtBetOdd();
		rtBetOdd.setFraOdds("2/1");
		rtBetOdd.setOdds("5.1");
		rtBetOdd.setFraOdds("4.1");
		rtBet.setBetOdd(rtBetOdd);
		rtBet.setActualizeDate(new Date());
		rtMarket.add(rtBet);

		/*
		 * Add Market
		 */
		rtMatch.add(rtMarket);

		/*
		 * Add result list
		 */
		result.add(rtMatch);

		return result;
	}
}
