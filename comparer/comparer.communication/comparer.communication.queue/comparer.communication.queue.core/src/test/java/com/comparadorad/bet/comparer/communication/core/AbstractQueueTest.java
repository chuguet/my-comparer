package com.comparadorad.bet.comparer.communication.core;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import static org.junit.Assert.assertNotNull;

public abstract class AbstractQueueTest extends AbstractTest {
	
	public abstract AmqpTemplate getAmqpTemplate();
	
	@Test
	public void notNullTest(){
		assertNotNull(getAmqpTemplate());
	}

}
