/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;

/**
 * The Class ResultValueBet.
 */
public class ResultValueBet {

	/** The value bet datas. */
	private List<ValueBetData> valueBetDatas;

	/**
	 * Adds the.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 */
	public void add(ValueBetData valueBetData) {
		getValueBetDatas().add(valueBetData);
	}

	/**
	 * Gets the value bet datas.
	 * 
	 * @return the value bet datas
	 */
	public List<ValueBetData> getValueBetDatas() {
		if (valueBetDatas == null) {
			valueBetDatas = new ArrayList<ValueBetData>();
		}
		return valueBetDatas;
	}

	/**
	 * Sets the value bet datas.
	 * 
	 * @param valueBetDatas
	 *            the new value bet datas
	 */
	public void setValueBetDatas(List<ValueBetData> valueBetDatas) {
		this.valueBetDatas = valueBetDatas;
	}

}
