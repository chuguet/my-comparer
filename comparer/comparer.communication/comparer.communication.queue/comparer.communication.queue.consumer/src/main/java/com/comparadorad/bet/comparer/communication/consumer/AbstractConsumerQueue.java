/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.consumer;

import org.springframework.amqp.core.AmqpTemplate;

import com.thoughtworks.xstream.XStream;

/**
 * The Class AbstractConsumerQueue.
 * 
 * @param <T>
 *            the generic type
 */
abstract class AbstractConsumerQueue<T> implements IConsumerQueue<T> {

	/**
	 * Gets the template.
	 * 
	 * @return the template
	 */
	public abstract AmqpTemplate getTemplate();

	/**
	 * Receive.
	 * 
	 * @return the value bet queue {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T receive() {
		XStream xStream = new XStream();
		T result = null;
		String xml = (String) getTemplate().receiveAndConvert();
		if (xml != null) {
			result = (T) xStream.fromXML(xml);
		}
		return result;
	}

}
