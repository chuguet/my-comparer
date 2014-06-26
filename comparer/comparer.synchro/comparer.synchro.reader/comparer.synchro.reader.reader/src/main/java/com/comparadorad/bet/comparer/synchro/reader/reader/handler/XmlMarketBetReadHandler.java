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
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderDataMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class XmlSportReadHandler.
 */
class XmlMarketBetReadHandler
		extends
		AbstractXmlBetFileReaderHandler<XmlMarketBet, CfgBookmakerXmlReaderDataMarketBet> {

	/**
	 * Instantiates a new xml market bet read handler.
	 * 
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public XmlMarketBetReadHandler(
			XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			AbstractCfgBookmakerXmlReaderData pAbstractCfgBookmakerXmlReaderData) {
		super(
				pXmlReaderHandlerConfiguration,
				(CfgBookmakerXmlReaderDataMarketBet) pAbstractCfgBookmakerXmlReaderData);
	}

	/**
	 * Process handle.
	 * 
	 * @param pElement
	 *            the element
	 * @return the xml market bet {@inheritDoc}
	 */
	@Override
	XmlMarketBet processHandle(final Element pElement)
			throws XmlReaderException {
		final XmlMarketBet xmlMarketBet = new XmlMarketBet();
		// Set odd parameters (odd, american odd, fra odd)
		final String oddValue = getElementValue(pElement,
				getXmlReaderConfigData().getOddParam());
		final String americanOddValue = getElementValue(pElement,
				getXmlReaderConfigData().getAmericanOddParam());
		final String fraOddValue = getElementValue(pElement,
				getXmlReaderConfigData().getFraOddParam());
		if (oddValue != null || americanOddValue != null || fraOddValue != null) {
			XmlMarketBetOdd xmlMarketBetOdd = new XmlMarketBetOdd(oddValue);
			xmlMarketBetOdd.setAmericanOdds(getElementValue(pElement,
					getXmlReaderConfigData().getAmericanOddParam()));
			xmlMarketBetOdd.setFraOdds(getElementValue(pElement,
					getXmlReaderConfigData().getFraOddParam()));
			xmlMarketBet.setXmlMarketBetOdd(xmlMarketBetOdd);
		}
		// Set value param
		xmlMarketBet.setMarketBetValue(getElementValue(pElement,
				getXmlReaderConfigData().getValueParam()));
		// Extract participants name from the MarketBet name field
		if (getXmlReaderConfigData().isParticipantsInName()
				|| getReaderVariables().isParticipantsInNameParamMarketBet()) {
			String nameParam = getElementValue(pElement,
					getXmlReaderConfigData().getNameParam());
			XmlMatchParticipant matchParticipant = new XmlMatchParticipant(
					getElementValue(pElement, getXmlReaderConfigData()
							.getNameParam()));
			xmlMarketBet.setXmlMatchParticipant(matchParticipant);
		}

		return xmlMarketBet;
	}
}
