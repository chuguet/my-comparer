package com.comparadorad.bet.comparer.communication.producer;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

public class FourthSurebetQueueProducerTest extends AbstractTest {
	
	/** The queue surebet. */
	@Inject
	private FourthSurebetQueueProducer<SureBetQueue> queueSurebet;
	
	/**
	 * Send test.
	 */
	@Test
	public final void sendTest(){
		queueSurebet.send(new SureBetQueue(new SecureBeanData(), new Date()));
	}

}
