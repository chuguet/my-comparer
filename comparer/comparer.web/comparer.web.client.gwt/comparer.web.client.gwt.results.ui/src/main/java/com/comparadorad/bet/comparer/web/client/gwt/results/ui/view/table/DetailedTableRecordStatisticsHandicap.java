package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;

public class DetailedTableRecordStatisticsHandicap extends DetailedTableRecordStatistics {
	
	public DetailedTableRecordStatisticsHandicap(TableResponseRowTo pRowData, String recordId, String col0Name) {
		setRecordId(recordId);
		setDirectValue(ColName.getCol(0), col0Name);
		int tableColNum = 3;
		int respColNum;
		for (respColNum = 0; respColNum < pRowData.getCellList().size(); respColNum++) {
			setValueStr(ColName.getCol(tableColNum), pRowData.getCellList().get(respColNum));
			setSortValue(ColName.getCol(tableColNum));
			tableColNum++;
		}
	}
	
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		int tableColNum = 3;
		for (int resColNum = 0; resColNum < pRowData.getCellList().size(); resColNum++) {
			changed = setValueStr(ColName.getCol(tableColNum), pRowData.getCellList().get(resColNum));
			if (changed) {
				cellNumsToUpdate.add(tableColNum);
			}
			tableColNum++;
		}
		return cellNumsToUpdate;
	}

}
