/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * The Class TableBUnoXDos.
 */
public class ShortTermTableUnoXDos extends ShortTermTable {

	/** The col2 local. */
	private ListGridField col2Local;

	/** The col3 empate. */
	private ListGridField col3Empate;

	/** The col4 visitante. */
	private ListGridField col4Visitante;

	/**
	 * Instantiates a new table b uno x dos.
	 */
	public ShortTermTableUnoXDos() {

		col2Local = new ListGridField(ColName.getCol(2), messages.local());
		col3Empate = new ListGridField(ColName.getCol(3), messages.empate());
		col4Visitante = new ListGridField(ColName.getCol(4),
				messages.visitante());

		col2Local.setWidth(WIDTH_COL_CUOTAS);
		col3Empate.setWidth(WIDTH_COL_CUOTAS);
		col4Visitante.setWidth(WIDTH_COL_CUOTAS);

		col2Local.setAlign(Alignment.CENTER);
		col3Empate.setAlign(Alignment.CENTER);
		col4Visitante.setAlign(Alignment.CENTER);

		col2Local.setCellAlign(Alignment.LEFT);
		col3Empate.setCellAlign(Alignment.LEFT);
		col4Visitante.setCellAlign(Alignment.LEFT);

		col2Local
				.setCellFormatter(getCellFormatterExternalLinkBookmakerWithOdd());
		col3Empate
				.setCellFormatter(getCellFormatterExternalLinkBookmakerWithOdd());
		col4Visitante
				.setCellFormatter(getCellFormatterExternalLinkBookmakerWithOdd());

	}

	/** {@inheritDoc} */
	@Override
	public void setRows(List<TableResponseRowTo> rowsData) {
		Log.debug("setRows");
		ShortTermTableRecord[] records = new ShortTermTableRecord[rowsData.size()];
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			records[rowNum] = new ShortTermTableRecord(rowData, 5);
			rowNum++;
		}
		setData(records);
	}

	/** {@inheritDoc} */
	@Override
	public void setTitleRow(TableResponseRowTitleTo pResponse) {
		Log.debug("setTitleRow");
		setTableBHeaderSpanTitle(pResponse);
		ListGridField[] newFields = new ListGridField[5];
		newFields[0] = col0Fecha;
		newFields[1] = col1Event;
		newFields[2] = col2Local;
		newFields[3] = col3Empate;
		newFields[4] = col4Visitante;
		setFields(newFields);
	}
	
	@Override
	public void updateTitleRow(TableResponseRowTitleTo pResponse) {
		Log.debug("updateTitleRow");
		setTableBHeaderSpanTitle(pResponse);
	}

	/** {@inheritDoc} */
	@Override
	public void updateRows(List<TableResponseRowTo> rowsData) {
		Log.debug("updateRows");
		ListGridRecord[] newRecords = new ListGridRecord[rowsData.size()];
		boolean newRecordAdded = false;
		boolean recordDeleted = someRecordHasBeenDeleted(rowsData, null);
		ShortTermTableRecord record;
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			record = (ShortTermTableRecord) getRecordWithId(rowData.getObjectToId()
					.getId());
			if (record == null) {
				record = new ShortTermTableRecord(rowData, 5);
				newRecordAdded = true;
			} else {
				List<Integer> cellNumsToUpdate = record.update(rowData);
				if (!newRecordAdded && !recordDeleted) {
					updateCells(cellNumsToUpdate, rowNum);
				}
			}
			newRecords[rowNum] = record;
			rowNum++;
		}
		if (newRecordAdded || recordDeleted) {
			Log.debug("setData");
			setData(newRecords);
		}
	}

}
