/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.apache.commons.httpclient.HttpException;
import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.HttpClientConnection.HttpClientConnectionException;
import com.comparadorad.bet.comparer.synchro.reader.datasource.test.util.AbstractServerTest;

/**
 * The Class DatasourceProxyTest.
 */
public class DatasourceProxyTest extends AbstractServerTest {

	/** The datasource proxy. */
	@Inject
	private DatasourceProxy datasourceProxy;

	/**
	 * Test do connection.
	 * 
	 * @throws HttpException
	 *             the http exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws HttpClientConnectionException
	 *             the http client connection exception
	 */
	@Test
	public void testDoConnection() throws HttpException, IOException,
			HttpClientConnectionException {
		InputStream result = datasourceProxy
				.doConnection(
						"http://xml.betclick.com/odds_en.xml",
						null, new HttpClientConnection());
		assertNotNull(result);
	}
}
