/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree;

import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * The Class CompetitionTreeGrid.
 */
public class CompetitionTreeGrid extends GenericTreeGrid {

	/** The Constant COMP. */
	protected final static String COMP = "Comp";

	/** The Constant NODO_LONG_TERM_EVENT. */
	protected final static String NODO_LONG_TERM_EVENT = "NodoLTEvent";

	/**
	 * Gets the base style.
	 * 
	 * @param record
	 *            the record
	 * @param rowNum
	 *            the row num
	 * @param colNum
	 *            the col num
	 * @return the base style {@inheritDoc}
	 */
	@Override
	protected String getBaseStyle(ListGridRecord record, int rowNum, int colNum) {
		String type = "";
		if (record instanceof TreeNodeLongTermEvent) {
			type = NODO_LONG_TERM_EVENT;
		} else if (record instanceof TreeNodeBetType) {
			type = NODO_BET_TYPE;
		} else if (record instanceof TreeNodeError) {
			type = NODO_ERROR;
		}
		if (colNum == 0) {
			return new StringBuffer().append(RES_ARBOL_BANDERA).append(COMP)
					.append(type).toString();
		} else if (colNum == 1) {
			return new StringBuffer().append(RES_ARBOL_LINK).append(COMP)
					.append(type).toString();
		} else if (colNum == 2) {
			return new StringBuffer().append(RES_ARBOL_NORMAL).append(COMP)
					.append(type).toString();
		} else if (colNum == 3) {
				return new StringBuffer().append(RES_ARBOL_INFO).append(COMP)
						.append(type).toString();
		} else if (colNum == 4) {
			return new StringBuffer().append(RES_ARBOL_NORMAL).append(COMP)
					.append(type).toString();
		} else {
			return super.getBaseStyle(record, rowNum, colNum);
		}
	}

}
