package com.comparadorad.bet.comparer.communication.producer;

public interface IProducerQueue<T> {
	
	Boolean send(T t);

}
