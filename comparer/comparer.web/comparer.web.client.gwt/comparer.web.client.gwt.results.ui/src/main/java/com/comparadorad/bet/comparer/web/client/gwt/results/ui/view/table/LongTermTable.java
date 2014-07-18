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
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
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
 * The Class LongTermTable.
 */
public class LongTermTable extends GenericTable {

	/** The Constant CELL_HEIGHT. */
	private static final int CELL_HEIGHT = 22;

	/** The Constant CELL_STYLE_COL_0. */
	protected final static String CELL_STYLE_COL_0 = "resLongTermCeldaEmpty";

	/** The Constant CELL_STYLE_COL_1. */
	protected final static String CELL_STYLE_COL_1 = "resLongTermCeldaParticipant";

	/** The Constant CELL_STYLE_COL_2. */
	protected final static String CELL_STYLE_COL_2 = "resLongTermCeldaMedia";

	/** The Constant CELL_STYLE_COL_3. */
	protected final static String CELL_STYLE_COL_3 = "resLongTermCeldaMediaNum";

	/** The Constant CELL_STYLE_COL_4. */
	protected final static String CELL_STYLE_COL_4 = "resLongTermCeldaOdd";

	/** The Constant CELL_STYLE_COL_5. */
	protected final static String CELL_STYLE_COL_5 = "resLongTermCeldaAroba";

	/** The Constant CELL_STYLE_COL_6. */
	protected final static String CELL_STYLE_COL_6 = "resLongTermCeldaImgA";

	/** The Constant CELL_STYLE_COL_7. */
	protected final static String CELL_STYLE_COL_7 = "resLongTermCeldaImgB";

	/** The Constant CELL_STYLE_COL_8. */
	protected final static String CELL_STYLE_COL_8 = "resLongTermCeldaImgC";

	/** The Constant IMG_HEIGHT. */
	private static final int IMG_HEIGHT = 15;

	/** The Constant IMG_WIDTH. */
	private static final int IMG_WIDTH = 65;

	/** The Constant MIN_HEIGHT. */
	private static final int MIN_HEIGHT = 1;

	/** The Constant WIDTH. */
	private static final int WIDTH = 680;

	/** The Constant WIDTH_COL_0. */
	private static final int WIDTH_COL_0 = 210;

	/** The Constant WIDTH_COL_1. */
	private static final int WIDTH_COL_1 = 50;

	/** The Constant WIDTH_COL_2. */
	private static final int WIDTH_COL_2 = 52;

	/** The Constant WIDTH_COL_3. */
	private static final int WIDTH_COL_3 = 53;

	/** The Constant WIDTH_COL_4. */
	private static final int WIDTH_COL_4 = 30;

	/** The Constant WIDTH_COL_5. */
	private static final int WIDTH_COL_5 = 80;

	/** The Constant WIDTH_COL_6. */
	private static final int WIDTH_COL_6 = 80;

	/** The Constant WIDTH_COL_7. */
	private static final int WIDTH_COL_7 = 80;

	/** The Constant WIDTH_COL_EMPTY. */
	private static final int WIDTH_COL_EMPTY = 50;

	// Columnas estaticas

	/** The col0. */
	private ListGridField col0;

	/** The col1. */
	private ListGridField col1;

	/** The col2. */
	private ListGridField col2;

	/** The col3. */
	private ListGridField col3;

	/** The col4. */
	private ListGridField col4;

	/** The col5. */
	private ListGridField col5;

	/** The col6. */
	private ListGridField col6;

	/** The col7. */
	private ListGridField col7;

	/** The col empty. */
	private ListGridField colEmpty;

