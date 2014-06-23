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
 * The Interface CorrectCoreDate.
 */
@NotNull
@Constraint(validatedBy = { MarketValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectMarket {

	/**
	 * Message.
	 * 
	 */
	public abstract String message() default "{correctMarket.message}";

	/**
	 * Groups.
	 * 
	 */
	public abstract Class<?>[] groups() default {};

	/**
	 * Payload.
	 * 
	 */
	public abstract Class<? extends Payload>[] payload() default {};

}
