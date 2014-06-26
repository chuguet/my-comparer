/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.core.repository.exception.ValidationObjectException;

/**
 * The Class InvalidMarketsException.
 */
@SuppressWarnings("serial")
public class InvalidMarketsException extends ValidationObjectException {

	/** The constraint violations. */
	private Set<ConstraintViolation<RtMatch>> constraintViolations;

	/** The rt match. */
	private RtMatch rtMatch;

	/**
	 * Instantiates a new invalid markets exception.
	 * 
	 * @param pConstraintViolations
	 *            the constraint violations
	 */
	public InvalidMarketsException(
			Set<ConstraintViolation<RtMatch>> pConstraintViolations) {
		super(pConstraintViolations);
		constraintViolations = pConstraintViolations;
	}

	/**
	 * Instantiates a new invalid markets exception.
	 * 
	 * @param pConstraintViolations
	 *            the constraint violations
	 * @param pRtMatch
	 *            the rt match
	 */
	public InvalidMarketsException(
			Set<ConstraintViolation<RtMatch>> pConstraintViolations,
			RtMatch pRtMatch) {
		super(pConstraintViolations);
		constraintViolations = pConstraintViolations;
		rtMatch = pRtMatch;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message {@inheritDoc}
	 */
	@Override
	public String getMessage() {
		StringBuffer message = new StringBuffer();
		message.append("[Validator] Hay ");
		message.append(constraintViolations.size());
		message.append(" mercados invalidos en el partido con nombre: ");
		message.append(rtMatch.getName(null));
		message.append(" del deporte: ");
		message.append(rtMatch.getMatchId().getCompetition().getSport()
				.getName(null));
		message.append(" y de la competicion: ");
		message.append(rtMatch.getMatchId().getCompetition().getName(null));
		message.append(". Los msg de error son los siguientes: ");
		int index = 1;
		for (ConstraintViolation<RtMatch> violation : constraintViolations) {
			message.append("\n Error ").append(index).append(" [");
			message.append(violation.getMessage());
			message.append("]");
			index++;
		}
		return message.toString();
	}

}
