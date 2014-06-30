/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;

/**
 * The Class SecureBetCalculateWriterTest.
 */
public final class SecureBetCalculateWriterTest extends AbstractTest {

	/** The secure bet calculate writer. */
	@Inject
	private SureBetWriter<SureBetsMatch> secureBetCalculateWriter;

	/**
	 * Without secure bet test.
	 */
	@Test
	public final void withoutSecureBetTest() {
		SureBetsMatch calculateSecureBetBean = new SureBetsMatch();
		List<SureBetsMarket> secureBetBeans = new ArrayList<SureBetsMarket>();
		SureBetsMarket secureBetBean;

		secureBetBean = new SureBetsMarket();
		secureBetBean.setBetType(new CfgBetType());
		secureBetBean.setBetTypeEvent(new RtBetTypeEvent());
		secureBetBean.setMatch(createMatch("Real Madrid CF", "1", new Date(),
				"1010"));
		secureBetBean.setModificationDate(new CoreDate());
		secureBetBean.setCreateDate(new CoreDate());

		secureBetBeans.add(secureBetBean);

		calculateSecureBetBean.setSureBetsMarket(secureBetBeans);
		secureBetCalculateWriter.write(calculateSecureBetBean);
	}

	private RtMatch createMatch(String nameMatch, String idCompetition,
			Date date, String idMatch) {
		RtMatch match = new RtMatch();
		match.setName(nameMatch);
		match.setCompetition(new CfgCompetition(idCompetition));
		match.setMatchId(new RtMatchId());
		CoreDate coreDate = new CoreDate();
		coreDate.setZeroGmtMatchDate(date);
		match.getMatchId().setStartDate(coreDate);
		match.setObjectId(new BigInteger(idMatch));
		return match;
	}

	/**
	 * With secure bet test.
	 */
	public final void withSecureBetTest() {
		SureBetsMatch calculateSecureBetBean = new SureBetsMatch();
		List<SureBetsMarket> secureBetBeans = new ArrayList<SureBetsMarket>();
		Map<SecureBeanBenefit, List<RtBet>> secureBetAgrupation;
		SureBetsMarket secureBetBean;

		secureBetBean = new SureBetsMarket();
		secureBetAgrupation = new HashMap<SecureBeanBenefit, List<RtBet>>();
		List<RtBet> rtBets = new ArrayList<RtBet>();

		secureBetBean.setBetType(new CfgBetType());
		secureBetBean.setBetTypeEvent(new RtBetTypeEvent());
		secureBetBean.setMatch(new RtMatch());
		secureBetBean.setModificationDate(new CoreDate());
		secureBetBean.setCreateDate(new CoreDate());

		rtBets.add(new RtBet());

		secureBetAgrupation.put(new SecureBeanBenefit(), rtBets);

		secureBetBean.setSecureBetAgrupation(secureBetAgrupation);

		secureBetBeans.add(secureBetBean);

		calculateSecureBetBean.setSureBetsMarket(secureBetBeans);
		secureBetCalculateWriter.write(calculateSecureBetBean);
	}

	@Test
	public final void roundBenefitTest() {

		Assert.assertEquals(new Double("1.36"), (secureBetCalculateWriter
				.roundBenefit(new Double("1.363956"), 2)).getValue());
	}
}
