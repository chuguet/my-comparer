/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl;

import javax.inject.Inject;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.context.ApplicationContext;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;
import com.comparadorad.bet.comparer.model.bet.bean.RtBmInternalId;
import com.comparadorad.bet.comparer.model.bet.bean.RtInternalId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategies;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyGeneral;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.process.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.IXmlToRtResolver;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Interface IXmlToRtResolver.
 * 
 * @param <T>
 *            the generic type
 * @param <S>
 *            the generic type
 * @param <I>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractXmlToRtResolver<T extends IRtData, S extends IRtData, I extends AbstractXmlData>
		implements IXmlToRtResolver<T, S, I> {

	/** The Constant USER. */
	private final static String USER = "system";

	/** The mapper. */
	@Inject
	private ApplicationContext applicationContext;

	/**
	 * Gets the mapper.
	 * 
	 * @return the mapper
	 */
	private Mapper getMapper() {
		return applicationContext.getBean(Mapper.class);
	}

	/** The synchro error event. */
	@Inject
	private ISynchroErrorEvent synchroErrorEvent;

	/**
	 * Map.
	 * 
	 * @param <Z>
	 *            the generic type
	 * @param pSource
	 *            the source
	 * @param pDestinationClass
	 *            the destination class
	 * @param mapId
	 *            the map id
	 * @param pCfgBookmaker
	 *            the cfg bookmaker
	 * @return the z
	 * @throws MappingException
	 *             the mapping exception
	 */
	protected <Z> Z map(Object pSource, Class<Z> pDestinationClass,
			String mapId, final CfgBookmaker pCfgBookmaker,
			XmlToRtResolverData xmlToResolverData) throws MappingException {
		Mapper mapper = getMapper();
		if (mapper instanceof DozerBeanMapper) {
			for (String key : ((DozerBeanMapper) mapper)
					.getCustomConvertersWithId().keySet()) {
				CustomConverter customConverter = ((DozerBeanMapper) mapper)
						.getCustomConvertersWithId().get(key);
				if (customConverter instanceof CustomConvertProcess) {
					((CustomConvertProcess) customConverter)
							.setCfgBookmaker(pCfgBookmaker);
					((CustomConvertProcess) customConverter)
							.setXmlToRtResolverData(xmlToResolverData);
					((CustomConvertProcess) customConverter).setMapper(mapper);
				}
			}
		}
		return getMapper().map(pSource, pDestinationClass, mapId);
	}

	/**
	 * Gets the rt internal id.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 * @param pResolverData
	 *            the resolver data
	 * @return the rt internal id
	 */
	protected RtInternalId getRtInternalId(BmInternalId pBmInternalId,
			XmlToRtResolverData pResolverData) {
		RtInternalId result = null;
		if (pBmInternalId != null && pBmInternalId.getValue() != null
				&& pResolverData != null
				&& pResolverData.getBookmaker() != null) {
			result = new RtInternalId(pResolverData.getBookmaker(),
					new RtBmInternalId(pBmInternalId.getValue()));
		}
		return result;
	}

	/**
	 * Gets the rt internal id.
	 * 
	 * @param identifier
	 *            the identifier
	 * @param cfgBookmaker
	 *            the cfg bookmaker
	 * @return the rt internal id
	 */
	protected RtInternalId getRtInternalId(String identifier,
			CfgBookmaker cfgBookmaker) {
		RtInternalId result = null;
		if (identifier != null && cfgBookmaker != null) {
			result = new RtInternalId(cfgBookmaker, new RtBmInternalId(
					identifier));
		}
		return result;
	}

	/**
	 * Gets the synchro error event.
	 * 
	 * @return the synchro error event
	 */
	public ISynchroErrorEvent getSynchroErrorEvent() {
		return synchroErrorEvent;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	protected String getUser() {
		return USER;
	}

	/**
	 * Resolver xml to rt resolver data.
	 * 
	 * @param data
	 *            the data
	 * @param pData
	 *            the data
	 * @return the xml to rt resolver data
	 */
	protected abstract XmlToRtResolverData resolverXmlToRtResolverData(T data,
			XmlToRtResolverData pData);

	protected CfgBookmaker setBookmaker() {
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		CfgBookmakerConfiguration cfgBookmakerConfiguration = new CfgBookmakerConfiguration();
		CfgBookmakerBetTypeStrategies cfgBookmakerBetTypeStrategies = new CfgBookmakerBetTypeStrategies();
		CfgBookmakerBetTypeStrategyGeneral cfgBookmakerBetTypeStrategyGeneral = new CfgBookmakerBetTypeStrategyGeneral();
		cfgBookmakerBetTypeStrategyGeneral.setDeleteNegativeNumbers(false);
		cfgBookmakerBetTypeStrategies
				.addBetTypeStrategy(cfgBookmakerBetTypeStrategyGeneral);
		cfgBookmakerConfiguration
				.setBookmakerBetTypeStrategies(cfgBookmakerBetTypeStrategies);
		cfgBookmaker.setBookmakerConfiguration(cfgBookmakerConfiguration);
		return cfgBookmaker;
	}

}
