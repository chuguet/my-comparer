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
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.grid.ListGridField;

/**
 * The Class DetailedTableGanador.
 */
public class DetailedTableGanador extends DetailedTable {

	/** The Constant EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS. */
	protected final static int EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS = 45;

	/** The Constant ID_PAYOUT_FIELD. */
	protected static final String ID_PAYOUT_FIELD = "idPayoutField";

	/** The Constant MAX_NUM_PARTICIPANTS_WITHOUT_SCROLL. */
	private static final int MAX_NUM_PARTICIPANTS_WITHOUT_SCROLL = 3;

	/**
	 * Instantiates a new detailed table ganador.
	 */
	public DetailedTableGanador() {
		col0Bookmaker.setFrozen(true);
		col1Info.setFrozen(true);

		addCellClickHandler(getDetailedTableCellClickHandler(1));
		addCellContextClickHandler(getDetailedTableCellContextClickHandler(1));
	}

	/**
	 * Adjust col widths.
	 * 
	 * @param numParticipants
	 *            the num participants
	 */
	private void adjustColWidths(int numParticipants) {
		int factor = MAX_NUM_PARTICIPANTS_WITHOUT_SCROLL - numParticipants;
		col0Bookmaker.setWidth(WIDTH_COL0_STANDARD
				+ EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS * factor);
		col1Info.setWidth(WIDTH_COL1
				+ EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS * factor);
		Log.debug("WIDTH COL0 = " + WIDTH_COL0_STANDARD
				+ EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS * factor);
		Log.debug("WIDTH COL1 = " + WIDTH_COL1
				+ EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS * factor);
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
				records[rowNum] = new DetailedTableRecordGanador(rowData,
						ID_PAYOUT_FIELD);
			} else {
				records[rowNum] = new DetailedTableRecordStatisticsGanador(
						rowData, Integer.toString(statisticsRowNum),
						staticRowTitles[statisticsRowNum], ID_PAYOUT_FIELD);
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
		Log.debug("setTitleRow");
		ListGridField[] newFields = new ListGridField[pResponse.getCellList()
				.size() + 3];
		newFields[0] = col0Bookmaker;
		newFields[1] = col1Info;
		int tableColNum = 2;
		for (TableResponseCellTo cellData : pResponse.getCellList()) {
			if (getField(cellData.getId().getId()) == null) {
				// Nueva columna
				ListGridField listGridField;
				if (cellData.getValueTo() != null) {
					listGridField = new ListGridField(ColName.getCol(cellData
							.getId().getId()), cellData.getValueTo()
							.getValueStr());
				} else {
					listGridField = new ListGridField(ColName.getCol(cellData
							.getId().getId()), null);
				}

				listGridField.setWidth(90);
				listGridField.setAlign(Alignment.CENTER);
				listGridField
						.setCellFormatter(getCellFormatterExtLinkWithArrow());
				listGridField.setSortNormalizer(getCustomSortNormalizer());
				newFields[tableColNum] = listGridField;
			} else {
				// La columna ya existe, la reposicionamos
				newFields[tableColNum] = getField(cellData.getId().getId());
			}
			tableColNum++;
		}
		// Añadimos la ultima columna 'Payout'
		ListGridField colPago = new ListGridField(ID_PAYOUT_FIELD,
				messages.pago());
		colPago.setWidth(90);
		colPago.setAlign(Alignment.CENTER);
		colPago.setSortNormalizer(getCustomSortNormalizer());
		newFields[tableColNum] = colPago;
		if (pResponse.getCellList().size() < MAX_NUM_PARTICIPANTS_WITHOUT_SCROLL) {
			adjustColWidths(pResponse.getCellList().size());
		} else {
			adjustColWidths(MAX_NUM_PARTICIPANTS_WITHOUT_SCROLL);
		}

		Log.debug("clear sort");
		clearSort();
		Integer bodyScrollLeft = getBodyScrollLeft();
		if (bodyScrollLeft == null) {
			bodyScrollLeft = 0;
		}
		setFields(newFields);
		// El scroll a su posicion anterior (ya que setFields lo resetea)
		// No hacer el scroll si la tabla no contiene ninguna fila (como la
		// primera vez que llamamos setTitleRow())
		if (getRecords().length != 0) {
			Log.debug("ScrollBody");
			scrollBodyTo(bodyScrollLeft, 0);
		} else {
			Log.debug("NO scrollBody");
		}
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
				record = (DetailedTableRecordGanador) getRecordWithId(rowData
						.getObjectToId().getId());
			} else {
				record = (DetailedTableRecordStatisticsGanador) getRecordWithId(Integer
						.toString(statisticsRowNum));
				statisticsRowNum++;
			}
			if (record == null) {
				record = new DetailedTableRecordGanador(rowData,
						ID_PAYOUT_FIELD);
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
