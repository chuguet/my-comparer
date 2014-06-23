/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Test;

import com.comparadorad.bet.comparer.bet.bean.validator.CorrectMarketGroup;
import com.comparadorad.bet.comparer.model.bet.bean.AbstractBetBeanTest;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;

/**
 * The Class RtMarketTest.
 */
public class RtMarketTest extends AbstractBetBeanTest {

	/** The validator. */
	@Inject
	private Validator validator;

	/**
	 * Bookmaker with invalid combination of bet attributes test. Aqui creamos
	 * un mercado de tipo handicap asiatico que tiene sus dos RtBet puesto con
	 * atributos de tipo TWO (en vez de uno con tipo ONE y el otro con tipo
	 * TWO).
	 */
	@Test
	public void bookmakerWithInvalidCombinationOfBetAttributesTest() {

		RtMarket market = new RtMarket();

		// BETTYPE
		CfgBetType betType = new CfgBetType();
		betType.setI18n(getValidI18n());
		betType.setObjectId(new BigInteger("4"));
		betType.setNameId("Handicap_Asiatico");
		market.setBetType(betType);

		// BETTYPEEVENT
		RtBetTypeEvent betTypeEvent = getValidBetTypeEvent();
		market.setBetTypeEvent(betTypeEvent);

		// BETS
		RtBet betLocal = new RtBet();
		betLocal.setBetType(betType);
		betLocal.setObjectId("123");

		RtBet betVisitante = new RtBet();
		betVisitante.setBetType(betType);
		betVisitante.setObjectId("687");

		// BETODDS
		RtBetOdd rtBetOddLocal = new RtBetOdd();
		rtBetOddLocal.setOdds("5");
		betLocal.setBetOdd(rtBetOddLocal);

		RtBetOdd rtBetOddVisitante = new RtBetOdd();
		rtBetOddVisitante.setOdds("4");
		betVisitante.setBetOdd(rtBetOddVisitante);

		// ATTRIBUTOS los dos RtBet tiene el Result.TWO
		RtAsianHandicapAttribute attributeLocal = new RtAsianHandicapAttribute();
		attributeLocal.setBetName("Handicap_Asiatico");
		attributeLocal.setAsianResult(AsianResult.TWO);
		attributeLocal.setFinalValue(new Double(1.5));
		betLocal.setAttribute(attributeLocal);

		RtAsianHandicapAttribute attributeVisitante = new RtAsianHandicapAttribute();
		attributeVisitante.setBetName("Handicap_Asiatico");
		attributeVisitante.setAsianResult(AsianResult.TWO);
		attributeVisitante.setFinalValue(new Double(1.5));
		betVisitante.setAttribute(attributeVisitante);

		// PARTICIPANTES
		RtParticipant participantLocal = new RtParticipant();
		CfgParticipant cfgParticipantLocal = new CfgParticipant("1");
		cfgParticipantLocal.setName("Part1");
		participantLocal.setAwayParticipant(false);
		participantLocal.setHomeParticipant(true);
		participantLocal.setCfgParticipant(cfgParticipantLocal);
		participantLocal.hashCode();
		betLocal.setParticipant(participantLocal);

		RtParticipant participantVisitante = new RtParticipant();
		CfgParticipant cfgParticipantVisitante = new CfgParticipant("2");
		cfgParticipantVisitante.setName("Part2");
		participantVisitante.setAwayParticipant(false);
		participantVisitante.setHomeParticipant(true);
		participantVisitante.setCfgParticipant(cfgParticipantVisitante);
		participantVisitante.hashCode();
		betVisitante.setParticipant(participantVisitante);

		// BOOKMAKER
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setI18n(getValidI18n());
		bookmaker.setNameId("BetClick");
		bookmaker.setObjectId(new BigInteger("19"));
		betLocal.setBookmaker(bookmaker);
		betVisitante.setBookmaker(bookmaker);

		market.add(betLocal);
		market.add(betVisitante);

		// HASHKEYS
		betLocal.getHashKey();
		betVisitante.getHashKey();
		market.getHashKey();

		RtMatch match = getValidMatch(market, false, participantLocal,
				participantVisitante);

		Set<ConstraintViolation<RtMatch>> constraintViolations;
		constraintViolations = validator.validate(match,
				CorrectMarketGroup.class);
		assertNotNull(constraintViolations);
		assertEquals(1, constraintViolations.size());

		for (ConstraintViolation<RtMatch> violation : constraintViolations) {
			assertEquals(
					"Mercado invalido: Una apuesta de tipo Handicap_Asiatico del bookmaker con nombre: BetClick, id: 19, no tiene todos los atributos necesarios.",
					violation.getMessage());
		}

	}

