/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository.valuebet;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.mongodb.DBCollection;

/**
 * The Class RtMatchRepositoryValueBetSkipTest.
 */
public class RtMatchRepositoryValueBetSkipTest extends
		AbstractRtMatchRepositoryValueBetTest {

	/** The Constant PREFIX. */
	private static final String PREFIX = "-ValueBetTest-Skip";

	/**
	 * Gets the aditional name for load.
	 * 
	 * @return the aditional name for load {@inheritDoc}
	 */
	@Override
	protected String getAditionalNameForLoad() {
		return PREFIX;
	}

	/**
	 * Gets the collections.
	 * 
	 * @return the collections {@inheritDoc}
	 */
	@Override
	protected HashMap<Class<? extends IDocument>, DBCollection> getCollections() {
		HashMap<Class<? extends IDocument>, DBCollection> result = new HashMap<Class<? extends IDocument>, DBCollection>();
		result.put(RtMatch.class, mongoTemplate.getCollection(mongoTemplate
				.getCollectionName(RtMatch.class)));
		return result;
	}

	/**
	 * Skip test. Hay 9 partidos en BD con id 0 a 8. Este test verifica que son
	 * recogidos como pide los limites pasados a 'getEventsForValueBetLimit'.
	 * (Ya que el metodo filtra por numero de bets y fecha de partido, los 9
	 * partidos tienen fecha no caducada y al menos un mercado con mas de 2
	 * bets)
	 */
	@Test
	public void skipTest() {

		assertEquals(9, rtMatchRepository.count());

		// Recoger 4 partidos empezando por index 0
		List<RtMatch> matchs = rtMatchRepository.getEventsForValueBetLimit(4,
				0, 3);
		assertEquals(4, matchs.size());
		assertEquals("0", matchs.get(0).getObjectId().toString());
		assertEquals("1", matchs.get(1).getObjectId().toString());
		assertEquals("2", matchs.get(2).getObjectId().toString());
		assertEquals("3", matchs.get(3).getObjectId().toString());

		// Recoger 2 partidos empezando por index 4
		matchs = rtMatchRepository.getEventsForValueBetLimit(2, 4, 3);
		assertEquals(2, matchs.size());
		assertEquals("4", matchs.get(0).getObjectId().toString());
		assertEquals("5", matchs.get(1).getObjectId().toString());

		// Recoger 6 partidos empezando por index 8
		// Ya que es el ultimo partido sólo devuelve ese
		matchs = rtMatchRepository.getEventsForValueBetLimit(6, 8, 3);
		assertEquals(1, matchs.size());
		assertEquals("8", matchs.get(0).getObjectId().toString());

		// Recoger 10 partidos empezando por index 15
		// Devuelve nada
		matchs = rtMatchRepository.getEventsForValueBetLimit(10, 15, 3);
		assertEquals(0, matchs.size());

	}

}
