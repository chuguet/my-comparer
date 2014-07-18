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
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.grid.ListGridField;

/**
 * The Class DetailedTableGanadorPartido.
 */
public class DetailedTableGanadorPartido extends DetailedTable {

	/** The col2 local. */
	private ListGridField col2Local;

	/** The col3 visitante. */
	private ListGridField col3Visitante;

	/** The col4 pago. */
	private ListGridField col4Pago;

	/**
	 * Instantiates a new detailed table ganador partido.
	 */
	public DetailedTableGanadorPartido() {

		setOverflow(Overflow.HIDDEN);
		setBodyOverflow(Overflow.HIDDEN);

		col2Local = new ListGridField(ColName.getCol(2), messages.local());
		col3Visitante = new ListGridField(ColName.getCol(3),
				messages.visitante());
		col4Pago = new ListGridField(ColName.getCol(4), messages.pago());

		col0Bookmaker.setWidth(WIDTH_COL0_STANDARD + WIDTH_COL_CUOTAS);
		col2Local.setWidth(WIDTH_COL_CUOTAS);
		col3Visitante.setWidth(WIDTH_COL_CUOTAS);
		col4Pago.setWidth(WIDTH_COL_CUOTAS);

		col2Local.setAlign(Alignment.CENTER);
		col3Visitante.setAlign(Alignment.CENTER);
		col4Pago.setAlign(Alignment.CENTER);

		col2Local.setCellFormatter(getCellFormatterExtLinkWithArrow());
		col3Visitante.setCellFormatter(getCellFormatterExtLinkWithArrow());

		col2Local.setSortNormalizer(getCustomSortNormalizer());
		col3Visitante.setSortNormalizer(getCustomSortNormalizer());
		col4Pago.setSortNormalizer(getCustomSortNormalizer());

		ListGridField[] fields = new ListGridField[5];
		fields[0] = col0Bookmaker;
		fields[1] = col1Info;
		fields[2] = col2Local;
		fields[3] = col3Visitante;
		fields[4] = col4Pago;
		setFields(fields);

		addCellClickHandler(getDetailedTableCellClickHandler(1));
		addCellContextClickHandler(getDetailedTableCellContextClickHandler(1));
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
		GenericRecord[] records = new GenericRecord[rowsData.size()];
		int rowNum = 0;
		int statisticsRowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			if (rowNum < (rowsData.size() - 3)) {
				records[rowNum] = new DetailedTableRecord(rowData);
			} else {
				records[rowNum] = new DetailedTableRecordStatistics(rowData,
						Integer.toString(statisticsRowNum),
						staticRowTitles[statisticsRowNum]);
				statisticsRowNum++;
			}
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
		clearSort();
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
		GenericRecord[] newRecords = new GenericRecord[rowsData.size()];
		boolean newRecordAdded = false;
		boolean recordDeleted = someRecordHasBeenDeleted(rowsData, 3);
		GenericRecord record;
		int rowNum = 0;
		int statisticsRowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			if (rowNum < (rowsData.size() - 3)) {
				record = (DetailedTableRecord) getRecordWithId(rowData
						.getObjectToId().getId());
			} else {
				record = (DetailedTableRecordStatistics) getRecordWithId(Integer
						.toString(statisticsRowNum));
				statisticsRowNum++;
			}
			if (record == null) {
				record = new DetailedTableRecord(rowData);
				newRecordAdded = true;
			}
			List<Integer> cellNumsToUpdate = record.update(rowData);
			if (!newRecordAdded && !recordDeleted) {
				updateCells(cellNumsToUpdate, rowNum);
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
