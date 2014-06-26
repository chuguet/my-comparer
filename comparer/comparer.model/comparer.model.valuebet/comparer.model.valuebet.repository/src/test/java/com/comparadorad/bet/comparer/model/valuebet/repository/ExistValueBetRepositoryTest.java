/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.mongodb.DBCollection;

/**
 * The Class ExistValueBetRepositoryTest.
 */
public class ExistValueBetRepositoryTest extends AbstractValueBetRepositoryTest {

	/** The value bet repository. */
	@Inject
	private ValueBetRepository valueBetRepository;

	/**
	 * En BD hay 4 valuebets (solo con los datos obligatorios para este test) de
	 * los cuales buscamos uno con los hashKeys del market y del bet.
	 */
	@Test
	public void existTest() {

		ValueBetData valueBetData = new ValueBetData();
		CfgBetTypeEvent betTypeEvent = new CfgBetTypeEvent();
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		RtParticipant participant = new RtParticipant();
		Rt1X2Attribute attr = new Rt1X2Attribute();
		CfgBetType betType = new CfgBetType();
		InfoMatch infoMatch = new InfoMatch();
		RtMarket market = new RtMarket();
		RtBet bet = new RtBet();

		// Estos son los hashKeys que generan el market y el bet que se crean en
		// este test. Corresponden a los datos de un valuebet de la BD
		String hashKeyMarket = "17ba0791499db908433b80f37c5fbc89b870084b";
		String hashKeyBet = "391ec54598264231e0c1ae473d7257f97e119824";

		infoMatch.setObjectId(new BigInteger("1"));

		betType.setObjectId(CfgBetTypeId.UNO_X_DOS.id());

		betTypeEvent.setObjectId(CfgBetTypeEventId.PARTIDO_COMPLETO.objectId());
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		market.setBetType(betType);
		market.setBetTypeEvent(rtBetTypeEvent);
		assertEquals(hashKeyMarket, market.getHashKey());

		infoMatch.setMarket(market);
		valueBetData.setInfoMatch(infoMatch);

		attr.setBetName(CfgBetTypeId.UNO_X_DOS.nameId());
		bet.setAttribute(attr);
		bet.setBookmaker(new CfgBookmaker("19"));

		participant.setHomeParticipant(true);
		participant.setAwayParticipant(false);
		participant.setCfgParticipant(new CfgParticipant("1"));
		bet.setParticipant(participant);
		assertEquals(hashKeyBet, bet.getHashKey());
		valueBetData.setBet(bet);

		List<ValueBetData> valueBetDataDB = valueBetRepository
				.exist(valueBetData);
		assertNotNull(valueBetDataDB);
		assertEquals(1, valueBetDataDB.size());
		assertEquals("1", valueBetDataDB.get(0).getInfoMatch().getObjectId()
				.toString());
		assertEquals(hashKeyMarket, valueBetDataDB.get(0).getInfoMatch()
				.getMarket().getHashKey());
		assertEquals(hashKeyBet, valueBetDataDB.get(0).getBet().getHashKey());

	}

	/**
	 * Gets the aditional name for load.
	 * 
	 * @return the aditional name for load {@inheritDoc}
	 */
	@Override
	protected String getAditionalNameForLoad() {
		return new StringBuffer().append("-")
				.append(this.getClass().getSimpleName()).toString();
	}

	/**
	 * Gets the collections.
	 * 
	 * @return the collections {@inheritDoc}
	 */
	@Override
	protected HashMap<Class<? extends IDocument>, DBCollection> getCollections() {
		HashMap<Class<? extends IDocument>, DBCollection> result = new HashMap<Class<? extends IDocument>, DBCollection>();
		result.put(ValueBetData.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(ValueBetData.class)));
		result.put(CfgBetType.class, mongoTemplate.getCollection(mongoTemplate
				.getCollectionName(CfgBetType.class)));
		result.put(CfgBetTypeEvent.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBetTypeEvent.class)));
		result.put(CfgBookmaker.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBookmaker.class)));
		result.put(CfgParticipant.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgParticipant.class)));
		return result;
	}

}
