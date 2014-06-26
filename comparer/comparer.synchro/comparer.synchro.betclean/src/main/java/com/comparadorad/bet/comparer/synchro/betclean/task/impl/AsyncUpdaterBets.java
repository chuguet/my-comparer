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

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.synchro.betclean.exception.UpdateBetsException;
import com.comparadorad.bet.comparer.synchro.betclean.task.IAsyncUpdaterBets;
import com.comparadorad.bet.comparer.synchro.betclean.util.IModifyBets;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class UpdaterBets.
 */
@Component
class AsyncUpdaterBets implements IAsyncUpdaterBets {

	/** The Constant DATE_FORMAT. */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"mm:ss");
	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The modify bets. */
	@Inject
	private IModifyBets modifyBets;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.betclean.task.IUpdaterBets#
	 * updateBetsFromMsgQueue(java.lang.Object, java.lang.String)
	 */
	@Override
	@Async(value = "updateTaskExecutor")
	public void updateBetsFromMsgQueue(UpdaterBetsTO msg,
			String idThreadLauncher) {
		try {
			Date start = new Date();
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer(
							"Comienzo de actualizacion de apuestas y me he ejecutado desde [Thread ")
							.append(idThreadLauncher).append("]").toString());
			modifyBets.updateBets(msg);
			Date end = new Date();
			String minutes = DATE_FORMAT
					.format(end.getTime() - start.getTime());
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer(
							"Fin de actualizacion de apuestas y me he ejecutado desde [Thread ")
							.append(idThreadLauncher).append("]. DURACION ==> ")
							.append(minutes).toString());
		} catch (UpdateBetsException e) {
			LOG.error(Thread.currentThread(),
					"Error durante el proceso de actualizacion de apuestas.", e);
		}
	}
}
