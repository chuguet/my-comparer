package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.url.maker.AbstractUrlFactoryTest;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.CoreUrlMakerException;

public final class StrategyPinnacleMakeUrlTest extends AbstractUrlFactoryTest {
	
//	@Resource(name="strategyPinnacleMakeUrl")
//	private StrategyMakeUrl makeUrl;
//	
//	@Test
//	public final void witParameter() throws CoreUrlMakerException{	
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
//		
//		List<UriParameterBean> uriParameter = new ArrayList<UriParameterBean>();
//		
//		uriParameter.add( new UriParameterBean("parameter","value") );
//		uriParameter.add( new UriParameterBean("parameter2","value2") );
//		
//		
//		StrategyType.PINNACLE.setUriParameter(uriParameter);
//		
//		assertNotNull(makeUrl);
//		
//		List<BeanUrlMaker> strings = makeUrl.getUrls(bookmaker);
//		
//		assertEquals(strings.size(), bookmakerConfiguration.getBookmakerUrl()
//				.size());
//		
//		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmakerConfiguration
//				.getBookmakerUrl()) {
//			assertEquals((bookmakerDataUrl.getUrl()+"?parameter=value&parameter2=value2&"), strings.get(i++).getUrl());
//		}	
//	}
//	
	@Test
	public final void withoutParameter() throws CoreUrlMakerException{
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
//		
//		assertNotNull(makeUrl);
//		
//		List<BeanUrlMaker> strings = makeUrl.getUrls(bookmaker);
//		
//		assertEquals(strings.size(), bookmakerConfiguration.getBookmakerUrl()
//				.size());
//		
//		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmakerConfiguration
//				.getBookmakerUrl()) {
//			assertEquals(bookmakerDataUrl.getUrl(), strings.get(i++).getUrl());
//		}		
//		
	}

}
