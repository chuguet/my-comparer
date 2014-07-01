package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.view;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;

public class FirstRecordLiveBet extends RecordLiveBet {

	private static final int EXP_RESPONSE_ROW_SIZE = 3;
	
	public FirstRecordLiveBet(TableResponseRowTo pRowData) {
		if (rowSizeAsExpected(pRowData.getCellList(), EXP_RESPONSE_ROW_SIZE)) {
			setDate(ColName.getCol(0), pRowData.getCellList().get(0));
			setDate(ColName.getCol(1), pRowData.getCellList().get(1));
			setValueStr(ColName.getCol(3), pRowData.getCellList().get(2));
		}
	}
	
	@Override
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		changed = setDate(ColName.getCol(0), pRowData.getCellList().get(0));
		if (changed) {
			cellNumsToUpdate.add(0);
		}
		changed = setDate(ColName.getCol(1), pRowData.getCellList().get(1));
		if (changed) {
			cellNumsToUpdate.add(1);
		}
		changed = setValueStr(ColName.getCol(3), pRowData.getCellList().get(2));
		if (changed) {
			cellNumsToUpdate.add(3);
		}
		return cellNumsToUpdate;
	}

}