/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.util.ExternalLinkContextMenu;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.calculator.CalculatorService;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.calculator.bean.BeanCalculator;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class SecureBetTable.
 */
public abstract class SecureBetTable extends GenericTable {

	/** The Constant celdaComponenteInternoClick. */
	private static final String celdaComponenteInternoClick = "sureCeldaComponenteInternoClick";

	private static final String imgBookmakerSurebet = "imgBookmakerSurebet";

	private static final String imgBookmakerOverSurebet = "imgBookmakerOverSurebet";

	private static final String oddBackgroundSurebet = "oddBackgroundSurebet";

	/** The Constant celdaNormal. */
	private static final String celdaNormal = "sureCeldaNormal";

	/** The Constant celdaNormalClick. */
	private static final String celdaNormalClick = "sureCeldaNormalClick";

	/** The Constant celdaSubrayadoClick. */
	private static final String celdaSubrayadoClick = "sureCeldaSubrayadoClick";

	/** The Constant CELL_HEIGHT. */
	private static final int CELL_HEIGHT = 80;

	/** The Constant colTitles. */
	private static final String[] colTitles = { messages.evento(), messages.tipoDeApuesta(), messages.beneficio(),
			messages.casasDeApuestas(), messages.cuotas(), messages.desde(), messages.calculadora() };

	/** The Constant HEIGHT_BOOKMAKER_IMG. */
	private static final int HEIGHT_BOOKMAKER_IMG = 20;

	/** The Constant WIDTH_BOOKMAKER_IMG. */
	private static final int WIDTH_BOOKMAKER_IMG = 105;

	/** The Constant WIDTH_COL0. */
	private static final int WIDTH_COL0 = 250;

	/** The col0 event. */
	private ListGridField col0Event;

	/** The col1 bet type. */
	private ListGridField col1BetType;

	/** The col2 benefit. */
	private ListGridField col2Benefit;

	/** The col3 bookmaker. */
	private ListGridField col3Bookmaker;

	/** The col4 quotas. */
	private ListGridField col4Quotas;

	/** The col5 from. */
	private ListGridField col5From;

	private ListGridField col6Calculator;

	/** The fields. */
	private ListGridField[] fields;

	private static final int MIN_HEIGHT = 100;

	public abstract Integer getWidth();

	public abstract Integer getWidthCol1();

	public abstract Integer getWidthCol2();

	public abstract Integer getWidthCol3();

	public abstract Integer getWidthCol4();

	public abstract Integer getWidthCol4OddBackground();

	public abstract Integer getWidthCol5();

	public abstract Integer getWidthCol6();

	/**
	 * Instantiates a new secure bet table.
	 */
	public SecureBetTable() {

		setWidth(getWidth());
		setHeight(MIN_HEIGHT);
		setCellHeight(CELL_HEIGHT);

		setAutoFitData(Autofit.VERTICAL);

		setOverflow(Overflow.HIDDEN);
		setBodyOverflow(Overflow.HIDDEN);

		setShowAllRecords(true);
		setLeaveScrollbarGap(false);
		setCanSort(false);
		setShowRecordComponents(true);
		setShowRecordComponentsByCell(true);
		setCanDragResize(false);
		setShowHeaderContextMenu(false);
		setShowRollOver(false);
		setShowSelectedStyle(false);

		col0Event = new ListGridField(ColName.getCol(0), colTitles[0]);
		col1BetType = new ListGridField(ColName.getCol(1), colTitles[1]);
		col2Benefit = new ListGridField(ColName.getCol(2), colTitles[2]);
		col3Bookmaker = new ListGridField(ColName.getCol(3), colTitles[3]);
		col4Quotas = new ListGridField(ColName.getCol(4), colTitles[4]);
		col5From = new ListGridField(ColName.getCol(5), colTitles[5]);
		col6Calculator = new ListGridField(ColName.getCol(6), colTitles[6]);
		fields = new ListGridField[] { col0Event, col1BetType, col2Benefit, col3Bookmaker, col4Quotas, col5From, col6Calculator };

		col1BetType.setAlign(Alignment.CENTER);
		col2Benefit.setAlign(Alignment.CENTER);
		col3Bookmaker.setAlign(Alignment.CENTER);
		col4Quotas.setAlign(Alignment.CENTER);
		col5From.setAlign(Alignment.CENTER);
		col6Calculator.setAlign(Alignment.CENTER);

		col0Event.setCanDragResize(false);
		col1BetType.setCanDragResize(false);
		col2Benefit.setCanDragResize(false);
		col3Bookmaker.setCanDragResize(false);
		col4Quotas.setCanDragResize(false);
		col5From.setCanDragResize(false);
		col6Calculator.setCanDragResize(false);

		addCellClickHandler(new CellClickHandler() {
			@Override
			public void onCellClick(CellClickEvent pEvent) {
				if (pEvent.getColNum() == 0) {
					onInternalLinkClickRedirect(pEvent, InternalLinkEventNames.SURE_BET_MATCH_EVENT);
				} else if (pEvent.getColNum() == 6) {
					CalculatorService service = new CalculatorService();
					service.openCalculator((BeanCalculator) pEvent.getRecord().getAttributeAsObject("calculator"));
				}
			}
		});

		addCellContextClickHandler(new CellContextClickHandler() {

			@Override
			public void onCellContextClick(CellContextClickEvent pEvent) {
				if (pEvent.getColNum() == 0) {
					showInternalLinkContextMenu(pEvent, InternalLinkEventNames.SURE_BET_MATCH_EVENT);
				} else {
					setContextMenu(null);
				}
			}

		});

		col0Event.setWidth(WIDTH_COL0);
		col1BetType.setWidth(getWidthCol1());
		col2Benefit.setWidth(getWidthCol2());
		col3Bookmaker.setWidth(getWidthCol3());
		col4Quotas.setWidth(getWidthCol4());
		col5From.setWidth(getWidthCol5());
		col6Calculator.setWidth(getWidthCol6());

		col0Event.setCellFormatter(getCellFormatterIntLinkWithDate());
		col6Calculator.setCellFormatter(getCellFormatterCalculatorIcon());

		setFields(fields);

	}

