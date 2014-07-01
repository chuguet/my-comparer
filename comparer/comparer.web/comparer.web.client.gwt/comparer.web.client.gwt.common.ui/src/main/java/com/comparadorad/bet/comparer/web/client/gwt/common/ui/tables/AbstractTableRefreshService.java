/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.google.gwt.user.client.Timer;

/**
 * The Class AbstractTableRefreshService.
 */
public abstract class AbstractTableRefreshService {

	/** The Constant REFRESH_INTERVAL_MS. */
	private static final int REFRESH_INTERVAL_MS = 15000;

	/** The table map. */
	private Map<String, GenericTable> tableMap;

	/** The timer. */
	private Timer timer;

	/** The timer on. */
	private boolean timerOn;

	/** The times ignored. */
	int timesIgnored = 0;

	/**
	 * Call server to obtain table data.
	 */
	public abstract void callServerToObtainTableData();

	/**
	 * Creates the timer.
	 */
	private void createTimer() {
		timer = new Timer() {
			int numTimesIgnored = 0;
			public void run() {
				boolean allTablesDrawn = true;
				if(tableMap != null){
					Iterator<Entry<String, GenericTable>> it = tableMap.entrySet()
							.iterator();
					while (it.hasNext() && allTablesDrawn) {
						Map.Entry<String, GenericTable> entry = (Map.Entry<String, GenericTable>) it
								.next();
						GenericTable table = entry.getValue();
						if (!table.isDrawn()) {
							allTablesDrawn = false;
						}
					}
					if (allTablesDrawn) {
						if (tablesReadyForRefresh()) {
							Log.debug("Llamar servidor");
							callServerToObtainTableData();
						} else {
							Log.debug("El refresco esta en proceso, ignorando llamada al servidor");
							numTimesIgnored++;
							if (numTimesIgnored > 5) {
								cancel();
								numTimesIgnored = 0;
							}
						}
					} else {
						Log.debug("No todas las tablas han sido pintadas, ignorando llamada al servidor (llamada " + numTimesIgnored + ")");
						numTimesIgnored++;
						if (numTimesIgnored > 5) {
							Log.debug("Se cancela el refresco despues de 5 intentos de pintar las tablas");
							cancel();
							numTimesIgnored = 0;
						}
					}
				} else{
					Log.debug("Llamar servidor");
					callServerToObtainTableData();
				}
			}
		};
	}

	/**
	 * Checks if is timer on.
	 * 
	 * @return true, if is timer on
	 */
	public boolean isTimerOn() {
		return timerOn;
	}

	/**
	 * Load table first time.
	 * 
	 * @param pResponse
	 *            the response
	 */
	public void loadTableFirstTime(TableResponseTo pResponse) {
		GenericTable table = tableMap.get(pResponse.getObjectToId().getId());
		table.setTitleRow(pResponse.getTitle());
		table.setRows(pResponse.getRows());
	}

	/**
	 * Refresh table.
	 * 
	 * @param pResponseTo
	 *            the response to
	 */
	public void refreshTable(List<TableResponseTo> pResponseTo) {
		for (TableResponseTo response : pResponseTo) {
			refreshTable(response);
		}
	}

	/**
	 * Refresh table.
	 * 
	 * @param pResponseTo
	 *            the response to
	 */
	public void refreshTable(TableResponseTo pResponseTo) {
		GenericTable table = tableMap.get(pResponseTo.getObjectToId().getId());
		if (table.refreshState.getNumRefreshTries() < 5) {
			try {
				Log.debug("refrescar tabla con id = "
						+ pResponseTo.getObjectToId().getId());
				table.updateTitleRow(pResponseTo.getTitle());
				table.updateRows(pResponseTo.getRows());
				table.refreshState.finishRefreshProcess();
			} catch (RuntimeException e) {
				Log.error("Fallo al refrescar la tabla con id "
						+ pResponseTo.getObjectToId().getId()
						+ " en intento numero: "
						+ table.refreshState.getNumRefreshTries());
				table.refreshState.increaseNumRefreshTries();
				refreshTable(pResponseTo);
			}
		} else {
			Log.error("La tabla no se ha podido refrescar. Paramos el refresco.");
			// TODO lanzar exception
			stopRefreshTimer();
		}
	}

	/**
	 * Sets the table map.
	 * 
	 * @param pTableMap
	 *            the table map
	 */
	public void setTableMap(Map<String, GenericTable> pTableMap) {
		tableMap = pTableMap;
	}

	/**
	 * Start timer.
	 */
	public void startTimer() {
		Log.debug("startTimer");
		if (timer == null) {
			createTimer();
		}
		timer.scheduleRepeating(REFRESH_INTERVAL_MS);
		timerOn = true;
	}

	/**
	 * Stop refresh timer.
	 */
	public void stopRefreshTimer() {
		Log.debug("stopTimer");
		if (timer != null) {
			timer.cancel();
			timerOn = false;
			// Cerrar y resetear el proceso de refresco
			Iterator<Entry<String, GenericTable>> it = tableMap.entrySet()
					.iterator();
			it = tableMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, GenericTable> entry = (Map.Entry<String, GenericTable>) it
						.next();
				GenericTable table = entry.getValue();
				table.refreshState.resetNumRefreshTries();
				table.refreshState.finishRefreshProcess();
			}
		}
	}

	// Las tablas pueden ser refrescadas de nuevo si ninguna tabla tenga el
	// proceso de refresco activo, o si lo tenga activo, que se ha agotado
	// el numero de intentos para refrescar.
	/**
	 * Tables ready for refresh.
	 * 
	 * @return true, if successful
	 */
	protected boolean tablesReadyForRefresh() {
		boolean refreshInProcess = false;
		int minRefreshTries = 5;
		Iterator<Entry<String, GenericTable>> it = tableMap.entrySet()
				.iterator();
		while (it.hasNext() && !refreshInProcess) {
			Map.Entry<String, GenericTable> entry = (Map.Entry<String, GenericTable>) it
					.next();
			GenericTable table = entry.getValue();
			refreshInProcess = table.refreshState.isRefreshInProgress();
			if (table.refreshState.getNumRefreshTries() < minRefreshTries) {
				minRefreshTries = table.refreshState.getNumRefreshTries();
			}
		}
		if (!refreshInProcess || minRefreshTries >= 5) {
			// Resetear el estado de refresco de las tablas
			it = tableMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, GenericTable> entry = (Map.Entry<String, GenericTable>) it
						.next();
				GenericTable table = entry.getValue();
				table.refreshState.resetNumRefreshTries();
				table.refreshState.initRefreshProcess();
			}
			return true;
		} else {
			return false;
		}
	}
}
