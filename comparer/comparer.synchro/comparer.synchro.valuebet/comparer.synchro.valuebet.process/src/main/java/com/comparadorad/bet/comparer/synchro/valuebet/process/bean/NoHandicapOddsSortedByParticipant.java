/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.bean;

import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;

/**
 * The Class NoHandicapOddsSortedByParticipant.
 */
public class NoHandicapOddsSortedByParticipant extends OddsSortedBy {

	/** The participant. */
	private RtParticipant participant;

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoHandicapOddsSortedByParticipant other = (NoHandicapOddsSortedByParticipant) obj;
		if (participant == null) {
			if (other.participant != null)
				return false;
		} else if (!participant.equals(other.participant))
			return false;
		return true;
	}

	/**
	 * Gets the participant.
	 * 
	 * @return the participant
	 */
	public RtParticipant getParticipant() {
		return participant;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((participant == null) ? 0 : participant.hashCode());
		return result;
	}

	/**
	 * Sets the participant.
	 * 
	 * @param participant
	 *            the new participant
	 */
	public void setParticipant(RtParticipant participant) {
		this.participant = participant;
	}

}
