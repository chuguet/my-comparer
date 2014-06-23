package com.comparadorad.bet.comparer.communication.consumer;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;

public class ValueBetQueueProducerTest<T extends ValueBetQueueConsumer<ValueBetQueue>, I extends ValueBetQueue>
		extends ConsumerQueueTest<T, I> {
	
	@Inject
	private ValueBetQueueConsumer<ValueBetQueue> betQueueProducer;

	@Override
	public T getAbstractConsumerQueue() {
		return (T) betQueueProducer;
	}

}
