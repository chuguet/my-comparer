/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean;

import java.util.List;

/**
 * The Class ValueTo.
 */
public class ValueTo {

	/** The date. */
	private String date;

	/** The list value str. */
	private List<String> listValueStr;

	/** The literal. */
	private String literal;

	/** The value. */
	private String valueStr;

	/**
	 * Instantiates a new value to.
	 */
	public ValueTo() {
		super();
	}

	/**
	 * Instantiates a new value to.
	 * 
	 * @param obj
	 *            the obj
	 */
	@SuppressWarnings("unchecked")
	public ValueTo(Object obj) {
		if (obj instanceof String) {
			this.valueStr = obj.toString();
		} else if (obj instanceof List) {
			this.listValueStr = (List<String>) obj;
		}
	}

	/**
	 * Instantiates a new value to.
	 * 
	 * @param literal
	 *            the literal
	 */
	public ValueTo(String literal) {
		super();
		this.literal = literal;
	}

	/**
	 * Instantiates a new value to.
	 * 
	 * @param pDate
	 *            the date
	 * @param pValue
	 *            the value
	 */
	public ValueTo(String pDate, String pValue) {
		super();
		date = pDate;
		valueStr = pValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueTo other = (ValueTo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (listValueStr == null) {
			if (other.listValueStr != null)
				return false;
		} else if (!listValueStr.equals(other.listValueStr))
			return false;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		if (valueStr == null) {
			if (other.valueStr != null)
				return false;
		} else if (!valueStr.equals(other.valueStr))
			return false;
		return true;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the list value str.
	 * 
	 * @return the list value str
	 */
	public List<String> getListValueStr() {
		return listValueStr;
	}

	/**
	 * Gets the literal.
	 * 
	 * @return the literal
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValueStr() {
		return valueStr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((listValueStr == null) ? 0 : listValueStr.hashCode());
		result = prime * result + ((literal == null) ? 0 : literal.hashCode());
		result = prime * result
				+ ((valueStr == null) ? 0 : valueStr.hashCode());
		return result;
	}

	/**
	 * Sets the date.
	 * 
	 * @param pDate
	 *            the new date
	 */
	public void setDate(String pDate) {
		date = pDate;
	}

	/**
	 * Sets the list value str.
	 * 
	 * @param listValueStr
	 *            the new list value str
	 */
	public void setListValueStr(List<String> listValueStr) {
		this.listValueStr = listValueStr;
	}

	/**
	 * Sets the literal.
	 * 
	 * @param literal
	 *            the new literal
	 */
	public void setLiteral(String literal) {
		this.literal = literal;
	}

	/**
	 * Sets the value.
	 * 
	 * @param pValue
	 *            the new value
	 */
	public void setValueStr(String pValue) {
		valueStr = pValue;
	}

}
