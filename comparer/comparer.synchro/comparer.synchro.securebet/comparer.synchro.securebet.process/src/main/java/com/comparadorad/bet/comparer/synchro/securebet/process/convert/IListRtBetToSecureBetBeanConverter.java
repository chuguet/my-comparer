/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.convert;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

/**
 * The Interface IListRtBetToSecureBetBeanConverter.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
public interface IListRtBetToSecureBetBeanConverter<T, I> {

	/**
	 * Convert.
	 * 
	 * @param market
	 *            the market
	 * @param t
	 *            the t
	 * @return the i
	 */
	I convert(RtMatch match ,RtMarket market, T t);

}
