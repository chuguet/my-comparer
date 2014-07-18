/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.grid.HeaderSpan;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.SortNormalizer;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;

/**
 * The Class TableC.
 */
public class DetailedTable extends GenericTable {

	/** The Constant celdaImagenClick. */
	protected static final String CELL_STYLE_COL_0 = "resDetailedTableCeldaBookmaker";

	/** The Constant celdaInfoClick. */
	protected static final String CELL_STYLE_COL_1 = "resDetailedTableCeldaInfo";

	/** The Constant CELL_STYLE_COL_PAGO. */
	protected static final String CELL_STYLE_COL_PAGO = "resDetailedTableCeldaPago";

	/** The Constant celdaNormalClickMasAlta. */
	protected static final String CELL_STYLE_MAX_ODD = "resDetailedTableCeldaMaxOdd";

	/** The Constant celdaNormalClick. */
	protected static final String CELL_STYLE_ODD = "resDetailedTableCeldaOdd";

	/** The Constant HEIGHT_TABLE. */
	protected static final int HEIGHT_TABLE = 100;

	/** The Constant mediaPorPronosticoStyle. */
	protected static final String ROW_STYLE_MEDIA_POR_PRONOSTICO = "resDetailedTableFilaMediaPronostico";

	/** The Constant ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_0. */
	protected static final String ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_0 = "resDetailedTableFilaMediaPronosticoCeldaBookmaker";

	/** The Constant ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_1. */
	protected static final String ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_1 = "resDetailedTableFilaMediaPronosticoCeldaInfo";

	/** The Constant ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_PAGO. */
	protected static final String ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_PAGO = "resDetailedTableFilaMediaPronosticoCeldaPago";

	/** The Constant probabilidadStyle. */
	protected static final String ROW_STYLE_PROBABILIDAD = "resDetailedTableFilaProbabilidad";

	/** The Constant ROW_STYLE_PROBABILIDAD_COL_0. */
	protected static final String ROW_STYLE_PROBABILIDAD_COL_0 = "resDetailedTableFilaProbabilidadCeldaBookmaker";

	/** The Constant ROW_STYLE_PROBABILIDAD_COL_1. */
	protected static final String ROW_STYLE_PROBABILIDAD_COL_1 = "resDetailedTableFilaProbabilidadCeldaInfo";

	/** The Constant ROW_STYLE_PROBABILIDAD_COL_PAGO. */
	protected static final String ROW_STYLE_PROBABILIDAD_COL_PAGO = "resDetailedTableFilaProbabilidadCeldaPago";

	/** The Constant valorMasAltoStyle. */
	protected static final String ROW_STYLE_VALOR_MAS_ALTO = "resDetailedTableFilaValorMasAlto";

	/** The Constant ROW_STYLE_VALOR_MAS_ALTO_COL_0. */
	protected static final String ROW_STYLE_VALOR_MAS_ALTO_COL_0 = "resDetailedTableFilaValorMasAltoCeldaBookmaker";

	/** The Constant ROW_STYLE_VALOR_MAS_ALTO_COL_1. */
	protected static final String ROW_STYLE_VALOR_MAS_ALTO_COL_1 = "resDetailedTableFilaValorMasAltoCeldaInfo";

	/** The Constant ROW_STYLE_VALOR_MAS_ALTO_COL_PAGO. */
	protected static final String ROW_STYLE_VALOR_MAS_ALTO_COL_PAGO = "resDetailedTableFilaValorMasAltoCeldaPago";

	/** The Constant WIDTH_COL_CUOTAS. */
	protected static final int WIDTH_COL_CUOTAS = 90;

	/** The Constant WIDTH_COL0_STANDARD. */
	protected static final int WIDTH_COL0_STANDARD = 260;

	/** The Constant WIDTH_COL1. */
	protected static final int WIDTH_COL1 = 60;

	/** The Constant WIDTH_TABLE. */
	protected static final int WIDTH_TABLE = 680;

	/** The col0 bookmaker. */
	protected ListGridField col0Bookmaker;

	/** The col1 info. */
	protected ListGridField col1Info;

	/** The col num best. */
	protected List<Integer> colNumBest = new ArrayList<Integer>();

	/** The header span. */
	protected HeaderSpan headerSpan;

	/** The row num best. */
	protected List<Integer> rowNumBest = new ArrayList<Integer>();

