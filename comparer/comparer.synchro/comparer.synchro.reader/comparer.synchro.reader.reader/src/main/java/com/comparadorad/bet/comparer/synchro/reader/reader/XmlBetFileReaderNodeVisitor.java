/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader;

import javax.annotation.Resource;
import javax.inject.Inject;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.reader.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderRuntimeException;
import com.comparadorad.bet.comparer.synchro.reader.reader.handler.AbstractXmlBetFileReaderHandler;
import com.comparadorad.bet.comparer.synchro.reader.reader.handler.XmlBetFileReaderHandlerFactory;
import com.comparadorad.bet.comparer.synchro.reader.reader.log.IReaderLogEvent;
import com.comparadorad.bet.comparer.synchro.reader.reader.util.XomUtil;

/**
 * The Class XmlBetFileReaderNodeVisitor.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class XmlBetFileReaderNodeVisitor {

	private static final Log LOG = LogFactory
			.getLog(XmlBetFileReaderNodeVisitor.class);

	/** The log event service. */
	@Inject
	private IReaderLogEvent readerLogEvent;
	/** The xml bet file reader data resolver. */
	@Resource
	private XmlBetFileReaderDataResolver xmlBetFileReaderDataResolver;

	/**
	 * Read document.
	 * 
	 * @param document
	 *            the document
	 * @param pCfgBookmakerXmlReader
	 *            the xml reader config
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @return the xml bookmaker events
	 */
	public XmlBookmakerEvents readDocument(final Document document,
			final XmlBetFileReaderData pXmlBetFileReaderData,
			final XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration)
			throws XmlReaderException {
		Element element = document.getRootElement();

		XmlBetFileReaderVariables matchVariables = new XmlBetFileReaderVariables();
		visitElement(element, pXmlBetFileReaderData,
				pXmlReaderHandlerConfiguration, matchVariables);
		return xmlBetFileReaderDataResolver.getXmlBookmakerEvents();
	}

	/**
	 * Visit element.
	 * 
	 * @param pElement
	 *            the element
	 * @param pCfgBookmakerXmlReader
	 *            the xml reader config
	 */
	private void visitElement(final Element pElement,
			final XmlBetFileReaderData pXmlBetFileReaderData,
			final XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			final XmlBetFileReaderVariables readerVariables)
			throws XmlReaderException {
		String nodePath = XomUtil.getElementXpath(pElement);
		// LOG.info("nodePath = " + nodePath);
		try {
			AbstractXmlBetFileReaderHandler<?, ?> handler = XmlBetFileReaderHandlerFactory
					.getGeneratorObject(nodePath,
							pXmlBetFileReaderData.getXmlReaderConfig(),
							pXmlReaderHandlerConfiguration);
			if (handler != null) {
				handler.setReaderVariables(readerVariables);
				AbstractXmlData abstractXmlData = handler.process(pElement,
						null);
				if (abstractXmlData != null) {
					this.xmlBetFileReaderDataResolver.resolveData(
							abstractXmlData,
							handler.getAbstractCfgBookmakerXmlReaderData(),
							readerVariables);
				}
			}
		} catch (XmlReaderRuntimeException e) {
			readerLogEvent.errorLog("No se encuentra el handler para el nodo:"
					+ nodePath, pXmlBetFileReaderData.getXmlReaderConfig(),
					new CfgBookmaker(pXmlBetFileReaderData
							.getXmlBookmakerData().getBookmakerId()));
		}
		if (pElement.getChildCount() > 0) {
			Elements elements = pElement.getChildElements();
			for (int i = 0; i < elements.size(); i++) {
				Element childElement = elements.get(i);
				visitElement(childElement, pXmlBetFileReaderData,
						pXmlReaderHandlerConfiguration, readerVariables);
			}
		}
	}
}
