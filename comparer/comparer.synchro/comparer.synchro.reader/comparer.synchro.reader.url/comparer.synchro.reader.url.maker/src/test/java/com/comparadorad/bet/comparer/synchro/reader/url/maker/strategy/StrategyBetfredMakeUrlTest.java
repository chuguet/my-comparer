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
public class StrategyBetfredMakeUrlTest extends AbstractUrlFactoryTest {

//	/** The make url. */
//	@Resource(name = "strategyBetfredMakeUrl")
//	private StrategyMakeUrl makeUrl;
//
//	/**
//	 * With parameter.
//	 * 
//	 * @throws CoreUrlMakerException
//	 *             the core url maker exception
//	 */
	@Test
	public final void withParameter() throws CoreUrlMakerException {
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		List<RemoteFileBean> files = new ArrayList<RemoteFileBean>();
//		List<BeanUrlMaker> urls;
//
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http://xml.betfred.com/@templates@.xml"));
//
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//
//		files.add(new RemoteFileBean("Football-Championship.xml"));
//		files.add(new RemoteFileBean("Football-English-League-1.xml"));
//
//		StrategyType.BETFRED.setFiles(files);
//
//		assertNotNull(makeUrl);
//
//		urls = makeUrl.getUrls(bookmaker);
//
//		assertNotNull(urls);
//
//		// assertEquals(urls.size(), 2);
//
//		Boolean contador = Boolean.FALSE;
//		for (BeanUrlMaker bean : urls) {
//			if (!urls
//					.contains("http://xml.betfred.com/Football-English-League-1.xml")
//					|| !urls.contains("http://xml.betfred.com/Football-Championship.xml")) {
//				contador = Boolean.TRUE;
//				break;
//			}
//
//		}
//		
//		if (!contador) {
//			fail("La salida del metodo es incorrecta");
//		}
//		
	}
//
//	/**
//	 * Without parameter.
//	 * 
//	 * @throws CoreUrlMakerException
//	 */
//	@Test
//	public final void withoutParameter() throws CoreUrlMakerException {
//
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		List<RemoteFileBean> files = new ArrayList<RemoteFileBean>();
//		List<BeanUrlMaker> urls;
//
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http://xml.betfred.com/@templates@.xml"));
//
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//
//		StrategyType.BETFRED.setFiles(files);
//
//		assertNotNull(makeUrl);
//
//		urls = makeUrl.getUrls(bookmaker);
//
//		assertNotNull(urls);
//
//		urls = makeUrl.getUrls(bookmaker);
//
//		assertNotNull(urls);
//
//		// assertEquals(urls.size(), 1);
//
//		Boolean contador = Boolean.FALSE;
//		for (BeanUrlMaker bean : urls) {
//			if (bean.getUrl().contains("http://xml.betfred.com/Football-English-League-1.xml")) {
//				contador = Boolean.TRUE;
//				break;
//			}
//		}
//			
//		if (!contador) {
//			fail("La salida del metodo es incorrecta");
//		}
//
//	}

}
