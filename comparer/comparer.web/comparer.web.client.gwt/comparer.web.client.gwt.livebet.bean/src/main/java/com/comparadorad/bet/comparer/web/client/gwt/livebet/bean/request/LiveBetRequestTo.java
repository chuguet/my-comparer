/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.livebet.bean.request;

import java.util.Date;

import com.comparadorad.bet.comparer.web.client.gwt.core.bean.AbstractClientToRequest;

/**
 * The Class LiveBetRequest.
 */
public class LiveBetRequestTo extends AbstractClientToRequest {

	/** The date. */
	private Date date = null;

	/**
	 * Instantiates a new live bet request to.
	 */
	public LiveBetRequestTo() {
		super();
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param pDate
	 *            the new date
	 */
	public void setDate(Date pDate) {
		date = pDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LiveBetRequestTo other = (LiveBetRequestTo) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LiveBetRequestTo [date=" + date + "]";
	}
	
	

}
