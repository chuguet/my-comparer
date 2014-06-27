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

import java.io.FileNotFoundException;
import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventYouWin;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeYouWin;
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
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.youwin.XMLYouWinFileReader;

/**
 * The Class XMLYouWinFileReaderTest.
 */
public class XMLYouWinFileReaderTest extends AbstractTest {

	private static final String YOUWIN_XML_LOCATION_BUG3242 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_bug3242.xml";

	private static final String YOUWIN_XML_LOCATION_BUG3251 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_bug3251.xml";

	private static final String YOUWIN_XML_LOCATION_BUG3430 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_bug3430.xml";

	private static final String YOUWIN_XML_LOCATION_BUG3731 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_bug3731.xml";

	/** The Constant YOUWIN_XML_LOCATION. */
	private static final String YOUWIN_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin.xml";

	/** The Constant YOUWIN_XML_LOCATION. */
	private static final String YOUWIN_XML_LOCATION_BIG = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youwin_big.xml";

	private static final String YOUWIN_XML_LOCATION_BUG3734 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_bug3734.xml";
	
	private static final String YOUWIN_XML_LOCATION_TENIS = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_tenis.xml";
	
	/**
	 * Localización del fichero de pruebas para el testBug4024()
	 */
	private static final String YOUWIN_XML_LOCATION_BUG4024 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_bug4024.xml";
	
	/**
	 * Localización del fichero de pruebas para el testBug4025()
	 */
	private static final String YOUWIN_XML_LOCATION_BUG4025 = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_bug4025.xml";
	
	/**
	 * Localización del fichero de pruebas para el test contemplacion de prorrogas()
	 */
	private static final String YOUWIN_XML_LOCATION_PRORROGAS = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\youwin\\youWin_prorroga.xml";

