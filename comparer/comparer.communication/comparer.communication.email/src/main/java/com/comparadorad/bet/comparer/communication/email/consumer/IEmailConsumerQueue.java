package com.comparadorad.bet.comparer.communication.email.consumer;

import com.comparadorad.bet.comparer.communication.email.exception.EmailException;

public interface IEmailConsumerQueue {
	
	void receive() throws EmailException;

}
