package com.comparador.bet.comparer.test.core.mainTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractIntertopsDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.BetEventUniBet;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetGun;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeInterTops;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeUniBet;
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
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betathome.XMLBetAtHomeReader.BetTypeBetatHome;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.BetTypeEventInterwetten;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;

public class IntertopsCompleteTest extends AbstractIntertopsDecorator {

	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(4));
		for (BeanLectura match : getEventosLeidos()) {
			// Prueba especifica para tenis de corto plazo
			if (match.getXmlMatch().getName()
					.equals("Van Uytvanck A. v Morita A.")) {
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
								.getXmlAttribute();
						if (atributo.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("3"));
							assertTrue(bet.getXmlMatchParticipant().getName()
									.equals("Van Uytvanck A."));
						} else if (atributo.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds()
									.equals("1.3"));
							assertTrue(bet.getXmlMatchParticipant().getName()
									.equals("Morita A."));
						} else {
							fail("Error en la lectura del xml");
						}
					}
				}
			} else if (match.getXmlMatch().getName()
					.equals("Manchester United v Aston Villa")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(4));
				// assertTrue(match.getXmlMatch().getXmlMarkets().size() ==
				// Integer.valueOf(4));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent()
						.getLongTerm().getLongTerm().equals(false));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						if (market.getXmlBetType().getXmlBetEvent()
								.getBetEvent()
								.equals(BetEventInterTops.PRIMERA_PARTE)) {
							for (XmlMarketBet bet : market.getXmlMarketBets()) {
								Xml1X2Attribute atributo = (Xml1X2Attribute) bet
										.getXmlAttribute();
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("5"));
									assertTrue(bet.getXmlMatchParticipant()
											.getName()
											.equals("Manchester United"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.1"));
									assertTrue(bet.getXmlMatchParticipant()
											.getName().equals("Aston Villa"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.2"));
								} else {
									fail("Error en la lectura del xml");
								}
							}

						} else if (market.getXmlBetType().getXmlBetEvent()
								.getBetEvent()
								.equals(BetEventInterTops.PARTIDO_COMPLETO)) {
							for (XmlMarketBet bet : market.getXmlMarketBets()) {
								Xml1X2Attribute atributo = (Xml1X2Attribute) bet
										.getXmlAttribute();
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.35"));
									assertTrue(bet.getXmlMatchParticipant()
											.getName()
											.equals("Manchester United"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("7.5"));
									assertTrue(bet.getXmlMatchParticipant()
											.getName().equals("Aston Villa"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("4.75"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 2.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.44"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.75"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
						// } else if
						// (market.getXmlBetType().getBetType().equals(BetTypeInterTops.GANADOR_PARTIDO))
						// {
						// assertTrue(market.getXmlMarketBets().size() == 2);
						// for (XmlMarketBet bet : market.getXmlMarketBets()) {
						// XmlMatchWinnerAttribute atributo =
						// (XmlMatchWinnerAttribute) bet.getXmlAttribute();
						// if (atributo.getResult().equals(Result.ONE)) {
						// assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.79"));
						// } else if (atributo.getResult().equals(Result.TWO)) {
						// assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.16"));
						// } else {
						// fail("Error en la lectura del xml");
						// }
						// }
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.UNO_X_DOS_HANDICAP)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2HandicapAttribute atributo = (Xml1X2HandicapAttribute) bet
									.getXmlAttribute();
							if (atributo.getFirstValue() == 1) {
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.16"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("2.5"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("3.8"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName()
					.equals("English Premier League 2013/14: To Win Outright")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(1));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent()
						.getLongTerm().getLongTerm().equals(true));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeInterTops.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.05"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.25"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Chelsea FC")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1001"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("West Ham United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1501"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			}
			// else if
			// (match.getXmlMatch().getName().equals("English Premier League 2013/14: Top Goalscorer"))
			// {
			// assertTrue(match.getXmlMatch().getXmlMarkets().size() ==
			// Integer.valueOf(1));
			// assertTrue(match.getXmlMatch().getXmlTournamentEvent().getLongTerm().getLongTerm().equals(true));
			// for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
			// if
			// (market.getXmlBetType().getBetType().equals(BetTypeInterTops.MAXIMO_GOLEADOR))
			// {
			// assertTrue(market.getXmlMarketBets().size() == 2);
			// for (XmlMarketBet bet : market.getXmlMarketBets()) {
			// if
			// (bet.getXmlMatchParticipant().getName().equals("Robin Van Persie"))
			// {
			// assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.05"));
			// } else if
			// (bet.getXmlMatchParticipant().getName().equals("David Silva")) {
			// assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("19"));
			// } else {
			// fail("Error en la lectura del xml");
			// }
			// }
			// } else {
			// fail("Error en la lectura del xml");
			// }
			// }
			// }
		}
	}

	@Override
	public void verificarXmlGuardadosBD() {
		assertTrue(getEventosProcesados().size() == Integer.valueOf(4));
		for (RtMatch match : getEventosProcesados()) {
			// Prueba especifica para tenis de corto plazo
			if (match.getName(null).equals("Van Uytvanck A. v Morita A.")) {
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeInterTops.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Van Uytvanck A."));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.3"));
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
					"Manchester United v Aston Villa")) {

				assertTrue(match.getRtMarkets().size() == Integer.valueOf(5));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeInterTops.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						if (market.getBetTypeEvent().equals(
								BetEventInterTops.PRIMERA_PARTE)) {
							for (RtBet bet : market.getBets()) {
								Rt1X2Attribute atributo = (Rt1X2Attribute) bet
										.getAttribute();
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("5"));
									assertTrue(bet.getParticipant()
											.getCfgParticipant().getName(null)
											.equals("Manchester United"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.1"));
									assertTrue(bet.getParticipant()
											.getCfgParticipant().getName(null)
											.equals("Aston Villa"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.2"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						} else if (market.getBetType().getNameId()
								.equals(BetTypeInterTops.UNO_X_DOS.getId())) {
							assertTrue(market.getBets().size() == 3);
							if (market.getBetTypeEvent().equals(
									BetEventInterTops.PARTIDO_COMPLETO)) {
								for (RtBet bet : market.getBets()) {
									Rt1X2Attribute atributo = (Rt1X2Attribute) bet
											.getAttribute();
									if (atributo.getResult().equals(Result.ONE)) {
										assertTrue(bet.getBetOdd().getOdds()
												.equals("1.35"));
										assertTrue(bet.getParticipant()
												.getCfgParticipant()
												.getName(null)
												.equals("Manchester United"));
									} else if (atributo.getResult().equals(
											Result.TWO)) {
										assertTrue(bet.getBetOdd().getOdds()
												.equals("7.5"));
										assertTrue(bet.getParticipant()
												.getCfgParticipant()
												.getName(null)
												.equals("Aston Villa"));
									} else if (atributo.getResult().equals(
											Result.DRAW)) {
										assertTrue(bet.getBetOdd().getOdds()
												.equals("4.75"));
									} else {
										fail("Error en la lectura del xml");
									}
								}
							}

						} else if (market.getBetType().getNameId()
								.equals(BetTypeInterTops.MAS_MENOS.getId())) {
							assertTrue(market.getBets().size() == 2);
							for (RtBet bet : market.getBets()) {
								RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
										.getAttribute();
								if (atributo.getTotalGoalValue() == 2.5) {
									if (atributo.getMasMenos().equals(
											MasMenos.MAS)) {
										assertTrue(bet.getBetOdd().getOdds()
												.equals("1.44"));
									}
									if (atributo.getMasMenos().equals(
											MasMenos.MENOS)) {
										assertTrue(bet.getBetOdd().getOdds()
												.equals("2.75"));
									}
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}

						else if (market
								.getBetType()
								.getNameId()
								.equals(BetTypeInterTops.UNO_X_DOS_HANDICAP
										.getId())) {
							assertTrue(market.getBets().size() == 3);
							for (RtBet bet : market.getBets()) {
								Rt1X2HandicapAttribute atributo = (Rt1X2HandicapAttribute) bet
										.getAttribute();
								assertTrue(atributo.getFirstValue() == 1);
								if (atributo.getResult().equals(Result.ONE)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.16"));
									assertTrue(bet.getParticipant()
											.getCfgParticipant().getName(null)
											.equals("Manchester United"));
								} else if (atributo.getResult().equals(
										Result.DRAW)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("2.5"));
								} else if (atributo.getResult().equals(
										Result.TWO)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("3.8"));
									assertTrue(bet.getParticipant()
											.getCfgParticipant().getName(null)
											.equals("Aston Villa"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						} else {
							fail("Error en la lectura del xml");
						}
					}
				}

			} else if (match.getName(null).equals(
					"English Premier League 2013/14: To Win Outright")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeBetGun.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.05"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.25"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1001"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1501"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}
				}
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
