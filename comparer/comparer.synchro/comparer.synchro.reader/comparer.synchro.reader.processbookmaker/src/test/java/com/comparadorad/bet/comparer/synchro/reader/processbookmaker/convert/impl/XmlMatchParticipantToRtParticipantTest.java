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

import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlMatchParticipantToRtParticipantTest.
 */
public class XmlMatchParticipantToRtParticipantTest extends AbstractTest {

	/** The xml match participant to rt participant. */
	@Inject
	private XmlMatchParticipantToRtParticipant xmlMatchParticipantToRtParticipant;

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Test
	public void test() {
		XmlTournament torneo = new XmlTournament("Primera Liga");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		
		XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(
				"Real Madrid", true, false, torneo);
		RtParticipant result = new RtParticipant();
		result = (RtParticipant) xmlMatchParticipantToRtParticipant.convert(
				null, xmlMatchParticipant, null, null);
		assertNotNull(result);
		assertTrue(result.getCfgParticipant().getName(null)
				.equals("Real Madrid"));

	}

	/**
	 * Test no encontrado.
	 */
	@Test
	public void testNoEncontrado() {
		XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant(
				"Participante inventado", true, false, tournament);

		RtParticipant result = null;
		try {
			result = (RtParticipant) xmlMatchParticipantToRtParticipant
					.convert(null, xmlMatchParticipant, null, null);
		} catch (Exception e) {
			assertTrue(result == null);
		}

	}

}
