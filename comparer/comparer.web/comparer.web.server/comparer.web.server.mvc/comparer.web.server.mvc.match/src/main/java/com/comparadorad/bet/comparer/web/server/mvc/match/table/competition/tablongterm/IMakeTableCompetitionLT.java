/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.tablongterm;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.IMakeTable;

/**
 * The Interface IMakeTableCompetitionLT.
 */
public interface IMakeTableCompetitionLT extends IMakeTable {

	/**
	 * Make table.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param informationWindow
	 *            the information window
	 * @return the table response to
	 */
	TableResponseTo makeTable(RtMatch match,
			InformationWindow informationWindow);
}
