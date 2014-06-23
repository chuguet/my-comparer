/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.bet.bean.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

/**
 * The Interface AllContainsName.
 */
@NotNull
@Constraint(validatedBy = ParticipantContainsNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AllContainsName {

	/**
	 * Message.
	 * 
	 * @return the string
	 */
	public abstract String message() default "{allContainsName.message}";

	/**
	 * Groups.
	 * 
	 * @return the class[]
	 */
	public abstract Class<?>[] groups() default {};

	/**
	 * Payload.
	 * 
	 * @return the class[]
	 */
	public abstract Class<? extends Payload>[] payload() default {};
}
