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
import com.comparadorad.bet.comparer.model.bet.bean.RtMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;

/**
 * The Class Abstract1x2AttributeConverter.
 */
@Component
public class AttributeMaximumGoalerConverter implements
		IAttribute<AbstractXMLAttribute> {

	@Override
	public AbstractRtAttribute convert(AbstractXMLAttribute xmlData) {
		RtMaximumGoalerAttribute result = new RtMaximumGoalerAttribute();
		XmlMaximumGoalerAttribute dato = (XmlMaximumGoalerAttribute) xmlData;
		result.setBetName(CfgBetTypeId.MAXIMO_GOLEADOR.nameId());
		result.setGoalerName(dato.getGoaler().getName());
		return result;
	}

	@Override
	public String getName() {
		return CfgBetTypeId.MAXIMO_GOLEADOR.nameId();
	}

}