	/**
	 * Bookmaker with invalid number of bets test. En este test creamos un
	 * mercado de tipo gandor de partido con 4 RtBet. Para ser un mercado
	 * valido, los 4 bets deberian estar divididos entre dos bookmakers de
	 * manera 2:2. Pero al dividirlo 1:3 la validacion tiene que fallar dando el
	 * mensaje de error de la validacion de numero de bets por bookmaker.
	 */
	@Test
	public void bookmakerWithInvalidNumberOfBetsTest() {

		RtMarket market = new RtMarket();

		// BETTYPE
		CfgBetType betType = new CfgBetType();
		betType.setI18n(getValidI18n());
		betType.setObjectId(new BigInteger("2"));
		betType.setNameId("Ganador_Partido");
		market.setBetType(betType);

		// BETTYPEEVENT
		RtBetTypeEvent betTypeEvent = getValidBetTypeEvent();
		market.setBetTypeEvent(betTypeEvent);

		// BETS
		RtBet bet1 = new RtBet();
		bet1.setBetType(betType);
		bet1.setObjectId("123");

		RtBet bet2 = new RtBet();
		bet2.setBetType(betType);
		bet2.setObjectId("687");

		RtBet bet3 = new RtBet();
		bet3.setBetType(betType);
		bet3.setObjectId("453");

		RtBet bet4 = new RtBet();
		bet4.setBetType(betType);
		bet4.setObjectId("683");

		// BETODDS
		RtBetOdd rtBetOdd1 = new RtBetOdd();
		rtBetOdd1.setOdds("5");
		bet1.setBetOdd(rtBetOdd1);

		RtBetOdd rtBetOdd2 = new RtBetOdd();
		rtBetOdd2.setOdds("3");
		bet2.setBetOdd(rtBetOdd2);

		RtBetOdd rtBetOdd3 = new RtBetOdd();
		rtBetOdd3.setOdds("4");
		bet3.setBetOdd(rtBetOdd3);

		RtBetOdd rtBetOdd4 = new RtBetOdd();
		rtBetOdd4.setOdds("2.5");
		bet4.setBetOdd(rtBetOdd4);

		// ATTRIBUTOS
		RtGanadorPartidoAttribute attribute1 = new RtGanadorPartidoAttribute();
		attribute1.setBetName("Ganador_Partido");
		attribute1.setResult(Result.ONE);
		attribute1.setWinnerName("Part1");
		bet1.setAttribute(attribute1);

		RtGanadorPartidoAttribute attribute2 = new RtGanadorPartidoAttribute();
		attribute2.setBetName("Ganador_Partido");
		attribute2.setResult(Result.TWO);
		attribute2.setWinnerName("Part2");
		bet2.setAttribute(attribute2);

		RtGanadorPartidoAttribute attribute3 = new RtGanadorPartidoAttribute();
		attribute3.setBetName("Ganador_Partido");
		attribute3.setResult(Result.ONE);
		attribute3.setWinnerName("Part1");
		bet3.setAttribute(attribute3);

		RtGanadorPartidoAttribute attribute4 = new RtGanadorPartidoAttribute();
		attribute4.setBetName("Ganador_Partido");
		attribute4.setResult(Result.TWO);
		attribute4.setWinnerName("Part2");
		bet4.setAttribute(attribute4);

		// PARTICIPANTES
		RtParticipant participantLocal = new RtParticipant();
		CfgParticipant cfgParticipantLocal = new CfgParticipant("1");
		cfgParticipantLocal.setName("Part1");
		participantLocal.setAwayParticipant(false);
		participantLocal.setHomeParticipant(true);
		participantLocal.setCfgParticipant(cfgParticipantLocal);
		participantLocal.hashCode();
		bet1.setParticipant(participantLocal);
		bet3.setParticipant(participantLocal);

		RtParticipant participantVisitante = new RtParticipant();
		CfgParticipant cfgParticipantVisitante = new CfgParticipant("2");
		cfgParticipantVisitante.setName("Part2");
		participantVisitante.setAwayParticipant(false);
		participantVisitante.setHomeParticipant(true);
		participantVisitante.setCfgParticipant(cfgParticipantVisitante);
		participantVisitante.hashCode();
		bet2.setParticipant(participantVisitante);
		bet4.setParticipant(participantVisitante);

		// BOOKMAKER distribuimos los RtBets 1:3 entre los dos bookmakers
		CfgBookmaker bookmaker1 = new CfgBookmaker();
		bookmaker1.setI18n(getValidI18n());
		bookmaker1.setNameId("BetClick");
		bookmaker1.setObjectId(new BigInteger("19"));
		bet1.setBookmaker(bookmaker1);

		CfgBookmaker bookmaker2 = new CfgBookmaker();
		bookmaker2.setI18n(getValidI18n());
		bookmaker2.setNameId("BetOnline");
		bookmaker2.setObjectId(new BigInteger("33"));
		bet2.setBookmaker(bookmaker2);
		bet3.setBookmaker(bookmaker2);
		bet4.setBookmaker(bookmaker2);

		market.add(bet1);
		market.add(bet2);
		market.add(bet3);
		market.add(bet4);

		// HASHKEYS
		bet1.getHashKey();
		bet2.getHashKey();
		bet3.getHashKey();
		bet4.getHashKey();
		market.getHashKey();

		RtMatch match = getValidMatch(market, false, participantLocal,
				participantVisitante);

		Set<ConstraintViolation<RtMatch>> constraintViolations;
		constraintViolations = validator.validate(match,
				CorrectMarketGroup.class);
		assertNotNull(constraintViolations);
		assertEquals(2, constraintViolations.size());

		for (ConstraintViolation<RtMatch> violation : constraintViolations) {
			assertTrue(violation
					.getMessage()
					.equalsIgnoreCase(
							"Mercado invalido: Una apuesta de tipo Ganador_Partido del bookmaker con nombre: BetClick, id: 19, tiene un numero de RtBbet invalido: 1")
					|| violation
							.getMessage()
							.equalsIgnoreCase(
									"Mercado invalido: Una apuesta de tipo Ganador_Partido del bookmaker con nombre: BetOnline, id: 33, tiene un numero de RtBbet invalido: 3"));
		}

	}

