package com.comparadorad.bet.comparer.communication.email.shipping;

import com.comparadorad.bet.comparer.autosender.core.enume.MessageType;

public abstract class AbstractShippingSureBetsEmail extends AbstractShippingEmail {
	
	/** {@inheritDoc} */ 
	@Override
	protected MessageType getMessageType() {
		return MessageType.HTML;
	}

	/** {@inheritDoc} */ 
	@Override
	protected String getContent() {
		return "Sure Bet";
	}

}
