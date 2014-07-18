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

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;

/**
 * The Class RecordTableCGanador.
 */
public class DetailedTableRecordGanador extends DetailedTableRecord {

	/** The id payout field. */
	String idPayoutField;

	/**
	 * Instantiates a new record table c ganador.
	 * 
	 * @param pRowData
	 *            the row data
	 * @param pIdPayoutField
	 *            the id payout field
	 */
	public DetailedTableRecordGanador(TableResponseRowTo pRowData,
			String pIdPayoutField) {
		this.idPayoutField = pIdPayoutField;
		setRecordId(pRowData.getObjectToId().getId());
		setExtLink(ColName.getCol(0), pRowData.getCellList().get(0));
		setDirectValue(ColName.getCol(1), "comparer/icons/info.jpg");
		int respColNum;
		for (respColNum = 1; respColNum < pRowData.getCellList().size() - 1; respColNum++) {
			if (pRowData.getCellList().get(respColNum).getId() != null
					&& pRowData.getCellList().get(respColNum).getId().getId() != null) {
				setExtLink(ColName.getCol(pRowData.getCellList().get(respColNum).getId()
						.getId()), pRowData.getCellList().get(respColNum));
				setSortValue(ColName.getCol(pRowData.getCellList().get(respColNum).getId()
						.getId()), pRowData.getCellList().get(respColNum));
			}
		}
		// ultima celda de pago
		setValueStr(idPayoutField, pRowData.getCellList().get(respColNum));
	}

	/** {@inheritDoc} */
	@Override
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		int tableColNum = 2;
		int resColNum;
		for (resColNum = 1; resColNum < pRowData.getCellList().size() - 1; resColNum++) {
			if (pRowData.getCellList().get(resColNum).getId() != null
					&& pRowData.getCellList().get(resColNum).getId().getId() != null) {
				changed = updateExtLinkWithArrow(
						ColName.getCol(pRowData.getCellList().get(resColNum).getId().getId()),
						pRowData.getCellList().get(resColNum));
			}
			if (changed) {
				setSortValue(ColName.getCol(pRowData.getCellList().get(resColNum).getId()
						.getId()), pRowData.getCellList().get(resColNum));
				cellNumsToUpdate.add(tableColNum);
			}
			tableColNum++;
		}
		// ultima celda de pago
		changed = setValueStr(idPayoutField,
				pRowData.getCellList().get(resColNum));
		if (changed) {
			cellNumsToUpdate.add(tableColNum);
		}
		return cellNumsToUpdate;
	}

}
