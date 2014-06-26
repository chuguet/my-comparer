/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.task.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.synchro.betclean.beans.Range;
import com.comparadorad.bet.comparer.synchro.betclean.exception.RemoveBetsException;
import com.comparadorad.bet.comparer.synchro.betclean.task.IAsyncDraftBets;
import com.comparadorad.bet.comparer.synchro.betclean.util.IModifyBets;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class DraftBets.
 */
@Component
class AsyncDraftBets implements IAsyncDraftBets {

	/** The Constant DATE_FORMAT. */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"mm:ss");

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The match repository. */
	@Inject
	private RtMatchRepository matchRepository;

	/** The modify bets. */
	@Inject
	private IModifyBets modifyBets;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.betclean.task.IDraftBets#removeBets
	 * (java.util.List, java.lang.String)
	 */
	@Override
	@Async(value = "draftTaskExecutor")
	public void removeBetsFromRangeMatchs(Range range, String idThreadLauncher) {
		try {
			Date start = new Date();
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer(
							"Comienzo de borrado de apuestas. Me he lanzando desde el proceso de [ThreadId: ")
							.append(idThreadLauncher + "]").toString());
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer(
							"Buscando en base de datos desde el partido ")
							.append(range.getInit())
							.append(" hasta el partido ")
							.append(range.getFinish() + range.getInit())
							.toString());
			List<RtMatch> matchs = matchRepository.findAllLimitBetClean(
					range.getFinish(), range.getInit());
			LOG.debug(Thread.currentThread(),
					"Se proceden a borrar las apuestas.");
			modifyBets.removeBets(matchs);
			Date end = new Date();
			String minutes = DATE_FORMAT
					.format(end.getTime() - start.getTime());
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer(
							"Fin de borrado de apuestas. Me he lanzando desde el proceso de [ThreadId: ")
							.append(idThreadLauncher + "]. DURACION ==> ")
							.append(minutes).toString());
		} catch (RemoveBetsException e) {
			LOG.error(Thread.currentThread(),
					"Error durante el proceso de borrado de apuestas.", e);
		}
	}

}
