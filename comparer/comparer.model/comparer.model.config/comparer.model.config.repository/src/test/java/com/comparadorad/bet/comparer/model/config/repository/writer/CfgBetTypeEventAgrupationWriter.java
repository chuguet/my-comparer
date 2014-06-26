package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventAgrupation;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

public class CfgBetTypeEventAgrupationWriter extends AbstractWriterXML<List<CfgBetTypeEventAgrupation>> {

	@Override
	protected boolean isExtended() {
		return false;
	}

	@Override
	protected List<CfgBetTypeEventAgrupation> makeObject() {
		List<CfgBetTypeEventAgrupation> result;
		CfgBetTypeEventAgrupation cfgBetTypeEventAgrupation;
		Order order;
		
		result = new ArrayList<CfgBetTypeEventAgrupation>();
		cfgBetTypeEventAgrupation = new CfgBetTypeEventAgrupation();
		order = new Order();
		order.setPriority(1);
		cfgBetTypeEventAgrupation.setName("Esto es una prueba");
		result.add(cfgBetTypeEventAgrupation);
		
		return result;
	}

}
