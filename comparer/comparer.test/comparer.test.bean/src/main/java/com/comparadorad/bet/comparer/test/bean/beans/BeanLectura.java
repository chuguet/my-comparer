/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.test.bean.beans;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Class BeanLectura.
 */
public class BeanLectura {

	/** The xml match. */
	private XmlMatch xmlMatch;

	/** The bookmaker. */
	private CfgBookmaker bookmaker;

	/**
	 * Gets the xml match.
	 * 
	 * @return the xml match
	 */
	public XmlMatch getXmlMatch() {
		return xmlMatch;
	}

	/**
	 * Sets the xml match.
	 * 
	 * @param xmlMatch
	 *            the new xml match
	 */
	public void setXmlMatch(XmlMatch xmlMatch) {
		this.xmlMatch = xmlMatch;
	}

	/**
	 * Gets the bookmaker.
	 * 
	 * @return the bookmaker
	 */
	public CfgBookmaker getBookmaker() {
		return bookmaker;
	}

	/**
	 * Sets the bookmaker.
	 * 
	 * @param bookmaker
	 *            the new bookmaker
	 */
	public void setBookmaker(CfgBookmaker bookmaker) {
		this.bookmaker = bookmaker;
	}

}
