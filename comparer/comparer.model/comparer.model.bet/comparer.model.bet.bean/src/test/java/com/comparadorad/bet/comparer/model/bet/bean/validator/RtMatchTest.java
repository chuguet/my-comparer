/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.validator;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractBetBeanTest;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
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
import com.comparadorad.bet.comparer.model.config.bean.CfgResource;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;

/**
 * The Class RtMatchTest.
 */
public class RtMatchTest extends AbstractBetBeanTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtMatchTest.class);

	/** The validator. */
	@Inject
	private Validator validator;

	/**
	 * Creates the match.
	 */
	@Test
	public final void createMatch() {
		LOG.debug("Inicio creacion");
		System.out.println(System.currentTimeMillis());
		for (int i = 0; i < 200; i++) {
			RtMatch match = new RtMatch();

			// NOMBRE
			I18n i18N = new I18n();
			Set<I18nField> i18fields = new HashSet<I18nField>();
			for (int j = 0; j < 3; j++) {
				i18fields.add(new I18nField("Spain", new Locale("Sp", "ES")));
			}
			i18N.setI18nFields(i18fields);
			match.setI18n(i18N);

			// FECHA
			CoreDate coreDate = new CoreDate();
			coreDate.setProviderDate(new Date());
			coreDate.setZeroGmtMatchDate(new Date());
			coreDate.setProviderTimeZoneStr("GMT+0");
			coreDate.setZeroGmtMatchTimeZoneStr();
			match.setStartDate(coreDate);

			// COMPETICION
			CfgCompetition competition = new CfgCompetition();
			match.setCompetition(competition);

			// MATCHID
			RtMatchId matchId = new RtMatchId();
			match.setMatchId(matchId);

			// PARTICIPANTES
			for (int k = 0; k < 20; k++) {
				RtParticipant participant = new RtParticipant();
				participant.setAwayParticipant(false);
				participant.setHomeParticipant(false);
				participant.setName("Yo");
				matchId.addParticipiant(participant);
			}

			// CompetitionEvent
			CfgCompetitionEvent competitionEvent = new CfgCompetitionEvent();
			competitionEvent.setI18n(i18N);
			matchId.setCompetitionEvent(competitionEvent);

			for (int l = 0; l < 5; l++) {
				RtMarket market = new RtMarket();
				CfgBetType betType = new CfgBetType();
				betType.setName("1x2");
				betType.setI18n(i18N);
				betType.setObjectId(new BigInteger("654"));
				betType.setNameId("1x2");
				market.setBetType(betType);

				RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
				betTypeEvent.setNameId("1x2");
				betTypeEvent.setObjectId(new BigInteger("654"));
				CfgBetTypeEvent cfgBetTypeEvent = new CfgBetTypeEvent();
				cfgBetTypeEvent.setBetType(betType);
				cfgBetTypeEvent.setI18n(i18N);
				betTypeEvent.setBetTypeEvent(cfgBetTypeEvent);
				market.setBetTypeEvent(betTypeEvent);

				for (int u = 0; u < 50; u++) {

					RtBet bet = new RtBet();
					RtBetOdd rtBetOdd = new RtBetOdd();
					rtBetOdd.setBet(bet);
					rtBetOdd.setOdds("1.1");
					rtBetOdd.setFraOdds("1.1");
					rtBetOdd.setAmericanOdds("1.1");
					bet.add(rtBetOdd);

					RtAsianHandicapAttribute attribute = new RtAsianHandicapAttribute();
					attribute.setBetName("awef");
					attribute.setFirstValue(new Double(654));
					attribute.setSecondValue(new Double(123));
					attribute.setAsianResult(AsianResult.ONE);
					bet.setAttribute(attribute);

					bet.setBetType(betType);
					bet.setCoreDate(coreDate);
					bet.setMarket(market);
					bet.setName("hola");
					bet.setNameId("adios");

					RtParticipant participant = new RtParticipant();
					participant.setAwayParticipant(false);
					participant.setHomeParticipant(false);
					participant.setName("Yo");
					matchId.addParticipiant(participant);
					bet.setParticipant(participant);
					bet.setObjectId("123");
					bet.setStartDate(coreDate);
					CfgBookmaker bookmaker = new CfgBookmaker();
					bookmaker.setI18n(i18N);
					bookmaker.setName("sdf");
					bookmaker.setObjectId(new BigInteger("1231"));
					CfgResource resource = new CfgResource();
					resource.setHeight(123);
					resource.setI18n(i18N);
					resource.setLocation("wevwe");
					bookmaker.setResource(resource);
					bet.setBookmaker(bookmaker);

					market.add(bet);
				}

				match.add(market);
			}

			LOG.debug("Fin creacion");
		}
		System.out.println(System.currentTimeMillis());
	}

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */

	@Test
	public final void test() {
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtParticipant participant = new RtParticipant();
		CfgParticipant cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(new BigInteger("123"));
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);
		match.setMatchId(matchId);
		I18n i18n = new I18n();
		i18n.addI18nField(new I18nField("nombre", Locale.ENGLISH));
		match.setI18n(i18n);
		Set<ConstraintViolation<RtMatch>> constraintViolations;
		constraintViolations = validator.validate(match);
		assertNotNull(constraintViolations);
		// assertEquals(10, constraintViolations.size());

		LOG.info("Violaciones de validacion: " + constraintViolations.size());

	}

}
