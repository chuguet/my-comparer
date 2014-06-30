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
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import com.comparador.bet.comparer.test.core.mainTest.decorators.AbstractGeneralDecorator;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;

/**
 * The Class BetClickCompleteTest.
 */
public final class GeneralCompleteTest extends AbstractGeneralDecorator {
	
	/** The participants competition separator. */
	@Value("${general.numeroMatchs}")
	private String numeroMatchs;
	
	/** The participants competition separator. */
	@Value("${general.numeroMatchsBD}")
	private String numeroMatchsBD;

	/** The participants competition separator. */
	@Value("${general.numeroMarketsMatch}")
	private String numeroMarketsMatch;

	/** The nombre match1. */
	@Value("${general.nombreMatch1}")
	private String nombreMatch1;

	/** The nombre match2. */
	@Value("${general.nombreMatch2}")
	private String nombreMatch2;
	
	/** The nombre match2 en base de datos. */
	@Value("${general.nombreMatch21}")
	private String nombreMatch21;

	/** The nombre match3. */
	@Value("${general.nombreMatch3}")
	private String nombreMatch3;
	
	/** The nombre match3 en base de datos. */
	@Value("${general.nombreMatch31}")
	private String nombreMatch31;

	/** The nombre match4. */
	@Value("${general.nombreMatch4}")
	private String nombreMatch4;
	
	/** The nombre match4 en base de datos. */
	@Value("${general.nombreMatch41}")
	private String nombreMatch41;

	/** The nombre match5. */
	@Value("${general.nombreMatch5}")
	private String nombreMatch5;
	
	/** The nombre match5 en base de datos. */
	@Value("${general.nombreMatch51}")
	private String nombreMatch51;

	/** The nombre match6. */
	@Value("${general.nombreMatch6}")
	private String nombreMatch6;
	
	/** The nombre match6 en base de datos. */
	@Value("${general.nombreMatch61}")
	private String nombreMatch61;
	
	/** The nombre match7. */
	@Value("${general.nombreMatch7}")
	private String nombreMatch7;

	/** The live id match1. */
	@Value("${general.liveIdMatch1}")
	private String liveIdMatch1;

	/** The live id match2. */
	@Value("${general.liveIdMatch2}")
	private String liveIdMatch2;

	/** The live id match3. */
	@Value("${general.liveIdMatch3}")
	private String liveIdMatch3;

	/** The live id match4. */
	@Value("${general.liveIdMatch4}")
	private String liveIdMatch4;

	/** The live id match5. */
	@Value("${general.liveIdMatch5}")
	private String liveIdMatch5;

	/** The live id match6. */
	@Value("${general.liveIdMatch6}")
	private String liveIdMatch6;
	
	/** The betType 1X2. */
	@Value("${general.tipoApuesta1X2}")
	private String tipoApuesta1X2;
	
	/** The betType 1X2 en base de datos. */
	@Value("${general.tipoApuesta1X2BD}")
	private String tipoApuesta1X2BD;
	
	/** The betType Mas/Menos. */
	@Value("${general.tipoApuestaMasMenos}")
	private String tipoApuestaMasMenos;
	
	/** The betType Mas/Menos en base de datos. */
	@Value("${general.tipoApuestaMasMenosBD}")
	private String tipoApuestaMasMenosBD;
	
	/** The betType Ganador. */
	@Value("${general.tipoApuestaGanador}")
	private String tipoApuestaGanador;
	
	/** The betType Ganador Partido. */
	@Value("${general.tipoApuestaGanadorPartido}")
	private String tipoApuestaGanadorPartido;
	
	/** The betType Ganador Partido en base de datos. */
	@Value("${general.tipoApuestaGanadorPartidoBD}")
	private String tipoApuestaGanadorPartidoBD;
	
	/** The betType Handicap Asiatico. */
	@Value("${general.tipoApuestaHandicap}")
	private String tipoApuestaHandicap;
	
