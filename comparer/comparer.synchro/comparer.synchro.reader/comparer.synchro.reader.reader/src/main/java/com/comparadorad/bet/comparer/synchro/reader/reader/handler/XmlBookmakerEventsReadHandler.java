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
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderDataBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class XmlBookmakerEventsReadHandler.
 */
class XmlBookmakerEventsReadHandler
		extends
		AbstractXmlBetFileReaderHandler<XmlBookmakerEvents, CfgBookmakerXmlReaderDataBookmakerEvents> {

	/**
	 * Instantiates a new xml bookmaker events read handler.
	 * 
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public XmlBookmakerEventsReadHandler(
			XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			AbstractCfgBookmakerXmlReaderData pAbstractCfgBookmakerXmlReaderData) {
		super(
				pXmlReaderHandlerConfiguration,
				(CfgBookmakerXmlReaderDataBookmakerEvents) pAbstractCfgBookmakerXmlReaderData);
	}

	/**
	 * Process handle.
	 * 
	 * @param pElement
	 *            the element
	 * @return the xml bookmaker events {@inheritDoc}
	 */
	@Override
	XmlBookmakerEvents processHandle(Element pElement)
			throws XmlReaderException {
		XmlBookmakerEvents xmlBookmakerEvents = new XmlBookmakerEvents();
		String strFileDate = getElementValue(pElement, getXmlReaderConfigData()
				.getFileDateParam());
		if (strFileDate != null) {
			XmlDate fileDate = getDateUtil().getXmlDate(strFileDate);
			xmlBookmakerEvents.setFileDate(fileDate);
		}

		XmlBookmaker xmlBookmaker = new XmlBookmaker(super
				.getXmlReaderHandlerConfiguration().getXmlBetFileReaderData()
				.getXmlBookmakerData().getName());
		xmlBookmakerEvents.setXmlBookmaker(xmlBookmaker);
		return xmlBookmakerEvents;
	}
}
