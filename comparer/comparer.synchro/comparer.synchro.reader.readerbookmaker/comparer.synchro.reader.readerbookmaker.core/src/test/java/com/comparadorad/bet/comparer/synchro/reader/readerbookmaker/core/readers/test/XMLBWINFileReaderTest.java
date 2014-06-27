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

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin.XMLBwinFileReader;

/**
 * The Class XMLBetClickFileReaderTest.
 */
public class XMLBWINFileReaderTest extends AbstractTest {

	/** The bet click reader. */
	@Inject
	private XMLBwinFileReader bwinFileReader;

	/** The Constant XML_LOCATION. */
	protected static final String BWIN_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\bwin.xml";

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(bwinFileReader.getBookmakerId());
		assertEquals(bwinFileReader.getBookmakerId(),
				CfgBookmakerId.BWIN_COM_ID.objectId().toString());
	}

	/**
	 * Bet click read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void bwinReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BWIN_READER, BWIN_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		assertEquals(1, result.size());
		XmlMatch match = (XmlMatch) result.toArray()[0];

		assertEquals(4, match.getXmlMarkets().size());
		assertEquals(3,((XmlMarket)((List)match.getXmlMarkets()).get(0)).getXmlMarketBets().size());
	}


	@Test
	public void bwinReadMatchIdTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BWIN_READER, BWIN_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);

		XmlMatch match = (XmlMatch) result.toArray()[0];

		assertEquals("San Jose at Calgary", match.getName().toString());
		assertEquals(4, match.getXmlMarkets().size());
		assertEquals(2, match.getXmlMatchParticipants().size());
		assertEquals("NHL", match.getXmlTournament().getName());



	}

	@Test
	public void bwinReadMarket1X2Test() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BWIN_READER, BWIN_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);

		XmlMatch match = (XmlMatch) result.toArray()[0];

		assertEquals(4, match.getXmlMarkets().size());

		for (XmlMarket market : match.getXmlMarkets()) {

			if(market.getXmlBetType().getBetType().toString().equals("UNO_X_DOS")){
				assertEquals(3, market.getXmlMarketBets().size());
				for (XmlMarketBet bet : market.getXmlMarketBets()) {

					if(bet.getXmlMatchParticipant()!=null){
						if(bet.getXmlMatchParticipant().isHomeParticipant()){
							assertEquals("1X2", bet.getXmlAttribute().getCfgBetTypeId());
							assertEquals("1.9", bet.getXmlBetOdd().getOdds());
						}
						if(bet.getXmlMatchParticipant().isAwayParticipant()){
							assertEquals("1X2", bet.getXmlAttribute().getCfgBetTypeId());
							assertEquals("3.4", bet.getXmlBetOdd().getOdds());
						}
					}else{
						assertEquals("1X2", bet.getXmlAttribute().getCfgBetTypeId());
						assertEquals("4.0", bet.getXmlBetOdd().getOdds());
					}

				}
			}

		}

	}




	@Test
	public void bwinReadMarketGanadorPartidoTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BWIN_READER, BWIN_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);

		XmlMatch match = (XmlMatch) result.toArray()[0];

		assertEquals(4, match.getXmlMarkets().size());

		for (XmlMarket market : match.getXmlMarkets()) {

			if(market.getXmlBetType().getBetType().toString().equals("GANADOR_PARTIDO")){
				assertEquals(2, market.getXmlMarketBets().size());
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					if(bet.getXmlMatchParticipant().isHomeParticipant()){
						assertEquals("Ganador_Partido", bet.getXmlAttribute().getCfgBetTypeId());
						assertEquals("1.55", bet.getXmlBetOdd().getOdds());
					}
					if(bet.getXmlMatchParticipant().isAwayParticipant()){
						assertEquals("Ganador_Partido", bet.getXmlAttribute().getCfgBetTypeId());
						assertEquals("2.5", bet.getXmlBetOdd().getOdds());
					}
				}
			}

		}

	}

	@Test
	public void bwinReadMarketMasMenosTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BWIN_READER, BWIN_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);

		XmlMatch match = (XmlMatch) result.toArray()[0];

		assertEquals(4, match.getXmlMarkets().size());

		for (XmlMarket market : match.getXmlMarkets()) {

			if(market.getXmlBetType().getBetType().toString().equals("MAS_MENOS")){
				assertEquals(2, market.getXmlMarketBets().size());
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					if(bet.getXmlMatchParticipant().isHomeParticipant()){
						assertEquals("Mas_Menos", bet.getXmlAttribute().getCfgBetTypeId());
						assertEquals("2.05", bet.getXmlBetOdd().getOdds());
					}
					if(bet.getXmlMatchParticipant().isAwayParticipant()){
						assertEquals("Mas_Menos", bet.getXmlAttribute().getCfgBetTypeId());
						assertEquals("1.8", bet.getXmlBetOdd().getOdds());
					}
				}
			}

		}

	}

	@Test
	public void bwinReadMarketAsianHandicapTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(
				BWIN_READER, BWIN_XML_LOCATION, bookmakerConfiguration,null);

		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);

		XmlMatch match = (XmlMatch) result.toArray()[0];

		assertEquals(4, match.getXmlMarkets().size());

		for (XmlMarket market : match.getXmlMarkets()) {

			if(market.getXmlBetType().getBetType().toString().equals("HANDICAP_ASIATICO")){
				assertEquals(2, market.getXmlMarketBets().size());
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					if(bet.getXmlMatchParticipant().isHomeParticipant()){
						assertEquals("Handicap_Asiatico", bet.getXmlAttribute().getCfgBetTypeId());
						assertEquals("2.65", bet.getXmlBetOdd().getOdds());
					}
					if(bet.getXmlMatchParticipant().isAwayParticipant()){
						assertEquals("Handicap_Asiatico", bet.getXmlAttribute().getCfgBetTypeId());
						assertEquals("1.5", bet.getXmlBetOdd().getOdds());
					}
				}
			}

		}

	}


}
