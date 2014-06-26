/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.handler;

import nu.xom.Element;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.AbstractCfgBookmakerXmlReaderData;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderDataMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.ParticipiantNames;
import com.comparadorad.bet.comparer.synchro.reader.model.ParticipiantNames.ParticipantName;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class XmlMatchReadHandler.
 */
class XmlMatchReadHandler
		extends
		AbstractXmlBetFileReaderHandler<XmlMatch, CfgBookmakerXmlReaderDataMatch> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlMatchReadHandler.class);

	/**
	 * Instantiates a new xml match read handler.
	 * 
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public XmlMatchReadHandler(
			XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			AbstractCfgBookmakerXmlReaderData pAbstractCfgBookmakerXmlReaderData) {
		super(
				pXmlReaderHandlerConfiguration,
				(CfgBookmakerXmlReaderDataMatch) pAbstractCfgBookmakerXmlReaderData);
	}

	/**
	 * Process handle.
	 * 
	 * @param pElement
	 *            the element
	 * @return the xml match {@inheritDoc}
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	@Override
	XmlMatch processHandle(Element pElement) throws XmlReaderException {
		XmlMatch xmlMatch = new XmlMatch();
		// Set start date param
		String dateXml = getElementValue(pElement, getXmlReaderConfigData()
				.getStartDateParam());
		if (dateXml != null) {
			xmlMatch.setStartDate(super.getDateUtil().getXmlDate(dateXml));
		}
		// Set live param to true or false (also in cases where the live
		// parameter is 'yes' or 'no')
		String live = getElementValue(pElement, getXmlReaderConfigData()
				.getLiveParam());
		if (live != null
				&& (live.equalsIgnoreCase("no") || live
						.equalsIgnoreCase("false"))) {
			xmlMatch.setLive(false);
		}
		if (live != null
				&& (live.equalsIgnoreCase("yes") || live
						.equalsIgnoreCase("true"))) {
			xmlMatch.setLive(true);
		}
		// Set live id param
		xmlMatch.setLiveId(getElementValue(pElement, getXmlReaderConfigData()
				.getLiveIdParam()));
		// Set streaming param
		xmlMatch.setStreaming(getElementValue(pElement,
				getXmlReaderConfigData().getStreamingParam()));
		// Extract participants name from the match name field
		if (getXmlReaderConfigData().isParticipantsInName()) {
			resolveParticipants(xmlMatch, pElement);
		}
		return xmlMatch;
	}

	/**
	 * Resolve participants.
	 * 
	 * @param xmlMatch
	 *            the xml match
	 * @param pElement
	 *            the element
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	private void resolveParticipants(XmlMatch xmlMatch, Element pElement)
			throws XmlReaderException {
		String nameParam = getElementValue(pElement, getXmlReaderConfigData()
				.getNameParam());
		String separator = getXmlReaderConfigData()
				.getParticipiansSeparatorParam().getXmlExtraInfoParam();
		if (StringUtils.isEmpty(separator)) {
			throw new XmlReaderException(
					"It's mandatory the separator of the participiant names");
		}
		// En algunos casos los participantes no están en el nombre de la
		// apuesta
		if (nameParam.contains(separator)) {
			String participiantNameType = getXmlReaderConfigData()
					.getParticipantsNameTypeParam().getXmlExtraInfoParam();
			ParticipiantNames participiantNames = new ParticipiantNames(
					nameParam, separator, participiantNameType);
			int index = 0;
			for (ParticipantName participantName : participiantNames
					.getParticipantNameArray()) {
				XmlMatchParticipant matchParticipant = new XmlMatchParticipant(
						participantName.getName(), participantName.getRole());
				// Si hay dos participantes, el primero será el de casa , el
				// segundo
				// el de fuera
				if (participiantNames.getParticipantNameArray().size() == 2) {
					if (index == 0) {
						matchParticipant.setHomeParticipant(true);
					} else {
						matchParticipant.setAwayParticipant(true);
					}
				}
				xmlMatch.addXmlMatchParticipant(matchParticipant);
				index++;
			}
		} else {
			getReaderVariables().setParticipantsInNameParamMarketBet(true);
		}
	}
}
