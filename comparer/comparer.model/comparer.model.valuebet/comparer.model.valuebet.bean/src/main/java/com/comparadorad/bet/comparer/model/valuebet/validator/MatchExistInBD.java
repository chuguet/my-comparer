package com.comparadorad.bet.comparer.model.valuebet.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

@NotNull
@Constraint(validatedBy = MatchValidatorExistBD.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MatchExistInBD {
	/**
	 * Message.
	 * 
	 */
	public abstract String message() default "El partido no existe en la base de datos.";

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
