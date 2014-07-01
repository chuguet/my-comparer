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
 * The Class CountryTreeGrid.
 */
public class CountryTreeGrid extends GenericTreeGrid {

	/** The Constant COUNTRY. */
	protected final static String COUNTRY = "Pais";

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
		if (record instanceof TreeNodeCompetition) {
			type = NODO_COMP;
		} else if (record instanceof TreeNodeBetType) {
			type = NODO_BET_TYPE;
		} else if (record instanceof TreeNodeError) {
			type = NODO_ERROR;
		}
		if (colNum == 0) {
			return new StringBuffer().append(RES_ARBOL_BANDERA).append(COUNTRY)
					.append(type).toString();
		} else if (colNum == 1) {
			return new StringBuffer().append(RES_ARBOL_LINK).append(COUNTRY)
					.append(type).toString();
		} else if (colNum == 2) {
			return new StringBuffer().append(RES_ARBOL_NORMAL).append(COUNTRY)
					.append(type).toString();
		} else if (colNum == 3) {
			return new StringBuffer().append(RES_ARBOL_INFO).append(COUNTRY)
					.append(type).toString();
		} else if (colNum == 4) {
			return new StringBuffer().append(RES_ARBOL_NORMAL).append(COUNTRY)
					.append(type).toString();
		} else {
			return super.getBaseStyle(record, rowNum, colNum);
		}
	}

}
