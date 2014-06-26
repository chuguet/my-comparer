package com.comparadorad.bet.comparer.model.securebet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;

public class SecureBetHistoricRespositoryTest extends
		AbstractConfigRepositoryTest<SecureBetHistoricRepository> {

	/** The sport type repository. */
	@Inject
	private SecureBetHistoricRepository secureBetHistoricRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public SecureBetHistoricRepository getCrudRepository() {
		return secureBetHistoricRepository;
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
		InfoMatch match = new InfoMatch();
		match.setObjectId(new BigInteger("1001"));
		CoreDate coreDate = new CoreDate();
		coreDate.setZeroGmtMatchDate(new Date());
		RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
		CfgBetType betType = new CfgBetType();
		betType.setObjectId("7");
		RtBet rtBet = new RtBet();
		Set<RtBet> setBets = new HashSet<RtBet>();
		setBets.add(rtBet);
		secureBeanData.setBenefit(new SecureBeanBenefit());
		secureBeanData.setBets(setBets);
		secureBeanData.setBetType(betType);
		secureBeanData.setInfoMatch(match);
		secureBeanData.setCreateDate(coreDate);
		secureBeanData.setBetTypeEvent(betTypeEvent);
		secureBeanData.setNameId("Real Madrid CF");
		secureBeanData.setObjectId("1");
		return secureBeanData;
	}

	@Test
	public void testFindAll() {
		List<SecureBeanHistoricData> list = secureBetHistoricRepository
				.findAll();
		assertTrue(list.size() == 1);
		assertEquals(list.get(0).getNameId(), "Real Madrid CF");
	}

	@Test
	public void testFindOne() {
		SecureBeanHistoricData secureBet = secureBetHistoricRepository
				.findOne(new BigInteger("1"));
		assertEquals(secureBet.getNameId(), "Real Madrid CF");
	}
}