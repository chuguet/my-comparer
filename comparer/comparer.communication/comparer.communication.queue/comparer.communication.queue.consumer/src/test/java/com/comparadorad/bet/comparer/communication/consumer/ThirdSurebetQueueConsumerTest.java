package com.comparadorad.bet.comparer.communication.consumer;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.communication.core.bean.SureBetQueue;

public class ThirdSurebetQueueConsumerTest<T extends ThirdSurebetQueueConsumer<SureBetQueue>, I extends SureBetQueue>
extends ConsumerQueueTest<T, I> {
	
	@Inject
	private ThirdSurebetQueueConsumer<SureBetQueue> consumer;

	@Override
	public T getAbstractConsumerQueue() {
		return (T) consumer;
	}

}
