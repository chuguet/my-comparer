/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.core;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;

/**
 * The Class UpdaterBetsTemplateTest.
 */
public class UpdaterBetsTemplateTest extends AbstractQueueTest {

	/** The template. */
	@Resource(name = "updaterBetsTemplate")
	private AmqpTemplate template;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.communication.core.AbstractQueueTest#
	 * getAmqpTemplate()
	 */
	@Override
	public AmqpTemplate getAmqpTemplate() {
		return template;
	}
}