	/** The bet click reader. */
	@Inject
	private XMLYouWinFileReader youWinReader;

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(youWinReader.getBookmakerId());
		assertEquals(youWinReader.getBookmakerId(), CfgBookmakerId.YOUWIN_COM_ID.objectId().toString());
	}

	/**
	 * You win read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void youWinReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);
		for (XmlMatch sport : result) {
			if (sport.getName().equals("Club Olimpia v Club General Diaz")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Paraguay");
				assertEquals(sport.getXmlMarkets().size(), 5);
			} else if (sport.getName().equals("World Rally Championship 2013")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "FIA World Rally");
				assertEquals(sport.getXmlMarkets().size(), 1);
				for (XmlMarket bet : sport.getXmlMarkets()) {
					assertEquals(bet.getXmlMarketBets().size(), 6);
				}
			}
		}

		// Bug 3242
		xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_BUG3242, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBug3242 = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBug3242.size() == 3);
		for (XmlMatch sport : resultBug3242) {
			if (sport.getName().equals("New York Knicks v Indiana Pacers")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(sport.getXmlMarkets().size(), 1);
				for (XmlMarket market : sport.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeYouWin.HANDICAP_ASIATICO));
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute dato = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
						if (dato.getAsianResult().equals(AsianResult.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.50"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("New York Knicks"));
							assertTrue(dato.getFirstValue() == -5.0);
						} else {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.35"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Indiana Pacers"));
							assertTrue(dato.getFirstValue() == -5.0);
						}
					}
				}
			} else if (sport.getName().equals("Mallorca v Real Betis")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(sport.getXmlMarkets().size(), 1);
				for (XmlMarket market : sport.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeYouWin.UNO_X_DOS_HANDICAP));
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2HandicapAttribute dato = (Xml1X2HandicapAttribute) bet.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("4.55"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Mallorca"));
							assertTrue(dato.getFirstValue() == -1.0);
						} else if (dato.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.54"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Real Betis"));
							assertTrue(dato.getFirstValue() == -1.0);
						} else {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.95"));
							assertTrue(dato.getFirstValue() == -1.0);
						}
					}
				}
			} else if (sport.getName().equals("Getafe CF vs Valencia CF")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(sport.getXmlMarkets().size(), 1);
				for (XmlMarket market : sport.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeYouWin.MAS_MENOS));
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute dato = (XmlMoreLessAttribute) bet.getXmlAttribute();
						if (dato.getMasMenos().equals(MasMenos.MAS)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.64"));
							assertTrue(dato.getTotalGoal() == 2.5);
						} else {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.12"));
							assertTrue(dato.getTotalGoal() == 2.5);
						}
					}
				}
			}
		}

		// Bug 3251
		xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_BUG3251, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBug3251 = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBug3251.size() == 1);
		for (XmlMatch sport : resultBug3251) {
			if (sport.getName().equals("Real Madrid vs Atletico Madrid")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(sport.getXmlMarkets().size(), 1);
				for (XmlMarket market : sport.getXmlMarkets()) {
					assertTrue(market.getXmlBetType().getBetType().equals(BetTypeYouWin.UNO_X_DOS));
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2Attribute dato = (Xml1X2Attribute) bet.getXmlAttribute();
						if (dato.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Real Madrid"));
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.52"));
						} else if (dato.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Atletico Madrid"));
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("5.78"));
						} else {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("4.22"));
						}
					}
				}
			}
		}

	}

	@Test
	public void testBug3430() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_BUG3430, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBug3430 = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBug3430.size() == 1);
		for (XmlMatch sport : resultBug3430) {
			if (sport.getName().equals("Shandong Luneng Taishan FC vs Jiangsu Shuntian")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(sport.getXmlMarkets().size(), 3);
			}
		}
	}

	@Test
	public void testBug3731() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_BUG3731, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBug3731 = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBug3731.size() == 1);
		for (XmlMatch sport : resultBug3731) {
			if (sport.getName().equals("Real Madrid vs Atletico Madrid")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(sport.getXmlMarkets().size(), 1);
				XmlMarket market = sport.getXmlMarkets().iterator().next();
				for (XmlMarketBet bet : market.getXmlMarketBets()) {
					assertTrue(((XmlMoreLessAttribute) bet.getXmlAttribute()).getTotalGoal() == 7.5);
					if (((XmlMoreLessAttribute) bet.getXmlAttribute()).getMasMenos().equals(MasMenos.MENOS)) {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.75"));
					} else {
						assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.11"));
					}
				}
			}
		}
	}

	/**
	 * You win read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void youWinReadBigTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_BIG, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);
		for (XmlMatch sport : result) {
			if (sport.getName().equals("Atletico Madrid vs Valencia CF")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(sport.getXmlMarkets().size(), 1);
				assertEquals(sport.getXmlTournament().getXmlSport().getName(), "Football");
				for (XmlMatchParticipant participant : sport.getXmlMatchParticipants()) {
					assertTrue(participant.getName().equals("Atletico Madrid") || participant.getName().equals("Valencia CF"));
				}
			}
		}
	}

	/**
	 * Test para bug 3734. No leer en el reader de Youwin y Uwin las
	 * competiciones "Upcoming Matches". En caso de aparecer esa competición y
	 * sus partidos asociados no serán tenidos en cuenta.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBug3734() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_BUG3734, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBug3734 = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBug3734.size() == 0);
	}

	/**
	 * Test que comprueba que los handicaps de tipo European Handicaps se
	 * resuelven correctamente.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBug4024() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_BUG4024, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBug3731 = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBug3731.size() == 1);
		for (XmlMatch sport : resultBug3731) {
			if (sport.getName().equals("Alcorcon AD vs Numancia CD")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(2, sport.getXmlMatchParticipants().size());
				assertEquals(4, sport.getXmlMarkets().size());
				for (XmlMarket market : sport.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.UNO_X_DOS_HANDICAP)) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {					
							Xml1X2HandicapAttribute dato = (Xml1X2HandicapAttribute) bet.getXmlAttribute();
							if (dato.getFirstValue().equals(1.0)) {
								if (dato.getResult().equals(Result.ONE)) {
									assertEquals("1.20", bet.getXmlMarketBetOdd().getOdds());
									assertEquals("Alcorcon AD", bet.getXmlMatchParticipant().getName());
								} else if (dato.getResult().equals(Result.DRAW)) {
									assertEquals("5.00", bet.getXmlMarketBetOdd().getOdds());
								} else if (dato.getResult().equals(Result.TWO)) {
									assertEquals("8.75", bet.getXmlMarketBetOdd().getOdds());
									assertEquals("Numancia CD", bet.getXmlMatchParticipant().getName());
								} else {
									fail ("Error en la apuesta");
								}
							} else if (dato.getFirstValue().equals(2.0)) {
								if (dato.getResult().equals(Result.ONE)) {
									assertEquals("1.04", bet.getXmlMarketBetOdd().getOdds());
									assertEquals("Alcorcon AD", bet.getXmlMatchParticipant().getName());
								} else if (dato.getResult().equals(Result.DRAW)) {
									assertEquals("7.75", bet.getXmlMarketBetOdd().getOdds());
								} else if (dato.getResult().equals(Result.TWO)) {
									assertEquals("20.00", bet.getXmlMarketBetOdd().getOdds());
									assertEquals("Numancia CD", bet.getXmlMatchParticipant().getName());
								} else {
									fail ("Error en la apuesta");
								}
							} else if (dato.getFirstValue().equals(-1.0)) {
								if (dato.getResult().equals(Result.ONE)) {
									assertEquals("3.40", bet.getXmlMarketBetOdd().getOdds());
									assertEquals("Alcorcon AD", bet.getXmlMatchParticipant().getName());
								} else if (dato.getResult().equals(Result.DRAW)) {
									assertEquals("3.40", bet.getXmlMarketBetOdd().getOdds());
								} else if (dato.getResult().equals(Result.TWO)) {
									assertEquals("1.80", bet.getXmlMarketBetOdd().getOdds());
									assertEquals("Numancia CD", bet.getXmlMatchParticipant().getName());
								} else {
									fail ("Error en la apuesta");
								}
							} else if (dato.getFirstValue().equals(-2.0)) {
								if (dato.getResult().equals(Result.ONE)) {
									assertEquals("7.75", bet.getXmlMarketBetOdd().getOdds());
									assertEquals("Alcorcon AD", bet.getXmlMatchParticipant().getName());
								} else if (dato.getResult().equals(Result.DRAW)) {
									assertEquals("4.85", bet.getXmlMarketBetOdd().getOdds());
								} else if (dato.getResult().equals(Result.TWO)) {
									assertEquals("1.25", bet.getXmlMarketBetOdd().getOdds());
									assertEquals("Numancia CD", bet.getXmlMatchParticipant().getName());
								} else {
									fail ("Error en la apuesta");
								}
							} else {
								fail ("Error al obtener los atributos de la apuesta");
							}
						}
					} else {
						fail ("Error al obtener el mercado");
					}
					
					
				}
				
			}
		}
	}
	
	
	
	/**
	 * Test que comprueba que las apuestas de maximo goleador se resuelven correctamente.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBug4025() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_BUG4025, bookmakerConfiguration, null);
		Collection<XmlMatch> resultBug4025 = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultBug4025.size() == 1);
		for (XmlMatch sport : resultBug4025) {
			if (sport.getName().equals("Spain - La Liga 2013-14")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "Spain");
				assertEquals(3, sport.getXmlMatchParticipants().size());
				assertEquals(1, sport.getXmlMarkets().size());
				for (XmlMarket market : sport.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.MAXIMO_GOLEADOR)) {
						for (XmlMarketBet bet : market.getXmlMarketBets()) {					
							XmlMaximumGoalerAttribute dato = (XmlMaximumGoalerAttribute) bet.getXmlAttribute();
							if (dato.getGoaler().getName().equals("Lionel Messi")) {
								assertEquals("1.57",bet.getXmlMarketBetOdd().getOdds());
							} else if (dato.getGoaler().getName().equals("Cristiano Ronaldo")) {
								assertEquals("2.63",bet.getXmlMarketBetOdd().getOdds());
							} else if (dato.getGoaler().getName().equals("Diego Costa")) {
								assertEquals("8.50",bet.getXmlMarketBetOdd().getOdds());
							}  else {
								fail ("Error al obtener los atributos de la apuesta");
							}
						}
					} else {
						fail ("Error al obtener el mercado");
					}
					
					
				}
				
			}
		}
	}
	
	
	/**
	 * Test que comprueba si se asigna correctamente los partidos con prorroga
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProrrogas() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_PRORROGAS, bookmakerConfiguration, null);
		Collection<XmlMatch> overtimeMatchs = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(overtimeMatchs.size() == 2);
		for (XmlMatch sport : overtimeMatchs) {
			if (sport.getName().equals("Arizona Cardinals @ Philadelphia Eagles")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "NFL");
				assertEquals(2, sport.getXmlMatchParticipants().size());
				assertEquals(3, sport.getXmlMarkets().size());
				for (XmlMarket market : sport.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.GANADOR_PARTIDO)
							||market.getXmlBetType().getBetType().equals(BetTypeYouWin.HANDICAP_ASIATICO)
							||market.getXmlBetType().getBetType().equals(BetTypeYouWin.MAS_MENOS)){
						
						assertEquals(BetEventYouWin.PARTIDO_COMPLETO_PRORROGA, market.getXmlBetType().getXmlBetEvent().getBetEvent());
					}		
				}
				
			}else if (sport.getName().equals("Anaheim Ducks @ Dallas Stars")) {
				assertEquals(sport.getXmlTournament().getRegion().getName(), "NHL");
				assertEquals(2, sport.getXmlMatchParticipants().size());
				assertEquals(3, sport.getXmlMarkets().size());
				for (XmlMarket market : sport.getXmlMarkets()) {
					// comprobacion de ganador partido para etiqueta draw no bet
					if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.GANADOR_PARTIDO)){
						assertEquals(BetEventYouWin.PARTIDO_COMPLETO, market.getXmlBetType().getXmlBetEvent().getBetEvent());
						
					}else if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.HANDICAP_ASIATICO)
							||market.getXmlBetType().getBetType().equals(BetTypeYouWin.MAS_MENOS)){
						
						assertEquals(BetEventYouWin.PARTIDO_COMPLETO_PRORROGA, market.getXmlBetType().getXmlBetEvent().getBetEvent());
					}else if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.UNO_X_DOS_HANDICAP)){
						if (market.getXmlBetType().getXmlBetEvent().getBetEvent() != null){
							assertEquals(BetEventYouWin.PARTIDO_COMPLETO, market.getXmlBetType().getXmlBetEvent().getBetEvent());	
						}
					}
				}
			}
		}
	}
	
	
	@Test
	public void testTenis() throws FileNotFoundException, XmlReaderException {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(YOUWIN_TIMEZONE);

		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(YOUWIN_READER, YOUWIN_XML_LOCATION_TENIS, bookmakerConfiguration, null);
		Collection<XmlMatch> tenisMatchs = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
		assertTrue(tenisMatchs.size() == 3);
		for (XmlMatch match : tenisMatchs) {
			assertTrue(match.getXmlTournament().getXmlSport().getName().equals("Tennis"));
			if (match.getName().equals("Davis Cup 2014")) {
				assertTrue(match.getXmlTournament().getName().equals("Davis Cup Davis Cup 2014"));
				assertEquals(match.getXmlTournament().getRegion().getName(), "Davis Cup");
				assertEquals(8, match.getXmlMatchParticipants().size());
				assertEquals(1, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 8);
					} else {
						fail("Error en la resolucion del mercado");
					}
				}
			} else if (match.getName().equals("Fed Cup 2014")) {
				assertTrue(match.getXmlTournament().getName().equals("Federation Cup Fed Cup 2014"));
				assertEquals(match.getXmlTournament().getRegion().getName(), "Federation Cup");
				assertEquals(8, match.getXmlMatchParticipants().size());
				assertEquals(1, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 8);
					} else {
						fail("Error en la resolucion del mercado");
					}
				}
			} else if (match.getName().equals("Almagro, Nicolas vs Alund, Martin")) {
				assertTrue(match.getXmlTournament().getName().equals("ATP Via del Mar Matches"));
				assertEquals(match.getXmlTournament().getRegion().getName(), "ATP Via del Mar");
				assertEquals(2, match.getXmlMatchParticipants().size());
				assertEquals(3, match.getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMarkets()) {
					if (market.getXmlBetType().getXmlBetEvent().getBetEvent() == null) {
						 if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.GANADOR_PARTIDO)) {
								assertTrue(market.getXmlMarketBets().size() == 2);
								assertTrue(market.getXmlMarketBets().size() == 2);
						 } else {
							 fail ("Error al resolver el tipo de apuesta");
						 }
					} else {
						if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.GANADOR_PARTIDO) && market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventYouWin.PRIMER_SET)) {
							assertTrue(market.getXmlMarketBets().size() == 2);
							assertTrue(market.getXmlMarketBets().size() == 2);
						} else if (market.getXmlBetType().getBetType().equals(BetTypeYouWin.GANADOR_PARTIDO) && market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventYouWin.SEGUNDO_SET)) {
							assertTrue(market.getXmlMarketBets().size() == 2);
							assertTrue(market.getXmlMarketBets().size() == 2);
						} else {
							fail("Error en la resolucion del mercado");
						}
					}
					
				}
			} else {
				fail("Error en la resolucion del partido");
			} 
		}
		
	}

}
