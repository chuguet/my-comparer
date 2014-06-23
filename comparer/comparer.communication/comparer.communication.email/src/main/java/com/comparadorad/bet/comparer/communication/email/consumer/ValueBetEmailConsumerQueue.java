/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.consumer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.communication.consumer.IConsumerQueue;
import com.comparadorad.bet.comparer.communication.consumer.ValueBetQueueConsumer;
import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;
import com.comparadorad.bet.comparer.communication.email.beans.ValueBetTo;
import com.comparadorad.bet.comparer.communication.email.build.BuildValueBetsEmail;
import com.comparadorad.bet.comparer.communication.email.exception.EmailException;
import com.comparadorad.bet.comparer.communication.email.mapper.enums.MapperId;
import com.comparadorad.bet.comparer.communication.email.shipping.IShippingEmail;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;

/**
 * The Class ValueBetEmailConsumerQueue.
 */
@Service
public class ValueBetEmailConsumerQueue extends AbstractEmailConsumerQueue {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ValueBetEmailConsumerQueue.class);
	
	/** The consumer queue. */
	@Inject
	private ValueBetQueueConsumer<ValueBetQueue> consumerQueue;
	
	/** The make email. */
	@Inject
	private BuildValueBetsEmail<List<ValueBetTo>> makeEmail;
	
	@Inject
	@Resource(name="shippingValueBetsEmail")
	private IShippingEmail shippingEmail;
	
	
	public MapperId getMapperId(){
		return MapperId.VALUEBETDATA_TO_VALUEBETTO;
	}

	 /** {@inheritDoc} */
	@Scheduled(fixedDelay=5000)
	public void receive() throws EmailException{
		
		List<ValueBetTo> valueBetTos = new ArrayList<ValueBetTo>();
		LOG.info("Se ejecuta la generacion y envio de correo de valuebet");
		
		ValueBetQueue betQueue = getConsumer().receive();
		if( betQueue != null && betQueue.getBetDatas() != null && betQueue.getBetDatas().size() != 0  ){
			ValueBetTo valueBetTo;
			if( betQueue != null && betQueue.getBetDatas() != null ){
				for (ValueBetData betData : betQueue.getBetDatas()) {
					valueBetTo = new ValueBetTo();
					getMapper().map(betData, valueBetTo,getMapperId().getNameId());
					valueBetTos.add(valueBetTo);
				}
				shippingEmail.shipMail(getBuildEmail().makeMail(valueBetTos));			
			}else{
				LOG.debug("No existe ningun mensaje en la cola");
			}
			
		}else{
			LOG.debug("No existe ningun mensaje en la cola");
		}
		LOG.info("Se finaliza la generacion y envio de correo de valuebet");
	}

	@Override
	protected IConsumerQueue<ValueBetQueue> getConsumer() {
		return consumerQueue;
	}
	
	@Override
	protected BuildValueBetsEmail<List<ValueBetTo>> getBuildEmail(){
		return makeEmail;
	}
	
	
}
