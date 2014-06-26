/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert;

import org.dozer.CustomConverter;
import org.dozer.Mapper;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Interface CustomConvertProcess.
 */
public interface CustomConvertProcess extends CustomConverter {

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Gets the cfg bookmaker.
	 * 
	 * @return the cfg bookmaker
	 */
	CfgBookmaker getCfgBookmaker();

	/**
	 * Sets the cfg bookmaker.
	 * 
	 * @param pCfgBookmaker
	 *            the new cfg bookmaker
	 */
	void setCfgBookmaker(CfgBookmaker pCfgBookmaker);

	/**
	 * Gets the mapper.
	 * 
	 * @return the mapper
	 */
	Mapper getMapper();

	/**
	 * Sets the mapper.
	 * 
	 * @param mapper
	 *            the new mapper
	 */
	void setMapper(Mapper mapper);
	
	/**
	 * Gets the xml to rt resolver data.
	 *
	 * @return the xml to rt resolver data
	 */
	XmlToRtResolverData getXmlToRtResolverData();
	
	void setXmlToRtResolverData(XmlToRtResolverData xmlToRtResolverData);
}
