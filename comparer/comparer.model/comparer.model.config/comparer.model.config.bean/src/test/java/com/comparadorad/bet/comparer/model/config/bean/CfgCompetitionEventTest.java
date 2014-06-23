package com.comparadorad.bet.comparer.model.config.bean;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.Order;

public class CfgCompetitionEventTest {

	
	@Test
	public final void orderTest(){
		List<CfgCompetitionEvent> list;		
		CfgCompetitionEvent betTypeEvent;
		Order order;
		
		list  = new ArrayList<CfgCompetitionEvent>();
		order = new Order();
		betTypeEvent = new CfgCompetitionEvent();
		order.setPriority(2);
		betTypeEvent.setName("Esto es la prueba 2");
		betTypeEvent.setOrder(order);
		list.add(betTypeEvent);
		
		betTypeEvent = new CfgCompetitionEvent();
		order = new Order();
		order.setPriority(1);
		betTypeEvent.setName("Esto es la prueba 1");
		betTypeEvent.setOrder(order);
		list.add(betTypeEvent);
		
		assertEquals(list.get(0).getOrder().getPriority(),new Integer(2));
		assertEquals(list.get(1).getOrder().getPriority(),new Integer(1));
		
		Collections.sort(list);
		
		assertEquals(list.get(0).getOrder().getPriority(),new Integer(1));
		assertEquals(list.get(1).getOrder().getPriority(),new Integer(2));
	}
}
