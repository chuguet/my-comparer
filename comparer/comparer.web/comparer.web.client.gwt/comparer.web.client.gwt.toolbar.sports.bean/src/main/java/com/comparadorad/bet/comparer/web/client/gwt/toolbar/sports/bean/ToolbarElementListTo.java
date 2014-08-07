/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ToolbarElementListTo.
 */
public class ToolbarElementListTo {

	/** The sport type list. */
	private List<ToolbarElementTo> toolbarElementList;

	/**
	 * Adds the.
	 * 
	 * @param pElement
	 *            the element
	 * @return true, if adds the
	 */
	public boolean add(ToolbarElementTo pElement) {
		if (toolbarElementList == null) {
			toolbarElementList = new ArrayList<ToolbarElementTo>();
		}
		return toolbarElementList.add(pElement);
	}

	/**
	 * Gets the sport type list.
	 * 
	 * @return the sport type list
	 */
	public List<ToolbarElementTo> getToolbarElementList() {
		return toolbarElementList;
	}

	/**
	 * Sets the sport type list.
	 * 
	 * @param pSportList
	 *            the sport type list
	 */
	public void setToolbarElementList(List<ToolbarElementTo> pSportList) {
		toolbarElementList = pSportList;
	}
}
