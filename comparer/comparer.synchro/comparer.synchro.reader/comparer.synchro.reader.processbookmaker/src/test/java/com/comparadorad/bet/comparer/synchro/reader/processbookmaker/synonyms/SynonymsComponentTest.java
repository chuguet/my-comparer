/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.synonyms;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.repository.exception.CompetitionNotVerifiedException;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleParticipantException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleRegionException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleSportException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleTournamentException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.ParticipantNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.RegionNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.SportNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.TournamentNotFoundException;

/**
 * The Class SynonymsComponentTest.
 */
public class SynonymsComponentTest extends AbstractTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SynonymsComponentTest.class);

	/** The synonyms component. */
	@Inject
	private SynonymsComponent synonymsComponent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest
	 * #test()
	 */
	@Override
	public void test() {

	}

	/**
	 * Find by name competition test.
	 */
	@Test
	public void findByNameCompetitionTest() {
		String competicion = "Champions League";
		try {
			assertNotNull(synonymsComponent.findByNameCompetition(competicion));
		} catch (TournamentNotFoundException e) {
			LOG.error("Competicion no encontrada");
		} catch (MultipleTournamentException e) {
			LOG.error("Competicion Multiple");
		}
	}

	/**
	 * Find by name competition no encontrado test.
	 */
	@Test
	public void findByNameCompetitionNoEncontradoTest() {
		String competicion = "competicion Inventada";
		try {
			synonymsComponent.findByNameCompetition(competicion);
			fail("Competicion no encontrada");
		} catch (TournamentNotFoundException e) {
			LOG.error("Competicion no encontrada");
		} catch (MultipleTournamentException e) {
			LOG.error("Competicion Multiple");
		}
	}

	/**
	 * Find by name participant test.
	 */
	@Test
	public void findByNameParticipantTest() {
		String participante = "Real Madrid";
		try {
			assertNotNull(synonymsComponent.findByNameParticipant(participante));
		} catch (ParticipantNotFoundException e) {
			LOG.error("Participante no encontrado");
		} catch (MultipleParticipantException e) {
			LOG.error("Participante multiple");
		}
	}

	/**
	 * Find by name participant no encontrado test.
	 */
	@Test
	public void findByNameParticipantNoEncontradoTest() {
		String participante = "Participante no encontrado";
		try {
			synonymsComponent.findByNameParticipant(participante);
			fail("Participante no encontrado");
		} catch (ParticipantNotFoundException e) {
			LOG.error("Participante no encontrado");
		} catch (MultipleParticipantException e) {
			LOG.error("Participante multiple");
		}
	}

	/**
	 * Find by name region test.
	 */
	@Test
	public void findByNameRegionTest() {
		String region = "Otros";
		try {
			assertNotNull(synonymsComponent.findByNameRegion(region));
		} catch (RegionNotFoundException e) {
			LOG.error("Region no encontrado");
		} catch (MultipleRegionException e) {
			LOG.error("Region multiple");
		}
	}

	/**
	 * Find by name region no encontrada test.
	 */
	@Test
	public void findByNameRegionNoEncontradaTest() {
		String region = "region inventada";
		try {
			synonymsComponent.findByNameRegion(region);
			fail("Region no encontrada");
		} catch (RegionNotFoundException e) {
			LOG.error("Region no encontrado");
		} catch (MultipleRegionException e) {
			LOG.error("Region multiple");
		}
	}

	/**
	 * Find by name sport test.
	 */
	@Test
	public void findByNameSportTest() {
		String deporte = "Futbol";
		try {
			assertNotNull(synonymsComponent.findByNameSport(deporte));
		} catch (SportNotFoundException e) {
			LOG.error("Deporte no encontrado");
		} catch (MultipleSportException e) {
			LOG.error("Multiple deporte");
		}
	}

	/**
	 * Find by name sport no encontrado test.
	 */
	@Test
	public void findByNameSportNoEncontradoTest() {
		String deporte = "deporte inventado";
		try {
			assertNotNull(synonymsComponent.findByNameSport(deporte));
			fail("Deporte no encontrado");
		} catch (SportNotFoundException e) {
			LOG.error("Deporte no encontrado");
		} catch (MultipleSportException e) {
			LOG.error("Multiple deporte");
		}
	}

	/**
	 * Find by competition name and sport test.
	 */
	@Test
	public void findByCompetitionNameAndSportTest() {
		String competicion = "Champions league";
		try {
			try {
				assertNotNull(synonymsComponent.findByCompetitionNameAndSport(competicion, new BigInteger("1")));
			} catch (CompetitionNotVerifiedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (TournamentNotFoundException e) {
			LOG.error("Competicion no encontrada");
		} catch (MultipleTournamentException e) {
			LOG.error("Competicion Multiple");
		}
	}

	/**
	 * Find by competition name and sport no encontrado test.
	 */
	@Test
	public void findByCompetitionNameAndSportNoEncontradoTest() {
		String competicion = "competicion inventada";
		try {
			try {
				assertNotNull(synonymsComponent.findByCompetitionNameAndSport(competicion, new BigInteger("8979878")));
			} catch (CompetitionNotVerifiedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (TournamentNotFoundException e) {
			LOG.error("Competicion no encontrada");
		} catch (MultipleTournamentException e) {
			LOG.error("Competicion Multiple");
		}
	}

	/**
	 * Test que comprueba que un participante existe asociado a un deporte
	 * concreto y competicion concreta
	 */
	@Test
	public void findByNameSportTournamentParticipantTest() {
		XmlSport deporte = new XmlSport();
		deporte.setName("Football");
		deporte.setCfgObjectId(new BigInteger("1"));
		XmlTournament competicion = new XmlTournament();
		competicion.setXmlSport(deporte);
		competicion.setName("United States MLS");
		competicion.setCfgObjectId(new BigInteger("69"));

		XmlMatchParticipant participante = new XmlMatchParticipant("Kansas City", competicion);
		participante.setAwayParticipant(false);
		participante.setHomeParticipant(true);
		try {
			assertNotNull(synonymsComponent.resolverParticipantes(participante));
		} catch (ParticipantNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MultipleParticipantException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
