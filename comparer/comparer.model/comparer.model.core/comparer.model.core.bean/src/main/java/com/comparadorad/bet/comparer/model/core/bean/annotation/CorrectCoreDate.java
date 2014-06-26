/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

import com.comparadorad.bet.comparer.model.core.bean.validator.CoreDateValidator;

/**
 * The Interface CorrectCoreDate.
 */
@NotNull
@Constraint(validatedBy = { CoreDateValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrectCoreDate {

	/**
	 * Message.
	 * 
	 */
	public abstract String message() default "{correctCoreDate.message}";

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
