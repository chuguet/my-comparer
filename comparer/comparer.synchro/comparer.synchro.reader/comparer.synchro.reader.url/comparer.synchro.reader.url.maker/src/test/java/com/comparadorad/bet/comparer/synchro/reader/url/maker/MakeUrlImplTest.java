/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.CoreUrlMakerException;

/**
 * The Class MakeUrlImplTest.
 */
public final class MakeUrlImplTest extends AbstractUrlFactoryTest {

//	/** The make url. */
//	@Inject
//	private MakeUrl makeUrl;
//
//	/**
//	 * Make url generic test.
//	 *
//	 * @throws CoreUrlMakerException the core url maker exception
//	 */
	@Test
	public final void MakeUrlGenericTest() throws CoreUrlMakerException {
//		
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		int i = 0;
//
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http:\\test1"));
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http:\\test2"));
//
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//
//		List<BeanUrlMaker> urls = makeUrl.getUrl(bookmaker);
//
//		assertEquals(urls.size(), bookmakerConfiguration.getBookmakerUrl()
//				.size());
//		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmakerConfiguration
//				.getBookmakerUrl()) {
//			assertEquals(bookmakerDataUrl.getUrl(), urls.get(i++).getUrl());
//		}
//
	}
//
//	/**
//	 * Make url pinnacle test.
//	 *
//	 * @throws CoreUrlMakerException the core url maker exception
//	 */
	@Test
	public final void MakeUrlPinnacleTest() throws CoreUrlMakerException {
//		
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		int i = 0;
//		
//		bookmaker.setNameId(CfgBookmakerId.PINNACLESPORTS_COM_ID.nameId());
//		
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http:\\test1"));
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http:\\test2"));
//		
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//		
//		StrategyType.PINNACLE.setUriParameter(null);
//		
//		List<BeanUrlMaker> strings = makeUrl.getUrl(bookmaker);
//		
//		assertEquals(strings.size(), bookmakerConfiguration.getBookmakerUrl()
//				.size());
//		
//		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmakerConfiguration
//				.getBookmakerUrl()) {
//			assertEquals(bookmakerDataUrl.getUrl(), strings.get(i++).getUrl());
//		}
//		
//		assertNotNull(makeUrl);
	}
//	
//	
//	/**
//	 * Make url betfred test.
//	 *
//	 * @throws CoreUrlMakerException the core url maker exception
//	 */
	@Test
	public final void MakeUrlBetfredTest() throws CoreUrlMakerException {
//		
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		
//		bookmaker.setNameId(CfgBookmakerId.BETFRED_COM_ID.nameId());
//		
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http://xml.betfred.com/@Templates@.xml"));
//		
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);	
//		
//		
//		StrategyType.BETFRED.setUriParameter(null);
//		
//		List<BeanUrlMaker> strings = makeUrl.getUrl(bookmaker);
//		
////		assertEquals(strings.size(), bookmakerConfiguration.getBookmakerUrl()
////				.size());
//		
////		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmakerConfiguration
////				.getBookmakerUrl()) {
////			assertEquals(bookmakerDataUrl.getUrl(), strings.get(i++));
////		}
//		assertTrue(bookmakerConfiguration.getBookmakerUrl().size()<strings.size());
//		
//		assertNotNull(makeUrl);
	}
//
//	
	@Test
	public final void MakeUrlBlueSquareTest() throws CoreUrlMakerException {
//		
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		
//		bookmaker.setNameId(CfgBookmakerId.BLUESQUARE_COM_ID.nameId());
//		
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http://cubs.bluesq.com/cubs/cubs.php?action=dictionary"));
//		
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);	
//		
//		
//		StrategyType.BLUESQUARE.setUriParameter(null);
//		
//		List<BeanUrlMaker> strings = makeUrl.getUrl(bookmaker);
//		
//		assertTrue(bookmakerConfiguration.getBookmakerUrl().size()<strings.size());
//		
//		assertNotNull(makeUrl);
	}
}
