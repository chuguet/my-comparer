package com.comparador.bet.comparer.test.core.mainTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractBetAtHomeDecoratorPaco;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
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
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;

public class BetAtHomeCompleteTestPaco extends AbstractBetAtHomeDecoratorPaco {

	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(7));
		for (BeanLectura match : getEventosLeidos()) {
			if (match.getXmlMatch().getName().equals("Manchester United VS Aston Villa")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent().getLongTerm().getLongTerm().equals(false));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetatHome.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.35"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.95"));
								assertTrue(bet.getXmlMatchParticipant().getName().equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.25"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetatHome.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet.getXmlAttribute();
							if (atributo.getTotalGoal() == 2.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.7"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.95"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetatHome.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("8.0"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.02"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetatHome.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
							if (atributo.getFirstValue() == -4.5) {
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.85"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.85"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else if (market.getXmlBetType().getBetType().equals(BetTypeBetatHome.UNO_X_DOS_HANDICAP)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2HandicapAttribute atributo = (Xml1X2HandicapAttribute) bet.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -1);
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("4.6"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.5"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.6"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getXmlMatch().getName().equals("Premier League Champion")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent().getLongTerm().getLongTerm().equals(true));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetatHome.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName().equals("Manchester United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.0"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Manchester City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.7"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Chelsea FC")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.0"));
							} else if (bet.getXmlMatchParticipant().getName().equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("500.0"));
							} else if (bet.getXmlMatchParticipant().getName().equals("West Ham United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("500.0"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} else if (match.getXmlMatch().getName().equals("England Premier League top scorer 2013/14")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer.valueOf(1));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent().getLongTerm().getLongTerm().equals(true));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType().equals(BetTypeBetatHome.MAXIMO_GOLEADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName().equals("Robin Van Persie")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.0"));
							} else if (bet.getXmlMatchParticipant().getName().equals("David Silva")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("100.0"));
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
					if (market.getBetType().getNameId().equals(BetTypeBetatHome.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.35"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.95"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.25"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetatHome.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet.getAttribute();
							if (atributo.getTotalGoalValue() == 2.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.7"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.95"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetatHome.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("8.0"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.02"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetatHome.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet.getAttribute();
							if (atributo.getFirstValue() == -4.5) {
								if (atributo.getAsianResult().equals(AsianResult.ONE)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.85"));
								} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.85"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetatHome.UNO_X_DOS_HANDICAP.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2HandicapAttribute atributo = (Rt1X2HandicapAttribute) bet.getAttribute();
							assertTrue(atributo.getFirstValue() == -1);
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("4.6"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.5"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.6"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else if (match.getName(null).equals("Premier League Champion")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetatHome.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.0"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds().equals("2.7"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.0"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds().equals("500.0"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds().equals("500.0"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} else if (match.getName(null).equals("England Premier League top scorer 2013/14")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetatHome.MAXIMO_GOLEADOR.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant().getName(null).equals("Van Persie, Robin")) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.0"));
							} else if (bet.getParticipant().getCfgParticipant().getName(null).equals("Silva, David")) {
								assertTrue(bet.getBetOdd().getOdds().equals("100.0"));
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
