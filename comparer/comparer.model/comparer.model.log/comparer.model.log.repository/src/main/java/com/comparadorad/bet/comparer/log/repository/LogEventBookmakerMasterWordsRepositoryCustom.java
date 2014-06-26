/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.log.repository;

import java.math.BigInteger;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.core.repository.IGenericCustomRepository;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;

/**
 * The Interface LogEventBookmakerRepositoryCustom.
 * 
 * @param <T>
 *            the generic type
 */
interface LogEventBookmakerMasterWordsRepositoryCustom<T extends LogEventBookmakerMasterWords> extends IGenericCustomRepository<T> {

	/**
	 * Custom find by bookmaker and state.
	 * 
	 * @param pLogState
	 *            the log state
	 * @return the list
	 */
	List<LogEventBookmakerMasterWords> customFindByState(LogState pLogState);

	/**
	 * Comprueba si el participante existia antes de generarlo.
	 * 
	 * @param participante
	 * @return si existe o no el participante
	 */
	Boolean checkParticipantExistence(XmlMatchParticipant participante);

	/**
	 * Elimina un sinonimo ya generado.
	 * 
	 * @param message
	 */
	void deleteExistentSynonym(String message);

	/**
	 * Exists previous error.
	 * 
	 * @param dataName
	 *            the data name
	 * @param pLogState
	 *            the log state
	 * @param competitionID
	 *            the competition id
	 * @return true, if successful
	 */
	boolean existsPreviousParticipantError(String dataName, String[] pLogState, BigInteger competitionID);

	/**
	 * Exists previous competition error.
	 * 
	 * @param dataName
	 *            the data name
	 * @param pLogState
	 *            the log state
	 * @return the cfg competition
	 */
	LogEventBookmakerMasterWords existsPreviousCompetitionError(String dataName, String[] pLogState);

	/**
	 * Update event competition.
	 * 
	 * @param event
	 *            the event
	 */
	void updateEventCompetition(LogEventBookmakerMasterWords event);

	/**
	 * Exists previous error.
	 * 
	 * @param dataName
	 *            the data name
	 * @param pLogState
	 *            the log state
	 * @return true, if successful
	 */
	boolean existsPreviousError(String dataName, String[] pLogState);
}
