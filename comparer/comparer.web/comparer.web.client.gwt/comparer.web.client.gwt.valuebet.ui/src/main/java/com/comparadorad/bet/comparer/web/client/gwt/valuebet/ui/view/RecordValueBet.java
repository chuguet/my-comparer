/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.view;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;

/**
 * The Class RecordValueBet.
 */
public class RecordValueBet extends GenericRecord {

	/** The Constant EXP_RESP_ROW_SIZE. */
	private static final int EXP_RESP_ROW_SIZE = 7;

	/**
	 * Instantiates a new record value bet.
	 * 
	 * @param pRowData
	 *            the row data
	 */
	public RecordValueBet(TableResponseRowTo pRowData) {
		if (rowSizeAsExpected(pRowData.getCellList(), EXP_RESP_ROW_SIZE)) {
			setRecordId(pRowData.getObjectToId().getId());
			setIntLink(ColName.getCol(0), pRowData.getCellList().get(0));
			setDate(ColName.getCol(0), pRowData.getCellList().get(0));
			setValueStrWithSpace(ColName.getCol(1),
					pRowData.getCellList().get(1));
			setValueStr(ColName.getCol(2), pRowData.getCellList().get(2));
			setExtLink(ColName.getCol(3), pRowData.getCellList().get(3));
			if (pRowData.getCellList().get(3).getExternalLinkTo() != null) {
				setDirectValue(ColName.getCol(3), pRowData.getCellList().get(3)
						.getExternalLinkTo().getLinkImgLocation());
			}
			setExtLink(ColName.getCol(4), pRowData.getCellList().get(4));
			if (pRowData.getCellList().get(4).getExternalLinkTo() != null) {
				setDirectValue(ColName.getCol(4), pRowData.getCellList().get(4)
						.getExternalLinkTo().getLinkText());
			}
			setValueStr(ColName.getCol(5), pRowData.getCellList().get(5));
			setValueStr(ColName.getCol(6), pRowData.getCellList().get(6));
		}
	}

	/**
	 * Sets the date.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	protected boolean setDate(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		if (cellData.getValueTo() != null
				&& cellData.getValueTo().getDate() != null) {
			oldValue = getAttributeAsString(fieldName + DATE);
			newValue = cellData.getValueTo().getDate();
			setAttribute(fieldName + DATE, newValue);
		} else {
			Log.error("Expected value 'date' but was null");
		}
		return oldValue != null && !oldValue.equalsIgnoreCase(newValue);
	}

	/**
	 * Sets the int link.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	protected boolean setIntLink(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		boolean changed = false;
		if (cellData.getLinkTo() != null
				&& cellData.getLinkTo().getName() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_TEXT);
			newValue = cellData.getLinkTo().getName();
			setAttribute(fieldName + INT_LINK_TEXT, newValue);
			changed = oldValue != null && !oldValue.equalsIgnoreCase(newValue);
		} else {
			Log.error("Expected value 'intLinkText' but was null");
		}
		if (cellData.getLinkTo() != null
				&& cellData.getLinkTo().getObjectToId() != null
				&& cellData.getLinkTo().getObjectToId().getId() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_ID);
			newValue = cellData.getLinkTo().getObjectToId().getId();
			setAttribute(fieldName + INT_LINK_ID, newValue);
		} else {
			Log.error("Expected value 'intLinkId' but was null");
		}
		if (cellData.getLinkTo() != null
				&& cellData.getLinkTo().getObjectToIdAux() != null
				&& cellData.getLinkTo().getObjectToIdAux().getId() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_ID_AUX);
			newValue = cellData.getLinkTo().getObjectToIdAux().getId();
			setAttribute(fieldName + INT_LINK_ID_AUX, newValue);
		} else {
			Log.error("Expected value 'intLinkIdAux' but was null");
		}
		if (cellData.getLinkTo() != null
				&& cellData.getLinkTo().getObjectToIdAux2() != null
				&& cellData.getLinkTo().getObjectToIdAux2().getId() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_ID_AUX_2);
			newValue = cellData.getLinkTo().getObjectToIdAux2().getId();
			setAttribute(fieldName + INT_LINK_ID_AUX_2, newValue);
		} else {
			Log.error("Expected value 'intLinkIdAux2' but was null");
		}
		return changed
				|| (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
	}

	/**
	 * Update.
	 * 
	 * @param pRowData
	 *            the row data
	 * @return the list {@inheritDoc}
	 */
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		changed = setDate(ColName.getCol(0), pRowData.getCellList().get(0));
		if (changed) {
			cellNumsToUpdate.add(0);
		}
		changed = setValueStrWithSpace(ColName.getCol(1), pRowData
				.getCellList().get(1));
		if (changed) {
			cellNumsToUpdate.add(1);
		}
		changed = setValueStr(ColName.getCol(2), pRowData.getCellList().get(2));
		if (changed) {
			cellNumsToUpdate.add(2);
		}
		changed = setExtLink(ColName.getCol(3), pRowData.getCellList().get(3));
		if (changed) {
			cellNumsToUpdate.add(3);
			setDirectValue(ColName.getCol(3), pRowData.getCellList().get(3)
					.getExternalLinkTo().getLinkImgLocation());
		}
		changed = setExtLink(ColName.getCol(4), pRowData.getCellList().get(4));
		if (changed) {
			cellNumsToUpdate.add(4);
			setDirectValue(ColName.getCol(4), pRowData.getCellList().get(4)
					.getExternalLinkTo().getLinkText());
		}
		changed = setValueStr(ColName.getCol(5), pRowData.getCellList().get(5));
		if (changed) {
			cellNumsToUpdate.add(5);
		}
		changed = setValueStr(ColName.getCol(6), pRowData.getCellList().get(6));
		if (changed) {
			cellNumsToUpdate.add(6);
		}
		return cellNumsToUpdate;
	}

}
