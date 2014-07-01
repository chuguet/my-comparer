/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree;

import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.Messages;
import com.google.gwt.core.client.GWT;

/**
 * The Class TreeNodeError.
 */
public class TreeNodeError extends GenericTreeNode {

	/** The messages. */
	protected Messages messages = GWT.create(Messages.class);

	/**
	 * Instantiates a new tree node error.
	 * 
	 * @param nodeId
	 *            the node id
	 * @param parentNodeId
	 *            the parent node id
	 */
	public TreeNodeError(String nodeId, String parentNodeId) {
		setTreeNodeId(nodeId);
		setTreeNodeParentId(parentNodeId);
		setIsFolder(false);
		setDirectValue(ColName.getCol(1),
				messages.eventoNoDisponibleTemporalmente());
	}

}
