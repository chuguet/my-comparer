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
 * The Class DetailedTableHandicapAsiatico.
 */
public class DetailedTableHandicapAsiatico extends DetailedTable {

	/** The col2 handicap. */
	private ListGridField col2Handicap;

	/** The col3 local. */
	private ListGridField col3Local;

	/** The col4 visitante. */
	private ListGridField col4Visitante;

	/** The col5 pago. */
	private ListGridField col5Pago;

	/**
	 * Instantiates a new detailed table handicap asiatico.
	 */
	public DetailedTableHandicapAsiatico() {

		setOverflow(Overflow.HIDDEN);
		setBodyOverflow(Overflow.HIDDEN);

		col2Handicap = new ListGridField(ColName.getCol(2), "Handicap");
		col3Local = new ListGridField(ColName.getCol(3), messages.local());
		col4Visitante = new ListGridField(ColName.getCol(4),
				messages.visitante());
		col5Pago = new ListGridField(ColName.getCol(5), messages.pago());

		col2Handicap.setWidth(WIDTH_COL_CUOTAS);
		col3Local.setWidth(WIDTH_COL_CUOTAS);
		col4Visitante.setWidth(WIDTH_COL_CUOTAS);
		col5Pago.setWidth(WIDTH_COL_CUOTAS);

		col2Handicap.setAlign(Alignment.CENTER);
		col3Local.setAlign(Alignment.CENTER);
		col4Visitante.setAlign(Alignment.CENTER);
		col5Pago.setAlign(Alignment.CENTER);

		col2Handicap.setCellFormatter(getCellFormatterExtLinkWithArrow());
		col3Local.setCellFormatter(getCellFormatterExtLinkWithArrow());
		col4Visitante.setCellFormatter(getCellFormatterExtLinkWithArrow());

		col2Handicap.setSortNormalizer(getCustomSortNormalizer());
		col3Local.setSortNormalizer(getCustomSortNormalizer());
		col4Visitante.setSortNormalizer(getCustomSortNormalizer());
		col5Pago.setSortNormalizer(getCustomSortNormalizer());

		ListGridField[] fields = new ListGridField[6];
		fields[0] = col0Bookmaker;
		fields[1] = col1Info;
		fields[2] = col2Handicap;
		fields[3] = col3Local;
		fields[4] = col4Visitante;
		fields[5] = col5Pago;
		setFields(fields);

		addCellClickHandler(getDetailedTableCellClickHandler(2));
		addCellContextClickHandler(getDetailedTableCellContextClickHandler(2));

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
				records[rowNum] = new DetailedTableRecordHandicap(rowData);
			} else {
				records[rowNum] = new DetailedTableRecordStatisticsHandicap(
						rowData, Integer.toString(statisticsRowNum),
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
				record = (DetailedTableRecordHandicap) getRecordWithId(rowData
						.getObjectToId().getId());
			} else {
				record = (DetailedTableRecordStatisticsHandicap) getRecordWithId(Integer
						.toString(statisticsRowNum));
				statisticsRowNum++;
			}
			if (record == null) {
				record = new DetailedTableRecordHandicap(rowData);
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
