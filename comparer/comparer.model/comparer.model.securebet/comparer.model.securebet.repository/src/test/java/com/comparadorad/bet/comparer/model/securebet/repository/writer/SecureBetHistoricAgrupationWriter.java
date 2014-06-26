package com.comparadorad.bet.comparer.model.securebet.repository.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;

public class SecureBetHistoricAgrupationWriter extends
		AbstractWriterXML<List<SecureBeanHistoricData>> {

	@Override
	protected boolean isExtended() {
		return false;
	}

	@Override
	protected List<SecureBeanHistoricData> makeObject() {
		List<SecureBeanHistoricData> result;
		SecureBeanHistoricData secureBeanHistoricData;

		result = new ArrayList<SecureBeanHistoricData>();
		secureBeanHistoricData = new SecureBeanHistoricData();
		InfoMatch match = new InfoMatch();
		match.setDate(new Date());
		match.setObjectId(new BigInteger("1001"));
		CoreDate coreDate = new CoreDate();
		RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
		CfgBetType betType = new CfgBetType();
		betType.setObjectId("7");

		Set<RtBet> setBets = new HashSet<RtBet>();

		RtBet rtBet = new RtBet();
		RtBetOdd betOdd = new RtBetOdd();
		betOdd.setOdds("1.5");
		rtBet.setBetOdd(betOdd);
		rtBet.setAttribute(new Rt1X2Attribute());
		rtBet.setBetType(betType);
		rtBet.setHashKey("bbb");
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setObjectId(new BigInteger("105"));
		rtBet.setBookmaker(bookmaker);
		setBets.add(rtBet);

		rtBet = new RtBet();
		betOdd = new RtBetOdd();
		betOdd.setOdds("2.5");
		rtBet.setBetOdd(betOdd);
		rtBet.setAttribute(new Rt1X2Attribute());

		rtBet.setBetType(betType);
		rtBet.setHashKey("ccc");
		bookmaker = new CfgBookmaker();
		bookmaker.setObjectId(new BigInteger("33"));
		rtBet.setBookmaker(bookmaker);
		setBets.add(rtBet);

		rtBet = new RtBet();
		betOdd = new RtBetOdd();
		betOdd.setOdds("1.75");
		rtBet.setBetOdd(betOdd);
		rtBet.setAttribute(new Rt1X2Attribute());
		rtBet.setBetType(betType);
		rtBet.setHashKey("aaa");
		bookmaker = new CfgBookmaker();
		bookmaker.setObjectId(new BigInteger("43"));
		rtBet.setBookmaker(bookmaker);
		setBets.add(rtBet);

		secureBeanHistoricData.setBenefit(new SecureBeanBenefit(new Double(
				"6.5")));
		secureBeanHistoricData.setBets(setBets);
		secureBeanHistoricData.setBetType(betType);
		secureBeanHistoricData.setInfoMatch(match);
		secureBeanHistoricData.setCreateDate(coreDate);
		secureBeanHistoricData.setBetTypeEvent(betTypeEvent);
		secureBeanHistoricData.setNameId("Real Madrid CF");
		secureBeanHistoricData.setObjectId("1");

		result.add(secureBeanHistoricData);

		return result;
	}

}
