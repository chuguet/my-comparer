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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlMatchParticipantsToRtParticipantsTest.
 */
public class XmlMatchParticipantsToRtParticipantsTest extends AbstractTest {

	/** The xml match participants to rt participants. */
	@Inject
	private XmlMatchParticipantsToRtParticipants xmlMatchParticipantsToRtParticipants;

	

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
		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		
		XmlTournament torneo = new XmlTournament("Primera Liga");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		lista.add(new XmlMatchParticipant("Real Madrid", torneo));
		lista.add(new XmlMatchParticipant("Barcelona", torneo));
		Set<RtParticipant> result = new HashSet<RtParticipant>();
		result = (Set<RtParticipant>) xmlMatchParticipantsToRtParticipants
				.convert(null, lista, null, null);

		assertNotNull(result);
		assertTrue(result.size() > 0);

	}

	/**
	 * Test no encontrado.
	 */
	@Test
	public void testNoEncontrado() {
		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		lista.add(new XmlMatchParticipant("Participante inventado", tournament));
		lista.add(new XmlMatchParticipant("Participante mas inventado",
				tournament));
		Set<RtParticipant> result = new HashSet<RtParticipant>();
		try {
			result = (Set<RtParticipant>) xmlMatchParticipantsToRtParticipants
					.convert(null, lista, null, null);
		} catch (Exception e) {
			assertTrue(result.size() == 0);
		}

	}

	/**
	 * Test objeto incorrecto.
	 */
	@Test
	public void testObjetoIncorrecto() {

		Set<String> result = new HashSet<String>();
		result.add("objeto");
		result.add("objeto2");
		result = (Set<String>) xmlMatchParticipantsToRtParticipants.convert(
				null, "objeto", null, null);
		assertTrue(result.size() == 0);

	}
	
	@Test
	public void testParticipanteDesactivado() {
		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		lista.add(new XmlMatchParticipant("Participante Desactivado", tournament));
		Set<RtParticipant> result = new HashSet<RtParticipant>();
		try {
			result = (Set<RtParticipant>) xmlMatchParticipantsToRtParticipants
					.convert(null, lista, null, null);
		} catch (Exception e) {
			assertTrue(result.size() == 0);
		}
	}

}
