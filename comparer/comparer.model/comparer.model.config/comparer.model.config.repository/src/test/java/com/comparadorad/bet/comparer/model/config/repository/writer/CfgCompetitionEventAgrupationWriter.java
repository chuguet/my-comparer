package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEventAgrupation;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

public class CfgCompetitionEventAgrupationWriter extends AbstractWriterXML<List<CfgCompetitionEventAgrupation>> {

	@Override
	protected boolean isExtended() {
		return false;
	}

	@Override
	protected List<CfgCompetitionEventAgrupation> makeObject() {
		List<CfgCompetitionEventAgrupation> result;
		CfgCompetitionEventAgrupation cfgCompetitionEventAgrupation;
		Order order;
		
		result  = new ArrayList<CfgCompetitionEventAgrupation>();
		cfgCompetitionEventAgrupation = new CfgCompetitionEventAgrupation();
		order  = new Order();
		
		order.setPriority(1);
		cfgCompetitionEventAgrupation.setName("Esto es una prueba");
		cfgCompetitionEventAgrupation.setOrder(order);
		result.add(cfgCompetitionEventAgrupation);
		
		return result;
	}

}
