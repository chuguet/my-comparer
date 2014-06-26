/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.exception;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;

/**
 * The Class InconsistentParticipantOrderException.
 */
@SuppressWarnings("serial")
public class InconsistentParticipantOrderException extends
		SynchroMatchWriterServiceException {

	/** The away participant. */
	private RtParticipant awayParticipant;

	/** The bet. */
	private RtBet bet;

	/** The home participant. */
	private RtParticipant homeParticipant;

	/**
	 * Instantiates a new inconsistent participant order exception.
	 */
	public InconsistentParticipantOrderException() {
		super();
	}

	/**
	 * Instantiates a new inconsistent participant order exception.
	 * 
	 * @param bet
	 *            the bet
	 * @param homeParticipant
	 *            the home participant
	 * @param awayParticipant
	 *            the away participant
	 */
	public InconsistentParticipantOrderException(RtBet bet,
			RtParticipant homeParticipant, RtParticipant awayParticipant) {
		this.bet = bet;
		this.homeParticipant = homeParticipant;
		this.awayParticipant = awayParticipant;
	}

	/**
	 * Instantiates a new inconsistent participant order exception.
	 * 
	 * @param message
	 *            the message
	 */
	public InconsistentParticipantOrderException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new inconsistent participant order exception.
	 * 
	 * @param message
	 *            the message
	 * @param bet
	 *            the bet
	 * @param homeParticipant
	 *            the home participant
	 * @param awayParticipant
	 *            the away participant
	 */
	public InconsistentParticipantOrderException(String message, RtBet bet,
			RtParticipant homeParticipant, RtParticipant awayParticipant) {
		super(message);
		this.bet = bet;
		this.homeParticipant = homeParticipant;
		this.awayParticipant = awayParticipant;
	}

	/** {@inheritDoc} */
	@Override
	public String getMessage() {
		StringBuffer message = new StringBuffer();
		message.append("Parece ser que haya inconsistencias entre los participantes a nivel de bet y los participantes a nivel de match\n ");
		message.append("Los participantes de nivel RtMatchId estaban invertidos pero ahora se ha encontrado un bet donde los participantes NO estan invertidos:\n ");
		if (homeParticipant.getCfgParticipant() != null) {
			message.append("Participante HOME del partido: id = ");
			message.append(homeParticipant.getCfgParticipant().getObjectId()
					.toString());
			message.append(" , name = ");
			message.append(homeParticipant.getCfgParticipant().getName(null));
		}
		if (awayParticipant.getCfgParticipant() != null) {
			message.append("\n Participante AWAY del partido: id = ");
			message.append(awayParticipant.getCfgParticipant().getObjectId()
					.toString());
			message.append(" , name = ");
			message.append(awayParticipant.getCfgParticipant().getName(null));
		}
		message.append("\n El participante del bet: id = ");
		message.append(bet.getParticipant().getCfgParticipant().getObjectId()
				.toString());
		message.append(" , name = ");
		message.append(bet.getParticipant().getCfgParticipant().getName(null));
		message.append(", es de tipo: ");
		if (bet.getParticipant().isHomeParticipant()) {
			message.append("HOME");
		} else {
			message.append("AWAY");
		}
		return message.toString();
	}

}
