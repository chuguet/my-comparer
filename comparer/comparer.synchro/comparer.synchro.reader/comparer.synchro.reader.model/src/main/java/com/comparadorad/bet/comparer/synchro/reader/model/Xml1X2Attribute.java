/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class XML1X2Attribute.
 */
@Component
@SuppressWarnings("serial")
public class Xml1X2Attribute extends AbstractXMLAttribute {

	/** The cfg bet type id. */
	private String cfgBetTypeId;

	/** The result. */
	private Result result;

	/**
	 * Instantiates a new xml1 x2 attribute.
	 */
	public Xml1X2Attribute() {
		super();
		this.cfgBetTypeId = CfgBetTypeId.UNO_X_DOS.nameId();
	}

	public Xml1X2Attribute(Result result) {
		super();
		this.result = result;
		this.cfgBetTypeId = CfgBetTypeId.UNO_X_DOS.nameId();
	}

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 * 
	 * @param pResult
	 *            the new result
	 */
	public void setResult(Result pResult) {
		result = pResult;
	}

	/**
	 * Gets the cfg bet type id.
	 * 
	 * @return the cfg bet type id
	 */
	public String getCfgBetTypeId() {
		return cfgBetTypeId;
	}

}
