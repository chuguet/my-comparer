/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.databaseclean.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgRegionSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportSynonymsRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.securebet.repository.SecureBetRepository;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.repository.ValueBetRepository;

/**
 * The Class Cleaner.
 */
@Component
class DatabaseCleaner extends AbstractDatabaseCleaner {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(DatabaseCleaner.class);

	/** The competition repository. */
	@Inject
	private CfgCompetitionRepository competitionRepository;

	/** The competition synonyms repository. */
	@Inject
	private CfgCompetitionSynonymsRepository competitionSynonymsRepository;

	/** The match service. */
	@Inject
	private RtMatchRepository matchRepository;

	/** The participant repository. */
	@Inject
	private CfgParticipantRepository participantRepository;

	/** The participant synonyms repository. */
	@Inject
	private CfgParticipantSynonymsRepository participantSynonymsRepository;

	/** The region synonyms repository. */
	@Inject
	private CfgRegionSynonymsRepository regionSynonymsRepository;

	/** The secure bet repository. */
	@Inject
	private SecureBetRepository secureBetRepository;

	/** The skip competition. */
	private Integer skipCompetition = 0;

	/** The skip competition synonyms. */
	private Integer skipCompetitionSynonyms = 0;

	/** The skip match. */
	private Integer skipMatch = 0;

	/** The skip participant. */
	private Integer skipParticipant = 0;

	/** The skip participant synonyms. */
	private Integer skipParticipantSynonyms = 0;

	/** The skip region synonyms. */
	private Integer skipRegionSynonyms = 0;

	/** The skip secure bet. */
	private Integer skipSecureBet = 0;

	/** The skip sport. */
	private Integer skipSport = 0;

	/** The skip sport synonyms. */
	private Integer skipSportSynonyms = 0;

	/** The skip value bet. */
	private Integer skipValueBet = 0;

	/** The sport repository. */
	@Inject
	private CfgSportRepository sportRepository;

	/** The sport synonyms repository. */
	@Inject
	private CfgSportSynonymsRepository sportSynonymsRepository;

	/** The validator. */
	@Inject
	private LocalValidatorFactoryBean validator;

