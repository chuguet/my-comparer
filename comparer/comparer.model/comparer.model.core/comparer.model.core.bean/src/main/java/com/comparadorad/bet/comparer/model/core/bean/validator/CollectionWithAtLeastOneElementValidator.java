/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean.validator;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.comparadorad.bet.comparer.model.core.bean.annotation.CollectionWithAtLeastOneElement;

/**
 * The Class CollectionWithAtLeastOneElementValidator.
 */
public class CollectionWithAtLeastOneElementValidator implements
		ConstraintValidator<CollectionWithAtLeastOneElement, Collection<?>> {

	/**
	 * Initialize.
	 * 
	 * @param pConstraintAnnotation
	 *            the constraint annotation {@inheritDoc}
	 */
	@Override
	public void initialize(CollectionWithAtLeastOneElement pConstraintAnnotation) {

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
	public boolean isValid(Collection<?> pCollection,
			ConstraintValidatorContext pContext) {
		boolean flag = false;
		if (pCollection != null && pCollection.size() >= 1) {
			flag = true;
		}
		return flag;
	}

}