	/**
	 * Instantiates a new long term table.
	 */
	public LongTermTable() {
		setWidth(WIDTH);
		setHeight(MIN_HEIGHT);
		setCellHeight(CELL_HEIGHT);
		setAlternateRecordStyles(false);
		setShowRollOver(false);
		setShowSelectedStyle(false);
		setShowAllRecords(true);
		setAutoFitData(Autofit.VERTICAL);
		setOverflow(Overflow.HIDDEN);
		setBodyOverflow(Overflow.HIDDEN);
		setLeaveScrollbarGap(false);
		setShowHeader(false);

		addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent pEvent) {
				GenericRecord record = (GenericRecord) pEvent.getRecord();
				if (pEvent.getColNum() >= 4) {
					onExternalLinkClick(record.getExtLinkUrl(getFieldName(pEvent.getColNum())),
							record.getExtLinkCategoryAnalytics(getFieldName(pEvent.getColNum())),
							record.getExtLinkActionAnalytics(getFieldName(pEvent.getColNum())));
//					onExternalLinkClick(record, pEvent.getColNum());
				}
			}
		});

		addCellContextClickHandler(new CellContextClickHandler() {

			@Override
			public void onCellContextClick(CellContextClickEvent pEvent) {
				if (pEvent.getColNum() >= 4) {
					showExternalLinkContextMenu(pEvent);
				} else {
					setContextMenu(null);
				}
			}

		});

		colEmpty = new ListGridField(ColName.getCol("empty"));
		col0 = new ListGridField(ColName.getCol(0));
		col1 = new ListGridField(ColName.getCol(1));
		col2 = new ListGridField(ColName.getCol(2));
		col3 = new ListGridField(ColName.getCol(3));
		col4 = new ListGridField(ColName.getCol(4));
		col5 = new ListGridField(ColName.getCol(5));
		col6 = new ListGridField(ColName.getCol(6));
		col7 = new ListGridField(ColName.getCol(7));

		colEmpty.setWidth(WIDTH_COL_EMPTY);
		col0.setWidth(WIDTH_COL_0);
		col1.setWidth(WIDTH_COL_1);
		col2.setWidth(WIDTH_COL_2);
		col3.setWidth(WIDTH_COL_3);
		col4.setWidth(WIDTH_COL_4);
		col5.setWidth(WIDTH_COL_5);
		col6.setWidth(WIDTH_COL_6);
		col7.setWidth(WIDTH_COL_7);

		col0.setAlign(Alignment.LEFT);
		col1.setAlign(Alignment.CENTER);
		col2.setAlign(Alignment.LEFT);
		col3.setAlign(Alignment.RIGHT);
		col4.setAlign(Alignment.CENTER);

		col5.setType(ListGridFieldType.IMAGE);
		col6.setType(ListGridFieldType.IMAGE);
		col7.setType(ListGridFieldType.IMAGE);
		col5.setImageWidth(IMG_WIDTH);
		col6.setImageWidth(IMG_WIDTH);
		col7.setImageWidth(IMG_WIDTH);
		col5.setImageHeight(IMG_HEIGHT);
		col6.setImageHeight(IMG_HEIGHT);
		col7.setImageHeight(IMG_HEIGHT);

		setFields(colEmpty, col0, col1, col2, col3, col4, col5, col6, col7);
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
			return CELL_STYLE_COL_0;
		} else if (colNum == 1) {
			return CELL_STYLE_COL_1;
		} else if (colNum == 2) {
			return CELL_STYLE_COL_2;
		} else if (colNum == 3) {
			return CELL_STYLE_COL_3;
		} else if (colNum == 4) {
			return CELL_STYLE_COL_4;
		} else if (colNum == 5) {
			return CELL_STYLE_COL_5;
		} else if (colNum == 6) {
			return CELL_STYLE_COL_6;
		} else if (colNum == 7) {
			return CELL_STYLE_COL_7;
		} else if (colNum == 8) {
			return CELL_STYLE_COL_8;
		} else {
			return super.getBaseStyle(record, rowNum, colNum);
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
		LongTermTableRecord[] records = new LongTermTableRecord[rowsData.size()];
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			records[rowNum] = new LongTermTableRecord(rowData);
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
		GenericRecord[] newRecords = new GenericRecord[rowsData.size()];
		boolean newRecordAdded = false;
		boolean recordDeleted = someRecordHasBeenDeleted(rowsData, null);
		LongTermTableRecord record;
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			record = (LongTermTableRecord) getRecordWithId(rowData
					.getObjectToId().getId());
			if (record == null) {
				record = new LongTermTableRecord(rowData);
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
