/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class LiveBetTableWrapper.
 */
public class LiveBetTableWrapper extends VLayout {

	/** The Constant STYLE_NAME. */
	private static final String STYLE_NAME = "proxEvTableWrapper";

	/** The Constant WIDTH. */
	private final static int WIDTH = 680;

	/** The table map. */
	private Map<String, GenericTable> tableMap;

	/** The table positions. */
	private Map<String, Integer> tablePositions;

	/** The table refresh service. */
	private AbstractTableRefreshService tableRefreshService;

	/**
	 * Instantiates a new live bet table wrapper.
	 */
	public LiveBetTableWrapper() {
		tableMap = new HashMap<String, GenericTable>();
		tablePositions = new HashMap<String, Integer>();
		setWidth(WIDTH);
		setStyleName(STYLE_NAME);
	}

	/**
	 * Adds the and delete tables.
	 * 
	 * @param pResponse
	 *            the response
	 */
	public void addAndDeleteTables(final List<TableResponseTo> pResponse) {
		Log.debug("addAndDeleteTables");
		List<String> tableIds = new ArrayList<String>();
		int position = 0;
		for (TableResponseTo response : pResponse) {
			// Anadir nueva tabla
			if (tableMap.get(response.getObjectToId().getId()) == null) {
				createTable(response, position);

				position++;
			}
			tableIds.add(response.getObjectToId().getId());
		}
		// Borrar tabla
		Iterator<Entry<String, GenericTable>> it = tableMap.entrySet()
				.iterator();
		ArrayList<String> arrayIds = new ArrayList<String>();
		while (it.hasNext()) {
			Map.Entry<String, GenericTable> entry = (Map.Entry<String, GenericTable>) it
					.next();
			if (!tableIds.contains(entry.getKey())) {
				arrayIds.add(entry.getKey());
				Log.debug("Eliminamos tabla");
			}
		}
		for (String id : arrayIds) {
			removeTable(id);
		}
		int contador = 0;
		for (TableResponseTo response : pResponse) {
			LiveBetTable table = (LiveBetTable) tableMap.get(response
					.getObjectToId().getId());
			if (contador % 2 == 0) {
				Log.error("even: " + true);
				table.setEvenTable(true);
			} else {
				Log.error("even: " + false);
				table.setEvenTable(false);
			}
			contador++;
		}
	}

	/**
	 * Creates the table.
	 * 
	 * @param pResponse
	 *            the response
	 */
	public void createTable(final List<TableResponseTo> pResponse) {
		int position = 0;
		for (TableResponseTo response : pResponse) {
			createTable(response, position);
			position++;
		}
		startTimer();
	}

	/**
	 * Creates the table.
	 * 
	 * @param pResponse
	 *            the response
	 * @param position
	 *            the position
	 */
	public void createTable(final TableResponseTo pResponse, Integer position) {
		Log.debug("createTable()");
		String tableId = pResponse.getObjectToId().getId();
		LiveBetTable table;
		if (position % 2 == 0) {
			table = new LiveBetTable(true);
		} else {
			table = new LiveBetTable(false);
		}
		addMember(table, position);
		tableMap.put(tableId, table);
		tablePositions.put(tableId, position);
		tableRefreshService.setTableMap(tableMap);
		tableRefreshService.loadTableFirstTime(pResponse);
		table.setAddAndDeleteTable(true);
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
	 * Removes the table.
	 * 
	 * @param tableId
	 *            the table id
	 */
	public void removeTable(final String tableId) {
		LiveBetTable table = (LiveBetTable) tableMap.get(tableId);
		removeMember(table);
		tableMap.remove(tableId);
		tableRefreshService.setTableMap(tableMap);
		table.setAddAndDeleteTable(true);
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
