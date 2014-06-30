package com.comparador.bet.comparer.test.core.mainTest;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetGun;
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
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.test.bean.beans.BeanBookmaker;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;

public class BetgunCompleteTest extends AbstractTemplateMainTest {

	/** The Constant XML_LOCATION. */
	private static final String BG_XML_LOCATION_SHORT = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betgunPruebas.xml";

	@Override
	protected List<BeanBookmaker> getBookmakersData() {

		List<BeanBookmaker> bookmakersData = new ArrayList<BeanBookmaker>();
		BeanBookmaker beanBookmaker = new BeanBookmaker();
		beanBookmaker.setXmlLocation(BG_XML_LOCATION_SHORT);
		beanBookmaker.setOrdenBookmaker(4);
		beanBookmaker.setIdBookmaker(new BigInteger("27"));
		beanBookmaker.setBookmaker(getBookmaker());
		beanBookmaker
				.setBeanAdditionalXmlInfoReader(new BeanAdditionalXmlInfoReader(
						"", "Eng. Premier League", ""));
		bookmakersData.add(beanBookmaker);

		return bookmakersData;
	}

	private CfgBookmaker getBookmaker() {
		CfgBookmaker bookmaker = new CfgBookmaker(new BigInteger("27"));
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl(
				"http:\\www.betgun.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}

	@Override
	public void verificarLecturaXml() {
		assertTrue(getEventosLeidos().size() == Integer.valueOf(3));
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
					.equals("Manchester United - Aston Villa")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(5));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetGun.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2Attribute atributo = (Xml1X2Attribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.7500"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Manchester United"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2354-02062013,1"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.1500"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2354-02062013,2"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("15.0000"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2354-02062013,0"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetGun.MAS_MENOS)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMoreLessAttribute atributo = (XmlMoreLessAttribute) bet
									.getXmlAttribute();
							if (atributo.getTotalGoal() == 1.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("1.2300"));
									assertTrue(bet
											.getXmlUrl()
											.getUrl()
											.equals("https://www.betgun.com/en/add-bet/2776-01072013,2"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getXmlMarketBetOdd()
											.getOdds().equals("3.8000"));
									assertTrue(bet
											.getXmlUrl()
											.getUrl()
											.equals("https://www.betgun.com/en/add-bet/2776-01072013,1"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetGun.GANADOR_PARTIDO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlMatchWinnerAttribute atributo = (XmlMatchWinnerAttribute) bet
									.getXmlAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.3900"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2772-01072013,1"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.7400"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2772-01072013,2"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetGun.HANDICAP_ASIATICO)) {
						assertTrue(market.getXmlMarketBets().size() == 2);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							XmlAsianHandicapAttribute atributo = (XmlAsianHandicapAttribute) bet
									.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -1.5);
							if (atributo.getAsianResult().equals(
									AsianResult.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.7600"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2802-01072013,1"));
							} else if (atributo.getAsianResult().equals(
									AsianResult.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("1.3800"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2802-01072013,2"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetGun.UNO_X_DOS_HANDICAP)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							Xml1X2HandicapAttribute atributo = (Xml1X2HandicapAttribute) bet
									.getXmlAttribute();
							assertTrue(atributo.getFirstValue() == -1);
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.7600"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Manchester United"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2803-01072013,1"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.7000"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2803-01072013,0"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.0600"));
								assertTrue(bet.getXmlMatchParticipant()
										.getName().equals("Aston Villa"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2803-01072013,2"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} else if (match.getXmlMatch().getName()
					.equals("Eng. Premier League")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetGun.GANADOR)) {
						assertTrue(market.getXmlMarketBets().size() == 5);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester United")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.0000"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6737-27052013,1"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Manchester City")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("4.1500"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6738-27052013,1"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Chelsea FC")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("6.2500"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6739-27052013,1"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("Aston Villa")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("6.5000"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6740-27052013,1"));
							} else if (bet.getXmlMatchParticipant().getName()
									.equals("West Ham")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("6.7500"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6741-27052013,1"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}
				}
			} else if (match.getXmlMatch().getName()
					.equals("West Ham-Chelsea FC")) {
				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
						.valueOf(1));
				for (XmlMarket market : match.getXmlMatch().getXmlMarkets()) {
					if (market.getXmlBetType().getBetType()
							.equals(BetTypeBetGun.UNO_X_DOS)) {
						assertTrue(market.getXmlMarketBets().size() == 3);
						for (XmlMarketBet bet : market.getXmlMarketBets()) {
							if (bet.getXmlMatchParticipant().getName() != null
									&& bet.getXmlMatchParticipant().getName()
											.equals("Chelsea FC")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.4000"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/4468-26092013,2"));
							} else if (bet.getXmlMatchParticipant().getName() != null
									&& bet.getXmlMatchParticipant().getName()
											.equals("West Ham")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("2.0200"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/4468-26092013,1"));
							} else if (bet.getXmlMatchParticipant().getName() != null
									&& bet.getXmlMatchParticipant().getName()
											.equals("")) {
								assertTrue(bet.getXmlMarketBetOdd().getOdds()
										.equals("3.4000"));
								assertTrue(bet
										.getXmlUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/4468-26092013,0"));
							} else {
								fail("Error en la lectura de las bets");
							}
						}
					} else {
						fail("Error en la lectura del market");
					}
				}
			} else {
				fail("El numero de partidos es incorrecto.");
			}
		}
	}

	@Override
	public void verificarXmlGuardadosBD() {
		assertTrue(getEventosProcesados().size() == Integer.valueOf(3));
		for (RtMatch match : getEventosProcesados()) {
			// Prueba especifica para tenis de corto plazo
			if (match.getName(null).equals("Van Uytvanck A. v Morita A.")) {
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeInterTops.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
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
			} else if (match.getName(null).equals("Manchester United vs Aston Villa")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(5));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeBetGun.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2Attribute atributo = (Rt1X2Attribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.7500"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2354-02062013,1"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.1500"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2354-02062013,2"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("15.0000"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2354-02062013,0"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetGun.MAS_MENOS.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtMasMenosAttribute atributo = (RtMasMenosAttribute) bet
									.getAttribute();
							if (atributo.getTotalGoalValue() == 1.5) {
								if (atributo.getMasMenos().equals(MasMenos.MAS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("1.2300"));
									assertTrue(bet
											.getWebUrl()
											.getUrl()
											.equals("https://www.betgun.com/en/add-bet/2776-01072013,2"));
								}
								if (atributo.getMasMenos().equals(
										MasMenos.MENOS)) {
									assertTrue(bet.getBetOdd().getOdds()
											.equals("3.8000"));
									assertTrue(bet
											.getWebUrl()
											.getUrl()
											.equals("https://www.betgun.com/en/add-bet/2776-01072013,1"));
								}
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetGun.GANADOR_PARTIDO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtGanadorPartidoAttribute atributo = (RtGanadorPartidoAttribute) bet
									.getAttribute();
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.3900"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2772-01072013,1"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.7400"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2772-01072013,2"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetGun.HANDICAP_ASIATICO.getId())) {
						assertTrue(market.getBets().size() == 2);
						for (RtBet bet : market.getBets()) {
							RtAsianHandicapAttribute atributo = (RtAsianHandicapAttribute) bet
									.getAttribute();
							assertTrue(atributo.getFirstValue() == -1.5);
							if (atributo.getAsianResult().equals(
									AsianResult.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.7600"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2802-01072013,1"));
							} else if (atributo.getAsianResult().equals(
									AsianResult.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("1.3800"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2802-01072013,2"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else if (market.getBetType().getNameId()
							.equals(BetTypeBetGun.UNO_X_DOS_HANDICAP.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							Rt1X2HandicapAttribute atributo = (Rt1X2HandicapAttribute) bet
									.getAttribute();
							assertTrue(atributo.getFirstValue() == -1);
							if (atributo.getResult().equals(Result.ONE)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.7600"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Manchester United"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2803-01072013,1"));
							} else if (atributo.getResult().equals(Result.DRAW)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.7000"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2803-01072013,0"));
							} else if (atributo.getResult().equals(Result.TWO)) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.0600"));
								assertTrue(bet.getParticipant()
										.getCfgParticipant().getName(null)
										.equals("Aston Villa"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/2803-01072013,2"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					} else {
						fail("Error en la lectura del xml");
					}
				}
			} else if (match.getName(null).equals("Eng. Premier League")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeBetGun.GANADOR.getId())) {
						assertTrue(market.getBets().size() == 5);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester United")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.0000"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6737-27052013,1"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Manchester City")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("4.1500"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6738-27052013,1"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("6.2500"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6739-27052013,1"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("Aston Villa")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("6.5000"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6740-27052013,1"));
							} else if (bet.getParticipant().getCfgParticipant()
									.getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("6.7500"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/6741-27052013,1"));
							} else {
								fail("Error en la lectura del xml");
							}
						}
					}
				}
			} else if (match.getName(null).equals("West Ham vs Chelsea FC")) {
				assertTrue(match.getRtMarkets().size() == Integer.valueOf(1));
				for (RtMarket market : match.getRtMarkets()) {
					if (market.getBetType().getNameId()
							.equals(BetTypeBetGun.UNO_X_DOS.getId())) {
						assertTrue(market.getBets().size() == 3);
						for (RtBet bet : market.getBets()) {
							if (bet.getParticipant().getCfgParticipant() != null
									&& bet.getParticipant().getCfgParticipant()
											.getName(null).equals("West Ham")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("2.0200"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/4468-26092013,1"));
							} else if (bet.getParticipant().getCfgParticipant() == null) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.4000"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/4468-26092013,0"));
							} else if (bet.getParticipant().getCfgParticipant() != null
									&& bet.getParticipant().getCfgParticipant()
											.getName(null).equals("Chelsea FC")) {
								assertTrue(bet.getBetOdd().getOdds()
										.equals("3.4000"));
								assertTrue(bet
										.getWebUrl()
										.getUrl()
										.equals("https://www.betgun.com/en/add-bet/4468-26092013,2"));
							} else {
								fail("Error en la lectura de las bets");
							}
						}
					} else {
						fail("Error en la lectura del market");
					}
				}
			} else {
				fail("Error en la lectura del xml");
			}

		}

	}

	@Override
	public void verificarValueBetGenerada() {
		assertTrue(getResultValueBet().getValueBetDatas().size() == Integer
				.valueOf(0));
	}

//	@Override
//	public void verificarSureBetGenerada() {
//		assertTrue(getCalculateSecureBetBean().getSecureBetBeans().size() == Integer
//				.valueOf(0));
//
//	}

}
