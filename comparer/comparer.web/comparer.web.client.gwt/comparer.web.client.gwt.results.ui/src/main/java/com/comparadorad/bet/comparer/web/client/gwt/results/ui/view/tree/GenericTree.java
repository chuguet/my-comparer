/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeNode;

/**
 * The Class GenericTree.
 */
public class GenericTree extends Tree {

	/** The Constant ROOT_VALUE. */
	private static final String ROOT_VALUE = "genericTreeRootValue";

	/**
	 * Instantiates a new generic tree.
	 */
	public GenericTree() {
		setModelType(com.smartgwt.client.types.TreeModelType.PARENT);
		setRoot(new GenericTreeNode(ROOT_VALUE));
	}

	/**
	 * Gets the old tree nodes.
	 * 
	 * @param parentNode
	 *            the parent node
	 * @param nodeData
	 *            the node data
	 * @return the old tree nodes
	 */
	public GenericTreeNode[] getOldTreeNodes(GenericTreeNode parentNode,
			List<TableResponseRowTo> nodeData) {
		Log.debug("Inicio getOldTreeNodes");
		GenericTreeNode[] oldTreeNodes;
		List<GenericTreeNode> oldTreeNodesAux = new ArrayList<GenericTreeNode>();
		List<String> newNodeIds = new ArrayList<String>();
		for (TableResponseRowTo data : nodeData) {
			newNodeIds.add(data.getObjectToId().getId());
		}
		// Recorrimos los nodos hijos actuales buscando nodos obsoletos
		for (TreeNode childNodeAux : getChildren(parentNode)) {
			GenericTreeNode childNode = (GenericTreeNode) childNodeAux;
			if (!newNodeIds.contains(childNode.getTreeNodeId())) {
				Log.debug(new StringBuffer().append("Nodo antiguo: ")
						.append(childNode.getTreeNodeId()).toString());
				oldTreeNodesAux.add(childNode);
			}
		}
		oldTreeNodes = treeNodeArrayListToArray(oldTreeNodesAux);
		Log.debug("Fin getOldTreeNodes");
		return oldTreeNodes;
	}

	/**
	 * Checks for child nodes.
	 * 
	 * @param node
	 *            the node
	 * @return true, if successful
	 */
	public boolean hasChildNodes(GenericTreeNode node) {
		return (getAllNodes(node).length > 1) ? true : false;
	}

	/**
	 * Tree node array list to array.
	 * 
	 * @param list
	 *            the list
	 * @return the generic tree node[]
	 */
	private GenericTreeNode[] treeNodeArrayListToArray(
			List<GenericTreeNode> list) {
		GenericTreeNode[] result = new GenericTreeNode[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = (GenericTreeNode) list.get(i);
		}
		return result;
	}
}
