package com.comparadorad.bet.comparer.communication.email.consumer;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.consumer.FourthSurebetQueueConsumer;
import com.comparadorad.bet.comparer.communication.consumer.IConsumerQueue;
import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.communication.email.exception.EmailException;
import com.comparadorad.bet.comparer.communication.email.shipping.FourthShippingSureBetsEmail;
import com.comparadorad.bet.comparer.communication.email.shipping.IShippingEmail;

@Service
public class FourthSureBetEmailConsumerQueue extends
AbstractSureBetEmailConsumerQueue {
	
	private static final Log LOG = LogFactory
			.getLog(ValueBetEmailConsumerQueue.class);
	
	@Inject
	private FourthSurebetQueueConsumer<SureBetQueue> consumerQueue;
	
	@Inject
	private FourthShippingSureBetsEmail shippingSureBetsEmail;

	@Override
	public IShippingEmail getShippingEmail() {
		return shippingSureBetsEmail;
	}

	@Override
	protected IConsumerQueue<SureBetQueue> getConsumer() {
		return consumerQueue;
	}
	
	@Override
	@Scheduled(fixedDelay = 180000)
	public void receive() throws EmailException {
		LOG.info("Se ejecuta la generacion y envio de correo surebet para el cuarto tipo de envio");
		super.receive();
		LOG.info("Se finaliza la generacion y envio de correo surebet para el cuarto tipo de envio");
	}

}
