package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.url.maker.AbstractUrlFactoryTest;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.CoreUrlMakerException;

public class StrategyGenericMakeUrlTest extends AbstractUrlFactoryTest {
	
//	@Resource(name="strategyGenericMakeUrl")
//	private StrategyMakeUrl makeUrl;
//	
//	@Test
//	public final void withMinimumTimeUpdateTest() throws CoreUrlMakerException{
//		
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		int i;
//		List<BeanUrlMaker> urls;
//		
//		bookmaker.setObjectId(BigInteger.ZERO);
//		
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http:\\test11"));
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http:\\test22"));
//		
//		bookmakerConfiguration.setMinimumTimeUpdate(1000L);
//		
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//		
//		urls = makeUrl.getUrls(bookmaker);
//		
//		assertEquals(urls.size(), bookmakerConfiguration.getBookmakerUrl()
//				.size());
//		
////		i = 0;
////		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmakerConfiguration
////				.getBookmakerUrl()) {
////			assertEquals((bookmakerDataUrl.getUrl()), urls.get(i++).getUrl());
////		}		
//		
////		assertNotNull(makeUrl);
////		
////		urls = makeUrl.getUrls(bookmaker);
////		
////		assertEquals(urls.size(), 0);
//		
//	}
//	
	@Test
	public final void withoutMinimumTimeUpdateTest() throws CoreUrlMakerException{
//		
//		CfgBookmaker bookmaker = new CfgBookmaker();
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		int i;
//		List<BeanUrlMaker> urls;
//		
//		bookmaker.setObjectId(BigInteger.ONE);
//		
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http:\\test10"));
//		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
//				"http:\\test20"));
//		
//		bookmakerConfiguration.setMinimumTimeUpdate(0L);
//		
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//		
//		urls = makeUrl.getUrls(bookmaker);
//		
//		assertEquals(urls.size(), bookmakerConfiguration.getBookmakerUrl()
//				.size());
//		
//		i = 0;
//		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmakerConfiguration
//				.getBookmakerUrl()) {
//			assertEquals((bookmakerDataUrl.getUrl()), urls.get(i++).getUrl());
//		}		
//		
//		assertNotNull(makeUrl);
//		
//		urls = makeUrl.getUrls(bookmaker);
//		
//		assertEquals(urls.size(), bookmakerConfiguration.getBookmakerUrl()
//				.size());
//		
//		i = 0;
//		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmakerConfiguration
//				.getBookmakerUrl()) {
//			assertEquals((bookmakerDataUrl.getUrl()), urls.get(i++).getUrl());
//		}	
//		
	}

}
