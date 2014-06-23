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
 * The Class RtMatchRepositoryValueBetDateTest.
 */
public class RtMatchRepositoryValueBetDateTest extends
		AbstractRtMatchRepositoryValueBetTest {

	/** The Constant PREFIX. */
	private static final String PREFIX = "-ValueBetTest-Date";

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
	 * Old date test. En BD hay 9 partidos de los cuales sólo 6 tienen fecha
	 * mayor de hoy.
	 */
	@Test
	public void oldDateTest() {

		assertEquals(9, rtMatchRepository.count());

		List<RtMatch> matchs = rtMatchRepository.getEventsForValueBetLimit(9,
				0, 3);

		assertEquals(6, matchs.size());

	}

}
