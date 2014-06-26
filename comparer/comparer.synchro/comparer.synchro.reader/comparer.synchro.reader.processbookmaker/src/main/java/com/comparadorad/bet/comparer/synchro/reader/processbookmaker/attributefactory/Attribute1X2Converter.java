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
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;

/**
 * The Class Abstract1x2AttributeConverter.
 */
@Component
public class Attribute1X2Converter implements IAttribute<AbstractXMLAttribute> {

	/** {@inheritDoc} */
	@Override
	public AbstractRtAttribute convert(AbstractXMLAttribute xmlData) {
		Rt1X2Attribute result = new Rt1X2Attribute();
		Xml1X2Attribute dato = (Xml1X2Attribute) xmlData;
		result.setBetName(CfgBetTypeId.UNO_X_DOS.nameId());
		result.setResult(dato.getResult());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return CfgBetTypeId.UNO_X_DOS.nameId();
	}

}
