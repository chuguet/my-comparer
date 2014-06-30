package com.comparador.bet.comparer.test.core.mainTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractBetOnlineDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
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
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.betonline.BetTypeBetOnline;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;

public class BetOnlineCompleteTest extends AbstractBetOnlineDecorator {

	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(2));
		for (BeanLectura match : getEventosLeidos()) {
			if (match.getXmlMatch().getName()
					.equals("England - Barclays Premier League")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(1)
						|| match.getXmlMatch().getXmlMarkets().size() == Integer
								.valueOf(3));
				assertTrue(match.getXmlMatch().getXmlTournamentEvent()
						.getLongTerm().getLongTerm().equals(false));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetOnline.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.38"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("6.40"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("4.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetOnline.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 3) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.98"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.85"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetOnline.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.38"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetOnline.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							if (atributo.getFirstValue() == -1.25) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.87"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.95"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else {
				fail("Error en la lectura del xml");
			}
		}
	}

	@Override
	public void verificarXmlGuardadosBD() {
		assertTrue(getEventosProcesados().size() == Integer.valueOf(1));
		for (RtMatch match : getEventosProcesados()) {
			if (match.getName(null).equals("Manchester United vs Aston Villa")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(4));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeBetOnline.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.38"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("6.40"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("4.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetOnline.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 3) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.98"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.85"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetOnline.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.38"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetOnline.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							if (atributo.getFirstValue() == -1.25) {
								if (atributo.getAsianResult().equals(
										AsianResult.ONE)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.87"));
								} else if (atributo.getAsianResult().equals(
										AsianResult.TWO)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.95"));
								} else {
									fail("Error en la lectura del xml");
								}
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else {
				fail("Error en la lectura del xml");
			}
		}

	}

	@Override
	public void verificarValueBetGenerada() {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void verificarSureBetGenerada() {
//		// TODO Auto-generated method stub
//
//	}

}
