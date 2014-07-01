/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.core.bean.AbstractClientToResponse;

/**
 * The Class TabToView.
 */
public class TabResponseTo extends AbstractClientToResponse {

	/** The tabs. */
	private List<TabResponseDataTo> tabs;

	/**
	 * Gets the tabs.
	 * 
	 * @return the tabs
	 */
	public List<TabResponseDataTo> getTabs() {
		return tabs;
	}

	/**
	 * Sets the tabs.
	 * 
	 * @param tabs
	 *            the new tabs
	 */
	public void setTabs(List<TabResponseDataTo> tabs) {
		this.tabs = tabs;
	}

	/**
	 * Adds the tab.
	 * 
	 * @param tab
	 *            the tab
	 */
	public void addTab(TabResponseDataTo tab) {
		if (tabs == null) {
			tabs = new ArrayList<TabResponseDataTo>();
		}
		tabs.add(tab);
	}

}
