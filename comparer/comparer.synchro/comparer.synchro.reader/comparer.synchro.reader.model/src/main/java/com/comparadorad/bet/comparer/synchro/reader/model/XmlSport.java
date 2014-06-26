/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

/**
 * The Class XmlSport.
 */
@SuppressWarnings("rawtypes")
public class XmlSport extends AbstractXmlData {

	/**
	 * Instantiates a new xml sport type.
	 */
	public XmlSport() {
		super();
	}

	/**
	 * Instantiates a new xml sport type.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlSport(final BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml sport type.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlSport(final String pName) {
		super(pName);
	}

	/**
	 * Instantiates a new xml sport type.
	 * 
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlSport(final String pName, final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
	}

	@Override
	public String toString() {
		return "XmlSport [getBmInternalId()=" + getBmInternalId()
				+ ", getCfgObjectId()=" + getCfgObjectId() + ", getName()="
				+ getName() + ", getParent()=" + getParent() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
