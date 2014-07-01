/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.view;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.Messages;
import com.google.gwt.core.client.GWT;

/**
 * The Class RecordLiveBet.
 */
public class RecordLiveBet extends GenericRecord {

	/** The Constant EXP_RESPONSE_ROW_SIZE. */
	private static final int EXP_RESPONSE_ROW_SIZE = 4;
	
	protected static Messages messages = GWT.create(Messages.class);

	/**
	 * Instantiates a new record live bet.
	 */
	public RecordLiveBet() {
	}

	/**
	 * Instantiates a new record live bet.
	 * 
	 * @param pRowData
	 *            the row data
	 */
	public RecordLiveBet(final TableResponseRowTo pRowData) {
		if (rowSizeAsExpected(pRowData.getCellList(), EXP_RESPONSE_ROW_SIZE)) {
			if (pRowData.getCellList().get(0).getValueTo() != null && pRowData.getCellList().get(0).getValueTo().getValueStr() != null) {
				setValueStr(ColName.getCol(0), pRowData.getCellList().get(0));
			} else {
				setLiteral(ColName.getCol(0), pRowData.getCellList().get(0));
			}
			setValueStr(ColName.getCol(1), pRowData.getCellList().get(1));
			setDirectValue(ColName.getCol(2), messages.en());
			setExtLink(ColName.getCol(3), pRowData.getCellList().get(2));
			setDirectValue(ColName.getCol(4), messages.gane());
			setValueStr(ColName.getCol(5), pRowData.getCellList().get(3));
			setDirectValue(ColName.getCol(6), messages.porTanSolo10());
		}
	}

	/** {@inheritDoc} */
	public List<Integer> update(final TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		if (pRowData.getCellList().get(0).getValueTo() != null && pRowData.getCellList().get(0).getValueTo().getValueStr() != null) {
			changed = setValueStr(ColName.getCol(0), pRowData.getCellList().get(0));
		} else {
			changed = setLiteral(ColName.getCol(0), pRowData.getCellList().get(0));
		}
		if (changed) {
			cellNumsToUpdate.add(0);
		}
		changed = setValueStr(ColName.getCol(1), pRowData.getCellList().get(1));
		if (changed) {
			cellNumsToUpdate.add(1);
		}
		changed = setExtLink(ColName.getCol(3), pRowData.getCellList().get(2));
		if (changed) {
			cellNumsToUpdate.add(3);
		}
		changed = setValueStr(ColName.getCol(5), pRowData.getCellList().get(3));
		if (changed) {
			cellNumsToUpdate.add(5);
		}
		return cellNumsToUpdate;
	}

}
