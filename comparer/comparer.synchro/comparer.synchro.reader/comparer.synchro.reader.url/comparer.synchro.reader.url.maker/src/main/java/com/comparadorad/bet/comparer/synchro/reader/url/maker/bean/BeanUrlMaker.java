/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.bean;

import java.io.Serializable;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;

/**
 * The Class BeanUrlMaker.
 */
@SuppressWarnings("serial")
public class BeanUrlMaker implements Serializable {

	/** The url. */
	private String url;

	/** The url data types. */
	private UrlDataTypes urlDataTypes;

	/** The bean additional xml info reader. */
	private BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader;

	/**
	 * Instantiates a new bean url maker.
	 * 
	 * @param url
	 *            the url
	 * @param beanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 */
	public BeanUrlMaker(String url,
			BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader) {
		super();
		this.url = url;
		this.beanAdditionalXmlInfoReader = beanAdditionalXmlInfoReader;
	}

	/**
	 * Instantiates a new bean url maker.
	 * 
	 * @param url
	 *            the url
	 * @param beanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 * @param urlDataTypes
	 *            the url data types
	 */
	public BeanUrlMaker(String url,
			BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader,
			UrlDataTypes urlDataTypes) {
		super();
		this.url = url;
		this.beanAdditionalXmlInfoReader = beanAdditionalXmlInfoReader;
		this.urlDataTypes = urlDataTypes;
	}

	public BeanUrlMaker(String url, UrlDataTypes urlDataTypes) {
		super();
		this.url = url;
		this.urlDataTypes = urlDataTypes;
	}

	/**
	 * Gets the url data types.
	 * 
	 * @return the url data types
	 */
	public UrlDataTypes getUrlDataTypes() {
		return urlDataTypes;
	}

	/**
	 * Sets the url data types.
	 * 
	 * @param urlDataTypes
	 *            the new url data types
	 */
	public void setUrlDataTypes(UrlDataTypes urlDataTypes) {
		this.urlDataTypes = urlDataTypes;
	}

	/**
	 * Instantiates a new bean url maker.
	 */
	public BeanUrlMaker() {
		super();
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
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
