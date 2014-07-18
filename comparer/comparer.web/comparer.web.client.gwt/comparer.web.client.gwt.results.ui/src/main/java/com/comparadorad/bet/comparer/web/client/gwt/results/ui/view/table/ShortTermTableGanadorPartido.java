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
 * The Class TableBGanadorPartido.
 */
public class ShortTermTableGanadorPartido extends ShortTermTable {

	/** The col2 local. */
	private ListGridField col2Local;

	/** The col3 visitante. */
	private ListGridField col3Visitante;

	/**
	 * Instantiates a new table b ganador partido.
	 */
	public ShortTermTableGanadorPartido() {

		col2Local = new ListGridField(ColName.getCol(2), messages.local());
		col3Visitante = new ListGridField(ColName.getCol(3),
				messages.visitante());

		col1Event.setWidth(WIDTH_COL1_STANDARD + WIDTH_COL_CUOTAS);
		col2Local.setWidth(WIDTH_COL_CUOTAS);
		col3Visitante.setWidth(WIDTH_COL_CUOTAS);

		col2Local.setAlign(Alignment.CENTER);
		col3Visitante.setAlign(Alignment.CENTER);

		col2Local.setCellAlign(Alignment.LEFT);
		col3Visitante.setCellAlign(Alignment.LEFT);

		col2Local
				.setCellFormatter(getCellFormatterExternalLinkBookmakerWithOdd());
		col3Visitante
				.setCellFormatter(getCellFormatterExternalLinkBookmakerWithOdd());

	}

	/**
	 * Sets the rows.
	 * 
	 * @param rowsData
	 *            the new rows {@inheritDoc}
	 */
	@Override
	public void setRows(List<TableResponseRowTo> rowsData) {
		Log.debug("setRows");
		ShortTermTableRecord[] records = new ShortTermTableRecord[rowsData
				.size()];
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			records[rowNum] = new ShortTermTableRecord(rowData, 4);
			rowNum++;
		}
		setData(records);
	}

	/**
	 * Sets the title row.
	 * 
	 * @param pResponse
	 *            the new title row {@inheritDoc}
	 */
	@Override
	public void setTitleRow(TableResponseRowTitleTo pResponse) {
		Log.debug("setTitleRow");
		setTableBHeaderSpanTitle(pResponse);
		ListGridField[] newFields = new ListGridField[4];
		newFields[0] = col0Fecha;
		newFields[1] = col1Event;
		newFields[2] = col2Local;
		newFields[3] = col3Visitante;
		setFields(newFields);
	}

	/**
	 * Update rows.
	 * 
	 * @param rowsData
	 *            the rows data {@inheritDoc}
	 */
	@Override
	public void updateRows(List<TableResponseRowTo> rowsData) {
		Log.debug("updateRows");
		ListGridRecord[] newRecords = new ListGridRecord[rowsData.size()];
		boolean newRecordAdded = false;
		boolean recordDeleted = someRecordHasBeenDeleted(rowsData, null);
		ShortTermTableRecord record;
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			record = (ShortTermTableRecord) getRecordWithId(rowData
					.getObjectToId().getId());
			if (record == null) {
				record = new ShortTermTableRecord(rowData, 4);
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

	/** {@inheritDoc} */
	@Override
	public void updateTitleRow(TableResponseRowTitleTo pResponse) {
		Log.debug("updateTitleRow");
		setTableBHeaderSpanTitle(pResponse);
	}

}
