/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.synonyms;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.service.ICfgBetTypeEventSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgBetTypeSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionEventSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgSportSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgParticipantSynonymsService;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.BetTypeEventNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.BetTypeNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.CompetitionAndSportNotEqualScope;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleBetTypeEventException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleBetTypeException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleSportException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleTeamException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleTournamentEventException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleTournamentException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.SportNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.TeamNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.TournamentEventNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.TournamentNotFoundException;

/**
 * The Class SynonymsComponent.
 */
@Component
class SynonymsComponent implements ISynonymsComponent {

	/** The cfg bet type event synonyms service. */
	@Inject
	private ICfgBetTypeEventSynonymsService cfgBetTypeEventSynonymsService;

	/** The cfg bet type synonyms service. */
	@Inject
	private ICfgBetTypeSynonymsService cfgBetTypeSynonymsService;

	/** The cfg sport synonyms service. */
	@Inject
	private ICfgSportSynonymsService cfgSportSynonymsService;

	/** The cfg team synonyms service. */
	@Inject
	private ICfgParticipantSynonymsService cfgParticipantSynonymsService;

	/** The competition synonyms service. */
	@Inject
	private ICfgCompetitionSynonymsService competitionSynonymsService;

	/** The competition event synonyms service. */
	@Inject
	private ICfgCompetitionEventSynonymsService competitionEventSynonymsService;

	/**
	 * Resolver bet type.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg bet type
	 * @throws BetTypeNotFoundException
	 *             the bet type not found exception
	 * @throws MultipleBetTypeException
	 *             the multiple bet type exception {@inheritDoc}
	 */
	public CfgBetType findByNameBetType(String name)
			throws BetTypeNotFoundException, MultipleBetTypeException {
		CfgBetType cfgBetType = null;
		List<CfgBetTypeSynonyms> lstCfgBetTypeSynonyms = cfgBetTypeSynonymsService
				.customFindByname(name);
		if (lstCfgBetTypeSynonyms.size() == 1) {
			cfgBetType = lstCfgBetTypeSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgBetTypeSynonyms.size() == 0) {
			throw new BetTypeNotFoundException("Not Found bet type: " + name);
		} else if (lstCfgBetTypeSynonyms.size() > 1) {
			throw new MultipleBetTypeException("Multiple bet type found: "
					+ name);
		}
		return cfgBetType;
	}

	/**
	 * Find by name bet type event.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg bet type event
	 * @throws BetTypeEventNotFoundException
	 *             the bet type event not found exception
	 * @throws MultipleBetTypeEventException
	 *             the multiple bet type event exception {@inheritDoc}
	 */
	@Override
	public CfgBetTypeEvent findByNameBetTypeEvent(String name)
			throws BetTypeEventNotFoundException, MultipleBetTypeEventException {
		CfgBetTypeEvent result = null;
		List<CfgBetTypeEventSynonyms> lstCfgBetTypeEventSynonyms = cfgBetTypeEventSynonymsService
				.customFindByname(name);
		if (lstCfgBetTypeEventSynonyms.size() == 1) {
			result = lstCfgBetTypeEventSynonyms.get(0).getBetTypeEvent();
		} else if (lstCfgBetTypeEventSynonyms.size() == 0) {
			throw new BetTypeEventNotFoundException("Not Found bet type: "
					+ name);
		} else if (lstCfgBetTypeEventSynonyms.size() > 1) {
			throw new MultipleBetTypeEventException("Multiple bet type found: "
					+ name);
		}
		return result;
	}

	/**
	 * Find by name competition.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg competition
	 * @throws TournamentNotFoundException
	 *             the tournament not found exception
	 * @throws MultipleTournamentException
	 *             the mutiple tournament exception {@inheritDoc}
	 */
	public CfgCompetition findByNameCompetition(String name)
			throws TournamentNotFoundException, MultipleTournamentException {
		CfgCompetition result = null;
		List<CfgCompetitionSynonyms> lstCfgCompetitionSynonyms = competitionSynonymsService
				.customFindByname(name);
		if (lstCfgCompetitionSynonyms.size() == 1) {
			result = lstCfgCompetitionSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgCompetitionSynonyms.size() == 0) {
			throw new TournamentNotFoundException("Not found the tournament: "
					+ name);
		} else if (lstCfgCompetitionSynonyms.size() > 1) {
			throw new MultipleTournamentException("Multiple Sport tournament: "
					+ name);
		}
		return result;
	}

	/**
	 * Find by name sport.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg sport
	 * @throws SportNotFoundException
	 *             the sport not found exception
	 * @throws MultipleSportException
	 *             the mutiple sport exception {@inheritDoc}
	 */
	public CfgSport findByNameSport(String name) throws SportNotFoundException,
			MultipleSportException {
		CfgSport result = null;
		List<CfgSportSynonyms> lstCfgSportSynonyms = cfgSportSynonymsService
				.customFindByname(name);
		if (lstCfgSportSynonyms.size() == 1) {
			result = lstCfgSportSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgSportSynonyms.size() == 0) {
			throw new SportNotFoundException("Not found the sport: " + name);
		} else if (lstCfgSportSynonyms.size() > 1) {
			throw new MultipleSportException("Multiple Sport found: " + name);
		}
		return result;
	}

