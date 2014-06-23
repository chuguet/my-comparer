/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.validator;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.model.core.bean.annotation.SetWithAtLeastOneElement;

/**
 * The Class CollectionWithAtLeastOneElementValidator.
 */
public class SetWithAtLeastOneElementCfgBookmakerDataUrlValidator implements
		ConstraintValidator<SetWithAtLeastOneElement, Set<CfgBookmakerDataUrl>> {

	/**
	 * Initialize.
	 * 
	 * @param pConstraintAnnotation
	 *            the constraint annotation {@inheritDoc}
	 */
	@Override
	public void initialize(SetWithAtLeastOneElement pConstraintAnnotation) {
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
	public boolean isValid(Set<CfgBookmakerDataUrl> pCollection,
			ConstraintValidatorContext pContext) {
		boolean flag = false;
		if (pCollection != null && pCollection.size() >= 1) {
			flag = true;
		}
		return flag;
	}

}