	/** The betType Handicap Asiatico en base de datos. */
	@Value("${general.tipoApuestaHandicapBD}")
	private String tipoApuestaHandicapBD;
	
	/** The betType 1X2 Handicap. */
	@Value("${general.tipoApuesta1X2Handicap}")
	private String tipoApuesta1X2Handicap;
	
	/** The betType 1X2 Handicap en base de datos. */
	@Value("${general.tipoApuesta1X2HandicapBD}")
	private String tipoApuesta1X2HandicapBD;
	
	/** The betType Maximo Goleador. */
	@Value("${general.tipoApuestaMaximoGoleador}")
	private String tipoApuestaMaximoGoleador;
	
	/** The betType Maximo Goleador en base de datos. */
	@Value("${general.tipoApuestaMaximoGoleadorBD}")
	private String tipoApuestaMaximoGoleadorBD;
	
	/** Numero de apuestas 1X2 en BBDD. */
	@Value("${general.numApuestas1X2BD}")
	private String numApuestas1X2BD;
	
	/** Numero de apuestas Mas/Menos en BBDD. */
	@Value("${general.numApuestasMasMenosBD}")
	private String numApuestasMasMenosBD;
	
	/** Numero de apuestas Ganador en BBDD. */
	@Value("${general.numApuestasGanadorBD}")
	private String numApuestasGanadorBD;
	
	/** Numero de apuestas Ganador Partido en BBDD. */
	@Value("${general.numApuestasGanadorPartidoBD}")
	private String numApuestasGanadorPartidoBD;
	
	/** Numero de apuestas Handicap Asiatico en BBDD. */
	@Value("${general.numApuestasHandicapBD}")
	private String numApuestasHandicapBD;
	
	/** Numero de apuestas 1X2 Handicap en BBDD. */
	@Value("${general.numApuestas1X2HandicapBD}")
	private String numApuestas1X2HandicapBD;
	
	/** Numero de apuestas Maximo Goleador en BBDD. */
	@Value("${general.numApuestasMaximoGoleadorBD}")
	private String numApuestasMaximoGoleadorBD;
	
	/** Numero de apuestas 1X2. */
	@Value("${general.numApuestas1X2}")
	private String numApuestas1X2;
	
	/** Numero de apuestas Mas/Menos. */
	@Value("${general.numApuestasMasMenos}")
	private String numApuestasMasMenos;
	
	/** Numero de apuestas Ganador. */
	@Value("${general.numApuestasGanador}")
	private String numApuestasGanador;
	
	/** Numero de apuestas Ganador Partido. */
	@Value("${general.numApuestasGanadorPartido}")
	private String numApuestasGanadorPartido;
	
	/** Numero de apuestas Handicap Asiatico. */
	@Value("${general.numApuestasHandicap}")
	private String numApuestasHandicap;
	
	/** Numero de apuestas 1X2 Handicap. */
	@Value("${general.numApuestas1X2Handicap}")
	private String numApuestas1X2Handicap;
	
	/** Numero de apuestas Maximo Goleador. */
	@Value("${general.numApuestasMaximoGoleador}")
	private String numApuestasMaximoGoleador;
	
	/** Numero de participantes Ganador. */
	@Value("${general.numParticipantsGanador}")
	private String numParticipantsGanador;
	
	/** Numero de participantes General (para todos los que no sean Ganador o Maximo goleador). */
	@Value("${general.numParticipantsGeneral}")
	private String numParticipantsGeneral;
	
