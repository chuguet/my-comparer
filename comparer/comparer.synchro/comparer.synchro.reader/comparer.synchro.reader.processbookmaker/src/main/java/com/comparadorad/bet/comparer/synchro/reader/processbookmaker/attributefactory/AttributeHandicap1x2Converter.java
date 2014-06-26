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
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;

/**
 * The Class AttributeHandicap1x2Converter.
 */
@Component
public class AttributeHandicap1x2Converter implements
		IAttribute<AbstractXMLAttribute> {

	/** {@inheritDoc} */
	@Override
	public AbstractRtAttribute convert(final AbstractXMLAttribute xmlData) {
		Rt1X2HandicapAttribute result = new Rt1X2HandicapAttribute();
		Xml1X2HandicapAttribute datoReader = (Xml1X2HandicapAttribute) xmlData;
		result.setBetName(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId());
		result.setResult(datoReader.getResult());
		result.setFirstValue(datoReader.getFirstValue());
		result.setSecondValue(datoReader.getSecondValue());
		if (datoReader.getSecondValue() != null) {
			result.setFinalValue((datoReader.getFirstValue() + datoReader
					.getSecondValue()) / 2);
		} else {
			result.setFinalValue(datoReader.getFirstValue());
		}
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId();
	}

}
