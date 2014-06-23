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
 * The Enum MasMenos.
 */
public enum MasMenos implements INameIdEnum {

	/** The MENOS. */
	MENOS("Menos"),

	/** The MAS. */
	MAS("Mas");
	
	private final String nameId;

	public String getNameId() {
		return nameId;
	}
	
	MasMenos(String nameId) {
		this.nameId = nameId;
	}

	@Override
	public String nameId() {
		return nameId;
	}
	
}
