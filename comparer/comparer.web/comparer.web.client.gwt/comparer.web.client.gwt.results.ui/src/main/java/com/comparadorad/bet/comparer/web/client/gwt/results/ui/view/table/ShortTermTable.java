/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;

/**
 * The Class TableB.
 */
public class ShortTermTable extends GenericTable {

	/** The Constant CELL_STYLE_COL_0. */
	protected final static String CELL_STYLE_COL_0 = "resShortTermTableCeldaFecha";

	/** The Constant CELL_STYLE_COL_1. */
	protected final static String CELL_STYLE_COL_1 = "resShortTermTableCeldaLinkEvento";

	/** The Constant CELL_STYLE_COL_2. */
	protected final static String CELL_STYLE_COL_EVEN = "resShortTermTableCeldaOscuro";

	/** The Constant CELL_STYLE_COL_NORMAL. */
	protected final static String CELL_STYLE_COL_NORMAL = "resShortTermTableCeldaNormal";

	/** The Constant CELL_STYLE_COL_3. */
	protected final static String CELL_STYLE_COL_ODD = "resShortTermTableCeldaClaro";

	/** The Constant EVENT_COL_INDEX. */
	private static final int EVENT_COL_INDEX = 1;

	/** The Constant HEADER_HEIGHT. */
	protected static final int HEADER_HEIGHT = 22;

	/**
	 * The Constant HEADER_SPAN_HEIGHT. Para que no suelte ningun error
	 * JavaScript de tipo: "Refuse to draw: heigh is zero or null" dejamos 1 px
	 * en el header de la tabla
	 */
	protected static final int HEADER_SPAN_HEIGHT = 21;

	/** The Constant HEADER_SPAN_NAME. */
	private final static String HEADER_SPAN_NAME = "headerSpan";

	/** The Constant MIN_HEIGHT. */
	private static final int MIN_HEIGHT = 1;

	/** The Constant NUM_STATIC_COL. */
	protected static final int NUM_STATIC_COL = 2;

	/** The Constant WIDTH. */
	protected static final int WIDTH = 680;

	/** The Constant WIDTH_COL_CUOTAS. */
	protected static final int WIDTH_COL_CUOTAS = 110;

	/** The Constant WIDTH_COL0_SPECIAL. */
	protected static final int WIDTH_COL0_SPECIAL = 95;

	/** The Constant WIDTH_COL0. */
	protected static final int WIDTH_COL0_STANDARD = 85;

	/** The Constant WIDTH_COL1_SPECIAL. */
	protected static final int WIDTH_COL1_SPECIAL = 255;

	/** The Constant WIDTH_COL1_STANDARD. */
	protected static final int WIDTH_COL1_STANDARD = 265;

	/** The col0. */
	protected ListGridField col0Fecha;

	/** The col1 event. */
	protected ListGridField col1Event;

	/** The header span. */
	protected HeaderSpan headerSpan;

	/**
	 * Instantiates a new table b.
	 */
	public ShortTermTable() {

		setHeaderHeight(HEADER_HEIGHT);
		setHeaderSpanHeight(HEADER_SPAN_HEIGHT);
		setWidth(WIDTH);
		setHeight(MIN_HEIGHT);
		setAutoFitData(Autofit.VERTICAL);
		setOverflow(Overflow.HIDDEN);
		setBodyOverflow(Overflow.HIDDEN);
		setAlternateRecordStyles(false);
		setShowAllRecords(true);
		setLeaveScrollbarGap(false);
		setCanSort(false);
		setShowRollOver(false);
		setShowSelectedStyle(false);

		col0Fecha = new ListGridField(ColName.getCol(0));
		col1Event = new ListGridField(ColName.getCol(1));

		col0Fecha.setWidth(WIDTH_COL0_STANDARD);
		col1Event.setWidth(WIDTH_COL1_STANDARD);

		col0Fecha.setAlign(Alignment.LEFT);
		col1Event.setAlign(Alignment.LEFT);

		addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent pEvent) {
				GenericRecord record = (GenericRecord) pEvent.getRecord();
				if (pEvent.getColNum() == EVENT_COL_INDEX) {
					onInternalLinkClick(pEvent, pEvent.getColNum(),
							InternalLinkEventNames.RESULTS_MATCH_EVENT);
				} else if (pEvent.getColNum() >= NUM_STATIC_COL) {
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
				if (pEvent.getColNum() == EVENT_COL_INDEX) {
					showInternalLinkContextMenu(pEvent,
							InternalLinkEventNames.RESULTS_MATCH_EVENT);
				} else if (pEvent.getColNum() >= NUM_STATIC_COL) {
					showExternalLinkContextMenu(pEvent);
				} else {
					setContextMenu(null);
				}
			}

		});

		headerSpan = new HeaderSpan("", new String[] { ColName.getCol(0),
				ColName.getCol(1) });
		headerSpan.setName(HEADER_SPAN_NAME);
		headerSpan.setAlign(Alignment.LEFT);

		setHeaderSpans(headerSpan);
		setFields(col0Fecha, col1Event);
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
		} else if (colNum % 2 == 0) {
			return CELL_STYLE_COL_EVEN;
		} else if (colNum % 2 != 0) {
			return CELL_STYLE_COL_ODD;
		} else {
			return CELL_STYLE_COL_NORMAL;
		}
	}

	/**
	 * Sets the rows.
	 * 
	 * @param pRowsData
	 *            the new rows {@inheritDoc}
	 */
	@Override
	public void setRows(List<TableResponseRowTo> pRowsData) {
	}

	/**
	 * Sets the table b header span title.
	 * 
	 * @param pResponse
	 *            the response
	 * @return true, if successful
	 */
	protected boolean setTableBHeaderSpanTitle(TableResponseRowTitleTo pResponse) {
		boolean specialColWidth = false;
		if (pResponse.getCellList().get(0).getValueTo().getDate() != null) {
			setHeaderSpanTitle(HEADER_SPAN_NAME, pResponse.getCellList().get(0)
					.getValueTo().getDate());
		} else {
			specialColWidth = true;
			StringBuffer sb = new StringBuffer();
			sb.append(messages.tipoDeApuesta());
			sb.append(": ");
			if (pResponse.getCellList().get(0).getValueTo() != null) {
				sb.append(pResponse.getCellList().get(0).getValueTo()
						.getValueStr());
			}
			setHeaderSpanTitle(HEADER_SPAN_NAME, sb.toString());
			col0Fecha.setWidth(WIDTH_COL0_SPECIAL);
			col1Event.setWidth(WIDTH_COL1_SPECIAL);
		}

		return specialColWidth;
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
	 * @param pRowsData
	 *            the rows data {@inheritDoc}
	 */
	@Override
	public void updateRows(List<TableResponseRowTo> pRowsData) {
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
