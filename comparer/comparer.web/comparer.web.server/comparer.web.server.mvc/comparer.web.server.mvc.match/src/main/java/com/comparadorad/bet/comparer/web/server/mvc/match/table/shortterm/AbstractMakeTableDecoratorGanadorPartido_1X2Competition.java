/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;
import com.comparadorad.bet.comparer.web.server.mvc.match.comparator.TableResponseToCompetitionComparator;

/**
 * The Class AbstractMakeTableDecoratorGanadorPartido_1X2Competition.
 */
public abstract class AbstractMakeTableDecoratorGanadorPartido_1X2Competition
		extends AbstractMakeTableDecoratorGanadorPartido_1X2 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.
	 * AbstractMakeTableShortTerm#getFechaHora(java.util.Date,
	 * java.util.TimeZone, java.util.Locale)
	 */
	protected String getFechaHora(Date date, TimeZone timeZone, Locale locale) {
		Date dateAux = DateUtilJava
				.convertSistemDependentDateToDesiredTimeZone(date, timeZone);
		return DateUtilJava.timeToString(dateAux);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.
	 * AbstractMakeTableShortTerm#getTitle(java.util.List, java.util.TimeZone,
	 * java.util.Locale)
	 */
	protected TableResponseRowTitleTo getTitle(List<RtMatch> matchs,
			final TimeZone timeZone, Locale locale) {
		TableResponseRowTitleTo row = new TableResponseRowTitleTo();

		String date = getFecha(matchs.iterator().next(), timeZone);

		List<TableResponseCellTo> cells = new ArrayList<TableResponseCellTo>();
		TableResponseCellTo cell = createCellDate(date);
		cells.add(cell);

		row.setCellList(cells);

		return row;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.table.shortterm.
	 * AbstractMakeTableShortTerm#sortTables(java.util.List, java.util.Locale)
	 */
	protected List<TableResponseTo> sortTables(
			List<TableResponseTo> listTableResponseTo, Locale locale) {
		Collections.sort(listTableResponseTo,
				new TableResponseToCompetitionComparator());
		return listTableResponseTo;
	}
}
