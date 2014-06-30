/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.server.dummy;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.synchro.server.dummy.config.SynchroReaderServerDummyConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class XmlBetDummyServerTest.
 */
@ContextConfiguration(classes = { SynchroReaderServerDummyConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.TEST)
public class XmlBetDummyServerTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlBetDummyServerTest.class);

	/** The bet dummy server params. */
	@Resource
	private XmlBetDummyServerParams betDummyServerParams;

	/**
	 * Test.
	 * 
	 * @throws HttpException
	 *             the http exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void test() throws HttpException, IOException {

		testUrl("www.bet-at-home.com");
		testUrl("https://www.noxwin.com/xmlFeeds.aspx?type=odds");

	}

	/**
	 * Test url.
	 * 
	 * @param url
	 *            the url
	 * @throws HttpException
	 *             the http exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void testUrl(final String url) throws HttpException, IOException {
		String strURL = betDummyServerParams.getServerUrl();
		strURL += "/?" + betDummyServerParams.getProxiedUrlparam() + "=" + url;
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(strURL);
		int result = httpclient.executeMethod(post);
		// Display status code
		LOG.info("Response status code: " + result);
		// Display response
		LOG.info("Response body: ");
		LOG.info(post.getResponseBodyAsString());
	}
}