	/** The value bet repository. */
	@Inject
	private ValueBetRepository valueBetRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanCompetitions()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanCompetitions() {
		Long numCompetitions = competitionRepository.count();
		this.skipCompetition = calculateSkip(this.skipCompetition,
				numCompetitions, dataProperties.getLimitQuery());
		LOG.info(new StringBuffer("Se recuperan las competiciones desde ")
				.append(this.skipCompetition).append(" hasta la competicion ")
				.append(this.skipCompetition + dataProperties.getLimitQuery())
				.append(" de un total de ").append(numCompetitions)
				.append(" competiciones.").toString());
		List<CfgCompetition> competitions = competitionRepository.findAllLimit(
				dataProperties.getLimitQuery(), this.skipCompetition);
		List<CfgCompetition> wrongCompetitions = new ArrayList<CfgCompetition>();

		for (CfgCompetition competition : competitions) {
			final Set<ConstraintViolation<CfgCompetition>> violations = validator
					.validate(competition);
			if (!violations.isEmpty()) {
				wrongCompetitions.add(competition);
			}
		}

		competitionRepository.delete(wrongCompetitions);
		return wrongCompetitions.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanCompetitionsSynonyms()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanCompetitionsSynonyms() {
		Long numSynonymsCompetition = competitionSynonymsRepository.count();
		this.skipCompetitionSynonyms = calculateSkip(
				this.skipCompetitionSynonyms, numSynonymsCompetition,
				dataProperties.getLimitQuery());
		LOG.info(new StringBuffer(
				"Se recuperan los sinonimos de competicion desde ")
				.append(this.skipCompetitionSynonyms)
				.append(" hasta el sinonimo de competicion ")
				.append(this.skipCompetitionSynonyms
						+ dataProperties.getLimitQuery())
				.append(" de un total de ").append(numSynonymsCompetition)
				.append(" sinonimos de competicion.").toString());
		List<CfgCompetitionSynonyms> competitionsSynonyms = competitionSynonymsRepository
				.findAllLimit(dataProperties.getLimitQuery(),
						this.skipCompetitionSynonyms);
		List<CfgCompetitionSynonyms> wrongCompetitionsSynonyms = new ArrayList<CfgCompetitionSynonyms>();

		for (CfgCompetitionSynonyms competitionSynonyms : competitionsSynonyms) {
			final Set<ConstraintViolation<CfgCompetitionSynonyms>> violations = validator
					.validate(competitionSynonyms);
			if (!violations.isEmpty()) {
				wrongCompetitionsSynonyms.add(competitionSynonyms);
			}
		}

		competitionSynonymsRepository.delete(wrongCompetitionsSynonyms);
		return wrongCompetitionsSynonyms.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanMatches()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanMatches() {
		Long numMatchs = matchRepository.count();
		this.skipMatch = calculateSkip(this.skipMatch, numMatchs,
				dataProperties.getLimitQuery());
		LOG.info(new StringBuffer("Se recuperan los partidos desde ")
				.append(this.skipMatch).append(" hasta el partido ")
				.append(this.skipMatch + dataProperties.getLimitQuery())
				.append(" de un total de ").append(numMatchs)
				.append(" partidos.").toString());
		List<RtMatch> matchs = matchRepository.findAllLimit(
				dataProperties.getLimitQuery(), this.skipMatch);
		List<RtMatch> pastMatches = new ArrayList<RtMatch>();
		List<RtMatch> currentMatches = new ArrayList<RtMatch>();
		List<RtMatch> wrongMatches = new ArrayList<RtMatch>();

		for (RtMatch match : matchs) {
			if (isPastMatch(match)) {
				pastMatches.add(match);
			} else {
				currentMatches.add(match);
			}
		}
		for (RtMatch match : currentMatches) {
			final Set<ConstraintViolation<RtMatch>> violations = validator
					.validate(match);
			if (!violations.isEmpty()) {
				for (ConstraintViolation<RtMatch> violation : violations) {
					LOG.info(new StringBuffer("Match: ")
							.append(match.getName(null))
							.append(" violacion ==>")
							.append(violation.getMessage()).toString());
				}
				wrongMatches.add(match);
			}
		}

		exportMatchesToZip(matchRepository.convertMatchsToJSON(pastMatches));
		matchRepository.delete(pastMatches);
		matchRepository.delete(wrongMatches);
		return wrongMatches.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanParticipants()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanParticipants() {
		Long numParticipants = participantRepository.count();
		this.skipParticipant = calculateSkip(this.skipParticipant,
				numParticipants, dataProperties.getLimitQuery());
		LOG.info(new StringBuffer("Se recuperan los participantes desde ")
				.append(this.skipParticipant).append(" hasta el participante ")
				.append(this.skipParticipant + dataProperties.getLimitQuery())
				.append(" de un total de ").append(numParticipants)
				.append(" participantes.").toString());
		List<CfgParticipant> participants = participantRepository.findAllLimit(
				dataProperties.getLimitQuery(), this.skipParticipant);
		List<CfgParticipant> wrongParticipants = new ArrayList<CfgParticipant>();

		for (CfgParticipant participant : participants) {
			final Set<ConstraintViolation<CfgParticipant>> violations = validator
					.validate(participant);
			if (!violations.isEmpty()) {
				wrongParticipants.add(participant);
			}
		}

		participantRepository.delete(wrongParticipants);
		return wrongParticipants.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanParticipantsSynonyms()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanParticipantsSynonyms() {
		Long numSynonymsParticipants = participantSynonymsRepository.count();
		this.skipParticipantSynonyms = calculateSkip(
				this.skipParticipantSynonyms, numSynonymsParticipants,
				dataProperties.getLimitQuery());
		LOG.info(new StringBuffer(
				"Se recuperan los sinonimos de participante desde ")
				.append(this.skipParticipantSynonyms)
				.append(" hasta el sinonimo de participante ")
				.append(this.skipParticipantSynonyms
						+ dataProperties.getLimitQuery())
				.append(" de un total de ").append(numSynonymsParticipants)
				.append(" sinonimos de participante.").toString());
		List<CfgParticipantSynonyms> participantsSynonyms = participantSynonymsRepository
				.findAllLimit(dataProperties.getLimitQuery(),
						this.skipParticipantSynonyms);
		List<CfgParticipantSynonyms> wrongParticipantsSynonyms = new ArrayList<CfgParticipantSynonyms>();

		for (CfgParticipantSynonyms participantSynonyms : participantsSynonyms) {
			final Set<ConstraintViolation<CfgParticipantSynonyms>> violations = validator
					.validate(participantSynonyms);
			if (!violations.isEmpty()) {
				wrongParticipantsSynonyms.add(participantSynonyms);
			}
		}

		participantSynonymsRepository.delete(wrongParticipantsSynonyms);
		return wrongParticipantsSynonyms.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanRegionSynonyms()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanRegionSynonyms() {
		Long numSynonymsRegion = regionSynonymsRepository.count();
		this.skipRegionSynonyms = calculateSkip(this.skipRegionSynonyms,
				numSynonymsRegion, dataProperties.getLimitQuery());
		LOG.info(new StringBuffer("Se recuperan los sinonimos de region desde ")
				.append(this.skipRegionSynonyms)
				.append(" hasta el sinonimo de region ")
				.append(this.skipRegionSynonyms
						+ dataProperties.getLimitQuery())
				.append(" de un total de ").append(numSynonymsRegion)
				.append(" sinonimos de region.").toString());
		List<CfgRegionSynonyms> regionsSynonyms = regionSynonymsRepository
				.findAllLimit(dataProperties.getLimitQuery(),
						this.skipRegionSynonyms);
		List<CfgRegionSynonyms> wrongRegionsSynonyms = new ArrayList<CfgRegionSynonyms>();

		for (CfgRegionSynonyms regionSynonyms : regionsSynonyms) {
			final Set<ConstraintViolation<CfgRegionSynonyms>> violations = validator
					.validate(regionSynonyms);
			if (!violations.isEmpty()) {
				wrongRegionsSynonyms.add(regionSynonyms);
			}
		}

		regionSynonymsRepository.delete(wrongRegionsSynonyms);
		return wrongRegionsSynonyms.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanSports()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanSports() {
		Long numSports = sportRepository.count();
		this.skipSport = calculateSkip(this.skipSport, numSports,
				dataProperties.getLimitQuery());
		LOG.info(new StringBuffer("Se recuperan los deportes desde ")
				.append(this.skipSport).append(" hasta el deporte ")
				.append(this.skipSport + dataProperties.getLimitQuery())
				.append(" de un total de ").append(numSports)
				.append(" deportes.").toString());
		List<CfgSport> sports = sportRepository.findAllLimit(
				dataProperties.getLimitQuery(), this.skipSport);
		List<CfgSport> wrongSports = new ArrayList<CfgSport>();

		for (CfgSport sport : sports) {
			final Set<ConstraintViolation<CfgSport>> violations = validator
					.validate(sport);
			if (!violations.isEmpty()) {
				wrongSports.add(sport);
			}
		}

		sportRepository.delete(wrongSports);
		return wrongSports.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanSportSynonyms()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanSportSynonyms() {
		Long numSynonymsSport = sportSynonymsRepository.count();
		this.skipSportSynonyms = calculateSkip(this.skipSportSynonyms,
				numSynonymsSport, dataProperties.getLimitQuery());
		LOG.info(new StringBuffer(
				"Se recuperan los sinonimos de deporte desde ")
				.append(this.skipSportSynonyms)
				.append(" hasta el sinonimo de deporte ")
				.append(this.skipSportSynonyms + dataProperties.getLimitQuery())
				.append(" de un total de ").append(numSynonymsSport)
				.append(" sinonimos de deporte.").toString());
		List<CfgSportSynonyms> sportsSynonyms = sportSynonymsRepository
				.findAllLimit(dataProperties.getLimitQuery(),
						this.skipSportSynonyms);
		List<CfgSportSynonyms> wrongSportsSynonyms = new ArrayList<CfgSportSynonyms>();

		for (CfgSportSynonyms sportSynonyms : sportsSynonyms) {
			final Set<ConstraintViolation<CfgSportSynonyms>> violations = validator
					.validate(sportSynonyms);
			if (!violations.isEmpty()) {
				wrongSportsSynonyms.add(sportSynonyms);
			}
		}

		sportSynonymsRepository.delete(wrongSportsSynonyms);
		return wrongSportsSynonyms.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanSureBet()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanSureBet() {
		Long numSureBets = secureBetRepository.count();
		this.skipSecureBet = calculateSkip(this.skipSecureBet, numSureBets,
				dataProperties.getLimitQuery());
		LOG.info(new StringBuffer("Se recuperan las sure bets desde ")
				.append(this.skipSecureBet).append(" hasta la sure bet ")
				.append(this.skipSecureBet + dataProperties.getLimitQuery())
				.append(" de un total de ").append(numSureBets)
				.append(" sure bets.").toString());
		List<SecureBeanData> secureBets = secureBetRepository.findAllLimit(
				dataProperties.getLimitQuery(), this.skipSecureBet);
		List<SecureBeanData> wrongsecureBets = new ArrayList<SecureBeanData>();

		for (SecureBeanData secureBet : secureBets) {
			final Set<ConstraintViolation<SecureBeanData>> violations = validator
					.validate(secureBet);
			if (!violations.isEmpty()) {
				wrongsecureBets.add(secureBet);
			}
		}

		secureBetRepository.delete(wrongsecureBets);
		return wrongsecureBets.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.validators.ICleaner#
	 * cleanValueBet()
	 */
	/** {@inheritDoc} */
	@Override
	public Integer cleanValueBet() {
		Long numValueBets = valueBetRepository.count();
		this.skipValueBet = calculateSkip(this.skipValueBet, numValueBets,
				dataProperties.getLimitQuery());
		LOG.info(new StringBuffer("Se recuperan las value bets desde ")
				.append(this.skipValueBet).append(" hasta la value bet ")
				.append(this.skipValueBet + dataProperties.getLimitQuery())
				.append(" de un total de ").append(numValueBets)
				.append(" value bets.").toString());
		List<ValueBetData> valueBets = valueBetRepository.findAllLimit(
				dataProperties.getLimitQuery(), this.skipValueBet);
		List<ValueBetData> wrongValueBets = new ArrayList<ValueBetData>();

		for (ValueBetData valueBet : valueBets) {
			final Set<ConstraintViolation<ValueBetData>> violations = validator
					.validate(valueBet);
			if (!violations.isEmpty()) {
				wrongValueBets.add(valueBet);
			}
		}

		valueBetRepository.delete(wrongValueBets);
		return wrongValueBets.size();
	}

}
