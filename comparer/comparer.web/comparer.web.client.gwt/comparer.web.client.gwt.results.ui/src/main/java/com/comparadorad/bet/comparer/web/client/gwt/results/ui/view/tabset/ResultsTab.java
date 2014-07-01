/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset;

import com.smartgwt.client.widgets.tab.Tab;

/**
 * The Class ResultsTab.
 */
public class ResultsTab extends Tab {

	/** The fix hash. */
	private boolean fixHash = false;

	/** The id. */
	private String id;

	/** The id prefix. */
	private String idPrefix = "T";

	/**
	 * Instantiates a new results tab.
	 */
	public ResultsTab() {
		super();
	}

	/**
	 * Instantiates a new results tab.
	 * 
	 * @param pId
	 *            the id
	 * @param tabSetId
	 *            the tab set id
	 * @param pIdPrefix
	 *            the id prefix
	 */
	public ResultsTab(String pId, String tabSetId, String pIdPrefix) {
		super();
		this.idPrefix = tabSetId + pIdPrefix;
		id = new StringBuffer(idPrefix.length() + pId.length())
				.append(idPrefix).append(pId).toString();
		setID(id);
	}

	/**
	 * Gets the id prefix.
	 * 
	 * @return the id prefix
	 */
	public String getIdPrefix() {
		return idPrefix;
	}

	/**
	 * Gets the id without prefix.
	 * 
	 * @return the id without prefix
	 */
	public String getIdWithoutPrefix() {
		return id.replace(idPrefix, "");
	}

	/**
	 * Gets the id with prefix.
	 * 
	 * @return the id with prefix
	 */
	public String getIdWithPrefix() {
		return id;
	}

	/**
	 * Checks if is fix hash.
	 *
	 * @return true, if is fix hash
	 */
	public boolean isFixHash() {
		return fixHash;
	}

	/**
	 * Sets the fix hash.
	 *
	 * @param pFixHash the new fix hash
	 */
	public void setFixHash(boolean pFixHash) {
		fixHash = pFixHash;
	}

	/**
	 * Sets the id prefix.
	 * 
	 * @param pIdPrefix
	 *            the new id prefix
	 */
	public void setIdPrefix(String pIdPrefix) {
		idPrefix = pIdPrefix;
	}

}
