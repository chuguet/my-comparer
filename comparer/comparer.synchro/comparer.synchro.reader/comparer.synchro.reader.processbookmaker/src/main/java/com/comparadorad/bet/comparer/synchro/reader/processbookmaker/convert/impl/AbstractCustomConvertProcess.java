/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.dozer.MappingException;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.util.logger.readerdatanoprocessed.LogReaderDataNoProcessed;

/**
 * The Class AbstractCustomConvertProcess.
 */
abstract class AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The cfg bookmaker. */
	private CfgBookmaker cfgBookmaker;

	/** The LO g_ dat a_ n o_ processed. */
	@Inject
	protected LogReaderDataNoProcessed LOG_DATA_NO_PROCESSED;

	/** The mapper. */
	private Mapper mapper;

	/** The synchro error event. */
	@Inject
	private ISynchroErrorEvent synchroErrorEvent;

	/** The xml to rt resolver data. */
	private XmlToRtResolverData xmlToRtResolverData;

	/**
	 * Gets the cfg bookmaker.
	 * 
	 * @return the cfg bookmaker
	 */
	public CfgBookmaker getCfgBookmaker() {
		return cfgBookmaker;
	}

	/**
	 * Gets the mapper.
	 * 
	 * @return the mapper {@inheritDoc}
	 */

	@Override
	public Mapper getMapper() {
		return mapper;
	}

	/**
	 * Gets the synchro error event.
	 * 
	 * @return the synchro error event
	 */
	public ISynchroErrorEvent getSynchroErrorEvent() {
		return synchroErrorEvent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert
	 * .CustomConvertProcess#getXmlToRtResolverData()
	 */
	@Override
	public XmlToRtResolverData getXmlToRtResolverData() {
		return xmlToRtResolverData;
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

	/**
	 * Sets the cfg bookmaker.
	 * 
	 * @param pCfgBookmaker
	 *            the new cfg bookmaker
	 */
	public void setCfgBookmaker(CfgBookmaker pCfgBookmaker) {
		cfgBookmaker = pCfgBookmaker;
	}

	/**
	 * Sets the mapper.
	 * 
	 * @param pMapper
	 *            the new mapper {@inheritDoc}
	 */

	@Override
	public void setMapper(Mapper pMapper) {
		mapper = pMapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert
	 * .CustomConvertProcess
	 * #setXmlToRtResolverData(com.comparadorad.bet.comparer
	 * .synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData)
	 */
	@Override
	public void setXmlToRtResolverData(XmlToRtResolverData pXmlToRtResolverData) {
		xmlToRtResolverData = pXmlToRtResolverData;
	}

}
