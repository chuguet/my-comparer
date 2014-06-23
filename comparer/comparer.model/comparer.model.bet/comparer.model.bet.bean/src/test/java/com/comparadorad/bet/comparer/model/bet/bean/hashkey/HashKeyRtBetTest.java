/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.hashkey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractBetBeanTest;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Class HashKeyRtBetTest.
 */
public class HashKeyRtBetTest extends AbstractBetBeanTest {

	/**
	 * Hash key ganador partido test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void hashKeyGanadorPartidoTest() throws FileNotFoundException {
		List<String> hashKeys = new ArrayList<String>();
		List<String> uniqueHashKeys = new ArrayList<String>();
		List<IDocument> list = getBeanFromXml("ganadorPartido");
		for (IDocument id : list) {
			RtBet bet = (RtBet) id;
			hashKeys.add(bet.getHashKey());
		}
		assertEquals(6, hashKeys.size());

		for (String hashKey : hashKeys) {
			assertTrue(!uniqueHashKeys.contains(hashKey));
			uniqueHashKeys.add(hashKey);
		}
		assertEquals(6, uniqueHashKeys.size());
	}

	/**
	 * Hash key ganador test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void hashKeyGanadorTest() throws FileNotFoundException {
		List<String> hashKeys = new ArrayList<String>();
		List<String> uniqueHashKeys = new ArrayList<String>();
		List<IDocument> list = getBeanFromXml("ganador");
		for (IDocument id : list) {
			RtBet bet = (RtBet) id;
			hashKeys.add(bet.getHashKey());
		}
		assertEquals(10, hashKeys.size());

		for (String hashKey : hashKeys) {
			assertTrue(!uniqueHashKeys.contains(hashKey));
			uniqueHashKeys.add(hashKey);
		}
		assertEquals(10, uniqueHashKeys.size());
	}

	/**
	 * Hash key handicap asiatico test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void hashKeyHandicapAsiaticoTest() throws FileNotFoundException {
		List<String> hashKeys = new ArrayList<String>();
		List<String> uniqueHashKeys = new ArrayList<String>();
		List<IDocument> list = getBeanFromXml("handicapAsiatico");
		for (IDocument id : list) {
			RtBet bet = (RtBet) id;
			hashKeys.add(bet.getHashKey());
		}
		assertEquals(8, hashKeys.size());

		for (String hashKey : hashKeys) {
			assertTrue(!uniqueHashKeys.contains(hashKey));
			uniqueHashKeys.add(hashKey);
		}
		assertEquals(8, uniqueHashKeys.size());

	}

	/**
	 * Hash key handicap uno x dos test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void hashKeyHandicapUnoXDosTest() throws FileNotFoundException {
		List<String> hashKeys = new ArrayList<String>();
		List<String> uniqueHashKeys = new ArrayList<String>();
		List<IDocument> list = getBeanFromXml("handicapUnoXDos");
		for (IDocument id : list) {
			RtBet bet = (RtBet) id;
			hashKeys.add(bet.getHashKey());
		}
		assertEquals(12, hashKeys.size());

		for (String hashKey : hashKeys) {
			assertTrue(!uniqueHashKeys.contains(hashKey));
			uniqueHashKeys.add(hashKey);
		}
		assertEquals(12, uniqueHashKeys.size());

	}

	/**
	 * Hash key mas menos test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void hashKeyMasMenosTest() throws FileNotFoundException {
		List<String> hashKeys = new ArrayList<String>();
		List<String> uniqueHashKeys = new ArrayList<String>();
		List<IDocument> list = getBeanFromXml("masMenos");
		for (IDocument id : list) {
			RtBet bet = (RtBet) id;
			hashKeys.add(bet.getHashKey());
		}
		assertEquals(8, hashKeys.size());

		for (String hashKey : hashKeys) {
			assertTrue(!uniqueHashKeys.contains(hashKey));
			uniqueHashKeys.add(hashKey);
		}
		assertEquals(8, uniqueHashKeys.size());
	}

	/**
	 * Hash key maximo goleador test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void hashKeyMaximoGoleadorTest() throws FileNotFoundException {
		List<String> hashKeys = new ArrayList<String>();
		List<String> uniqueHashKeys = new ArrayList<String>();
		List<IDocument> list = getBeanFromXml("maximoGoleador");
		for (IDocument id : list) {
			RtBet bet = (RtBet) id;
			hashKeys.add(bet.getHashKey());
		}
		assertEquals(10, hashKeys.size());

		for (String hashKey : hashKeys) {
			assertTrue(!uniqueHashKeys.contains(hashKey));
			uniqueHashKeys.add(hashKey);
		}
		assertEquals(10, uniqueHashKeys.size());
	}

	/**
	 * Hash key uno x dos test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void hashKeyUnoXDosTest() throws FileNotFoundException {
		List<String> hashKeys = new ArrayList<String>();
		List<String> uniqueHashKeys = new ArrayList<String>();
		List<IDocument> list = getBeanFromXml("unoXDos");
		for (IDocument id : list) {
			RtBet bet = (RtBet) id;
			hashKeys.add(bet.getHashKey());
		}
		assertEquals(9, hashKeys.size());

		for (String hashKey : hashKeys) {
			assertTrue(!uniqueHashKeys.contains(hashKey));
			uniqueHashKeys.add(hashKey);
		}
		assertEquals(9, uniqueHashKeys.size());
	}

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */

	@Override
	public final void test() {
		RtBet rtBet = new RtBet();
		assertNotNull(rtBet.getAbstractKey());
		assertEquals(rtBet.getAbstractKey().getHashKey(), "");

	}

}
