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

import java.math.BigInteger;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlTournamentToCfgCompetitionTest.
 */
public class XmlTournamentToCfgCompetitionTest extends AbstractTest {

	/** The xml tournament to cfg competition. */
	@Inject
	private XmlTournamentToCfgCompetition xmlTournamentToCfgCompetition;

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
		XmlTournament xmlTournament = new XmlTournament("Primera Liga");
		xmlTournament.setCfgObjectId(new BigInteger("656935033"));
		xmlTournament.setXmlSport(new XmlSport("Futbol"));
		xmlTournament.getXmlSport().setCfgObjectId(new BigInteger("1"));
		CfgCompetition result = new CfgCompetition();
		result = (CfgCompetition) xmlTournamentToCfgCompetition.convert(null,
				xmlTournament, null, null);

		assertNotNull(result);
		assertTrue(result.getName(null).equals("Primera Liga"));

	}

	/**
	 * Test no encontrado.
	 */
	@Test
	public void testNoEncontrado() {
		XmlTournament xmlTournament = new XmlTournament("Competicion inventada");
		xmlTournament.setXmlSport(new XmlSport("Futbol"));
		xmlTournament.getXmlSport().setCfgObjectId(new BigInteger("1"));
		CfgCompetition result = new CfgCompetition();
		try {
			result = (CfgCompetition) xmlTournamentToCfgCompetition.convert(
					null, xmlTournament, null, null);
		} catch (Exception e) {
			assertTrue(result.getI18n() == null);
		}

	}
	
	@Test
	public void testNoEncontradoSinSportId() {
		XmlTournament xmlTournament = new XmlTournament("Competicion inventada");
		xmlTournament.setXmlSport(new XmlSport("Futbol"));
		CfgCompetition result = new CfgCompetition();
		try {
			result = (CfgCompetition) xmlTournamentToCfgCompetition.convert(
					null, xmlTournament, null, null);
		} catch (Exception e) {
			assertTrue(result.getI18n() == null);
		}

	}

	/**
	 * Test mal informado.
	 */
	@Test
	public void testMalInformado() {
		CfgCompetition result = new CfgCompetition();
		try {
			result = (CfgCompetition) xmlTournamentToCfgCompetition.convert(
					null, "objeto", null, null);
		} catch (Exception e) {
			assertTrue(result.getI18n() == null);
		}

	}

}
