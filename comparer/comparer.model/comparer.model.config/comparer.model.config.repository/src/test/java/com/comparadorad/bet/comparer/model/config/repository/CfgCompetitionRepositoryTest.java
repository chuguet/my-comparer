/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CompetitionToolbar;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryToolbar;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportCountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportToolbar;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;

/**
 * The Class CfgCompetitionRepositoryTest.
 */
public class CfgCompetitionRepositoryTest extends
		AbstractConfigRepositoryTest<CfgCompetitionRepository> {

	/** The competition repository. */
	@Inject
	private CfgCompetitionRepository cfgCompetitionRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgCompetitionRepository getCrudRepository() {
		return cfgCompetitionRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		HashSet<CfgParticipant> set = new HashSet<CfgParticipant>();
		CfgCompetition cfgCompetition = new CfgCompetition();
		CoreDate coreDate = new CoreDate(new Date());
		cfgCompetition.setEndDate(coreDate);
		cfgCompetition.setStartDate(coreDate);
		cfgCompetition.setName("comp1");
		cfgCompetition.setI18n(getI18N());
		CfgParticipant participant = new CfgParticipant();
		participant.setObjectId(new BigInteger("867343746"));
		participant.setName("");
		participant.setI18n(getI18N());
		set.add(participant);
		cfgCompetition.setParticipant(set);

		return cfgCompetition;
	}

	/**
	 * Test query.
	 */
	@Test
	public void testgetCompetitionsBySportAndCountry() {
		List<CfgCompetition> result = cfgCompetitionRepository
				.getCompetitionsBySportAndCountry(new BigInteger("1"),
						new BigInteger("724"));

		assertNotNull(result);
		assertEquals(result.size(), 6);
		assertEquals(result.get(0).getSport().getObjectId(),
				new BigInteger("1"));
		assertEquals(result.get(0).getRegion().getObjectId(), new BigInteger(
				"724"));
	}

	@Test
	public void getCompetitionsFilteredBySport() {
		List<CfgCompetition> competitions = cfgCompetitionRepository
				.getCompetitionsFilteredBySport(new BigInteger("1"));

		CfgCompetition competitionEspana = null;
		for (CfgCompetition competition : competitions) {
			if (competition.getRegion().getObjectId()
					.equals(new BigInteger("724"))) {
				competitionEspana = competition;
			}
		}
		assertNotNull(competitionEspana);
		assertEquals(competitions.size(), 23);

	}

	@Test
	public void getCompetitionById() {
		CfgCompetition result = cfgCompetitionRepository
				.getCompetitionById(new BigInteger("3"));

		assertNotNull(result);
		assertEquals(result.getRegion().getObjectId(), new BigInteger("724"));
		assertEquals(result.getObjectId(), new BigInteger("3"));
	}

	@Test
	public void getCompetitionsBySport() {
		ArrayList<CfgCompetition> competitions = cfgCompetitionRepository
				.getCompetitionsBySport(new BigInteger("1"));

		CfgCompetition competitionEspana = null;
		for (CfgCompetition competition : competitions) {
			if (competition.getRegion().getObjectId()
					.equals(new BigInteger("724"))) {
				competitionEspana = competition;
			}
		}
		assertNotNull(competitionEspana);
		assertEquals(competitions.size(), 23);
		assertEquals(competitions.get(0).getSport().getObjectId(),
				new BigInteger("1"));
	}

	@Test
	public void getCompetitionByName() {
		ArrayList<CfgCompetition> competitions = cfgCompetitionRepository
				.getCompetitionByName("La Liga");

		CfgCompetition competitionLaLiga = null;
		for (CfgCompetition competition : competitions) {
			if (competition.getRegion().getObjectId()
					.equals(new BigInteger("724"))) {
				competitionLaLiga = competition;
			}
		}
		assertNotNull(competitionLaLiga);
		assertEquals(competitions.size(), 1);
		assertEquals(competitions.get(0).getObjectId(), new BigInteger(
				"870865763"));
	}

	/**
	 * Test map reduce country competition event.
	 */
	@Test
	public void testMapReduceCountryCompetitionEvent() {
		List<CountryCompetitionEvent> resultQuery = cfgCompetitionRepository
				.mapReduceGetLevelCountryCompetitionEvent(new BigInteger("1"),
						new BigInteger("724"));
		List<CountryCompetitionEvent> result = new ArrayList<CountryCompetitionEvent>();
		for (CountryCompetitionEvent countryCompetitionEvent : resultQuery) {
			if (!countryCompetitionEvent.getValue().getCounter().equals(0)) {
				result.add(countryCompetitionEvent);
			}
		}

		assertNotNull(result);
	}

	/**
	 * Test map reduce sport country competition event.
	 */
	@Test
	public void testMapReduceSportCountryCompetitionEvent() {
		List<SportCountryCompetitionEvent> resultQuery = cfgCompetitionRepository
				.mapReduceGetLevelSportCountryCompetitionEvent(new BigInteger(
						"27"));
		List<SportCountryCompetitionEvent> result = new ArrayList<SportCountryCompetitionEvent>();
		for (SportCountryCompetitionEvent sportCountryCompetitionEvent : resultQuery) {
			if (!sportCountryCompetitionEvent.getValue()
					.getCounterCompetitions().equals(0)
					&& !sportCountryCompetitionEvent.getValue()
							.getCounterEvents().equals(0)) {
				result.add(sportCountryCompetitionEvent);
			}
		}

		assertNotNull(result);
	}

	@Test
	public void testMapReduceSportToolbar() {
		List<SportToolbar> resultQuery = cfgCompetitionRepository
				.mapReduceToolbarSport();

		assertNotNull(resultQuery);
	}

	@Test
	public void testMapReduceCountryToolbar() {
		List<CountryToolbar> resultQuery = cfgCompetitionRepository
				.mapReduceToolbarCountry("1");

		assertNotNull(resultQuery);
	}

	@Test
	public void testMapReduceCompetitionToolbar() {
		List<CompetitionToolbar> resultQuery = cfgCompetitionRepository
				.mapReduceToolbarCompetition("1", "724");

		assertNotNull(resultQuery);
	}
}
