/**
 *
º * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.consumer;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.consumer.IConsumerQueue;
import com.comparadorad.bet.comparer.communication.consumer.ThirdSurebetQueueConsumer;
import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.communication.email.exception.EmailException;
import com.comparadorad.bet.comparer.communication.email.shipping.IShippingEmail;
import com.comparadorad.bet.comparer.communication.email.shipping.ThirdShippingSureBetsEmail;

/**
 * The Class ThirdSureBetEmailConsumerQueue.
 */
@Service
public class ThirdSureBetEmailConsumerQueue  extends
AbstractSureBetEmailConsumerQueue {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(SecondSureBetEmailConsumerQueue.class);
	
	/** The consumer queue. */
	@Inject
	private ThirdSurebetQueueConsumer<SureBetQueue> consumerQueue;	
	
	/** The third shipping sure bets email. */
	@Inject
	private ThirdShippingSureBetsEmail thirdShippingSureBetsEmail;

	/** {@inheritDoc} */ 
	@Override
	public IShippingEmail getShippingEmail() {
		return thirdShippingSureBetsEmail;
	}

	/** {@inheritDoc} */ 
	@Override
	protected IConsumerQueue<SureBetQueue> getConsumer() {
		return consumerQueue;
	}
	
	/** {@inheritDoc} */ 
	@Override
	@Scheduled(fixedDelay = 120000)
	public void receive() throws EmailException {
		LOG.info("Se ejecuta la generacion y envio de correo surebet para el tercero tipo de envio");
		super.receive();
		LOG.info("Se finaliza la generacion y envio de correo surebet para el tercero tipo de envio");
	}

}
