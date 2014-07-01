/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables;

/**
 * The Class ColIds.
 */
public class ColName {

	private final static String COL = "col";
	
	/** The Constant COL0. */
	private final static String COL0 = "col0";

	/** The Constant COL1. */
	private final static String COL1 = "col1";

	/** The Constant COL2. */
	private final static String COL2 = "col2";

	/** The Constant COL3. */
	private final static String COL3 = "col3";

	/** The Constant COL4. */
	private final static String COL4 = "col4";

	/** The Constant COL5. */
	private final static String COL5 = "col5";

	/** The Constant COL6. */
	private final static String COL6 = "col6";

	/** The Constant COL7. */
	private final static String COL7 = "col7";

	/** The Constant COL8. */
	private final static String COL8 = "col8";

	/**
	 * Gets the col0.
	 * 
	 * @return the col0
	 */
	public static String getCol0() {
		return COL0;
	}

	/**
	 * Gets the col1.
	 * 
	 * @return the col1
	 */
	public static String getCol1() {
		return COL1;
	}

	/**
	 * Gets the col2.
	 * 
	 * @return the col2
	 */
	public static String getCol2() {
		return COL2;
	}

	/**
	 * Gets the col3.
	 * 
	 * @return the col3
	 */
	public static String getCol3() {
		return COL3;
	}

	/**
	 * Gets the col4.
	 * 
	 * @return the col4
	 */
	public static String getCol4() {
		return COL4;
	}

	/**
	 * Gets the col5.
	 * 
	 * @return the col5
	 */
	public static String getCol5() {
		return COL5;
	}

	/**
	 * Gets the col6.
	 * 
	 * @return the col6
	 */
	public static String getCol6() {
		return COL6;
	}

	/**
	 * Gets the col7.
	 * 
	 * @return the col7
	 */
	public static String getCol7() {
		return COL7;
	}

	/**
	 * Gets the col8.
	 * 
	 * @return the col8
	 */
	public static String getCol8() {
		return COL8;
	}
	
	public static String getCol(int colNum) {
		return new StringBuffer(6).append(COL).append(colNum).toString();
	}
	
	public static String getCol(String colId) {
		return new StringBuffer().append(COL).append(colId).toString();
	}

}
