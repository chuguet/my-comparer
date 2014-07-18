/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class TableResponseToComparator.
 */
public class TableResponseToCompetitionComparator implements
		Comparator<TableResponseTo> {

	private static final Log LOG = LogFactory
			.getLog(TableResponseToCompetitionComparator.class);

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"dd/MM/yyyy");

	/** {@inheritDoc} */
	@Override
	public int compare(TableResponseTo pTable1, TableResponseTo pTable2) {
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = DATE_FORMATTER.parse(pTable1.getTitle().getCellList()
					.get(0).getValueTo().getDate());
			date2 = DATE_FORMATTER.parse(pTable2.getTitle().getCellList()
					.get(0).getValueTo().getDate());
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		}
		return date1.compareTo(date2);
	}
}
