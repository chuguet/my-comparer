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

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractBetclickDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetClick;
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
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BetClickCompleteTest.
 */
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public final class BetClickCompleteTest extends AbstractBetclickDecorator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarLecturaXml()
	 */
	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(3));
		for (BeanLectura match : getEventosLeidos()) {
			if(match.getXmlMatch().getName().equals("DET Tigers (A. Sanchez) - WAS Nationals (S. Strasburg)")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(4));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName().equals("DET Tigers")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.68"));
							} else if (bet.getXmlMatchParticipant().getName().equals("WAS Nationals")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.05"));
							} else {
								fail("Error en la lectura del xml");
							}
						}						
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -2.5);
							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.90"));
							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.80"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.72"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("DET Tigers"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.15"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("WAS Nationals"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("14.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}						
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (atributo.getTotalGoal() == 151.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.85"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.85"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} else 	if (match.getXmlMatch().getName().equals("Manchester United - Aston Villa")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(3));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.22"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("10.00"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("6.50"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 4);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (atributo.getTotalGoal() == 1.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.12"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("5.25"));
								}
							} else if (atributo.getTotalGoal() == 2.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.52"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.35"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.12"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("5.25"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -4.5);
							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.85"));
							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.88"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}

					else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName().equals("Eng. Premier League 2013-2014")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetClick.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName().equals("Manchester United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.00"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Manchester City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.25"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Chelsea")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.25"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("500.00"));
							} else if (bet.getXmlMatchParticipant().getName().equals("West Ham")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("500.00"));
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
		assertTrue(getEventosProcesados().size() == Integer.valueOf(3));
		for (RtMatch match : getEventosProcesados()) {
			if (match.getName(null).equals("Manchester United vs Aston Villa")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(3));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetClick.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.22"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("10.00"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds().equals("6.50"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetClick.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 4);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet.getAttribute();
							if (atributo.getTotalGoalValue() == 1.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.12"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("5.25"));
								}
							} else if (atributo.getTotalGoalValue() == 2.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.52"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("2.35"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetClick.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet.getAttribute();
							if(atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.12"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("5.25"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetClick.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet.getAttribute();
							assertTrue(atributo.getFirstValue() == -4.5);
							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.85"));
							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.88"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}

					else
						fail("Error en la lectura del xml");
				}
			} else if (match.getName(null).equals("DET Tigers vs WAS Nationals")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(4));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetClick.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet.getAttribute();
							if (atributo.getFirstValue() == -2.5) {
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.90"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.80"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}

					} else if (market.getBetType().getNameId().equals(BetTypeBetClick.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet.getAttribute();
							if (atributo.getTotalGoalValue() == 151.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.85"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.85"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetClick.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet.getAttribute();							
							if(atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.68"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.05"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetClick.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.72"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("DET Tigers"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.15"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("WAS Nationals"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds().equals("14.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
						
					} 
					else {
						fail("Error en la lectura del xml");
					}
				}
			} else if (match.getName(null).equals("Eng. Premier League 2013-2014")) {
				assertTrue(match.getRtMarkets().size()  == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetClick.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.00"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.25"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.25"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds().equals("500.00"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds().equals("500.00"));
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
