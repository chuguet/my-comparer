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
 * The Class SportTreeGrid.
 */
public class SportTreeGrid extends GenericTreeGrid {

	/** The Constant NODO_COUNTRY. */
	protected final static String NODO_COUNTRY = "NodoCountry";

	/** The Constant SPORT. */
	protected final static String SPORT = "Deporte";

	/**
	 * Instantiates a new sport tree grid.
	 */
	public SportTreeGrid() {
		super();
	}

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
		if (record instanceof TreeNodeCountry) {
			type = NODO_COUNTRY;
		} else if (record instanceof TreeNodeCompetition) {
			type = NODO_COMP;
		} else if (record instanceof TreeNodeError) {
			type = NODO_ERROR;
		}
		if (colNum == 0) {
			return new StringBuffer().append(RES_ARBOL_BANDERA).append(SPORT)
					.append(type).toString();
		} else if (colNum == 1) {
			return new StringBuffer().append(RES_ARBOL_LINK).append(SPORT)
					.append(type).toString();
		} else if (colNum == 2 && type.equalsIgnoreCase(NODO_COUNTRY)) {
			return new StringBuffer().append(RES_ARBOL_SPECIAL).append(SPORT)
					.append(type).toString();
		} else if (colNum == 3) {
			return new StringBuffer().append(RES_ARBOL_INFO).append(SPORT)
					.append(type).toString();
		} else {
			return new StringBuffer().append(RES_ARBOL_NORMAL).append(SPORT)
					.append(type).toString();
		}
	}

}
