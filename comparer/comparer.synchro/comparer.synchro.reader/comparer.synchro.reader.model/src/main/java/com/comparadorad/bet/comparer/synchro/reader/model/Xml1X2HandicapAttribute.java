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
 * The Class XML1X2HandicapAttribute.
 */
@Component
@SuppressWarnings("serial")
public class Xml1X2HandicapAttribute extends AbstractXMLAttribute {

	/** The cfg bet type id. */
	private String cfgBetTypeId;

	/** The value. */
	private Double firstValue;

	/** The result. */
	private Result result;

	/** The second value. */
	private Double secondValue;

	/**
	 * Instantiates a new xml1 x2 handicap attribute.
	 */
	public Xml1X2HandicapAttribute() {
		super();
		this.cfgBetTypeId = CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId();
	}

	/**
	 * Instantiates a new xml1 x2 handicap attribute.
	 * 
	 * @param result
	 *            the result
	 * @param firstValue
	 *            the first value
	 */
	public Xml1X2HandicapAttribute(Result result, Double firstValue) {
		super();
		this.result = result;
		this.firstValue = firstValue;
		this.cfgBetTypeId = CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId();
	}

	/**
	 * Gets the cfg bet type id.
	 * 
	 * @return the cfg bet type id
	 */
	public String getCfgBetTypeId() {
		return cfgBetTypeId;
	}

	/**
	 * Gets the first value.
	 * 
	 * @return the first value
	 */
	public Double getFirstValue() {
		return firstValue;
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
	 * Gets the second value.
	 * 
	 * @return the second value
	 */
	public Double getSecondValue() {
		return secondValue;
	}

	/**
	 * Sets the first value.
	 * 
	 * @param firstValue
	 *            the new first value
	 */
	public void setFirstValue(Double firstValue) {
		this.firstValue = firstValue;
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
	 * Sets the second value.
	 * 
	 * @param secondValue
	 *            the new second value
	 */
	public void setSecondValue(Double secondValue) {
		this.secondValue = secondValue;
	}

}
