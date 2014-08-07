/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.competition.tablongterm;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.InformationWindow;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.IMakeTable;

/**
 * The Interface IMakeTableLTCompetition.
 */
public interface IMakeTableLTCompetition extends IMakeTable {

	/**
	 * Make table.
	 * 
	 * @param rtMatchs
	 *            the rt matchs
	 * @param informationWindow
	 *            the information window
	 * @return the table response to
	 */
	TableResponseTo makeTable(List<RtMatch> rtMatchs,
			InformationWindow informationWindow);
}
