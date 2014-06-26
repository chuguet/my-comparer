/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class XMLAsianHandicapAttribute.
 */
@Component
@SuppressWarnings("serial")
public class XmlAsianHandicapAttribute extends AbstractXMLAttribute {

	/** The asian result. */
	private AsianResult asianResult;

	/** The cfg bet type id. */
	private String cfgBetTypeId;

	/** The first value. */
	private Double firstValue;

	/** The second value. */
	private Double secondValue;

	/**
	 * Instantiates a new xml asian handicap attribute.
	 */
	public XmlAsianHandicapAttribute() {
		super();
		this.cfgBetTypeId = CfgBetTypeId.HANDICAP_ASIATICO.nameId();
	}

	/**
	 * Instantiates a new xml asian handicap attribute.
	 * 
	 * @param asianResult
	 *            the asian result
	 * @param firstValue
	 *            the first value
	 */
	public XmlAsianHandicapAttribute(AsianResult asianResult, Double firstValue) {
		super();
		this.asianResult = asianResult;
		this.firstValue = firstValue;
		this.cfgBetTypeId = CfgBetTypeId.HANDICAP_ASIATICO.nameId();
	}

	/**
	 * Gets the asian result.
	 * 
	 * @return the asian result
	 */
	public AsianResult getAsianResult() {
		return asianResult;
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
	 * Gets the second value.
	 * 
	 * @return the second value
	 */
	public Double getSecondValue() {
		return secondValue;
	}

	/**
	 * Sets the asian result.
	 * 
	 * @param pAsianResult
	 *            the new asian result
	 */
	public void setAsianResult(AsianResult pAsianResult) {
		asianResult = pAsianResult;
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
	 * Sets the second value.
	 * 
	 * @param secondValue
	 *            the new second value
	 */
	public void setSecondValue(Double secondValue) {
		this.secondValue = secondValue;
	}

	/**
	 * To string.
	 * 
	 * @return the string {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "XmlAsianHandicapAttribute [cfgBetTypeId=" + cfgBetTypeId
				+ ", asianResult=" + asianResult + ", firstValue=" + firstValue
				+ ", secondValue=" + secondValue + "]";
	}

}
