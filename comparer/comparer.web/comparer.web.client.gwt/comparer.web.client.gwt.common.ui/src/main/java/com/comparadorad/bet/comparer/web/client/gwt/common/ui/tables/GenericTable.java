/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.Messages;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.util.ExternalLinkContextMenu;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.util.InternalLinkContextMenu;
import com.comparadorad.bet.comparer.web.client.gwt.core.analytics.AnalyticsEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.AppLinkUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.Page;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;

/**
 * The Class GenericTable.
 */
public abstract class GenericTable extends ListGrid {

	/** The messages. */
	protected static Messages messages = GWT.create(Messages.class);

	/** The external link context menu. */
	private ExternalLinkContextMenu externalLinkContextMenu = new ExternalLinkContextMenu();

	/** The internal link context menu. */
	private InternalLinkContextMenu internalLinkContextMenu = new InternalLinkContextMenu();

	/** The link util. */
	private AppLinkUtil linkUtil = new AppLinkUtil();

	/** The refresh state. */
	public RefreshStateNew refreshState;

	/**
	 * Instantiates a new generic table.
	 */
	public GenericTable() {
		refreshState = new RefreshStateNew();
		setShowEmptyMessage(false);
		setShowHeaderContextMenu(false);
		setCanResizeFields(false);
	}

	/**
	 * Divide word.
	 * 
	 * @param word
	 *            the word
	 * @param seperator
	 *            the seperator
	 * @param maxWordLengthBeforeIntroducingSeperator
	 *            the max word length before introducing seperator
	 * @return the string
	 */
	private String divideWord(String word, char seperator, int maxWordLengthBeforeIntroducingSeperator) {
		String[] wordDivided = word.split(" ");
		StringBuffer result = new StringBuffer();
		int i = 0;
		while (i < wordDivided.length && result.length() < maxWordLengthBeforeIntroducingSeperator) {
			if (result.length() + wordDivided[i].length() > maxWordLengthBeforeIntroducingSeperator) {
				result.append(" -").append(seperator);
			}
			result.append(" ").append(wordDivided[i]);
			i++;
		}
		for (; i < wordDivided.length; i++) {
			result.append(wordDivided[i]);
		}
		return result.toString();
	}

