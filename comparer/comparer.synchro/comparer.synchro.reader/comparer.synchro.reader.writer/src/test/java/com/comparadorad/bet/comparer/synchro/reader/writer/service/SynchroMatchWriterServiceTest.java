/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.data.repository.CrudRepository;

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
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.model.repository.CfgRegionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportRepository;
import com.comparadorad.bet.comparer.synchro.reader.writer.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.writer.config.SynchroReaderWriterConfig;

/**
 * The Class SynchroMatchWriterServiceTest.
 */
public class SynchroMatchWriterServiceTest extends AbstractTest {

	/** The Constant PREFIX. */
	private static final String PREFIX = "-SynchroMatchWriterServiceTest";

	/** The bet type event repository. */
	@Inject
	protected CfgBetTypeEventRepository betTypeEventRepository;

	/** The bet type repository. */
	@Inject
	protected CfgBetTypeRepository betTypeRepository;

	/** The bookmaker repository. */
	@Inject
	protected CfgBookmakerRepository bookmakerRepository;

	/** The competition event repository. */
	@Inject
	protected CfgCompetitionEventRepository competitionEventRepository;

	/** The competition repository. */
	@Inject
	protected CfgCompetitionRepository competitionRepository;

	/** The match repository. */
	@Inject
	protected RtMatchRepository matchRepository;

	/** The participant repository. */
	@Inject
	protected CfgParticipantRepository participantRepository;

	/** The region repository. */
	@Inject
	protected CfgRegionRepository regionRepository;

	/** The rt match service. */
	@Inject
	private IRtMatchService rtMatchService;

	/** The sport repository. */
	@Inject
	protected CfgSportRepository sportRepository;

	/** The synchro match writer service. */
	@Inject
	private ISynchroMatchWriterService synchroMatchWriterService;

