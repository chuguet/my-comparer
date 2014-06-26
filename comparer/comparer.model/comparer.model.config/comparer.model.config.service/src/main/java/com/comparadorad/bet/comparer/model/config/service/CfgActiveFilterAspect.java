/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.core.service.AbstractActiveFilterAspect;

/**
 * The Class CfgActiveFilterAspect. This class filter all the services, and
 * deletes in the result all the inactive rows.
 */
@Aspect
@Component
class CfgActiveFilterAspect extends AbstractActiveFilterAspect {

	/** {@inheritDoc} */
	@AfterReturning(pointcut = "execution(* com.comparadorad.bet.comparer.model.core.service.AbstractGenericCrudService.*(..))"
			+ "|| execution(* com.comparadorad.bet.comparer.model.config.service.*Service.*(..))", returning = "result")
	@Override
	public void filterActiveAfterReturning(JoinPoint joinPoint, Object result) {
		super.filterActiveAfterReturning(joinPoint, result);
	}
}
