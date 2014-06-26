/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.task.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.synchro.betclean.task.IAsyncUpdaterBets;
import com.comparadorad.bet.comparer.synchro.betclean.task.IListenerMsgQueue;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;
import com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.UnknownFieldException;

/**
 * The Class ReaderMsgQueue.
 */
@Component
class ListenerMsgQueue implements IListenerMsgQueue {

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The updater bets. */
	@Inject
	private IAsyncUpdaterBets updaterBets;

	/** {@inheritDoc} */ 
	@Override
	public void receive(UpdaterBetsTO updaterBetsTO) {
		try {
			LOG.debug(
					Thread.currentThread(),
					"Comienzo de lanzamiento de procesos asincronos para lectura de cola y actualizar apuestas");
			updaterBets.updateBetsFromMsgQueue(updaterBetsTO,
					String.valueOf(Thread.currentThread().getId()));
			LOG.debug(
					Thread.currentThread(),
					"Fin de lanzamiento de procesos asincronos para buscar partidos y borrar apuestas.");
		} catch (UnknownFieldException e) {
			LOG.error(Thread.currentThread(),
					"Error en la lectura del mensaje de la cola.", e);
		}
	}

}
