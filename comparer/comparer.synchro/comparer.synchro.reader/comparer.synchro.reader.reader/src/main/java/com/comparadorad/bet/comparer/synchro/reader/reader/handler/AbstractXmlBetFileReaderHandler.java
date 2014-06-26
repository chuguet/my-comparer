/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.handler;

import nu.xom.Element;
import nu.xom.ParentNode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.AbstractCfgBookmakerXmlReaderData;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReaderParam;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlBetFileReaderVariables;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.reader.XmlReaderHandlerConfiguration.XmlDateFormatUtil;
import com.comparadorad.bet.comparer.synchro.reader.reader.exception.XmlReaderException;

/**
 * The Class AbstractXmlBetFileReaderHandler.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
public abstract class AbstractXmlBetFileReaderHandler<T extends AbstractXmlData, I extends AbstractCfgBookmakerXmlReaderData> {

	/** The Constant LOG. */
	private static final Log LOG = (Log) LogFactory
			.getLog(AbstractXmlBetFileReaderHandler.class);

	/** The Constant XML_ID_PARAM. */
	public static final String XML_ID_PARAM = "bmInternalId";

	/** The Constant XML_NAME_PARAM. */
	public static final String XML_NAME_PARAM = "name";

	/** The xml reader config data. */
	private final I abstractCfgBookmakerXmlReaderData;

	/** The reader variables. */
	private XmlBetFileReaderVariables readerVariables;

	/** The xml reader handler configuration. */
	private final XmlReaderHandlerConfiguration xmlReaderHandlerConfiguration;

	/**
	 * Instantiates a new abstract xml bet file reader handler.
	 * 
	 * @param pXmlReaderHandlerConfiguration
	 *            the xml reader handler configuration
	 * @param pAbstractCfgBookmakerXmlReaderData
	 *            the xml reader config data
	 */
	public AbstractXmlBetFileReaderHandler(
			XmlReaderHandlerConfiguration pXmlReaderHandlerConfiguration,
			final I pAbstractCfgBookmakerXmlReaderData) {
		super();
		xmlReaderHandlerConfiguration = pXmlReaderHandlerConfiguration;
		this.abstractCfgBookmakerXmlReaderData = pAbstractCfgBookmakerXmlReaderData;
	}

	/**
	 * Gets the abstract cfg bookmaker xml reader data.
	 * 
	 * @return the abstract cfg bookmaker xml reader data
	 */
	public I getAbstractCfgBookmakerXmlReaderData() {
		return abstractCfgBookmakerXmlReaderData;
	}

	/**
	 * Gets the date util.
	 * 
	 * @return the date util
	 */
	public XmlDateFormatUtil getDateUtil() {
		return xmlReaderHandlerConfiguration.getDateUtil();
	}

	/**
	 * Gets the element value.
	 * 
	 * @param pElement
	 *            the element
	 * @param readerParam
	 *            the reader param
	 * @return the element value
	 */
	protected String getElementValue(Element pElement,
			CfgBookmakerXmlReaderParam readerParam) {
		String value = null;
		if (readerParam != null && readerParam.getDataLocation() != null) {
			switch (readerParam.getDataLocation()) {
			case CURRENT_NODE_ATTRIBUTE:
				if (readerParam.getXmlAttributeName() != null) {
					value = pElement.getAttributeValue(readerParam
							.getXmlAttributeName());
				}
				break;
			case CURRENT_NODE_BODY:
				value = pElement.getValue();
				break;
			case CURRENT_NODE_PATH_NAME:
				if (readerParam.getXmlNodeName() != null) {
					value = readerParam.getXmlNodeName();
				}
				break;
			case CHILD_NODE_ATTRIBUTE:
				// TODO
				break;
			case CHILD_NODE_BODY:
				if (readerParam.getXmlNodeName() != null) {
					Element childElement = pElement.getFirstChildElement(
							readerParam.getXmlNodeName(), "");
					if (childElement != null) {
						value = childElement.getValue();
					}
				}
				break;
			case PARENT_NODE_ATTRIBUTE:
				// TODO
				break;
			case PARENT_NODE_BODY:
				// TODO
				break;
			case BROTHER_NODE_ATTRIBUTE:
				// TODO
				break;
			case BROTHER_NODE_BODY:
				if (readerParam.getXmlNodeName() != null) {
					ParentNode parentNode = pElement.getParent();
					Element parentElement = (Element) parentNode;
					Element childElement = parentElement.getFirstChildElement(
							readerParam.getXmlNodeName(), "");
					if (childElement != null) {
						value = childElement.getValue();
					}
				}
				break;
			default:
				LOG.error("El DataLocation no está especificado");
			}
		}
		return value;
	}

	/**
	 * Gets the reader variables.
	 * 
	 * @return the reader variables
	 */
	protected XmlBetFileReaderVariables getReaderVariables() {
		return readerVariables;
	}

	/**
	 * Gets the xml reader config data.
	 * 
	 * @return the xml reader config data
	 */
	public I getXmlReaderConfigData() {
		return abstractCfgBookmakerXmlReaderData;
	}

	/**
	 * Gets the xml reader handler configuration.
	 * 
	 * @return the xml reader handler configuration
	 */
	public XmlReaderHandlerConfiguration getXmlReaderHandlerConfiguration() {
		return xmlReaderHandlerConfiguration;
	}

	/**
	 * Process.
	 * 
	 * @param pElement
	 *            the element
	 * @param data
	 *            the data
	 * @return the abstract xml data
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	@SuppressWarnings("rawtypes")
	public AbstractXmlData process(Element pElement, Object data)
			throws XmlReaderException {
		this.readerVariables = readerVariables;
		AbstractXmlData abstractXmlData = processHandle(pElement);
		if (abstractXmlData != null) {
			setNameAttribute(abstractXmlData, pElement);
			setIdAttribute(abstractXmlData, pElement);
		}
		return abstractXmlData;
	}

	/**
	 * Process handle.
	 * 
	 * @param element
	 *            the element
	 * @return the abstract xml data
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	abstract AbstractXmlData processHandle(Element element)
			throws XmlReaderException;

	/**
	 * Sets the id attribute.
	 * 
	 * @param pAbstractXmlData
	 *            the abstract xml data
	 * @param pElement
	 *            the element
	 */
	protected void setIdAttribute(final AbstractXmlData pAbstractXmlData,
			final Element pElement) {
		String value = null;
		CfgBookmakerXmlReaderParam readerParam;
		readerParam = getAbstractCfgBookmakerXmlReaderData()
				.getXmlReaderConfigDataParameter(XML_ID_PARAM);
		value = getElementValue(pElement, readerParam);
		if (value != null) {
			pAbstractXmlData.setBmInternalId(new BmInternalId(value));
		}
	}

	/**
	 * Sets the name attribute.
	 * 
	 * @param pAbstractXmlData
	 *            the abstract xml data
	 * @param pElement
	 *            the element
	 */
	protected void setNameAttribute(final AbstractXmlData pAbstractXmlData,
			final Element pElement) {
		String value = null;
		CfgBookmakerXmlReaderParam readerParam;
		readerParam = getAbstractCfgBookmakerXmlReaderData()
				.getXmlReaderConfigDataParameter(XML_NAME_PARAM);
		value = getElementValue(pElement, readerParam);
		if (value != null) {
			pAbstractXmlData.setName(value);
		}
	}

	/**
	 * Sets the reader variables.
	 * 
	 * @param pReaderVariables
	 *            the new reader variables
	 */
	public void setReaderVariables(XmlBetFileReaderVariables pReaderVariables) {
		readerVariables = pReaderVariables;
	}

}
