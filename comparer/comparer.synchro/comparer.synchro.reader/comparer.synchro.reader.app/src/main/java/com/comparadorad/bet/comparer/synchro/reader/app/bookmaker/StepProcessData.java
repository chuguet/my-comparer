/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker;

import java.io.Serializable;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class StepProcessData.
 * 
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("serial")
public final class StepProcessData<T extends Serializable> implements
		Serializable {

	/** The cfg bookmaker. */
	private CfgBookmaker cfgBookmaker;

	/** The data. */
	private T data;
	
	private BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader;

	/**
	 * Instantiates a new abstract process data.
	 * 
	 * @param pCfgBookmaker
	 *            the cfg bookmaker
	 * @param pData
	 *            the data
	 */
	public StepProcessData(CfgBookmaker pCfgBookmaker, T pData) {
		super();
		cfgBookmaker = pCfgBookmaker;
		data = pData;
	}

	/**
	 * Instantiates a new step process data.
	 * 
	 * @param pData
	 *            the data
	 * @param pCfgBookmaker
	 *            the cfg bookmaker
	 */
	public StepProcessData(T pData, CfgBookmaker pCfgBookmaker) {
		super();
		data = pData;
		cfgBookmaker = pCfgBookmaker;
	}

	public StepProcessData(CfgBookmaker cfgBookmaker2,
			T pXmldataFiles,
			BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) {
		super();
		data = pXmldataFiles;
		beanAdditionalXmlInfoReader = pBeanAdditionalXmlInfoReader;
		cfgBookmaker = cfgBookmaker2;
	}

	/**
	 * Gets the cfg bookmaker.
	 * 
	 * @return the cfg bookmaker
	 */
	public CfgBookmaker getCfgBookmaker() {
		return cfgBookmaker;
	}

	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the cfg bookmaker.
	 * 
	 * @param pCfgBookmaker
	 *            the new cfg bookmaker
	 */
	public void setCfgBookmaker(CfgBookmaker pCfgBookmaker) {
		cfgBookmaker = pCfgBookmaker;
	}

	/**
	 * Sets the data.
	 * 
	 * @param pData
	 *            the data
	 */
	public void setData(T pData) {
		data = pData;
	}

	public BeanAdditionalXmlInfoReader getBeanAdditionalXmlInfoReader() {
		return beanAdditionalXmlInfoReader;
	}

	public void setBeanAdditionalXmlInfoReader(
			BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader) {
		this.beanAdditionalXmlInfoReader = beanAdditionalXmlInfoReader;
	}
	
	

}
