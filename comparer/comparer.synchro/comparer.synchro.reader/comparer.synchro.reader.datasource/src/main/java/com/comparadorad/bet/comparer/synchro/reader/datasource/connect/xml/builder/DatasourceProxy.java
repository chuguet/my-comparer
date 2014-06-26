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

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.util.URIUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.comparadorad.bet.comparer.synchro.reader.datasource.config.ProxyPassConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.HttpClientConnection.HttpClientConnectionException;
import com.comparadorad.bet.comparer.synchro.server.dummy.XmlBetDummyServerParams;

/**
 * The Class DatasourceProxy.
 */
public class DatasourceProxy {

	/**
	 * The xml bet dummy server params. It's not required, in prod mode is not
	 * active
	 */
	@Autowired(required = false)
	private XmlBetDummyServerParams xmlBetDummyServerParams;

	/**
	 * Instantiates a new datasource proxy.
	 * 
	 * @param pActive
	 *            the active
	 */
	public DatasourceProxy(boolean pActive) {
		super();
		active = pActive;
	}

	/** The active. */
	private boolean active;

	/**
	 * Checks if is active.
	 * 
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 * 
	 * @param pActive
	 *            the new active
	 */
	public void setActive(boolean pActive) {
		active = pActive;
	}

	/**
	 * Do connection.
	 * 
	 * @param url
	 *            the url
	 * @param proxyPassConfig
	 *            the proxy pass config
	 * @param pHttpClientConnection
	 *            the http client connection
	 * @return the input stream
	 * @throws HttpException
	 *             the http exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws HttpClientConnectionException
	 *             the http client connection exception
	 */
	public InputStream doConnection(String url,
			ProxyPassConfig proxyPassConfig,
			final HttpClientConnection pHttpClientConnection)
			throws HttpException, IOException, HttpClientConnectionException {
		String nuevaUrl = "";
		if (active) {
			StringBuffer newUrl = new StringBuffer(
					xmlBetDummyServerParams.getServerUrl());
			newUrl.append("/?")
					.append(xmlBetDummyServerParams.getProxiedUrlparam())
					.append("=").append(URIUtil.encodePath(url));
			nuevaUrl = newUrl.toString();
		}
		return pHttpClientConnection.doConnection(nuevaUrl, proxyPassConfig);
	}
}
