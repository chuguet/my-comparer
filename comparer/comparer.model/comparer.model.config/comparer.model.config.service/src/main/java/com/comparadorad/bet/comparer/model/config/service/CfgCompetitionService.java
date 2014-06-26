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

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SportCountryCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;

/**
 * The Class CfgCompetitionService.
 */
@Service
class CfgCompetitionService extends AbstractGenericCrudService<CfgCompetition>
		implements ICfgCompetitionService {

	/** The competition repository. */
	@Inject
	private CfgCompetitionRepository cfgCompetitionRepository;

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService#findAllLimit(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<CfgCompetition> findAllLimit(Integer limit, Integer skip) {
		return cfgCompetitionRepository.findAllLimit(limit, skip);
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService#getCompetitionsBySport(java.math.BigInteger)
	 */
	@Override
	public ArrayList<CfgCompetition> getCompetitionsBySport(BigInteger sportId) {
		return cfgCompetitionRepository.getCompetitionsBySport(sportId);
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService#getCompetitionsBySportAndCountry(java.math.BigInteger, java.math.BigInteger)
	 */
	@Override
	public List<CfgCompetition> getCompetitionsBySportAndCountry(
			BigInteger sportId, BigInteger countryId) {
		return cfgCompetitionRepository.getCompetitionsBySportAndCountry(
				sportId, countryId);
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
		return cfgCompetitionRepository.getCompetitionsFilteredBySport(sportId);
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
		return cfgCompetitionRepository
				.getCompetitionsFilteredBySportAndCountry(sportId, countryId);
	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgCompetition> getCrudRepository() {
		return cfgCompetitionRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService
	 * #mapReduceGetLevelCountryCompetitionEvent(java.math.BigInteger,
	 * java.math.BigInteger)
	 */
	@Override
	public List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEvent(
			BigInteger sportId, BigInteger countryId) {
		return cfgCompetitionRepository
				.mapReduceGetLevelCountryCompetitionEvent(sportId, countryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService
	 * #mapReduceGetLevelCountryCompetitionEventCache(java.math.BigInteger,
	 * java.math.BigInteger)
	 */
	@Override
	public List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEventCache(
			BigInteger sportId, BigInteger countryId) {
		return cfgCompetitionRepository
				.mapReduceGetLevelCountryCompetitionEvent(sportId, countryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService
	 * #mapReduceGetLevelCountryCompetitionEventLT(java.math.BigInteger,
	 * java.math.BigInteger)
	 */
	@Override
	public List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEventLT(
			BigInteger sportId, BigInteger countryId) {
		return cfgCompetitionRepository
				.mapReduceGetLevelCountryCompetitionEventLT(sportId, countryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService
	 * #mapReduceGetLevelCountryCompetitionEventLTCache(java.math.BigInteger,
	 * java.math.BigInteger)
	 */
	@Override
	public List<CountryCompetitionEvent> mapReduceGetLevelCountryCompetitionEventLTCache(
			BigInteger sportId, BigInteger countryId) {
		return cfgCompetitionRepository
				.mapReduceGetLevelCountryCompetitionEventLT(sportId, countryId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService
	 * #mapReduceGetLevelSportCountryCompetitionEvent(java.math.BigInteger)
	 */
	@Override
	public List<SportCountryCompetitionEvent> mapReduceGetLevelSportCountryCompetitionEvent(
			BigInteger sportId) {
		return cfgCompetitionRepository
				.mapReduceGetLevelSportCountryCompetitionEvent(sportId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionService
	 * #mapReduceGetLevelSportCountryCompetitionEventCache(java.math.BigInteger)
	 */
	@Override
	public List<SportCountryCompetitionEvent> mapReduceGetLevelSportCountryCompetitionEventCache(
			BigInteger sportId) {
		return cfgCompetitionRepository
				.mapReduceGetLevelSportCountryCompetitionEvent(sportId);
	}

	@Override
	public List<CfgCompetition> findBySport(String pId) {
		return cfgCompetitionRepository
				.findBySport(pId);
	}

}
