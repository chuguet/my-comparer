/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Class CfgSportActive.
 */
@SuppressWarnings("serial")
@Document
public class CfgSportActive implements IDocument {

	/** The sport name. */
	@Field
	private String sportName;

	/** The bets by sport allowed. */
	@Field
	private Collection<String> betsBySportAllowed;

	/**
	 * Instantiates a new cfg sport active.
	 */
	public CfgSportActive() {
		super();
	}

	/**
	 * Instantiates a new cfg sport active.
	 * 
	 * @param sportName
	 *            the sport name
	 */
	public CfgSportActive(String sportName) {
		super();
		this.sportName = sportName;
	}

	/**
	 * Gets the sport name.
	 * 
	 * @return the sport name
	 */
	public String getSportName() {
		return sportName;
	}

	/**
	 * Sets the sport name.
	 * 
	 * @param sportName
	 *            the new sport name
	 */
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	/**
	 * Gets the bets by sport allowed.
	 * 
	 * @return the bets by sport allowed
	 */
	public Collection<String> getBetsBySportAllowed() {
		return betsBySportAllowed;
	}

	/**
	 * Sets the bets by sport allowed.
	 * 
	 * @param betsBySportAllowed
	 *            the new bets by sport allowed
	 */
	public void setBetsBySportAllowed(Collection<String> betsBySportAllowed) {
		this.betsBySportAllowed = betsBySportAllowed;
	}

}