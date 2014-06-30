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

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractTrioDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeNordicbet;
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
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class TrioCompleteTest.
 */
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public final class TrioCompleteTest extends AbstractTrioDecorator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarLecturaXml()
	 */
	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(2));
		for (BeanLectura match : getEventosLeidos()) {
			if (match.getXmlMatch().getName()
					.equals("Manchester United - Aston Villa")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(5));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeNordicbet.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.73"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("4.5"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.55"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeNordicbet.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 4.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.04"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("9.25"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeNordicbet.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.85"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.55"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeNordicbet.UNO_X_DOS_HANDICAP)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2HandicapAttribute atributo = (Xml1X2HandicapAttribute) bet
									.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -1);
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.1"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.65"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.35"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeNordicbet.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -3.5);
							if (atributo.getAsianResult().equals(
									AsianResult.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.3"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Manchester United"));
							} else if (atributo.getAsianResult().equals(
									AsianResult.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.2"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName()
					.equals("England Premier League Season Bets Winner Premier League 2013/2014")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeNordicbet.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.7"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.65"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Chelsea")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.65"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1500.0"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("West Ham United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1000.0"));
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
		assertTrue(getEventosProcesados().size() == Integer.valueOf(2));
		for (RtMatch match : getEventosProcesados()) {
			if (match.getName(null).equals("Manchester United vs Aston Villa")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(5));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeNordicbet.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.73"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("4.5"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.55"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeNordicbet.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 4.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.04"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("9.25"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeNordicbet.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.85"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.55"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market
							.getBetType()
							.getNameId()
							.equals(BetTypeNordicbet.UNO_X_DOS_HANDICAP.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2HandicapAttribute atributo = (Rt1X2HandicapAttribute) bet
									.getAttribute();
							assertTrue(atributo.getFirstValue() == -1);
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.1"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.65"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.35"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeNordicbet.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							assertTrue(atributo.getFirstValue() == -3.5);
							if (atributo.getAsianResult().equals(
									AsianResult.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.3"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getAsianResult().equals(
									AsianResult.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.2"));
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
			} else if (match.getName(null).equals(
					"England Premier League Season Bets Winner Premier League 2013/2014")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeNordicbet.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.7"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.65"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.65"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1500.0"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1000.0"));
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
