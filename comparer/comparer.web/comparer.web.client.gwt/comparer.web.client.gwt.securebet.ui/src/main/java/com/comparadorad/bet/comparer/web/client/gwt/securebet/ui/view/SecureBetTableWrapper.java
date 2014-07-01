package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view;

import java.util.HashMap;
import java.util.Map;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.AbstractTableRefreshService;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.Pagination;
import com.smartgwt.client.widgets.layout.VLayout;

public class SecureBetTableWrapper extends VLayout {

	private Map<String, GenericTable> tableMap;
	private AbstractTableRefreshService tableRefreshService;

	public SecureBetTableWrapper() {
		tableMap = new HashMap<String, GenericTable>();
	}

	public void createTable(final TableResponseTo pResponse) {
		Log.debug("createTable()");
		String tableId = pResponse.getObjectToId().getId();
		GenericTable table = SecureBetTableFactory.getInstance().getSecureBetTable();
		addMember(table);
		tableMap.put(tableId, table);
		tableRefreshService.setTableMap(tableMap);
		tableRefreshService.loadTableFirstTime(pResponse);
		startTimer();
	}

	public void removeTable(final ObjectToId tableId, final Pagination pagination) {
		Log.debug("removeTable()");
		GenericTable table = tableMap.get(tableId.getId());
		tableMap.remove(tableId.getId());
		removeMember(table);
		removeMember(pagination);
		tableRefreshService.setTableMap(tableMap);
		startTimer();
	}
	
	public Boolean existsTable(final ObjectToId tableId){
		return tableMap.containsKey(tableId.getId());
	}
	
	public AbstractTableRefreshService getTableRefreshService() {
		return tableRefreshService;
	}

	public boolean hasLoadedTables() {
		if (tableMap.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setTableRefreshService(
			AbstractTableRefreshService abstractTableRefreshService) {
		this.tableRefreshService = abstractTableRefreshService;
	}

	public void startTimer() {
		tableRefreshService.startTimer();
	}

	public void stopTimer() {
		tableRefreshService.stopRefreshTimer();
	}

}

