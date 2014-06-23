/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CompetitionToolbar;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryToolbar;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportCountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportToolbar;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;

/**
 * The Interface CfgCompetitionRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
public interface CfgCompetitionRepositoryCustom<T extends CfgCompetition>
		extends IGenericCustomRepository<T> {

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list
	 */
	List<CfgCompetition> findAllLimit(Integer limit, Integer skip);
	
	/**
	 * Find by sport.
	 *
	 * @param pId the id
	 * @return the list
	 */
	List<CfgCompetition> findBySport(String pId);

	/**
	 * Gets the competition by id.
	 * 
	 * @param id
	 *            the id
	 * @return the competition by id
	 */
	CfgCompetition getCompetitionById(BigInteger id);

	/**
	 * Gets the competition by name.
	 * 
	 * @param competitionName
	 *            the competition name
	 * @return the competition by name
	 */
	ArrayList<CfgCompetition> getCompetitionByName(String competitionName);

	/**
	 * Gets the competitions by sport.
	 * 
	 * @param pSportId
	 *            the sport id
	 * @return the competitions by sport
	 */
	ArrayList<CfgCompetition> getCompetitionsBySport(BigInteger pSportId);

	/**
	 * Gets the competitions by sport and country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the competitions by sport and country
	 */
	List<CfgCompetition> getCompetitionsBySportAndCountry(BigInteger sportId,
			BigInteger countryId);

	/**
	 * Gets the competitions filtered by sport.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the competitions filtered by sport
	 */
	List<CfgCompetition> getCompetitionsFilteredBySport(BigInteger sportId);

	/**
	 * Gets the competitions filtered by sport and country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the competitions filtered by sport and country
	 */
	List<CfgCompetition> getCompetitionsFilteredBySportAndCountry(
			BigInteger sportId, BigInteger countryId);

	/**
	 * Gets the first level country long term.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the first level country long term
	 */
	List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEvent(
			BigInteger sportId, BigInteger countryId);

	/**
	 * Map reduce get level country competition event lt.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the list
	 */
	List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEventLT(
			BigInteger sportId, BigInteger countryId);

	/**
	 * Map reduce get level sport country competition event.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the list
	 */
	List<SportCountryCompetitionEvent> mapReduceGetLevelSportCountryCompetitionEvent(
			BigInteger sportId);

	/**
	 * Map reduce toolbar competition.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the list
	 */
	List<CompetitionToolbar> mapReduceToolbarCompetition(String sportId,
			String countryId);

	/**
	 * Map reduce toolbar country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the list
	 */
	List<CountryToolbar> mapReduceToolbarCountry(String sportId);

	/**
	 * Map reduce toolbar sport.
	 * 
	 * @return the list
	 */
	List<SportToolbar> mapReduceToolbarSport();

}