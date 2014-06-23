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
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgHistoricUser;
import com.comparadorad.bet.comparer.model.core.bean.IHistoricChange;
import com.comparadorad.bet.comparer.model.repository.exception.CompetitionNotVerifiedException;

/**
 * The Class CfgCompetitionSynonymsRepositoryCustomImpl.
 */
class CfgCompetitionSynonymsRepositoryCustomImpl extends
		AbstractCfgSynonymsRepositoryCustomImpl<CfgCompetitionSynonyms>
		implements CfgCompetitionSynonymsRepositoryCustom {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgCompetitionSynonymsRepositoryCustomImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.
	 * CfgCompetitionSynonymsRepositoryCustom
	 * #customFindAllTournament(java.lang.String, java.math.BigInteger)
	 */
	@Override
	public List<CfgCompetitionSynonyms> customFindAllTournament(
			String tournamentName, BigInteger sportId) {
		List<CfgCompetitionSynonyms> competititonList = null;
		Query query1 = new Query(where("sport.$id").is(sportId));
		query1.fields().include("sport");

		List<CfgCompetition> competicionesPorDeporte = getMongoTemplate().find(
				query1, CfgCompetition.class);
		String[] competitionIds = new String[competicionesPorDeporte.size()];
		int contadorCompeticion = 0;
		for (CfgCompetition competition : competicionesPorDeporte) {
			competitionIds[contadorCompeticion] = competition.getObjectId()
					.toString();
			contadorCompeticion++;
		}

		Query query2 = new Query(where("competition.$id").in((Object[])competitionIds));

		competititonList = getMongoTemplate().find(query2,
				CfgCompetitionSynonyms.class);

		return competititonList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.ISynonymsRepository#
	 * findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<CfgCompetitionSynonyms> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<CfgCompetitionSynonyms> listResult = getMongoTemplate().find(
				query, CfgCompetitionSynonyms.class);
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.repository.
	 * CfgCompetitionSynonymsRepositoryCustom
	 * #findByCompetitionNameAndSport(java.lang.String, java.math.BigInteger)
	 */
	@Override
	public CfgCompetition findByCompetitionNameAndSport(final String name,
			final BigInteger sportId) throws CompetitionNotVerifiedException {
		List<CfgCompetitionSynonyms> competitionList = null;
		CfgCompetition result = null;
		//Query query1 = new Query(where("synonimWords.word").is(name));
		Query query1 = new Query(where("synonimWords").elemMatch(where("word").is(name)));		
		query1.fields().include("_id");
		query1.fields().include("synonimWords");
		query1.fields().include("competition");
		
		competitionList = getMongoTemplate().find(query1,
				CfgCompetitionSynonyms.class);

		// Verifico que la competicion que me ha llegado este verificada
		for (CfgCompetitionSynonyms competitionSynonim : competitionList) {
			for (AbstractCfgSynonymWord word : competitionSynonim
					.getSynonimWords()) {
				if (word.getWord().equals(name)) {
					for (IHistoricChange historico : word.getHistoric()
							.getHistoricList()) {
						if (historico.getUser().equals(
								CfgHistoricUser.NOT_VERIFIED.nameId())) {
							throw new CompetitionNotVerifiedException(
									new StringBuffer()
											.append("La competicion ")
											.append(name)
											.append(" no ha sido verificada.")
											.toString());
						}
					}
				}
			}
		}

		if (competitionList != null && competitionList.size() > 0) {
			for (CfgCompetitionSynonyms competitionSyn : competitionList) {
				CfgCompetition competition = competitionSyn.getCompetition();
				if (competition.getSport().getObjectId().equals(sportId)) {
					result = competition;
					break;
				}
			}

			// Si el deporte asociado a la competicion es el mismo devolvemos la
			// competicion en caso contrario devolvemos nulo
			if (result != null) {
				return result;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Gets the model class.
	 * 
	 * @return the model class {@inheritDoc}
	 */
	@Override
	protected Class<CfgCompetitionSynonyms> getModelClass() {
		return CfgCompetitionSynonyms.class;
	}

}
