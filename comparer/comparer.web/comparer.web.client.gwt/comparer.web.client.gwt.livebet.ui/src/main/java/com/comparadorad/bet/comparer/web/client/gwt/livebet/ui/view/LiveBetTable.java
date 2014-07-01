/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.view;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;

/**
 * The Class LiveBetTable.
 */
public class LiveBetTable extends GenericTable {

	/** The Constant COL_0_WIDTH. */
	private static final int COL_0_WIDTH = 150;

	/** The Constant COL_1_WIDTH. */
	private static final int COL_1_WIDTH = 70;

	/** The Constant COL_2_WIDTH. */
	private static final int COL_2_WIDTH = 60;

	/** The Constant COL_3_WIDTH. */
	private static final int COL_3_WIDTH = 140;

	/** The Constant COL_4_WIDTH. */
	private static final int COL_4_WIDTH = 50;

	/** The Constant COL_5_WIDTH. */
	private static final int COL_5_WIDTH = 80;

	/** The Constant COL_6_WIDTH. */
	private static final int COL_6_WIDTH = 130;

	/** The Constant WIDTH. */
	private static final int WIDTH = 680;

	/** The add and delete table. */
	private boolean addAndDeleteTable = false;

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

	/** The colored table. */
	private boolean evenTable;

	/**
	 * Instantiates a new live bet table.
	 * 
	 * @param evenTable
	 *            the even table
	 */
	public LiveBetTable(boolean evenTable) {
		this.evenTable = evenTable;
		setWidth(WIDTH);
		setCellHeight(25);
		setAutoFitData(Autofit.VERTICAL);
		setOverflow(Overflow.HIDDEN);
		setBodyOverflow(Overflow.HIDDEN);
		setShowAllRecords(true);
		setLeaveScrollbarGap(false);
		setCanSort(false);
		setShowHeader(false);
		setShowRollOver(true);
		setAlternateRecordStyles(false);
		setShowSelectedStyle(false);
		setStyleName("proxEvTable");

		col0 = new ListGridField(ColName.getCol0());
		col1 = new ListGridField(ColName.getCol1());
		col2 = new ListGridField(ColName.getCol2());
		col3 = new ListGridField(ColName.getCol3());
		col4 = new ListGridField(ColName.getCol4());
		col5 = new ListGridField(ColName.getCol5());
		col6 = new ListGridField(ColName.getCol6());

		col0.setWidth(COL_0_WIDTH);
		col1.setWidth(COL_1_WIDTH);
		col2.setWidth(COL_2_WIDTH);
		col3.setWidth(COL_3_WIDTH);
		col4.setWidth(COL_4_WIDTH);
		col5.setWidth(COL_5_WIDTH);
		col6.setWidth(COL_6_WIDTH);

		col1.setAlign(Alignment.RIGHT);
		col2.setAlign(Alignment.RIGHT);
		col3.setAlign(Alignment.RIGHT);
		col6.setAlign(Alignment.LEFT);

		col3.setCellFormatter(getCellFormatterExtLinkBookmakerImg());

		addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent pEvent) {
				RecordLiveBet record = (RecordLiveBet) pEvent.getRecord();
				if (pEvent.getColNum() == 3 && pEvent.getRowNum() > 1) {
					onExternalLinkClick(record.getExtLinkUrl(getFieldName(pEvent.getColNum())),
							record.getExtLinkCategoryAnalytics(getFieldName(pEvent.getColNum())),
							record.getExtLinkActionAnalytics(getFieldName(pEvent.getColNum())));
					// onExternalLinkClick(record, pEvent.getColNum());
				} else if (pEvent.getRowNum() == 1) {
					onInternalLinkClick(pEvent, 0, InternalLinkEventNames.NEXT_EVENT_MATCH_EVENT);
				}
			}
		});

		addCellContextClickHandler(new CellContextClickHandler() {

			@Override
			public void onCellContextClick(CellContextClickEvent pEvent) {
				if (pEvent.getColNum() == 3 && pEvent.getRowNum() > 1) {
					showExternalLinkContextMenu(pEvent);
				} else if (pEvent.getRowNum() == 1) {
					showInternalLinkContextMenu(pEvent, InternalLinkEventNames.NEXT_EVENT_MATCH_EVENT);
				} else {
					setContextMenu(null);
				}
			}

		});

		setFields(col0, col1, col2, col3, col4, col5, col6);

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
		String styleName = "";
		if (this.evenTable) {
			styleName = "Even";
		} else {
			styleName = "Odd";
		}
		if (rowNum == 0 && colNum == 0) {
			return new StringBuffer().append("proxEvCeldaFecha").append(styleName).toString();
		} else if (rowNum == 0 && colNum == 1) {
			return new StringBuffer().append("proxEvCeldaHora").append(styleName).toString();
		} else if (rowNum == 0 && colNum == 3) {
			return new StringBuffer().append("proxEvCeldaTipoApuesta").append(styleName).toString();
		} else if (rowNum == 1) {
			return new StringBuffer().append("proxEvCeldaLinkInt").append(styleName).toString();
		} else if (rowNum > 1 && colNum == 0) {
			return new StringBuffer().append("proxEvCeldaParticipante").append(styleName).toString();
		} else if (rowNum > 1 && (colNum == 1 || colNum == 5)) {
			return new StringBuffer().append("proxEvCeldaCuotas").append(styleName).toString();
		} else if (rowNum > 1 && colNum == 2) {
			return new StringBuffer().append("proxEvCeldaEn").append(styleName).toString();
		} else if (rowNum > 1 && colNum == 3) {
			return new StringBuffer().append("proxEvCeldaImg").append(styleName).toString();
		} else if (rowNum > 1 && colNum == 4) {
			return new StringBuffer().append("proxEvCeldaGane").append(styleName).toString();
		} else if (rowNum > 1 && colNum == 6) {
			return new StringBuffer().append("proxEvCeldaPorTanSolo").append(styleName).toString();
		} else {
			return new StringBuffer().append("proxEvCeldaNormal").append(styleName).toString();
			// return super.getBaseStyle(record, rowNum, colNum);
		}
	}

	/**
	 * Gets the cell formatter ext link bookmaker img.
	 * 
	 * @return the cell formatter ext link bookmaker img
	 */
	public CellFormatter getCellFormatterExtLinkBookmakerImg() {
		return new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				if (rowNum > 1) {
					RecordLiveBet rec = (RecordLiveBet) record;
					String fieldName = getFieldName(colNum);
					if (AppProperties.getInstance().isGwtNoServer()) {
						return "<img src='images/" + rec.getExtLinkImg(fieldName) + "' width='105' height='20'>";
					} else if (AppProperties.getInstance().isLiferayEnvironment()) {
						return "<img src='" + Page.getAppImgDir() + rec.getExtLinkImg(fieldName) + "' width='105' height='20'>";
					} else
						return "";
				} else if (value != null) {
					return value.toString();
				} else {
					return "";
				}
			}
		};
	}

	/**
	 * Checks if is adds the and delete table.
	 * 
	 * @return true, if is adds the and delete table
	 */
	public boolean isAddAndDeleteTable() {
		return addAndDeleteTable;
	}

	/**
	 * Checks if is even table.
	 * 
	 * @return true, if is even table
	 */
	public boolean isEvenTable() {
		return evenTable;
	}

	/**
	 * Recalculate row id.
	 * 
	 * @param rowData
	 *            the row data
	 * @param rowNum
	 *            the row num
	 */
	private void recalculateRowId(final TableResponseRowTo rowData, final int rowNum) {
		if (rowData.getObjectToId() == null) {
			rowData.setObjectToId(new ObjectToId(Integer.toString(rowNum)));
		}
	}

	/**
	 * Sets the adds the and delete table.
	 * 
	 * @param addAndDeleteTable
	 *            the new adds the and delete table
	 */
	public void setAddAndDeleteTable(boolean addAndDeleteTable) {
		this.addAndDeleteTable = addAndDeleteTable;
	}

	/**
	 * Sets the even table.
	 * 
	 * @param evenTable
	 *            the new even table
	 */
	public void setEvenTable(boolean evenTable) {
		this.evenTable = evenTable;
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
		RecordLiveBet[] records = new RecordLiveBet[rowsData.size()];
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			RecordLiveBet record;
			if (rowNum == 0) {
				record = new FirstRecordLiveBet(rowData);
			} else if (rowNum == 1) {
				record = new SecondRecordLiveBet(rowData);
			} else {
				record = new RecordLiveBet(rowData);
			}
			recalculateRowId(rowData, rowNum);
			if (rowData.getObjectToId() != null) {
				record.setRecordId(rowData.getObjectToId().getId());
			} else {
				record.setRecordId(null);
			}
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
	public void setTitleRow(TableResponseRowTitleTo pResponse) {
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
		RecordLiveBet[] newRecords = new RecordLiveBet[rowsData.size()];
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			recalculateRowId(rowData, rowNum);
			rowNum++;
		}
		boolean newRecordAdded = false;
		boolean recordDeleted = someRecordHasBeenDeleted(rowsData, null);
		boolean individualCellUpdate = false;
		RecordLiveBet record = null;
		rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			if (rowData.getObjectToId() != null) {
				record = (RecordLiveBet) getRecordWithId(rowData.getObjectToId().getId());
			}
			if (record == null) {
				record = new RecordLiveBet(rowData);
				newRecordAdded = true;
			}
			individualCellUpdate = !newRecordAdded && !recordDeleted;
			if (record instanceof FirstRecordLiveBet) {
				List<Integer> cellNumsToUpdate = record.update(rowData);
				if (individualCellUpdate && !isAddAndDeleteTable()) {
					updateCells(cellNumsToUpdate, rowNum);
				}
			} else if (record instanceof SecondRecordLiveBet) {
				List<Integer> cellNumsToUpdate = record.update(rowData);
				if (individualCellUpdate && !isAddAndDeleteTable()) {
					updateCells(cellNumsToUpdate, rowNum);
				}
			} else if (record instanceof RecordLiveBet) {
				List<Integer> cellNumsToUpdate = record.update(rowData);
				if (individualCellUpdate && !isAddAndDeleteTable()) {
					updateCells(cellNumsToUpdate, rowNum);
				}
			}
			newRecords[rowNum] = record;
			rowNum++;
		}
		if (newRecordAdded || recordDeleted || isAddAndDeleteTable()) {
			Log.debug("setData");
			setData(newRecords);
			setAddAndDeleteTable(false); // reseteamos
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
