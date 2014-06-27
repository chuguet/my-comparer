/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betboo.XMLBetBooFileReader;

/**
 * The Class XMLBetClickFileReaderTest.
 */
public class XMLBetBooFileReaderTest extends AbstractTest {

	/** The bet click reader. */
	@Inject
	private XMLBetBooFileReader betBooFileReader;

	/** The Constant XML_LOCATION. */
	protected static final String BB_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betboo.xml";

	protected static final String BB_SPREAD_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betbooSpread.xml";
	
	protected static final String BB_BUG_3748_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betbooBug3748.xml";

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(betBooFileReader.getBookmakerId());
		assertEquals(betBooFileReader.getBookmakerId(),
				CfgBookmakerId.BETBOO_ID.objectId().toString());
	}

	/**
	 * Bet click read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void betBooReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETBOO_READER, BB_SPREAD_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);


		XmlMatch match = (XmlMatch) result.toArray()[0];
		assertEquals(match.getXmlMarkets().size(), 1);
		assertEquals(2,((XmlMarket)((List)match.getXmlMarkets()).get(0)).getXmlMarketBets().size());



	}


	@Test
	public void betBooReadBetTypeTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETBOO_READER, BB_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);

		for (XmlMatch xmlMatch : result) {
			for (XmlMarket market : xmlMatch.getXmlMarkets()) {
				Boolean flag = Boolean.FALSE;
				for (String betType : market.getXmlBetType().getBetType().getTypes()) {
					if(betType.equals("3W") || betType.equals("Outright") || betType.equals("2W") || betType.equals("Spread") || betType.equals("Total")){
						flag = Boolean.TRUE;
					}
				}
				Assert.isTrue(flag==Boolean.TRUE);
			}
		}
	}


	@Test
	public void betBooSpreadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETBOO_READER, BB_SPREAD_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);

		XmlMatch match = (XmlMatch) result.toArray()[0];
		Assert.isTrue(match.getXmlTournament().getXmlSport().getName().equals("Baseball"));
		Assert.isTrue(match.getXmlTournament().getRegion().getName().equals("USA"));
		Assert.isTrue(match.getXmlTournament().getName().equals("USA  MLB"));
		XmlMarket market = (XmlMarket) match.getXmlMarkets().toArray()[0];

		Assert.isTrue(market.getXmlBetType().getBetType().getId().equals("Handicap_Asiatico"));

		for (XmlMarketBet bet : market.getXmlMarketBets()) {
			if(bet.getXmlMatchParticipant().isHomeParticipant()){
				Assert.isTrue(bet.getXmlBetOdd().getOdds().equals("1.96"));
				Assert.isTrue(((XmlAsianHandicapAttribute)bet.getXmlAttribute()).getAsianResult().equals(AsianResult.ONE));
				Assert.isTrue(((XmlAsianHandicapAttribute)bet.getXmlAttribute()).getFirstValue().equals(new Double("-1.5")));
			}else{
				Assert.isTrue(bet.getXmlBetOdd().getOdds().equals("1.80"));
				Assert.isTrue(((XmlAsianHandicapAttribute)bet.getXmlAttribute()).getAsianResult().equals(AsianResult.TWO));
				Assert.isTrue(((XmlAsianHandicapAttribute)bet.getXmlAttribute()).getFirstValue().equals(new Double("-1.5")));

			}

		}

	}
	
	@Test
	public void testBug3748EmptyOdds ()throws Exception{
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BETBOO_READER, BB_BUG_3748_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);

		XmlMatch match = (XmlMatch) result.toArray()[0];Assert.isTrue(match.getXmlTournament().getXmlSport().getName().equals("Baseball"));
		Assert.isTrue(match.getXmlTournament().getRegion().getName().equals("USA"));
		Assert.isTrue(match.getXmlTournament().getName().equals("USA  MLB"));
		XmlMarket market = (XmlMarket) match.getXmlMarkets().toArray()[0];

		Assert.isTrue(market.getXmlBetType().getBetType().getId().equals("Handicap_Asiatico"));

		Assert.isTrue(market.getXmlMarketBets().isEmpty());
	}
}
