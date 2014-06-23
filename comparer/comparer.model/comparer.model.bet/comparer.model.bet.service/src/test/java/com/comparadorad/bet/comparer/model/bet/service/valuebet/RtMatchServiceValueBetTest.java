/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service.valuebet;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.mongodb.DBCollection;

/**
 * The Class RtMatchServiceValueBetTest.
 */
public class RtMatchServiceValueBetTest extends
		AbstractRtMatchServiceValueBetTest<RtMatch> {

	/** The Constant PREFIX. */
	private static final String PREFIX = "-RtMatchServiceValueBetTest";

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
	 * En BD hay 9 partidos con id 0, 1, 2, ..., 8. Todos los partidos tienen
	 * fecha mayor de hoy y al menos un mercado con mas de 3 bets. Al pedir 5
	 * partidos empezando por index 0 se devuelven los 5 primeros partidos de la
	 * BD.
	 * 
	 * @return the events for value bet limit test
	 */
	@Test
	public void getEventsForValueBetLimitTest() {

		assertEquals(9, rtMatchService.count());

		List<RtMatch> matchs = rtMatchService
				.getEventsForValueBetLimit(5, 0, 3);

		assertEquals(5, matchs.size());
		// assertEquals("0", matchs.get(0).getObjectId().toString());
		// assertEquals("1", matchs.get(1).getObjectId().toString());
		// assertEquals("2", matchs.get(2).getObjectId().toString());
		// assertEquals("3", matchs.get(3).getObjectId().toString());
		// assertEquals("4", matchs.get(4).getObjectId().toString());

	}

}
