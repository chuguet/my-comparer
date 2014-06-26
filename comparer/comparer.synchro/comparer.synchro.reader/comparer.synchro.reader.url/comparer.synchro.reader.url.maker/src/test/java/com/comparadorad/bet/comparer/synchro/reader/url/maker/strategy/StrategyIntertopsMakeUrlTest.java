package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.AbstractUrlFactoryTest;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.CoreUrlMakerException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;

public class StrategyIntertopsMakeUrlTest extends AbstractUrlFactoryTest {

	@Resource(name = "strategyIntertopsMakeUrl")
	private StrategyMakeUrl makeUrl;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(StrategyPinnacleMakeUrl.class);

	@Test
	public final void testMakeUrlIntertops() throws CoreUrlMakerException,
			TimeOutReaderURLException, InterruptedException {
		CfgBookmaker bookmaker = new CfgBookmaker();
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		List<BeanUrlMaker> urls;

		bookmakerConfiguration
				.addBookmakerDataUrl(new CfgBookmakerDataUrl(
						"http://xmlfeed.intertops.com/xmloddsfeed/v2/xml/?apikey=b13e00e4-f72f-e311-bf8a-003048dd52d5"));

		bookmakerConfiguration.setRebootTime(new Long(0));
		bookmakerConfiguration.setRebootUrlMaker(new Long(0));

		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);

		assertNotNull(makeUrl);

		urls = makeUrl.getUrls(bookmaker);

		assertNotNull(urls);

		LOG.info(new StringBuffer("URL generada: ")
				.append(urls.get(0).getUrl()));
		if (!urls.get(0).getUrl().contains("delta=30")) {
			fail("la primera creacion de la url debe generase con delta = 30");
		}

		/*
		 * Esta linea se pone porque en tiempo de maven hay desfases de tiempo
		 * porque en codigo usamos new Date() y no siempre funciona la logica
		 * que tiene que hacer. Si se quita puede que funcione o puede que no
		 * funcione este test....
		 */
		Thread.sleep(1000);
		bookmakerConfiguration.setRebootTime(new Long(-1));
		bookmakerConfiguration.setRebootUrlMaker(new Long(-1));

		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);

		urls = makeUrl.getUrls(bookmaker);

		LOG.info(new StringBuffer("URL generada: ")
				.append(urls.get(0).getUrl()));
		if (!urls.get(0).getUrl().contains("delta=7200")) {
			fail("la segunda creacion de la url debe generase con delta = 7200");
		}

		assertEquals(urls.size(), 1);

	}

}
