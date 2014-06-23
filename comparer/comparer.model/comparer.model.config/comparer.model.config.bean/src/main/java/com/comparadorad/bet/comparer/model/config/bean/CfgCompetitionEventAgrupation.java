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

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTable;
import com.comparadorad.bet.comparer.model.core.bean.IObjectOrder;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.core.bean.sort.ObjectOrderSort;

/**
 * The Class CfgCompetitionEventAgrupation.
 */
@SuppressWarnings("serial")
@Document
public class CfgCompetitionEventAgrupation extends AbstractI18nTable implements
		IObjectOrder<CfgCompetitionEventAgrupation> {

	/** The order. */
	@Field
	private Order order;

	/**
	 * Gets the order.
	 * 
	 * @return the order
	 */
	@Override
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 * 
	 * @param pOrder
	 *            the new order
	 */
	@Override
	public void setOrder(Order pOrder) {
		order = pOrder;
	}

	/**
	 * Compare to.
	 * 
	 * @param pCfgCompetitionEventAgrupation
	 *            the cfg competition event agrupation
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int compareTo(
			CfgCompetitionEventAgrupation pCfgCompetitionEventAgrupation) {
		return ObjectOrderSort.compareTo(this, pCfgCompetitionEventAgrupation);
	}

}
