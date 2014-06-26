/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder;

import org.apache.commons.io.input.CloseShieldInputStream;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.datasource.config.ProxyPassConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlDataFileReaderException;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;

/**
 * The Class XmlFeedBulder.
 */
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class XmlFeedBuilder extends AbstractXmlBuilder {

	/**
	 * Instantiates a new xml feed builder.
	 */
	public XmlFeedBuilder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new xML bookmaker feed builder.
	 * 
	 * @param url
	 *            the url
	 */
	public XmlFeedBuilder(String url) {
		super(url);
	}

	/**
	 * Instantiates a new xml feed builder.
	 * 
	 * @param url
	 *            the url
	 * @param proxyPassConfig
	 *            the proxy pass config
	 */
	public XmlFeedBuilder(String url, ProxyPassConfig proxyPassConfig) {
		super(url, proxyPassConfig);
	}

	/**
	 * Connect.
	 * 
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 * @throws XmlNotFoundException 
	 */
	@Override
	public void connect() throws XmlDataFileReaderException, XmlNotFoundException {
		CloseShieldInputStream closeShieldInputStream = new CloseShieldInputStream(
				connect(getUrl()));
		getXmlDataFiles().addDataFile(
				new XmlDataFile(closeShieldInputStream, getUrl()));
	}

	/**
	 * Format.
	 * 
	 * @return the close shield input stream {@inheritDoc}
	 */
	@Override
	public XmlDataFiles format() {
		return getXmlDataFiles();
	}

	/**
	 * Checks if is xM lnew.
	 * 
	 * @return true, if is xM lnew {@inheritDoc}
	 * @throws XmlDataFileReaderException
	 *             the xml data file reader exception
	 */
	// @Override
	// public boolean isXMLnew() throws XmlDataFileReaderException {
	// encrypt = new EncryptImpl();
	// int len = 0;
	// int size = 1024;
	// byte[] buf;
	// String md5;
	// String md5After = null;
	// boolean result = false;
	// for (CloseShieldInputStream closeShieldInputStream :
	// getLstCloseShieldInputStream()) {
	// try {
	// size = closeShieldInputStream.available();
	// buf = new byte[size];
	// len = closeShieldInputStream.read(buf, 0, size);
	// md5 = encrypt.md5(Integer.toString(len));
	//
	// if (getBookmakerMap().containsKey(getUrl())) {
	// md5After = getBookmakerMap().get(getUrl());
	// }
	// if (!md5.equals(md5After)) {
	// getBookmakerMap().put(getUrl(), md5);
	// result = true;
	// }
	// } catch (IOException e) {
	// LOG.error(e.getMessage());
	// throw new XmlDataFileReaderException(e.getMessage(),e);
	// }
	// }
	// return result;
	// }

}
