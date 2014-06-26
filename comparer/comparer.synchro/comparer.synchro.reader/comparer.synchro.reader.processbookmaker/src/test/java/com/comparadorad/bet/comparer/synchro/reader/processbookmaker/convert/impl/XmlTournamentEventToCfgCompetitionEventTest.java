/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlTournamentEventToCfgCompetitionEventTest.
 */
public class XmlTournamentEventToCfgCompetitionEventTest extends AbstractTest {

	/** The tournament event to cfg competition event. */
	@Inject
	private XmlTournamentEventToCfgCompetitionEvent tournamentEventToCfgCompetitionEvent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest
	 * #test()
	 */
	@Override
	@Test
	public void test() {
		XmlTournamentEvent xmlTournamentEvent = new XmlTournamentEvent();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);
		xmlTournamentEvent.setLongTerm(longTerm);
		CfgCompetitionEvent result = new CfgCompetitionEvent();

		result = (CfgCompetitionEvent) tournamentEventToCfgCompetitionEvent
				.convert(null, xmlTournamentEvent, null, null);
		assertNotNull(result);
		assertTrue(result.getLongTerm().getLongTerm().equals(Boolean.TRUE));
	}

	/**
	 * Test corto plazo.
	 */
	@Test
	public void testCortoPlazo() {
		XmlTournamentEvent xmlTournamentEvent = new XmlTournamentEvent();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		xmlTournamentEvent.setLongTerm(longTerm);
		CfgCompetitionEvent result = new CfgCompetitionEvent();

		result = (CfgCompetitionEvent) tournamentEventToCfgCompetitionEvent
				.convert(null, xmlTournamentEvent, null, null);
		assertNotNull(result);
		assertTrue(result.getLongTerm().getLongTerm().equals(Boolean.FALSE));
	}

	/**
	 * Test no informado.
	 */
	@Test
	public void testNoInformado() {
		CfgCompetitionEvent result = new CfgCompetitionEvent();

		result = (CfgCompetitionEvent) tournamentEventToCfgCompetitionEvent
				.convert(null, null, null, null);
		assertNotNull(result);
		assertTrue(result.getLongTerm().getLongTerm().equals(Boolean.FALSE));
	}

}
