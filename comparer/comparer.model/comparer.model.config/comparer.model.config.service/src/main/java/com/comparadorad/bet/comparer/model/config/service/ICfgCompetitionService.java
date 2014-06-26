/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportCountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Interface ICfgCompetitionService.
 */
public interface ICfgCompetitionService extends
		IGenericCrudService<CfgCompetition> {

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
	 * Gets the competitions by sport.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the competitions by sport
	 */
	ArrayList<CfgCompetition> getCompetitionsBySport(BigInteger sportId);

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
	 * Gets the competitions by sport and country.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the competitions by sport and country
	 */
	List<CfgCompetition> getCompetitionsFilteredBySportAndCountry(
			BigInteger sportId, BigInteger countryId);

	/**
	 * Gets the first level country competition event.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the first level country competition event
	 */
	List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEvent(
			BigInteger sportId, BigInteger countryId);

	/**
	 * Map reduce get level country competition event cache.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the list
	 */
	@Cacheable(value = "countryCompetitionEventCache")
	List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEventCache(
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
	 * Map reduce get level country competition event lt cache.
	 * 
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @return the list
	 */
	@Cacheable(value = "countryCompetitionEventLTCache")
	List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEventLTCache(
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
	 * Map reduce get level sport country competition event cache.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the list
	 */
	@Cacheable(value = "sportCountryCompetitionEventCache")
	List<SportCountryCompetitionEvent> mapReduceGetLevelSportCountryCompetitionEventCache(
			BigInteger sportId);
}
