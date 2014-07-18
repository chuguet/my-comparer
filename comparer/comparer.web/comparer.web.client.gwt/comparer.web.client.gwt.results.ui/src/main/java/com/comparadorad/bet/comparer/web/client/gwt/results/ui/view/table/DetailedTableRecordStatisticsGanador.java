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
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;

/**
 * The Class RecordTableCStatisticsGanador.
 */
public class DetailedTableRecordStatisticsGanador extends
		DetailedTableRecordStatistics {

	/** The id payout field. */
	String idPayoutField;

	/**
	 * Instantiates a new record table c statistics ganador.
	 * 
	 * @param pRowData
	 *            the row data
	 * @param recordId
	 *            the record id
	 * @param col0Name
	 *            the col0 name
	 * @param pIdPayoutField
	 *            the id payout field
	 */
	public DetailedTableRecordStatisticsGanador(TableResponseRowTo pRowData,
			String recordId, String col0Name, String pIdPayoutField) {
		this.idPayoutField = pIdPayoutField;
		setRecordId(recordId);
		setDirectValue(ColName.getCol(0), col0Name);
		int respColNum;
		for (respColNum = 0; respColNum < pRowData.getCellList().size() - 1; respColNum++) {
			if (pRowData.getCellList().get(respColNum).getId() != null
					&& pRowData.getCellList().get(respColNum).getId().getId() != null) {
				setValueStr(
						ColName.getCol(pRowData.getCellList().get(respColNum)
								.getId().getId()),
						pRowData.getCellList().get(respColNum));
				setSortValue((pRowData.getCellList().get(respColNum).getId()
						.getId()));
			} else {
				Log.error("Falta el id del participante en celda de statistics row numero "
						+ recordId);
			}
		}
		// Si la ultima contiene un id estamos en la ultima fila 'Probabilidad'
		// (que no tiene un valor para la columna 'Payout')
		if (pRowData.getCellList().get(respColNum).getId() != null
				&& pRowData.getCellList().get(respColNum).getId().getId() != null) {
			setValueStr(
					ColName.getCol(pRowData.getCellList().get(respColNum)
							.getId().getId()),
					pRowData.getCellList().get(respColNum));
		} else {
			setValueStr(idPayoutField, pRowData.getCellList().get(respColNum));
			setSortValue(idPayoutField);
		}
	}

	/** {@inheritDoc} */
	@Override
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		int tableColNum = 2;
		int resColNum;
		for (resColNum = 0; resColNum < pRowData.getCellList().size() - 1; resColNum++) {
			if (pRowData.getCellList().get(resColNum).getId() != null
					&& pRowData.getCellList().get(resColNum).getId().getId() != null) {
				changed = setValueStr(
						ColName.getCol(pRowData.getCellList().get(resColNum)
								.getId().getId()),
						pRowData.getCellList().get(resColNum));
			}
			if (changed) {
				cellNumsToUpdate.add(tableColNum);
			}
			tableColNum++;
		}
		// Si la ultima contiene un id estamos en la ultima fila 'Probabilidad'
		// (que no tiene un valor para la columna 'Payout')
		if (pRowData.getCellList().get(resColNum).getId() != null
				&& pRowData.getCellList().get(resColNum).getId().getId() != null) {
			changed = setValueStr(
					ColName.getCol(pRowData.getCellList().get(resColNum)
							.getId().getId()),
					pRowData.getCellList().get(resColNum));
		} else {
			changed = setValueStr(idPayoutField,
					pRowData.getCellList().get(resColNum));
		}
		if (changed) {
			cellNumsToUpdate.add(tableColNum);
		}
		return cellNumsToUpdate;
	}

}
