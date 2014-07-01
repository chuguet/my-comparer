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

/**
 * The Class SecondRecordLiveBet.
 */
public class SecondRecordLiveBet extends RecordLiveBet {

	/** The Constant EXP_RESPONSE_ROW_SIZE. */
	private static final int EXP_RESPONSE_ROW_SIZE = 1;

	/**
	 * Instantiates a new second record live bet.
	 * 
	 * @param pRowData
	 *            the row data
	 */
	public SecondRecordLiveBet(TableResponseRowTo pRowData) {
		if (rowSizeAsExpected(pRowData.getCellList(), EXP_RESPONSE_ROW_SIZE)) {
			setIntLink(ColName.getCol(0), pRowData.getCellList().get(0));
			setSingleCellValue(getIntLinkText(ColName.getCol(0)));
		}
	}

	/** {@inheritDoc} */
	@Override
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		changed = setIntLink(ColName.getCol(0), pRowData.getCellList().get(0));
		if (changed) {
			cellNumsToUpdate.add(0);
		}
		return cellNumsToUpdate;
	}

}
