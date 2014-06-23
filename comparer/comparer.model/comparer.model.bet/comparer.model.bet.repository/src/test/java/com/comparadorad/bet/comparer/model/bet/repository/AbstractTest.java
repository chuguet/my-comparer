package com.comparadorad.bet.comparer.model.bet.repository;

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
import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfig;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BetRepositoryConfig.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST })
public abstract class AbstractTest {

	protected RtMatch createMatch(String competitionId) {
		RtMatch match = new RtMatch();

		Date date = new Date(new Date().getTime() + 65198718974l);
		CoreDate coreDate = new CoreDate();
		coreDate.setZeroGmtMatchDate(date);
		CoreActiveElement coreActiveElement = new CoreActiveElement(
				Boolean.TRUE);
		CfgCompetition competition = new CfgCompetition(competitionId);

		RtMatchId matchId = new RtMatchId();
		Set<RtParticipant> participantes = new HashSet<RtParticipant>();
		RtParticipant participante = new RtParticipant();
		CfgParticipant part1 = new CfgParticipant("1");
		participante.setName("participante");
		participante.setHomeParticipant(true);
		participante.setAwayParticipant(false);
		participante.setCfgParticipant(part1);
		RtParticipant participante1 = new RtParticipant();
		CfgParticipant part2 = new CfgParticipant("2");
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
		match.setCoreActiveElement(coreActiveElement);
		match.setName("Partido", null);
		match.setMatchId(matchId);

		return match;
	}

}
