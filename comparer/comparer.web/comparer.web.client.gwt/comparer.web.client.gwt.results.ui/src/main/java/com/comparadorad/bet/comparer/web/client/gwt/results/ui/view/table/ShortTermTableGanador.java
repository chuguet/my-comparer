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
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * The Class TableBGanador.
 */
public class ShortTermTableGanador extends ShortTermTable {

	/** The Constant CELL_HEIGHT. */
	protected static final int CELL_HEIGHT = 40;

	/** The Constant EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS. */
	protected final static int EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS = 55;

	/** The Constant MAX_NUM_PARTICIPANTES. */
	protected final static int MAX_NUM_PARTICIPANTES = 3;

	/** The second header span. */
	protected HeaderSpan secondHeaderSpan;

	/** The special col width. */
	private boolean specialColWidth;

	/**
	 * Instantiates a new table b ganador.
	 */
	public ShortTermTableGanador() {
		col0Fecha.setFrozen(true);
		col1Event.setFrozen(true);
		setCellHeight(CELL_HEIGHT);

		secondHeaderSpan = new HeaderSpan();
		// setFields("") para que el headerSpan no tenga sus fields a null. (Si
		// estan a null lanza un error JavaScript en runtime por intentar
		// acceder a la propiedad 'length' de los fields
		secondHeaderSpan.setFields("");
		secondHeaderSpan.setTitle(messages.ganador());
		secondHeaderSpan.setName("secondHeaderSpan");
		secondHeaderSpan.setAlign(Alignment.CENTER);
		setHeaderSpans(headerSpan, secondHeaderSpan);
	}

	/**
	 * Sets the column widths.
	 * 
	 * @param numParticipants
	 *            the new column widths
	 */
	private void setColumnWidths(int numParticipants) {
		int factor = MAX_NUM_PARTICIPANTES - numParticipants;
		if (specialColWidth) {
			col0Fecha.setWidth(WIDTH_COL0_SPECIAL
					+ EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS * factor);
			col1Event.setWidth(WIDTH_COL1_SPECIAL
					+ EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS * factor);
		} else {
			col0Fecha.setWidth(WIDTH_COL0_STANDARD
					+ EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS * factor);
			col1Event.setWidth(WIDTH_COL1_STANDARD
					+ EXTRA_COL_WIDTH_IF_LESSER_THAN_3_PARTICIPANTS * factor);
		}
	}

	/**
	 * Sets the rows.
	 * 
	 * @param rowsData
	 *            the new rows {@inheritDoc}
	 */
	@Override
	public void setRows(final List<TableResponseRowTo> rowsData) {
		setTitleRowWithRowDataInformation(rowsData);
		Log.debug("setRows");
		ShortTermTableRecord[] records = new ShortTermTableRecord[rowsData
				.size()];
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			records[rowNum] = new ShortTermTableRecord(rowData, rowData
					.getCellList().size());
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
	public void setTitleRow(final TableResponseRowTitleTo pResponse) {
		Log.debug("setTitleRow");
		specialColWidth = setTableBHeaderSpanTitle(pResponse);
	}

	/**
	 * Sets the title row with row data information.
	 * 
	 * @param response
	 *            the new title row with row data information
	 */
	private void setTitleRowWithRowDataInformation(
			List<TableResponseRowTo> response) {
		Log.debug("setTitleRowWithRowDataInformation");
		int numCols = response.get(0).getCellList().size();
		int numParticipantes = response.get(0).getCellList().size() - 2;
		setColumnWidths(numParticipantes);
		ListGridField[] newFields = new ListGridField[numCols];
		String[] colSpans = new String[numParticipantes];
		newFields[0] = col0Fecha;
		newFields[1] = col1Event;
		for (int i = 0, colNum = 2; i < numParticipantes; i++, colNum++) {
			ListGridField field = new ListGridField(ColName.getCol(colNum));
			field.setWidth(WIDTH_COL_CUOTAS);
			field.setAlign(Alignment.CENTER);
			field.setCellAlign(Alignment.LEFT);
			field.setCellFormatter(getCellFormatterExtLinkBookmakerWithOddAndParticipant());
			newFields[colNum] = field;
			colSpans[i] = ColName.getCol(colNum);
		}
		secondHeaderSpan.setFields(colSpans);
		setFields(newFields);
	}

	/**
	 * Update rows.
	 * 
	 * @param rowsData
	 *            the rows data {@inheritDoc}
	 */
	@Override
	public void updateRows(final List<TableResponseRowTo> rowsData) {
		setTitleRowWithRowDataInformation(rowsData);
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
				record = new ShortTermTableRecord(rowData, rowData
						.getCellList().size());
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
	public void updateTitleRow(final TableResponseRowTitleTo pResponse) {
		Log.debug("updateTitleRow");
		setTitleRow(pResponse);
	}

}
