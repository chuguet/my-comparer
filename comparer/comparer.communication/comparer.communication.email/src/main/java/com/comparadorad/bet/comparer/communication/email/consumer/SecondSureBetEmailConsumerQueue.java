package com.comparadorad.bet.comparer.communication.email.consumer;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.consumer.IConsumerQueue;
import com.comparadorad.bet.comparer.communication.consumer.SecondSurebetQueueConsumer;
import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.communication.email.exception.EmailException;
import com.comparadorad.bet.comparer.communication.email.shipping.IShippingEmail;
import com.comparadorad.bet.comparer.communication.email.shipping.SecondShippingSureBetsEmail;

@Service
public class SecondSureBetEmailConsumerQueue extends
AbstractSureBetEmailConsumerQueue {
	
	private static final Log LOG = LogFactory
			.getLog(SecondSureBetEmailConsumerQueue.class);
	
	@Inject
	private SecondSurebetQueueConsumer<SureBetQueue> consumerQueue;	
	
	@Inject
	private SecondShippingSureBetsEmail secondShippingSureBetsEmail;

	@Override
	public IShippingEmail getShippingEmail() {
		return secondShippingSureBetsEmail;
	}

	@Override
	protected IConsumerQueue<SureBetQueue> getConsumer() {
		return consumerQueue;
	}
	
	@Override
	@Scheduled(fixedDelay = 60000)
	public void receive() throws EmailException {
		LOG.info("Se ejecuta la generacion y envio de correo surebet para el segundo tipo de envio");
		super.receive();
		LOG.info("Se finaliza la generacion y envio de correo surebet para el segundo tipo de envio");
	}

}
