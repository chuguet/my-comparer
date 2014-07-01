/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset;

import com.allen_sauer.gwt.log.client.Log;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

/**
 * The Class ResultsTabSet.
 */
public class ResultsTabSet extends TabSet {

	/** The clean hash. */
	private boolean cleanHash = false;

	/** The follow native tab call. */
	private boolean followNativeTabCall = false;

	/** The id. */
	protected String id;

	/** The id prefix. */
	protected String idPrefix = "TS";

	/** The has set inicial tab. */
	protected boolean inicialTabSelected = false;

	/**
	 * Instantiates a new results tab set.
	 */
	public ResultsTabSet() {

	}

	/**
	 * Instantiates a new results tab set.
	 * 
	 * @param pId
	 *            the id
	 * @param pIdPrefix
	 *            the id prefix
	 */
	public ResultsTabSet(String pId, String pIdPrefix) {
		this.idPrefix = pIdPrefix;
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
	 * Checks if is clean hash.
	 * 
	 * @return true, if is clean hash
	 */
	public boolean isCleanHash() {
		return cleanHash;
	}

	/**
	 * Checks if is follow native tab call.
	 * 
	 * @return true, if is follow native tab call
	 */
	public boolean isFollowNativeTabCall() {
		return followNativeTabCall;
	}

	/**
	 * Checks if is inicial tab selected.
	 * 
	 * @return true, if is inicial tab selected
	 */
	public boolean isInicialTabSelected() {
		return inicialTabSelected;
	}

	/**
	 * Select inicial tab.
	 * 
	 * @param tabId
	 *            the tab id
	 * @return the int
	 */
	public int selectInicialTab(String tabId) {
		int tabIndex = 0;
		if (tabId != null) {
			for (Tab tab : getTabs()) {
				ResultsTab resultsTab = (ResultsTab) tab;
				Log.debug("recorre tab idWithoutPrefix: "
						+ resultsTab.getIdWithoutPrefix());
				if (resultsTab.getIdWithoutPrefix().equalsIgnoreCase(tabId)) {
					setSelectedTab(tabIndex);
					return tabIndex;
				}
				tabIndex++;
			}
		}
		return 0;
	}

	/**
	 * Sets the clean hash.
	 * 
	 * @param pCleanHash
	 *            the new clean hash
	 */
	public void setCleanHash(boolean pCleanHash) {
		cleanHash = pCleanHash;
	}

	/**
	 * Sets the follow native tab call.
	 * 
	 * @param pFollowNativeTabCall
	 *            the new follow native tab call
	 */
	public void setFollowNativeTabCall(boolean pFollowNativeTabCall) {
		followNativeTabCall = pFollowNativeTabCall;
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

	/**
	 * Sets the inicial tab selected.
	 * 
	 * @param pInicialTabSelected
	 *            the new inicial tab selected
	 */
	public void setInicialTabSelected(boolean pInicialTabSelected) {
		inicialTabSelected = pInicialTabSelected;
	}

}
