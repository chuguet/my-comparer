/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.comparadorad.bet.comparer.synchro.reader.datasource.config.ProxyPassConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlDataFileReaderException;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;

/**
 * The Class XMLMultipleFeedBuilder.
 */
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class XMLMultipleFeedBuilder extends AbstractXmlBuilder {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XMLMultipleFeedBuilder.class);

	/** The xpath. */
	private static XPath xpath;

	static {
		xpath = XPathFactory.newInstance().newXPath();
	}

	/**
	 * Evaluate xpath.
	 * 
	 * @param expression
	 *            the expression
	 * @param document
	 *            the document
	 * @return the node list
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	private static NodeList evaluateXpath(String expression, Document document)
			throws XmlDataFileReaderException {
		NodeList nodes = null;
		try {
			nodes = (NodeList) xpath.evaluate(expression,
					document.getDocumentElement(), XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			LOG.error(e.getMessage());
			throw new XmlDataFileReaderException(e.getMessage(), e);
		}
		return nodes;
	}

	/** The xpath expression. */
	private String xpathExpression;

	/**
	 * Instantiates a new xML multiple feed builder.
	 */
	public XMLMultipleFeedBuilder() {
		super();
	}

	/**
	 * Instantiates a new xML multiple feed builder.
	 * 
	 * @param pUrl
	 *            the url
	 */
	public XMLMultipleFeedBuilder(String pUrl) {
		super(pUrl);
	}

	/**
	 * Instantiates a new xML multiple feed builder.
	 * 
	 * @param pUrl
	 *            the url
	 * @param pProxyPassConfig
	 *            the proxy pass config
	 */
	public XMLMultipleFeedBuilder(String pUrl, ProxyPassConfig pProxyPassConfig) {
		super(pUrl, pProxyPassConfig);
	}

	/**
	 * Instantiates a new xML multiple feed builder.
	 * 
	 * @param url
	 *            the url
	 * @param proxyPassConfig
	 *            the proxy pass config
	 * @param expression
	 *            the expression
	 */
	public XMLMultipleFeedBuilder(String url, ProxyPassConfig proxyPassConfig,
			String expression) {
		super(url, proxyPassConfig);
		xpathExpression = expression;
	}

	/**
	 * Instantiates a new xML multiple feed builder.
	 * 
	 * @param pUrl
	 *            the url
	 * @param expression
	 *            the expression
	 */
	public XMLMultipleFeedBuilder(String pUrl, String expression) {
		super(pUrl);
		xpathExpression = expression;
	}

	/**
	 * Connect.
	 * 
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception {@inheritDoc}
	 * @throws XmlNotFoundException 
	 */
	@Override
	public void connect() throws XmlDataFileReaderException, XmlNotFoundException {
		Set<String> setUlr = new HashSet<String>();
		InputStream inputStream;
		inputStream = connect(getUrl());
		setUlr = getURIListFromFile(inputStream);
		for (String element : setUlr) {
			InputStream input = connect(element);
			CloseShieldInputStream closeShieldInputStream = new CloseShieldInputStream(
					input);
			XmlDataFile xmlDataFile = new XmlDataFile(closeShieldInputStream,
					element);
			getXmlDataFiles().addDataFile(xmlDataFile);
		}

	}

	/**
	 * Format.
	 * 
	 * @return the xml data files
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception {@inheritDoc}
	 */
	@Override
	public XmlDataFiles format() throws XmlDataFileReaderException {
		return getXmlDataFiles();
	}

	/**
	 * Gets the u rl.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @return the u rl
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	private Set<String> getURIListFromFile(InputStream inputStream)
			throws XmlDataFileReaderException {
		Document document;
		NodeList nodeList = null;
		Set<String> setUlr = new HashSet<String>();
		document = makeDocument(inputStream);
		nodeList = evaluateXpath(xpathExpression, document);
		String tmpUrl;
		for (int i = 0; i < nodeList.getLength(); i++) {
			tmpUrl = nodeList.item(i).getTextContent();
			if (!tmpUrl.startsWith("http")) {
				tmpUrl = getUrl() + tmpUrl;
			}
			setUlr.add(tmpUrl);
		}
		return setUlr;

	}

	/**
	 * Make document.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @return the document
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	private Document makeDocument(InputStream inputStream)
			throws XmlDataFileReaderException {
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			doc = factory.newDocumentBuilder().parse(inputStream);
		} catch (SAXException e) {
			LOG.error(e.getMessage());
			throw new XmlDataFileReaderException(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage());
			throw new XmlDataFileReaderException(e.getMessage(), e);
		} catch (ParserConfigurationException e) {
			LOG.error(e.getMessage());
			throw new XmlDataFileReaderException(e.getMessage(), e);
		}
		return doc;
	}

	/**
	 * Sets the xpath expression.
	 * 
	 * @param pXpathExpression
	 *            the new xpath expression
	 */
	public void setXpathExpression(String pXpathExpression) {
		xpathExpression = pXpathExpression;
	}
}
