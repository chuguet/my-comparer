/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.task;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;
import com.comparadorad.bet.comparer.communication.producer.ValuebetQueueProducer;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetService;
import com.thoughtworks.xstream.XStream;

/**
 * The Class AbstractTaskValueBet.
 */
abstract class AbstractTaskValueBet implements ITaskValueBet {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractTaskValueBet.class);

	/** The value bet queue. */
	private ValueBetQueue valueBetQueue;

	/** The producer queue. */
	@Inject
	private ValuebetQueueProducer<ValueBetQueue> producerQueue;

	/** The value bet service. */
	@Inject
	private IValueBetService valueBetService;

	/**
	 * Process.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void process() {

		XStream xStream;
		this.valueBetQueue = new ValueBetQueue(
				valueBetService.getValueBetFromNumDays(getNumDays()));

		LOG.info("Se han recuperado las ValueBets de Base de datos");

		if (LOG.isDebugEnabled()) {
			xStream = new XStream();
			LOG.debug("Se ha recuperado la siguiente informacion: "
					+ xStream.toXML(valueBetQueue));

		}

		LOG.info(new StringBuffer()
				.append("Se envia el correo de las apuestas de valor con los valores: ")
				.append(this.valueBetQueue.toString()).toString());
		Boolean result = producerQueue.send(this.valueBetQueue);

		if (result) {
			LOG.info("Mensaje producido correctamente");
		} else {
			LOG.info("Mensaje no producido");
		}
	}

	/** {@inheritDoc} */
	@Override
	public ValueBetQueue getValueBetQueue() {
		return valueBetQueue;
	}

	/**
	 * Sets the value bet queue.
	 * 
	 * @param valueBetQueue
	 *            the new value bet queue
	 */
	protected void setValueBetQueue(ValueBetQueue valueBetQueue) {
		this.valueBetQueue = valueBetQueue;
	}

}
