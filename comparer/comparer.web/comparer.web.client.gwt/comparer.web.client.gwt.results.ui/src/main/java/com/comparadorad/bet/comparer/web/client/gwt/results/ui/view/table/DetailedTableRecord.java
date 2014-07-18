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

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;

/**
 * The Class DetailedTableRecord.
 */
public class DetailedTableRecord extends GenericRecord {

	/**
	 * Instantiates a new detailed table record.
	 */
	public DetailedTableRecord() {

	}

	/** The Constant INFO_ICON_LOCATION. */
	private static final String INFO_ICON_LOCATION = "comparer/icons/info.jpg";

	/**
	 * Instantiates a new detailed table record.
	 * 
	 * @param pRowData
	 *            the row data
	 */
	public DetailedTableRecord(TableResponseRowTo pRowData) {
		setRecordId(pRowData.getObjectToId().getId());
		setExtLink(ColName.getCol(0), pRowData.getCellList().get(0));
		setDirectValue(ColName.getCol(1), INFO_ICON_LOCATION);
		int tableColNum = 2;
		int respColNum;
		for (respColNum = 1; respColNum < pRowData.getCellList().size() - 1; respColNum++) {
			setExtLink(ColName.getCol(tableColNum),
					pRowData.getCellList().get(respColNum));
			setSortValue(ColName.getCol(tableColNum), pRowData.getCellList()
					.get(respColNum));
			tableColNum++;
		}
		// ultima celda de pago
		setValueStr(ColName.getCol(tableColNum),
				pRowData.getCellList().get(respColNum));
	}

	/** {@inheritDoc} */
	@Override
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		int tableColNum = 2;
		for (int resColNum = 1; resColNum < pRowData.getCellList().size() - 1; resColNum++) {
			changed = updateExtLinkWithArrow(ColName.getCol(tableColNum),
					pRowData.getCellList().get(resColNum));
			if (changed) {
				setSortValue(ColName.getCol(tableColNum), pRowData
						.getCellList().get(resColNum));
				cellNumsToUpdate.add(tableColNum);
			}
			tableColNum++;
		}
		// ultima celda
		changed = setValueStr(ColName.getCol(tableColNum), pRowData
				.getCellList().get(pRowData.getCellList().size() - 1));
		if (changed) {
			cellNumsToUpdate.add(tableColNum);
		}
		return cellNumsToUpdate;
	}

	/**
	 * Update ext link with arrow.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean updateExtLinkWithArrow(String fieldName,
			TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		boolean changed = false;
		if (cellData.getExternalLinkTo() != null) {
			if (cellData.getExternalLinkTo().getLinkText() != null) {
				oldValue = getAttributeAsString(fieldName + EXT_LINK_TEXT);
				newValue = cellData.getExternalLinkTo().getLinkText();
				setAttribute(fieldName + EXT_LINK_TEXT, newValue);
				changed = changed
						|| (oldValue != null && !oldValue
								.equalsIgnoreCase(newValue));
			}
			if (changed) {
				// El odd se ha cambiado. Ponemos img de flecha.
				Double oldValueDouble = Double
						.valueOf(normalizeValue(oldValue));
				Double newValueDouble = Double
						.valueOf(normalizeValue(newValue));
				if (newValueDouble.compareTo(oldValueDouble) > 0) {
					setAttribute(fieldName + EXT_LINK_IMG,
							"comparer/icons/arrow_up_16x16.png");
				} else if (newValueDouble.compareTo(oldValueDouble) < 0) {
					setAttribute(fieldName + EXT_LINK_IMG,
							"comparer/icons/arrow_down_16x16.png");
				} else {
					Log.error("putting clean");
					setAttribute(fieldName + EXT_LINK_IMG, "");
				}
			}
			if (cellData.getExternalLinkTo().getUrl() != null) {
				oldValue = getAttributeAsString(fieldName + EXT_LINK_URL);
				newValue = cellData.getExternalLinkTo().getUrl();
				setAttribute(fieldName + EXT_LINK_URL, newValue);
				changed = changed
						|| (oldValue != null && !oldValue
								.equalsIgnoreCase(newValue));
			} else {
				Log.error("Expected value 'linkUrl' but was null");
			}
		} else {
			Log.error("Expected value 'extLink' but was null");
		}
		return changed;
	}

	/**
	 * Sets the sort value.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 */
	protected void setSortValue(String fieldName, TableResponseCellTo cellData) {
		if (cellData.getExternalLinkTo().getLinkText() != null) {
			setAttribute(fieldName + ASCENDING_SORT_VALUE, cellData
					.getExternalLinkTo().getLinkText());
			setAttribute(fieldName + DESCENDING_SORT_VALUE, cellData
					.getExternalLinkTo().getLinkText());
		}
	}

}
