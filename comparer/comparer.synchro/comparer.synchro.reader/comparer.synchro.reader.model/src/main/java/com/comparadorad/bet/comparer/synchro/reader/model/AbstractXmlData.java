/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class AbstractXmlData.
 * 
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractXmlData<T extends AbstractXmlData> implements
		Serializable {

	/** The bm internal id. */
	private BmInternalId bmInternalId;

	/** The cfg object id. */
	@Field
	private BigInteger cfgObjectId;

	/** The name. */
	private String name;

	/** The parent. */
	private T parent;

	/**
	 * Instantiates a new abstract xml data.
	 */
	public AbstractXmlData() {
		super();
	}

	/**
	 * Instantiates a new abstract xml data.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public AbstractXmlData(final BmInternalId pBmInternalId) {
		super();
		bmInternalId = pBmInternalId;
	}

	/**
	 * Instantiates a new abstract xml data.
	 * 
	 * @param pName
	 *            the name
	 */
	public AbstractXmlData(final String pName) {
		super();
		this.name = pName;
	}

	/**
	 * Instantiates a new abstract xml data.
	 * 
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public AbstractXmlData(final String pName, final BmInternalId pBmInternalId) {
		super();
		bmInternalId = pBmInternalId;
		this.name = pName;
	}

	/**
	 * Gets the bm internal id.
	 * 
	 * @return the bm internal id
	 */
	public BmInternalId getBmInternalId() {
		return bmInternalId;
	}

	/**
	 * Gets the cfg object id.
	 * 
	 * @return the cfg object id
	 */
	public BigInteger getCfgObjectId() {
		return cfgObjectId;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the parent.
	 * 
	 * @return the parent
	 */
	public T getParent() {
		return parent;
	}

	/**
	 * Sets the bm internal id.
	 * 
	 * @param pBmInternalId
	 *            the new bm internal id
	 */
	public void setBmInternalId(final BmInternalId pBmInternalId) {
		bmInternalId = pBmInternalId;
	}

	/**
	 * Sets the cfg object id.
	 * 
	 * @param pCfgObjectId
	 *            the new cfg object id
	 */
	public void setCfgObjectId(BigInteger pCfgObjectId) {
		cfgObjectId = pCfgObjectId;
	}

	/**
	 * Sets the name.
	 * 
	 * @param pName
	 *            the new name
	 */
	public void setName(String pName) {
		name = pName;
	}

	/**
	 * Sets the parent.
	 * 
	 * @param pParent
	 *            the new parent
	 */
	public void setParent(T pParent) {
		parent = pParent;
	}

	@Override
	public String toString() {
		return "AbstractXmlData [bmInternalId=" + bmInternalId
				+ ", cfgObjectId=" + cfgObjectId + ", name=" + name
				+ ", parent=" + parent + "]";
	}
	
	
}