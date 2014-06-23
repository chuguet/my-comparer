/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CompetitionToolbar;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryToolbar;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportCountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportToolbar;

/**
 * The Class CfgCompetitionSynonymsRepositoryCustomImpl.
 */
class CfgCompetitionRepositoryCustomImpl extends
		AbstractCfgRepository<CfgCompetition> implements
		CfgCompetitionRepositoryCustom<CfgCompetition> {

	/** The Constant COLLECTION_NAME. */
	private static final String COLLECTION_NAME = "cfgCompetition";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepositoryCustom
	 * #findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgCompetition> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgCompetition> listResult = getMongoTemplate().find(query,
				CfgCompetition.class);
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepositoryCustom
	 * #findBySport(java.lang.String)
	 */
	@Override
	public List<CfgCompetition> findBySport(String pId) {
		List<CfgCompetition> result;

		Query query = new Query(where("sport.$id").is(pId)
				.and("coreActiveElement.active").is(true));

		result = getMongoTemplate().find(query, CfgCompetition.class);

		return result;
	}

	/**
	 * Gets the competition by id.
	 * 
	 * @param id
	 *            the id
	 * @return the competition by id {@inheritDoc}
	 */
	@Override
	public CfgCompetition getCompetitionById(BigInteger id) {
		CfgCompetition result;

		Query query = new Query(where("_id").is(id));

		result = getMongoTemplate().findOne(query, CfgCompetition.class);

		return result;
	}

	/**
	 * Gets the competition by name.
	 * 
	 * @param competitionName
	 *            the competition name
	 * @return the competition by name {@inheritDoc}
	 */
	@Override
	public ArrayList<CfgCompetition> getCompetitionByName(String competitionName) {
		List<CfgCompetition> result = new ArrayList<CfgCompetition>();

		Query query = new Query(where("i18n.i18nFields.string").is(
				competitionName));

		result = getMongoTemplate().find(query, CfgCompetition.class);

		return (ArrayList<CfgCompetition>) result;
	}

	/**
	 * Gets the competitions by sport.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the competitions by sport {@inheritDoc}
	 */
	@Override
	public ArrayList<CfgCompetition> getCompetitionsBySport(BigInteger sportId) {

		List<CfgCompetition> result = new ArrayList<CfgCompetition>();

		Query query = new Query(where("sport.$id").is(sportId));

		result = getMongoTemplate().find(query, CfgCompetition.class);

		return (ArrayList<CfgCompetition>) result;
	}

	/**
	 * Gets the competitions by sport and country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the competitions by sport and country {@inheritDoc}
	 */
	@Override
	public List<CfgCompetition> getCompetitionsBySportAndCountry(
			BigInteger sportId, BigInteger countryId) {

		List<CfgCompetition> result;

		Query query = new Query(where("sport.$id").is(sportId)
				.and("region.$ref").is("cfgRegion").and("region.$id")
				.is(countryId));

		result = getMongoTemplate().find(query, CfgCompetition.class);

		return (List<CfgCompetition>) result;

	}

	/**
	 * Gets the competitions filtered by sport.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the competitions filtered by sport {@inheritDoc}
	 */
	@Override
	public List<CfgCompetition> getCompetitionsFilteredBySport(
			BigInteger sportId) {
		Query query = new Query(where("sport.$id").is(sportId)
				.and("sport.$ref").is("cfgSport"));

		query.fields().include("region");

		List<CfgCompetition> result = getMongoTemplate().find(query,
				CfgCompetition.class);

		return (List<CfgCompetition>) result;
	}

	/**
	 * Gets the competitions filtered by sport and country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the competitions filtered by sport and country {@inheritDoc}
	 */
	@Override
	public List<CfgCompetition> getCompetitionsFilteredBySportAndCountry(
			BigInteger sportId, BigInteger countryId) {
		List<CfgCompetition> result;

		Query query = new Query(where("sport.$id").is(sportId)
				.and("region.$ref").is("cfgRegion").and("region.$id")
				.is(countryId));

		query.fields().include("i18n");
		query.fields().include("_id");

		result = getMongoTemplate().find(query, CfgCompetition.class);

		return (List<CfgCompetition>) result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepositoryCustom
	 * #mapReduceGetLevelCountryCompetitionEvent(java.math.BigInteger,
	 * java.math.BigInteger)
	 */
	@Override
	public List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEvent(
			BigInteger sportId, BigInteger countryId) {
		Query query = new Query(where("sport.$id").is(sportId.toString())
				.and("region.$id").is(countryId.toString()));

		MapReduceOptions options = new MapReduceOptions();
		options.outputTypeInline();

		MapReduceResults<CountryCompetitionEvent> resultQuery = getMongoTemplate()
				.mapReduce(query, COLLECTION_NAME,
						"classpath:mapreduce/MapCountryCompetitionEvent.js",
						"classpath:mapreduce/ReduceCountryCompetitionEvent.js",
						options, CountryCompetitionEvent.class);
		List<CountryCompetitionEvent> result = new ArrayList<CountryCompetitionEvent>();
		for (CountryCompetitionEvent countryCompetitionEvent : resultQuery) {

			if (countryCompetitionEvent.getValue().getCounter() > 0) {
				result.add(countryCompetitionEvent);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepositoryCustom
	 * #mapReduceGetLevelSportCountryCompetitionEventLT(java.math.BigInteger)
	 */
	@Override
	public List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEventLT(
			BigInteger sportId, BigInteger countryId) {
		Query query = new Query(where("sport.$id").is(sportId.toString())
				.and("region.$id").is(countryId.toString()));

		MapReduceOptions options = new MapReduceOptions();
		options.outputTypeInline();

		MapReduceResults<CountryCompetitionEvent> resultQuery = getMongoTemplate()
				.mapReduce(
						query,
						COLLECTION_NAME,
						"classpath:mapreduce/MapCountryCompetitionEventLT.js",
						"classpath:mapreduce/ReduceCountryCompetitionEventLT.js",
						options, CountryCompetitionEvent.class);
		List<CountryCompetitionEvent> result = new ArrayList<CountryCompetitionEvent>();
		for (CountryCompetitionEvent countryCompetitionEvent : resultQuery) {

			if (countryCompetitionEvent.getValue().getCounter() > 0) {
				result.add(countryCompetitionEvent);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepositoryCustom
	 * #mapReduceGetLevelSportCountryCompetitionEvent(java.math.BigInteger)
	 */
	@Override
	public List<SportCountryCompetitionEvent> mapReduceGetLevelSportCountryCompetitionEvent(
			BigInteger sportId) {
		Query query = new Query(where("sport.$id").is(sportId.toString()));

		MapReduceOptions options = new MapReduceOptions();
		options.outputTypeInline();

		MapReduceResults<SportCountryCompetitionEvent> resultQuery = getMongoTemplate()
				.mapReduce(
						query,
						COLLECTION_NAME,
						"classpath:mapreduce/MapSportCountryCompetitionEvent.js",
						"classpath:mapreduce/ReduceSportCountryCompetitionEvent.js",
						options, SportCountryCompetitionEvent.class);
		List<SportCountryCompetitionEvent> result = new ArrayList<SportCountryCompetitionEvent>();
		for (SportCountryCompetitionEvent sportCountryCompetitionEvent : resultQuery) {
			if (sportCountryCompetitionEvent.getValue()
					.getCounterCompetitions() != null
					&& sportCountryCompetitionEvent.getValue()
							.getCounterEvents() != null
					&& sportCountryCompetitionEvent.getValue()
							.getCounterCompetitions() > 0
					&& sportCountryCompetitionEvent.getValue()
							.getCounterEvents() > 0) {
				result.add(sportCountryCompetitionEvent);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepositoryCustom
	 * #mapReduceToolbarCompetition(java.lang.String, java.lang.String)
	 */
	@Override
	public List<CompetitionToolbar> mapReduceToolbarCompetition(String sportId,
			String countryId) {
		Query query = new Query(where("coreActiveElement.active").is(true)
				.and("sport.$id").is(sportId).and("region.$id").is(countryId));

		MapReduceOptions options = new MapReduceOptions();
		options.outputTypeInline();

		MapReduceResults<CompetitionToolbar> resultQuery = getMongoTemplate()
				.mapReduce(query, COLLECTION_NAME,
						"classpath:mapreduce/toolbar/MapCompetition.js",
						"classpath:mapreduce/toolbar/ReduceCompetition.js",
						options, CompetitionToolbar.class);
		List<CompetitionToolbar> result = new ArrayList<CompetitionToolbar>();
		for (CompetitionToolbar competitionToolbar : resultQuery) {

			if (competitionToolbar.getValue().getCounterEvents() > 0) {
				result.add(competitionToolbar);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepositoryCustom
	 * #mapReduceToolbarCountry(java.lang.String)
	 */
	@Override
	public List<CountryToolbar> mapReduceToolbarCountry(String sportId) {
		Query query = new Query(where("coreActiveElement.active").is(true)
				.and("sport.$id").is(sportId));

		MapReduceOptions options = new MapReduceOptions();
		options.outputTypeInline();

		MapReduceResults<CountryToolbar> resultQuery = getMongoTemplate()
				.mapReduce(query, COLLECTION_NAME,
						"classpath:mapreduce/toolbar/MapCountry.js",
						"classpath:mapreduce/toolbar/ReduceCountry.js",
						options, CountryToolbar.class);
		List<CountryToolbar> result = new ArrayList<CountryToolbar>();
		for (CountryToolbar countryToolbar : resultQuery) {

			if (countryToolbar.getValue().getCounterEvents() > 0) {
				result.add(countryToolbar);
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepositoryCustom
	 * #mapReduceToolbarSport()
	 */
	@Override
	public List<SportToolbar> mapReduceToolbarSport() {
		Query query = new Query(where("coreActiveElement.active").is(true));

		MapReduceOptions options = new MapReduceOptions();
		options.outputTypeInline();

		MapReduceResults<SportToolbar> resultQuery = getMongoTemplate()
				.mapReduce(query, COLLECTION_NAME,
						"classpath:mapreduce/toolbar/MapSport.js",
						"classpath:mapreduce/toolbar/ReduceSport.js", options,
						SportToolbar.class);
		List<SportToolbar> result = new ArrayList<SportToolbar>();
		for (SportToolbar sportToolbar : resultQuery) {

			if (sportToolbar.getValue().getCounterEvents() > 0) {
				result.add(sportToolbar);
			}
		}
		return result;
	}

}
