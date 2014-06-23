/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.producer;

import org.springframework.amqp.core.AmqpTemplate;

import com.thoughtworks.xstream.XStream;

/**
 * The Class AbstractQueueProduce.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractQueueProduce<T> implements IProducerQueue<T> {

	/**
	 * Gets the template.
	 * 
	 * @return the template
	 */
	protected abstract AmqpTemplate getTemplate();

	/** {@inheritDoc} */
	public Boolean send(T t) {
		Boolean result = Boolean.TRUE;
		XStream xStream = new XStream();
		String xml = xStream.toXML(t);
		getTemplate().convertAndSend(xml);
		return result;
	}

}
