package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.IBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

@Component
public class XmlBetTypeToCfgBetTypeDefault implements IXmlBetTypeToCfgBetType {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	@Override
	public Object convert(Object targetObject, Object sourceObject, Class<?> pArg2, Class<?> pArg3, CfgBookmaker bookmaker,
			ISynchroErrorEvent synchroErrorEvent, XmlToRtResolverData xmlToResolverData) {
		CfgBetType result = new CfgBetType();
		LOG.debug(Thread.currentThread(), "Convertimos el tipo de apuesta");
		if (sourceObject instanceof XmlBetType) {
			XmlBetType xmlBetType = (XmlBetType) sourceObject;
			if (xmlBetType.getBetType() != null) {
				IBetType betTypeName = xmlBetType.getBetType();
				String tipo = betTypeName.getTypes()[0];
				if (tipo.equals(CfgBetTypeId.GANADOR.nameId())) {
					result.setNameId(CfgBetTypeId.GANADOR.nameId());
					result.setObjectId(CfgBetTypeId.GANADOR.id());
				} else if (tipo.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())) {
					result.setNameId(CfgBetTypeId.GANADOR_PARTIDO.nameId());
					result.setObjectId(CfgBetTypeId.GANADOR_PARTIDO.id());
				} else if (tipo.equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId())) {
					result.setNameId(CfgBetTypeId.HANDICAP_ASIATICO.nameId());
					result.setObjectId(CfgBetTypeId.HANDICAP_ASIATICO.id());
				} else if (tipo.equals(CfgBetTypeId.MAS_MENOS.nameId())) {
					result.setNameId(CfgBetTypeId.MAS_MENOS.nameId());
					result.setObjectId(CfgBetTypeId.MAS_MENOS.id());
				} else if (tipo.equals(CfgBetTypeId.MAXIMO_GOLEADOR.nameId())) {
					result.setNameId(CfgBetTypeId.MAXIMO_GOLEADOR.nameId());
					result.setObjectId(CfgBetTypeId.MAXIMO_GOLEADOR.id());
				} else if (tipo.equals(CfgBetTypeId.UNO_X_DOS.nameId())) {
					result.setNameId(CfgBetTypeId.UNO_X_DOS.nameId());
					result.setObjectId(CfgBetTypeId.UNO_X_DOS.id());
				} else if (tipo.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())) {
					result.setNameId(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId());
					result.setObjectId(CfgBetTypeId.UNO_X_DOS_HANDICAP.id());
				}
			}
		}
		LOG.debug(Thread.currentThread(), new StringBuffer("El tipo de apuesta es: ").append(result.getNameId()).toString());
		return result;
	}
}
