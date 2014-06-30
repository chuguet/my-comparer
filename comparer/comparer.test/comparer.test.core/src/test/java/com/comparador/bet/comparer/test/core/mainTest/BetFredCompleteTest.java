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

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractBetFredDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetFred;
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

/**
 * The Class BetClickCompleteTest.
 */
public final class BetFredCompleteTest extends AbstractBetFredDecorator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarLecturaXml()
	 */
	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(4));
		for (BeanLectura match : getEventosLeidos()) {
			if (match.getXmlMatch().getName().equals("Man Utd v Aston Villa")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(2));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent().getLongTerm().getLongTerm().equals(false));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.50"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Man Utd"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.38"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (atributo.getTotalGoal() == 7.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.91"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.91"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.10"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.73"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							if (atributo.getFirstValue() == 5.5) {
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.83"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.83"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName().equals("Premier League 2013-14 Outright")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent().getLongTerm().getLongTerm().equals(true));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName().equals("Man Utd")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.00"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Man City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.00"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Chelsea")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("7.00"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("34.00"));
							} else if (bet.getXmlMatchParticipant().getName().equals("West Ham")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("41.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else{
						fail("Error en la lectura del xml");
					}
				}
			}else if (match.getXmlMatch().getName().equals("Premier League 2013-14 Top Goalscorer")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetFred.MAXIMO_GOLEADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName().equals("Silva, David")) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("1.44"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Van Persie, Robin")) {
								assertTrue(bet.getXmlBetOdd().getOdds().equals("2.75"));
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
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(4));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetFred.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.50"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.38"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetFred.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet.getAttribute();
							if (atributo.getTotalGoalValue() == 7.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.91"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.91"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetFred.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.10"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.73"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetFred.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet.getAttribute();
							if (atributo.getFirstValue() == 5.5) {
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.83"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.83"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getName(null).equals("Premier League 2013-14 Outright")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetFred.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.00"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.00"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds().equals("7.00"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds().equals("34.00"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds().equals("41.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				} 
			} else if (match.getName(null).equals("Premier League 2013-14 Top Goalscorer")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetFred.MAXIMO_GOLEADOR.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant().getName(null).equals("Silva, David")) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.44"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Van Persie, Robin")) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.75"));
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
