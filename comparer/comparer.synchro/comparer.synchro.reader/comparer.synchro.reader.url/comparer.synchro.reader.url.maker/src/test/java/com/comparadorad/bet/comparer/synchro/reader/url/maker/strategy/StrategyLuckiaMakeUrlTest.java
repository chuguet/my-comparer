/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.UrlFilterWord;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.AbstractUrlFactoryTest;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.CoreUrlMakerException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;

/**
 * The Class StrategyLuckiaMakeUrlTest.
 */
public class StrategyLuckiaMakeUrlTest extends AbstractUrlFactoryTest {

	/** The make url. */
	@Resource(name = "strategyLuckiaMakeUrl")
	private StrategyMakeUrl makeUrl;

	/**
	 * Test make url luckia.
	 *
	 * @throws CoreUrlMakerException the core url maker exception
	 */
	@Test
	public final void testMakeUrlLuckia() throws CoreUrlMakerException {
		CfgBookmaker bookmaker = new CfgBookmaker();
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		List<BeanUrlMaker> urls;

		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
				"http://feed.luckia.es/betcompara/sports.php",
				UrlDataTypes.BASE));
		bookmakerConfiguration.setMinimumTimeUpdate(new Long(1));
		Set<UrlFilterWord> sportWhiteList = new HashSet<UrlFilterWord>();
		sportWhiteList.add(new UrlFilterWord("FOOTBALL"));
		sportWhiteList.add(new UrlFilterWord("TENNIS"));
		sportWhiteList.add(new UrlFilterWord("AMERICAN_FOOTBALL"));
		sportWhiteList.add(new UrlFilterWord("BASEBALL"));
		sportWhiteList.add(new UrlFilterWord("BASKETBALL"));
		sportWhiteList.add(new UrlFilterWord("CYCLING"));
		sportWhiteList.add(new UrlFilterWord("HANDBALL"));
		sportWhiteList.add(new UrlFilterWord("ICE_HOCKEY"));
		bookmakerConfiguration.setFilterMakeUrl(sportWhiteList);
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);

		assertNotNull(makeUrl);

		try {
			urls = makeUrl.getUrls(bookmaker);

			assertNotNull(urls);

		} catch (TimeOutReaderURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
