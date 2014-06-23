/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.integration.producer.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.springframework.integration.Message;
import org.springframework.integration.MessageHeaders;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.integration.producer.filter.MessageSelectorDuplicatedFilter;
import com.comparadorad.bet.comparer.integration.producer.service.IProducer;

/**
 * The Class DuplicatedMessageTest.
 */
public class DuplicatedMessageTest extends AbstractTest {

	/** The duplicated filter. */
	@Inject
	private MessageSelectorDuplicatedFilter duplicatedFilter;

	/** The executor service. */
	ExecutorService executorService;

	/**
	 * Send duplicated messages.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void sendDuplicatedMessages() throws Exception {

		MessageImpl msg = new MessageImpl();

		// Envio el mensaje por primera vez
		assertTrue(duplicatedFilter.accept(msg));

		// Envio el mensaje por segunda vez
		assertFalse(duplicatedFilter.accept(msg));

	}

	/**
	 * The Class MessageImpl.
	 */
	class MessageImpl implements Message<UpdaterBetsTO> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.integration.Message#getHeaders()
		 */
		@Override
		public MessageHeaders getHeaders() {
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.integration.Message#getPayload()
		 */
		@Override
		public UpdaterBetsTO getPayload() {
			return createMessage("gateway", "10", "send");
		}

	}

}
