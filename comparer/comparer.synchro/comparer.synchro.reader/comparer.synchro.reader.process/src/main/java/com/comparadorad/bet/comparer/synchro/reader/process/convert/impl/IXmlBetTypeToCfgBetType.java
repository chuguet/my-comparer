package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.process.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;



public interface IXmlBetTypeToCfgBetType {
	
	public XmlBetTypeToCfgBetTypeEnum getXmlBetTypeToCfgBetTypeEnum();
	public Object convert (Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3, CfgBookmaker bookmaker, ISynchroErrorEvent synchroErrorEvent, XmlToRtResolverData xmlToResolverData);
}
