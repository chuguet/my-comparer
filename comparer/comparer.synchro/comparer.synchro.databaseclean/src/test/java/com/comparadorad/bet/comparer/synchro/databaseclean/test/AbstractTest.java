/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.databaseclean.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.synchro.databaseclean.config.SpringDatabaseCleanConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringDatabaseCleanConfiguration.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

	protected RtMatch createMatch(String competitionId, Date date) {
		RtMatch match = new RtMatch();

		CoreDate coreDate = new CoreDate();
		coreDate.setZeroGmtMatchDate(date);
		CoreActiveElement coreActiveElement = new CoreActiveElement(
				Boolean.TRUE);
		CfgCompetition competition = new CfgCompetition(competitionId);

		RtMatchId matchId = new RtMatchId();
		Set<RtParticipant> participantes = new HashSet<RtParticipant>();
		RtParticipant participante = new RtParticipant();
		CfgParticipant part1 = new CfgParticipant("11");
		participante.setName("participante");
		participante.setHomeParticipant(true);
		participante.setAwayParticipant(false);
		participante.setCfgParticipant(part1);
		RtParticipant participante1 = new RtParticipant();
		CfgParticipant part2 = new CfgParticipant("12");
		participante1.setHomeParticipant(false);
		participante1.setAwayParticipant(true);
		participante1.setName("participante1");
		participante1.setCfgParticipant(part2);
		participantes.add(participante);
		participantes.add(participante1);
		matchId.setParticipiants(participantes);
		matchId.setStartDate(coreDate);
		CfgCompetitionEvent event = new CfgCompetitionEvent();
		event.setObjectId("1");
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		matchId.setCompetitionEvent(event);

		match.setStartDate(coreDate);
		matchId.setCompetition(competition);
		match.setCompetition(competition);
		match.setCoreActiveElement(coreActiveElement);
		match.setMatchId(matchId);
		match.setName("Partido", null);

		return match;
	}

}
