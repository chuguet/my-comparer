/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparador.bet.comparer.test.core.mainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.ActiveProfiles;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
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
public final class IntertopsCompleteBug4245Test /*extends AbstractTemplateMainTest*/ {

//	/** The Constant XML_LOCATION. */
//	private static final String BC_XML_LOCATION_SHORT = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
//			+ "\\test\\core\\xmlReaders\\Intertops_Bug4245.xml";
//	
//	private static final Integer bookmakerOrderIntertops = 13;
//
//	private static final BigInteger idBookmakerIntertops = new BigInteger("69");
//	
//	@Override
//	protected List<BeanBookmaker> getBookmakersData() {
//		List<BeanBookmaker> bookmakersData = new ArrayList<BeanBookmaker>();
//		
//		//Intertops
//		BeanBookmaker beanBookmaker = new BeanBookmaker();
//		beanBookmaker.setXmlLocation(BC_XML_LOCATION_SHORT);
//		beanBookmaker.setOrdenBookmaker(bookmakerOrderIntertops);
//		beanBookmaker.setIdBookmaker(idBookmakerIntertops);
//		beanBookmaker.setBookmaker(getBookmakerIntertops());
//		BeanAdditionalXmlInfoReader beanAdiAdditionalXmlInfoReader = new BeanAdditionalXmlInfoReader(
//				"", "", "");
//		beanBookmaker
//				.setBeanAdditionalXmlInfoReader(beanAdiAdditionalXmlInfoReader);
//		bookmakersData.add(beanBookmaker);
//		
//		return bookmakersData;
//	}
//
//	private CfgBookmaker getBookmakerIntertops() {
//		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerIntertops);
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		bookmakerConfiguration.setTimeZone("GMT+0");
//		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl(
//				"http://www.intertops.com"));
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//		return bookmaker;
//	}
//	
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
//	 * #verificarLecturaXml()
//	 */
//	@Override
//	public void verificarLecturaXml() {
////		assertTrue(getEventosLeidos().size() == Integer.valueOf(1));
////		for (BeanLectura match : getEventosLeidos()) {
////			if (match.getXmlMatch().getName().equalsIgnoreCase("FC Zenit St Petersburg v Athletico Madrid")) {
////				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
////				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
////					if (market.getXmlBetType().getBetType().equals(BetTypeInterTops.HANDICAP_ASIATICO)) {
////						assertTrue(market.getXmlMarketBets().size() == 2);
////						for (XmlMarketBet bet : market.getXmlMarketBets()) {
////							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
////							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
////								assertTrue(bet.getXmlMatchParticipant().getName().equals("FC Zenit St Petersburg"));
////								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2"));
////								assertTrue(atributo.getFirstValue() == -0.5);
////								assertEquals(null, atributo.getSecondValue());
////							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
////								assertTrue(bet.getXmlMatchParticipant().getName().equals("Athletico Madrid"));
////								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.8"));
////								assertTrue(atributo.getFirstValue() == -0.5);
////								assertEquals(null, atributo.getSecondValue());
////							} else {
////								fail("Error en la lectura del xml");
////							}
////						}
////					} else {
////						fail("Error en la lectura del xml");
////					}
////					
////				}
////			} else if (match.getXmlMatch().getName().equalsIgnoreCase("FC Zenit St Petersburg-Athletico Madrid")) {
////				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
////					if (market.getXmlBetType().getBetType().equals(BetTypeInterTops.HANDICAP_ASIATICO)) {
////						assertTrue(market.getXmlMarketBets().size() == 2);
////						for (XmlMarketBet bet : market.getXmlMarketBets()) {
////							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
////							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
////								assertTrue(bet.getXmlMatchParticipant().getName().equals("FC Zenit St Petersburg"));
////								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2"));
////								assertTrue(atributo.getFirstValue() == -0.5);
////								assertEquals(null, atributo.getSecondValue());
////							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
////								assertTrue(bet.getXmlMatchParticipant().getName().equals("Athletico Madrid"));
////								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.8"));
////								assertTrue(atributo.getFirstValue() == -0.5);
////								assertEquals(null, atributo.getSecondValue());
////							} else {
////								fail("Error en la lectura del xml");
////							}
////						}
////					} else {
////						fail("Error en la lectura del xml");
////					}
////				}
////			} else {
////				fail("Error en la lectura del xml");
////			}
////		}
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
//	 * #verificarXmlGuardadosBD()
//	 */
//	@Override
//	public void verificarXmlGuardadosBD() {
////		assertTrue(getEventosProcesados().size() == Integer.valueOf(1));
////		for (RtMatch match : getEventosProcesados()) {
////			if (match.getName(null).equals("FC Zenit St Petersburg vs Athletico Madrid")) {
////				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
////				for (RtMarket market : match.getRtMarkets()) {
////					if (market.getBetType().getNameId().equals(BetTypeBookmaker.HANDICAP_ASIATICO.getId())) {
////						assertTrue(market.getBets().size() == 2);
////						for (RtBet bet : market.getBets()) {
////							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet.getAttribute();
////							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
////								assertTrue(bet.getBetOdd().getOdds().equals("2"));
////								assertTrue(atributo.getFirstValue() == -0.5);
////								assertEquals(null, atributo.getSecondValue());
////							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
////								assertTrue(bet.getBetOdd().getOdds().equals("1.8"));
////								assertTrue(atributo.getFirstValue() == -0.5);
////								assertEquals(null, atributo.getSecondValue());
////							} else {
////								fail("Error en la lectura del xml");
////							}
////						}
////					} else {
////						fail("Error en la lectura del xml");
////					}
////				}
////			} else {
////				fail("Error en la lectura del xml");
////			}
////		}
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
//	 * #verificarValueBetGenerada()
//	 */
//	@Override
//	public void verificarValueBetGenerada() {
//		ResultValueBet resultValueBet = getResultValueBet();
//		assertTrue(resultValueBet.getValueBetDatas().size() == 0);
//		// TODO rellenar con mas pruebas
//
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see
//	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
//	 * #verificarSureBetGenerada()
//	 */
//	@Override
//	public void verificarSureBetGenerada() {
//		CalculateSecureBetBean sureBet = getCalculateSecureBetBean();
//		assertTrue(sureBet.getSecureBetBeans() != null);
//		// TODO rellenar con mas pruebas
//	}

}
