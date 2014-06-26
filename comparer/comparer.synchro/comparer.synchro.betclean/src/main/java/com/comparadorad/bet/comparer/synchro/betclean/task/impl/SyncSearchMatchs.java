/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.task.impl;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.synchro.betclean.beans.Range;
import com.comparadorad.bet.comparer.synchro.betclean.data.DataConfiguration;
import com.comparadorad.bet.comparer.synchro.betclean.task.IAsyncDraftBets;
import com.comparadorad.bet.comparer.synchro.betclean.task.ISyncSearchMatchs;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class CleanTask.
 */
@Component
class SyncSearchMatchs implements ISyncSearchMatchs {

	/** The draft bets. */
	@Inject
	private IAsyncDraftBets asyncDraftBets;

	/** The data configuration. */
	@Inject
	private DataConfiguration dataConfiguration;

	/** The match service. */
	@Inject
	private RtMatchRepository matchService;

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	@Value("${delay}")
	private String delay;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.task.ISearchMatchs#
	 * findAllMatchsRemoveBets()
	 */
	@Override
	@Scheduled(fixedDelayString = "${delay}")
	public void findAllMatchsRemoveBets() {
		LOG.debug(
				Thread.currentThread(),
				new StringBuffer("Comienzo de lanzamiento de procesos asincronos para buscar partidos y borrar apuestas con un tiempo de espera de: ").append(delay).toString());
		Long count = matchService.count();
		LOG.debug(Thread.currentThread(), new StringBuffer("Hay un total de ")
				.append(count).append(" matchs en base de datos.").toString());
		for (int skip = 0; skip < count; skip += dataConfiguration
				.getLimitQueryMatchs()) {
			asyncDraftBets.removeBetsFromRangeMatchs(new Range(skip,
					dataConfiguration.getLimitQueryMatchs()), String
					.valueOf(Thread.currentThread().getId()));
		}
		LOG.debug(
				Thread.currentThread(),
				"Fin de lanzamiento de procesos asincronos para buscar partidos y borrar apuestas.");
	}

}
