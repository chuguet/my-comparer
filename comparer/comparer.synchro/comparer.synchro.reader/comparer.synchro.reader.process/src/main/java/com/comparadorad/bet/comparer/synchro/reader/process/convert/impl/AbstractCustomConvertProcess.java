/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.dozer.MappingException;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.process.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Class AbstractCustomConvertProcess.
 */
abstract class AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The cfg bookmaker. */
	private CfgBookmaker cfgBookmaker;

	/** The synchro error event. */
	@Inject
	private ISynchroErrorEvent synchroErrorEvent;

	/** The mapper. */
	private Mapper mapper;
	
	private XmlToRtResolverData xmlToRtResolverData;

	/** {@inheritDoc} */

	@Override
	public Mapper getMapper() {
		return mapper;
	}

	/**
	 * Map.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param pArg0
	 *            the arg0
	 * @param pArg1
	 *            the arg1
	 * @param pArg2
	 *            the arg2
	 * @return the t
	 * @throws MappingException
	 *             the mapping exception
	 */
	public <T> T map(Object pArg0, Class<T> pArg1, String pArg2)
			throws MappingException {
		return mapper.map(pArg0, pArg1, pArg2);
	}

	/** {@inheritDoc} */

	@Override
	public void setMapper(Mapper pMapper) {
		mapper = pMapper;
	}

	/**
	 * Gets the cfg bookmaker.
	 * 
	 * @return the cfg bookmaker
	 */
	public CfgBookmaker getCfgBookmaker() {
		return cfgBookmaker;
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
	 * Sets the cfg bookmaker.
	 * 
	 * @param pCfgBookmaker
	 *            the new cfg bookmaker
	 */
	public void setCfgBookmaker(CfgBookmaker pCfgBookmaker) {
		cfgBookmaker = pCfgBookmaker;
	}

	@Override
	public XmlToRtResolverData getXmlToRtResolverData() {
		return  xmlToRtResolverData;
	}
	
	@Override
	public void setXmlToRtResolverData(XmlToRtResolverData pXmlToRtResolverData) {
		xmlToRtResolverData = pXmlToRtResolverData;
	}
	
	
}
