/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparador.bet.comparer.test.core.mainTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.springframework.test.context.ActiveProfiles;

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractPinnacleSportsDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.pinnacle.BetEventPinnacleSports;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.pinnacle.BetTypePinnacleSports;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class PinnacleSportsCompleteTest.
 */
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public final class PinnacleSportsCompleteTest extends
		AbstractPinnacleSportsDecorator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarLecturaXml()
	 */
	/** {@inheritDoc} */
	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(4));
		for (BeanLectura match : getEventosLeidos()) {
			if (match.getXmlMatch().getName().equals("WTA Birmingham")) {
				assertEquals(4, match.getXmlMatch().getXmlMarkets().size());
				// for (XmlMarket market : match.getXmlMatch().getXmlMarkets())
				// {
				// for (XmlMarketBet bet : market.getXmlMarketBets()) {
				// XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute)
				// bet
				// .getXmlAttribute();
				// if (atributo.getResult().equals(Result.ONE)) {
				// assertNotNull(bet.getXmlMarketBetOdd().getOdds());
				// assertTrue(bet.getXmlMatchParticipant().getName()
				// .equals("Van Uytvanck A."));
				// } else if (atributo.getResult().equals(Result.TWO)) {
				// assertNotNull(bet.getXmlMarketBetOdd().getOdds());
				// assertTrue(bet.getXmlMatchParticipant().getName()
				// .equals("Morita A."));
				// } else {
				// fail("Error en la lectura del xml");
				// }
				// }
				// }
			} else if (match.getXmlMatch().getName().equals("Eng. Premier")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(4));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypePinnacleSports.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.15"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.30"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.60"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypePinnacleSports.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 3) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.97"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.93"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypePinnacleSports.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (market
									.getXmlBetType()
									.getXmlBetEvent()
									.getBetEvent()
									.getId()
									.equals(BetEventPinnacleSports.PARTIDO_COMPLETO
											.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.50"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.20"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypePinnacleSports.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -1.25);
							if (atributo.getAsianResult().equals(
									AsianResult.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.79"));
							} else if (atributo.getAsianResult().equals(
									AsianResult.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.14"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}

					else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName()
					.equals("Eng. Premier OT Incl")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypePinnacleSports.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (market
									.getXmlBetType()
									.getXmlBetEvent()
									.getBetEvent()
									.getId()
									.equals(BetEventPinnacleSports.PARTIDO_COMPLETO_PRORROGA
											.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.80"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.00"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match
					.getXmlMatch()
					.getName()
					.equals("English Premier League 2013-2014: Outright Winner")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypePinnacleSports.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.96"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.52"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Chelsea")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.55"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("4.17"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("West Ham United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("6.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
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
	/** {@inheritDoc} */
	@Override
	public void verificarXmlGuardadosBD() {
		assertTrue(getEventosProcesados().size() == Integer.valueOf(3));
		for (RtMatch match : getEventosProcesados()) {
			// Prueba especifica para tenis de corto plazo
			if (match.getName(null).equals("Van Uytvanck A. vs Morita A.")) {
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeInterTops.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.54"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Van Uytvanck A."));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.67"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Morita A."));
							} else {
								fail("Error en la lectura del xml");
							}
						}

					}
				}
			} else if (match.getName(null).equals(
					"Manchester United vs Aston Villa")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(5));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypePinnacleSports.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.15"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.30"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.60"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypePinnacleSports.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 3) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.97"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.93"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market
							.getBetType()
							.getNameId()
							.equals(BetTypePinnacleSports.GANADOR_PARTIDO
									.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
									.getAttribute();
							if (market
									.getBetTypeEvent()
									.getBetTypeEvent()
									.getNameId()
									.equals(BetEventPinnacleSports.PARTIDO_COMPLETO
											.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.50"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.20"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market
									.getBetTypeEvent()
									.getBetTypeEvent()
									.getNameId()
									.equals(BetEventPinnacleSports.PARTIDO_COMPLETO_PRORROGA
											.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.80"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.00"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market
							.getBetType()
							.getNameId()
							.equals(BetTypePinnacleSports.HANDICAP_ASIATICO
									.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							assertTrue(atributo.getFirstValue() == -1.25);
							if (atributo.getAsianResult().equals(
									AsianResult.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.79"));
							} else if (atributo.getAsianResult().equals(
									AsianResult.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.14"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}

					else
						fail("Error en la lectura del xml");
				}
			} else if (match.getName(null).equals(
					"English Premier League 2013-2014: Outright Winner")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypePinnacleSports.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.96"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.52"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.55"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("4.17"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("6.00"));
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
	/** {@inheritDoc} */
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
//	/** {@inheritDoc} */
//	@Override
//	public void verificarSureBetGenerada() {
//		SureBetsMatch sureBet = getCalculateSecureBetBean();
//		assertTrue(sureBet.getSecureBetBeans() != null);
//		// TODO rellenar con mas pruebas
//	}

}
