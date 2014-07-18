package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;

public class LongTermTableRecord extends GenericRecord {

	public LongTermTableRecord(TableResponseRowTo pRowData) {
		List<TableResponseCellTo> cellData = pRowData.getCellList();
		setValueStr(ColName.getCol(0), cellData.get(0));
		setDirectValue(ColName.getCol(1), messages.media());
		setValueStr(ColName.getCol(2), cellData.get(1));
		setValueStr(ColName.getCol(3), cellData.get(2));
		setDirectValue(ColName.getCol(4), messages.arroba());
		int respColNum = 3;
		for (int colNum = 5; colNum < cellData.size() + 2; colNum++) {
			setExtLink(ColName.getCol(colNum), cellData.get(respColNum));
			setDirectValue(ColName.getCol(colNum), getExtLinkImg(ColName.getCol(colNum)));
			respColNum++;
		}
	}
	
	@Override
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		List<TableResponseCellTo> cellData = pRowData.getCellList();
		changed = setValueStr("2", cellData.get(2));
		if (changed) {
			cellNumsToUpdate.add(2);
		}
		changed = setValueStr("3", cellData.get(3));
		if (changed) {
			cellNumsToUpdate.add(3);
		}
		int respColNum = 3;
		for (int colNum = 5; colNum < cellData.size() + 2; colNum++) {
			changed = setExtLink(Integer.toString(colNum), cellData.get(respColNum));
			if (changed) {
				cellNumsToUpdate.add(colNum);
			}
		}
		return cellNumsToUpdate;
	}

}
