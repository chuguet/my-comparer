package com.comparadorad.bet.comparer.communication.consumer;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.communication.core.beans.UpdaterBetsTO;

public class UpdaterBetsQueueConsumerTest<T extends UpdaterBetsQueueConsumer<UpdaterBetsTO>, I extends UpdaterBetsTO>
		extends ConsumerQueueTest<T, I> {

	@Inject
	private UpdaterBetsQueueConsumer<UpdaterBetsTO> consumer;

	@Override
	public T getAbstractConsumerQueue() {
		return (T) consumer;
	}

}