	/**
	 * Generate html string with new lines at seperator symbol.
	 * 
	 * @param originalString
	 *            the original string
	 * @param seperatorSymbol
	 *            the seperator symbol
	 * @return the string
	 */
	protected String generateHtmlStringWithNewLinesAtSeperatorSymbol(final String originalString, final char seperatorSymbol) {
		StringBuffer result = new StringBuffer();
		for (char c : originalString.toCharArray()) {
			if (c == seperatorSymbol) {
				result.append("</br>");
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	/**
	 * Gets the cell formatter calculator icon.
	 * 
	 * @return the cell formatter calculator icon
	 */
	protected CellFormatter getCellFormatterCalculatorIcon() {
		return new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				StringBuffer sb = new StringBuffer();
				sb.append("<img src='").append(getImageSpecificRoute()).append("comparer/icons/calculator.jpg' height='30' width='30'>");
				return sb.toString();
			}
		};
	}

	/**
	 * Gets the cell formatter external link bookmaker with odd.
	 * 
	 * @return the cell formatter external link bookmaker with odd
	 */
	public CellFormatter getCellFormatterExternalLinkBookmakerWithOdd() {
		return new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				GenericRecord rec = (GenericRecord) record;
				String fieldName = getFieldName(colNum);
				if (rec.getExtLinkImg(fieldName) != null && rec.getExtLinkText(fieldName) != null) {
					return new StringBuffer().append("<img src='").append(getImageSpecificRoute()).append(rec.getExtLinkImg(fieldName))
							.append("' height='15' width='65'>&nbsp;&nbsp;").append(rec.getExtLinkText(fieldName)).toString();
				}
				return value.toString();
			}
		};
	}

	/**
	 * Gets the cell formatter ext link bookmaker with odd and participant.
	 * 
	 * @return the cell formatter ext link bookmaker with odd and participant
	 */
	protected CellFormatter getCellFormatterExtLinkBookmakerWithOddAndParticipant() {
		return new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				GenericRecord rec = (GenericRecord) record;
				String fieldName = getFieldName(colNum);
				if (rec.getExtLinkImg(fieldName) != null && rec.getExtLinkText(fieldName) != null) {
					return new StringBuffer().append("<img height='15' width='65' src='").append(getImageSpecificRoute())
							.append(rec.getExtLinkImg(fieldName)).append("'>&nbsp;&nbsp;").append(rec.getExtLinkText(fieldName))
							.append("</br>").append(rec.getValueStr(fieldName)).toString();

				} else {
					return "";
				}
			}
		};
	}

	/**
	 * Gets the cell formatter ext link with arrow.
	 * 
	 * @return the cell formatter ext link with arrow
	 */
	protected CellFormatter getCellFormatterExtLinkWithArrow() {
		return new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				GenericRecord rec = (GenericRecord) record;
				String fieldName = getFieldName(colNum);
				if (rec.getValueStr(fieldName) != null) {
					return value.toString();
				}
				StringBuffer html = new StringBuffer();
				// Apuesta
				if (rec.getExtLinkText(fieldName) != null && rec.getExtLinkImg(fieldName) == null) {
					html = html.append(rec.getExtLinkText(fieldName));
				}
				// Apuesta y flecha
				else if (rec.getExtLinkText(fieldName) != null && rec.getExtLinkImg(fieldName) != null
						&& !rec.getExtLinkImg(fieldName).equalsIgnoreCase("")) {
					String containerDivStart = "<div style='width:78px;height:20px;line-height:20px;position:relative;padding-left:4px;padding-right:4px;vertical-align:middle;'>";
					String divEnd = "</div>";

					html = html.append(containerDivStart).append(rec.getExtLinkText(fieldName))
							.append("<img width='16' height='16' style='position:absolute;left:64px;top:2px;vertical-align:middle;' src='")
							.append(getImageSpecificRoute()).append(rec.getExtLinkImg(fieldName)).append("'/>").append(divEnd);

				}
				return html.toString();
			}
		};
	}

	/**
	 * Gets the cell formatter int link with date.
	 * 
	 * @return the cell formatter int link with date
	 */
	protected CellFormatter getCellFormatterIntLinkWithDate() {
		return new CellFormatter() {
			public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
				StringBuffer sb = new StringBuffer();
				GenericRecord rec = (GenericRecord) record;
				String fieldName = getFieldName(colNum);
				// El texto nos llega como evento|deporte|pais|competicion.
				String linkText = rec.getIntLinkText(fieldName);
				// Si el nombre del evento tiene mas de 35 caracteres lo
				// dividimos (ej: nombreEvento --> nombre|Evento)
				String firstWordWithSeperator = divideWord(linkText.substring(0, linkText.indexOf('|')), '|', 35);
				linkText = new StringBuffer().append(firstWordWithSeperator)
						.append(linkText.substring(linkText.indexOf('|'), linkText.length())).toString();
				// Introducimos saltos de linea donde haya '|'
				linkText = generateHtmlStringWithNewLinesAtSeperatorSymbol(linkText, '|');
				// Concatenando la fecha y la imagen del calendario
				String date = generateHtmlStringWithNewLinesAtSeperatorSymbol(rec.getDate(fieldName), ' ');
				sb.append(linkText);
				sb.append("</br><img src='").append(getImageSpecificRoute())
						.append("comparer/calendar/small_calendar.jpg' height='15' width='15'>");
				sb.append(date);
				return sb.toString();
			}
		};
	}

	/**
	 * Gets the image specific route.
	 * 
	 * @return the image specific route
	 */
	protected String getImageSpecificRoute() {
		if (AppProperties.getInstance().isLiferayEnvironment()) {
			return Page.getAppImgDir();
		} else {
			return "images/";
		}
	}

	/**
	 * Gets the record with id.
	 * 
	 * @param recordId
	 *            the record id
	 * @return the record with id
	 */
	protected GenericRecord getRecordWithId(final String recordId) {
		try {
			RecordList recordList = getRecordList();
			GenericRecord record = (GenericRecord) recordList.find(GenericRecord.getRecordIdAttributeName(), recordId);
			return record;
		} catch (ClassCastException e) {
			return null;
		}
	}

	/**
	 * On external link click.
	 * 
	 * @param record
	 *            the record
	 * @param colNum
	 *            the col num
	 */
	protected void onExternalLinkClick(final GenericRecord record, final int colNum) {
		String encryptedUrl = record.getExtLinkUrl(getFieldName(colNum));
		onExternalLinkClick(encryptedUrl);
	}
	
	
	/**
	 * On external link click.
	 * 
	 * @param encryptedUrl
	 *            the encrypted url
	 */
	protected void onExternalLinkClick(final String encryptedUrl) {
		Log.debug("Tipo de evento: onExternalLinkClick");
		linkUtil.openExternalLinkInNewWindow(encryptedUrl);
	}

	/**
	 * On external link click.
	 * 
	 * @param encryptedUrl
	 *            the encrypted url
	 * @param categoryAnalytics
	 *            the category analytics
	 * @param actionAnalytics
	 *            the action analytics
	 */
	protected void onExternalLinkClick(final String encryptedUrl, String categoryAnalytics, String actionAnalytics) {
		Log.debug("Tipo de evento: onExternalLinkClick");
		Log.debug("Se añade la información de analytics: " + categoryAnalytics + " - " + actionAnalytics);
		AnalyticsEventUtil.trackAnalytics(categoryAnalytics, actionAnalytics);
		linkUtil.openExternalLinkInNewWindow(encryptedUrl);
	}

	/**
	 * On info click.
	 * 
	 * @param record
	 *            the record
	 * @param colNum
	 *            the col num
	 */
	protected void onInfoClick(final GenericRecord record, final int colNum) {
		// Abrir ventana con info sobre la casa de apuesta
	}

	/**
	 * On internal link click.
	 * 
	 * @param pEvent
	 *            the event
	 * @param colNum
	 *            the col num
	 * @param eventName
	 *            the event name
	 */
	protected void onInternalLinkClick(final CellClickEvent pEvent, int colNum, final InternalLinkEventNames eventName) {
		Log.debug("Tipo de evento: onInternalLinkClick");
		GenericRecord record = (GenericRecord) pEvent.getRecord();

		String id = record.getIntLinkId(getFieldName(colNum));
		String idAux = "";
		if (record.getIntLinkIdAux(getFieldName(colNum)) != null) {
			idAux = record.getIntLinkIdAux(getFieldName(colNum));
		}
		String idAux2 = "";
		if (record.getIntLinkIdAux2(getFieldName(colNum)) != null) {
			idAux2 = record.getIntLinkIdAux2(getFieldName(colNum));
		}

		if (pEvent.isCtrlKeyDown() && pEvent.isLeftButtonDown()) {
			linkUtil.openInternalLinkInNewWindow(id, idAux, idAux2, eventName);
		} else {
			linkUtil.openInternalLinkInCurrentWindow(id, idAux, eventName);
		}

	}

	/**
	 * On internal link click redirect.
	 * 
	 * @param pEvent
	 *            the event
	 * @param eventName
	 *            the event name
	 */
	protected void onInternalLinkClickRedirect(CellClickEvent pEvent, InternalLinkEventNames eventName) {
		Log.debug("Tipo de evento: onInternalLinkClickRedirect");
		GenericRecord record = (GenericRecord) pEvent.getRecord();
		int colNum = pEvent.getColNum();
		String eventId = record.getIntLinkId(getFieldName(colNum));
		String betTypeId = record.getIntLinkIdAux(getFieldName(colNum));
		String betTypeEventId = record.getIntLinkIdAux2(getFieldName(colNum));

		if (pEvent.isCtrlKeyDown() && pEvent.isLeftButtonDown()) {
			linkUtil.openInternalLinkInNewWindow(eventId, betTypeId, betTypeEventId, eventName);
		} else {
			linkUtil.redirectInternalLinkInCurrentWindow(eventId, betTypeId, betTypeEventId, eventName);
		}

	}

	/**
	 * Sets the rows.
	 * 
	 * @param rowsData
	 *            the new rows
	 */
	public abstract void setRows(final List<TableResponseRowTo> rowsData);

	/**
	 * Sets the title row.
	 * 
	 * @param pResponse
	 *            the new title row
	 */
	public abstract void setTitleRow(final TableResponseRowTitleTo pResponse);

	/**
	 * Show external link context menu.
	 * 
	 * @param pEvent
	 *            the event
	 */
	protected void showExternalLinkContextMenu(final CellContextClickEvent pEvent) {
		Log.debug("Tipo de evento: showContextMenu");
		GenericRecord record = (GenericRecord) pEvent.getRecord();
		externalLinkContextMenu.setEncryptedUrl(record.getExtLinkUrl(getFieldName(pEvent.getColNum())));
		setContextMenu(externalLinkContextMenu);
	}

	/**
	 * Show internal link context menu.
	 * 
	 * @param pEvent
	 *            the event
	 * @param eventName
	 *            the event name
	 */
	protected void showInternalLinkContextMenu(final CellContextClickEvent pEvent, final InternalLinkEventNames eventName) {
		Log.debug("Tipo de evento: showContextMenu");
		GenericRecord record = (GenericRecord) pEvent.getRecord();
		int colNum = pEvent.getColNum();

		String id = record.getIntLinkId(getFieldName(colNum));
		String idAux = "";
		if (record.getIntLinkIdAux(getFieldName(colNum)) != null) {
			idAux = record.getIntLinkIdAux(getFieldName(colNum));
		}
		String idAux2 = "";
		if (record.getIntLinkIdAux2(getFieldName(colNum)) != null) {
			idAux2 = record.getIntLinkIdAux2(getFieldName(colNum));
		}

		internalLinkContextMenu.setId(id);
		internalLinkContextMenu.setIdAux(idAux);
		internalLinkContextMenu.setIdAux2(idAux2);
		internalLinkContextMenu.setEventName(eventName);

		setContextMenu(internalLinkContextMenu);
	}

	/**
	 * Some record has been deleted.
	 * 
	 * @param pRowsData
	 *            the rows data
	 * @param staticRowNum
	 *            the static row num
	 * @return true, if successful
	 */
	protected boolean someRecordHasBeenDeleted(final List<TableResponseRowTo> pRowsData, Integer staticRowNum) {
		if (staticRowNum == null) {
			staticRowNum = 0;
		}
		List<String> list = new ArrayList<String>();
		int rowNum = 0;
		for (TableResponseRowTo row : pRowsData) {
			if (rowNum < pRowsData.size() - staticRowNum) {
				list.add(row.getObjectToId().getId());
			}
			rowNum++;
		}
		RecordList recordList = getRecordList();
		for (int recordNum = 0; recordNum < recordList.getLength() - staticRowNum; recordNum++) {
			GenericRecord record = (GenericRecord) recordList.get(recordNum);
			if (!list.contains(record.getRecordId())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Update cells.
	 * 
	 * @param cellNums
	 *            the cell nums
	 * @param rowNum
	 *            the row num
	 */
	protected void updateCells(final List<Integer> cellNums, final int rowNum) {
		for (Integer cellNum : cellNums) {
			refreshCell(rowNum, cellNum);
		}
	}

	/**
	 * Update rows.
	 * 
	 * @param rowsData
	 *            the rows data
	 */
	public abstract void updateRows(final List<TableResponseRowTo> rowsData);

	/**
	 * Update title row.
	 * 
	 * @param titleRowData
	 *            the title row data
	 */
	public abstract void updateTitleRow(final TableResponseRowTitleTo titleRowData);

}