	/**
	 * Bookmaker with invalid odds test. Aqui cremos un mercado de tipo 1X2 con
	 * cuotas 5, 1.6 y 8. Estos valores no forman una apuesta válida ya que la
	 * suma de su cuotas (1/5 + 1/1.6 + 1/8 = 0.95 < 1 [en vez de > 1]). La
	 * validacion tiene que fallar dando el mensaje de error de la validacion de
	 * los odds por bookmaker.
	 */
	@Test
	public void bookmakerWithInvalidOddsTest() {

		RtMarket market = new RtMarket();

		// BETTYPE
		CfgBetType betType = new CfgBetType();
		betType.setI18n(getValidI18n());
		betType.setObjectId(new BigInteger("1"));
		betType.setNameId("1X2");
		market.setBetType(betType);

		// BETTYPEEVENT
		RtBetTypeEvent betTypeEvent = getValidBetTypeEvent();
		market.setBetTypeEvent(betTypeEvent);

		// BETS
		RtBet betLocal = new RtBet();
		betLocal.setBetType(betType);
		betLocal.setObjectId("123");

		RtBet betEmpate = new RtBet();
		betEmpate.setBetType(betType);
		betEmpate.setObjectId("464");

		RtBet betVisitante = new RtBet();
		betVisitante.setBetType(betType);
		betVisitante.setObjectId("687");

		// BETODDS - las cuotas 5, 1.6 y 8 no forman una apuesta válida (1/5 +
		// 1/1.6 + 1/8 = 0.95 < 1 [en vez de > 1]).
		RtBetOdd rtBetOddLocal = new RtBetOdd();
		rtBetOddLocal.setOdds("5");
		betLocal.setBetOdd(rtBetOddLocal);

		RtBetOdd rtBetOddEmpate = new RtBetOdd();
		rtBetOddEmpate.setOdds("1.6");
		betEmpate.setBetOdd(rtBetOddEmpate);

		RtBetOdd rtBetOddVisitante = new RtBetOdd();
		rtBetOddVisitante.setOdds("8");
		betVisitante.setBetOdd(rtBetOddVisitante);

		// ATTRIBUTOS
		Rt1X2Attribute attributeLocal = new Rt1X2Attribute();
		attributeLocal.setBetName("1X2");
		attributeLocal.setResult(Result.ONE);
		betLocal.setAttribute(attributeLocal);

		Rt1X2Attribute attributeEmpate = new Rt1X2Attribute();
		attributeEmpate.setBetName("1X2");
		attributeEmpate.setResult(Result.DRAW);
		betEmpate.setAttribute(attributeEmpate);

		Rt1X2Attribute attributeVisitante = new Rt1X2Attribute();
		attributeVisitante.setBetName("1X2");
		attributeVisitante.setResult(Result.TWO);
		betVisitante.setAttribute(attributeVisitante);

		// PARTICIPANTES
		RtParticipant participantLocal = new RtParticipant();
		CfgParticipant cfgParticipantLocal = new CfgParticipant("1");
		cfgParticipantLocal.setName("Part1");
		participantLocal.setAwayParticipant(false);
		participantLocal.setHomeParticipant(true);
		participantLocal.setCfgParticipant(cfgParticipantLocal);
		participantLocal.hashCode();
		betLocal.setParticipant(participantLocal);

		RtParticipant participantEmpate = new RtParticipant();
		CfgParticipant cfgParticipantEmpate = new CfgParticipant("1");
		participantEmpate.setAwayParticipant(false);
		participantEmpate.setHomeParticipant(false);
		participantEmpate.setCfgParticipant(cfgParticipantEmpate);
		participantEmpate.hashCode();
		betEmpate.setParticipant(participantEmpate);

		RtParticipant participantVisitante = new RtParticipant();
		CfgParticipant cfgParticipantVisitante = new CfgParticipant("2");
		cfgParticipantVisitante.setName("Part2");
		participantVisitante.setAwayParticipant(false);
		participantVisitante.setHomeParticipant(true);
		participantVisitante.setCfgParticipant(cfgParticipantVisitante);
		participantVisitante.hashCode();
		betVisitante.setParticipant(participantVisitante);

		// BOOKMAKER
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setI18n(getValidI18n());
		bookmaker.setNameId("BetClick");
		bookmaker.setObjectId(new BigInteger("19"));
		betLocal.setBookmaker(bookmaker);
		betEmpate.setBookmaker(bookmaker);
		betVisitante.setBookmaker(bookmaker);

		market.add(betLocal);
		market.add(betEmpate);
		market.add(betVisitante);

		// HASHKEYS
		betLocal.getHashKey();
		betEmpate.getHashKey();
		betVisitante.getHashKey();
		market.getHashKey();

		RtMatch match = getValidMatch(market, false, participantLocal,
				participantVisitante);

		Set<ConstraintViolation<RtMatch>> constraintViolations;
		constraintViolations = validator.validate(match,
				CorrectMarketGroup.class);
		assertNotNull(constraintViolations);
		assertEquals(1, constraintViolations.size());

		for (ConstraintViolation<RtMatch> violation : constraintViolations) {
			assertEquals(
					"Mercado invalido: La apuesta de tipo 1X2 del bookmaker con nombre: BetClick, id: 19, tiene cuotas invalidas.",
					violation.getMessage());
		}

	}

