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
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;

/**
 * The Class Abstract1x2AttributeConverter.
 */
@Component
public class AttributeMasMenosConverter implements
		IAttribute<AbstractXMLAttribute> {

	/** {@inheritDoc} */
	@Override
	public AbstractRtAttribute convert(AbstractXMLAttribute xmlData) {
		RtMasMenosAttribute result = new RtMasMenosAttribute();
		XmlMoreLessAttribute dato = (XmlMoreLessAttribute) xmlData;
		result.setBetName(CfgBetTypeId.MAS_MENOS.nameId());
		result.setMasMenos(dato.getMasMenos());
		result.setTotalGoalValue(dato.getTotalGoal());
		// TODO si se meten first y second value hay que reimplementar y meter
		// en final value la media de los dos valores
		result.setFinalValue(dato.getTotalGoal());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return CfgBetTypeId.MAS_MENOS.nameId();
	}

}
