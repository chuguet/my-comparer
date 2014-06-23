/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class PreproductionActivatorMatch.
 */
@Component
@Scope("singleton")
final class PreproductionActivatorMatch extends AbstractActivatorMatch {

	/** {@inheritDoc} */
	@Override
	public String getEnviroment() {
		return ProfileConstant.PREPRODUCTION;
	}

}
