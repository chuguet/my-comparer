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

import com.comparadorad.bet.comparer.model.core.bean.validator.SetWithAtLeastOneElementValidator;

/**
 * The Interface SetWithAtLeastOneElement.
 */
@NotNull
@Constraint(validatedBy = { SetWithAtLeastOneElementValidator.class })
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SetWithAtLeastOneElement {

	/**
	 * Groups.
	 * 
	 * @return the class[]
	 */
	Class<?>[] groups() default {};

	/**
	 * Message.
	 * 
	 * @return the string
	 */
	String message() default "{oneElement.message}";

	/**
	 * Payload.
	 * 
	 * @return the class[]
	 */
	Class<? extends Payload>[] payload() default {};

}
