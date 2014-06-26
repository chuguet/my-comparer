/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

/**
 * The Class XmlBookmaker.
 */
@SuppressWarnings("rawtypes")
public class XmlBookmaker extends AbstractXmlData {

	/**
	 * Instantiates a new xml bookmaker.
	 */
	public XmlBookmaker() {
		super();

	}

	/**
	 * Instantiates a new xml bookmaker.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBookmaker(BmInternalId pBmInternalId) {
		super(pBmInternalId);

	}

	/**
	 * Instantiates a new xml bookmaker.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlBookmaker(String pName) {
		super(pName);

	}

	/**
	 * Instantiates a new xml bookmaker.
	 * 
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBookmaker(String pName, BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
	}

}
