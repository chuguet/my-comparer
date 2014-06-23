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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;

/**
 * 
 * The Class CfgParticipantSynonymsRepositoryCustomImpl.
 * 
 */
class CfgParticipantSynonymsRepositoryCustomImpl extends
		AbstractCfgSynonymsRepositoryCustomImpl<CfgParticipantSynonyms>
		implements CfgParticipantSynonymsRepositoryCustom {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgParticipantSynonymsRepositoryCustomImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.
	 * CfgParticipantSynonymsRepositoryCustom
	 * #customFindAllParticipants(java.math.BigInteger)
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindAllParticipants(
			BigInteger competitionId) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();
		List<CfgParticipant> participantesPorCompeticion = new ArrayList<CfgParticipant>();

		Query query = new Query(where("cfgCompetition.$id").is(competitionId));

		participantesPorCompeticion = getMongoTemplate().find(query,
				CfgParticipant.class);
		String[] participantIds = new String[participantesPorCompeticion.size()];
		int contadorParticipantes = 0;
		for (CfgParticipant participante : participantesPorCompeticion) {
			participantIds[contadorParticipantes] = participante.getObjectId()
					.toString();
			contadorParticipantes++;
		}

		Query query2 = new Query(where("participant.$id").in(participantIds));

		result = getMongoTemplate().find(query2, CfgParticipantSynonyms.class);

		return result;
	}

	/**
	 * Custom find by name and competition.
	 * 
	 * @param teamName
	 *            the team name
	 * @param competition
	 *            the competition
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindByNameAndCompetition(
			String teamName, CfgCompetition competition) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();
		Query query1 = new Query(where("synonimWords.word").is(teamName));

		Query query2 = new Query(where("cfgCompetition.$id").is(
				getConvertedId(competition)));

		List<CfgParticipantSynonyms> teamSyn = getMongoTemplate().find(query1,
				CfgParticipantSynonyms.class);

		List<CfgParticipant> teams = getMongoTemplate().find(query2,
				CfgParticipant.class);

		for (CfgParticipant cfgParticipant : teams) {
			for (CfgParticipantSynonyms cfgParticipantSyn : teamSyn) {
				if (cfgParticipantSyn.getRelatedDocument().getObjectId()
						.equals(cfgParticipant.getObjectId())) {
					result.add(cfgParticipantSyn);
				}
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.
	 * CfgParticipantSynonymsRepositoryCustom
	 * #customFindByParticipantNameSportAndCompetitionId(java.lang.String,
	 * java.math.BigInteger, java.math.BigInteger)
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindByParticipantNameSportAndCompetitionId(
			String teamName, BigInteger sportId, BigInteger competitionId) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();
		Query query1 = new Query(where("synonimWords.word").is(teamName));
		query1.fields().include("participant");
		Query query2 = new Query(where("cfgCompetition.$id").is(competitionId));
		query2.fields().include("_id");
		List<CfgParticipantSynonyms> teamSyn = getMongoTemplate().find(query1,
				CfgParticipantSynonyms.class);

		List<CfgParticipant> teams = getMongoTemplate().find(query2,
				CfgParticipant.class);

		for (CfgParticipant cfgParticipant : teams) {
			for (CfgParticipantSynonyms cfgParticipantSyn : teamSyn) {
				if (cfgParticipantSyn.getRelatedDocument().getObjectId()
						.equals(cfgParticipant.getObjectId())) {
					result.add(cfgParticipantSyn);
				}
			}
		}

		return result;
	}

	/**
	 * Custom find by name and competition name.
	 * 
	 * @param teamName
	 *            the team name
	 * @param competitionId
	 *            the competition id
	 * @return the list {@inheritDoc}
	 */

	@Override
	public List<CfgParticipantSynonyms> customFindByTeamNameAndCompetitionName(
			String teamName, BigInteger competitionId) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();
		Query query1 = new Query(where("synonimWords.word").is(teamName));

		List<CfgParticipantSynonyms> teamSyn = getMongoTemplate().find(query1,
				CfgParticipantSynonyms.class);

		Query query2 = new Query(where("cfgCompetition.$id").is(competitionId)
				.and("i18n.i18nFields.string").is(teamName));

		List<CfgParticipant> teams = getMongoTemplate().find(query2,
				CfgParticipant.class);

		for (CfgParticipant cfgParticipant : teams) {
			for (CfgParticipantSynonyms cfgParticipantSyn : teamSyn) {
				if (cfgParticipantSyn.getRelatedDocument() != null) {
					if (cfgParticipantSyn.getRelatedDocument().getObjectId()
							.equals(cfgParticipant.getObjectId())) {
						result.add(cfgParticipantSyn);
					}
				}

			}
		}
		return result;
	}

	/**
	 * Custom find by team name and sport name.
	 * 
	 * @param teamName
	 *            the team name
	 * @param sportId
	 *            the sport id
	 * @return the list {@inheritDoc}
	 */

	@Override
	public List<CfgParticipantSynonyms> customFindByTeamNameAndSportName(
			String teamName, BigInteger sportId) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();
		Query query1 = new Query(where("synonimWords.word").is(teamName));

		List<CfgParticipantSynonyms> teamSyn = getMongoTemplate().find(query1,
				CfgParticipantSynonyms.class);

		Query query2 = new Query(where("cfgSport.$id").is(sportId)
				.and("i18n.i18nFields.string").is(teamName));

		List<CfgParticipant> teams = getMongoTemplate().find(query2,
				CfgParticipant.class);

		for (CfgParticipant cfgParticipant : teams) {
			for (CfgParticipantSynonyms cfgParticipantSyn : teamSyn) {
				if (cfgParticipantSyn.getRelatedDocument().getObjectId()
						.equals(cfgParticipant.getObjectId())) {
					result.add(cfgParticipantSyn);
				}
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.ISynonymsRepository#
	 * findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgParticipantSynonyms> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgParticipantSynonyms> listResult = getMongoTemplate().find(
				query, CfgParticipantSynonyms.class);
		return listResult;
	}

	/**
	 * Gets the model class.
	 * 
	 * @return the model class {@inheritDoc}
	 */
	@Override
	protected Class<CfgParticipantSynonyms> getModelClass() {
		return CfgParticipantSynonyms.class;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepositoryCustom#customFindByParticipant(java.math.BigInteger)
	 */
	@Override
	public List<CfgParticipantSynonyms> customFindByParticipant(
			BigInteger participantId) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();

		Query query = new Query(where("participant.$id").is(participantId));

		result = getMongoTemplate().find(query, CfgParticipantSynonyms.class);

		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepositoryCustom#customFindById(java.math.BigInteger)
	 */
	public List<CfgParticipantSynonyms> customFindById(BigInteger synonymId) {
		List<CfgParticipantSynonyms> result = new ArrayList<CfgParticipantSynonyms>();

		Query query = new Query(where("_id").is(synonymId));

		result = getMongoTemplate().find(query, CfgParticipantSynonyms.class);

		return result;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepositoryCustom#deleteParticipantReferer(java.math.BigInteger)
	 */
	@Override
	public void deleteParticipantReferer(BigInteger participantId) {
		Query query = new Query(where("participant.$id").is(participantId));
		getMongoTemplate().remove(query, CfgParticipantSynonyms.class);
	}

}