	/** Numero de participantes Maximo Goleador. */
	@Value("${general.numParticipantsMaximoGoleador}")
	private String numParticipantsMaximoGoleador;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest
	 * #verificarLecturaXml()
	 */
	@Override
	public void verificarLecturaXml() {
//		assertEquals(getEventosLeidos().size(), Integer.parseInt(numeroMatchs));
//		for (BeanLectura match : getEventosLeidos()) {
//			if (match.getXmlMatch().getName().equals(nombreMatch1)) {
//				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				
//				for(XmlMarket market : match.getXmlMatch().getXmlMarkets()){
//					assertEquals(market.getXmlMarketBets().size(), Integer.parseInt(numApuestasGanador));
//					for(XmlMarketBet bet : market.getXmlMarketBets()){
//						assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), tipoApuestaGanador);
//					}
//				}
//				
//				assertEquals(match.getXmlMatch().getXmlMatchParticipants().size(), Integer.parseInt(numParticipantsGanador));
//			} else if (match.getXmlMatch().getName().equals(nombreMatch2)) {
//				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				
//				for(XmlMarket market : match.getXmlMatch().getXmlMarkets()){
//					assertEquals(market.getXmlMarketBets().size(), Integer.parseInt(numApuestas1X2));
//					for(XmlMarketBet bet : market.getXmlMarketBets()){
//						assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), tipoApuesta1X2);
//					}
//				}
//				
//				assertEquals(match.getXmlMatch().getXmlMatchParticipants().size(), Integer.parseInt(numParticipantsGeneral));
//			} else if (match.getXmlMatch().getName().equals(nombreMatch3)) {
//				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				
//				for(XmlMarket market : match.getXmlMatch().getXmlMarkets()){
//					assertEquals(market.getXmlMarketBets().size(), Integer.parseInt(numApuestasGanadorPartido));
//					for(XmlMarketBet bet : market.getXmlMarketBets()){
//						assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), tipoApuestaGanadorPartido);
//					}
//				}
//				
//				assertEquals(match.getXmlMatch().getXmlMatchParticipants().size(), Integer.parseInt(numParticipantsGeneral));
//			} else if (match.getXmlMatch().getName().equals(nombreMatch4)) {
//				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				
//				for(XmlMarket market : match.getXmlMatch().getXmlMarkets()){
//					assertEquals(market.getXmlMarketBets().size(), Integer.parseInt(numApuestasHandicap));
//					for(XmlMarketBet bet : market.getXmlMarketBets()){
//						assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), tipoApuestaHandicap);
//					}
//				}
//				
//				assertEquals(match.getXmlMatch().getXmlMatchParticipants().size(), Integer.parseInt(numParticipantsGeneral));
//			} else if (match.getXmlMatch().getName().equals(nombreMatch5)) {
//				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//
//				for(XmlMarket market : match.getXmlMatch().getXmlMarkets()){
//					assertEquals(market.getXmlMarketBets().size(), Integer.parseInt(numApuestas1X2Handicap));
//					for(XmlMarketBet bet : market.getXmlMarketBets()){
//						assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), tipoApuesta1X2Handicap);
//					}
//				}
//				
//				assertEquals(match.getXmlMatch().getXmlMatchParticipants().size(), Integer.parseInt(numParticipantsGeneral));
//			} else if (match.getXmlMatch().getName().equals(nombreMatch6)) {
//				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//
//				for(XmlMarket market : match.getXmlMatch().getXmlMarkets()){
//					assertEquals(market.getXmlMarketBets().size(), Integer.parseInt(numApuestasMasMenos));
//					for(XmlMarketBet bet : market.getXmlMarketBets()){
//						assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), tipoApuestaMasMenos);
//					}
//				}
//				
//				assertEquals(match.getXmlMatch().getXmlMatchParticipants().size(), Integer.parseInt(numParticipantsGeneral));
//			} else if (match.getXmlMatch().getName().equals(nombreMatch7)) {
//				assertTrue(match.getXmlMatch().getXmlMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				for(XmlMarket market : match.getXmlMatch().getXmlMarkets()){
//					assertEquals(market.getXmlMarketBets().size(), Integer.parseInt(numApuestasMaximoGoleador));
//					for(XmlMarketBet bet : market.getXmlMarketBets()){
//						assertEquals(bet.getXmlAttribute().getCfgBetTypeId(), tipoApuestaMaximoGoleador);
//					}
//				}
//				
//				assertEquals(match.getXmlMatch().getXmlMatchParticipants().size(), Integer.parseInt(numParticipantsMaximoGoleador));
//			}
//		}
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
//		List<RtMatch> matches = getRtMatchRepository().findAll();
//		assertEquals(matches.size(), Integer.parseInt(numeroMatchsBD));
//		for (RtMatch match : matches) {
//			if (match.getName(null).equals(nombreMatch1)) {
//				assertTrue(match.getRtMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				assertEquals(match.getLiveId(), liveIdMatch1);
//				
//				for(RtMarket market : match.getRtMarkets()){
//					assertEquals(market.getBets().size(), Integer.parseInt(numApuestasGanadorBD));
//					assertEquals(market.getBetType().getName(null), tipoApuestaGanador);
//				}
//			} else if (match.getName(null).equals(nombreMatch21)) {
//				assertTrue(match.getRtMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				assertEquals(match.getLiveId(), liveIdMatch2);
//				
//				for(RtMarket market : match.getRtMarkets()){
//					assertEquals(market.getBets().size(), Integer.parseInt(numApuestas1X2BD));
//					assertEquals(market.getBetType().getName(null), tipoApuesta1X2BD);
//				}
//			} else if (match.getName(null).equals(nombreMatch31)) {
//				assertTrue(match.getRtMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				assertEquals(match.getLiveId(), liveIdMatch3);
//				
//				for(RtMarket market : match.getRtMarkets()){
//					assertEquals(market.getBets().size(), Integer.parseInt(numApuestasGanadorPartidoBD));
//					assertEquals(market.getBetType().getName(null), tipoApuestaGanadorPartidoBD);
//				}
//			} else if (match.getName(null).equals(nombreMatch41)) {
//				assertTrue(match.getRtMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				assertEquals(match.getLiveId(), liveIdMatch4);
//				
//				for(RtMarket market : match.getRtMarkets()){
//					assertEquals(market.getBets().size(), Integer.parseInt(numApuestasHandicapBD));
//					assertEquals(market.getBetType().getName(null), tipoApuestaHandicapBD);
//				}
//			} else if (match.getName(null).equals(nombreMatch51)) {
//				assertTrue(match.getRtMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				assertEquals(match.getLiveId(), liveIdMatch5);
//				
//				for(RtMarket market : match.getRtMarkets()){
//					assertEquals(market.getBets().size(), Integer.parseInt(numApuestas1X2HandicapBD));
//					assertEquals(market.getBetType().getName(null), tipoApuesta1X2HandicapBD);
//				}
//			} else if (match.getName(null).equals(nombreMatch61)) {
//				assertTrue(match.getRtMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				assertEquals(match.getLiveId(), liveIdMatch6);
//				
//				for(RtMarket market : match.getRtMarkets()){
//					assertEquals(market.getBets().size(), Integer.parseInt(numApuestasMasMenosBD));
//					assertEquals(market.getBetType().getName(null), tipoApuestaMasMenosBD);
//				}
//			} else if (match.getName(null).equals(nombreMatch7)) {
//				assertTrue(match.getRtMarkets().size() == Integer
//						.valueOf(numeroMarketsMatch));
//				
//				for(RtMarket market : match.getRtMarkets()){
//					assertEquals(market.getBets().size(), Integer.parseInt(numApuestasMaximoGoleadorBD));
//					assertEquals(market.getBetType().getName(null), tipoApuestaMaximoGoleadorBD);
//				}
//			}
//		}
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
//		ResultValueBet resultValueBet = getResultValueBet();
//		assertTrue(resultValueBet.getValueBetDatas().size() == 0);
//		// TODO rellenar con mas pruebas

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
//		CalculateSecureBetBean sureBet = getCalculateSecureBetBean();
//		assertTrue(sureBet.getSecureBetBeans() != null);
//		// TODO rellenar con mas pruebas
//	}

}
