/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean.validator;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.comparadorad.bet.comparer.model.core.bean.annotation.SetWithAtLeastTwoElement;

/**
 * The Class CollectionWithAtLeastTwoElementValidator.
 */
public class SetWithAtLeastTwoElementValidator implements
		ConstraintValidator<SetWithAtLeastTwoElement, Set<?>> {

	/**
	 * Initialize.
	 * 
	 * @param pConstraintAnnotation
	 *            the constraint annotation {@inheritDoc}
	 */
	@Override
	public void initialize(SetWithAtLeastTwoElement pConstraintAnnotation) {
		// TODO Auto-generated method stub
	}

	/**
	 * Checks if is valid.
	 * 
	 * @param pCollection
	 *            the collection
	 * @param pContext
	 *            the context
	 * @return true, if is valid {@inheritDoc}
	 */
	@Override
	public boolean isValid(Set<?> pCollection,
			ConstraintValidatorContext pContext) {
		boolean flag = false;
		if (pCollection != null && pCollection.size() >= 2) {
			flag = true;
		}
		return flag;
	}

}
