/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.synonyms;

import java.math.BigInteger;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.repository.exception.CompetitionNotVerifiedException;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleParticipantException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleRegionException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleSportException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.MultipleTournamentException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.ParticipantNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.RegionNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.SportNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.TournamentNotFoundException;

/**
 * The Interface ISynonymsComponent.
 */
public interface ISynonymsComponent {

	/**
	 * Find by competition name and sport.
	 * 
	 * @param name
	 *            the name
	 * @param sportId
	 *            the sport id
	 * @return the cfg competition
	 * @throws TournamentNotFoundException
	 *             the tournament not found exception
	 * @throws MultipleTournamentException
	 *             the multiple tournament exception
	 * @throws CompetitionNotVerifiedException
	 *             the competition not verified exception
	 */
	CfgCompetition findByCompetitionNameAndSport(String name, BigInteger sportId)
			throws TournamentNotFoundException, MultipleTournamentException,
			CompetitionNotVerifiedException;

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
	 * Find by name participant.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg participant
	 * @throws ParticipantNotFoundException
	 *             the team not found exception
	 * @throws MultipleParticipantException
	 *             the mutiple team exception
	 */
	CfgParticipant findByNameParticipant(String name)
			throws ParticipantNotFoundException, MultipleParticipantException;

	/**
	 * Find by name region.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg region
	 * @throws RegionNotFoundException
	 *             the region not found exception
	 * @throws MultipleRegionException
	 *             the multiple region exception
	 */
	CfgRegion findByNameRegion(String name) throws RegionNotFoundException,
			MultipleRegionException;

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
	 * Find by name sport tournament participant.
	 * 
	 * @param name
	 *            the name
	 * @param sportId
	 *            the sport id
	 * @param competitionId
	 *            the competition id
	 * @return the cfg participant
	 * @throws ParticipantNotFoundException
	 *             the participant not found exception
	 * @throws MultipleParticipantException
	 *             the multiple participant exception
	 */
	CfgParticipant findByNameSportTournamentParticipant(String name,
			BigInteger sportId, BigInteger competitionId)
			throws ParticipantNotFoundException, MultipleParticipantException;

	/**
	 * Resolver participantes.
	 * 
	 * @param xmlMatchParticipantXml
	 *            the xml match participant xml
	 * @return the cfg team
	 * @throws ParticipantNotFoundException
	 *             the team not found exception
	 * @throws MultipleParticipantException
	 *             the mutiple team exception
	 */
	CfgParticipant resolverParticipantes(
			XmlMatchParticipant xmlMatchParticipantXml)
			throws ParticipantNotFoundException, MultipleParticipantException;

}
