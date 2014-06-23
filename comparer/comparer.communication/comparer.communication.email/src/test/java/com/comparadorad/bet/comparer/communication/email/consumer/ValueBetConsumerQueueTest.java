package com.comparadorad.bet.comparer.communication.email.consumer;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValueBetConsumerQueueTest extends AbstractConsumerTest {
	
	@Inject
	private ValueBetEmailConsumerQueue consumerQueue;

	@Override
	protected IEmailConsumerQueue getConsumer() {
		return consumerQueue;
	}
	
	

}
