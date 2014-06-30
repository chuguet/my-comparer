/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparador.bet.comparer.test.core.mainTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.test.context.ActiveProfiles;

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractBookmakereuDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker.BetTypeBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanBookmaker;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BookmakereuCompleteTest.
 */
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public final class BookmakereuCompleteBug4197Test extends AbstractTemplateMainTest {

	/** The Constant XML_LOCATION. */
	private static final String BC_XML_LOCATION_SHORT = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\bookmakereu_bug4197.xml";

	private static final Integer bookmakerOrder = 10;

	private static final BigInteger idBookmaker = new BigInteger("42");
	
	
	@Override
	protected List<BeanBookmaker> getBookmakersData() {
		List<BeanBookmaker> bookmakersData = new ArrayList<BeanBookmaker>();
		BeanBookmaker beanBookmaker = new BeanBookmaker();
		beanBookmaker.setXmlLocation(BC_XML_LOCATION_SHORT);
		beanBookmaker.setOrdenBookmaker(bookmakerOrder);
		beanBookmaker.setIdBookmaker(idBookmaker);
		beanBookmaker.setBookmaker(getBookmaker());
		BeanAdditionalXmlInfoReader beanAdiAdditionalXmlInfoReader = new BeanAdditionalXmlInfoReader(
				"", "", "");
		Map<String, String> deporte_torneo = new HashMap<String, String>();
		deporte_torneo.put("12251", "Soccer");
		deporte_torneo.put("12068", "Soccer");
		beanAdiAdditionalXmlInfoReader.setMapLeaguesBySport(deporte_torneo);
		beanBookmaker
				.setBeanAdditionalXmlInfoReader(beanAdiAdditionalXmlInfoReader);
		bookmakersData.add(beanBookmaker);

		return bookmakersData;
	}

	private CfgBookmaker getBookmaker() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmaker);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl(
				"http://www.bookmaker.eu"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarLecturaXml()
	 */
	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(1));
		for (BeanLectura match : getEventosLeidos()) {
			if (match.getXmlMatch().getName().equalsIgnoreCase("MANCHESTER UNITED vs ASTON VILLA")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(3));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBookmaker.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.05"));
								assertTrue(bet.getXmlMarketBetOdd().getAmericanOdds().equals("105"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("MANCHESTER UNITED"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.30"));
								assertTrue(bet.getXmlMarketBetOdd().getAmericanOdds().equals("230"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("ASTON VILLA"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.00"));
								assertTrue(bet.getXmlMarketBetOdd().getAmericanOdds().equals("200"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBookmaker.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (atributo.getTotalGoal() == 2) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.80"));
									assertTrue(bet.getXmlMarketBetOdd().getAmericanOdds().equals("-125"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.95"));
									assertTrue(bet.getXmlMarketBetOdd().getAmericanOdds().equals("-105"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBookmaker.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -12);
							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
								assertTrue(bet.getXmlMatchParticipant().getName().equals("MANCHESTER UNITED"));
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.87"));
								assertTrue(bet.getXmlMarketBetOdd().getAmericanOdds().equals("-115"));
							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
								assertTrue(bet.getXmlMatchParticipant().getName().equals("ASTON VILLA"));
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.25"));
								assertTrue(bet.getXmlMarketBetOdd().getAmericanOdds().equals("-400"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else {
				fail("Error en la lectura del xml");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarXmlGuardadosBD()
	 */
	@Override
	public void verificarXmlGuardadosBD() {
		assertTrue(getEventosProcesados().size() == Integer.valueOf(1));
		for (RtMatch match : getEventosProcesados()) {
			if (match.getName(null).equals("Manchester United vs Aston Villa")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(3));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBookmaker.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.05"));
								assertTrue(bet.getBetOdd().getAmericanOdds().equals("105"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.30"));
								assertTrue(bet.getBetOdd().getAmericanOdds().equals("230"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.00"));
								assertTrue(bet.getBetOdd().getAmericanOdds().equals("200"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBookmaker.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet.getAttribute();
							if (atributo.getTotalGoalValue() == 2) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.80"));
									assertTrue(bet.getBetOdd().getAmericanOdds().equals("-125"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.95"));
									assertTrue(bet.getBetOdd().getAmericanOdds().equals("-105"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBookmaker.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet.getAttribute();
							assertTrue(atributo.getFirstValue() == -12);
							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.87"));
								assertTrue(bet.getBetOdd().getAmericanOdds().equals("-115"));
							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.25"));
								assertTrue(bet.getBetOdd().getAmericanOdds().equals("-400"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} else {
				fail("Error en la lectura del xml");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarValueBetGenerada()
	 */
	@Override
	public void verificarValueBetGenerada() {
		ResultValueBet resultValueBet = getResultValueBet();
		assertTrue(resultValueBet.getValueBetDatas().size() == 0);
		// TODO rellenar con mas pruebas

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarSureBetGenerada()
	 */
//	@Override
//	public void verificarSureBetGenerada() {
//		SureBetsMatch sureBet = getCalculateSecureBetBean();
//		assertTrue(sureBet.getSecureBetBeans() != null);
//		// TODO rellenar con mas pruebas
//	}

}
