/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import com.comparadorad.bet.comparer.model.bet.bean.IBetType;

/**
 * The Class XmlBetType.
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class XmlBetType extends AbstractXmlData {

	/** The bet type. */
	private IBetType betType;

	/** The code. */
	private String code;

	/** The xml bet event. */
	private XmlBetEvent xmlBetEvent;

	/**
	 * Instantiates a new xml bet type.
	 */
	public XmlBetType() {
		super();
	}

	/**
	 * Instantiates a new xml bet type.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBetType(final BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml bet type.
	 * 
	 * @param pType
	 *            the type
	 */
	public XmlBetType(IBetType pType) {
		super();
		this.betType = pType;
	}

	/**
	 * Instantiates a new xml bet type.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlBetType(String pName) {
		super(pName);
	}

	/**
	 * Instantiates a new xml bet type.
	 * 
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBetType(String pName, final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
	}

	/**
	 * Instantiates a new xml bet type.
	 * 
	 * @param pName
	 *            the name
	 * @param pType
	 *            the type
	 */
	public XmlBetType(String pName, IBetType pType) {
		super(pName);
		this.betType = pType;
	}

	/**
	 * Instantiates a new xml bet type.
	 * 
	 * @param pCode
	 *            the code
	 * @param pName
	 *            the name
	 */
	public XmlBetType(final String pCode, final String pName) {
		super(pName);
		this.code = pCode;
	}

	/**
	 * Instantiates a new xml bet type.
	 * 
	 * @param pCode
	 *            the code
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBetType(final String pCode, String pName,
			final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
		this.code = pCode;
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
		XmlBetType other = (XmlBetType) obj;
		if (betType == null) {
			if (other.betType != null)
				return false;
		} else if (!betType.equals(other.betType))
			return false;
		if (xmlBetEvent == null) {
			if (other.xmlBetEvent != null)
				return false;
		} else if (!xmlBetEvent.equals(other.xmlBetEvent))
			return false;
		return true;
	}

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public IBetType getBetType() {
		return betType;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the xml bet event.
	 * 
	 * @return the xml bet event
	 */
	public XmlBetEvent getXmlBetEvent() {
		return xmlBetEvent;
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
		result = prime * result + ((betType == null) ? 0 : betType.hashCode());
		result = prime * result
				+ ((xmlBetEvent == null) ? 0 : xmlBetEvent.hashCode());
		return result;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param pBetType
	 *            the new bet type
	 */
	public void setBetType(IBetType pBetType) {
		betType = pBetType;
	}

	/**
	 * Sets the code.
	 * 
	 * @param pCode
	 *            the new code
	 */
	public void setCode(String pCode) {
		code = pCode;
	}

	/**
	 * Sets the xml bet event.
	 * 
	 * @param pXmlBetEvent
	 *            the new xml bet event
	 */
	public void setXmlBetEvent(XmlBetEvent pXmlBetEvent) {
		xmlBetEvent = pXmlBetEvent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData#toString
	 * ()
	 */
	@Override
	public String toString() {
		return "XmlBetType [betType=" + betType + ", code=" + code
				+ ", xmlBetEvent=" + xmlBetEvent + "]";
	}

}
