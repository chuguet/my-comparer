/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tabset;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseDataTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.Side;

/**
 * The Class BetTypeTabSet.
 */
public class BetTypeTabSet extends ResultsTabSet {

	/** The Constant ID_PREFIX. */
	private static final String ID_PREFIX = "BTTS";

	/** The Constant MIN_HEIGHT. */
	private static final int MIN_HEIGHT = 50;

	/** The Constant WIDTH. */
	private static final int WIDTH = 680;

	/**
	 * Instantiates a new bet type tab set.
	 * 
	 * @param pId
	 *            the id
	 */
	public BetTypeTabSet(String pId) {
		super(pId, ID_PREFIX);
		setTabBarPosition(Side.TOP);
		setWidth(WIDTH);
		setHeight(MIN_HEIGHT);
		setOverflow(Overflow.VISIBLE);
		setPaneContainerOverflow(Overflow.VISIBLE);
		setPaneMargin(0);
		setPadding(0);
		setUseSimpleTabs(true);
	}

	/**
	 * Load tabs with bet type id.
	 * 
	 * @param tabResponseTo
	 *            the tab response to
	 * @param tabSetId
	 *            the tab set id
	 */
	public void loadTabsWithBetTypeId(TabResponseTo tabResponseTo,
			String tabSetId) {
		Log.info("loadTabsWithBetTypeId");
		int i = 0;
		for (final TabResponseDataTo tabData : tabResponseTo.getTabs()) {
			final BetTypeTab tab = new BetTypeTab(tabData.getName(), tabData
					.getId().getId(), tabSetId);
			Log.debug("tabID interno = " + tab.getID());
			tab.setWidth(100);
			tab.setBetTypeId(tabData.getId().getId());
			Log.debug("betTypeId = " + tabData.getId().getId());
			addTab(tab);
			i++;
		}
	}

}
