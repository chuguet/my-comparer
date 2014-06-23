/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * The Class AbstractSystemExternal.
 */
@MappedSuperclass
public class AbstractSystemExternal extends AbstractRelacional  {
	
	/** The extenal system id. */
	@Basic
	@Column(nullable = true, length = 30, name = "EXTERNAL_SYSTEM_ID")
	private String extenalSystemId;

	/**
	 * Gets the extenal system id.
	 *
	 * @return the extenal system id
	 */
	public String getExtenalSystemId() {
		return extenalSystemId;
	}

	/**
	 * Sets the extenal system id.
	 *
	 * @param extenalSystemId the new extenal system id
	 */
	public void setExtenalSystemId(String extenalSystemId) {
		this.extenalSystemId = extenalSystemId;
	}	
	

}