	/**
	 * Find by name team.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg team
	 * @throws TeamNotFoundException
	 *             the team not found exception
	 * @throws MultipleTeamException
	 *             the mutiple team exception {@inheritDoc}
	 */
	public CfgParticipant findByNameTeam(String name) throws TeamNotFoundException,
			MultipleTeamException {
		CfgParticipant result = null;
		List<CfgParticipantSynonyms> lstCfgTeamSynonyms = cfgParticipantSynonymsService
				.customFindByname(name);
		if (lstCfgTeamSynonyms.size() == 1) {
			result = lstCfgTeamSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgTeamSynonyms.size() == 0) {
			throw new TeamNotFoundException("Not found the team: " + name);
		} else if (lstCfgTeamSynonyms.size() > 1) {
			throw new MultipleTeamException("Multiple Sport team: " + name);
		}
		return result;
	}

	/**
	 * Resolver competition and sport.
	 * 
	 * @param xmlMatch
	 *            the xml match
	 * @return the cfg competition
	 * @throws TournamentNotFoundException
	 *             the tournament not found exception
	 * @throws MultipleTournamentException
	 *             the mutiple tournament exception
	 * @throws SportNotFoundException
	 *             the sport not found exception
	 * @throws MultipleSportException
	 *             the mutiple sport exception
	 * @throws CompetitionAndSportNotEqualScope
	 *             the competition and sport not equal scope {@inheritDoc}
	 */
	public CfgCompetition resolverCompetitionAndSport(XmlMatch xmlMatch)
			throws TournamentNotFoundException, MultipleTournamentException,
			SportNotFoundException, MultipleSportException,
			CompetitionAndSportNotEqualScope {

		CfgSport cfgSport = null;

		CfgCompetition cfgCompetition = null;

		String sport = null;

		String competition = xmlMatch.getXmlTournament().getName();

		cfgCompetition = findByNameCompetition(competition);

		if (xmlMatch.getXmlTournament().getXmlSport() != null
				&& xmlMatch.getXmlTournament().getXmlSport().getName() != null) {
			sport = xmlMatch.getXmlTournament().getXmlSport().getName();
			cfgSport = findByNameSport(sport);
		}

		if (cfgSport != null && cfgCompetition.getSport() != null
				&& !cfgCompetition.getSport().equals(cfgSport)) {
			throw new CompetitionAndSportNotEqualScope(
					"Competition and Sport is not the same Scope: Competition: "
							+ competition + ", Sport: " + sport);
		}

		return cfgCompetition;
	}

	/**
	 * Find by name competition event.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg competition envet
	 * @throws TournamentEventNotFoundException
	 *             the tournament event not found exception
	 * @throws MultipleTournamentEventException
	 *             the mutiple tournament event exception {@inheritDoc}
	 */
	public CfgCompetitionEvent findByNameCompetitionEvent(String name)
			throws TournamentEventNotFoundException,
			MultipleTournamentEventException {
		CfgCompetitionEvent result = null;
		List<CfgCompetitionEventSynonyms> lstCfgCompetitionEventSynonyms = competitionEventSynonymsService
				.customFindByname(name);
		if (lstCfgCompetitionEventSynonyms.size() == 1) {
			result = lstCfgCompetitionEventSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgCompetitionEventSynonyms.size() == 0) {
			throw new TournamentEventNotFoundException(
					"Not found the tournament event: " + name);
		} else if (lstCfgCompetitionEventSynonyms.size() > 1) {
			throw new MultipleTournamentEventException(
					"Multiple Sport tournament event: " + name);
		}
		return result;
	}

	/**
	 * Resolver participantes.
	 * 
	 * @param xmlMatchParticipant
	 *            the xml match participant
	 * @return the cfg team
	 * @throws TeamNotFoundException
	 *             the team not found exception
	 * @throws MultipleTeamException
	 *             the mutiple team exception {@inheritDoc}
	 */

	public CfgParticipant resolverParticipantes(XmlMatchParticipant xmlMatchParticipant)
			throws TeamNotFoundException, MultipleTeamException {
		CfgParticipant cfgTeam = null;

		List<CfgParticipantSynonyms> lstCfgTeamSynonyms;
		String teamName = xmlMatchParticipant.getName();

		// Buscamos por nombre de competicion y de equipo
		if (xmlMatchParticipant.getParent() != null) {
			if (xmlMatchParticipant.getXmlTournament() != null) {
				BigInteger competitionId = xmlMatchParticipant.getParent()
						.getCfgObjectId();
				lstCfgTeamSynonyms = cfgParticipantSynonymsService
						.customFindByTeamNameCompetitionName(teamName,
								competitionId);
				if (!lstCfgTeamSynonyms.isEmpty()) {
					cfgTeam = lstCfgTeamSynonyms.get(0).getRelatedDocument();
				}
			}
		}

		// Si no hay nada buscamos por nombre de deporte y de equipo
		if (cfgTeam == null) {
			if (xmlMatchParticipant.getXmlTournament() != null) {
				if (xmlMatchParticipant.getXmlTournament().getXmlSport() != null) {
					BigInteger sportId = xmlMatchParticipant.getXmlTournament()
							.getXmlSport().getCfgObjectId();
					lstCfgTeamSynonyms = cfgParticipantSynonymsService
							.customFindByTeamNameSportName(teamName, sportId);
					if (!lstCfgTeamSynonyms.isEmpty()) {
						cfgTeam = lstCfgTeamSynonyms.get(0)
								.getRelatedDocument();
					}
				}

			}
		}

		// Si no hay nada buscamos por nombre de equipo
		if (cfgTeam == null) {
			cfgTeam = findByNameTeam(teamName);
		}

		return cfgTeam;
	}
}
