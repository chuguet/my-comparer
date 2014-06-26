package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;



public interface IXmlBetTypeToCfgBetType {


	public Object convert (Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3, CfgBookmaker bookmaker, ISynchroErrorEvent synchroErrorEvent, XmlToRtResolverData xmlToResolverData);
}
