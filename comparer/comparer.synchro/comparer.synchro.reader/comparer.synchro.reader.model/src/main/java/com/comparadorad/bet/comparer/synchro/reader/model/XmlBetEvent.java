/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;

/**
 * The Class XmlBetEvent.
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class XmlBetEvent extends AbstractXmlData {

	/** The bet event. */
	private IBetEvent betEvent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((betEvent == null) ? 0 : betEvent.hashCode());
		return result;
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
		XmlBetEvent other = (XmlBetEvent) obj;
		if (betEvent == null) {
			if (other.betEvent != null)
				return false;
		} else if (!betEvent.equals(other.betEvent))
			return false;
		return true;
	}

	/**
	 * Instantiates a new xml bet event.
	 */
	public XmlBetEvent() {
		super();
	}

	/**
	 * Instantiates a new xml bet event.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBetEvent(final BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml bet event.
	 * 
	 * @param pEvent
	 *            the event
	 */
	public XmlBetEvent(IBetEvent pEvent) {
		super();
		this.betEvent = pEvent;
	}

	/**
	 * Instantiates a new xml bet event.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlBetEvent(String pName) {
		super(pName);
	}

	/**
	 * Instantiates a new xml bet event.
	 * 
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBetEvent(String pName, final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
	}

	/**
	 * Instantiates a new xml bet event.
	 * 
	 * @param pName
	 *            the name
	 * @param pEvent
	 *            the event
	 */
	public XmlBetEvent(String pName, IBetEvent pEvent) {
		super(pName);
		this.betEvent = pEvent;
	}

	/**
	 * Gets the bet event.
	 * 
	 * @return the bet event
	 */
	public IBetEvent getBetEvent() {
		return betEvent;
	}

	/**
	 * Sets the bet event.
	 * 
	 * @param pBetEvent
	 *            the new bet event
	 */
	public void setBetEvent(IBetEvent pBetEvent) {
		betEvent = pBetEvent;
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
		return "XmlBetEvent [betEvent=" + betEvent + "]";
	}

}
