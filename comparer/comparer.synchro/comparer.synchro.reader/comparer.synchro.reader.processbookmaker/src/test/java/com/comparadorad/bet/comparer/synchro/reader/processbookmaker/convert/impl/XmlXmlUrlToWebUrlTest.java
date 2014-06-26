/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlUrl;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlXmlUrlToWebUrlTest.
 */
public class XmlXmlUrlToWebUrlTest extends AbstractTest {

	/** The xml url to web url. */
	@Inject
	private XmlXmlUrlToWebUrl xmlUrlToWebUrl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest
	 * #test()
	 */
	@Override
	@Test
	public void test() {
		XmlUrl xmlUrl = new XmlUrl();
		xmlUrl.setUrl("http://www.google.es");
		RtWebUrl result = new RtWebUrl();

		result = (RtWebUrl) xmlUrlToWebUrl.convert(null, xmlUrl, null, null);

		assertNotNull(result);
		assertTrue(result.getUrl().equals("http://www.google.es"));

	}

}
