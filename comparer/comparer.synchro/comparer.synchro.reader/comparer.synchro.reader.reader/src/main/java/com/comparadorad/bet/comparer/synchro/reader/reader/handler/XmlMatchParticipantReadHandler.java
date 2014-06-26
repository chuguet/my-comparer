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
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderDataMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class XmlMatchParticipantReadHandler.
 */
class XmlMatchParticipantReadHandler
		extends
		AbstractXmlBetFileReaderHandler<XmlMatchParticipant, CfgBookmakerXmlReaderDataMatchParticipant> {

	/**
	 * Instantiates a new xml match participant read handler.
	 * 
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public XmlMatchParticipantReadHandler(
			XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			AbstractCfgBookmakerXmlReaderData pAbstractCfgBookmakerXmlReaderData) {
		super(
				pXmlReaderHandlerConfiguration,
				(CfgBookmakerXmlReaderDataMatchParticipant) pAbstractCfgBookmakerXmlReaderData);
	}

	/**
	 * Process handle.
	 * 
	 * @param pElement
	 *            the element
	 * @return the xml match {@inheritDoc}
	 */
	@Override
	XmlMatchParticipant processHandle(Element pElement)
			throws XmlReaderException {
		XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant();
		String role = getElementValue(pElement, getXmlReaderConfigData()
				.getRoleParam());
		if (role != null) {
			if (role.equals("1") || role.equalsIgnoreCase("home")) {
				xmlMatchParticipant.setHomeParticipant(true);
			} else if (role.equals("2") || role.equalsIgnoreCase("away")
					|| role.equalsIgnoreCase("visiting")) {
				xmlMatchParticipant.setAwayParticipant(true);
			}
			xmlMatchParticipant.setRole(role);
			// Special for PinnacleSport who treats Draw as a participant
			if (role.equalsIgnoreCase("draw")) {
				xmlMatchParticipant = null;
			}
		}
		return xmlMatchParticipant;
	}
}
