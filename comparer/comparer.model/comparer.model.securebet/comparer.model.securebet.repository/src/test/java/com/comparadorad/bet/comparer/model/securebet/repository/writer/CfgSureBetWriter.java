package com.comparadorad.bet.comparer.model.securebet.repository.writer;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;

public class CfgSureBetWriter extends AbstractWriterXML<List<CfgSureBet>> {

	@Override
	protected boolean isExtended() {
		return false;
	}

	@Override
	protected List<CfgSureBet> makeObject() {
		List<CfgSureBet> result = new ArrayList<CfgSureBet>();

		CfgSureBet cfgSureBet = new CfgSureBet();
		cfgSureBet.setPorcentajeMinimo(1f);
		cfgSureBet.setRetardoTipo0(0);
		cfgSureBet.setRetardoTipo1(1);
		cfgSureBet.setRetardoTipo2(3);
		cfgSureBet.setRetardoTipo3(16);
		cfgSureBet.setMaxBenefit(new SecureBeanBenefit(20.0));

		result.add(cfgSureBet);

		return result;
	}

}
