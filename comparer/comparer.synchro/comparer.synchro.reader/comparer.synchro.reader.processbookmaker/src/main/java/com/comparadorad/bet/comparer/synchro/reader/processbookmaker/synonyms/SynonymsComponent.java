/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.synonyms;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.config.service.ICfgBetTypeEventSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionEventSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgParticipantSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgRegionSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ICfgSportSynonymsService;
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
 * The Class SynonymsComponent.
 */
@Component
class SynonymsComponent implements ISynonymsComponent {

	/** The cfg bet type event synonyms service. */
	@Inject
	private ICfgBetTypeEventSynonymsService cfgBetTypeEventSynonymsService;

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

	@Inject
	private ICfgRegionSynonymsService cfgRegionSynonymsService;

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
	public CfgCompetition findByNameCompetition(final String name)
			throws TournamentNotFoundException, MultipleTournamentException {
		CfgCompetition result = null;
		List<CfgCompetitionSynonyms> lstCfgCompetitionSynonyms = competitionSynonymsService
				.customFindByname(name);
		if (lstCfgCompetitionSynonyms.size() == 1) {
			result = lstCfgCompetitionSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgCompetitionSynonyms.size() == 0) {
			throw new TournamentNotFoundException(new StringBuffer()
					.append("Not found the competition: ").append(name)
					.toString());
		} else if (lstCfgCompetitionSynonyms.size() > 1) {
			throw new MultipleTournamentException(new StringBuffer()
					.append("Multiple Sport tournament:  ").append(name)
					.toString());

		}
		return result;
	}

	@Override
	@Cacheable(value = { "findByNameCompetition" })
	public CfgCompetition findByCompetitionNameAndSport(final String name,
			final BigInteger sportId) throws TournamentNotFoundException,
			MultipleTournamentException, CompetitionNotVerifiedException {
		CfgCompetition competitionSynonyms = competitionSynonymsService
				.findByCompetitionNameAndSport(name, sportId);
		if (competitionSynonyms == null) {
			throw new TournamentNotFoundException(new StringBuffer()
					.append("Not found the competition: ").append(name)
					.toString());
		}

		return competitionSynonyms;
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
	@Cacheable(value = { "findByNameSport" })
	public CfgSport findByNameSport(final String name)
			throws SportNotFoundException, MultipleSportException {
		CfgSport result = null;
		List<CfgSportSynonyms> lstCfgSportSynonyms = cfgSportSynonymsService
				.customFindByname(name);
		if (lstCfgSportSynonyms.size() == 1) {
			result = lstCfgSportSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgSportSynonyms.size() == 0) {

			throw new SportNotFoundException(new StringBuffer()
					.append("Not found the sport: ").append(name).toString());
		} else if (lstCfgSportSynonyms.size() > 1) {
			throw new MultipleSportException(new StringBuffer()
					.append("Multiple Sport found: ").append(name).toString());
		}
		return result;
	}

	/**
	 * Find by name team.
	 * 
	 * @param name
	 *            the name
	 * @return the cfg team
	 * @throws ParticipantNotFoundException
	 *             the team not found exception
	 * @throws MultipleParticipantException
	 *             the mutiple team exception {@inheritDoc}
	 */
	public CfgParticipant findByNameParticipant(final String name)
			throws ParticipantNotFoundException, MultipleParticipantException {
		CfgParticipant result = null;
		List<CfgParticipantSynonyms> lstCfgTeamSynonyms = cfgParticipantSynonymsService
				.customFindByname(name);
		if (lstCfgTeamSynonyms.size() == 1) {
			result = lstCfgTeamSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgTeamSynonyms.size() == 0) {
			throw new ParticipantNotFoundException(
					"Not found the participant: " + name);
		} else if (lstCfgTeamSynonyms.size() > 1) {
			throw new MultipleParticipantException(
					"Multiple Sport participant: " + name);
		}
		return result;
	}

	@Override
	public CfgParticipant findByNameSportTournamentParticipant(
			final String name, final BigInteger sportId,
			final BigInteger competitionId)
			throws ParticipantNotFoundException, MultipleParticipantException {
		CfgParticipant result = null;
		List<CfgParticipantSynonyms> lstCfgTeamSynonyms = cfgParticipantSynonymsService
				.customFindByParticipantNameSportAndCompetitionId(name,
						sportId, competitionId);
		if (lstCfgTeamSynonyms.size() == 1) {
			result = lstCfgTeamSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgTeamSynonyms.size() == 0) {
			throw new ParticipantNotFoundException(
					"Not found the participant: " + name);
		} else if (lstCfgTeamSynonyms.size() > 1) {
			throw new MultipleParticipantException(
					"Multiple Sport participant: " + name);
		}
		return result;
	}

	/**
	 * Resolver participantes.
	 * 
	 * @param xmlMatchParticipant
	 *            the xml match participant
	 * @return the cfg participant
	 * @throws ParticipantNotFoundException
	 *             the team not found exception
	 * @throws MultipleParticipantException
	 *             the mutiple participant exception {@inheritDoc}
	 */
	@Cacheable(value = { "findByNameParticipant" }, key = "#xmlMatchParticipant.getName()"
			+ "+#xmlMatchParticipant.getXmlTournament().getXmlSport().getCfgObjectId()"
			+ "+#xmlMatchParticipant.getXmlTournament().getCfgObjectId()")
	public CfgParticipant resolverParticipantes(
			final XmlMatchParticipant xmlMatchParticipant)
			throws ParticipantNotFoundException, MultipleParticipantException {
		CfgParticipant cfgParticipant = new CfgParticipant();

		List<CfgParticipantSynonyms> lstCfgTeamSynonyms;
		String teamName = xmlMatchParticipant.getName().trim();
		BigInteger sportId = xmlMatchParticipant.getXmlTournament()
				.getXmlSport().getCfgObjectId();
		BigInteger competitionId = xmlMatchParticipant.getXmlTournament()
				.getCfgObjectId();

		cfgParticipant = findByNameSportTournamentParticipant(teamName,
				sportId, competitionId);

		return cfgParticipant;
	}

	@Override
	public CfgRegion findByNameRegion(final String name)
			throws RegionNotFoundException, MultipleRegionException {
		CfgRegion result = null;
		List<CfgRegionSynonyms> lstCfgRegionSynonyms = cfgRegionSynonymsService
				.customFindByname(name);
		if (lstCfgRegionSynonyms.size() == 1) {
			result = lstCfgRegionSynonyms.get(0).getRelatedDocument();
		} else if (lstCfgRegionSynonyms.size() == 0) {
			throw new RegionNotFoundException("Not found the region: " + name);
		} else if (lstCfgRegionSynonyms.size() > 1) {
			throw new MultipleRegionException("Multiple Sport region: " + name);
		}
		return result;
	}

}