	/**
	 * Gets the valid bet type event. Convenience method.
	 * 
	 * @return the valid bet type event
	 */
	private RtBetTypeEvent getValidBetTypeEvent() {
		RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
		CfgBetTypeEvent cfgBetTypeEvent = new CfgBetTypeEvent();
		betTypeEvent.setNameId("Partido completo");
		betTypeEvent.setObjectId(new BigInteger("1"));
		cfgBetTypeEvent.setObjectId("1");
		cfgBetTypeEvent.setI18n(getValidI18n());
		betTypeEvent.setBetTypeEvent(cfgBetTypeEvent);
		return betTypeEvent;
	}

	/**
	 * Gets the valid match. Metodo que devuelve un RtMatch con todos los campos
	 * obligatorios rellenado para que pase las validaciones de @NotNull y @NotEmpty
	 * (si se le pasa participantes validos). De esta forma se puede jugar con
	 * los campos de RtMarket para ir probando las validaciones de
	 * MarketValidator.
	 * 
	 * @param market
	 *            the market
	 * @param longTerm
	 *            the long term
	 * @param participants
	 *            the participants
	 * @return the valid match
	 */
	private RtMatch getValidMatch(RtMarket market, Boolean longTerm,
			RtParticipant... participants) {

		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();

		CfgCompetitionEvent competitionEvent = new CfgCompetitionEvent();
		competitionEvent.setI18n(getValidI18n());
		LongTerm lt = new LongTerm();
		lt.setLongTerm(longTerm);
		competitionEvent.setLongTerm(lt);
		matchId.setCompetitionEvent(competitionEvent);

		CfgCompetition competition = new CfgCompetition("456");
		competition.setI18n(getValidI18n());

		CfgRegion region = new CfgRegion("45");
		region.setI18n(getValidI18n());
		competition.setRegion(region);

		CfgSport sport = new CfgSport(CfgSportId.FOOTBALL.id());
		sport.setI18n(getValidI18n());
		competition.setSport(sport);

		CoreDate coreDate = new CoreDate();
		coreDate.setProviderDate(new Date());
		coreDate.setZeroGmtMatchDate(new Date());
		coreDate.setProviderTimeZoneStr("GMT+0");
		coreDate.setZeroGmtMatchTimeZoneStr();

		match.setCoreActiveElement(new CoreActiveElement(true));
		match.setI18n(getValidI18n());
		matchId.setCompetition(competition);
		matchId.setStartDate(coreDate);
		for (RtParticipant part : participants) {
			matchId.addParticipiant(part);
		}
		match.setMatchId(matchId);
		match.add(market);

		match.getHashKey();

		return match;
	}

