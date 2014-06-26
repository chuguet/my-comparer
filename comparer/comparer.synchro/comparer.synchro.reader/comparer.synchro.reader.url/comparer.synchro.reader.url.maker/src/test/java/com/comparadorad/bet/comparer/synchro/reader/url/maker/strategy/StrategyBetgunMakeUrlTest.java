/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.url.maker.AbstractUrlFactoryTest;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.CoreUrlMakerException;

/**
 * The Class StrategyBetfredMakeUrlTest.
 */
public class StrategyBetgunMakeUrlTest extends AbstractUrlFactoryTest {

//	/** The make url. */
//	@Resource(name = "strategyBetgunMakeUrl")
//	private StrategyMakeUrl makeUrl;
//
//	/**
//	 * With parameter.
//	 * 
//	 * @throws CoreUrlMakerException
//	 *             the core url maker exception
//	 */
//	@Test
//	public final void withParameter() throws CoreUrlMakerException {
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		List<BeanUrlMaker> urls;
//
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http://odds.betgun.com/"));
//
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//
//		urls = makeUrl.getUrls(bookmaker);
//
//		assertNotNull(urls);
//
//		for (BeanUrlMaker bean : urls) {
//			assertTrue(bean.getBeanAdditionalXmlInfoReader() != null
//					&& bean.getBeanAdditionalXmlInfoReader()
//							.getCompetitionName() != null);
//			assertTrue(bean.getUrl() != null);
//
//		}
//	}
//
//	/**
//	 * Without parameter.
//	 * 
//	 * @throws CoreUrlMakerException
//	 */
	@Test
	public final void withoutParameter() throws CoreUrlMakerException {
//
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		List<RemoteFileBean> files = new ArrayList<RemoteFileBean>();
//		List<BeanUrlMaker> urls;
//
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http://odds.betgun.com/"));
//
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//
//		urls = makeUrl.getUrls(bookmaker);
//
//		assertNotNull(urls);
//
//		for (BeanUrlMaker bean : urls) {
//			assertTrue(bean.getBeanAdditionalXmlInfoReader() != null
//					&& bean.getBeanAdditionalXmlInfoReader()
//							.getCompetitionName() != null);
//			assertTrue(bean.getUrl() != null);
//		}
	}

}
