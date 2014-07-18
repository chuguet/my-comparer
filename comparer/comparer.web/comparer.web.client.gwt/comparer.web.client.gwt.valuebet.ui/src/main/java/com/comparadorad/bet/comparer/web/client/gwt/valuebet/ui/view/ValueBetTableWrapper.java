/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.view;

import java.util.HashMap;
import java.util.Map;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class ValueBetTableWrapper.
 */
public class ValueBetTableWrapper extends VLayout {

	/** The table map. */
	private Map<String, GenericTable> tableMap;

	/** The table refresh service. */
	private AbstractTableRefreshService tableRefreshService;

	/**
	 * Instantiates a new value bet table wrapper.
	 */
	public ValueBetTableWrapper() {
		tableMap = new HashMap<String, GenericTable>();
	}

	/**
	 * Creates the table.
	 * 
	 * @param pResponse
	 *            the response
	 */
	public void createTable(final TableResponseTo pResponse) {
		Log.debug("createTable()");
		String tableId = pResponse.getObjectToId().getId();
		final ValueBetTable table = new ValueBetTable();
		addMember(table);
		tableMap.put(tableId, table);
		tableRefreshService.setTableMap(tableMap);
		tableRefreshService.loadTableFirstTime(pResponse);
		startTimer();
	}

	/**
	 * Gets the table refresh service.
	 * 
	 * @return the table refresh service
	 */
	public AbstractTableRefreshService getTableRefreshService() {
		return tableRefreshService;
	}

	/**
	 * Checks for loaded tables.
	 * 
	 * @return true, if successful
	 */
	public boolean hasLoadedTables() {
		if (tableMap.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Sets the table refresh service.
	 * 
	 * @param abstractTableRefreshService
	 *            the new table refresh service
	 */
	public void setTableRefreshService(
			AbstractTableRefreshService abstractTableRefreshService) {
		this.tableRefreshService = abstractTableRefreshService;
	}

	/**
	 * Start timer.
	 */
	public void startTimer() {
		tableRefreshService.startTimer();
	}

	/**
	 * Stop timer.
	 */
	public void stopTimer() {
		tableRefreshService.stopRefreshTimer();
	}

}
