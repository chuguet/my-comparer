/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.mongodb.DBCollection;

/**
 * The Class DifferingValueBetsRepositoryTest.
 */
public class DifferingValueBetsRepositoryTest extends
		AbstractValueBetRepositoryTest {

	/** The value bet repository. */
	@Inject
	private ValueBetRepository valueBetRepository;

	/**
	 * En BD hay 8 valuebets. 6 son de un partido y 2 de otro partido. Este test
	 * verifica que al especificar el id del partido y parejas de hashKeys de
	 * market y bet, devuelve todos los valubets del partido en concreto que NO
	 * corresponden a las parejas de hashs pasados. Aqui esta el esquema de los
	 * hashKeys de los valuebets en BD:
	 * 
	 * *** TODOS LOS HASH KEYS ***
	 *************************************************** 
	 * Market MA: 1X2, PC --> hashKey = 17b ... 84b
	 * 
	 * Market MB: Hand Asia, PC --> hashKey = 761 ... 6de
	 * 
	 * Market MC: Gan Part, PC --> hashKey = 472 ... 5c7
	 * 
	 * Bet BA: Bookie 19, Part 1, MA --> hashKey = 391 ... 824
	 * 
	 * Bet BB: Bookie 20, Part 1, MA --> hashKey = cfe ... b7e
	 * 
	 * Bet BC: Bookie 19, Part 2, M2 --> hashKey = 978 ... a73
	 * 
	 * Bet BD: Bookie 19, Part 1, MC --> hashKey = f71 ... bfd
	 * 
	 * Bet BE: Bookie 20, Part 1, MC --> hashKey = 49d ... b03
	 * 
	 * Bet BF: Bookie 19, Part 2, MC --> hashKey = fac ... de9
	 * 
	 *** EN BD HAY LOS SIGUIENTES VALUBETS ***
	 *************************************************** 
	 * Partido 1 Partido 2
	 * 
	 * MA - BA MA - BA
	 * 
	 * MA - BB MA - BB
	 * 
	 * MB - BC
	 * 
	 * MC - BD
	 * 
	 * MC - BE
	 * 
	 * MC - BF
	 */
	@Test
	public void differingValueBetsTest() {

		assertEquals(8, valueBetRepository.count());

		List<String> marketHashKeys = new ArrayList<String>();
		List<String> betHashKeys = new ArrayList<String>();
		List<ValueBetData> valueBetsDB;

		// Partido 1
		marketHashKeys.add("17ba0791499db908433b80f37c5fbc89b870084b");
		betHashKeys.add("391ec54598264231e0c1ae473d7257f97e119824");

		marketHashKeys.add("17ba0791499db908433b80f37c5fbc89b870084b");
		betHashKeys.add("cfef4e5e54a31cca6f0453af5e14e5ef3723fb7e");

		marketHashKeys.add("761f22b2c1593d0bb87e0b606f990ba4974706de");
		betHashKeys.add("97880ce02fe2eefd486316ce1174f9aea5771a73");

		marketHashKeys.add("472b07b9fcf2c2451e8781e944bf5f77cd8457c8");
		betHashKeys.add("f7158a478e7a7c5c31a6bc885f21f58e96af7bfd");

		marketHashKeys.add("472b07b9fcf2c2451e8781e944bf5f77cd8457c8");
		betHashKeys.add("49dc8aee8abeb4aa82729dc76b7e60a01a9a3b03");

		marketHashKeys.add("472b07b9fcf2c2451e8781e944bf5f77cd8457c8");
		betHashKeys.add("fac08c20be77bd84cb6bcfddad1614bbea153de9");

		// Partido 2
		marketHashKeys.add("17ba0791499db908433b80f37c5fbc89b870084b");
		betHashKeys.add("391ec54598264231e0c1ae473d7257f97e119824");

		marketHashKeys.add("17ba0791499db908433b80f37c5fbc89b870084b");
		betHashKeys.add("cfef4e5e54a31cca6f0453af5e14e5ef3723fb7e");

		// Parejas: 0 y 2 del Partido 1. Se devuelven los 4 restantes
		valueBetsDB = valueBetRepository.getDifferingMatchValueBets("1",
				getHashKeyAtPosition(marketHashKeys, 0, 2),
				getHashKeyAtPosition(betHashKeys, 0, 2));

		assertEquals(4, valueBetsDB.size());
		for (ValueBetData valueBet : valueBetsDB) {
			assertEquals("1", valueBet.getInfoMatch().getObjectId().toString());
			assertFalse(valueBet.getInfoMatch().getMarket().getHashKey()
					.equalsIgnoreCase(marketHashKeys.get(0))
					&& valueBet.getBet().getHashKey()
							.equalsIgnoreCase(betHashKeys.get(0)));
			assertFalse(valueBet.getInfoMatch().getMarket().getHashKey()
					.equalsIgnoreCase(marketHashKeys.get(2))
					&& valueBet.getBet().getHashKey()
							.equalsIgnoreCase(betHashKeys.get(2)));
		}

		// Parejas: 3 del Partido 1. Se devuelven los 5 restantes
		valueBetsDB = valueBetRepository.getDifferingMatchValueBets("1",
				getHashKeyAtPosition(marketHashKeys, 3),
				getHashKeyAtPosition(betHashKeys, 3));

		assertEquals(5, valueBetsDB.size());
		for (ValueBetData valueBet : valueBetsDB) {
			assertEquals("1", valueBet.getInfoMatch().getObjectId().toString());
			assertFalse(valueBet.getInfoMatch().getMarket().getHashKey()
					.equalsIgnoreCase(marketHashKeys.get(3))
					&& valueBet.getBet().getHashKey()
							.equalsIgnoreCase(betHashKeys.get(3)));
		}

		// Parejas: 6 del Partido 2. Se devuelve el unico valuebet restante
		valueBetsDB = valueBetRepository.getDifferingMatchValueBets("2",
				getHashKeyAtPosition(marketHashKeys, 6),
				getHashKeyAtPosition(betHashKeys, 6));

		assertEquals(1, valueBetsDB.size());
		for (ValueBetData valueBet : valueBetsDB) {
			assertEquals("2", valueBet.getInfoMatch().getObjectId().toString());
			assertFalse(valueBet.getInfoMatch().getMarket().getHashKey()
					.equalsIgnoreCase(marketHashKeys.get(6))
					&& valueBet.getBet().getHashKey()
							.equalsIgnoreCase(betHashKeys.get(6)));
		}

		// Parejas: 6 y 7 del Partido 2. No se devuelve nada
		valueBetsDB = valueBetRepository.getDifferingMatchValueBets("2",
				getHashKeyAtPosition(marketHashKeys, 6, 7),
				getHashKeyAtPosition(betHashKeys, 6, 7));

		assertEquals(0, valueBetsDB.size());

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

	/**
	 * Gets the hash key at position.
	 * 
	 * @param hashKeys
	 *            the hash keys
	 * @param positions
	 *            the positions
	 * @return the hash key at position
	 */
	private List<String> getHashKeyAtPosition(List<String> hashKeys,
			int... positions) {
		List<String> result = new ArrayList<String>();
		for (int p : positions) {
			result.add(hashKeys.get(p));
		}
		return result;
	}

}
