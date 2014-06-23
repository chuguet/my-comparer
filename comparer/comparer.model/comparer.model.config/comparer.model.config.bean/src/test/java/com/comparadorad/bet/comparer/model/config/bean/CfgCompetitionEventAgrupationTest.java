/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.Order;

/**
 * The Class CfgCompetitionEventAgrupationTest.
 */
public class CfgCompetitionEventAgrupationTest {
	
	/**
	 * Order test.
	 */
	@Test
	public final void orderTest() {

		List<CfgCompetitionEventAgrupation> list;
		CfgCompetitionEventAgrupation betTypeEvent;
		Order order;

		list = new ArrayList<CfgCompetitionEventAgrupation>();
		order = new Order();
		betTypeEvent = new CfgCompetitionEventAgrupation();
		order.setPriority(2);
		betTypeEvent.setName("Esto es la prueba 2");
		betTypeEvent.setOrder(order);
		list.add(betTypeEvent);

		betTypeEvent = new CfgCompetitionEventAgrupation();
		order = new Order();
		order.setPriority(1);
		betTypeEvent.setName("Esto es la prueba 1");
		betTypeEvent.setOrder(order);
		list.add(betTypeEvent);

		assertEquals(list.get(0).getOrder().getPriority(), new Integer(2));
		assertEquals(list.get(1).getOrder().getPriority(), new Integer(1));

		Collections.sort(list);

		assertEquals(list.get(0).getOrder().getPriority(), new Integer(1));
		assertEquals(list.get(1).getOrder().getPriority(), new Integer(2));

	}

}
