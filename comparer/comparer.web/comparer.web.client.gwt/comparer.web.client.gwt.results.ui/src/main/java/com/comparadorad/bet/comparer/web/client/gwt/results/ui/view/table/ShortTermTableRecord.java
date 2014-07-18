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

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;

/**
 * The Class RecordTableB.
 */
public class ShortTermTableRecord extends GenericRecord {

	/** The exp resonse row size. */
	private int expResonseRowSize;

	/**
	 * Instantiates a new record table b.
	 * 
	 * @param pRowData
	 *            the row data
	 * @param expResonseRowSize
	 *            the exp resonse row size
	 */
	public ShortTermTableRecord(final TableResponseRowTo pRowData,
			final int expResonseRowSize) {
		this.expResonseRowSize = expResonseRowSize;
		List<TableResponseCellTo> cellList = pRowData.getCellList();
		if (rowSizeAsExpected(cellList, expResonseRowSize)) {
			setRecordId(pRowData.getObjectToId().getId());
			setDate(ColName.getCol(0), cellList.get(0));
			setIntLink(ColName.getCol(1), cellList.get(1));
			for (int colNum = 2; colNum < cellList.size(); colNum++) {
				setExtLink(ColName.getCol(colNum), cellList.get(colNum));
				if (cellList.get(colNum).getValueTo() != null
						&& cellList.get(colNum).getValueTo().getValueStr() != null) {
					// En caso de Ganador Partido
					setValueStr(ColName.getCol(colNum), cellList.get(colNum));
				}
			}
		}
	}

	/**
	 * Gets the exp resonse row size.
	 * 
	 * @return the exp resonse row size
	 */
	public int getExpResonseRowSize() {
		return expResonseRowSize;
	}

	/**
	 * Sets the exp resonse row size.
	 * 
	 * @param pExpResonseRowSize
	 *            the new exp resonse row size
	 */
	public void setExpResonseRowSize(final int pExpResonseRowSize) {
		expResonseRowSize = pExpResonseRowSize;
	}

	/**
	 * Update.
	 * 
	 * @param pRowData
	 *            the row data
	 * @return the list {@inheritDoc}
	 */
	public List<Integer> update(final TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		List<TableResponseCellTo> cellList = pRowData.getCellList();
		changed = setDate(ColName.getCol(0), cellList.get(0));
		if (changed) {
			cellNumsToUpdate.add(0);
		}
		changed = setIntLink(ColName.getCol(1), cellList.get(1));
		if (changed) {
			cellNumsToUpdate.add(1);
		}
		for (int colNum = 2; colNum < cellList.size(); colNum++) {
			changed = setExtLinkUpdateOnlyOnTextChanged(ColName.getCol(colNum),
					cellList.get(colNum));
			if (cellList.get(colNum).getValueTo() != null
					&& cellList.get(colNum).getValueTo().getValueStr() != null) {
				// En caso de Ganador Partido
				changed = setValueStr(ColName.getCol(colNum),
						cellList.get(colNum));
			}
			if (changed) {
				cellNumsToUpdate.add(colNum);
			}
		}
		return cellNumsToUpdate;
	}

}
