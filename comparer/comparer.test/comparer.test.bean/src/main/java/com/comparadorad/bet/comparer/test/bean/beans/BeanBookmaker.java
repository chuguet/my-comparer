/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.test.bean.beans;

import java.math.BigInteger;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class BeanBookmaker.
 */
public class BeanBookmaker {

	/** The id bookmaker. */
	private BigInteger idBookmaker;

	/** The xml location. */
	private String xmlLocation;

	/** The orden bookmaker. */
	private Integer ordenBookmaker;

	/** The bookmaker. */
	private CfgBookmaker bookmaker;

	/** The bean additional xml info reader. */
	private BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader;

	/**
	 * Gets the id bookmaker.
	 * 
	 * @return the id bookmaker
	 */
	public BigInteger getIdBookmaker() {
		return idBookmaker;
	}

	/**
	 * Sets the id bookmaker.
	 * 
	 * @param idBookmaker
	 *            the new id bookmaker
	 */
	public void setIdBookmaker(BigInteger idBookmaker) {
		this.idBookmaker = idBookmaker;
	}

	/**
	 * Gets the xml location.
	 * 
	 * @return the xml location
	 */
	public String getXmlLocation() {
		return xmlLocation;
	}

	/**
	 * Sets the xml location.
	 * 
	 * @param xmlLocation
	 *            the new xml location
	 */
	public void setXmlLocation(String xmlLocation) {
		this.xmlLocation = xmlLocation;
	}

	/**
	 * Gets the orden bookmaker.
	 * 
	 * @return the orden bookmaker
	 */
	public Integer getOrdenBookmaker() {
		return ordenBookmaker;
	}

	/**
	 * Sets the orden bookmaker.
	 * 
	 * @param ordenBookmaker
	 *            the new orden bookmaker
	 */
	public void setOrdenBookmaker(Integer ordenBookmaker) {
		this.ordenBookmaker = ordenBookmaker;
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

	/**
	 * Gets the bean additional xml info reader.
	 * 
	 * @return the bean additional xml info reader
	 */
	public BeanAdditionalXmlInfoReader getBeanAdditionalXmlInfoReader() {
		return beanAdditionalXmlInfoReader;
	}

	/**
	 * Sets the bean additional xml info reader.
	 * 
	 * @param beanAdditionalXmlInfoReader
	 *            the new bean additional xml info reader
	 */
	public void setBeanAdditionalXmlInfoReader(
			BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader) {
		this.beanAdditionalXmlInfoReader = beanAdditionalXmlInfoReader;
	}

}
