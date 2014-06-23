/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.consumer;

import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;

import com.comparadorad.bet.comparer.communication.consumer.IConsumerQueue;
import com.comparadorad.bet.comparer.communication.email.beans.IEmailParameter;
import com.comparadorad.bet.comparer.communication.email.build.IBuildEmail;
import com.comparadorad.bet.comparer.communication.email.mapper.enums.MapperId;

/**
 * The Class AbstractEmailConsumerQueue.
 */
public abstract class AbstractEmailConsumerQueue<T extends List<? extends IEmailParameter>> implements IEmailConsumerQueue {
	
	/** The mapper. */
	@Inject
	private Mapper mapper;	
	
	/**
	 * Gets the mapper.
	 *
	 * @return the mapper
	 */
	protected Mapper getMapper() {
		return mapper;
	}
	

	
	/**
	 * Gets the mapper id.
	 *
	 * @return the mapper id
	 */
	protected abstract MapperId getMapperId();
	
	/**
	 * Gets the consumer.
	 *
	 * @return the consumer
	 */
	protected abstract IConsumerQueue getConsumer();
	
	/**
	 * Gets the builds the email.
	 *
	 * @return the builds the email
	 */
	protected abstract IBuildEmail<T> getBuildEmail();

}
