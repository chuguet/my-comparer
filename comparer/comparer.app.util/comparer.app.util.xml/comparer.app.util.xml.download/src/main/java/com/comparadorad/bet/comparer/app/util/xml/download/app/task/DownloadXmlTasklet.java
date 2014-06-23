/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.app.util.xml.download.app.task;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.synchro.reader.datasource.config.ProxyPassConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.AbstractXmlBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XMLMultipleFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XmlFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.director.XmlDirector;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;

/**
 * The Class DownloadXmlTasklet.
 */
public class DownloadXmlTasklet {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(DownloadXmlTasklet.class);

	/** The date. */
	private Date date;

	/** The name. */
	private String name;

	/** The url. */
	private URL url;

	/** The xpath. */
	private String xpath;

	/** The proxy pass config. */
	private ProxyPassConfig proxyPassConfig;

	/**
	 * Gets the proxy pass config.
	 * 
	 * @return the proxy pass config
	 */
	public ProxyPassConfig getProxyPassConfig() {
		return proxyPassConfig;
	}

	/**
	 * Sets the proxy pass config.
	 * 
	 * @param pProxyPassConfig
	 *            the new proxy pass config
	 */
	public void setProxyPassConfig(ProxyPassConfig pProxyPassConfig) {
		proxyPassConfig = pProxyPassConfig;
	}

	/**
	 * Execute.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws XmlNotFoundException 
	 */

	public void execute() throws IOException, XmlNotFoundException {
		XmlDirector director;
		AbstractXmlBuilder builder;
		director = new XmlDirector();
		if (getXpath() == null || "".equals(getXpath())) {
			builder = new XmlFeedBuilder(getUrl().toString(), proxyPassConfig);
		} else {
			builder = new XMLMultipleFeedBuilder(getUrl().toString(),
					proxyPassConfig, getXpath());
		}
		director.setBuilder(builder);
		XmlDataFiles xmlDataFiles = director.makeXML();
		for (XmlDataFile xmlDataFile : xmlDataFiles) {
			inputStreamToFile(xmlDataFile.getDataFileInputStream(), getName());
		}
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * Gets the xpath.
	 * 
	 * @return the xpath
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * Input stream to file.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @param name
	 *            the name
	 */
	public void inputStreamToFile(InputStream inputStream, String name) {
		try {
			byte[] fileData = IOUtils.toByteArray(inputStream);

			if (date == null) {
				date = new Date();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			FileUtils.writeByteArrayToFile(new File("d:/tmp/bet-xml-files/"
					+ name + "." + sdf.format(date) + ".xml"), fileData);

		} catch (IOException e) {
			LOG.error(e.toString());
		}
	}

	/**
	 * Sets the date.
	 * 
	 * @param pDate
	 *            the new date
	 */
	public void setDate(Date pDate) {
		date = pDate;
	}

	/**
	 * Sets the name.
	 * 
	 * @param pName
	 *            the new name
	 */
	public void setName(String pName) {
		name = pName;
	}

	/**
	 * Sets the url.
	 * 
	 * @param pUrl
	 *            the new url
	 */
	public void setUrl(URL pUrl) {
		url = pUrl;
	}

	/**
	 * Sets the xpath.
	 * 
	 * @param pXpath
	 *            the new xpath
	 */
	public void setXpath(String pXpath) {
		xpath = pXpath;
	}

}
