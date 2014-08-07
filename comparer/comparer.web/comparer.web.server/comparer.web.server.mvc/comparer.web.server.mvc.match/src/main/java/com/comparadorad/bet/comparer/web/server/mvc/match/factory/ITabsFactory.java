/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.factory;

import com.comparadorad.bet.comparer.web.server.mvc.match.enums.BetTypesView;
import com.comparadorad.bet.comparer.web.server.mvc.match.tabs.IMakeTabs;

/**
 * The Interface IMakeTabs.
 */
public interface ITabsFactory {

	/**
	 * Gets the make tabs.
	 * 
	 * @param betTypesView
	 *            the bet types view
	 * @return the make tabs
	 */
	IMakeTabs getMakeTabs(BetTypesView betTypesView);
}
