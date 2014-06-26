/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.annotation.CorrectCoreDate;

/**
 * The Class DateAfterValidator.
 */
public class CoreDateValidator implements
		ConstraintValidator<CorrectCoreDate, CoreDate> {

	/** {@inheritDoc} */
	@Override
	public boolean isValid(CoreDate pCoreDate,
			ConstraintValidatorContext pContext) {
		boolean flag = false;
		if (pCoreDate != null) {
			if (pCoreDate.getZeroGmtMatchDate() != null
					|| pCoreDate.getZeroGmtMatchTimeZone() != null
					|| pCoreDate.getProviderDate() != null
					|| pCoreDate.getProviderTimeZone() != null) {
				flag = true;
			}
		}

		return flag;
	}

	@Override
	public void initialize(CorrectCoreDate pConstraintAnnotation) {
		// TODO Auto-generated method stub

	}

}
