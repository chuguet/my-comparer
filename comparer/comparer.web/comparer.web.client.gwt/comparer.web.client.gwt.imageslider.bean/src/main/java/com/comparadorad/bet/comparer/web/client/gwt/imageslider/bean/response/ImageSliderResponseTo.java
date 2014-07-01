/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class ImageSliderResponseTo.
 */
public class ImageSliderResponseTo {

	/** The bet type. */
	private String betType;

	/** The bet id. */
	private ObjectToId betTypeEventId;

	/** The bet id. */
	private ObjectToId betTypeId;

	/** The competition link. */
	private LinkTo competitionLink;

	/** The event date. */
	private String eventDate;

	/** The event id. */
	private ObjectToId eventId;

	/** The event link. */
	private LinkTo eventLink;

	/** The resource. */
	private ResourceTo resource;

	/** The table. */
	private TableResponseTo table;

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public String getBetType() {
		return betType;
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
	 * Gets the bet type id.
	 * 
	 * @return the bet type id
	 */
	public ObjectToId getBetTypeId() {
		return betTypeId;
	}

	/**
	 * Gets the competition link.
	 * 
	 * @return the competition link
	 */
	public LinkTo getCompetitionLink() {
		return competitionLink;
	}

	/**
	 * Gets the event date.
	 * 
	 * @return the event date
	 */
	public String getEventDate() {
		return eventDate;
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
	 * Gets the event link.
	 * 
	 * @return the event link
	 */
	public LinkTo getEventLink() {
		return eventLink;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource
	 */
	public ResourceTo getResource() {
		return resource;
	}

	/**
	 * Gets the table.
	 * 
	 * @return the table
	 */
	public TableResponseTo getTable() {
		return table;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param betType
	 *            the new bet type
	 */
	public void setBetType(String betType) {
		this.betType = betType;
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
	 * Sets the competition link.
	 * 
	 * @param pCompetitionLink
	 *            the new competition link
	 */
	public void setCompetitionLink(LinkTo pCompetitionLink) {
		this.competitionLink = pCompetitionLink;
	}

	/**
	 * Sets the event date.
	 * 
	 * @param eventDate
	 *            the new event date
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
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
	 * Sets the event link.
	 * 
	 * @param pEventLink
	 *            the new event link
	 */
	public void setEventLink(LinkTo pEventLink) {
		this.eventLink = pEventLink;
	}

	/**
	 * Sets the resource.
	 * 
	 * @param resource
	 *            the new resource
	 */
	public void setResource(ResourceTo resource) {
		this.resource = resource;
	}

	/**
	 * Sets the table.
	 * 
	 * @param table
	 *            the new table
	 */
	public void setTable(TableResponseTo table) {
		this.table = table;
	}
}
