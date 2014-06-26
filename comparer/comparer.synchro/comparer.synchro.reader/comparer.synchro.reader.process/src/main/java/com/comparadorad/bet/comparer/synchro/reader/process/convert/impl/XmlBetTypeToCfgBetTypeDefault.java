package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyGeneral;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.BetInactiveException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.BetTypeNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleBetTypeException;
import com.comparadorad.bet.comparer.synchro.reader.process.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.process.synonyms.ISynonymsComponent;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;

@Component
public class XmlBetTypeToCfgBetTypeDefault implements IXmlBetTypeToCfgBetType {

	/** The synonyms component. */
	@Inject
	private ISynonymsComponent synonymsComponent;

	@Inject
	private StringUtil stringUtil;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlBetTypeToCfgBetTypeDefault.class);

	@Override
	public XmlBetTypeToCfgBetTypeEnum getXmlBetTypeToCfgBetTypeEnum() {
		return XmlBetTypeToCfgBetTypeEnum.DEFAULT;
	}

	@Override
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3, CfgBookmaker bookmaker,
			ISynchroErrorEvent synchroErrorEvent,
			XmlToRtResolverData xmlToResolverData) {
		CfgBetType result = null;
		LOG.debug("Convertimos el tipo de apuesta");
		if (sourceObject instanceof XmlBetType) {
			XmlBetType xmlBetType = (XmlBetType) sourceObject;
			if (xmlBetType.getName() != null) {
				try {
					String betTypeName = xmlBetType.getName();

					CfgBookmakerBetTypeStrategyGeneral generalStrategyCfg = (CfgBookmakerBetTypeStrategyGeneral) bookmaker
							.getBookmakerConfiguration()
							.getBookmakerBetTypeStrategies()
							.get(CfgBookmakerBetTypeStrategyGeneral.STRATEGY_ID);
					if (generalStrategyCfg != null) {
						if (generalStrategyCfg.isDeleteParenthesis()) {
							betTypeName = stringUtil
									.deleteParenthesis(betTypeName);
						}
						if (generalStrategyCfg.isDeleteNegativeNumbers()) {
							betTypeName = stringUtil
									.deleteNegatives(betTypeName);
						}
						if (generalStrategyCfg.isDeleteNumbers()) {
							betTypeName = stringUtil.deleteNumbers(betTypeName);
						}
					}

					result = synonymsComponent.findByNameBetType(betTypeName);
					if (result != null) {
						xmlBetType.setCfgObjectId(result.getObjectId());
						if (result.getCoreActiveElement() != null
								&& !result.getCoreActiveElement().isActive(
										new Date())) {
							throw new BetInactiveException(new StringBuffer()
									.append("El tipo de apuesta ")
									.append(result.getName(null))
									.append(" esta desactivada.").toString());
						}
					}
				} catch (BetTypeNotFoundException e) {
					synchroErrorEvent.errorLog(e.getMessage(), e, xmlBetType,
							bookmaker);
					// throw new ConvertException(e);
				} catch (MultipleBetTypeException e) {
					synchroErrorEvent.errorLog(e.getMessage(), e, xmlBetType,
							bookmaker);
					// throw new ConvertException(e);
				} catch (BetInactiveException e) {
					synchroErrorEvent.errorLog(e.getMessage(), e, xmlBetType,
							bookmaker);
				}
			}
		}
		return result;
	}
}
