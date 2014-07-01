/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree;

import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;

/**
 * The Class LongTermEventTreeNode.
 */
public class TreeNodeLongTermEvent extends GenericTreeNode {

	/**
	 * Instantiates a new long term event tree node.
	 * 
	 * @param rowData
	 *            the row data
	 */
	public TreeNodeLongTermEvent(TableResponseRowTo rowData) {
		List<TableResponseCellTo> cellData = rowData.getCellList();

		setTreeNodeId(rowData.getObjectToId().getId());
		Log.debug("eventId = " + rowData.getObjectToId().getId());

		// Bandera (response celda 0, treegrid col 0)
		if (cellData.get(0).getResources() != null
				&& cellData.get(0).getResources().get(0) != null) {
			setDirectValue(ColName.getCol(0), cellData.get(0).getResources()
					.get(0).getLocation());
			setIntLinkIpcName(ColName.getCol(1),
					InternalLinkEventNames.RESULTS_MATCH_EVENT.getEventName());
		}

		// Link al evento (response celda 1, treegrid col 1)
		setIntLink(ColName.getCol(1), cellData.get(1));

		// Numero de eventos (response celda 2, treegrid col 4)
		if (cellData.get(2) != null && cellData.get(2).getValueTo() != null
				&& cellData.get(2).getValueTo().getValueStr() != null) {
			setDirectValue(
					ColName.getCol(4),
					new StringBuffer()
							.append(cellData.get(2).getValueTo().getValueStr())
							.append(" ").append(messages.eventos()).toString());
		}

	}

}
