package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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

public class StrategyUnibetMakeUrlTest extends AbstractUrlFactoryTest {

	@Resource(name = "strategyUnibetMakeUrl")
	private StrategyMakeUrl makeUrl;

	@Test
	public final void testMakeUrlUnibet() throws CoreUrlMakerException {
/*		CfgBookmaker bookmaker = new CfgBookmaker();
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		List<BeanUrlMaker> urls;

		bookmakerConfiguration.addBookmakerDataUrl(new CfgBookmakerDataUrl(
				"http://api.unicdn.net/v1/feeds/sportsbook/groups.json?lang=LANG&app_id=219230ff&app_key=f2da3925a86150e2668e3821a0e0d92a", UrlDataTypes.BASE));
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
		bookmakerConfiguration.setFilterMakeUrl(sportWhiteList );
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		

		assertNotNull(makeUrl);

		try {
			urls = makeUrl.getUrls(bookmaker);

			assertNotNull(urls);
			
		} catch (TimeOutReaderURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/

	}

	private boolean contains(List<BeanUrlMaker> urls, String string) {
		boolean result = false;
		for (BeanUrlMaker beanUrlMaker : urls) {
			if (beanUrlMaker.getUrl().equals(string)) {
				result = true;
				break;
			}
		}
		return result;
	}
}
