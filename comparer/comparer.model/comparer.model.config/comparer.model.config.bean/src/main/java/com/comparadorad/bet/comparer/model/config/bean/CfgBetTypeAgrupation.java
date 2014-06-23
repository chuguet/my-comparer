/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.IObjectOrder;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.core.bean.sort.ObjectOrderSort;

/**
 * The Class CfgBetTypeAgrupation.
 */
@SuppressWarnings("serial")
@Document
public class CfgBetTypeAgrupation extends AbstractI18nTableActivable implements
		IObjectOrder<CfgBetTypeEventAgrupation> {

	/** The order. */
	@Field
	private Order order;

	 /**
 	 * Compare to.
 	 *
 	 * @param agrupation the agrupation
 	 * @return the int
 	 * {@inheritDoc}
 	 */ 
	@Override
	public int compareTo(CfgBetTypeEventAgrupation agrupation) {
		return ObjectOrderSort.compareTo(this, agrupation);
	}

	 /**
 	 * Gets the order.
 	 *
 	 * @return the order
 	 * {@inheritDoc}
 	 */ 
	@Override
	public Order getOrder() {
		return order;
	}

	 /**
 	 * Sets the order.
 	 *
 	 * @param pOrder the new order
 	 * {@inheritDoc}
 	 */ 
	@Override
	public void setOrder(Order pOrder) {
		this.order = pOrder;

	}

}
