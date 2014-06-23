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
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.communication.email.beans.SureBetTo;
import com.comparadorad.bet.comparer.communication.email.build.BuildSureBetsEmail;
import com.comparadorad.bet.comparer.communication.email.build.IBuildEmail;
import com.comparadorad.bet.comparer.communication.email.exception.EmailException;
import com.comparadorad.bet.comparer.communication.email.mapper.enums.MapperId;
import com.comparadorad.bet.comparer.communication.email.shipping.IShippingEmail;

/**
 * The Class AbstractSureBetEmailConsumerQueue.
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractSureBetEmailConsumerQueue extends AbstractEmailConsumerQueue {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractSureBetEmailConsumerQueue.class);
	
	/** The build sure bets email. */
	@Inject
	private BuildSureBetsEmail<List<SureBetTo>> buildSureBetsEmail;
	
	/** {@inheritDoc} */ 
	public void receive() throws EmailException {
		List<SureBetTo> sureBetTos = new ArrayList<SureBetTo>();
		SureBetTo sureBetTo = new SureBetTo();
		SureBetQueue sureBetQueue = (SureBetQueue) getConsumer().receive();
		
		if( sureBetQueue != null){
			if( LOG.isInfoEnabled() ){
				LOG.info("Se ha recibido una apuesta segura");
			}
			getMapper().map(sureBetQueue, sureBetTo, getMapperId().getNameId());
			sureBetTos.add(sureBetTo);
			getShippingEmail().shipMail(getBuildEmail().makeMail(sureBetTos));
		}else{
			if( LOG.isInfoEnabled() ){
				LOG.info("No se ha recibido ninguna apuesta segura");
			}
		}
		if( LOG.isDebugEnabled() ){
			LOG.debug(sureBetTo.toString());
		}
	}
	
	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	protected Map<String, String> getParameters(){
		return null;
	}
	
	/**
	 * Gets the shipping email.
	 *
	 * @return the shipping email
	 */
	public abstract IShippingEmail getShippingEmail();
	
	/** {@inheritDoc} */ 
	@Override
	protected IBuildEmail<List<SureBetTo>> getBuildEmail() {
		return buildSureBetsEmail;
	}
	

	/** {@inheritDoc} */ 
	@Override
	protected MapperId getMapperId() {
		return MapperId.SUREBETDATA_TO_SUREBETTO;
	}

}
