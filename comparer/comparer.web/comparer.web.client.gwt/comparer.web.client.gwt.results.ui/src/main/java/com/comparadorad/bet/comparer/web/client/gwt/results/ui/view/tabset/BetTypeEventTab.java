/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset;

/**
 * The Class BetTypeEventTab.
 */
public class BetTypeEventTab extends BetTypeTab {

	/** The Constant BET_TYPE_EVENT_ID. */
	private static final String BET_TYPE_EVENT_ID = "betTypeEventId";

	/** The id prefix. */
	private String idPrefix = "BTET";

	/**
	 * Instantiates a new bet type event tab.
	 * 
	 * @param pTitle
	 *            the title
	 * @param pId
	 *            the id
	 * @param tabSetId
	 *            the tab set id
	 */
	public BetTypeEventTab(String pTitle, String pId, String tabSetId) {
		super(pTitle, pId, tabSetId);
		setFixHash(true);
	}

	/**
	 * Gets the bet type event id.
	 * 
	 * @return the bet type event id
	 */
	public String getBetTypeEventId() {
		return getAttributeAsString(BET_TYPE_EVENT_ID);
	}

	/**
	 * Gets the id prefix.
	 * 
	 * @return the id prefix {@inheritDoc}
	 */
	@Override
	public String getIdPrefix() {
		return this.idPrefix;
	}

	/**
	 * Sets the bet type event id.
	 * 
	 * @param betTypeEventId
	 *            the new bet type event id
	 */
	public void setBetTypeEventId(String betTypeEventId) {
		setAttribute(BET_TYPE_EVENT_ID, betTypeEventId);
	}

	/**
	 * Sets the id prefix.
	 * 
	 * @param pIdPrefix
	 *            the new id prefix {@inheritDoc}
	 */
	@Override
	public void setIdPrefix(String pIdPrefix) {
		this.idPrefix = pIdPrefix;
	}

}
