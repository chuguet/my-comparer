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
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;

/**
 * The Class AsianHandicapAttributeConverter.
 */
@Component
public class AttributeAsianHandicapConverter implements
		IAttribute<AbstractXMLAttribute> {

	/** {@inheritDoc} */
	@Override
	public AbstractRtAttribute convert(AbstractXMLAttribute xmlData) {
		RtAsianHandicapAttribute result = new RtAsianHandicapAttribute();
		XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) xmlData;
		result.setBetName(CfgBetTypeId.HANDICAP_ASIATICO.nameId());
		result.setAsianResult(dato.getAsianResult());
		result.setFirstValue(dato.getFirstValue());
		if (dato.getSecondValue() != null) {
			result.setSecondValue(dato.getSecondValue());
			result.setFinalValue((dato.getFirstValue() + dato.getSecondValue()) / 2);
		} else {
			result.setFinalValue(dato.getFirstValue());
		}
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return CfgBetTypeId.HANDICAP_ASIATICO.nameId();
	}

}
