/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.log.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.math.BigInteger;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.QueryUtils;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepository;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class CfgBetTypeRepositoryCustomImpl.
 */
class LogEventBookmakerMasterWordsRepositoryCustomImpl extends AbstractRepository<LogEventBookmakerMasterWords> implements
		IGenericCustomRepository<LogEventBookmakerMasterWords>, LogEventBookmakerMasterWordsRepositoryCustom<LogEventBookmakerMasterWords> {

	
	@Inject
	private ComparerWrapperLog LOG;
	
	

	/**
	 * Custom find by state.
	 * 
	 * @param pLogState
	 *            the log state
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<LogEventBookmakerMasterWords> customFindByState(LogState pLogState) {
		Query q1 = new Query(where("logState").is(pLogState.getState())).limit(5);
		Order order = new Order(Direction.ASC, "errorDate");
		Sort sort = new Sort(order);
		QueryUtils.applySorting(q1, sort);

		return getMongoTemplate().find(q1, LogEventBookmakerMasterWords.class);
	}

	/**
	 * Exists previous error.
	 * 
	 * @param dataName
	 *            the data name
	 * @param pLogState
	 *            the log state
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	public boolean existsPreviousError(String dataName, String[] pLogState) {
		boolean result = false;
		Query q1 = new Query(where("message").is(dataName));

		LOG.debug(Thread.currentThread(), q1.getQueryObject().toString());

		List<LogEventBookmakerMasterWords> listaResultados = getMongoTemplate().find(q1, LogEventBookmakerMasterWords.class);

		if (!listaResultados.isEmpty()) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.log.repository.
	 * LogEventBookmakerMasterWordsRepositoryCustom
	 * #existsPreviousParticipantError(java.lang.String, java.lang.String[],
	 * java.math.BigInteger)
	 */
	 /** {@inheritDoc} */
	@Override
	public boolean existsPreviousParticipantError(String dataName, String[] pLogState, BigInteger competitionId) {
		CfgParticipant participant = new CfgParticipant();
		Query q1 = new Query(where("message").is(dataName));
		boolean existe = false;

		List<LogEventBookmakerMasterWords> listaResultados = getMongoTemplate().find(q1, LogEventBookmakerMasterWords.class);

		if (!listaResultados.isEmpty()) {
			for (LogEventBookmakerMasterWords palabraBD : listaResultados) {
				XmlMatchParticipant participante = (XmlMatchParticipant) palabraBD.getData();
				if (participante.getXmlTournament().getCfgObjectId().equals(competitionId)) {
					existe = true;
					break;
				}
			}
		}

		return existe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.log.repository.
	 * LogEventBookmakerMasterWordsRepositoryCustom
	 * #existsPreviousCompetitionError(java.lang.String, java.lang.String[])
	 */
	 /** {@inheritDoc} */
	@Override
	public LogEventBookmakerMasterWords existsPreviousCompetitionError(final String errorMessage, final String[] pLogState) {
		LogEventBookmakerMasterWords event = null;
		Query existentCompetitionQuery = new Query(where("message").is(errorMessage).and("logState").in(pLogState));
		List<LogEventBookmakerMasterWords> events = (getMongoTemplate().find(existentCompetitionQuery, LogEventBookmakerMasterWords.class));

		if (events != null && events.size() > 0) {
			event = events.get(0);
		}
		return event;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.log.repository.
	 * LogEventBookmakerMasterWordsRepositoryCustom
	 * #updateEventCompetition(com.comparadorad
	 * .bet.comparer.model.log.bean.LogEventBookmakerMasterWords)
	 */
	 /** {@inheritDoc} */
	@Override
	public void updateEventCompetition(LogEventBookmakerMasterWords event) {
		getMongoTemplate().save(event);
	}

	 /** {@inheritDoc} */
	@Override
	public Boolean checkParticipantExistence(XmlMatchParticipant participante) {
		Boolean existe = Boolean.FALSE;
		Query query1 = new Query(where("synonimWords.word").is(participante.getName()));
		query1.fields().include("participant");
		Query query2 = new Query(where("cfgCompetition.$id").is(participante.getXmlTournament().getCfgObjectId().toString()));
		query2.fields().include("_id");
		List<CfgParticipantSynonyms> teamSyn = getMongoTemplate().find(query1, CfgParticipantSynonyms.class);

		List<CfgParticipant> teams = getMongoTemplate().find(query2, CfgParticipant.class);

		try {
			if (teamSyn != null && teamSyn.size() > 0) {
				for (CfgParticipant cfgParticipant : teams) {
					for (CfgParticipantSynonyms cfgParticipantSyn : teamSyn) {
						if (cfgParticipantSyn.getRelatedDocument().getObjectId().equals(cfgParticipant.getObjectId())) {
							existe = Boolean.TRUE;
							break;
						}
					}
				}
			}
		} catch (NullPointerException exception)  {
			LOG.warn(Thread.currentThread(), "No se ha podido verificar si el participante existia previamente, se continua con su procesado");
		}
		return existe;
	}

	 /** {@inheritDoc} */
	@Override
	public void deleteExistentSynonym(String message) {
		Query query = new Query(where("message").is(message));
		LOG.debug(Thread.currentThread(), new StringBuffer("Se va a eliminar la entrada ").append(message).toString());
		getMongoTemplate().remove(query);
	}
}
