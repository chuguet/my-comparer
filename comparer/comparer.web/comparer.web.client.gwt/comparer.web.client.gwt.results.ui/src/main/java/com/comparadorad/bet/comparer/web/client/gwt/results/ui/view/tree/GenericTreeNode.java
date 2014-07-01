/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.Messages;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.tree.TreeNode;

/**
 * The Class GenericTreeNode.
 */
public class GenericTreeNode extends TreeNode {

	/** The Constant INT_LINK_ID. */
	protected static final String INT_LINK_ID = "intLinkId";

	/** The Constant INT_LINK_ID_AUX. */
	protected static final String INT_LINK_ID_AUX = "intLinkIdAux";

	/** The Constant INT_LINK_ID_AUX_2. */
	protected static final String INT_LINK_ID_AUX_2 = "intLinkIdAux2";

	/** The Constant INT_LINK_IPC_EVENT_NAME. */
	protected static final String INT_LINK_IPC_EVENT_NAME = "intLinkIpcEventName";

	/** The Constant INT_LINK_TEXT. */
	protected static final String INT_LINK_TEXT = "intLinkText";

	/** The Constant NODE_ID. */
	private static final String NODE_ID = "nodeId";

	/** The Constant PARENT_NODE_ID. */
	private static final String PARENT_NODE_ID = "parentNodeId";

	/** The Constant VALUE_STR. */
	protected static final String VALUE_STR = "valueStr";

	/**
	 * Gets the tree node id attribute name.
	 * 
	 * @return the tree node id attribute name
	 */
	public static String getTreeNodeIdAttributeName() {
		return NODE_ID;
	}

	/** The messages. */
	protected Messages messages = GWT.create(Messages.class);

	/** The position. */
	private int position;

	/**
	 * Instantiates a new generic tree node.
	 */
	public GenericTreeNode() {
		setIsFolder(true);
	}

	/**
	 * Instantiates a new generic tree node.
	 * 
	 * @param id
	 *            the id
	 */
	public GenericTreeNode(String id) {
		setIsFolder(true);
		setTreeNodeId(id);
	}

	/**
	 * Gets the int link id.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the int link id
	 */
	protected String getIntLinkId(String fieldName) {
		return getAttribute(fieldName + INT_LINK_ID);
	}

	/**
	 * Gets the int link id aux.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the int link id aux
	 */
	protected String getIntLinkIdAux(String fieldName) {
		return getAttribute(fieldName + INT_LINK_ID_AUX);
	}

	/**
	 * Gets the int link ipc name.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the int link ipc name
	 */
	protected String getIntLinkIpcName(String fieldName) {
		return getAttributeAsString(fieldName + INT_LINK_IPC_EVENT_NAME);
	}

	/**
	 * Gets the position.
	 * 
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Gets the tree node id.
	 * 
	 * @return the tree node id
	 */
	public String getTreeNodeId() {
		return getAttribute(NODE_ID);
	}

	/**
	 * Gets the tree node parent id.
	 * 
	 * @return the tree node parent id
	 */
	public String getTreeNodeParentId() {
		return getAttribute(PARENT_NODE_ID);
	}

	/**
	 * Sets the direct value.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param value
	 *            the value
	 */
	protected void setDirectValue(String fieldName, String value) {
		setAttribute(fieldName, value);
	}

	/**
	 * Sets the int link.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setIntLink(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		boolean changed = false;
		if (cellData.getLinkTo() != null
				&& cellData.getLinkTo().getName() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_TEXT);
			newValue = cellData.getLinkTo().getName();
			setAttribute(fieldName, newValue);
			setAttribute(fieldName + INT_LINK_TEXT, newValue);
			changed = oldValue != null && !oldValue.equalsIgnoreCase(newValue);
		} else {
			Log.error("Expected value 'intLinkText' but was null");
		}
		if (cellData.getLinkTo() != null
				&& cellData.getLinkTo().getObjectToId() != null
				&& cellData.getLinkTo().getObjectToId().getId() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_ID);
			newValue = cellData.getLinkTo().getObjectToId().getId();
			setAttribute(fieldName + INT_LINK_ID, newValue);
		} else {
			Log.error("Expected value 'intLinkId' but was null");
		}
		if (cellData.getLinkTo() != null
				&& cellData.getLinkTo().getObjectToIdAux() != null
				&& cellData.getLinkTo().getObjectToIdAux().getId() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_ID_AUX);
			newValue = cellData.getLinkTo().getObjectToIdAux().getId();
			setAttribute(fieldName + INT_LINK_ID_AUX, newValue);
		}
		return changed
				|| (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
	}

	/**
	 * Sets the int link ipc name.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param ipcEventName
	 *            the ipc event name
	 */
	protected void setIntLinkIpcName(String fieldName, String ipcEventName) {
		setAttribute(fieldName + INT_LINK_IPC_EVENT_NAME, ipcEventName);
	}

	/**
	 * Sets the position.
	 * 
	 * @param pPosition
	 *            the new position
	 */
	public void setPosition(int pPosition) {
		position = pPosition;
	}

	/**
	 * Sets the tree node id.
	 * 
	 * @param id
	 *            the new tree node id
	 */
	public void setTreeNodeId(String id) {
		if (id != null) {
			setID(id);
			setAttribute(NODE_ID, id);
			Log.debug("treeNodeId = " + id);
		} else {
			Log.warn("Expected value 'id' but was null");
		}
	}

	/**
	 * Sets the tree node parent id.
	 * 
	 * @param id
	 *            the new tree node parent id
	 */
	public void setTreeNodeParentId(String id) {
		if (id != null) {
			setParentID(id);
			setAttribute(PARENT_NODE_ID, id);
		} else {
			Log.warn("Expected value 'parentId' but was null");
		}
	}

	/**
	 * Sets the value str.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setValueStr(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		if (cellData.getValueTo() != null
				&& cellData.getValueTo().getValueStr() != null) {
			String cellValueStr = cellData.getValueTo().getValueStr();
			oldValue = getAttributeAsString(fieldName + VALUE_STR);
			newValue = cellValueStr;
			setAttribute(fieldName, newValue);
			setAttribute(fieldName + VALUE_STR, newValue);
		} else {
			Log.error("Expected value 'valueStr' but was null");
		}
		return oldValue != null && !oldValue.equalsIgnoreCase(newValue);
	}

}
