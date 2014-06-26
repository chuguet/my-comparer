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
import java.net.ConnectException;
import java.net.MalformedURLException;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.synchro.reader.datasource.config.ProxyPassConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.HttpClientConnection.HttpClientConnectionException;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlDataFileReaderException;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;

/**
 * The Class XmlBuilder.
 */
public abstract class AbstractXmlBuilder {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractXmlBuilder.class);

	/** The datasource proxy. */
	@Inject
	private DatasourceProxy datasourceProxy;

	/** The proxy pass config. */
	@Inject
	private ProxyPassConfig proxyPassConfig;

	/** The url. */
	private String url;

	/** The xml data files. */
	private XmlDataFiles xmlDataFiles;

	/** The Xmlnew. */
	private boolean xmlnew;

	/**
	 * Instantiates a new abstract xml builder.
	 */
	public AbstractXmlBuilder() {
		super();
	}

	/**
	 * Instantiates a new xML bookmaker builder.
	 * 
	 * @param url
	 *            the url
	 */
	protected AbstractXmlBuilder(String url) {
		super();
		this.url = url;
	}

	/**
	 * Instantiates a new xml builder.
	 * 
	 * @param url
	 *            the url
	 * @param proxyPassConfig
	 *            the proxy pass config
	 */
	protected AbstractXmlBuilder(String url, ProxyPassConfig proxyPassConfig) {
		super();
		this.url = url;
		this.proxyPassConfig = proxyPassConfig;
	}

	/**
	 * Connect.
	 * 
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	public abstract void connect() throws XmlDataFileReaderException, XmlNotFoundException;

	/**
	 * Connect.
	 * 
	 * @param url
	 *            the url
	 * @return the input stream
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 * @throws XmlNotFoundException 
	 */
	protected InputStream connect(String url) throws XmlDataFileReaderException, XmlNotFoundException {

		LOG.debug("Url to connect: " + url);
		InputStream inputStream = null;
		try {
			HttpClientConnection clientConnection = new HttpClientConnection(
					true);
			if (datasourceProxy != null && datasourceProxy.isActive()) {
				inputStream = datasourceProxy.doConnection(url,
						proxyPassConfig, clientConnection);
			} else {
				inputStream = clientConnection.doConnection(url,
						proxyPassConfig);
			}
		} catch (MalformedURLException e) {
			LOG.error(e.getMessage());
			throw new XmlDataFileReaderException(e.getMessage(), e);
		} catch (ConnectException e){
			LOG.error(e.getMessage() + " No se ha podido descargar la url: " + url);
		}
		catch (IOException e) {
			LOG.error(e.getMessage());
			throw new XmlDataFileReaderException(e.getMessage() + " url: "
					+ url, e);
		} catch (HttpClientConnectionException e) {
			LOG.error(e.getMessage());
			throw new XmlNotFoundException(e.getMessage(), e);
		}
		return inputStream;

	}

	/**
	 * Format.
	 * 
	 * @return the close shield input stream
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	public abstract XmlDataFiles format() throws XmlDataFileReaderException;

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the xml data files.
	 * 
	 * @return the xml data files
	 */
	public XmlDataFiles getXmlDataFiles() {
		if (xmlDataFiles == null) {
			xmlDataFiles = new XmlDataFiles();
		}
		return xmlDataFiles;
	}

	/**
	 * Checks if is xmlnew.
	 * 
	 * @return true, if is xmlnew
	 */
	public boolean isXmlnew() {
		return xmlnew;
	}

	/**
	 * Sets the url.
	 * 
	 * @param pUrl
	 *            the new url
	 */
	public void setUrl(String pUrl) {
		url = pUrl;
	}

	/**
	 * Sets the xml data files.
	 * 
	 * @param pXmlDataFiles
	 *            the new xml data files
	 */
	public void setXmlDataFiles(XmlDataFiles pXmlDataFiles) {
		xmlDataFiles = pXmlDataFiles;
	}

	/**
	 * Sets the xmlnew.
	 * 
	 * @param pXmlnew
	 *            the new xmlnew
	 */
	public void setXmlnew(boolean pXmlnew) {
		xmlnew = pXmlnew;
	}

}
