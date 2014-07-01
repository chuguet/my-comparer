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
 * The Class BetTypeTreeNode.
 */
public class TreeNodeBetType extends GenericTreeNode {

	/** The Constant INT_LINK_COMPETITION_LT_EVENT_NAME. */
	private static final String INT_LINK_COMPETITION_LT_EVENT_NAME = InternalLinkEventNames.RESULTS_COMPETITION_LT_EVENT
			.getEventName();

	/** The Constant INT_LINK_MATCH_EVENT_NAME. */
	private static final String INT_LINK_MATCH_EVENT_NAME = InternalLinkEventNames.RESULTS_MATCH_EVENT
			.getEventName();

	/** The Constant NODE_ID_AUX. */
	private static final String NODE_ID_AUX = "nodeIdAux";

	/**
	 * Instantiates a new bet type tree node.
	 * 
	 * @param rowData
	 *            the row data
	 * @param parentTreeNodeId
	 *            the parent tree node id
	 * @param competitionEvent
	 *            the competition event
	 */
	public TreeNodeBetType(TableResponseRowTo rowData, String parentTreeNodeId,
			boolean competitionEvent) {
		String intLinkEventName;
		if (competitionEvent) {
			intLinkEventName = INT_LINK_COMPETITION_LT_EVENT_NAME;
		} else {
			intLinkEventName = INT_LINK_MATCH_EVENT_NAME;
		}
		List<TableResponseCellTo> cellData = rowData.getCellList();

		setTreeNodeId(rowData.getObjectToId().getId());
		setTreeNodeParentId(parentTreeNodeId);
		// Bet type id
		setTreeNodeIdAux(cellData.get(0).getLinkTo().getObjectToIdAux().getId());

		// Internal link
		setIntLink(ColName.getCol(1), cellData.get(0));
		setIntLinkIpcName(ColName.getCol(1), intLinkEventName);
	}

	/**
	 * Gets the tree node id aux.
	 * 
	 * @return the tree node id aux
	 */
	public String getTreeNodeIdAux() {
		return getAttribute(NODE_ID_AUX);
	}

	/**
	 * Sets the tree node id aux.
	 * 
	 * @param id
	 *            the new tree node id aux
	 */
	private void setTreeNodeIdAux(String id) {
		setAttribute(NODE_ID_AUX, id);
	}

}
