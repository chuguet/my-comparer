/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.IMakeTable;

/**
 * The Interface IMakeTableEvent.
 */
public interface IMakeTableEvent extends IMakeTable {

	/**
	 * Make table.
	 * 
	 * @param match
	 *            the match
	 * @param informationWindow
	 *            the information window
	 * @return the table response to
	 */
	List<TableResponseTo> makeTable(RtMatch match, InformationWindow informationWindow, String betTypeEventId);
}
