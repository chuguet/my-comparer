/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.view;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;

/**
 * The Class ValueBetTable.
 */
public class ValueBetTable extends GenericTable {

	/** The Constant celdaNormal. */
	private static final String celdaNormal = "valueCeldaNormal";

	/** The Constant celdaNormalClick. */
	private static final String celdaNormalClick = "valueCeldaNormalClick";

	/** The Constant celdaSubrayadoClick. */
	private static final String celdaSubrayadoClick = "valueCeldaSubrayadoClick";

	/** The Constant CELL_HEIGHT. */
	private static final int CELL_HEIGHT = 90;

	/** The Constant colTitles. */
	private static final String[] colTitles = { messages.evento(), messages.tipoDeApuesta(), messages.resultado(),
			messages.casasDeApuestas(), messages.cuotas(), messages.probabilidad(), messages.esperanza() };

	/** The Constant HEIGHT_BOOKMAKER_IMG. */
	private static final int HEIGHT_BOOKMAKER_IMG = 20;

	/** The Constant WIDTH. */
	private static final int WIDTH = 872;

	/** The Constant WIDTH_BOOKMAKER_IMG. */
	private static final int WIDTH_BOOKMAKER_IMG = 105;

	/** The Constant WIDTH_COL0. */
	private static final int WIDTH_COL0 = 250;

	/** The Constant WIDTH_COL1. */
	private static final int WIDTH_COL1 = 120;

	/** The Constant WIDTH_COL2. */
	private static final int WIDTH_COL2 = 142;

	/** The Constant WIDTH_COL3. */
	private static final int WIDTH_COL3 = 120;

	/** The Constant WIDTH_COL4. */
	private static final int WIDTH_COL4 = 80;

	/** The Constant WIDTH_COL5. */
	private static final int WIDTH_COL5 = 80;

	/** The Constant WIDTH_COL6. */
	private static final int WIDTH_COL6 = 80;

	/** The col0 event. */
	private ListGridField col0Event;

	/** The col1 bet type. */
	private ListGridField col1BetType;

	/** The col2 result. */
	private ListGridField col2Result;

	/** The col3 bookmaker. */
	private ListGridField col3Bookmaker;

	/** The col4 quotas. */
	private ListGridField col4Quotas;

	/** The col5 probability. */
	private ListGridField col5Probability;

	/** The col6 esperanza. */
	private ListGridField col6Esperanza;

	/** The Constant MIN_HEIGHT. */
	private static final int MIN_HEIGHT = 100;

	/** The fields. */
	private ListGridField[] fields;