	/**
	 * Creates the record component.
	 * 
	 * @param record
	 *            the record
	 * @param colNum
	 *            the col num
	 * @return the canvas {@inheritDoc}
	 */
	@Override
	protected Canvas createRecordComponent(final ListGridRecord record, final Integer colNum) {
		final String fieldName = this.getFieldName(colNum);
		final RecordSecureBet rec = (RecordSecureBet) record;
		if (colNum == 3) {
			VLayout layout = new VLayout();
			layout.setAutoHeight();
			layout.setAutoWidth();
			layout.setMembersMargin(10);
			layout.setCursor(Cursor.HAND);
			if (getRecordIndex(record) % 2 == 0) {
				layout.setStyleName(celdaComponenteInternoClick);
			} else {
				layout.setStyleName(celdaComponenteInternoClick + "Dark");
			}

			for (int linkCont = 0; linkCont < rec.getMultExtLinkCont(fieldName); linkCont++) {
				Img img = new Img();
				img.setSrc(rec.getExtLinkImg(fieldName, linkCont));
				img.setHeight(HEIGHT_BOOKMAKER_IMG);
				img.setWidth(WIDTH_BOOKMAKER_IMG);
				img.setCursor(Cursor.HAND);
				img.setCanHover(true);
				img.setShowHover(true);
				img.setStyleName(imgBookmakerSurebet);

				final int cont = linkCont;
				img.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						onExternalLinkClick(rec.getExtLinkUrl(fieldName, cont), rec.getExtLinkCategoryAnalytics(fieldName, cont),
								rec.getExtLinkActionAnalytics(fieldName, cont));
						// onExternalLinkClick(rec.getExtLinkUrl(fieldName,
						// cont));
					}
				});
				ExternalLinkContextMenu externalLinkContextMenu = new ExternalLinkContextMenu();
				externalLinkContextMenu.setEncryptedUrl(rec.getExtLinkUrl(fieldName, cont));
				img.setContextMenu(externalLinkContextMenu);
				layout.addMember(img);
			}
			return layout;
		} else if (colNum == 4) {
			VLayout layout = new VLayout();
			layout.setAutoHeight();
			layout.setAutoWidth();
			layout.setMembersMargin(10);
			layout.setAlign(Alignment.CENTER);
			layout.setCursor(Cursor.HAND);
			if (getRecordIndex(record) % 2 == 0) {
				layout.setStyleName(celdaComponenteInternoClick);
			} else {
				layout.setStyleName(celdaComponenteInternoClick + "Dark");
			}

			for (int linkCont = 0; linkCont <= rec.getMultExtLinkCont(fieldName); linkCont++) {
				Label label = new Label(rec.getExtLinkText(fieldName, linkCont));
				label.setAutoHeight();
				label.setWidth(getWidthCol4OddBackground());
				label.setAlign(Alignment.CENTER);
				label.setCursor(Cursor.HAND);
				label.setCanHover(true);
				label.setShowHover(true);
				label.setStyleName(oddBackgroundSurebet);
				final int cont = linkCont;
				label.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						onExternalLinkClick(rec.getExtLinkUrl(fieldName, cont), rec.getExtLinkCategoryAnalytics(fieldName, cont),
								rec.getExtLinkActionAnalytics(fieldName, cont));
						// onExternalLinkClick(rec.getExtLinkUrl(fieldName,
						// cont));
					}
				});
				ExternalLinkContextMenu externalLinkContextMenu = new ExternalLinkContextMenu();
				externalLinkContextMenu.setEncryptedUrl(rec.getExtLinkUrl(fieldName, cont));
				label.setContextMenu(externalLinkContextMenu);
				layout.addMember(label);
			}
			return layout;
		} else {
			return null;
		}
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
		} else if (colNum == 3 || colNum == 4 || colNum == 6) {
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
	public void setRows(List<TableResponseRowTo> rowsData) {
		Log.debug("setRows");
		RecordSecureBet[] records = new RecordSecureBet[rowsData.size()];
		int rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			RecordSecureBet record = new RecordSecureBet(rowData);
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
		RecordSecureBet[] newRecords = new RecordSecureBet[rowsData.size()];
		int rowNum = 0;
		boolean newRecordAdded = false;
		boolean recordDeleted = someRecordHasBeenDeleted(rowsData, null);
		boolean individualCellUpdate = false;
		RecordSecureBet record;
		rowNum = 0;
		for (TableResponseRowTo rowData : rowsData) {
			if (rowData.getObjectToId() != null && rowData.getObjectToId().getId() != null) {
				record = (RecordSecureBet) getRecordWithId(rowData.getObjectToId().getId());
			} else {
				record = (RecordSecureBet) getRecordWithId(null);
			}
			if (record == null) {
				record = new RecordSecureBet(rowData);
				newRecordAdded = true;
			}
			individualCellUpdate = !newRecordAdded && !recordDeleted;
			List<Integer> cellNumsToUpdate = record.update(rowData);
			if (individualCellUpdate) {
				updateCells(cellNumsToUpdate, rowNum);
				if (cellNumsToUpdate.contains(3)) {
					refreshRecordComponent(rowNum, 3);
				}
				if (cellNumsToUpdate.contains(4)) {
					refreshRecordComponent(rowNum, 4);
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