	/** The static row titles. */
	protected String[] staticRowTitles = { messages.mediaPorPronostico(), messages.valorMasAlto(), messages.probabilidad() };

	/**
	 * Instantiates a new table c.
	 */
	public DetailedTable() {
		setHeaderHeight(25);
		setHeaderSpanHeight(25);
		setWidth(WIDTH_TABLE);
		setAlternateRecordStyles(true);
		setShowAllRecords(true);
		setAutoFitData(Autofit.VERTICAL);
		setLeaveScrollbarGap(false);
		setCanSort(true);
		setShowRollOver(false);
		setScrollbarSize(360);
		setShowSelectedStyle(false);

		col0Bookmaker = new ListGridField(ColName.getCol(0));
		col1Info = new ListGridField(ColName.getCol(1));

		// Para que no suelte ningun error JavaScript de tipo: "Refuse to draw:
		// heigh is zero or null" ponemos el button del header de columna 0 y 1
		// a 1px
		Button headerButton0 = new Button();
		headerButton0.setHeight("1px");
		Button headerButton1 = new Button();
		headerButton0.setHeight("1px");
		col0Bookmaker.setHeaderButtonProperties(headerButton0);
		col1Info.setHeaderButtonProperties(headerButton1);

		col0Bookmaker.setWidth(WIDTH_COL0_STANDARD);
		col1Info.setWidth(WIDTH_COL1);

		col0Bookmaker.setAlign(Alignment.LEFT);
		col1Info.setAlign(Alignment.CENTER);

		col0Bookmaker.setCellFormatter(getCellFormatterExternalLinkBookmakerWithOdd());
		col1Info.setType(ListGridFieldType.IMAGE);

		col1Info.setCanSort(false);
		col0Bookmaker.setCanSort(false);

		headerSpan = new HeaderSpan(messages.casasDeApuestas(), new String[] { ColName.getCol(0), ColName.getCol(1) });
		setHeaderSpans(headerSpan);
		setFields(col0Bookmaker, col1Info);
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
		int numRows = getRecords().length;
		int numeroColumnas = getFields().length;
		if (rowNum == numRows - 1) {
			if (colNum == 0) {
				return ROW_STYLE_PROBABILIDAD_COL_0;
			} else if (colNum == 1) {
				return ROW_STYLE_PROBABILIDAD_COL_1;
			} else if (colNum == numeroColumnas - 1) {
				return ROW_STYLE_PROBABILIDAD_COL_PAGO;
			} else {
				return ROW_STYLE_PROBABILIDAD;
			}
		} else if (rowNum == numRows - 2) {
			if (colNum == 0) {
				return ROW_STYLE_VALOR_MAS_ALTO_COL_0;
			} else if (colNum == 1) {
				return ROW_STYLE_VALOR_MAS_ALTO_COL_1;
			} else if (colNum == numeroColumnas - 1) {
				return ROW_STYLE_VALOR_MAS_ALTO_COL_PAGO;
			} else {
				return ROW_STYLE_VALOR_MAS_ALTO;
			}
		} else if (rowNum == numRows - 3) {
			if (colNum == 0) {
				return ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_0;
			} else if (colNum == 1) {
				return ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_1;
			} else if (colNum == numeroColumnas - 1) {
				return ROW_STYLE_MEDIA_POR_PRONOSTICO_COL_PAGO;
			} else {
				return ROW_STYLE_MEDIA_POR_PRONOSTICO;
			}
		} else if (colNum == 0) {
			return (CELL_STYLE_COL_0);
		} else if (colNum == 1) {
			return (CELL_STYLE_COL_1);
		} else if (colNum >= 2 && colNum < numeroColumnas - 1) {
			GenericRecord rec = (GenericRecord) getRecord(rowNum);
			if (rec.getExtLinkText(getFieldName(colNum)) == null) {
				return CELL_STYLE_ODD;
			} else {
				String formatoCelda = "";
				formatoCelda = getMaxOddStyle(colNum, rowNum, 2);
				return formatoCelda;
			}
		} else if (colNum == numeroColumnas - 1) {
			return CELL_STYLE_COL_PAGO;
		} else {
			return super.getBaseStyle(record, rowNum, colNum);
		}

	}

