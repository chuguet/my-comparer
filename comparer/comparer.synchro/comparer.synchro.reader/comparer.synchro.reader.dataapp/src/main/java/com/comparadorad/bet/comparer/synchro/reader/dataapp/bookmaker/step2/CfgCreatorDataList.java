/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step2;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.CfgCreatorData;

/**
 * The Class CfgCreatorDataList.
 */
public class CfgCreatorDataList {

	/** The creator data list. */
	private List<CfgCreatorData> creatorDataList = new ArrayList<CfgCreatorData>();

	public List<CfgCreatorData> getCreatorDataList() {
		return creatorDataList;
	}

	/** The is doubt list. */
	private boolean isDoubtList = false;

	/**
	 * Adds the.
	 * 
	 * @param pE
	 *            the p e
	 * @return true, if successful
	 */
	public boolean add(CfgCreatorData pE) {
		return creatorDataList.add(pE);
	}

	/**
	 * Checks if is doubt list.
	 * 
	 * @return true, if is doubt list
	 */
	public boolean isDoubtList() {
		return isDoubtList;
	}

	/**
	 * Sets the doubt list.
	 * 
	 * @param pIsDoubtList
	 *            the new doubt list
	 */
	public void setDoubtList(boolean pIsDoubtList) {
		isDoubtList = pIsDoubtList;
	}
}
