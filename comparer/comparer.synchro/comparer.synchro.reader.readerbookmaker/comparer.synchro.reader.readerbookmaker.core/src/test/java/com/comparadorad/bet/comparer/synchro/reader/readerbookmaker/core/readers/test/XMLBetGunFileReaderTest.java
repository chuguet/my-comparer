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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetGun;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetGun;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betgun.XMLBetGunFileReader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class XMLBetClickFileReaderTest.
 */
public class XMLBetGunFileReaderTest extends AbstractTest {

	/** The bet click reader. */
	@Inject
	private XMLBetGunFileReader betGunFileReader;

	/** The Constant BETGUN_XML_SOCCER_WINNER. */
	private static final String BETGUN_XML_SOCCER_WINNER = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_soccer_winner.xml";

	/** The Constant BETGUN_XML_BAD. */
	private static final String BETGUN_XML_BAD = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_badXml.xml";

	/** The Constant BETGUN_XML_VARIADO. */
	private static final String BETGUN_XML_VARIADO = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_variado.xml";

	/** The Constant BETGUN_XML_BASKET_VARIADO. */
	private static final String BETGUN_XML_BASKET_VARIADO = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_basket_variado.xml";

	/** The Constant BETGUN_XML_BLACK_LIST. */
	private static final String BETGUN_XML_BLACK_LIST = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_blackList.xml";

	/** The Constant BETGUN_XML_BUG3399. */
	private static final String BETGUN_XML_BUG3399 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_bug3399.xml";

	/** The Constant BETGUN_XML_MASMENOS_SEVERALBETS. */
	private static final String BETGUN_XML_MASMENOS_SEVERALBETS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_masMenosSeveralBets.xml";

	/** The Constant BETGUN_XML_HANDICAP_SEVERALBETS. */
	private static final String BETGUN_XML_HANDICAP_SEVERALBETS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_handicapSeveralBets.xml";

	/** The Constant BETGUN_XML_HANDICAP_3518. */
	private static final String BETGUN_XML_HANDICAP_3518 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_handicap3518.xml";
	