	/**
	 * Active match test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void activeMatchTest() throws FileNotFoundException {
		RtMatch incommingActiveMatch = new RtMatch();
		List<IDocument> incommingRtMatchs = getBeanFromXml("ActiveMatchTest");
		for (IDocument match : incommingRtMatchs) {
			incommingActiveMatch = (RtMatch) match;
			// Seteamos los hashs
			incommingActiveMatch.getHashKey();
			for (RtMarket market : incommingActiveMatch.getRtMarkets()) {
				market.getHashKey();
				for (RtBet bet : market.getBets()) {
					bet.getHashKey();
				}
			}
			synchroMatchWriterService.write(incommingActiveMatch);
		}
		List<RtMatch> activeRtMatchsDB = rtMatchService
				.getMatchsByHashKey(incommingActiveMatch.getHashKey());
		RtMatch activeRtMatchDB = null;
		if (activeRtMatchsDB != null && activeRtMatchsDB.size() > 0) {
			activeRtMatchDB = activeRtMatchsDB.get(0);
		} else {
			fail("No se ha podido recuperar el rtMatch de la BD");
		}
		assertTrue(activeRtMatchDB.isActive(null));
	}

	/**
	 * Bug3906 invert handicap value test. En BD hay un RtMatch con tipo de
	 * apuesta Asian Handicap del bookmaker 19 donde el valor del handicap es
	 * 2.5. Viene otro RtMatch del bookmaker 17 con los participantes al reves.
	 * El nuevo RtMatch tiene un mercado de handicap asiatico con un valor de
	 * -2.5 y otro mercado con una apuesta de 1X2 Handicap con valor 3 y otro
	 * con valor -2. Este test verifica que al cambiar el orden de los
	 * participantes también se invierten los valores del handicap.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public final void bug3906InvertHandicapValueTest()
			throws FileNotFoundException {
		RtMatch incommingRtMatch = null;
		RtMatch rtMatchDB = null;
		List<IDocument> incommingRtMatchs = getBeanFromXml("Bug3906");
		for (IDocument match : incommingRtMatchs) {
			incommingRtMatch = (RtMatch) match;
			incommingRtMatch.getHashKey();
			for (RtMarket market : incommingRtMatch.getRtMarkets()) {
				market.getHashKey();
				for (RtBet bet : market.getBets()) {
					bet.getHashKey();
				}
			}
			synchroMatchWriterService.write(incommingRtMatch);
		}
		List<RtMatch> rtMatchsDB = rtMatchService
				.getMatchsByHashKey(incommingRtMatch.getHashKey());
		if (rtMatchsDB != null && rtMatchsDB.size() > 0) {
			rtMatchDB = rtMatchsDB.get(0);
		} else {
			fail("No se ha podido recuperar el rtMatch de la BD");
		}

		assertEquals(2, rtMatchDB.getRtMarkets().size());
		for (RtMarket rtMarket : rtMatchDB.getRtMarkets()) {
			if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId())) {
				assertEquals(4, rtMarket.getBets().size());
				for (RtBet rtBet : rtMarket.getBets()) {
					RtAsianHandicapAttribute attr = (RtAsianHandicapAttribute) rtBet
							.getAttribute();
					assertEquals(new Double(2.75), attr.getFinalValue());
					assertEquals(new Double(2.5), attr.getFirstValue());
					assertEquals(new Double(3.0), attr.getSecondValue());
					if (attr.getAsianResult().equals(AsianResult.ONE)) {
						assertEquals("1", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
					} else if (attr.getAsianResult().equals(AsianResult.TWO)) {
						assertEquals("2", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
					} else {
						fail("El attributo de la apuesta no se reconoce");
					}

				}
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())) {
				assertEquals(6, rtMarket.getBets().size());
				for (RtBet rtBet : rtMarket.getBets()) {
					Rt1X2HandicapAttribute attr = (Rt1X2HandicapAttribute) rtBet
							.getAttribute();
					assertTrue(attr.getFinalValue().equals(new Double(2))
							|| attr.getFinalValue().equals(new Double(-3)));
				}
			}
		}
	}

	/**
	 * Bug4147 recognize bet after participant inversion test. En BD ya esta un
	 * partido con dos bets de tipo Asian Handicap de BetClick (bookmaker 19).
	 * Viene un partido de BetBoo (bookmaker 17) con los participantes
	 * invertidos. El partido de BetBoo tiene apuestas de tipo ganador de
	 * partido, 1X2, handicap asiatico, handicap 1X2 y mas/menos. La primera vez
	 * se da de alta como apuestas nuevas. Lo pasamos una segunda vez con coutas
	 * nuevas y tienen que actualizarse los bets previamente guardados de
	 * BetBoo.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void bug4147RecognizeBetAfterParticipantInversionTest()
			throws FileNotFoundException {

		RtMatch incommingMatch = null;
		RtMatch rtMatchDB = null;

		// **************************************************************************//
		// Primera vez que entra la casa 17
		// **************************************************************************//
		List<IDocument> incommingMatchs = getBeanFromXml("Bug4147NewBet");
		assertEquals(1, incommingMatchs.size());
		incommingMatch = (RtMatch) incommingMatchs.get(0);
		// Seteamos los hashs
		incommingMatch.getHashKey();
		for (RtMarket market : incommingMatch.getRtMarkets()) {
			market.getHashKey();
			for (RtBet bet : market.getBets()) {
				bet.getHashKey();
			}
		}
		synchroMatchWriterService.write(incommingMatch);
		// Los bets de bookmaker 17 deben estar dados de alta ahora. Verificamos
		// los attributos y las coutas de todos.
		List<RtMatch> matchsDB = rtMatchService
				.getMatchsByHashKey(incommingMatch.getHashKey());
		assertEquals(1, matchsDB.size());
		rtMatchDB = matchsDB.get(0);
		assertEquals(5, rtMatchDB.getRtMarkets().size());
		for (RtMarket rtMarket : rtMatchDB.getRtMarkets()) {
			if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())) {
				assertEquals(2, rtMarket.getBets().size());
				boolean betBookmaker17OddLocale = false;
				boolean betBookmaker17OddVisitante = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					assertNull(rtBet.getBetOddhistoric());
					RtGanadorPartidoAttribute attr = (RtGanadorPartidoAttribute) rtBet
							.getAttribute();
					assertEquals(rtBet.getParticipant().getCfgParticipant()
							.getName(null), attr.getWinnerName());
					if (attr.getResult().equals(Result.ONE)) {
						betBookmaker17OddLocale = true;
						assertEquals("1", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.71", rtBet.getBetOdd().getOdds());
					} else if (attr.getResult().equals(Result.TWO)) {
						betBookmaker17OddVisitante = true;
						assertEquals("2", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.72", rtBet.getBetOdd().getOdds());
					}
				}
				assertTrue(betBookmaker17OddLocale
						&& betBookmaker17OddVisitante);
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.UNO_X_DOS.nameId())) {
				assertEquals(3, rtMarket.getBets().size());
				boolean betBookmaker17OddLocale = false;
				boolean betBookmaker17OddEmpate = false;
				boolean betBookmaker17OddVisitante = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					assertNull(rtBet.getBetOddhistoric());
					Rt1X2Attribute attr = (Rt1X2Attribute) rtBet.getAttribute();
					if (attr.getResult().equals(Result.ONE)) {
						betBookmaker17OddLocale = true;
						assertEquals("1", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.71", rtBet.getBetOdd().getOdds());
					} else if (attr.getResult().equals(Result.TWO)) {
						betBookmaker17OddVisitante = true;
						assertEquals("2", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.72", rtBet.getBetOdd().getOdds());
					} else if (attr.getResult().equals(Result.DRAW)) {
						betBookmaker17OddEmpate = true;
						assertEquals("1.73", rtBet.getBetOdd().getOdds());
					}
				}
				assertTrue(betBookmaker17OddLocale
						&& betBookmaker17OddVisitante
						&& betBookmaker17OddEmpate);
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId())) {
				assertEquals(4, rtMarket.getBets().size());
				boolean betBookmaker17OddLocale = false;
				boolean betBookmaker17OddVisitante = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					if (rtBet.getBookmaker().getObjectId().toString()
							.equalsIgnoreCase("17")) {
						assertNull(rtBet.getBetOddhistoric());
						RtAsianHandicapAttribute attr = (RtAsianHandicapAttribute) rtBet
								.getAttribute();
						assertEquals(new Double(2.5), attr.getFinalValue());
						if (attr.getAsianResult().equals(AsianResult.ONE)) {
							betBookmaker17OddLocale = true;
							assertEquals("1", rtBet.getParticipant()
									.getCfgParticipant().getObjectId()
									.toString());
							assertEquals("1.71", rtBet.getBetOdd().getOdds());
						} else if (attr.getAsianResult()
								.equals(AsianResult.TWO)) {
							betBookmaker17OddVisitante = true;
							assertEquals("2", rtBet.getParticipant()
									.getCfgParticipant().getObjectId()
									.toString());
							assertEquals("1.72", rtBet.getBetOdd().getOdds());
						}
					}
				}
				assertTrue(betBookmaker17OddLocale
						&& betBookmaker17OddVisitante);
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())) {
				assertEquals(3, rtMarket.getBets().size());
				boolean betBookmaker17OddLocale = false;
				boolean betBookmaker17OddEmpate = false;
				boolean betBookmaker17OddVisitante = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					assertNull(rtBet.getBetOddhistoric());
					Rt1X2HandicapAttribute attr = (Rt1X2HandicapAttribute) rtBet
							.getAttribute();
					assertEquals(new Double(2.5), attr.getFinalValue());
					if (attr.getResult().equals(Result.ONE)) {
						betBookmaker17OddLocale = true;
						assertEquals("1", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.71", rtBet.getBetOdd().getOdds());
					} else if (attr.getResult().equals(Result.TWO)) {
						betBookmaker17OddVisitante = true;
						assertEquals("2", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.72", rtBet.getBetOdd().getOdds());
					} else if (attr.getResult().equals(Result.DRAW)) {
						betBookmaker17OddEmpate = true;
						assertEquals("1.73", rtBet.getBetOdd().getOdds());
					}
				}
				assertTrue(betBookmaker17OddLocale
						&& betBookmaker17OddVisitante
						&& betBookmaker17OddEmpate);
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.MAS_MENOS.nameId())) {
				assertEquals(2, rtMarket.getBets().size());
				boolean betBookmaker17OddMas = false;
				boolean betBookmaker17OddMenos = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					assertNull(rtBet.getBetOddhistoric());
					RtMasMenosAttribute attr = (RtMasMenosAttribute) rtBet
							.getAttribute();
					if (attr.getMasMenos().equals(MasMenos.MAS)) {
						betBookmaker17OddMas = true;
						assertEquals("1.71", rtBet.getBetOdd().getOdds());
					} else if (attr.getMasMenos().equals(MasMenos.MENOS)) {
						betBookmaker17OddMenos = true;
						assertEquals("1.72", rtBet.getBetOdd().getOdds());
					}
				}
				assertTrue(betBookmaker17OddMas && betBookmaker17OddMenos);
			} else {
				fail("No se ha recomocido el tipo de apuesta");
			}
		}

		// **************************************************************************//
		// Segunda vez que entra la casa 17, ahora con cuotas cambiadas.
		// **************************************************************************//
		incommingMatchs = getBeanFromXml("Bug4147UpdatedBet");
		assertEquals(1, incommingMatchs.size());
		incommingMatch = (RtMatch) incommingMatchs.get(0);
		// Seteamos los hashs
		incommingMatch.getHashKey();
		for (RtMarket market : incommingMatch.getRtMarkets()) {
			market.getHashKey();
			for (RtBet bet : market.getBets()) {
				bet.getHashKey();
			}
		}
		synchroMatchWriterService.write(incommingMatch);
		// Los dos bets de bookmaker 17 deben tener cuotas modificadas ahora
		matchsDB = rtMatchService.getMatchsByHashKey(incommingMatch
				.getHashKey());
		assertEquals(1, matchsDB.size());
		rtMatchDB = matchsDB.get(0);
		assertEquals(5, rtMatchDB.getRtMarkets().size());
		for (RtMarket rtMarket : rtMatchDB.getRtMarkets()) {
			if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())) {
				assertEquals(2, rtMarket.getBets().size());
				boolean betBookmaker17OddLocale = false;
				boolean betBookmaker17OddVisitante = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					assertNotNull(rtBet.getBetOddhistoric());
					assertEquals(1, rtBet.getBetOddhistoric().size());
					RtGanadorPartidoAttribute attr = (RtGanadorPartidoAttribute) rtBet
							.getAttribute();
					if (attr.getResult().equals(Result.ONE)) {
						betBookmaker17OddLocale = true;
						assertEquals("1", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.81", rtBet.getBetOdd().getOdds());
						assertEquals("1.71", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					} else if (attr.getResult().equals(Result.TWO)) {
						betBookmaker17OddVisitante = true;
						assertEquals("2", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.82", rtBet.getBetOdd().getOdds());
						assertEquals("1.72", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					}
				}
				assertTrue(betBookmaker17OddLocale
						&& betBookmaker17OddVisitante);
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.UNO_X_DOS.nameId())) {
				assertEquals(3, rtMarket.getBets().size());
				boolean betBookmaker17OddLocale = false;
				boolean betBookmaker17OddEmpate = false;
				boolean betBookmaker17OddVisitante = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					assertNotNull(rtBet.getBetOddhistoric());
					assertEquals(1, rtBet.getBetOddhistoric().size());
					Rt1X2Attribute attr = (Rt1X2Attribute) rtBet.getAttribute();
					if (attr.getResult().equals(Result.ONE)) {
						betBookmaker17OddLocale = true;
						assertEquals("1", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.81", rtBet.getBetOdd().getOdds());
						assertEquals("1.71", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					} else if (attr.getResult().equals(Result.TWO)) {
						betBookmaker17OddVisitante = true;
						assertEquals("2", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.82", rtBet.getBetOdd().getOdds());
						assertEquals("1.72", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					} else if (attr.getResult().equals(Result.DRAW)) {
						betBookmaker17OddEmpate = true;
						assertEquals("1.83", rtBet.getBetOdd().getOdds());
						assertEquals("1.73", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					}
				}
				assertTrue(betBookmaker17OddLocale
						&& betBookmaker17OddVisitante
						&& betBookmaker17OddEmpate);
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.HANDICAP_ASIATICO.nameId())) {
				assertEquals(4, rtMarket.getBets().size());
				boolean betBookmaker17OddLocale = false;
				boolean betBookmaker17OddVisitante = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					if (rtBet.getBookmaker().getObjectId().toString()
							.equalsIgnoreCase("17")) {
						assertNotNull(rtBet.getBetOddhistoric());
						assertEquals(1, rtBet.getBetOddhistoric().size());
						RtAsianHandicapAttribute attr = (RtAsianHandicapAttribute) rtBet
								.getAttribute();
						assertEquals(new Double(2.5), attr.getFinalValue());
						if (attr.getAsianResult().equals(AsianResult.ONE)) {
							betBookmaker17OddLocale = true;
							assertEquals("1", rtBet.getParticipant()
									.getCfgParticipant().getObjectId()
									.toString());
							assertEquals("1.81", rtBet.getBetOdd().getOdds());
							assertEquals("1.71",
									rtBet.getBetOddhistoric().get(0).getOdds());
						} else if (attr.getAsianResult()
								.equals(AsianResult.TWO)) {
							betBookmaker17OddVisitante = true;
							assertEquals("2", rtBet.getParticipant()
									.getCfgParticipant().getObjectId()
									.toString());
							assertEquals("1.82", rtBet.getBetOdd().getOdds());
							assertEquals("1.72",
									rtBet.getBetOddhistoric().get(0).getOdds());
						}
					} else {
						assertNull(rtBet.getBetOddhistoric());
					}
				}
				assertTrue(betBookmaker17OddLocale
						&& betBookmaker17OddVisitante);
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())) {
				assertEquals(3, rtMarket.getBets().size());
				boolean betBookmaker17OddLocale = false;
				boolean betBookmaker17OddEmpate = false;
				boolean betBookmaker17OddVisitante = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					assertNotNull(rtBet.getBetOddhistoric());
					assertEquals(1, rtBet.getBetOddhistoric().size());
					Rt1X2HandicapAttribute attr = (Rt1X2HandicapAttribute) rtBet
							.getAttribute();
					assertEquals(new Double(2.5), attr.getFinalValue());
					if (attr.getResult().equals(Result.ONE)) {
						betBookmaker17OddLocale = true;
						assertEquals("1", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.81", rtBet.getBetOdd().getOdds());
						assertEquals("1.71", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					} else if (attr.getResult().equals(Result.TWO)) {
						betBookmaker17OddVisitante = true;
						assertEquals("2", rtBet.getParticipant()
								.getCfgParticipant().getObjectId().toString());
						assertEquals("1.82", rtBet.getBetOdd().getOdds());
						assertEquals("1.72", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					} else if (attr.getResult().equals(Result.DRAW)) {
						betBookmaker17OddEmpate = true;
						assertEquals("1.83", rtBet.getBetOdd().getOdds());
						assertEquals("1.73", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					}
				}
				assertTrue(betBookmaker17OddLocale
						&& betBookmaker17OddVisitante
						&& betBookmaker17OddEmpate);
			} else if (rtMarket.getBetType().getNameId()
					.equals(CfgBetTypeId.MAS_MENOS.nameId())) {
				assertEquals(2, rtMarket.getBets().size());
				boolean betBookmaker17OddMas = false;
				boolean betBookmaker17OddMenos = false;
				for (RtBet rtBet : rtMarket.getBets()) {
					assertNotNull(rtBet.getBetOddhistoric());
					assertEquals(1, rtBet.getBetOddhistoric().size());
					RtMasMenosAttribute attr = (RtMasMenosAttribute) rtBet
							.getAttribute();
					if (attr.getMasMenos().equals(MasMenos.MAS)) {
						betBookmaker17OddMas = true;
						assertEquals("1.81", rtBet.getBetOdd().getOdds());
						assertEquals("1.71", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					} else if (attr.getMasMenos().equals(MasMenos.MENOS)) {
						betBookmaker17OddMenos = true;
						assertEquals("1.82", rtBet.getBetOdd().getOdds());
						assertEquals("1.72", rtBet.getBetOddhistoric().get(0)
								.getOdds());
					}
				}
				assertTrue(betBookmaker17OddMas && betBookmaker17OddMenos);
			} else {
				fail("No se ha recomocido el tipo de apuesta");
			}

		}
	}

	/**
	 * Combinate matchs change participants test. Entran dos RtMatch. El primer
	 * es de BetClick (19) y solo actualiza el partido ya guardado en BD
	 * anteriormente. El seguno partido es de BetBoo. A nivel de RtMatchId tiene
	 * los participantes invertidos comparado con el RtMatch de la BD. PERO, a
	 * nivel de bet los participantes NO estan invertidos (el participante con
	 * id 1 es local y el participante con id 2 es el visitante). Este test solo
	 * guarda el primer partido de BetClick.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void combinateMatchsChangeParticipantsTest()
			throws FileNotFoundException {
		RtMatch combinateMatch = new RtMatch();
		List<IDocument> matchsFromXml = getBeanFromXml("MatchCombinationChangeParticipants");
		for (IDocument match : matchsFromXml) {
			combinateMatch = (RtMatch) match;
			// Seteamos los hashs
			combinateMatch.setHashKey(combinateMatch.getHashKey());
			for (RtMarket market : combinateMatch.getRtMarkets()) {
				market.setHashKey(market.getHashKey());
				for (RtBet bet : market.getBets()) {
					bet.setHashKey(bet.getHashKey());
				}
			}
			synchroMatchWriterService.write(combinateMatch);
		}
		List<RtMatch> combinateMatchs = rtMatchService
				.getMatchsByHashKey(combinateMatch.getHashKey());
		if (!combinateMatchs.isEmpty()) {
			combinateMatch = combinateMatchs.get(0);
			assertEquals(1, combinateMatch.getRtMarkets().size());
			assertEquals(2, combinateMatch.getRtMarkets().iterator().next()
					.getBets().size());
		} else {
			fail("No se ha podido recuperar el rtMatch de la BD");
		}
		assertTrue(combinateMatch.isActive(null));

	}

	/**
	 * Combinate matchs test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void combinateMatchsTest() throws FileNotFoundException {
		RtMatch combinateMatch = new RtMatch();
		List<IDocument> matchsFromXml = getBeanFromXml("MatchCombination");
		for (IDocument match : matchsFromXml) {
			combinateMatch = (RtMatch) match;
			// Seteamos los hashs
			combinateMatch.setHashKey(combinateMatch.getHashKey());
			for (RtMarket market : combinateMatch.getRtMarkets()) {
				market.setHashKey(market.getHashKey());
				for (RtBet bet : market.getBets()) {
					bet.setHashKey(bet.getHashKey());
				}
			}
			synchroMatchWriterService.write(combinateMatch);
		}
		List<RtMatch> combinateMatchs = rtMatchService
				.getMatchsByHashKey(combinateMatch.getHashKey());
		if (!combinateMatchs.isEmpty()) {
			combinateMatch = combinateMatchs.get(0);
			assertEquals(1, combinateMatch.getRtMarkets().size());
			assertEquals(4, combinateMatch.getRtMarkets().iterator().next()
					.getBets().size());
		} else {
			fail("No se ha podido recuperar el rtMatch de la BD");
		}
		assertTrue(combinateMatch.isActive(null));
	}

	/**
	 * Gets the aditional name for load.
	 * 
	 * @return the aditional name for load {@inheritDoc}
	 */
	protected String getAditionalNameForLoad() {
		return PREFIX;
	}

	/**
	 * Gets the loader class.
	 * 
	 * @return the loader class {@inheritDoc}
	 */
	@Override
	protected Class<?> getLoaderClass() {
		return SynchroReaderWriterConfig.class;
	}

	/**
	 * Gets the repository.
	 * 
	 * @return the repository {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected HashMap<Class<? extends IDocument>, CrudRepository> getRepository() {
		HashMap<Class<? extends IDocument>, CrudRepository> result = new HashMap<Class<? extends IDocument>, CrudRepository>();
		result.put(CfgCompetition.class, competitionRepository);
		result.put(CfgCompetitionEvent.class, competitionEventRepository);
		result.put(CfgSport.class, sportRepository);
		result.put(CfgParticipant.class, participantRepository);
		result.put(CfgBetType.class, betTypeRepository);
		result.put(CfgBetTypeEvent.class, betTypeEventRepository);
		result.put(CfgBookmaker.class, bookmakerRepository);
		result.put(CfgRegion.class, regionRepository);
		result.put(RtMatch.class, matchRepository);
		return result;
	}

	/**
	 * Inactive match no active bet type event test.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void inactiveMatchNoActiveBetTypeEventTest()
			throws FileNotFoundException {
		RtMatch incommingInactiveMatch = new RtMatch();
		List<IDocument> incommingRtMatchs = getBeanFromXml("InactiveMatchNoActiveBetTypeEventTest");
		for (IDocument match : incommingRtMatchs) {
			incommingInactiveMatch = (RtMatch) match;
			// Seteamos los hashs
			incommingInactiveMatch.getHashKey();
			for (RtMarket market : incommingInactiveMatch.getRtMarkets()) {
				market.getHashKey();
				for (RtBet bet : market.getBets()) {
					bet.getHashKey();
				}
			}
			synchroMatchWriterService.write(incommingInactiveMatch);
		}
		List<RtMatch> inactiveRtMatchsDB = rtMatchService
				.getMatchsByHashKey(incommingInactiveMatch.getHashKey());
		RtMatch inactiveRtMatchDB = null;
		if (inactiveRtMatchsDB != null && inactiveRtMatchsDB.size() > 0) {
			inactiveRtMatchDB = inactiveRtMatchsDB.get(0);
		} else {
			fail("No se ha podido recuperar el rtMatch de la BD");
		}
		assertTrue(inactiveRtMatchDB.isActive(null));
	}

	/**
	 * Write inactive match. Si el partido tiene apuestas de tipo 1x2, ganador o
	 * ganador partido en alguno de sus mercados y que alguna de ellas tenga
	 * partido completo en alguno de sus eventos es un partido activo, en caso
	 * contrario debería ser un partido desactivado.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void inactiveMatchNoActiveBetTypeTest() throws FileNotFoundException {
		RtMatch incommingInactiveMatch = new RtMatch();
		List<IDocument> incommingRtMatchs = getBeanFromXml("InactiveMatchNoActiveBetTypeTest");
		for (IDocument match : incommingRtMatchs) {
			incommingInactiveMatch = (RtMatch) match;
			// Seteamos los hashs
			incommingInactiveMatch.getHashKey();
			for (RtMarket market : incommingInactiveMatch.getRtMarkets()) {
				market.getHashKey();
				for (RtBet bet : market.getBets()) {
					bet.getHashKey();
				}
			}
			synchroMatchWriterService.write(incommingInactiveMatch);
		}
		List<RtMatch> inactiveRtMatchsDB = rtMatchService
				.getMatchsByHashKey(incommingInactiveMatch.getHashKey());
		RtMatch inactiveRtMatchDB = null;
		if (inactiveRtMatchsDB != null && inactiveRtMatchsDB.size() > 0) {
			inactiveRtMatchDB = inactiveRtMatchsDB.get(0);
		} else {
			fail("No se ha podido recuperar el rtMatch de la BD");
		}
		assertTrue(inactiveRtMatchDB.isActive(null));
	}

	/**
	 * Prueba que en un RtMatch con varios mercados si uno de ellos es
	 * incorrecto, se elimina pero se almacena el RtMatch con el resto de
	 * mercados válidos Esta prueba tiene inicialmente un xml asociado con un
	 * RtMatch con dos mercados uno de ellos de tipo handicap asiatico y mal
	 * formado con lo que verifica que en BD se almacena un RtMatch con un solo
	 * mercado de tipo ganador partido.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void incorrectMarketInMatchTest() throws FileNotFoundException {
		RtMatch incommingInactiveMatch = new RtMatch();
		List<IDocument> incommingRtMatchs = getBeanFromXml("IncorrectMarketInMatchTest");
		for (IDocument match : incommingRtMatchs) {
			incommingInactiveMatch = (RtMatch) match;
			// Seteamos los hashs
			incommingInactiveMatch.getHashKey();
			for (RtMarket market : incommingInactiveMatch.getRtMarkets()) {
				market.getHashKey();
				for (RtBet bet : market.getBets()) {
					bet.getHashKey();
				}
			}
			synchroMatchWriterService.write(incommingInactiveMatch);
		}
		List<RtMatch> rtMatchsDB = rtMatchService
				.getMatchsByHashKey(incommingInactiveMatch.getHashKey());
		RtMatch rtMatchDB = null;
		if (rtMatchsDB != null && rtMatchsDB.size() > 0) {
			rtMatchDB = rtMatchsDB.get(0);
			assertTrue(rtMatchDB.getRtMarkets().size() == 1);

		} else {
			fail("No se ha podido recuperar el rtMatch de la BD");
		}
		assertTrue(rtMatchDB.isActive(null));
	}

	/**
	 * Prueba que en un RtMatch con dos mercados invalidos y uno valido sólo
	 * guarda el mercado valido en BD. Esta prueba tiene inicialmente un xml
	 * asociado con un RtMatch con un mercado de tipo handicap asiatico mal
	 * formado, otro mercado de tipo 1X2 Handicap mal formado y un mercado de
	 * tipo ganador partido bien formado.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@Test
	public void twoIncorrectMarketInMatchTest() throws FileNotFoundException {
		RtMatch incommingInactiveMatch = new RtMatch();
		List<IDocument> incommingRtMatchs = getBeanFromXml("TwoIncorrectMarketInMatchTest");
		for (IDocument match : incommingRtMatchs) {
			incommingInactiveMatch = (RtMatch) match;
			// Seteamos los hashs
			incommingInactiveMatch.getHashKey();
			for (RtMarket market : incommingInactiveMatch.getRtMarkets()) {
				market.getHashKey();
				for (RtBet bet : market.getBets()) {
					bet.getHashKey();
				}
			}
			synchroMatchWriterService.write(incommingInactiveMatch);
		}
		List<RtMatch> rtMatchsDB = rtMatchService
				.getMatchsByHashKey(incommingInactiveMatch.getHashKey());
		RtMatch rtMatchDB = null;
		if (rtMatchsDB != null && rtMatchsDB.size() > 0) {
			rtMatchDB = rtMatchsDB.get(0);
			assertEquals(1, rtMatchDB.getRtMarkets().size());

		} else {
			fail("No se ha podido recuperar el rtMatch de la BD");
		}
		assertTrue(rtMatchDB.isActive(null));
	}

}
