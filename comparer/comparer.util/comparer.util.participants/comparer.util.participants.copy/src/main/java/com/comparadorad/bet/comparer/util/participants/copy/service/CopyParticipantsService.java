/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.copy.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.MongoDataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepository;
import com.comparadorad.bet.comparer.util.participants.copy.exception.CompetitionNotFoundException;
import com.comparadorad.bet.comparer.util.participants.copy.exception.DataNotFoundException;
import com.comparadorad.bet.comparer.util.participants.copy.exception.ParticipantCopyException;
import com.comparadorad.bet.comparer.util.participants.copy.exception.ParticipantNotFoundException;
import com.comparadorad.bet.comparer.util.participants.copy.exception.ParticipantSynonymNotFoundException;
import com.comparadorad.bet.comparer.util.participants.copy.util.Utils;

/**
 * Class to Copy Participants between competitions.
 * 
 * Reads participants from a competition, creates duplicates for that
 * participants and theirs synonyms, assigning to all that participants the
 * target competition in a transactional environment.
 * 
 * 
 * @author farce
 * 
 */
@Service
@Transactional
public class CopyParticipantsService implements ICopyParticipantsService {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CopyParticipantsService.class);

	/** The mongo template. */
	@Inject
	private MongoTemplate mongoTemplate;

	/** The cfg competition respository. */
	@Inject
	private CfgCompetitionRepository cfgCompetitionRespository;

	/** The cfg participant respository. */
	@Inject
	private CfgParticipantRepository cfgParticipantRespository;

	/** The cfg participant synonyms repository. */
	@Inject
	private CfgParticipantSynonymsRepository cfgParticipantSynonymsRepository;

	/**
	 * Find all competitions.
	 * 
	 * @return the list {@inheritDoc}
	 */
	public List<CfgCompetition> findAllCompetitions() {
		return cfgCompetitionRespository.findAll();
	}

	/** {@inheritDoc} */
	public CfgCompetition getCompetitionById(String id) {
		CfgCompetition result;

		Query query = new Query(where("_id").is(id));

		result = getMongoTemplate().findOne(query, CfgCompetition.class);

		return result;
	}

	/**
	 * Find competition by name.
	 * 
	 * @param cmpName
	 *            the cmp name
	 * @return the cfg competition {@inheritDoc}
	 */
	public CfgCompetition findCompetitionByName(String cmpName) {

		CfgCompetition result;

		Query query = new Query(where("cfgName").is(cmpName));

		result = getMongoTemplate().findOne(query, CfgCompetition.class);

		return result;
	}

	/**
	 * Find participants by competition id.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param bRejectNotActive
	 *            the b reject not active
	 * @return the list {@inheritDoc}
	 */
	public List<CfgParticipant> findParticipantsByCompetitionId(
			String competitionId, boolean bRejectNotActive) {
		List<CfgParticipant> result = new ArrayList<CfgParticipant>();

		Query query = new Query(where("cfgCompetition.$id").is(competitionId));
		if (bRejectNotActive == true) {
			query.addCriteria(where("coreActiveElement.active").is(true));
		}
		result = getMongoTemplate().find(query, CfgParticipant.class);

		return result;
	}

	/**
	 * Find participant synonyms.
	 * 
	 * @param participants
	 *            the participants
	 * @param bRejectNotActive
	 *            the b reject not active
	 * @return the map {@inheritDoc}
	 */
	public Map<CfgParticipant, List<CfgParticipantSynonyms>> findParticipantSynonyms(
			List<CfgParticipant> participants, boolean bRejectNotActive) {
		Map<CfgParticipant, List<CfgParticipantSynonyms>> result = new HashMap<CfgParticipant, List<CfgParticipantSynonyms>>();

		// Hay que recorrer los participantes, recoger los sinónimos y
		// almacenarlos en el mapa.
		for (CfgParticipant participant : participants) {
			Query query = new Query(where("participant.$id").is(
					participant.getObjectId().toString()));
			if (bRejectNotActive == true) {
				query.addCriteria(where("coreActiveElement.active").is(true));
			}

			List<CfgParticipantSynonyms> synonyms = getMongoTemplate().find(
					query, CfgParticipantSynonyms.class);

			List<CfgParticipantSynonyms> theSynonyms = new ArrayList<CfgParticipantSynonyms>();
			for (CfgParticipantSynonyms syn : synonyms) {
				theSynonyms.add(syn);
			}

			result.put(participant, theSynonyms);
		}

		return result;
	}

	/**
	 * Do copy participants.
	 * 
	 * @param competitionSource
	 *            the competition source
	 * @param competitionTarget
	 *            the competition target
	 * @param participantsSourceSynonyms
	 *            the participants source synonyms
	 * @param participantsTargetSynonyms
	 *            the participants target synonyms
	 * @param outputFilePath
	 *            the output file path
	 * @return true, if successful {@inheritDoc}
	 */
	public boolean doCopyParticipants(
			CfgCompetition competitionSource,
			CfgCompetition competitionTarget,
			Map<CfgParticipant, List<CfgParticipantSynonyms>> participantsSourceSynonyms,
			Map<CfgParticipant, List<CfgParticipantSynonyms>> participantsTargetSynonyms,
			String outputFilePath) {
		// Copiado de partcipants names
		competitionTarget.setParticipantNames(competitionSource
				.getParticipantNames());
		cfgCompetitionRespository.save(competitionTarget);

		// Borrado de participantes y sinónimos, primera parte de la
		// transacción.
		deleteParticipantsSynonimsTarget(participantsTargetSynonyms,
				outputFilePath);

		// Controlar que los nuevos ids entre si no se repiten
		List<BigInteger> newCompetitionIds = new ArrayList<BigInteger>();
		List<BigInteger> newSynonymsIds = new ArrayList<BigInteger>();
		// Reserva de nuevos participantes
		Map<CfgParticipant, CfgParticipantSynonyms> newParticipantsToCreate = new HashMap<CfgParticipant, CfgParticipantSynonyms>();
		// Reserva de sinónimos de nuevos participantes.

		for (CfgParticipant participant : participantsSourceSynonyms.keySet()) {
			List<CfgParticipantSynonyms> listSynonyms = participantsSourceSynonyms
					.get(participant);

			BigInteger newId = null;
			do {
				newId = getNewParticipantId();
			} while (newCompetitionIds.contains(newId));
			newCompetitionIds.add(newId);

			CfgParticipant newParticipant = new CfgParticipant();
			newParticipant.setCfgName(participant.getCfgName());
			newParticipant.setCoreActiveElement(participant
					.getCoreActiveElement());
			newParticipant.setI18n(participant.getI18n());
			newParticipant.setCompetition(competitionTarget);
			newParticipant
					.setCompetitionXmlName(competitionTarget.getCfgName());
			newParticipant.setObjectId(newId);

			BigInteger newSynId = null;
			do {
				newSynId = getNewParticipantSynonymId();
			} while (newSynonymsIds.contains(newSynId));
			newSynonymsIds.add(newSynId);
			CfgParticipantSynonyms participantSynonym = mergeSynonyms(
					newParticipant, listSynonyms, newSynId);
			newParticipantsToCreate.put(newParticipant, participantSynonym);
		}

		for (CfgParticipant participant : newParticipantsToCreate.keySet()) {
			cfgParticipantRespository.save(participant);
			cfgParticipantSynonymsRepository.save(newParticipantsToCreate
					.get(participant));
		}
		return true;
	}

	/**
	 * Merge synonyms.
	 * 
	 * @param participant
	 *            the participant
	 * @param listSynonyms
	 *            the list synonyms
	 * @param newSynId
	 *            the new syn id
	 * @return the cfg participant synonyms
	 */
	private CfgParticipantSynonyms mergeSynonyms(CfgParticipant participant,
			List<CfgParticipantSynonyms> listSynonyms, BigInteger newSynId) {
		CfgParticipantSynonyms result = new CfgParticipantSynonyms();
		result.setCompetitionXmlName(participant.getCompetition().getCfgName());
		result.setCoreActiveElement(listSynonyms.get(0).getCoreActiveElement());
		result.setParticipant(participant);
		result.setSportXmlName(listSynonyms.get(0).getSportXmlName());
		result.setSynonimWords(new ArrayList<AbstractCfgSynonymWord>());
		result.setObjectId(newSynId);
		for (CfgParticipantSynonyms participantSynonym : listSynonyms) {
			for (AbstractCfgSynonymWord synonym : participantSynonym
					.getSynonimWords()) {
				if (!result.getSynonimWords().contains(synonym)) {
					result.getSynonimWords().add(synonym);
				}
				if (result.getHistoric() == null
						&& synonym.getHistoric() != null) {
					result.setHistoric(synonym.getHistoric());
				}
			}
		}
		return result;
	}

	/**
	 * Deletes the participants an theirs synonyms.
	 * 
	 * @param participantsTargetSynonyms
	 *            the participants target synonyms
	 * @param outputFilePath
	 *            the output file path
	 */
	private void deleteParticipantsSynonimsTarget(
			Map<CfgParticipant, List<CfgParticipantSynonyms>> participantsTargetSynonyms,
			String outputFilePath) {
		if (participantsTargetSynonyms == null) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		Iterator<CfgParticipant> itePS = participantsTargetSynonyms.keySet()
				.iterator();
		while (itePS.hasNext()) {
			CfgParticipant pp = itePS.next();
			List<CfgParticipantSynonyms> lsyms = participantsTargetSynonyms
					.get(pp);
			sb.append("Borrado Participante: " + pp.getCfgName());
			sb.append(" - [id: " + pp.getObjectId().toString() + "]\n");
			// Borrado de participantes
			cfgParticipantRespository.delete(pp);
			// Borrado de sinónimos
			if (lsyms != null && lsyms.size() > 0) {
				for (int i = 0; i < lsyms.size(); ++i) {
					sb.append("\nBorrado Sinónimo - id: "
							+ lsyms.get(i).getObjectId().toString() + "]");
					List<AbstractCfgSynonymWord> acsw = lsyms.get(i)
							.getSynonimWords();
					if (acsw != null && acsw.size() > 0) {
						for (AbstractCfgSynonymWord symonym : acsw) {
							sb.append("\nWord: " + symonym.getWord() + "\n");
						}
					}
					cfgParticipantSynonymsRepository.delete(lsyms.get(i));
				}
			}
		}

		Utils.writeToFile(outputFilePath, sb.toString());
	}

	/**
	 * Gets the mongo template.
	 * 
	 * @return the mongo template
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * Obtains ids.
	 * 
	 * @return the new participant id
	 */
	private BigInteger getNewParticipantId() {
		BigInteger newObjectId = null;
		boolean isNew = false;
		while (!isNew) {
			newObjectId = getRandom();

			Object result = cfgParticipantRespository.findOne(newObjectId);
			if (result == null) {
				isNew = true;
			}
		}
		return newObjectId;
	}

	/**
	 * Obtains ids.
	 * 
	 * @return the new participant synonym id
	 */
	private BigInteger getNewParticipantSynonymId() {
		BigInteger newObjectId = null;
		boolean isNew = false;
		while (!isNew) {
			newObjectId = getRandom();

			Object result = cfgParticipantSynonymsRepository
					.findOne(newObjectId);
			if (result == null) {
				isNew = true;
			}
		}
		return newObjectId;
	}

	/**
	 * Returns a random id.
	 * 
	 * @return the random
	 */
	public static BigInteger getRandom() {
		Random prng = new SecureRandom(); // self-seeding
		BigInteger result = BigInteger.probablePrime(30, prng);
		return result;
	}

	/**
	 * Trace list.
	 * 
	 * @param toTrace
	 *            the to trace
	 */
	@SuppressWarnings("unused")
	private void traceList(List<?> toTrace) {
		if (toTrace == null) {
			return;
		}

		// for(int i=0;i<toTrace.size();++i) {
		// LOG.info(toTrace.get(i));
		// }
	}

	/** {@inheritDoc} */
	public void copyParticiantToCompetition(List<String> participantIds,
			String competitionId) throws ParticipantCopyException {
		CfgCompetition competition;
		try {
			competition = findCompetition(competitionId);
			LOG.info(new StringBuffer("Se recupera la competicion destino: ")
					.append(competitionId).toString());
		} catch (DataNotFoundException e) {
			throw new ParticipantCopyException(
					"No se han encontrado los datos en BD", e);
		}
		for (String id : participantIds) {
			copyParticiantToCompetition(id, competition);
		}
	}

	/**
	 * Copy particiant to competition.
	 * 
	 * @param participantId
	 *            the participant id
	 * @param competition
	 *            the competition
	 * @throws ParticipantCopyException
	 *             the participant copy exception
	 */
	private void copyParticiantToCompetition(String participantId,
			CfgCompetition competition) throws ParticipantCopyException {
		CfgParticipant participant;
		CfgParticipantSynonyms participantSynonym;
		CfgParticipant participantDestiny;
		CfgParticipantSynonyms participantSynonymDestiny;

		try {
			participant = findParticipant(new BigInteger(participantId));
			LOG.info(new StringBuffer("Se recupera el participante de origen: ")
					.append(participantId));
			participantSynonym = findParticipantSynonymByParticipantId(new BigInteger(
					participantId));
			LOG.info("Se recupera el sinonimo de participante de origen");
		} catch (DataNotFoundException e) {
			throw new ParticipantCopyException(
					"No se han encontrado los datos en BD", e);
		}

		LOG.info("Se mapea el participante origen al destino");
		participantDestiny = copyParticipant(participant, competition);
		try {
			cfgParticipantRespository.save(participantDestiny);
		} catch (MongoDataIntegrityViolationException e) {
			throw new ParticipantCopyException(
					"El participante no se ha guardado en BD", e);
		}
		LOG.info("Mapeado y persistido la copia del participante");

		LOG.info("Se mapea el sinonimo de participante origen al destino");
		participantSynonymDestiny = copyParticipantSynonym(participantSynonym,
				participantDestiny, competition);
		try {
			cfgParticipantSynonymsRepository.save(participantSynonymDestiny);
		} catch (MongoDataIntegrityViolationException e) {
			LOG.error("El participantSynonym no se ha guardado en BD. Se borra el participante dado de alta anteriormente.");
			cfgParticipantRespository.delete(participantDestiny);
			throw new ParticipantCopyException(
					"El participantSynonym no se ha guardado en BD", e);
		}
		LOG.info("Mapeado y persistido la copia del sinonimo de participante");

	}

	/**
	 * Find participant.
	 * 
	 * @param participantId
	 *            the participant id
	 * @return the cfg participant
	 * @throws ParticipantNotFoundException
	 *             the participant not found exception
	 */
	private CfgParticipant findParticipant(BigInteger participantId)
			throws ParticipantNotFoundException {
		CfgParticipant participant;
		participant = cfgParticipantRespository.findOne(participantId);
		if (participant == null) {
			throw new ParticipantNotFoundException(
					"No se ha encontrado el participante");
		} else {
			return participant;
		}
	}

	/**
	 * Find participant synonym by participant id.
	 * 
	 * @param participantId
	 *            the participant id
	 * @return the cfg participant synonyms
	 * @throws ParticipantSynonymNotFoundException
	 *             the participant synonym not found exception
	 */
	private CfgParticipantSynonyms findParticipantSynonymByParticipantId(
			BigInteger participantId)
			throws ParticipantSynonymNotFoundException {
		List<CfgParticipantSynonyms> participantSynonymList;
		participantSynonymList = cfgParticipantSynonymsRepository
				.customFindByParticipant(participantId);
		if (participantSynonymList == null
				|| participantSynonymList.size() != 1) {
			throw new ParticipantSynonymNotFoundException(
					"No se ha encontrado el sinonimo del participante");
		} else {
			return participantSynonymList.get(0);
		}
	}

	/**
	 * Find competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the cfg competition
	 * @throws CompetitionNotFoundException
	 *             the competition not found exception
	 */
	private CfgCompetition findCompetition(String competitionId)
			throws CompetitionNotFoundException {
		CfgCompetition competition;
		competition = cfgCompetitionRespository.findOne(new BigInteger(
				competitionId));
		if (competition == null) {
			throw new CompetitionNotFoundException(
					"No se ha encontrado la competicion");
		} else {
			return competition;
		}
	}

	/**
	 * Copy participant.
	 * 
	 * @param participant
	 *            the participant
	 * @param competition
	 *            the competition
	 * @return the cfg participant
	 */
	private CfgParticipant copyParticipant(CfgParticipant participant,
			CfgCompetition competition) {
		CfgParticipant participantCopy = new CfgParticipant();
		participantCopy.setObjectId(getNewParticipantId());
		participantCopy.setCfgName(participant.getCfgName());
		participantCopy.setCompetition(competition);
		participantCopy.setCompetitionXmlName(competition.getCfgName());
		participantCopy.setName(participant.getName(null));
		participantCopy.setI18n(participant.getI18n());
		return participantCopy;
	}

	/**
	 * Copy participant synonym.
	 * 
	 * @param participantSynonym
	 *            the participant synonym
	 * @param participant
	 *            the participant
	 * @param competition
	 *            the competition
	 * @return the cfg participant synonyms
	 */
	private CfgParticipantSynonyms copyParticipantSynonym(
			CfgParticipantSynonyms participantSynonym,
			CfgParticipant participant, CfgCompetition competition) {
		CfgParticipantSynonyms participantSynonymCopy = new CfgParticipantSynonyms();
		participantSynonymCopy.setObjectId(getNewParticipantSynonymId());
		participantSynonymCopy.setCompetitionXmlName(competition.getCfgName());
		participantSynonymCopy.setSportXmlName(competition.getSport()
				.getCfgName());
		participantSynonymCopy.setSynonimWords(participantSynonym
				.getSynonimWords());
		participantSynonymCopy.setCoreActiveElement(participantSynonym
				.getCoreActiveElement());
		participantSynonymCopy.setHistoricCreationData("APP_VERIFIED");
		participantSynonymCopy.setParticipant(participant);
		return participantSynonymCopy;
	}

}
