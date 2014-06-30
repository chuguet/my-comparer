/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process;

import java.math.BigInteger;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;
import com.comparadorad.bet.comparer.synchro.securebet.process.config.SynchroSecureBetProcessConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SynchroSecureBetProcessConfig.class,
		ConfigRepositoryConfig.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

	/**
	 * Make cfg bookmaker.
	 * 
	 * @param id
	 *            the id
	 * @return the cfg bookmaker
	 */
	protected CfgBookmaker makeCfgBookmaker(String id) {
		CfgBookmaker result = new CfgBookmaker();
		result.setObjectId(new BigInteger(id));
		return result;
	}

	/**
	 * Make rt bet.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @param rtBetOdd
	 *            the rt bet odd
	 * @param participant
	 *            the participant
	 * @return the rt bet
	 */
	protected RtBet makeRtBet(CfgBookmaker bookmaker, RtBetOdd rtBetOdd,
			RtParticipant participant) {
		RtBet result = new RtBet();
		result.setBookmaker(bookmaker);
		result.getParticipant();
		result.setBetOdd(rtBetOdd);
		result.setParticipant(participant);
		return result;
	}
	
	protected RtBet market1X2RtBet(CfgBookmaker bookmaker, RtBetOdd rtBetOdd,
			RtParticipant participant,Result oneDrawSecond) {
		RtBet result = new RtBet();
		Rt1X2Attribute attribute = new Rt1X2Attribute();
		result.setBookmaker(bookmaker);
		result.getParticipant();
		result.setBetOdd(rtBetOdd);
		result.setParticipant(participant);
		
		switch (oneDrawSecond) {
		case ONE:
			attribute.setResult(Result.ONE);
			break;
		case DRAW:
			attribute.setResult(Result.DRAW);
			break;
		case TWO:
			attribute.setResult(Result.TWO);
			break;		
		}		
		result.setAttribute(attribute);
		
		return result;
	}
	
	protected RtBet marketGanadorRtBet(CfgBookmaker bookmaker, RtBetOdd rtBetOdd,
			RtParticipant participant,Result oneDrawSecond) {
		RtBet result = new RtBet();
		RtGanadorPartidoAttribute attribute = new RtGanadorPartidoAttribute();
		result.setBookmaker(bookmaker);
		result.getParticipant();
		result.setBetOdd(rtBetOdd);
		result.setParticipant(participant);
		
		switch (oneDrawSecond) {
		case ONE:
			attribute.setResult(Result.ONE);
			break;
		case TWO:
			attribute.setResult(Result.TWO);
			break;		
		}		
		result.setAttribute(attribute);
		
		return result;
	}

	/**
	 * Make rt bet odd.
	 * 
	 * @param americanOdds
	 *            the american odds
	 * @param fraOdds
	 *            the fra odds
	 * @param odds
	 *            the odds
	 * @return the rt bet odd
	 */
	protected RtBetOdd makeRtBetOdd(String americanOdds, String fraOdds,
			String odds) {
		RtBetOdd result = new RtBetOdd();
		result.setAmericanOdds(americanOdds);
		result.setFraOdds(fraOdds);
		result.setOdds(odds);
		return result;
	}

	/**
	 * Make rt participant.
	 * 
	 * @param id
	 *            the id
	 * @return the rt participant
	 */
	protected RtParticipant makeRtParticipant(String id) {
		RtParticipant result = new RtParticipant();
		CfgParticipant participant = new CfgParticipant();
		participant.setObjectId(new BigInteger(id));
		result.setCfgParticipant(participant);
		return result;
	}

}
