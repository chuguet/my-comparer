/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.tabs;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.BetTypesView;

/**
 * The Interface IMakeTabs.
 */
public interface IMakeTabs {

	/**
	 * Gets the bet types view.
	 * 
	 * @return the bet types view
	 */
	BetTypesView getBetTypesView();

	/**
	 * Make tab bet type.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param userData
	 *            the user data
	 * @return the tab response to
	 */
	TabResponseTo makeTabBetType(List<RtMatch> matchs, UserData userData);

	/**
	 * Make tab bet type.
	 * 
	 * @param match
	 *            the match
	 * @param userData
	 *            the user data
	 * @return the tab response to
	 */
	TabResponseTo makeTabBetType(RtMatch match, UserData userData);
}
