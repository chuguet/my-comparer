package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;

public class DetailedTableRecordHandicap extends DetailedTableRecord {

	public DetailedTableRecordHandicap(TableResponseRowTo pRowData) {
		setRecordId(pRowData.getObjectToId().getId());
		setExtLink(ColName.getCol(0), pRowData.getCellList().get(0));
		setDirectValue(ColName.getCol(1), "comparer/icons/info.jpg");
		setValueStr(ColName.getCol(2), pRowData.getCellList().get(1));
		int tableColNum = 3;
		int respColNum;
		for (respColNum = 2; respColNum < pRowData.getCellList().size() - 1; respColNum++) {
			setExtLink(ColName.getCol(tableColNum), pRowData.getCellList().get(respColNum));
			setSortValue(ColName.getCol(tableColNum), pRowData.getCellList().get(respColNum));
			tableColNum++;
		}
		// ultima celda de pago
		setValueStr(ColName.getCol(tableColNum), pRowData.getCellList().get(respColNum));
	}
	
	@Override
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		int tableColNum = 3;
		int respColNum;
		for (respColNum = 2; respColNum < pRowData.getCellList().size() - 1; respColNum++) {
			changed = updateExtLinkWithArrow(ColName.getCol(tableColNum), pRowData.getCellList().get(respColNum));
			if (changed) {
				setSortValue(ColName.getCol(tableColNum), pRowData.getCellList().get(respColNum));
				cellNumsToUpdate.add(tableColNum);
			}
			tableColNum++;
		}
		// ultima celda
		changed = setValueStr(ColName.getCol(tableColNum), pRowData.getCellList().get(respColNum));
		if (changed) {
			cellNumsToUpdate.add(tableColNum);
		}
		return cellNumsToUpdate;
	}
	
}

