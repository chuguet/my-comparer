/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.mapreduce.SynonymPerParticipant;
import com.comparadorad.bet.comparer.model.core.repository.exception.ValidationObjectException;

/**
 * The Class CfgParticipantRepositoryCustomImpl.
 */
class CfgParticipantRepositoryCustomImpl extends
		AbstractCfgRepository<CfgParticipant> implements
		CfgParticipantRepositoryCustom<CfgParticipant> {

	private static final String COLLECTION_NAME = "cfgParticipant";
	private static final String COLLECTION_NAME_SYNONYMS = "cfgParticipantSynonyms";

	private static final Log log = LogFactory
			.getLog(CfgParticipantRepositoryCustomImpl.class);

	@Inject
	private CfgParticipantSynonymsRepositoryCustomImpl synonymRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgParticipantRepositoryCustom
	 * #findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgParticipant> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgParticipant> listResult = getMongoTemplate().find(query,
				CfgParticipant.class);
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.repository.CfgParticipantRepositoryCustom
	 * #getParticipantsByCompetition(java.math.BigInteger)
	 */
	public List<CfgParticipant> getParticipantsByCompetition(
			BigInteger competitionId) {
		List<CfgParticipant> result = new ArrayList<CfgParticipant>();

		Query query = new Query(where("cfgCompetition.$id").is(competitionId));

		result = getMongoTemplate().find(query, CfgParticipant.class);

		return result;
	}

	public void cleanDuplicatedParticipantSynonyms() {
		log.info("Se comienza la limpieza de participantes con sinonimos duplicados");
		Boolean modified = false;
		
		Query query = new Query();

		MapReduceOptions options = new MapReduceOptions();
		options.outputTypeInline();

		MapReduceResults<SynonymPerParticipant> resultQuery = getMongoTemplate()
				.mapReduce(query, COLLECTION_NAME,
						"classpath:mapreduce/MapCleanDuplicatedSynonyms.js",
						"classpath:mapreduce/ReduceCleanDuplicatedSynonyms.js",
						options, SynonymPerParticipant.class);

		log.info("elementos encontrados: " + resultQuery.getCounts());

		for (SynonymPerParticipant synonymPerParticipant : resultQuery) {

				log.info("Participante " + synonymPerParticipant.getId());
				BigInteger baseSynonymId = new BigInteger(synonymPerParticipant.getId());
				List<CfgParticipantSynonyms> synonymsList = synonymRepository.customFindById(baseSynonymId);
				CfgParticipantSynonyms synonyms;
								
				
				// Si ninguno de los sinonimos asociados a un participante coincide en Id con este
				// seleccionamos el primero de los sinonimos y modificamos su id
				if (synonymsList.size() == 0){
					baseSynonymId = new BigInteger(synonymPerParticipant.getValue().getSynonymsIdList().get(0).toString());
					synonymsList = synonymRepository.customFindById(baseSynonymId);
					synonyms = synonymsList.get(0);
				}else{
					synonyms = synonymsList.get(0);	
				}

				for (Integer synonymId : synonymPerParticipant.getValue().getSynonymsIdList()) {

					if (!synonymId.toString().equals(synonymPerParticipant.getId())) {
						log.info("Id de sinonimo ha eliminar " + synonymId);
						List<CfgParticipantSynonyms> toCopyList = synonymRepository.customFindById(new BigInteger(synonymId.toString()));
						CfgParticipantSynonyms toCopy = toCopyList.get(0);
						modified = false;

						for (AbstractCfgSynonymWord word : toCopy.getSynonimWords()) {
							if (!synonyms.containsSynonimWord(word.getWord())) {
								log.info("Se añade la palabra " + word.getWord());
								synonyms.addSynonimWord(word);
								modified = true;
							} else if (word.getHistoric() == null || word.getHistoric().getHistoricList().get(0).getUser().equals("HUMAN_VERIFIED")) {
								log.info("Se sustituye la palabra "	+ word.getWord()+ " ya que estaba verificada en sinonimo origen");
								synonyms.getSynonimWords().set(synonyms.getSynonymWordIndex(word.getWord()), word);
								modified = true;
							}
						}

						if (!synonymId.equals(Integer.valueOf(baseSynonymId.toString()))){
							Query removeQuery = new Query(where("_id").is(synonymId.toString()));	
							log.info("Se elimina el sinonimo con id " + synonymId+ " Query --> " + removeQuery+ " || Collection --> " + COLLECTION_NAME_SYNONYMS);
							this.getMongoTemplate().remove(removeQuery,	COLLECTION_NAME_SYNONYMS);
						}

						if (modified) {
							log.info("Se guarda el sinonimo "+ synonymPerParticipant.getId()+ " con la informacion actualizada");
							synonymRepository.save(synonyms);
						}
					}
				}
		}
		log.info("Se finaliza la limpieza de participantes con sinonimos duplicados");
	}

	public void cleanParticipantsWithNoSynonyms() {

			log.info("Se comienza la limpieza de participantes sin sinonimo");
			Query query = new Query();

			MapReduceOptions options = new MapReduceOptions();
			options.outputTypeInline();

			MapReduceResults<SynonymPerParticipant> resultQuery = getMongoTemplate()
					.mapReduce(
							query,
							COLLECTION_NAME,
							"classpath:mapreduce/MapCleanParticipantsWithNoSynonyms.js",
							"classpath:mapreduce/ReduceCleanParticipantsWithNoSynonyms.js",
							options, SynonymPerParticipant.class);

			log.info("elementos encontrados: " + resultQuery.getCounts());

			for (SynonymPerParticipant synonymPerParticipant : resultQuery) {
				Query removeQuery = new Query(where("_id").is(
						synonymPerParticipant.getId()));
				log.info("El participante "
						+ synonymPerParticipant.getId()
						+ " no tiene asociado ningun sinonimo, se elimina de BBDD. Query --> "
						+ removeQuery + " || Collection --> " + COLLECTION_NAME);
				this.getMongoTemplate().remove(removeQuery, COLLECTION_NAME);
			}
			log.info("Se finaliza la limpieza de participantes sin sinonimo");
	}

}
