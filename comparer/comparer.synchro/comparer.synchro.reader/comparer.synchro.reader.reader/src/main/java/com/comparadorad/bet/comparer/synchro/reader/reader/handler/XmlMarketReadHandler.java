/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.handler;

import nu.xom.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.AbstractCfgBookmakerXmlReaderData;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderDataMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class XmlSportReadHandler.
 */
class XmlMarketReadHandler
		extends
		AbstractXmlBetFileReaderHandler<XmlMarket, CfgBookmakerXmlReaderDataMarket> {

	/** The Constant LOG. */
	private static final Log LOG = (Log) LogFactory
			.getLog(XmlMarketReadHandler.class);

	/**
	 * Instantiates a new xml market read handler.
	 * 
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public XmlMarketReadHandler(
			XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			AbstractCfgBookmakerXmlReaderData pAbstractCfgBookmakerXmlReaderData) {
		super(
				pXmlReaderHandlerConfiguration,
				(CfgBookmakerXmlReaderDataMarket) pAbstractCfgBookmakerXmlReaderData);
	}

	/**
	 * Process handle.
	 * 
	 * @param pElement
	 *            the element
	 * @return the xml market {@inheritDoc}
	 */
	@Override
	XmlMarket processHandle(Element pElement) throws XmlReaderException {
		XmlMarket xmlMarket = new XmlMarket();
		XmlBetType xmlBetType = new XmlBetType();
		xmlBetType.setCode(super.getElementValue(pElement,
				getXmlReaderConfigData().getCodeParam()));
		xmlBetType.setName(super.getElementValue(pElement,
				getXmlReaderConfigData().getNameParam()));
		if (super.getElementValue(pElement, getXmlReaderConfigData()
				.getBmInternalIdParamParam()) != null) {
			xmlBetType.setBmInternalId(new BmInternalId(super.getElementValue(
					pElement, getXmlReaderConfigData()
							.getBmInternalIdParamParam())));
		}
		xmlMarket.setXmlBetType(xmlBetType);

		// Leemos la url de la apuesta del market (si existe)
		XmlWebUrl xmlWebUrl = new XmlWebUrl();
		if (super.getElementValue(pElement, getXmlReaderConfigData()
				.getWebUrlParam()) != null) {
			xmlWebUrl.setUrl(super.getElementValue(pElement,
					getXmlReaderConfigData().getWebUrlParam()));
		}
		//xmlMarket.setXmlWebUrl(xmlWebUrl);
		return xmlMarket;
	}
}
