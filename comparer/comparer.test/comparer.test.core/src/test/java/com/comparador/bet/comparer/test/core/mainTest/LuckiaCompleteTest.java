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

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractLuckiaDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventLuckia;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeLuckia;
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
 * The Class BetClickCompleteTest.
 */
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public final class LuckiaCompleteTest extends AbstractLuckiaDecorator {

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
			if (match.getXmlMatch().getName().equals("Chelsea - West Ham")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(12));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeLuckia.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet.getXmlAttribute();
							if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.PARTIDO_COMPLETO)) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.33"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("9.0"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("5.25"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.PRIMERA_PARTE)) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.75"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("7.5"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.55"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.SEGUNDA_PARTE)) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.53"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("7.0"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.1"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeLuckia.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.PARTIDO_COMPLETO)) {
								if (atributo.getTotalGoal() == 5.5) {
									if (atributo.getMasMenos().equals(MasMenos.MAS)) {
										assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("9.5"));
									}
									if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
										assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.06"));
									}
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.PRIMERA_PARTE)) {
								if (atributo.getTotalGoal() == 2.5) {
									if (atributo.getMasMenos().equals(MasMenos.MAS)) {
										assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("5.75"));
									}
									if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
										assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.11"));
									}
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.SEGUNDA_PARTE)) {
								if (atributo.getTotalGoal() == 2.5) {
									if (atributo.getMasMenos().equals(MasMenos.MAS)) {
										assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.8"));
									}
									if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
										assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.22"));
									}
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeLuckia.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
							if (market.getXmlBetType().getXmlBetEvent().getBetEvent().getId()
									.equals(BetEventLuckia.PARTIDO_COMPLETO.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.09"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("7.5"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().getId()
									.equals(BetEventLuckia.PRIMERA_PARTE.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.12"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("4.8"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().getId()
									.equals(BetEventLuckia.SEGUNDA_PARTE.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.09"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("5.0"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeLuckia.UNO_X_DOS_HANDICAP)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2HandicapAttribute atributo = (Xml1X2HandicapAttribute) bet.getXmlAttribute();
							if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.PARTIDO_COMPLETO)) {
								assertTrue(atributo.getFirstValue() == -1.0);
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.9"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.35"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.6"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.PRIMERA_PARTE)) {
								assertTrue(atributo.getFirstValue() == -1.0);
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("4.2"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.9"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.9"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventLuckia.SEGUNDA_PARTE)) {
								assertTrue(atributo.getFirstValue() == -1.0);
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.15"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Chelsea"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.25"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.0"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}

					else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName().equals("Milwaukee Bucks - Detroit Pistons")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(3));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeLuckia.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							if (market.getXmlBetType().getXmlBetEvent().getBetEvent().getId()
									.equals(BetEventLuckia.PARTIDO_COMPLETO_PRORROGA.getId())) {
								assertTrue(atributo.getFirstValue() == -9.5);
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.73"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Milwaukee Bucks"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.12"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Detroit Pistons"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().getId()
									.equals(BetEventLuckia.PRIMERA_PARTE.getId())) {
								assertTrue(atributo.getFirstValue() == -5.5);
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.9"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Milwaukee Bucks"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.92"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Detroit Pistons"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getXmlBetType().getXmlBetEvent().getBetEvent().getId()
									.equals(BetEventLuckia.PRIMER_CUARTO.getId())) {
								assertTrue(atributo.getFirstValue() == -2.5);
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.83"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Milwaukee Bucks"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.0"));
									assertTrue(bet.getXmlMatchParticipant().getName().equals("Detroit Pistons"));
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
			} else if (match.getXmlMatch().getName().equals("Premier League 2013/2014 Ganador")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeLuckia.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName().equals("Manchester United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.0"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Manchester City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.2"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Chelsea")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("4.75"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}
				}
			} else if (match.getXmlMatch().getName().equals("Premier League 2013/2014 Marcar ms goles en el torneo/la liga")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeLuckia.MAXIMO_GOLEADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName().equals("Van Persie, R")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.5"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Silva, David")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.1"));
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
	@Override
	public void verificarXmlGuardadosBD() {
		assertTrue(getEventosProcesados().size() == Integer.valueOf(4));
		for (RtMatch match : getEventosProcesados()) {
			if (match.getName(null).equals("Chelsea FC vs West Ham")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(12));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeLuckia.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet.getAttribute();
							if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PARTIDO_COMPLETO.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.33"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("9.0"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getBetOdd().getOdds().equals("5.25"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PRIMERA_PARTE.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.75"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("7.5"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getBetOdd().getOdds().equals("2.55"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.SEGUNDA_PARTE.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.53"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("7.0"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getBetOdd().getOdds().equals("3.1"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeLuckia.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet.getAttribute();
							if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PARTIDO_COMPLETO.getId())) {
								if (atributo.getTotalGoalValue() == 5.5) {
									if (atributo.getMasMenos().equals(MasMenos.MAS)) {
										assertTrue(bet.getBetOdd().getOdds().equals("9.5"));
									}
									if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
										assertTrue(bet.getBetOdd().getOdds().equals("1.06"));
									}
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PRIMERA_PARTE.getId())) {
								if (atributo.getTotalGoalValue() == 2.5) {
									if (atributo.getMasMenos().equals(MasMenos.MAS)) {
										assertTrue(bet.getBetOdd().getOdds().equals("5.75"));
									}
									if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
										assertTrue(bet.getBetOdd().getOdds().equals("1.11"));
									}
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.SEGUNDA_PARTE.getId())) {
								if (atributo.getTotalGoalValue() == 2.5) {
									if (atributo.getMasMenos().equals(MasMenos.MAS)) {
										assertTrue(bet.getBetOdd().getOdds().equals("3.8"));
									}
									if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
										assertTrue(bet.getBetOdd().getOdds().equals("1.22"));
									}
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeLuckia.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet.getAttribute();
							if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PARTIDO_COMPLETO.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.09"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("7.5"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PRIMERA_PARTE.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.12"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("4.8"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.SEGUNDA_PARTE.getId())) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.09"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("5.0"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeLuckia.UNO_X_DOS_HANDICAP.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2HandicapAttribute atributo = (Rt1X2HandicapAttribute) bet.getAttribute();
							if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PARTIDO_COMPLETO.getId())) {
								assertTrue(atributo.getFirstValue() == -1);
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.9"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("3.35"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getBetOdd().getOdds().equals("3.6"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PRIMERA_PARTE.getId())) {
								assertTrue(atributo.getFirstValue() == -1);
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("4.2"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.9"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getBetOdd().getOdds().equals("2.9"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.SEGUNDA_PARTE.getId())) {
								assertTrue(atributo.getFirstValue() == -1);
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("3.15"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC"));
								} else if (atributo.getResult().equals(Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("2.25"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham"));
								} else if (atributo.getResult().equals(Result.DRAW)) {
									assertTrue(bet.getBetOdd().getOdds().equals("3.0"));
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
			} else if (match.getName(null).equals("Milwaukee Bucks vs Detroit Pistons")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(3));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeLuckia.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet.getAttribute();
							if (market.getBetTypeEvent().getBetTypeEvent().getNameId()
									.equals(BetEventLuckia.PARTIDO_COMPLETO_PRORROGA.getId())) {
								assertTrue(atributo.getFirstValue() == -9.5);
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.73"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Milwaukee Bucks"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("2.12"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Detroit Pistons"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PRIMERA_PARTE.getId())) {
								assertTrue(atributo.getFirstValue() == -5.5);
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.9"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Milwaukee Bucks"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.92"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Detroit Pistons"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (market.getBetTypeEvent().getBetTypeEvent().getNameId().equals(BetEventLuckia.PRIMER_CUARTO.getId())) {
								assertTrue(atributo.getFirstValue() == -2.5);
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.83"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Milwaukee Bucks"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("2.0"));
									assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Detroit Pistons"));
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
			} else if (match.getName(null).equals("Premier League 2013/2014 Ganador")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeLuckia.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.0"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.2"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds().equals("4.75"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} else if (match.getName(null).equals("Premier League 2013/2014 Marcar ms goles en el torneo/la liga")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeLuckia.MAXIMO_GOLEADOR.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant().getName(null).equals("Van Persie, Robin")) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.5"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Silva, David")) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.1"));
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
