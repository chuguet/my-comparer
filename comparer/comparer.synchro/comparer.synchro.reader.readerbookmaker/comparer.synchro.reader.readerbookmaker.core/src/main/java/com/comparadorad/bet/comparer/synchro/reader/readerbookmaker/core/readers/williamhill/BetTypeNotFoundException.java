package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

@SuppressWarnings("serial")
public class BetTypeNotFoundException extends XmlReaderException {

	public BetTypeNotFoundException() {
		super();
	}

	public BetTypeNotFoundException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	public BetTypeNotFoundException(String pMessage) {
		super(pMessage);
	}

	public BetTypeNotFoundException(Throwable pCause) {
		super(pCause);
	}

}
