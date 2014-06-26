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
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;

/**
 * The Class AsianHandicapAttributeConverter.
 */
@Component
public class AttributeGanadorPartidoConverter implements IAttribute<AbstractXMLAttribute> {

	/** {@inheritDoc} */
	@Override
	public AbstractRtAttribute convert(AbstractXMLAttribute xmlData) {
		RtGanadorPartidoAttribute result = new RtGanadorPartidoAttribute();
		XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) xmlData;
		result.setBetName(CfgBetTypeId.GANADOR_PARTIDO.nameId());
		result.setWinnerName(dato.getWinnerName().getName());
		result.setResult(dato.getResult());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return CfgBetTypeId.GANADOR_PARTIDO.nameId();
	}

}
