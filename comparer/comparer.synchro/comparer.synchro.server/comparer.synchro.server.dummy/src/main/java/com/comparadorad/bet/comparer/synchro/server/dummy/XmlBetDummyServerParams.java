/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.server.dummy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * The Class XmlBetDummyServerParams.
 */

public class XmlBetDummyServerParams {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlBetDummyServerParams.class);

	@Autowired
	private Environment env;

	private Properties properties;

	/** The proxied urlparam. */
	private String proxiedUrlparam = "proxiedUrl";
	/** The server host. */
	private String serverHost = "127.0.0.1";
	private Map<String, String> serverurlMap;

	/** The xml bet dummy server port. */
	private XmlBetDummyServerPort xmlBetDummyServerPort;

	public Properties getProperties() {
		return properties;
	}

	/**
	 * Gets the proxied urlparam.
	 * 
	 * @return the proxied urlparam
	 */
	public String getProxiedUrlparam() {
		return proxiedUrlparam;
	}

	/**
	 * Gets the server host.
	 * 
	 * @return the server host
	 */
	public String getServerHost() {
		return serverHost;
	}

	/**
	 * Gets the mongo port.
	 * 
	 * @return the mongo port
	 */
	public int getServerPort() {
		return xmlBetDummyServerPort().getPort();
	}

	/**
	 * Gets the server url.
	 * 
	 * @return the server url
	 */
	public String getServerUrl() {
		StringBuffer result = new StringBuffer();
		result.append("http://").append(getServerHost()).append(":")
				.append(getServerPort());
		LOG.debug("Server url: " + result.toString());
		return result.toString();
	}

	public Map<String, String> getServerUrlMap() {
		if (serverurlMap == null) {
			serverurlMap = new HashMap<String, String>();
			for (Iterator iterator = properties.keySet().iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				if (key.startsWith("serverurl.")) {
					serverurlMap.put(key.replaceFirst("serverurl.", ""),
							properties.getProperty(key));
				}
			}
		}
		return serverurlMap;
	}

	public void setProperties(Properties pProperties) {
		properties = pProperties;
	}

	/**
	 * Sets the proxied urlparam.
	 * 
	 * @param pProxiedUrlparam
	 *            the new proxied urlparam
	 */
	public void setProxiedUrlparam(String pProxiedUrlparam) {
		proxiedUrlparam = pProxiedUrlparam;
	}

	/**
	 * Sets the server host.
	 * 
	 * @param pServerHost
	 *            the new server host
	 */
	public void setServerHost(String pServerHost) {
		serverHost = pServerHost;
	}

	/**
	 * Xml bet dummy server port.
	 * 
	 * @return the xml bet dummy server port
	 */
	@Bean
	public XmlBetDummyServerPort xmlBetDummyServerPort() {
		if (xmlBetDummyServerPort == null) {
			this.xmlBetDummyServerPort = new XmlBetDummyServerPort();
		}
		return xmlBetDummyServerPort;
	}
}
