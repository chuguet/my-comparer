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

import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractBetBooDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetBoo;
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
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BetClickCompleteTest.
 */
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public final class BetBooCompleteTest extends AbstractBetBooDecorator {

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
			for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
				if (market.getXmlBetType().getBetType().equals(BetTypeBetBoo.UNO_X_DOS)) {
					assertTrue(market.getXmlMarketBets().size() == 3);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						Xml1X2Attribute atributo = (Xml1X2Attribute) bet.getXmlAttribute();
						if (atributo.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.90"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Manchester United"));
						} else if (atributo.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.90"));
							assertTrue(bet.getXmlMatchParticipant().getName().equals("Aston Villa"));
						} else if (atributo.getResult().equals(Result.DRAW)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.40"));
						} else {
							fail("Error en la lectura del xml");
						}
					}
				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetBoo.MAS_MENOS)) {
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet.getXmlAttribute();
						if (atributo.getTotalGoal() == 2.5) {
							if (atributo.getMasMenos().equals(MasMenos.MAS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.70"));
							}
							if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("2.00"));
							}
						} else {
							fail("Error en la lectura del xml");
						}
					}
				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetBoo.GANADOR_PARTIDO)) {
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet.getXmlAttribute();
						if (atributo.getResult().equals(Result.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.30"));
						} else if (atributo.getResult().equals(Result.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("3.10"));
						} else {
							fail("Error en la lectura del xml");
						}
					}
				} else if (market.getXmlBetType().getBetType().equals(BetTypeBetBoo.HANDICAP_ASIATICO)) {
					assertTrue(market.getXmlMarketBets().size() == 2);
					for (XmlMarketBet bet : market.getXmlMarketBets()) {
						XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet.getXmlAttribute();
						assertTrue(atributo.getFirstValue() == -2);
						if (atributo.getAsianResult().equals(AsianResult.ONE)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.93"));
						} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
							assertTrue(bet.getXmlMarketBetOdd().getOdds().equals("1.88"));
						} else {
							fail("Error en la lectura del xml");
						}
					}
				} else
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
		assertEquals(1, getEventosProcesados().size());
		for (RtMatch match : getEventosProcesados()) {
			if (match.getName(null).equals("Manchester United vs Aston Villa")) {
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId().equals(BetTypeBetBoo.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.90"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Manchester United"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.90"));
								assertTrue(bet.getParticipant().getCfgParticipant().getName(null).equals("Aston Villa"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.40"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetBoo.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet.getAttribute();
							if (atributo.getTotalGoalValue() == 2.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("1.70"));
								}
								if (atributo.getMasMenos().equals(MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds().equals("2.00"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetBoo.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.30"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("3.10"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId().equals(BetTypeBetBoo.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet.getAttribute();
							assertTrue(atributo.getFirstValue() == -2);
							if (atributo.getAsianResult().equals(AsianResult.ONE)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.93"));
							} else if (atributo.getAsianResult().equals(AsianResult.TWO)) {
								assertTrue(bet.getBetOdd().getOdds().equals("1.88"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else
						fail("Error en la lectura del xml");
				}
			} else
				fail("Error en la lectura del xml");
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
		assertTrue(getResultValueBet().getValueBetDatas().size() == Integer.valueOf(0));

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
//		assertTrue(getCalculateSecureBetBean().getSecureBetBeans().size() == Integer.valueOf(0));
//	}

}
