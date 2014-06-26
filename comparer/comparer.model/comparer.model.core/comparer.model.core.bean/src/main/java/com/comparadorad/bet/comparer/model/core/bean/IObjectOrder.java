/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

/**
 * The Interface IObjectOrder.
 *
 * @param <T> the generic type
 */
public interface IObjectOrder<T> extends Comparable<T> {
	/**
	 * Gets the order.
	 *
	 * @return the order
	 */
	Order getOrder();
	
	/**
	 * Sets the order.
	 *
	 * @param pOrder the new order
	 */
	void setOrder(Order pOrder);
}
