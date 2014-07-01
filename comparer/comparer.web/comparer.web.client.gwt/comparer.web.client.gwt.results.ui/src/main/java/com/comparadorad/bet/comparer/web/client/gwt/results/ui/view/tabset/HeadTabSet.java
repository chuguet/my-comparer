/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Side;

/**
 * The Class HeadTabSet.
 */
public class HeadTabSet extends ResultsTabSet {

	/** The Constant ID_PREFIX. */
	private static final String ID_PREFIX = "HTS";

	/** The Constant MIN_HEIGHT. */
	private static final int MIN_HEIGHT = 50;

	/** The Constant WIDTH. */
	private static final int WIDTH = 680;

	/**
	 * Instantiates a new head tab set.
	 * 
	 * @param id
	 *            the id
	 */
	public HeadTabSet(String id) {
		super(id, ID_PREFIX);
		setWidth(WIDTH);
		setHeight(MIN_HEIGHT);
		setOverflow(Overflow.VISIBLE);
		setPaneContainerOverflow(Overflow.VISIBLE);
		setTabBarPosition(Side.TOP);
		setPaneMargin(0);
		setPadding(0);
		setUseSimpleTabs(true);
	}

}
