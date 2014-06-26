/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.synchro.reader.reader.handler;

import nu.xom.Element;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.AbstractCfgBookmakerXmlReaderData;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderDataRegion;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlRegion;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class XmlRegionReadHandler.
 */
class XmlRegionReadHandler
		extends
		AbstractXmlBetFileReaderHandler<XmlRegion, CfgBookmakerXmlReaderDataRegion> {

	/**
	 * Instantiates a new xml sport type read handler.
	 * 
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public XmlRegionReadHandler(
			XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			AbstractCfgBookmakerXmlReaderData pAbstractCfgBookmakerXmlReaderData) {
		super(
				pXmlReaderHandlerConfiguration,
				(CfgBookmakerXmlReaderDataRegion) pAbstractCfgBookmakerXmlReaderData);
	}

	/**
	 * Process handle.
	 * 
	 * @param pElement
	 *            the element
	 * @return the xml region {@inheritDoc}
	 */
	@Override
	XmlRegion processHandle(Element pElement) throws XmlReaderException {
		XmlRegion xmlRegion = new XmlRegion(pElement.getValue());	//sets the name
		//return new XmlSport();
		return xmlRegion;
	}

}
