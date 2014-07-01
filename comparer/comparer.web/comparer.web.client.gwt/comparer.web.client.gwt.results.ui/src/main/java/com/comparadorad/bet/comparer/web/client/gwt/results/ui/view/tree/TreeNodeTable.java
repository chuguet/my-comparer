/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree;

import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableWrapper;

/**
 * The Class TreeNodeTable.
 */
public class TreeNodeTable extends GenericTreeNode {

	/** The Constant TABLE_LOADED. */
	private static final String TABLE_LOADED = "tableLoaded";

	/** The Constant TABLE_WRAPPER. */
	private static final String TABLE_WRAPPER = "tableWrapper";

	/**
	 * Instantiates a new tree node table.
	 * 
	 * @param tableWrapper
	 *            the table wrapper
	 * @param nodeId
	 *            the node id
	 * @param parentNodeId
	 *            the parent node id
	 */
	public TreeNodeTable(TableWrapper tableWrapper, String nodeId,
			String parentNodeId) {
		setAttribute(TABLE_LOADED, true);
		setAttribute(TABLE_WRAPPER, tableWrapper);
		setTreeNodeId(nodeId);
		setTreeNodeParentId(parentNodeId);
		setIsFolder(false);
	}

	/**
	 * Gets the table wrapper.
	 * 
	 * @return the table wrapper
	 */
	public TableWrapper getTableWrapper() {
		return (TableWrapper) getAttributeAsObject(TABLE_WRAPPER);
	}

}
