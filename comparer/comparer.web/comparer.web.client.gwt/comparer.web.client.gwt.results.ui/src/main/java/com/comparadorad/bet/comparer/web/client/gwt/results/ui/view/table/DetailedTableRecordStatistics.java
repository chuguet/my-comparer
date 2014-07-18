package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;

public class DetailedTableRecordStatistics extends GenericRecord {
	
	public DetailedTableRecordStatistics() {
		
	}
	
	public DetailedTableRecordStatistics(TableResponseRowTo pRowData, String recordId, String col0Name) {
		setRecordId(recordId);
		setDirectValue(ColName.getCol(0), col0Name);
		int tableColNum = 2;
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
		int tableColNum = 2;
		for (int resColNum = 0; resColNum < pRowData.getCellList().size(); resColNum++) {
			changed = setValueStr(ColName.getCol(tableColNum), pRowData.getCellList().get(resColNum));
			if (changed) {
				cellNumsToUpdate.add(tableColNum);
			}
			tableColNum++;
		}
		return cellNumsToUpdate;
	}
	
	protected void setSortValue(String fieldName) {
		setAttribute(fieldName + ASCENDING_SORT_VALUE, -1);
		setAttribute(fieldName + DESCENDING_SORT_VALUE, 1000);
	}

}
