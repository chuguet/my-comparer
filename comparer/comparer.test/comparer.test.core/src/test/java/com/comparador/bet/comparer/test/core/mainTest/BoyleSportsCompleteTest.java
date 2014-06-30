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

import org.springframework.test.context.ActiveProfiles;

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractBoyleSportsDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBoyleSports;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BetClickCompleteTest.
 */
public final class BoyleSportsCompleteTest extends AbstractBoyleSportsDecorator {

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
			if (match.getXmlMatch().getName()
					.equals("Premier League 2013/2014")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(2));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeBoyleSports.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Man United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.25"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Man City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.25"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Chelsea")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.25"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1001.00"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("West Ham")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2001.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBoyleSports.MAXIMO_GOLEADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Silva, David")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.05"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Van Persie, Robin")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("5.00"));
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
	 * #verificarXmlGuardadosBD()
	 */
	@Override
	public void verificarXmlGuardadosBD() {
		assertTrue(getEventosProcesados().size() == Integer.valueOf(1));
		for (RtMatch match : getEventosProcesados()) {
			if (match.getName(null).equals("Premier League 2013/2014")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(2));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeBoyleSports.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.25"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.25"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.25"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1001.00"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2001.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBoyleSports.MAXIMO_GOLEADOR.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Silva, David")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.05"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Van Persie, Robin")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("5.00"));
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
