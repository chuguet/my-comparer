/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Class CfgImageSlider.
 */
@SuppressWarnings("serial")
@Document
public class CfgImageSlider implements IDocument {

	/** The bet type. */
	@DBRef
	private CfgBetType betType;

	/** The bet type event. */
	@DBRef
	private CfgBetTypeEvent betTypeEvent;

	/** The match. */
	@Field
	private String idMatch;

	/** The image location. */
	@Field
	private String imageLocation;

	/** The match. */
	@Transient
	private RtMatch match;

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public CfgBetType getBetType() {
		return betType;
	}

	/**
	 * Gets the bet type event.
	 * 
	 * @return the bet type event
	 */
	public CfgBetTypeEvent getBetTypeEvent() {
		return betTypeEvent;
	}

	/**
	 * Gets the match.
	 * 
	 * @return the match
	 */
	public String getIdMatch() {
		return idMatch;
	}

	/**
	 * Gets the image location.
	 * 
	 * @return the image location
	 */
	public String getImageLocation() {
		return imageLocation;
	}

	/**
	 * Gets the match.
	 * 
	 * @return the match
	 */
	public RtMatch getMatch() {
		return match;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param betType
	 *            the new bet type
	 */
	public void setBetType(CfgBetType betType) {
		this.betType = betType;
	}

	/**
	 * Sets the bet type event.
	 * 
	 * @param betTypeEvent
	 *            the new bet type event
	 */
	public void setBetTypeEvent(CfgBetTypeEvent betTypeEvent) {
		this.betTypeEvent = betTypeEvent;
	}

	/**
	 * Sets the match.
	 * 
	 * @param match
	 *            the new match
	 */
	public void setIdMatch(String match) {
		this.idMatch = match;
	}

	/**
	 * Sets the image location.
	 * 
	 * @param imageLocation
	 *            the new image location
	 */
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	/**
	 * Sets the match.
	 * 
	 * @param match
	 *            the new match
	 */
	public void setMatch(RtMatch match) {
		this.match = match;
	}

}