	/**
	 * Market with invalid number of bets test. Este mercado tiene sólo un RtBet
	 * aunque es de tipo Ganador Partido que necesita 2, 4, 6, 8, ... numero de
	 * bets. Debería fallar con la validacion de numero de bets del mercado.
	 */
	@Test
	public void marketWithInvalidNumberOfBetsTest() {

		RtMarket market = new RtMarket();

		// BETTYPE
		CfgBetType betType = new CfgBetType();
		betType.setI18n(getValidI18n());
		betType.setObjectId(new BigInteger("2"));
		betType.setNameId("Ganador_Partido");
		market.setBetType(betType);

		// BETTYPEEVENT
		RtBetTypeEvent betTypeEvent = getValidBetTypeEvent();
		market.setBetTypeEvent(betTypeEvent);

		// BETS sólo existe un bet (el del local)
		RtBet betLocal = new RtBet();
		betLocal.setBetType(betType);
		betLocal.setObjectId("123");

		// BETODDS este mercado tiene sólo un RtBet aunque es de tipo Ganador
		// Partido que necesita 2, 4, 6, 8, ... numero de bets.
		RtBetOdd rtBetOddLocal = new RtBetOdd();
		rtBetOddLocal.setOdds("5");
		betLocal.setBetOdd(rtBetOddLocal);

		// ATRIBUTOS
		RtGanadorPartidoAttribute attributeLocal = new RtGanadorPartidoAttribute();
		attributeLocal.setBetName("Ganador_Partido");
		attributeLocal.setResult(Result.ONE);
		attributeLocal.setWinnerName("Part1");
		betLocal.setAttribute(attributeLocal);

		// PARTICIPANTES
		RtParticipant participantLocal = new RtParticipant();
		CfgParticipant cfgParticipantLocal = new CfgParticipant("1");
		cfgParticipantLocal.setName("Part1");
		participantLocal.setAwayParticipant(false);
		participantLocal.setHomeParticipant(true);
		participantLocal.setCfgParticipant(cfgParticipantLocal);
		participantLocal.hashCode();
		betLocal.setParticipant(participantLocal);

		RtParticipant participantVisitante = new RtParticipant();
		CfgParticipant cfgParticipantVisitante = new CfgParticipant("2");
		cfgParticipantVisitante.setName("Part2");
		participantVisitante.setAwayParticipant(false);
		participantVisitante.setHomeParticipant(true);
		participantVisitante.setCfgParticipant(cfgParticipantVisitante);
		participantVisitante.hashCode();

		// BOOKMAKER
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setI18n(getValidI18n());
		bookmaker.setNameId("BetClick");
		bookmaker.setObjectId(new BigInteger("19"));
		betLocal.setBookmaker(bookmaker);

		market.add(betLocal);

		// HASHKEYS
		betLocal.getHashKey();
		market.getHashKey();

		RtMatch match = getValidMatch(market, false, participantLocal,
				participantVisitante);

		Set<ConstraintViolation<RtMatch>> constraintViolations;
		constraintViolations = validator.validate(match,
				CorrectMarketGroup.class);
		assertNotNull(constraintViolations);
		assertEquals(1, constraintViolations.size());

		for (ConstraintViolation<RtMatch> violation : constraintViolations) {
			assertEquals(
					"Mercado invalido: El tipo de apuesta : Ganador_Partido tiene un numero invalido de RtBet: 1",
					violation.getMessage());
		}

	}

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */

	@Override
	@Test
	public void test() {
		Set<ConstraintViolation<RtMarket>> constraintViolations;
		RtMarket market = new RtMarket();
		constraintViolations = validator.validate(market);
		assertNotNull(constraintViolations);
		// Los constraintViolations son:
		// betTypeEvent - no puede ser null
		// bets - no puede ser null
		// bets - lista de elementos incorrecta
		// betType - no puede ser null
		// hashKey - no puede estar vacío
		assertEquals(5, constraintViolations.size());
	}

