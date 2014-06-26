/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.repository.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * The Class ValidationObjectException.
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class ValidationObjectException extends RuntimeException {

	/** The constraint violations. */
	private Set constraintViolations;

	/**
	 * Instantiates a new validation object exception.
	 * 
	 * @param pConstraintViolations
	 *            the constraint violations
	 */
	public ValidationObjectException(Set pConstraintViolations) {
		super();
		constraintViolations = pConstraintViolations;
	}

	/**
	 * Gets the constraint violations.
	 * 
	 * @return the constraint violations
	 */
	public Set getConstraintViolations() {
		return constraintViolations;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message {@inheritDoc}
	 */
	@Override
	public String getMessage() {
		StringBuffer message = new StringBuffer();
		message.append("Error in object validation. Errors:");
		int index = 0;
		for (Object violation : constraintViolations) {
			if (violation instanceof ConstraintViolation) {
				message.append(" Error ").append(index).append(" [");
				message.append("\"")
						.append(((ConstraintViolation) violation)
								.getPropertyPath()).append("\" ");
				message.append(((ConstraintViolation) violation).getMessage())
						.append("]");
				index++;
			}
		}
		return message.toString();
	}
}
