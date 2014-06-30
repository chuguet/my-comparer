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

import org.springframework.test.context.ActiveProfiles;

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractInterwettenDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.BetTypeInterwetten;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class InterwettenCompleteTest.
 */
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public final class InterwettenCompleteTest extends AbstractInterwettenDecorator {

	@Override
	public void verificarLecturaXml() {
		assertEquals(2, getEventosLeidos().size());
		for (BeanLectura match : getEventosLeidos()) {
//			// Prueba especifica para tenis de corto plazo
//			if (match.getXmlMatch().getName()
//					.equals("Van Uytvanck A. vs Morita A.")) {
//				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
//					for (XmlMarketBet bet : market.getXmlMarketBets()) {
//						XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
//								.getXmlAttribute();
//						if (atributo.getResult().equals(Result.ONE)) {
//							assertTrue(bet.getXmlMarketBetOdd().getOdds()
//									.equals("3.00"));
//							assertTrue(bet.getXmlMatchParticipant().getName()
//									.equals("Van Uytvanck A."));
//						} else if (atributo.getResult().equals(Result.TWO)) {
//							assertTrue(bet.getXmlMarketBetOdd().getOdds()
//									.equals("1.30"));
//							assertTrue(bet.getXmlMatchParticipant().getName()
//									.equals("Morita A."));
//						} else {
//							fail("Error en la lectura del xml");
//						}
//					}
//				}
//			}	
			if (match.getXmlMatch().getName().equals("Manchester United vs Aston Villa")) {
				assertEquals(5, match.getXmlMatch().getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterwetten.UNO_X_DOS)) {
						assertEquals(3, market.getXmlMarketBets().size());
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertEquals("1.37", bet.getXmlMarketBetOdd()
										.getOdds());
								assertEquals("Manchester United", bet
										.getXmlMatchParticipant().getName());
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertEquals("7.50", bet.getXmlMarketBetOdd()
										.getOdds());
								assertEquals("Aston Villa", bet
										.getXmlMatchParticipant().getName());
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertEquals("4.60", bet.getXmlMarketBetOdd()
										.getOdds());
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterwetten.MAS_MENOS)) {
						assertEquals(2, market.getXmlMarketBets().size());
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 2.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertEquals("1.55", bet
											.getXmlMarketBetOdd().getOdds());
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertEquals("2.20", bet
											.getXmlMarketBetOdd().getOdds());
								}
							} else if (atributo.getTotalGoal() == 43.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertEquals("1.55", bet
											.getXmlMarketBetOdd().getOdds());
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertEquals("2.20", bet
											.getXmlMarketBetOdd().getOdds());
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterwetten.UNO_X_DOS_HANDICAP)) {
						assertEquals(3, market.getXmlMarketBets().size());
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2HandicapAttribute atributo = (Xml1X2HandicapAttribute) bet
									.getXmlAttribute();
							assertEquals(Double.valueOf("-1.0"), atributo.getFirstValue());
							if (atributo.getResult().equals(Result.ONE)) {
								assertEquals("2.10", bet.getXmlMarketBetOdd()
										.getOdds());
								assertEquals("Manchester United", bet
										.getXmlMatchParticipant().getName());
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertEquals("2.75", bet.getXmlMarketBetOdd()
										.getOdds());
								assertEquals("Aston Villa", bet
										.getXmlMatchParticipant().getName());
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertEquals("3.60", bet.getXmlMarketBetOdd()
										.getOdds());
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterwetten.HANDICAP_ASIATICO)) {
						assertEquals(2, market.getXmlMarketBets().size());
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							assertEquals(Double.valueOf("-8.5"), atributo.getFirstValue());
							if (atributo.getAsianResult().equals(
									AsianResult.ONE)) {
								assertEquals("1.85", bet.getXmlMarketBetOdd()
										.getOdds());
								assertEquals("Manchester United", bet
										.getXmlMatchParticipant().getName());
							} else if (atributo.getAsianResult().equals(
									AsianResult.TWO)) {
								assertEquals("1.85", bet.getXmlMarketBetOdd()
										.getOdds());
								assertEquals("Aston Villa", bet
										.getXmlMatchParticipant().getName());
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName()
					.equals("Champions 2013/14")) {
				assertEquals(1, match.getXmlMatch().getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterwetten.GANADOR)) {
						assertEquals(5, market.getXmlMarketBets().size());
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester United")) {
								assertEquals("2.95", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester City")) {
								assertEquals("2.95", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Chelsea")) {
								assertEquals("3.00", bet.getXmlMarketBetOdd()
										.getOdds());
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Aston Villa")) {
								assertEquals("1500.00", bet
										.getXmlMarketBetOdd().getOdds());
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("West Ham")) {
								assertEquals("1000.00", bet
										.getXmlMarketBetOdd().getOdds());
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			}
			else {
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
		assertTrue(getEventosProcesados().size() == Integer.valueOf(2));
		for (RtMatch match : getEventosProcesados()) {
//			// Prueba especifica para tenis de corto plazo
//			if (match.getName(null).equals("Van Uytvanck A. vs Morita A.")) {
//				for (RtMarket market : match.getRtMarkets()) {
//					if (market.getBetType().getNameId()
//							.equals(BetTypeInterTops.GANADOR_PARTIDO.getId())) {
//						assertTrue(market.getBets().size() == 2);
//						for (RtBet bet : market.getBets()) {
//							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
//									.getAttribute();
//							if (atributo.getResult().equals(Result.ONE)) {
//								assertTrue(bet.getBetOdd().getOdds()
//										.equals("3.00"));
//								assertTrue(bet.getParticipant()
//										.getCfgParticipant().getName(null)
//										.equals("Van Uytvanck A."));
//							} else if (atributo.getResult().equals(Result.TWO)) {
//								assertTrue(bet.getBetOdd().getOdds()
//										.equals("1.30"));
//								assertTrue(bet.getParticipant()
//										.getCfgParticipant().getName(null)
//										.equals("Morita A."));
//							} else {
//								fail("Error en la lectura del xml");
//							}
//						}
//
//					}
//				}
//			}
			if (match.getName(null).equals("Manchester United vs Aston Villa")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(4));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeInterwetten.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.37"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("7.50"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("4.60"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeInterwetten.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 4);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 2.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.55"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.20"));
								}
							} else if (atributo.getTotalGoalValue() == 43.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.55"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.20"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market
							.getBetType()
							.getNameId()
							.equals(BetTypeInterwetten.UNO_X_DOS_HANDICAP
									.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2HandicapAttribute atributo = (Rt1X2HandicapAttribute) bet
									.getAttribute();
							assertTrue(atributo.getFirstValue() == -1);
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.10"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.75"));
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
					} else if (market
							.getBetType()
							.getNameId()
							.equals(BetTypeInterwetten.HANDICAP_ASIATICO
									.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							assertTrue(atributo.getFirstValue() == -8.5);
							if (atributo.getAsianResult().equals(
									AsianResult.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.85"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getAsianResult().equals(
									AsianResult.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.85"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}

					else
						fail("Error en la lectura del xml");
				}
			} else if (match.getName(null).equals("Champions 2013/14")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeInterwetten.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.95"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.95"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.00"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1500.00"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1000.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} 
			else {
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
