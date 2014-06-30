package com.comparador.bet.comparer.test.core.mainTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractBetRedKingsDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventBetRedKings;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetRedKings;
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
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betathome.XMLBetAtHomeReader.BetTypeBetatHome;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;

public class BetRedKingsCompleteTest extends AbstractBetRedKingsDecorator {

	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(3));
		for (BeanLectura match : getEventosLeidos()) {
			if (match.getXmlMatch().getName()
					.equals("Manchester United FC-Aston Villa")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(5));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent()
						.getLongTerm().getLongTerm().equals(false));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.75"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName()
										.equals("Manchester United FC"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.90"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 4);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 0.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("0.99"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("22.00"));
								}
							} else if (atributo.getTotalGoal() == 1.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.04"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("7.40"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("0.99"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1001.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							if (atributo.getFirstValue() == -2) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.65"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.06"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.UNO_X_DOS_HANDICAP)) {
						assertTrue(market.getXmlMarketBets().size() == 9);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2HandicapAttribute atributo = (Xml1X2HandicapAttribute) bet
									.getXmlAttribute();
							if (atributo.getFirstValue() == -2) {
								if (atributo.getResult().equals(
										Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("25.00"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("10.00"));
								}else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.04"));
								}  else {
									fail("Error en la lectura del xml");
								}
							}else if (atributo.getFirstValue() == -1) {
								if (atributo.getResult().equals(
										Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("8.20"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("5.20"));
								}else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.44"));
								}  else {
									fail("Error en la lectura del xml");
								}
							}else if (atributo.getFirstValue() == 1) {
								if (atributo.getResult().equals(
										Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.17"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("3.40"));
								}else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("18.00"));
								}  else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName()
					.equals("Premier League 2013/2014")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(1));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent()
						.getLongTerm().getLongTerm().equals(true));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester United FC")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.50"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.25"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Chelsea")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.25"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1000.00"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("West Ham United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1000.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} else if (match.getXmlMatch().getName()
					.equals("Atlanta Hawks-Boston Celtics")) {
				assertEquals(10, match.getXmlMatch().getXmlMarkets().size());
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.GANADOR_PARTIDO)
							&& market
									.getXmlBetType()
									.getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PARTIDO_COMPLETO_PRORROGA)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.41"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.72"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.HANDICAP_ASIATICO)
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PRIMER_CUARTO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							if (atributo.getFirstValue() == -1.5) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.86"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.86"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Asian Handicap es incorrecto");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.HANDICAP_ASIATICO)
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PRIMERA_PARTE)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							if (atributo.getFirstValue() == -3.0) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.86"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.86"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Asian Handicap es incorrecto");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.HANDICAP_ASIATICO)
							&& market.getXmlBetType().getXmlBetEvent().getBetEvent().equals(BetEventBetRedKings.PARTIDO_COMPLETO_PRORROGA)) {
						assertTrue(market.getXmlMarketBets().size() == 10);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							if (atributo.getFirstValue() == -4.0) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.70"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.04"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (atributo.getFirstValue() == -4.5) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.78"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.94"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (atributo.getFirstValue() == -5.0) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.86"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.86"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (atributo.getFirstValue() == -5.5) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.92"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.79"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (atributo.getFirstValue() == -6.0) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.04"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.70"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Asian Handicap es incorrecto");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.MAS_MENOS)
							&& market
									.getXmlBetType()
									.getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PARTIDO_COMPLETO_PRORROGA)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 144.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.84"));
								} else if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.85"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.MAS_MENOS)
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PRIMERA_PARTE)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 72.0) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.84"));
								} else if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.84"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.MAS_MENOS)
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PRIMER_CUARTO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 36.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.86"));
								} else if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.83"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.UNO_X_DOS)
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PRIMERA_PARTE)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.59"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Atlanta Hawks"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.38"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Boston Celtics"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("14.50"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.UNO_X_DOS)
							&& market.getXmlBetType().getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PRIMER_CUARTO)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.70"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Atlanta Hawks"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.28"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Boston Celtics"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("11.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetRedKings.UNO_X_DOS)
							&& market
									.getXmlBetType()
									.getXmlBetEvent()
									.getBetEvent()
									.equals(BetEventBetRedKings.PARTIDO_COMPLETO)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.44"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Atlanta Hawks"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.82"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Boston Celtics"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("15.50"));
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

	@Override
	public void verificarXmlGuardadosBD() {
		assertTrue(getEventosProcesados().size() == Integer.valueOf(3));
		for (RtMatch match : getEventosProcesados()) {
			if (match.getName(null).equals("Manchester United vs Aston Villa")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(5));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeBetRedKings.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.75"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.90"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetRedKings.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 4);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 0.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("0.99"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("22.00"));
								}
							} else if (atributo.getTotalGoalValue() == 1.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.04"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("7.40"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetRedKings.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("0.99"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1001.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetatHome.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							if (atributo.getFirstValue() == -2) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.65"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.06"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(CfgBetType.CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())) {
						assertTrue(market.getBets().size() == 9);
						for (RtBet bet : market.getBets()) {
							Rt1X2HandicapAttribute atributo = (Rt1X2HandicapAttribute) bet
									.getAttribute();
							if (atributo.getFirstValue() == -2) {
								if (atributo.getResult().equals(
										Result.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("25.00"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("10.00"));
								}else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.04"));
								}  else {
									fail("Error en la lectura del xml");
								}
							}else if (atributo.getFirstValue() == -1) {
								if (atributo.getResult().equals(
										Result.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("8.20"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("5.20"));
								}else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.44"));
								}  else {
									fail("Error en la lectura del xml");
								}
							}else if (atributo.getFirstValue() == 1) {
								if (atributo.getResult().equals(
										Result.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.17"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("3.40"));
								}else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("18.00"));
								}  else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getName(null).equals("Premier League 2013/2014")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeBetRedKings.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.50"));
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
										.equals("1000.00"));
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
			} else if (match.getName(null)
					.equals("Atlanta Hawks vs Boston Celtics")) {
				assertEquals(10, match.getRtMarkets().size());
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.GANADOR_PARTIDO.nameId())
							&& market
									.getBetTypeEvent().getBetTypeEvent().getNameId()
									.equals(CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.41"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.72"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PRIMER_CUARTO.nameId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							if (atributo.getFirstValue() == -1.5) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.86"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.86"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Asian Handicap es incorrecto");
							}
						}
					} else if(market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PRIMERA_PARTE.nameId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							if (atributo.getFirstValue() == -3.0) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.86"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.86"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Asian Handicap es incorrecto");
							}
						}
					} else if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId())) {
						assertTrue(market.getBets().size() == 10);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							if (atributo.getFirstValue() == -4.0) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.70"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("2.04"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (atributo.getFirstValue() == -4.5) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.78"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.94"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (atributo.getFirstValue() == -5.0) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.86"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.86"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (atributo.getFirstValue() == -5.5) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.92"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.79"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else if (atributo.getFirstValue() == -6.0) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("2.04"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.70"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Asian Handicap es incorrecto");
							}
						}
					} else if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.MAS_MENOS.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.nameId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 144.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.84"));
								} else if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.85"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.MAS_MENOS.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PRIMERA_PARTE.nameId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 72.0) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.84"));
								} else if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.84"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.MAS_MENOS.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PRIMER_CUARTO.nameId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 36.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.86"));
								} else if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd()
											.getOdds().equals("1.83"));
								} else {
									fail("Error en la lectura del xml");
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.UNO_X_DOS.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PRIMERA_PARTE.nameId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.59"));
								assertTrue(bet.getParticipant().getCfgParticipant()
										.getName(null).equals("Atlanta Hawks"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.38"));
								assertTrue(bet.getParticipant().getCfgParticipant()
										.getName(null).equals("Boston Celtics"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("14.50"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.UNO_X_DOS.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PRIMER_CUARTO.nameId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.70"));
								assertTrue(bet.getParticipant().getCfgParticipant()
										.getName(null).equals("Atlanta Hawks"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.28"));
								assertTrue(bet.getParticipant().getCfgParticipant()
										.getName(null).equals("Boston Celtics"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("11.00"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(CfgBetType.CfgBetTypeId.UNO_X_DOS.nameId())
							&& market
							.getBetTypeEvent().getBetTypeEvent().getNameId()
							.equals(CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO.nameId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.44"));
								assertTrue(bet.getParticipant().getCfgParticipant()
										.getName(null).equals("Atlanta Hawks"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.82"));
								assertTrue(bet.getParticipant().getCfgParticipant()
										.getName(null).equals("Boston Celtics"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("15.50"));
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

	@Override
	public void verificarValueBetGenerada() {
		ResultValueBet resultValueBet = getResultValueBet();
		assertTrue(resultValueBet.getValueBetDatas().size() == 0);

	}

//	@Override
//	public void verificarSureBetGenerada() {
//		// TODO Auto-generated method stub
//		SureBetsMatch sureBet = getCalculateSecureBetBean();
//		assertTrue(sureBet.getSecureBetBeans() != null);
//	}

}
