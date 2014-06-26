/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.synonyms;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
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
 * The Interface ISynonymsComponent.
 */
public interface ISynonymsComponent {

	/**
	 * Resolver bet type.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg bet type
	 * @throws BetTypeNotFoundException
	 *             the bet type not found exception
	 * @throws MultipleBetTypeException
	 *             the multiple bet type exception
	 */
	CfgBetType findByNameBetType(String name) throws BetTypeNotFoundException,
			MultipleBetTypeException;

	/**
	 * Find by name bet type event.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg bet type event
	 * @throws BetTypeEventNotFoundException
	 *             the bet type event not found exception
	 * @throws MultipleBetTypeEventException
	 *             the multiple bet type event exception
	 */
	CfgBetTypeEvent findByNameBetTypeEvent(String name)
			throws BetTypeEventNotFoundException, MultipleBetTypeEventException;

	/**
	 * Find by name competition.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg competition
	 * @throws TournamentNotFoundException
	 *             the tournament not found exception
	 * @throws MultipleTournamentException
	 *             the mutiple tournament exception
	 */
	CfgCompetition findByNameCompetition(String name)
			throws TournamentNotFoundException, MultipleTournamentException;

	/**
	 * Find by name competition event.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg competition event
	 * @throws TournamentEventNotFoundException
	 *             the tournament event not found exception
	 * @throws MultipleTournamentEventException
	 *             the mutiple tournament event exception
	 */
	CfgCompetitionEvent findByNameCompetitionEvent(String name)
			throws TournamentEventNotFoundException,
			MultipleTournamentEventException;

	/**
	 * Find by name sport.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg sport
	 * @throws SportNotFoundException
	 *             the sport not found exception
	 * @throws MultipleSportException
	 *             the mutiple sport exception
	 */
	CfgSport findByNameSport(String name) throws SportNotFoundException,
			MultipleSportException;

	/**
	 * Find by name team.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg team
	 * @throws TeamNotFoundException
	 *             the team not found exception
	 * @throws MultipleTeamException
	 *             the mutiple team exception
	 */
	CfgParticipant findByNameTeam(String name) throws TeamNotFoundException,
			MultipleTeamException;

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
	 *             the competition and sport not equal scope
	 */
	CfgCompetition resolverCompetitionAndSport(XmlMatch xmlMatch)
			throws TournamentNotFoundException, MultipleTournamentException,
			SportNotFoundException, MultipleSportException,
			CompetitionAndSportNotEqualScope;

	/**
	 * Resolver participantes.
	 * 
	 * @param xmlMatchParticipantXml
	 *            the xml match participant xml
	 * @return the cfg team
	 * @throws TeamNotFoundException
	 *             the team not found exception
	 * @throws MultipleTeamException
	 *             the mutiple team exception
	 */
	CfgParticipant resolverParticipantes(XmlMatchParticipant xmlMatchParticipantXml)
			throws TeamNotFoundException, MultipleTeamException;

}