	/**
	 * Gets the custom sort normalizer.
	 * 
	 * @return the custom sort normalizer
	 */
	public SortNormalizer getCustomSortNormalizer() {
		return new SortNormalizer() {
			public Object normalize(ListGridRecord record, String fieldName) {
				GenericRecord rec = (GenericRecord) record;
				if (getField(fieldName).getSortDirection().equals(SortDirection.ASCENDING)) {
					return rec.getAscendingSortValue(fieldName);
				} else if (getField(fieldName).getSortDirection().equals(SortDirection.DESCENDING)) {
					return rec.getDescendingSortValue(fieldName);
				} else {
					return "";
				}
			}
		};
	}

	/**
	 * Gets the cell click handler handicap.
	 * 
	 * @param colNumWhereBetOddsStart
	 *            the col num where bet odds start
	 * @return the cell click handler handicap
	 */
	protected CellClickHandler getDetailedTableCellClickHandler(final int colNumWhereBetOddsStart) {
		return new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent pEvent) {
				GenericRecord record = (GenericRecord) pEvent.getRecord();
				if (pEvent.getRowNum() < getRecords().length - 3) {
					if (pEvent.getColNum() == 1) {
						onInfoClick(record, pEvent.getColNum());
					} else if (pEvent.getColNum() == 0
							|| (pEvent.getColNum() > colNumWhereBetOddsStart && pEvent.getColNum() < (getFields().length - 1))) {
						onExternalLinkClick(record.getExtLinkUrl(getFieldName(pEvent.getColNum())),
								record.getExtLinkCategoryAnalytics(getFieldName(pEvent.getColNum())),
								record.getExtLinkActionAnalytics(getFieldName(pEvent.getColNum())));
//						onExternalLinkClick(record, pEvent.getColNum());
					}
				}
			}
		};
	}

	/**
	 * Gets the detailed table cell context click handler.
	 * 
	 * @param colNumWhereBetOddsStart
	 *            the col num where bet odds start
	 * @return the detailed table cell context click handler
	 */
	protected CellContextClickHandler getDetailedTableCellContextClickHandler(final int colNumWhereBetOddsStart) {
		return new CellContextClickHandler() {
			@Override
			public void onCellContextClick(CellContextClickEvent pEvent) {
				if (pEvent.getRowNum() < getRecords().length - 3
						&& (pEvent.getColNum() == 0 || (pEvent.getColNum() > colNumWhereBetOddsStart && pEvent.getColNum() < (getFields().length - 1)))) {
					showExternalLinkContextMenu(pEvent);
				} else {
					setContextMenu(null);
				}
			}
		};
	}

	/**
	 * Gets the max column odd.
	 * 
	 * @param colNum
	 *            the col num
	 * @return the max column odd
	 */
	protected Double getMaxColumnOdd(final int colNum) {
		Double result = 0.0;

		ListGridRecord[] records = getRecords();
		for (int i = 0; i < records.length - 3; i++) {
			GenericRecord rec = (GenericRecord) records[i];
			if (rec.getExtLinkText(getFieldName(colNum)) != null && Double.valueOf(rec.getExtLinkText(getFieldName(colNum))) > result) {
				result = Double.valueOf(rec.getExtLinkText(getFieldName(colNum)));
			}
		}

		return result;

	}

	/**
	 * Gets the max odd style.
	 * 
	 * @param colNum
	 *            the col num
	 * @param rowNum
	 *            the row num
	 * @param valorInicioBucle
	 *            the valor inicio bucle
	 * @return the max odd style
	 */
	protected String getMaxOddStyle(final int colNum, final int rowNum, final int valorInicioBucle) {
		int contador = getRecords().length;
		String formatoCelda = "";
		String style = "";
		for (int i = valorInicioBucle; i < contador - 1; i++) {
			String idParticipant = getFieldName(colNum);
			Double maxColumn = getMaxColumnOdd(colNum);
			Double valorColumna = Double.valueOf(((GenericRecord) getRecord(rowNum)).getExtLinkText(idParticipant));
			if (valorColumna.equals(maxColumn)) {
				formatoCelda = CELL_STYLE_MAX_ODD;
			} else {
				formatoCelda = CELL_STYLE_ODD;
			}
			return formatoCelda;
		}
		return formatoCelda;
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
		setTitleRow(pTitleRowData);
	}
}