	/** The Constant BETGUN_XML_TENNIS_ODDS. */
	private static final String BETGUN_XML_TENNIS_ODDS = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betgun\\betgun_tennis_test.xml";
	

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(betGunFileReader.getBookmakerId());
		assertEquals(betGunFileReader.getBookmakerId(), CfgBookmakerId.BETGUN_COM_ID.objectId().toString());
	}

	/**
	 * Bet click read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betGunReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "European Championships U21 - Long Term", "");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_SOCCER_WINNER, bookmakerConfiguration,
				beanAdditionalInfo);

		// Ganador
		Collection<XmlMatch> resultGanador = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultGanador.size() == 3);
		for (XmlMatch match : resultGanador) {
			assertTrue(match.getXmlTournamentEvent().getLongTerm().getLongTerm().equals(Boolean.TRUE));
			if (match.getName().equals("Zwyciezca")) {
				assertEquals(match.getXmlMarkets().size(), 1);
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR));
					assertTrue(market.getXmlMarketBets().size() == 8);
				}
			} else if (match.getName().equals("Zwyciezca grupy A")) {
				assertEquals(match.getXmlMarkets().size(), 1);
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR));
					assertTrue(market.getXmlMarketBets().size() == 4);
				}
			} else {
				assertEquals(match.getXmlMarkets().size(), 1);
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR));
					assertTrue(market.getXmlMarketBets().size() == 4);
				}
			}
		}

		// Variado
		beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "NHL", "");
		xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_VARIADO, bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> resultVariado = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultVariado.size() == 1);
		for (XmlMatch match : resultVariado) {
			assertTrue(match.getXmlMarkets().size() == 9);
			assertTrue(match.getName().equals("Los Angeles Kings-Chicago Blackhawks"));
			assertTrue(match.getXmlTournamentEvent().getLongTerm().getLongTerm().equals(Boolean.FALSE));
			for (XmlMarket market : match.getXmlMarkets()) {
				if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.UNO_X_DOS)) {
					if (market.getXmlBetType().getXmlBetEvent() == null
							|| market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetGun.PARTIDO_COMPLETO)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.3000"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Los Angeles Kings"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2962-04062013,1"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.7500"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Chicago Blackhawks"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2962-04062013,2"));
							} else {
								bet.getXmlMarketBetOdd().getOdds().equals("3.6000");
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2962-04062013,0"));
							}
						}
					} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetGun.PRIMERA_PARTE)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.8500"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Los Angeles Kings"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2963-04062013,1"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.2500"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Chicago Blackhawks"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2963-04062013,2"));
							} else {
								bet.getXmlMarketBetOdd().getOdds().equals("2.2500");
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2963-04062013,0"));
							}
						}
					} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetGun.SEGUNDA_PARTE)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.7000"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Los Angeles Kings"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2964-04062013,1"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.1000"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Chicago Blackhawks"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2964-04062013,2"));
							} else {
								bet.getXmlMarketBetOdd().getOdds().equals("2.4000");
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2964-04062013,0"));
							}
						}
					} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetGun.TERCERA_PARTE)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.7000"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Los Angeles Kings"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2965-04062013,1"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.1000"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Chicago Blackhawks"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2965-04062013,2"));
							} else {
								bet.getXmlMarketBetOdd().getOdds().equals("2.4000");
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2965-04062013,0"));
							}
						}
					}

				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR_PARTIDO)) {
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.7500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Los Angeles Kings"));
							assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2966-04062013,1"));
						} else if (dato.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.0800"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Chicago Blackhawks"));
							assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2966-04062013,2"));
						}
					}
				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.HANDICAP_ASIATICO)) {
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
						if (dato.getAsianResult().equals(AsianResult.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.3900"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Los Angeles Kings"));
							assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2967-04062013,1"));
						} else if (dato.getAsianResult().equals(AsianResult.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.3200"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Chicago Blackhawks"));
							assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2967-04062013,2"));
						}
					}
				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.MAS_MENOS)) {
					assertTrue(market.getXmlMarketBets().size() == 2);
					if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetGun.PRIMERA_PARTE)) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (dato.getMasMenos().equals(MasMenos.MAS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.2000"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2973-04062013,2"));
								assertTrue(dato.getTotalGoal() == 1.5);
							} else if (dato.getMasMenos().equals(MasMenos.MENOS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.6000"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2973-04062013,1"));
								assertTrue(dato.getTotalGoal() == 1.5);
							}
						}
					} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetGun.SEGUNDA_PARTE)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (dato.getMasMenos().equals(MasMenos.MAS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.8500"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2974-04062013,2"));
								assertTrue(dato.getTotalGoal() == 1.5);
							} else if (dato.getMasMenos().equals(MasMenos.MENOS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.8500"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2974-04062013,1"));
								assertTrue(dato.getTotalGoal() == 1.5);
							}
						}
					} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetGun.TERCERA_PARTE)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (dato.getMasMenos().equals(MasMenos.MAS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.8500"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2975-04062013,2"));
								assertTrue(dato.getTotalGoal() == 1.5);
							} else if (dato.getMasMenos().equals(MasMenos.MENOS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.8500"));
								assertTrue(bet.getXmlUrl().getUrl().equals("https://www.betgun.com/en/add-bet/2975-04062013,1"));
								assertTrue(dato.getTotalGoal() == 1.5);
							}
						}
					}

				}
			}
		}

		// Basket variado
		beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "France-Pro A", "");
		xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_BASKET_VARIADO, bookmakerConfiguration, beanAdditionalInfo);
		Collection<XmlMatch> resultBasketVariado = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBasketVariado.size() == 1);
		for (XmlMatch match : resultBasketVariado) {
			assertTrue(match.getXmlTournamentEvent().getLongTerm().getLongTerm().equals(Boolean.FALSE));
			assertEquals(5, match.getXmlMarkets().size());
			if (match.getName().equals("Jsf Nanterre - Strasbourg Ig")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							//Comprobación prórroga
							assertEquals(BetEventBetGun.PARTIDO_COMPLETO_PRORROGA, market.getXmlBetType().getXmlBetEvent().getBetEvent());
							
							XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.0800"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Jsf Nanterre"));
							} else {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.7000"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Strasbourg Ig"));
							}
						}
						
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.1500"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Jsf Nanterre"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.7500"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Strasbourg Ig"));
							} else {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("15.0000"));
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.MAS_MENOS)) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							//Comprobación prórroga
							assertEquals(BetEventBetGun.PARTIDO_COMPLETO_PRORROGA, market.getXmlBetType().getXmlBetEvent().getBetEvent());
							
							XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (dato.getMasMenos().equals(MasMenos.MAS) && dato.getTotalGoal() == 153.5) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.8800"));
								assertTrue(dato.getTotalGoal() == 153.5);
							} else if (dato.getMasMenos().equals(MasMenos.MENOS) && dato.getTotalGoal() == 153.5) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.8800"));
								assertTrue(dato.getTotalGoal() == 153.5);
							} else {
								fail("Error al obtener las apuestas de mas menos");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.HANDICAP_ASIATICO)) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							//Comprobación prórroga
							assertEquals(BetEventBetGun.PARTIDO_COMPLETO_PRORROGA, market.getXmlBetType().getXmlBetEvent().getBetEvent());
							
							XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							if (dato.getAsianResult().equals(AsianResult.ONE) && dato.getFirstValue() == 2.5) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("1.9000"));
							} else if (dato.getAsianResult().equals(AsianResult.TWO) && dato.getFirstValue() == 2.5) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("1.9000"));
							} else if (dato.getAsianResult().equals(AsianResult.ONE) && dato.getFirstValue() == 4.5) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("1.7000"));
							} else if (dato.getAsianResult().equals(AsianResult.TWO) && dato.getFirstValue() == 4.5) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("2.1000"));
							} else {
								fail("Error al obtener las apuestas de handicap asiatico");
							}
						}
						
					} else {
						fail("Error al intentar recuperar los tipos de apuesta");
					}

				}
			}
		}

	}

	/**
	 * Bet click read bad test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void betGunReadBadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "European Championships U21 - Long Term", "");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_BAD, bookmakerConfiguration, beanAdditionalInfo);
		Assert.isTrue(xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs().size() == 0);
	}

	/**
	 * Bet gun black list.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void betGunBlackList() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		bookmakerConfiguration.addBlackListWord("deporte lista negra");
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "European Championships U21 - Long Term", "");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_BLACK_LIST, bookmakerConfiguration,
				beanAdditionalInfo);

		// Deporte Lista Negra
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 0);

		// Participante lista negra
		bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		bookmakerConfiguration.addBlackListWord("Participante lista negra");
		xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_BLACK_LIST, bookmakerConfiguration, beanAdditionalInfo);
		result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 2);
		for (XmlMatch match : result) {
			assertTrue(match.getXmlTournamentEvent().getLongTerm().getLongTerm().equals(Boolean.TRUE));
			if (match.getName().equals("Zwyciezca")) {
				assertEquals(match.getXmlMarkets().size(), 1);
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR));
					assertTrue(market.getXmlMarketBets().size() == 8);
				}
			} else {
				assertEquals(match.getXmlMarkets().size(), 1);
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR));
					assertTrue(market.getXmlMarketBets().size() == 4);
				}
			}
		}

	}

	/**
	 * Test bug3399.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testBug3399() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "European Championships U21 - Long Term", "");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_BUG3399, bookmakerConfiguration,
				beanAdditionalInfo);

		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);
		for (XmlMatch match : result) {
			assertTrue(match.getName().equals("Real Madrid - Atletico Madrid"));
			assertTrue(match.getXmlMarkets().size() == 1);
			for (XmlMarket market : match.getXmlMarkets()) {
				assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetGun.UNO_X_DOS));
				assertTrue(market.getXmlMarketBets().size() == 3);
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
					if (dato.getResult().equals(Result.ONE)) {
						assertTrue(bet.getXmlMatchParticipant().getName().equals("Real Madrid"));
						assertTrue(bet.getXmlBetOdd().getOdds().equals("1.7500"));
					} else if (dato.getResult().equals(Result.TWO)) {
						assertTrue(bet.getXmlMatchParticipant().getName().equals("Atletico Madrid"));
						assertTrue(bet.getXmlBetOdd().getOdds().equals("2.1500"));
					} else {
						assertTrue(bet.getXmlBetOdd().getOdds().equals("15.0000"));
					}
				}
			}
		}
	}

	/**
	 * Test que lee un xml con apuestas de tipo mas menos separadas en dos
	 * mercados distintos, uno con muchas apuestas (4) de distintos valores de
	 * mas menos y otro con una sola apuesta, la ejecucion del test debe
	 * devolver tantos mercados como apuestas disintas de masmenos haya en el
	 * xml.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void test_masMenos_severalBetsOK() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "NHL", "");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_MASMENOS_SEVERALBETS, bookmakerConfiguration,
				beanAdditionalInfo);
		int contador_1_MAS=0;
		int contador_1_MENOS=0;
		int contador_2_MAS=0;
		int contador_2_MENOS=0;
		int contador_3_MAS=0;
		int contador_3_MENOS=0;
		int contador_4_MAS=0;
		int contador_4_MENOS=0;
		int contador_7_MAS=0;
		int contador_7_MENOS=0;
		
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);
		for (XmlMatch match : result) {
			assertTrue(match.getXmlMarkets().size() == 5);
			for (XmlMarket market : match.getXmlMarkets()) {
				assertTrue(market.getXmlMarketBets().size() == 2);
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
					if (dato.getMasMenos().equals(MasMenos.MAS) && dato.getTotalGoal() == 1.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.2300"));
						contador_1_MAS++;
					} else if (dato.getMasMenos().equals(MasMenos.MENOS) && dato.getTotalGoal() == 1.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.8000"));
						contador_1_MENOS++;
					} else if (dato.getMasMenos().equals(MasMenos.MAS) && dato.getTotalGoal() == 2.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.7500"));
						contador_2_MAS++;
					} else if (dato.getMasMenos().equals(MasMenos.MENOS) && dato.getTotalGoal() == 2.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.0000"));
						contador_2_MENOS++;
					} else if (dato.getMasMenos().equals(MasMenos.MAS) && dato.getTotalGoal() == 3.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.0000"));
						contador_3_MAS++;
					} else if (dato.getMasMenos().equals(MasMenos.MENOS) && dato.getTotalGoal() == 3.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.3500"));
						contador_3_MENOS++;
					} else if (dato.getMasMenos().equals(MasMenos.MAS) && dato.getTotalGoal() == 4.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("5.5000"));
						contador_4_MAS++;
					} else if (dato.getMasMenos().equals(MasMenos.MENOS) && dato.getTotalGoal() == 4.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.1200"));
						contador_4_MENOS++;
					} else if (dato.getMasMenos().equals(MasMenos.MAS) && dato.getTotalGoal() == 7.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.2300"));
						contador_7_MAS++;
					} else if (dato.getMasMenos().equals(MasMenos.MENOS) && dato.getTotalGoal() == 7.5) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.8000"));
						contador_7_MENOS++;
					} else {
						fail("Error al obtener los mercados");
					}
				}
			}
		}
		assertEquals(1,contador_1_MAS);
		assertEquals(1,contador_1_MENOS);
		assertEquals(1,contador_2_MAS);
		assertEquals(1,contador_2_MENOS);
		assertEquals(1,contador_3_MAS);
		assertEquals(1,contador_3_MENOS);
		assertEquals(1,contador_4_MAS);
		assertEquals(1,contador_4_MENOS);
		assertEquals(1,contador_7_MAS);
		assertEquals(1,contador_7_MENOS);
	}

	/**
	 * Test que comprueba que en un mismo mercado podamos tener apuestas tanto
	 * de handicap como de handicap 1x2 por lo que tendremos que generar un
	 * mercado por tipo de apuesta.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void test_handicap1x2_severalBets_OK() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "NHL", "");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_HANDICAP_SEVERALBETS, bookmakerConfiguration,
				beanAdditionalInfo);

		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);
		for (XmlMatch match : result) {
			assertTrue(match.getXmlMarkets().size() == 6);
			for (XmlMarket market : match.getXmlMarkets()) {
				if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.HANDICAP_ASIATICO)) {
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
						if (dato.getAsianResult().equals(AsianResult.ONE) && dato.getFirstValue() == -1.5) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.8500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Linfield Belfast"));
						} else if (dato.getAsianResult().equals(AsianResult.TWO) && dato.getFirstValue() == -1.5) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.8500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("IF Fuglafjordur"));
						} else if (dato.getAsianResult().equals(AsianResult.ONE) && dato.getFirstValue() == -2.5) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("3.2500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Linfield Belfast"));
						} else if (dato.getAsianResult().equals(AsianResult.TWO) && dato.getFirstValue() == -2.5) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.2800"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("IF Fuglafjordur"));
						} else if (dato.getAsianResult().equals(AsianResult.ONE) && dato.getFirstValue() == -5.5) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.8500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Linfield Belfast"));
						} else if (dato.getAsianResult().equals(AsianResult.TWO) && dato.getFirstValue() == -5.5) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.8500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("IF Fuglafjordur"));
						} else {
							fail("Error al procesar las apuestas de handicap asiatico");
						}
					}
				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.UNO_X_DOS_HANDICAP)) {
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2HandicapAttribute dato = (Xml1X2HandicapAttribute) bet.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE) && dato.getFirstValue() == -1.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.8500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Linfield Belfast"));
						} else if (dato.getResult().equals(Result.TWO) && dato.getFirstValue() == -1.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("3.2000"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("IF Fuglafjordur"));
						} else if (dato.getResult().equals(Result.DRAW) && dato.getFirstValue() == -1.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("3.7500"));
						} else if (dato.getResult().equals(Result.ONE) && dato.getFirstValue() == -2.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("3.2500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Linfield Belfast"));
						} else if (dato.getResult().equals(Result.TWO) && dato.getFirstValue() == -2.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.7500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("IF Fuglafjordur"));
						} else if (dato.getResult().equals(Result.DRAW) && dato.getFirstValue() == -2.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("4.1000"));
						} else if (dato.getResult().equals(Result.ONE) && dato.getFirstValue() == -6.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("1.8500"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Linfield Belfast"));
						} else if (dato.getResult().equals(Result.TWO) && dato.getFirstValue() == -6.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("3.2000"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("IF Fuglafjordur"));
						} else if (dato.getResult().equals(Result.DRAW) && dato.getFirstValue() == -6.0) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("3.7500"));
						} else {
							fail("Error al procesar las apuestas de handicap asiatico");
						}
					}
				} else {
					fail("Error al obtener el tipo de apuesta");
				}
			}
		}
	}

	/**
	 * Test para probar varios handicaps en un mismo mercado con la
	 * caracteristica de que una vez separados los handicaps uno de los mercados
	 * resultantes solo tiene un asiatico y un 1x2 en vez de varios.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testHandicap3518() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "NHL", "");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_HANDICAP_3518, bookmakerConfiguration,
				beanAdditionalInfo);

		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 2);
		for (XmlMatch match : result) {
			if (match.getName().equals("Manchester United - Aston Villa")) {
				assertTrue(match.getXmlMarkets().size() == 5);
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							if (dato.getAsianResult().equals(AsianResult.ONE)) {
								assertTrue(dato.getFirstValue() == -1.5);
								assertTrue(bet.getXmlBetOdd().getOdds().equals("2.7600"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Manchester United"));
							} else if (dato.getAsianResult().equals(AsianResult.TWO)) {
								assertTrue(dato.getFirstValue() == -1.5);
								assertTrue(bet.getXmlBetOdd().getOdds().equals("1.3800"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Aston Villa"));
							} else {
								fail("Error al resolver la apuesta de tipo handicap asiatico");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.UNO_X_DOS_HANDICAP)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2HandicapAttribute dato = (Xml1X2HandicapAttribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(dato.getFirstValue() == -1);
								assertTrue(bet.getXmlBetOdd().getOdds().equals("2.7600"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Manchester United"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(dato.getFirstValue() == -1);
								assertTrue(bet.getXmlBetOdd().getOdds().equals("2.0600"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Aston Villa"));
							} else if (dato.getResult().equals(Result.DRAW)) {
								assertTrue(dato.getFirstValue() == -1);
								assertTrue(bet.getXmlBetOdd().getOdds().equals("3.7000"));
							} else {
								fail("Error al resolver la apuesta de tipo handicap 1x2");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("1.7500"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Manchester United"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("2.1500"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Aston Villa"));
							} else if (dato.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("15.0000"));
							} else {
								fail("Error al resolver la apuesta de tipo 1x2");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (dato.getMasMenos().equals(MasMenos.MAS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.2300"));
								assertTrue(dato.getTotalGoal() == 1.5);
							} else if (dato.getMasMenos().equals(MasMenos.MENOS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.8000"));
								assertTrue(dato.getTotalGoal() == 1.5);
							} else {
								fail("Error al resolver la apuesta de tipo masmenos");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(dato.getWinnerName().getName().equals("Manchester United"));
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.3900"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(dato.getWinnerName().getName().equals("Aston Villa"));
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.7400"));
							} else {
								fail("Error al resolver la apuesta de tipo ganador partido");
							}
						}
					}
				}
			} else if (match.getName().equals("Eng. Premier League")) {
				assertTrue(match.getXmlMarkets().size() == 1);
				for (XmlMarket market : match.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR));
					assertTrue(market.getXmlMarketBets().size() == 5);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
//						XmlWinnerAttribute dato = (XmlWinnerAttribute) bet.getXmlAttribute();
						if (bet.getXmlMatchParticipant().getName().equals("Manchester United")) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("3.0000"));
						} else if (bet.getXmlMatchParticipant().getName().equals("Manchester City")) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("4.1500"));
						} else if (bet.getXmlMatchParticipant().getName().equals("Chelsea FC")) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("6.2500"));
						} else if (bet.getXmlMatchParticipant().getName().equals("Aston Villa")) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("6.5000"));
						} else if (bet.getXmlMatchParticipant().getName().equals("West Ham")) {
							assertTrue(bet.getXmlBetOdd().getOdds().equals("6.7500"));
						} else {
							fail ("Error al resolver la apuesta de tipo ganador");
						}
					}
				}
			} else {
				fail("Error al recuperar los matches");
			}
		}
	}
	
	@Test
	public void tennisTest () throws Exception{
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(BETGUN_TIMEZONE);
		BeanAdditionalXmlInfoReader beanAdditionalInfo = new BeanAdditionalXmlInfoReader("", "ATP Vina del Mar", "");
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(BETGUN_READER, BETGUN_XML_TENNIS_ODDS, bookmakerConfiguration,
				beanAdditionalInfo);

		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() == 1);
		for (XmlMatch match : result) {
			assertTrue(match.getXmlMarkets().size() == 3);
			if (match.getName().equals("L.Mayer-A.Haider Maurer")) {
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							if (dato.getAsianResult().equals(AsianResult.ONE)) {
								assertTrue(dato.getFirstValue() == -1.5);
								assertTrue(bet.getXmlBetOdd().getOdds().equals("2.0700"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("L.Mayer"));
							} else if (dato.getAsianResult().equals(AsianResult.TWO)) {
								assertTrue(dato.getFirstValue() == -1.5);
								assertTrue(bet.getXmlBetOdd().getOdds().equals("1.7000"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("A.Haider Maurer"));
							} else {
								fail("Error al resolver la apuesta de tipo handicap asiatico");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (dato.getMasMenos().equals(MasMenos.MAS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.3500"));
								assertTrue(dato.getTotalGoal() == 2.5);
							} else if (dato.getMasMenos().equals(MasMenos.MENOS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.5300"));
								assertTrue(dato.getTotalGoal() == 2.5);
							} else {
								fail("Error al resolver la apuesta de tipo masmenos");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetGun.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute dato = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
							if (dato.getResult().equals(Result.ONE)) {
								assertTrue(dato.getWinnerName().getName().equals("L.Mayer"));
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.4200"));
							} else if (dato.getResult().equals(Result.TWO)) {
								assertTrue(dato.getWinnerName().getName().equals("A.Haider Maurer"));
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.7800"));
							} else {
								fail("Error al resolver la apuesta de tipo ganador partido");
							}
						}
					}
				}
			} else {
				fail("Error al recuperar los matches");
			}
		}
		
	}

}
