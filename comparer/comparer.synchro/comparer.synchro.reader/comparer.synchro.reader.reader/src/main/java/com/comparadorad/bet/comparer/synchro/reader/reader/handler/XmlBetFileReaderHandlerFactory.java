/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.handler;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.AbstractCfgBookmakerXmlReaderData;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlRegion;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderRuntimeException;

/**
 * A factory for creating XmlBetFileReaderHandler objects.
 */
public class XmlBetFileReaderHandlerFactory {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlBetFileReaderHandlerFactory.class);

	/**
	 * Gets the generator object.
	 * 
	 * @param nodePath
	 *            the node path
	 * @param pCfgBookmakerXmlReader
	 *            the xml reader config
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @return the generator object
	 */
	public static AbstractXmlBetFileReaderHandler<?, ?> getGeneratorObject(
			final String nodePath,
			final CfgBookmakerXmlReader pCfgBookmakerXmlReader,
			final XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration) {
		AbstractCfgBookmakerXmlReaderData abstractCfgBookmakerXmlReaderData = pCfgBookmakerXmlReader
				.getXmlReaderConfigData(nodePath);
		AbstractXmlBetFileReaderHandler<?, ?> handler = null;
		if (abstractCfgBookmakerXmlReaderData != null
				&& !abstractCfgBookmakerXmlReaderData.isEmptyReader()) {
			handler = getHandler(abstractCfgBookmakerXmlReaderData,
					pXmlReaderHandlerConfiguration);
			if (handler == null) {
				throw new XmlReaderRuntimeException(
						"No se ha creado el handler para: "
								+ abstractCfgBookmakerXmlReaderData
										.getGenerator());
			}
		}

		return handler;
	}

	/**
	 * Gets the handler.
	 * 
	 * @param abstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @return the handler
	 */
	public static AbstractXmlBetFileReaderHandler<?, ?> getHandler(
			final AbstractCfgBookmakerXmlReaderData abstractCfgBookmakerXmlReaderData,
			final XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration) {
		AbstractXmlBetFileReaderHandler<?, ?> handler = null;
		final String generator = abstractCfgBookmakerXmlReaderData
				.getGenerator();
		if (!StringUtils.isEmpty(generator)) {
			if (generator.equalsIgnoreCase(XmlBookmakerEvents.class
					.getSimpleName())) {
				handler = new XmlBookmakerEventsReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			} else if (generator.equalsIgnoreCase(XmlSport.class
					.getSimpleName())) {
				handler = new XmlSportReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			} else if (generator.equalsIgnoreCase(XmlRegion.class
					.getSimpleName())) {
				handler = new XmlRegionReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			} else if (generator.equalsIgnoreCase(XmlTournament.class
					.getSimpleName())) {
				handler = new XmlTournamentReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			} else if (generator.equalsIgnoreCase(XmlTournamentEvent.class
					.getSimpleName())) {
				handler = new XmlTournamentEventReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			} else if (generator.equalsIgnoreCase(XmlMatch.class
					.getSimpleName())) {
				handler = new XmlMatchReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			} else if (generator.equalsIgnoreCase(XmlMatchParticipant.class
					.getSimpleName())) {
				handler = new XmlMatchParticipantReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			} else if (generator.equalsIgnoreCase(XmlMarket.class
					.getSimpleName())) {
				handler = new XmlMarketReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			} else if (generator.equalsIgnoreCase(XmlMarketBet.class
					.getSimpleName())) {
				handler = new XmlMarketBetReadHandler(
						pXmlReaderHandlerConfiguration,
						abstractCfgBookmakerXmlReaderData);
			}
		}
		return handler;
	}
}
