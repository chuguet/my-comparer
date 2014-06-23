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
 * The Class RunTest.
 */
public class FirstSurebetTemplateTest extends AbstractQueueTest {
	
	@Resource(name="firstSurebetTemplate")
	private AmqpTemplate amqpTemplate;	

	@Override
	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}

}
