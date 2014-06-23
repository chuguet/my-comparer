/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import com.comparadorad.bet.comparer.model.core.bean.INameIdEnum;

/**
 * The Enum AsianResult.
 */
public enum AsianResult implements INameIdEnum{

	/** The ONE. */
	ONE("1"),

	/** The TWO. */
	TWO("2");
	
	private final String nameId;
	
	AsianResult(String nameId) {
		this.nameId = nameId;
	}

	public String getNameId() {
		return nameId;
	}

	@Override
	public String nameId() {
		return nameId;
	}

}
