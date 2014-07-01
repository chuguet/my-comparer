/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset;

import com.smartgwt.client.widgets.Canvas;

/**
 * The Class BetTypeTab.
 */
public class BetTypeTab extends ResultsTab {

	/** The Constant BET_TYPE_ID. */
	private static final String BET_TYPE_ID = "betTypeId";

	/** The Constant ID_PREFIX. */
	private static final String ID_PREFIX = "BTT";

	/** The child. */
	private Canvas child;

	/** The loaded. */
	private boolean loaded;

	/**
	 * Instantiates a new bet type tab.
	 * 
	 * @param pTitle
	 *            the title
	 * @param pId
	 *            the id
	 * @param tabSetId
	 *            the tab set id
	 */
	public BetTypeTab(final String pTitle, final String pId,
			final String tabSetId) {
		super(pId, tabSetId, ID_PREFIX);
		setTitle(pTitle);
		loaded = false;
	}

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id
	 */
	public String getBetTypeId() {
		return getAttributeAsString(BET_TYPE_ID);
	}

	/**
	 * Gets the child.
	 * 
	 * @return the child
	 */
	public Canvas getChild() {
		return child;
	}

	/**
	 * Checks if is loaded.
	 * 
	 * @return true, if is loaded
	 */
	public boolean isLoaded() {
		return loaded;
	}

	/**
	 * Load special content.
	 */
	public void loadSpecialContent() {

	}

	/**
	 * Sets the bet type id.
	 * 
	 * @param id
	 *            the new bet type id
	 */
	public void setBetTypeId(String id) {
		setAttribute(BET_TYPE_ID, id);
	}

	/**
	 * Sets the child.
	 * 
	 * @param pChild
	 *            the new child
	 */
	public void setChild(Canvas pChild) {
		child = pChild;
	}

	/**
	 * Sets the loaded.
	 * 
	 * @param pLoaded
	 *            the new loaded
	 */
	public void setLoaded(boolean pLoaded) {
		loaded = pLoaded;
	}

}
