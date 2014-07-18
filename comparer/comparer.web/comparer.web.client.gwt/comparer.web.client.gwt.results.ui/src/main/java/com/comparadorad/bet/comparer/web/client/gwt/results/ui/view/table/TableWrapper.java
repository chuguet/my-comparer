/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

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
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.Type;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.View;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class TableWrapper.
 */
public class TableWrapper extends VLayout {

	/** The Constant MIN_HEIGHT. */
	private static final int MIN_HEIGHT = 1;

	/** The bet type. */
	private BetType betType;

	/** The bet type event. */
	private String betTypeEvent;

	/** The table factory. */
	private TableFactory tableFactory = new TableFactory();

	/** The table map. */
	private Map<String, GenericTable> tableMap;

	/** The table positions. */
	private Map<String, Integer> tablePositions;

	/** The table refresh service. */
	private AbstractTableRefreshService tableRefreshService;

	/** The type. */
	private Type type;

	/** The view. */
	private View view;

	// En el constructor definimos las variables que definan el tipo de tabla
	// que este wrapper contendrá
	/**
	 * Instantiates a new table wrapper.
	 * 
	 * @param pView
	 *            the view
	 * @param pType
	 *            the type
	 * @param pBetType
	 *            the bet type
	 * @param pBetTypeEvent
	 *            the bet type event
	 */
	public TableWrapper(final View pView, final Type pType,
			final BetType pBetType, final String pBetTypeEvent) {
		view = pView;
		type = pType;
		betType = pBetType;
		betTypeEvent = pBetTypeEvent;
		tableMap = new HashMap<String, GenericTable>();
		tablePositions = new HashMap<String, Integer>();
		// El height a 1 px funciona como height minimo cuando se combina con
		// Overflow.VISIBLE. Si no especificamos ningún height y el height de
		// las tablas dentro del TableWrapper es menor de 100px, TableWrapper se
		// genera con height 100 por defecto a pesar de esto
		setHeight(MIN_HEIGHT);
		setOverflow(Overflow.VISIBLE);
	}

	/**
	 * Adds the and delete tables.
	 * 
	 * @param pResponse
	 *            the response
	 */
	public void addAndDeleteTables(final List<TableResponseTo> pResponse) {
		Log.debug("Inicio addAndDeleteTables");
		List<String> tableIds = new ArrayList<String>();
		int position = 0;
		for (TableResponseTo response : pResponse) {
			// Anadir nueva tabla
			if (tableMap.get(response.getObjectToId().getId()) == null) {
				Log.debug(new StringBuffer()
						.append("Creamos una nueva tabla con id: ")
						.append(response.getObjectToId().getId()).toString());
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
			}
		}
		for (String id : arrayIds) {
			Log.debug(new StringBuffer().append("Borramos tabla con id: ")
					.append(id).toString());
			removeTable(id);
		}
		Log.debug("Fin addAndDeleteTables");
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
		Log.debug("createTable");
		boolean uniqueTable = false;
		if (position == null) {
			position = 0;
			uniqueTable = true;
		}
		String tableId = pResponse.getObjectToId().getId();
		GenericTable table = tableFactory.createTable(view, type, betType);
		addMember(table, position);
		tableMap.put(tableId, table);
		tablePositions.put(tableId, position);
		tableRefreshService.setTableMap(tableMap);
		tableRefreshService.loadTableFirstTime(pResponse);
		if (uniqueTable) {
			startTimer();
		}
	}

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public BetType getBetType() {
		return betType;
	}

	/**
	 * Gets the bet type event.
	 * 
	 * @return the bet type event
	 */
	public String getBetTypeEvent() {
		return betTypeEvent;
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
		GenericTable table = (GenericTable) tableMap.get(tableId);
		removeMember(table);
		tableMap.remove(tableId);
		tableRefreshService.setTableMap(tableMap);
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param pBetType
	 *            the new bet type
	 */
	public void setBetType(BetType pBetType) {
		betType = pBetType;
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
