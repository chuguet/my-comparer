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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepository;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class CfgParticipantSynonymsService.
 */
@Service
class CfgParticipantSynonymsService extends
		AbstractSynonymsCrudService<CfgParticipantSynonyms> implements
		ICfgParticipantSynonymsService {

	/** The cfg competition service. */
	@Inject
	private CfgCompetitionService cfgCompetitionService;

	/** The cfg participant repository. */
	@Inject
	private CfgParticipantRepository cfgParticipantRepository;

	/** The synonyms word repository. */
	@Inject
	private CfgParticipantSynonymsRepository cfgParticipantSynonymsRepository;

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.
	 * ICfgParticipantSynonymsService
	 * #cleanDuplicateSynonymsWordsOnlyOneParticipant()
	 */
	public void cleanDuplicateSynonymsWordsOnlyOneParticipant() {
		LOG.info(Thread.currentThread(),
				"Se comienza el borrado de los sinonimos duplicados en un solo participante");
		Integer sizeOld;
		Integer sizeNew;
		List<CfgParticipantSynonyms> participantsSynonyms;
		Set<AbstractCfgSynonymWord> set;
		Long total = cfgParticipantSynonymsRepository.count();
		Integer limit = 10;
		for (Integer skip = 0; skip < Integer.valueOf(total.toString()) + limit; skip += limit) {
			participantsSynonyms = cfgParticipantSynonymsRepository
					.findAllLimit(limit, skip);
			for (CfgParticipantSynonyms participantsSynonym : participantsSynonyms) {
				sizeOld = participantsSynonym.getSynonimWords().size();
				set = new HashSet<AbstractCfgSynonymWord>();
				set.addAll(participantsSynonym.getSynonimWords());
				participantsSynonym.getSynonimWords().clear();
				participantsSynonym.getSynonimWords().addAll(set);
				sizeNew = participantsSynonym.getSynonimWords().size();
				if (!sizeOld.equals(sizeNew)) {
					cfgParticipantSynonymsRepository.save(participantsSynonym);
				}
			}
		}
		LOG.info(Thread.currentThread(),
				"Se finaliza el borrado de los sinonimos duplicados en un solo participante");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.
	 * ICfgParticipantSynonymsService
	 * #cleanDuplicateSynonymsWordsSomeParticipants()
	 */
	@Override
	public void cleanDuplicateSynonymsWordsSomeParticipants() {
		LOG.info(Thread.currentThread(),
				"Se comienza el borrado de los sinonimos duplicados en varios participantes");
		CfgParticipantSynonyms participantSynonymResult;
		List<CfgCompetition> competitions;
		List<CfgParticipantSynonyms> participantsSynonyms;
		Long total = cfgCompetitionService.count();
		Integer limit = 10;
		// Recuperamos las competiciones de 10 en 10 para evitar java heap space
		for (Integer skip = 0; skip < Integer.valueOf(total.toString()) + limit; skip += limit) {
			competitions = cfgCompetitionService.findAllLimit(limit, skip);
			// Recorremos las competiciones y recuperamos los sinonimos de
			// participantes asociados
			for (CfgCompetition competition : competitions) {
				participantsSynonyms = cfgParticipantSynonymsRepository
						.customFindAllParticipants(competition.getObjectId());
				// Recorremos los sinonimos de participantes asociados
				for (CfgParticipantSynonyms participantSynonym : participantsSynonyms) {
					// Recorremos las words de los sinonimos y comprobamos que
					// no se repiten en todos los demas
					for (AbstractCfgSynonymWord synonymWord : participantSynonym
							.getSynonimWords()) {
						if (countSynonymWords(participantsSynonyms, synonymWord) > 1) {
							for (CfgParticipantSynonyms participantSynonymIt : participantsSynonyms) {
								if (participantSynonymIt.getSynonimWords()
										.contains(synonymWord)) {
									participantSynonymResult = new CfgParticipantSynonyms(
											participantSynonymIt);
									participantSynonymResult
											.removeSynonymWord(synonymWord);
									cfgParticipantSynonymsRepository
											.save(participantSynonymResult);
								}
							}
						}
					}
				}
			}
		}
		LOG.info(Thread.currentThread(),
				"Se finaliza el borrado de los sinonimos duplicados en varios participantes");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.
	 * ICfgParticipantSynonymsService
	 * #cleanParticipantsSynonymsWithoutParticipants()
	 */
	@Override
	public void cleanParticipantsSynonymsWithoutParticipants() {
		LOG.info(Thread.currentThread(),
				"Se comienza la limpieza de sinonimos de participantes sin participante");
		Integer counter = 0;
		List<CfgParticipantSynonyms> participantsSynonyms = cfgParticipantSynonymsRepository
				.findAll();
		for (CfgParticipantSynonyms participantSynonyms : participantsSynonyms) {
			if (participantSynonyms.getParticipant() == null) {
				cfgParticipantSynonymsRepository.delete(participantSynonyms
						.getObjectId());
				counter++;
			}
		}
		LOG.info(
				Thread.currentThread(),
				new StringBuffer(
						"Se finaliza la limpieza de sinonimos de participantes sin participante. Se han borrado: ")
						.append(counter).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.
	 * ICfgParticipantSynonymsService
	 * #cleanSynonymWordsFromBookmaker(java.lang.String)
	 */
	@Override
	public void cleanSynonymWordsFromBookmaker(String idBookmaker) {
		List<AbstractCfgSynonymWord> synonymsWords;
		LOG.info(Thread.currentThread(),
				"Se comienza la limpieza de synonymsWords por bookamker");
		List<CfgParticipantSynonyms> participantsSynonyms = cfgParticipantSynonymsRepository
				.findAll();
		for (CfgParticipantSynonyms participantSynonym : participantsSynonyms) {
			synonymsWords = new ArrayList<AbstractCfgSynonymWord>();
			for (AbstractCfgSynonymWord synonymWord : participantSynonym
					.getSynonimWords()) {
				if (synonymWord != null
						&& synonymWord.getSynonymBookmaker() != null
						&& synonymWord.getSynonymBookmaker().getObjectId() != null
						&& !synonymWord.getSynonymBookmaker().getObjectId()
								.toString().equals(idBookmaker)) {
					synonymsWords.add(synonymWord);
				}
			}
			if (synonymsWords.size() == 0
					&& participantSynonym.getSynonimWords().size() == 1) {
				cfgParticipantRepository.delete(participantSynonym
						.getParticipant().getObjectId());
				cfgParticipantSynonymsRepository.delete(participantSynonym
						.getObjectId());
			} else {
				participantSynonym.setSynonimWords(synonymsWords);
				cfgParticipantSynonymsRepository.save(participantSynonym);
			}
		}
		LOG.info(Thread.currentThread(),
				"Se finaliza la limpieza de synonymsWords por bookamker");
	}

	/**
	 * Count synonym words.
	 * 
	 * @param participantsSynonymsResult
	 *            the participants synonyms result
	 * @param synonymWord
	 *            the synonym word
	 * @return the integer
	 */
	private Integer countSynonymWords(
			List<CfgParticipantSynonyms> participantsSynonymsResult,
			AbstractCfgSynonymWord synonymWord) {
		Integer result = 0;
		for (CfgParticipantSynonyms participantSynonyms : participantsSynonymsResult) {
			result += participantSynonyms.count(synonymWord);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.ISynonymsService#
	 * customFindAllParticipant(java.math.BigInteger)
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindAllParticipant(
			BigInteger competitionId) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();
		result = cfgParticipantSynonymsRepository
				.customFindAllParticipants(competitionId);
		// .customFindByParticipantNameSportAndCompetitionId(
		// participantName, sportId, competitionId);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.ISynonymsService#
	 * customFindAllTournament(java.lang.String, java.math.BigInteger)
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindAllTournament(String string,
			BigInteger bigInteger) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Custom find by key words and competition id.
	 * 
	 * @param pKeywords
	 *            the keywords
	 * @param pCompetitionOjectId
	 *            the competition oject id
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindByKeyWordsAndCompetitionId(
			String[] pKeywords, BigInteger pCompetitionOjectId) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();
		List<CfgParticipantSynonyms> dbresult = cfgParticipantSynonymsRepository
				.customFindByKeyWords(pKeywords);
		for (CfgParticipantSynonyms cfgParticipantSynonyms : dbresult) {
			if (cfgParticipantSynonyms.getParticipant().getCompetition() != null
					&& cfgParticipantSynonyms.getParticipant().getCompetition()
							.getObjectId().equals(pCompetitionOjectId)) {
				result.add(cfgParticipantSynonyms);
			}
		}
		return result;
	}

	/**
	 * Custom find byname.
	 * 
	 * @param name
	 *            the name
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindByname(String name) {

		return cfgParticipantSynonymsRepository.customFindByname(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.
	 * ICfgParticipantSynonymsService
	 * #customFindByParticipant(java.math.BigInteger)
	 */
	public List<CfgParticipantSynonyms> customFindByParticipant(
			final BigInteger participantId) {

		return cfgParticipantSynonymsRepository
				.customFindByParticipant(participantId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.
	 * ICfgParticipantSynonymsService
	 * #customFindByParticipantNameSportAndCompetitionId(java.lang.String,
	 * java.math.BigInteger, java.math.BigInteger)
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindByParticipantNameSportAndCompetitionId(
			String teamName, BigInteger sportId, BigInteger competitionId) {
		List<CfgParticipantSynonyms> listaSinonimos = new ArrayList<CfgParticipantSynonyms>();
		listaSinonimos = cfgParticipantSynonymsRepository
				.customFindByParticipantNameSportAndCompetitionId(teamName,
						sportId, competitionId);
		return listaSinonimos;
	}

	/**
	 * Custom find by name competition name.
	 * 
	 * @param pTeamName
	 *            the team name
	 * @param pCompetitionId
	 *            the competition id
	 * @return the list {@inheritDoc}
	 */

	@Override
	public List<CfgParticipantSynonyms> customFindByTeamNameCompetitionName(
			String pTeamName, BigInteger pCompetitionId) {
		return cfgParticipantSynonymsRepository
				.customFindByTeamNameAndCompetitionName(pTeamName,
						pCompetitionId);
	}

	/**
	 * Custom find by team name sport name.
	 * 
	 * @param pTeamName
	 *            the team name
	 * @param pSportId
	 *            the sport id
	 * @return the list {@inheritDoc}
	 */

	@Override
	public List<CfgParticipantSynonyms> customFindByTeamNameSportName(
			String pTeamName, BigInteger pSportId) {
		return cfgParticipantSynonymsRepository
				.customFindByTeamNameAndSportName(pTeamName, pSportId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.config.service.
	 * ICfgParticipantSynonymsService
	 * #deleteParticipantReferer(java.math.BigInteger)
	 */
	@Override
	public void deleteParticipantReferer(BigInteger participantId) {
		cfgParticipantSynonymsRepository
				.deleteParticipantReferer(participantId);
	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgParticipantSynonyms> getCrudRepository() {
		return cfgParticipantSynonymsRepository;
	}
}
