/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.core.bean;

import java.util.List;

import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;

/**
 * The Class ValueBetQueue.
 */
public class ValueBetQueue extends AbstractQueue {

	/** The bet datas. */
	private final List<ValueBetData> betDatas;

	/**
	 * Instantiates a new value bet queue.
	 *
	 * @param betDatas the bet datas
	 */
	public ValueBetQueue(List<ValueBetData> betDatas) {
		super();
		this.betDatas = betDatas;
	}

	/**
	 * Gets the bet datas.
	 *
	 * @return the bet datas
	 */
	public List<ValueBetData> getBetDatas() {
		return betDatas;
	}

	@Override
	public String toString() {
		return "ValueBetQueue [betDatas=" + betDatas + "]";
	}
	
	
	
}
