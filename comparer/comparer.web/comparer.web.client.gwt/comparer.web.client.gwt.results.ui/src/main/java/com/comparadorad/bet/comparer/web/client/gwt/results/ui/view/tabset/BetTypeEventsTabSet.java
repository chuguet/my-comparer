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

/**
 * The Class BetTypeEventsTabSet.
 */
public class BetTypeEventsTabSet extends BetTypeTabSet {

	/** The id prefix. */
	protected String idPrefix = "BTETS";

	/**
	 * Instantiates a new bet type events tab set.
	 * 
	 * @param pId
	 *            the id
	 */
	public BetTypeEventsTabSet(String pId) {
		super(pId);
	}

	/** {@inheritDoc} */
	@Override
	public String getIdPrefix() {
		return this.idPrefix;
	}

	/**
	 * Load tabs with bet type event id.
	 * 
	 * @param tabResponseTo
	 *            the tab response to
	 * @param betTypeId
	 *            the bet type id
	 * @param tabSetId
	 *            the tab set id
	 */
	public void loadTabsWithBetTypeEventId(TabResponseTo tabResponseTo,
			String betTypeId, String tabSetId) {
		for (final TabResponseDataTo tabData : tabResponseTo.getTabs()) {
			final BetTypeEventTab tab = new BetTypeEventTab(tabData.getName(),
					tabData.getId().getId(), tabSetId);
			Log.debug("betTypeEventId = " + tab.getID());
			tab.setWidth(100);
			tab.setBetTypeId(betTypeId);
			tab.setBetTypeEventId(tabData.getId().getId());
			addTab(tab);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void setIdPrefix(String pIdPrefix) {
		this.idPrefix = pIdPrefix;
	}

}
