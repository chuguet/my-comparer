/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree;

import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;

/**
 * The Class EventsTreeNode.
 */
public class TreeNodeCompetition extends GenericTreeNode {

	/** The Constant INFO_ICON_LOCATION. */
	private static final String INFO_ICON_LOCATION = "comparer/icons/info.jpg";

	/** The Constant INT_LINK_COMPETITION_LT_EVENT_NAME. */
	private static final String INT_LINK_COMPETITION_LT_EVENT_NAME = InternalLinkEventNames.RESULTS_COMPETITION_LT_EVENT
			.getEventName();

	/** The Constant INT_LINK_COMPETITION_ST_EVENT_NAME. */
	private static final String INT_LINK_COMPETITION_ST_EVENT_NAME = InternalLinkEventNames.RESULTS_COMPETITION_EVENT
			.getEventName();

	/**
	 * Instantiates a new events tree node.
	 * 
	 * @param rowData
	 *            the row data
	 * @param parentTreeNodeId
	 *            the parent tree node id
	 * @param longTermCompetitionEvent
	 *            the long term competition event
	 */
	public TreeNodeCompetition(TableResponseRowTo rowData,
			String parentTreeNodeId, boolean longTermCompetitionEvent) {
		String intLinkEventName;
		if (longTermCompetitionEvent) {
			intLinkEventName = INT_LINK_COMPETITION_LT_EVENT_NAME;
		} else {
			intLinkEventName = INT_LINK_COMPETITION_ST_EVENT_NAME;
		}
		List<TableResponseCellTo> cellData = rowData.getCellList();

		setTreeNodeId(rowData.getObjectToId().getId());
		if (parentTreeNodeId != null) {
			setTreeNodeParentId(parentTreeNodeId);
		}

		// Bandera (response celda 0, treegrid col 0)
		if (cellData.get(0).getResources() != null
				&& cellData.get(0).getResources().get(0) != null) {
			setDirectValue(ColName.getCol(0), cellData.get(0).getResources()
					.get(0).getLocation());
		}

		// Link a la competicion (response celda 1, treegrid col 1)
		setIntLink(ColName.getCol(1), cellData.get(1));
		setIntLinkIpcName(ColName.getCol(1), intLinkEventName);

		// Info (teegrid col 3)
		if (!longTermCompetitionEvent) {
			setDirectValue(ColName.getCol(3), INFO_ICON_LOCATION);
		}

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
