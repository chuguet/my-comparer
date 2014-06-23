package com.comparadorad.bet.comparer.communication.email.consumer;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.consumer.FirstSurebetQueueConsumer;
import com.comparadorad.bet.comparer.communication.consumer.IConsumerQueue;
import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.communication.email.exception.EmailException;
import com.comparadorad.bet.comparer.communication.email.shipping.IShippingEmail;

@Service
public class FirstSureBetEmailConsumerQueue extends
		AbstractSureBetEmailConsumerQueue {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ValueBetEmailConsumerQueue.class);


	@Inject
	private FirstSurebetQueueConsumer<SureBetQueue> consumerQueue;
	

	@Resource(name="firstShippingSureBetsEmail")
	private IShippingEmail iShippingEmail;

	@Override
	@Scheduled(fixedDelay = 5000)
	public void receive() throws EmailException {
		LOG.info("Se ejecuta la generacion y envio de correo surebet para el primer tipo de envio");
		super.receive();
		LOG.info("Se finaliza la generacion y envio de correo surebet para el primer tipo de envio");
	}

	@Override
	protected IConsumerQueue<SureBetQueue> getConsumer() {
		return consumerQueue;
	}


	@Override
	public IShippingEmail getShippingEmail() {
		return iShippingEmail;
	}

}