	/**
	 * Instantiates a new value bet table.
	 */
	public ValueBetTable() {

		setWidth(WIDTH);
		setHeight(MIN_HEIGHT);
		setCellHeight(CELL_HEIGHT);

		setOverflow(Overflow.HIDDEN);
		setBodyOverflow(Overflow.HIDDEN);

		setAutoFitData(Autofit.VERTICAL);

		setShowAllRecords(true);
		setLeaveScrollbarGap(false);
		setCanSort(false);
		setCanDragResize(false);
		setShowHeaderContextMenu(false);
		setShowRollOver(false);
		setShowSelectedStyle(false);

		col0Event = new ListGridField(ColName.getCol(0), colTitles[0]);
		col1BetType = new ListGridField(ColName.getCol(1), colTitles[1]);
		col2Result = new ListGridField(ColName.getCol(2), colTitles[2]);
		col3Bookmaker = new ListGridField(ColName.getCol(3), colTitles[3]);
		col4Quotas = new ListGridField(ColName.getCol(4), colTitles[4]);
		col5Probability = new ListGridField(ColName.getCol(5), colTitles[5]);
		col6Esperanza = new ListGridField(ColName.getCol(6), colTitles[6]);
		fields = new ListGridField[] { col0Event, col1BetType, col2Result, col3Bookmaker, col4Quotas, col5Probability, col6Esperanza };

		col0Event.setCanDragResize(false);
		col1BetType.setCanDragResize(false);
		col2Result.setCanDragResize(false);
		col3Bookmaker.setCanDragResize(false);
		col4Quotas.setCanDragResize(false);
		col5Probability.setCanDragResize(false);
		col6Esperanza.setCanDragResize(false);

		col1BetType.setAlign(Alignment.CENTER);
		col2Result.setAlign(Alignment.CENTER);
		col3Bookmaker.setAlign(Alignment.CENTER);
		col4Quotas.setAlign(Alignment.CENTER);
		col5Probability.setAlign(Alignment.CENTER);
		col6Esperanza.setAlign(Alignment.CENTER);

		col0Event.setWidth(WIDTH_COL0);
		col1BetType.setWidth(WIDTH_COL1);
		col2Result.setWidth(WIDTH_COL2);
		col3Bookmaker.setWidth(WIDTH_COL3);
		col4Quotas.setWidth(WIDTH_COL4);
		col5Probability.setWidth(WIDTH_COL5);
		col6Esperanza.setWidth(WIDTH_COL6);

		col0Event.setCellFormatter(getCellFormatterIntLinkWithDate());
		col3Bookmaker.setType(ListGridFieldType.IMAGE);
		col3Bookmaker.setImageHeight(HEIGHT_BOOKMAKER_IMG);
		col3Bookmaker.setImageWidth(WIDTH_BOOKMAKER_IMG);

		addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent pEvent) {
				int colNum = pEvent.getColNum();
				GenericRecord record = (GenericRecord) pEvent.getRecord();
				if (colNum == 0) {
					onInternalLinkClickRedirect(pEvent, InternalLinkEventNames.VALUE_BET_MATCH_EVENT);
				}
				if (colNum == 3 || colNum == 4) {
					onExternalLinkClick(record.getExtLinkUrl(getFieldName(colNum)),
							record.getExtLinkCategoryAnalytics(getFieldName(colNum)),
							record.getExtLinkActionAnalytics((getFieldName(colNum))));
				}
			}
		});

		addCellContextClickHandler(new CellContextClickHandler() {
			@Override
			public void onCellContextClick(CellContextClickEvent pEvent) {
				if (pEvent.getColNum() == 0) {
					showInternalLinkContextMenu(pEvent, InternalLinkEventNames.VALUE_BET_MATCH_EVENT);
				} else if (pEvent.getColNum() == 3 || pEvent.getColNum() == 4) {
					showExternalLinkContextMenu(pEvent);
				} else {
					setContextMenu(null);
				}
			}
		});

		setFields(fields);

	}

	/**
	 * Gets the base style.
	 * 
	 * @param record
	 *            the record
	 * @param rowNum
	 *            the row num
	 * @param colNum
	 *            the col num
	 * @return the base style {@inheritDoc}
	 */
	@Override
	protected String getBaseStyle(ListGridRecord record, int rowNum, int colNum) {
		if (colNum == 0) {
			return celdaSubrayadoClick;
		} else if (colNum == 3 || colNum == 4) {
			return celdaNormalClick;
		} else {
			return celdaNormal;
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
		Log.debug("setRows");
		RecordValueBet[] records = new RecordValueBet[rowsData.size()];
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			RecordValueBet record = new RecordValueBet(rowData);
			records[rowNum] = record;
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
	public void setTitleRow(final TableResponseRowTitleTo pResponse) {
	}

	/**
	 * Update rows.
	 * 
	 * @param rowsData
	 *            the rows data {@inheritDoc}
	 */
	@Override
	public void updateRows(final List<TableResponseRowTo> rowsData) {
		Log.debug("updateRows");
		RecordValueBet[] newRecords = new RecordValueBet[rowsData.size()];
		int rowNum = 0;
		boolean newRecordAdded = false;
		boolean recordDeleted = someRecordHasBeenDeleted(rowsData, null);
		boolean individualCellUpdate = false;
		RecordValueBet record;
		rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			if (rowData.getObjectToId() != null) {
				record = (RecordValueBet) getRecordWithId(rowData.getObjectToId().getId());
			} else {
				record = (RecordValueBet) getRecordWithId(null);
			}
			if (record == null) {
				record = new RecordValueBet(rowData);
				newRecordAdded = true;
			}
			individualCellUpdate = !newRecordAdded && !recordDeleted;
			List<Integer> cellNumsToUpdate = record.update(rowData);
			if (individualCellUpdate) {
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

	/**
	 * Update title row.
	 * 
	 * @param pTitleRowData
	 *            the title row data {@inheritDoc}
	 */
	@Override
	public void updateTitleRow(TableResponseRowTitleTo pTitleRowData) {
	}

}
