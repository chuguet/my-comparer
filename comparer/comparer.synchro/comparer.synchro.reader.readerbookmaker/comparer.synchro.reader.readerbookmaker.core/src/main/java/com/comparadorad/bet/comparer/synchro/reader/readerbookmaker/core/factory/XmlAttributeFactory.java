/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.factory;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.model.IXmlAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;

/**
 * A factory for creating XmlAttribute objects.
 */
public class XmlAttributeFactory {

	/**
	 * Instantiates a new xml attribute factory.
	 */
	private XmlAttributeFactory() {
	}

	/**
	 * Gets the xml attribute.
	 * 
	 * @param pXmlBetType
	 *            the xml bet type
	 * @return the xml attribute
	 */
	public static IXmlAttribute getXmlAttribute(XmlBetType pXmlBetType) {
		IXmlAttribute result = null;
		if (pXmlBetType.getBetType() != null) {
			if (pXmlBetType.getBetType().getId()
					.equals(CfgBetTypeId.UNO_X_DOS.nameId())) {
				result = new Xml1X2Attribute();
			} else if (pXmlBetType.getBetType().getId()
					.equals(CfgBetTypeId.GANADOR.nameId())) {
				result = new XmlWinnerAttribute();
			} else if (pXmlBetType.getBetType().getId()
					.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())) {
				result = new XmlMatchWinnerAttribute();
			} else if (pXmlBetType.getBetType().getId()
					.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())) {
				result = new Xml1X2HandicapAttribute();
			} else if (pXmlBetType.getBetType().getId()
					.equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId())) {
				result = new XmlAsianHandicapAttribute();
			} else if (pXmlBetType.getBetType().getId()
					.equals(CfgBetTypeId.MAS_MENOS.nameId())) {
				result = new XmlMoreLessAttribute();
			} else if (pXmlBetType.getBetType().getId()
					.equals(CfgBetTypeId.MAXIMO_GOLEADOR.nameId())) {
				result = new XmlMaximumGoalerAttribute();
			}
		}
		return result;
	}
}
