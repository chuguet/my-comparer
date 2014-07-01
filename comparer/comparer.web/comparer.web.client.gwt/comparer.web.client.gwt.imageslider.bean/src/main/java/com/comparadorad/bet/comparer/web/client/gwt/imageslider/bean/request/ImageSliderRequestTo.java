/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.request;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.core.bean.AbstractClientToRequest;

/**
 * The Class ImageSliderRequestTo.
 */
public class ImageSliderRequestTo extends AbstractClientToRequest {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5651360474489971943L;

	/** The bet id. */
	private ObjectToId betTypeEventId;

	/** The bet id. */
	private ObjectToId betTypeId;

	/** The event id. */
	private ObjectToId eventId;

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id
	 */
	public ObjectToId getBetTypeId() {
		return betTypeId;
	}

	/**
	 * Gets the event id.
	 * 
	 * @return the event id
	 */
	public ObjectToId getEventId() {
		return eventId;
	}

	/**
	 * Sets the bet type id.
	 * 
	 * @param betTypeId
	 *            the new bet type id
	 */
	public void setBetTypeId(ObjectToId betTypeId) {
		this.betTypeId = betTypeId;
	}

	/**
	 * Sets the event id.
	 * 
	 * @param eventId
	 *            the new event id
	 */
	public void setEventId(ObjectToId eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the bet type event id.
	 * 
	 * @return the bet type event id
	 */
	public ObjectToId getBetTypeEventId() {
		return betTypeEventId;
	}

	/**
	 * Sets the bet type event id.
	 * 
	 * @param betTypeEventId
	 *            the new bet type event id
	 */
	public void setBetTypeEventId(ObjectToId betTypeEventId) {
		this.betTypeEventId = betTypeEventId;
	}

}
