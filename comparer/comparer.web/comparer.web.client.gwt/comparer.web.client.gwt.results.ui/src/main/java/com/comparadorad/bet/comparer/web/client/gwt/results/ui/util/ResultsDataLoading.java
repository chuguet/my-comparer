/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.util;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.ui.WaitPopup;

/**
 * The Class DataLoading.
 */
public class ResultsDataLoading {

	/** The Constant LEFT_COORDINATE_FOR_LOADING_RESULTS_DATA. */
	protected static final int LEFT_COORDINATE_FOR_LOADING_RESULTS_DATA = 300;

	/** The Constant TOP_COORDINATE_FOR_LOADING_TAB_SET. */
	protected static final int TOP_COORDINATE_FOR_LOADING_TAB_SET = 200;

	/** The Constant TOP_COORDINATE_FOR_LOADING_TREE. */
	protected static final int TOP_COORDINATE_FOR_LOADING_TREE = 200;

	/** The wait popup. */
	private WaitPopup waitPopup = new WaitPopup();

	/**
	 * Hide loading icon.
	 */
	public void hideLoadingIcon() {
		waitPopup.hide();
	}

	/**
	 * Show loading icon.
	 */
	public void showLoadingIcon() {
		waitPopup.show();
	}

	/**
	 * Show loading icon for tab set.
	 * 
	 * @param top
	 *            the top
	 * @param left
	 *            the left
	 */
	public void showLoadingIconForTabSet(int top, int left) {
		Log.debug("top = " + top);
		Log.debug("left = " + left);
		waitPopup.show(top + TOP_COORDINATE_FOR_LOADING_TAB_SET, left
				+ LEFT_COORDINATE_FOR_LOADING_RESULTS_DATA);
	}

	/**
	 * Show loading icon for tree.
	 * 
	 * @param top
	 *            the top
	 * @param left
	 *            the left
	 */
	public void showLoadingIconForTree(int top, int left) {
		Log.debug("top = " + top);
		Log.debug("left = " + left);
		waitPopup.show(top + TOP_COORDINATE_FOR_LOADING_TREE, left
				+ LEFT_COORDINATE_FOR_LOADING_RESULTS_DATA);
	}

}
