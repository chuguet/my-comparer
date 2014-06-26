/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class Order.
 */
@SuppressWarnings("serial")
public class Order implements Comparable<Order>, Serializable {

	/** The order. */
	@Field
	@NotNull
	private Integer priority;

	public Order() {
		super();
	}

	public Order(Integer pPriority) {
		super();
		priority = pPriority;
	}

	/**
	 * Gets the priority.
	 * 
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 * 
	 * @param pPriority
	 *            the new priority
	 */
	public void setPriority(Integer pPriority) {
		priority = pPriority;
	}

	/** {@inheritDoc} */
	@Override
	public int compareTo(Order pOrder) {
		int result = 0;
		if (getPriority() > pOrder.getPriority()) {
			result = 1;
		} else {
			result = -1;
		}
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return this.priority.toString();
	}

}
