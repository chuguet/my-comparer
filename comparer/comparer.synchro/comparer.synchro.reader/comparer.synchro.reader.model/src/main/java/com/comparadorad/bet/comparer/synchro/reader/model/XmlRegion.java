/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

/**
 * The Class XmlRegion.
 */
@SuppressWarnings("rawtypes")
public class XmlRegion extends AbstractXmlData {

	/**
	 * Instantiates a new xml sport type.
	 */
	public XmlRegion() {
		super();
	}

	/**
	 * Instantiates a new xml sport type.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlRegion(final BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml sport type.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlRegion(final String pName) {
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
	public XmlRegion(final String pName, final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
	}
}