	/**
	 * Valid market test.
	 */
	@Test
	public void validMarketTest() {

		RtMarket market = new RtMarket();

		// BETTYPE
		CfgBetType betType = new CfgBetType();
		betType.setI18n(getValidI18n());
		betType.setObjectId(CfgBetType.CfgBetTypeId.UNO_X_DOS_HANDICAP.id());
		betType.setNameId("1X2_Handicap");
		market.setBetType(betType);

		// BETTYPEEVENT
		RtBetTypeEvent betTypeEvent = getValidBetTypeEvent();
		market.setBetTypeEvent(betTypeEvent);

		// BETS
		RtBet betLocalHandicap1Bookmaker1 = new RtBet();
		betLocalHandicap1Bookmaker1.setBetType(betType);
		betLocalHandicap1Bookmaker1.setObjectId("123");

		RtBet betEmpateHandicap1Bookmaker1 = new RtBet();
		betEmpateHandicap1Bookmaker1.setBetType(betType);
		betEmpateHandicap1Bookmaker1.setObjectId("333");

		RtBet betVisitanteHandicap1Bookmaker1 = new RtBet();
		betVisitanteHandicap1Bookmaker1.setBetType(betType);
		betVisitanteHandicap1Bookmaker1.setObjectId("687");

		RtBet betLocalHandicap2Bookmaker1 = new RtBet();
		betLocalHandicap2Bookmaker1.setBetType(betType);
		betLocalHandicap2Bookmaker1.setObjectId("253");

		RtBet betEmpateHandicap2Bookmaker1 = new RtBet();
		betEmpateHandicap2Bookmaker1.setBetType(betType);
		betEmpateHandicap2Bookmaker1.setObjectId("777");

		RtBet betVisitanteHandicap2Bookmaker1 = new RtBet();
		betVisitanteHandicap2Bookmaker1.setBetType(betType);
		betVisitanteHandicap2Bookmaker1.setObjectId("888");

		RtBet betLocalHandicap1Bookmaker2 = new RtBet();
		betLocalHandicap1Bookmaker2.setBetType(betType);
		betLocalHandicap1Bookmaker2.setObjectId("573");

		RtBet betEmpateHandicap1Bookmaker2 = new RtBet();
		betEmpateHandicap1Bookmaker2.setBetType(betType);
		betEmpateHandicap1Bookmaker2.setObjectId("999");

		RtBet betVisitanteHandicap1Bookmaker2 = new RtBet();
		betVisitanteHandicap1Bookmaker2.setBetType(betType);
		betVisitanteHandicap1Bookmaker2.setObjectId("733");

		// BETODDS
		RtBetOdd rtBetOddLocalHandicap1Bookmaker1 = new RtBetOdd();
		rtBetOddLocalHandicap1Bookmaker1.setOdds("5");
		betLocalHandicap1Bookmaker1.setBetOdd(rtBetOddLocalHandicap1Bookmaker1);

		RtBetOdd rtBetOddEmpateHandicap1Bookmaker1 = new RtBetOdd();
		rtBetOddEmpateHandicap1Bookmaker1.setOdds("5");
		betEmpateHandicap1Bookmaker1
				.setBetOdd(rtBetOddEmpateHandicap1Bookmaker1);

		RtBetOdd rtBetOddVisitanteHandicap1Bookmaker1 = new RtBetOdd();
		rtBetOddVisitanteHandicap1Bookmaker1.setOdds("1.2");
		betVisitanteHandicap1Bookmaker1
				.setBetOdd(rtBetOddVisitanteHandicap1Bookmaker1);

		RtBetOdd rtBetOddLocalHandicap2Bookmaker1 = new RtBetOdd();
		rtBetOddLocalHandicap2Bookmaker1.setOdds("5");
		betLocalHandicap2Bookmaker1.setBetOdd(rtBetOddLocalHandicap2Bookmaker1);

		RtBetOdd rtBetOddEmpateHandicap2Bookmaker1 = new RtBetOdd();
		rtBetOddEmpateHandicap2Bookmaker1.setOdds("5");
		betEmpateHandicap2Bookmaker1
				.setBetOdd(rtBetOddEmpateHandicap2Bookmaker1);

		RtBetOdd rtBetOddVisitanteHandicap2Bookmaker1 = new RtBetOdd();
		rtBetOddVisitanteHandicap2Bookmaker1.setOdds("1.2");
		betVisitanteHandicap2Bookmaker1
				.setBetOdd(rtBetOddVisitanteHandicap2Bookmaker1);

		RtBetOdd rtBetOddLocalHandicap1Bookmaker2 = new RtBetOdd();
		rtBetOddLocalHandicap1Bookmaker2.setOdds("5");
		betLocalHandicap1Bookmaker2.setBetOdd(rtBetOddLocalHandicap1Bookmaker2);

		RtBetOdd rtBetOddEmpateHandicap1Bookmaker2 = new RtBetOdd();
		rtBetOddEmpateHandicap1Bookmaker2.setOdds("5");
		betEmpateHandicap1Bookmaker2
				.setBetOdd(rtBetOddEmpateHandicap1Bookmaker2);

		RtBetOdd rtBetOddVisitanteHandicap1Bookmaker2 = new RtBetOdd();
		rtBetOddVisitanteHandicap1Bookmaker2.setOdds("1.2");
		betVisitanteHandicap1Bookmaker2
				.setBetOdd(rtBetOddVisitanteHandicap1Bookmaker2);

		// ATTRIBUTOS
		Rt1X2HandicapAttribute attributeLocalHandicap1Bookmaker1 = new Rt1X2HandicapAttribute();
		attributeLocalHandicap1Bookmaker1.setBetName("1X2_Handicap");
		attributeLocalHandicap1Bookmaker1.setResult(Result.ONE);
		attributeLocalHandicap1Bookmaker1.setFinalValue(1.5);
		betLocalHandicap1Bookmaker1
				.setAttribute(attributeLocalHandicap1Bookmaker1);

		Rt1X2HandicapAttribute attributeEmpateHandicap1Bookmaker1 = new Rt1X2HandicapAttribute();
		attributeEmpateHandicap1Bookmaker1.setBetName("1X2_Handicap");
		attributeEmpateHandicap1Bookmaker1.setResult(Result.DRAW);
		attributeEmpateHandicap1Bookmaker1.setFinalValue(1.5);
		betEmpateHandicap1Bookmaker1
				.setAttribute(attributeEmpateHandicap1Bookmaker1);

		Rt1X2HandicapAttribute attributeVisitanteHandicap1Bookmaker1 = new Rt1X2HandicapAttribute();
		attributeVisitanteHandicap1Bookmaker1.setBetName("1X2_Handicap");
		attributeVisitanteHandicap1Bookmaker1.setResult(Result.TWO);
		attributeVisitanteHandicap1Bookmaker1.setFinalValue(1.5);
		betVisitanteHandicap1Bookmaker1
				.setAttribute(attributeVisitanteHandicap1Bookmaker1);

		Rt1X2HandicapAttribute attributeLocalHandicap2Bookmaker1 = new Rt1X2HandicapAttribute();
		attributeLocalHandicap2Bookmaker1.setBetName("1X2_Handicap");
		attributeLocalHandicap2Bookmaker1.setResult(Result.ONE);
		attributeLocalHandicap2Bookmaker1.setFinalValue(2.5);
		betLocalHandicap2Bookmaker1
				.setAttribute(attributeLocalHandicap2Bookmaker1);

		Rt1X2HandicapAttribute attributeEmpateHandicap2Bookmaker1 = new Rt1X2HandicapAttribute();
		attributeEmpateHandicap2Bookmaker1.setBetName("1X2_Handicap");
		attributeEmpateHandicap2Bookmaker1.setResult(Result.DRAW);
		attributeEmpateHandicap2Bookmaker1.setFinalValue(2.5);
		betEmpateHandicap2Bookmaker1
				.setAttribute(attributeEmpateHandicap2Bookmaker1);

		Rt1X2HandicapAttribute attributeVisitanteHandicap2Bookmaker1 = new Rt1X2HandicapAttribute();
		attributeVisitanteHandicap2Bookmaker1.setBetName("1X2_Handicap");
		attributeVisitanteHandicap2Bookmaker1.setResult(Result.TWO);
		attributeVisitanteHandicap2Bookmaker1.setFinalValue(2.5);
		betVisitanteHandicap2Bookmaker1
				.setAttribute(attributeVisitanteHandicap2Bookmaker1);

		Rt1X2HandicapAttribute attributeLocalHandicap1Bookmaker2 = new Rt1X2HandicapAttribute();
		attributeLocalHandicap1Bookmaker2.setBetName("1X2_Handicap");
		attributeLocalHandicap1Bookmaker2.setResult(Result.ONE);
		attributeLocalHandicap1Bookmaker2.setFinalValue(3.5);
		betLocalHandicap1Bookmaker2
				.setAttribute(attributeLocalHandicap1Bookmaker2);

		Rt1X2HandicapAttribute attributeEmpateHandicap1Bookmaker2 = new Rt1X2HandicapAttribute();
		attributeEmpateHandicap1Bookmaker2.setBetName("1X2_Handicap");
		attributeEmpateHandicap1Bookmaker2.setResult(Result.DRAW);
		attributeEmpateHandicap1Bookmaker2.setFinalValue(3.5);
		betEmpateHandicap1Bookmaker2
				.setAttribute(attributeEmpateHandicap1Bookmaker2);

		Rt1X2HandicapAttribute attributeVisitanteHandicap1Bookmaker2 = new Rt1X2HandicapAttribute();
		attributeVisitanteHandicap1Bookmaker2.setBetName("1X2_Handicap");
		attributeVisitanteHandicap1Bookmaker2.setResult(Result.TWO);
		attributeVisitanteHandicap1Bookmaker2.setFinalValue(3.5);
		betVisitanteHandicap1Bookmaker2
				.setAttribute(attributeVisitanteHandicap1Bookmaker2);

		// PARTICIPANTES
		RtParticipant participantLocal = new RtParticipant();
		CfgParticipant cfgParticipantLocal = new CfgParticipant("1");
		cfgParticipantLocal.setName("Part1");
		participantLocal.setAwayParticipant(false);
		participantLocal.setHomeParticipant(true);
		participantLocal.setCfgParticipant(cfgParticipantLocal);
		participantLocal.hashCode();
		betLocalHandicap1Bookmaker1.setParticipant(participantLocal);
		betLocalHandicap2Bookmaker1.setParticipant(participantLocal);
		betLocalHandicap1Bookmaker2.setParticipant(participantLocal);

		RtParticipant participantVisitante = new RtParticipant();
		CfgParticipant cfgParticipantVisitante = new CfgParticipant("2");
		cfgParticipantVisitante.setName("Part2");
		participantVisitante.setAwayParticipant(false);
		participantVisitante.setHomeParticipant(true);
		participantVisitante.setCfgParticipant(cfgParticipantVisitante);
		participantVisitante.hashCode();
		betVisitanteHandicap1Bookmaker1.setParticipant(participantVisitante);
		betVisitanteHandicap2Bookmaker1.setParticipant(participantVisitante);
		betVisitanteHandicap1Bookmaker2.setParticipant(participantVisitante);

		RtParticipant participantEmpate = new RtParticipant();
		CfgParticipant cfgParticipantEmpate = new CfgParticipant("3");
		participantEmpate.setAwayParticipant(false);
		participantEmpate.setHomeParticipant(false);
		participantEmpate.setCfgParticipant(cfgParticipantEmpate);
		participantEmpate.hashCode();
		betEmpateHandicap1Bookmaker1.setParticipant(participantEmpate);
		betEmpateHandicap2Bookmaker1.setParticipant(participantEmpate);
		betEmpateHandicap1Bookmaker2.setParticipant(participantEmpate);

		// BOOKMAKER
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setI18n(getValidI18n());
		bookmaker.setNameId("BetClick");
		bookmaker.setObjectId(new BigInteger("19"));
		betLocalHandicap1Bookmaker1.setBookmaker(bookmaker);
		betEmpateHandicap1Bookmaker1.setBookmaker(bookmaker);
		betVisitanteHandicap1Bookmaker1.setBookmaker(bookmaker);
		betLocalHandicap2Bookmaker1.setBookmaker(bookmaker);
		betEmpateHandicap2Bookmaker1.setBookmaker(bookmaker);
		betVisitanteHandicap2Bookmaker1.setBookmaker(bookmaker);

		CfgBookmaker bookmaker2 = new CfgBookmaker();
		bookmaker2.setI18n(getValidI18n());
		bookmaker2.setNameId("BetOnline");
		bookmaker2.setObjectId(new BigInteger("33"));
		betLocalHandicap1Bookmaker2.setBookmaker(bookmaker2);
		betEmpateHandicap1Bookmaker2.setBookmaker(bookmaker2);
		betVisitanteHandicap1Bookmaker2.setBookmaker(bookmaker2);

		market.add(betLocalHandicap1Bookmaker1);
		market.add(betEmpateHandicap1Bookmaker1);
		market.add(betVisitanteHandicap1Bookmaker1);
		market.add(betLocalHandicap2Bookmaker1);
		market.add(betEmpateHandicap2Bookmaker1);
		market.add(betVisitanteHandicap2Bookmaker1);
		market.add(betLocalHandicap1Bookmaker2);
		market.add(betEmpateHandicap1Bookmaker2);
		market.add(betVisitanteHandicap1Bookmaker2);

		// HASHKEYS
		betLocalHandicap1Bookmaker1.getHashKey();
		betEmpateHandicap1Bookmaker1.getHashKey();
		betVisitanteHandicap1Bookmaker1.getHashKey();
		betLocalHandicap2Bookmaker1.getHashKey();
		betEmpateHandicap2Bookmaker1.getHashKey();
		betVisitanteHandicap2Bookmaker1.getHashKey();
		betLocalHandicap1Bookmaker2.getHashKey();
		betEmpateHandicap1Bookmaker2.getHashKey();
		betVisitanteHandicap1Bookmaker2.getHashKey();
		market.getHashKey();

		RtMatch match = getValidMatch(market, false, participantLocal,
				participantVisitante);

		Set<ConstraintViolation<RtMatch>> constraintViolations;
		constraintViolations = validator.validate(match,
				CorrectMarketGroup.class);
		assertNotNull(constraintViolations);
		assertEquals(0, constraintViolations.size());

	}

}
