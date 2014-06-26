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
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderDataTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class XmlSportReadHandler.
 */
class XmlTournamentEventReadHandler
		extends
		AbstractXmlBetFileReaderHandler<XmlTournamentEvent, CfgBookmakerXmlReaderDataTournamentEvent> {

	/**
	 * Instantiates a new xml tournament read handler.
	 * 
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public XmlTournamentEventReadHandler(
			XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			AbstractCfgBookmakerXmlReaderData pAbstractCfgBookmakerXmlReaderData) {
		super(
				pXmlReaderHandlerConfiguration,
				(CfgBookmakerXmlReaderDataTournamentEvent) pAbstractCfgBookmakerXmlReaderData);
	}

	/**
	 * Process handle.
	 * 
	 * @param pElement
	 *            the element
	 * @return the xml tournament {@inheritDoc}
	 */
	@Override
	XmlTournamentEvent processHandle(Element pElement)
			throws XmlReaderException {

		XmlTournamentEvent xmlTournamentEvent = new XmlTournamentEvent();
		xmlTournamentEvent.setStartDate(getDateUtil().getXmlDate(
				getElementValue(pElement, getXmlReaderConfigData()
						.getStartDateParam())));
		xmlTournamentEvent.setEndDate(getDateUtil().getXmlDate(
				getElementValue(pElement, getXmlReaderConfigData()
						.getEndDateParam())));
		return xmlTournamentEvent;
	}
}
