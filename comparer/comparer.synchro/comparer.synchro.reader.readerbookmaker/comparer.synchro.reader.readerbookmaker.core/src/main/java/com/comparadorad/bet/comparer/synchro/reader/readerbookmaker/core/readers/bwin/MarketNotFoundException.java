package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

@SuppressWarnings("serial")
public class MarketNotFoundException extends XmlReaderException {

	public MarketNotFoundException() {
		super();
	}

	public MarketNotFoundException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	public MarketNotFoundException(String pMessage) {
		super(pMessage);
	}

	public MarketNotFoundException(Throwable pCause) {
		super(pCause);
	}

}
