package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

@SuppressWarnings("serial")
public class InvalidNumberParticipantsException extends XmlReaderException {

	public InvalidNumberParticipantsException() {
		super();
	}

	public InvalidNumberParticipantsException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	public InvalidNumberParticipantsException(String pMessage) {
		super(pMessage);
	}

	public InvalidNumberParticipantsException(Throwable pCause) {
		super(pCause);
	}

}
