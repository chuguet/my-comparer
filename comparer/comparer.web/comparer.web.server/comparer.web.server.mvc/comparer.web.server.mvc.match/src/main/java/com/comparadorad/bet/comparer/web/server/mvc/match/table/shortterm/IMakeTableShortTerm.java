/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.LevelType;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.IMakeTable;

/**
 * The Interface IMakeTableShortTerm.
 */
public interface IMakeTableShortTerm extends IMakeTable {
	/**
	 * Gets the level type.
	 * 
	 * @return the level type
	 */
	LevelType getLevelType();

	/**
	 * Make table.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param informationWindow
	 *            the information window
	 * @return the list
	 */
	List<TableResponseTo> makeTable(List<RtMatch> matchs,
			InformationWindow informationWindow);
}
