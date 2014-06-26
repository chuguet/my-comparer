/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

/**
 * The Class CfgBetTypeRepositoryTest.
 */

public class SecureBetRepositoryTest extends
		AbstractConfigRepositoryTest<SecureBetRepository> {

	/** The sport type repository. */
	@Inject
	private SecureBetRepository secureBetRepository;

	/**
	 * Find all test.
	 */
	@Test
	public void findAllTest() {
		List<SecureBeanData> list = secureBetRepository.findAll();
		assertTrue(list.size() == 1);
		assertEquals(list.get(0).getNameId(), "Real Madrid CF");
	}

	/**
	 * Find one custom test.
	 */
	@Test
	public void findOneCustomTest() {
		SecureBeanData secureBet = secureBetRepository.findOneCustom("1");
		assertEquals(secureBet.getNameId(), "Real Madrid CF");
	}

	/**
	 * Find one test.
	 */
	@Test
	public void findOneTest() {
		SecureBeanData secureBet = secureBetRepository.findOne(new BigInteger(
				"1"));
		assertEquals(secureBet.getNameId(), "Real Madrid CF");
	}

	/**
	 * Found last date surebet test.
	 */
	@Test
	public void foundLastDateSurebetTest() {

		SecureBeanData secureBeanData = new SecureBeanData();
		InfoMatch infoMatch = new InfoMatch();
		CfgCompetition competition = new CfgCompetition(BigInteger.ONE);
		CfgSport cfgSport = new CfgSport(BigInteger.ONE);
		CfgRegion cfgRegion = new CfgRegion(BigInteger.ONE);
		CfgBetType betType = new CfgBetType();
		RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
		CfgBetTypeEvent cfgBetTypeEvent = new CfgBetTypeEvent();

		cfgBetTypeEvent.setObjectId(BigInteger.ONE);
		betTypeEvent.setBetTypeEvent(cfgBetTypeEvent);

		betType.setObjectId(BigInteger.ONE);

		betType.setObjectId(BigInteger.ONE);
		secureBeanData.setBenefit(new SecureBeanBenefit(7d));
		secureBeanData.setBetTypeEvent(betTypeEvent);

		competition.setRegion(cfgRegion);
		competition.setSport(cfgSport);

		infoMatch.setCompetition(competition);
		infoMatch.setObjectId(BigInteger.ONE);
		secureBeanData.setInfoMatch(infoMatch);
		secureBeanData.setBetType(betType);
		secureBeanData.setNameId("Real Madrid CF");

		// beanData = secureBetRepository.lastDateSurebet(secureBeanData);

	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public SecureBetRepository getCrudRepository() {
		return secureBetRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		SecureBeanData secureBeanData = new SecureBeanData();
		secureBeanData = new SecureBeanData();
		secureBeanData.setNameId("Real Madrid CF");
		CfgBetTypeEvent betTypeEvent = new CfgBetTypeEvent();
		RtBetTypeEvent typeEvent = new RtBetTypeEvent();

		betTypeEvent.setObjectId(BigInteger.ONE);
		typeEvent.setBetTypeEvent(betTypeEvent);
		secureBeanData.setBetTypeEvent(typeEvent);

		secureBeanData.setBenefit(new SecureBeanBenefit());

		CfgBetType betType = new CfgBetType();
		betType.setObjectId("7");
		secureBeanData.setBetType(betType);

		// RtMatch
		InfoMatch match = new InfoMatch();
		match.setObjectId(new BigInteger("1001"));
		secureBeanData.setInfoMatch(match);

		CoreDate coreDate = new CoreDate();
		coreDate.setZeroGmtMatchDate(new Date());
		secureBeanData.setCreateDate(coreDate);
		// secureBeanData.setBetTypeEvent(betTypeEvent);
		return secureBeanData;
	}

	/**
	 * Last date surebet new test.
	 */
	@Test
	public void lastDateSurebetNewTest() {
		SecureBeanData secureBeanData = new SecureBeanData();
		secureBetRepository.lastDateSurebet(secureBeanData);
	}

	/**
	 * Last date surebet null test.
	 */
	@Test
	public void lastDateSurebetNullTest() {

		secureBetRepository.lastDateSurebet(null);

	}

	/**
	 * Not found last date surebet test.
	 */
	@Test
	public void notFoundLastDateSurebetTest() {

		// SecureBeanData secureBeanData = new SecureBeanData();
		// InfoMatch infoMatch = new InfoMatch();
		// CfgCompetition competition = new CfgCompetition(BigInteger.ONE);
		// CfgSport cfgSport = new CfgSport(BigInteger.ONE);
		// CfgRegion cfgRegion = new CfgRegion(BigInteger.ONE);
		// CfgBetType betType = new CfgBetType();
		// SecureBeanData beanData;
		//
		//
		// betType.setObjectId(BigInteger.ONE);
		// secureBeanData.setBenefit(new SecureBeanBenefit(7d));
		//
		//
		// competition.setRegion(cfgRegion);
		// competition.setSport(cfgSport);
		//
		// infoMatch.setCompetition(competition);
		// infoMatch.setObjectId(BigInteger.ONE);
		// secureBeanData.setInfoMatch(infoMatch);
		// secureBeanData.setBetType(betType);
		// secureBeanData.setNameId("Real Madrid");
		//
		// beanData = secureBetRepository.lastDateSurebet(secureBeanData);

	}

}
