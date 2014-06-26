/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.attributefactory;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;

/**
 * The Class AsianHandicapAttributeConverter.
 */
@Component
public class AttributeGanadorConverter implements IAttribute<AbstractXMLAttribute> {

	/** {@inheritDoc} */
	@Override
	public AbstractRtAttribute convert(AbstractXMLAttribute xmlData) {
		RtGanadorAttribute result = new RtGanadorAttribute();
		XmlWinnerAttribute dato = (XmlWinnerAttribute) xmlData;
		result.setBetName(CfgBetTypeId.GANADOR.nameId());
		result.setWinnerName(dato.getWinner().getName());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return CfgBetTypeId.GANADOR.nameId();
	}

}
