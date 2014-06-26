package com.comparadorad.bet.comparer.model.securebet.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

@NotNull
@Constraint(validatedBy = CompetitionValidatorExistBD.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CompetitionExistInBD {
	/**
	 * Message.
	 * 
	 */
	public abstract String message() default "La competicion no existe en la base de datos.";

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
