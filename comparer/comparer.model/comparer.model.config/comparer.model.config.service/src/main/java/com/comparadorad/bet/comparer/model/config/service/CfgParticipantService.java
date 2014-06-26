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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.service.beans.ParticipantsSynonymsMerge;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class CfgParticipantService.
 */
@Service
class CfgParticipantService extends AbstractGenericCrudService<CfgParticipant>
		implements ICfgParticipantService {

	/** The team repository. */
	@Inject
	private CfgParticipantRepository cfgParticipantRepository;

	@Inject
	private ICfgParticipantSynonymsService cfgParticipantSynonymsService;

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgParticipantService
	 * #cleanDuplicatedParticipantSynonyms()
	 */
	public void cleanDuplicatedParticipantSynonyms() {
//		cfgParticipantRepository.cleanDuplicatedParticipantSynonyms();
		ParticipantsSynonymsMerge participantsSynonymsMerge;
		List<CfgParticipantSynonyms> participantsSynonyms;
		List<CfgParticipant> participants = cfgParticipantRepository.findAll();
		for(CfgParticipant participant : participants){
			participantsSynonyms = cfgParticipantSynonymsService.customFindByParticipant(participant.getObjectId());
			if(participantsSynonyms.size()>1){
				participantsSynonymsMerge = merge(participantsSynonyms);
				cfgParticipantSynonymsService.save(participantsSynonymsMerge.getParticipantSynonymMaster());
				cfgParticipantSynonymsService.delete(participantsSynonymsMerge.getParticipantsSynonymsOld());
			}
		}
	}

	private ParticipantsSynonymsMerge merge(
			List<CfgParticipantSynonyms> participantsSynonyms) {
		List<CfgParticipantSynonyms> participantsSynonymsOld = new ArrayList<CfgParticipantSynonyms>();
		ParticipantsSynonymsMerge result = new ParticipantsSynonymsMerge();
		result.setParticipantSynonymMaster(participantsSynonyms.get(0));
		Set<AbstractCfgSynonymWord> synonymsWords = new HashSet<AbstractCfgSynonymWord>();
		synonymsWords.addAll(result.getParticipantSynonymMaster().getSynonimWords());
		for(int i = 1;i<participantsSynonyms.size();i++){
			synonymsWords.addAll(participantsSynonyms.get(i).getSynonimWords());
			participantsSynonymsOld.add(participantsSynonyms.get(i));
		}
		result.setParticipantsSynonymsOld(participantsSynonymsOld);
		result.getParticipantSynonymMaster().getSynonimWords().clear();
		result.getParticipantSynonymMaster().getSynonimWords().addAll(synonymsWords);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgParticipantService
	 * #cleanParticipantsWithNoSynonyms()
	 */
	public void cleanParticipantsWithNoSynonyms() {
		//cfgParticipantRepository.cleanParticipantsWithNoSynonyms();
		List<CfgParticipant> participants = cfgParticipantRepository.findAll();
		for(CfgParticipant participant : participants){
			if(cfgParticipantSynonymsService.customFindByParticipant(participant.getObjectId()).isEmpty()){
				cfgParticipantRepository.delete(participant.getObjectId());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgParticipantService
	 * #cleanParticipantsWithoutCompetition()
	 */
	@Override
	public void cleanParticipantsWithoutCompetition() {
		LOG.info(Thread.currentThread(),
				"Se comienza la limpieza de participantes sin competicion");
		Integer counter = 0;
		List<CfgParticipant> participants = cfgParticipantRepository.findAll();
		for (CfgParticipant participant : participants) {
			if (participant.getCompetition() == null) {
				cfgParticipantRepository.delete(participant.getObjectId());
				counter++;
			}
		}
		LOG.info(
				Thread.currentThread(),
				new StringBuffer(
						"Se finaliza la limpieza de participantes sin competicion. Se han borrado: ")
						.append(counter).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgParticipantService
	 * #findBySynonyms(java.lang.String)
	 */
	@Override
	public List<CfgParticipant> findBySynonyms(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	protected IGenericRepository<CfgParticipant> getCrudRepository() {
		return cfgParticipantRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.config.service.ICfgParticipantService
	 * #getParticipantsByCompetition(java.math.BigInteger)
	 */
	@Override
	public List<CfgParticipant> getParticipantsByCompetition(
			BigInteger competitionId) {
		return cfgParticipantRepository
				.getParticipantsByCompetition(competitionId);
	}

}
