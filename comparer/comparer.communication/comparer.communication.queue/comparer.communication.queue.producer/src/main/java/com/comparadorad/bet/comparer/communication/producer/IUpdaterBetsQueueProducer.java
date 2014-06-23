package com.comparadorad.bet.comparer.communication.producer;

import com.comparadorad.bet.comparer.communication.core.beans.UpdaterBetsTO;

public interface IUpdaterBetsQueueProducer<T extends UpdaterBetsTO> extends
		IProducerQueue<T> {

}
