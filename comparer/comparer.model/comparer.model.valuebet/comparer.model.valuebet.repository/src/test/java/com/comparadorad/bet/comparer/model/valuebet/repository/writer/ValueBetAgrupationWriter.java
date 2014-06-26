/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.repository.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.bet.bean.RtWebUrl;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetMathematicalExpectation;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetProbability;

/**
 * The Class ValueBetAgrupationWriter.
 */
public class ValueBetAgrupationWriter extends
		AbstractWriterXML<List<ValueBetData>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML
	 * #isExtended()
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Gets the bet.
	 * 
	 * @param value
	 *            the value
	 * @return the bet
	 */
	private RtBet getBet(String value) {
		RtBet bet = new RtBet();
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setObjectId(new BigInteger("19"));
		bet.setBookmaker(bookmaker);
		RtBetOdd betOdd = new RtBetOdd();
		betOdd.setOdds(value);
		betOdd.setFraOdds(value);
		betOdd.setAmericanOdds(value);
		bet.setBetOdd(betOdd);
		RtParticipant participant = new RtParticipant();
		participant.setAwayParticipant(false);
		participant.setHomeParticipant(true);
		bet.setParticipant(participant);
		Rt1X2Attribute attribute = new Rt1X2Attribute();
		attribute.setResult(Result.TWO);
		attribute.setBetName("1X2");
		bet.setAttribute(attribute);
		RtWebUrl webUrl = new RtWebUrl();
		webUrl.setUrl("http://www.BetClick.com");
		bet.setWebUrl(webUrl);
		CfgBetType betType = new CfgBetType();
		betType.setObjectId(new BigInteger("1"));
		bet.setBetType(betType);
		return bet;
	}

	/**
	 * Gets the match.
	 * 
	 * @param pId
	 *            the id
	 * @return the match
	 */
	private InfoMatch getMatch(String pId) {
		InfoMatch match = new InfoMatch();
		match.setObjectId(new BigInteger(pId));
		match.setDate(new Date(new Date().getTime() - 86400000l));
		match.setName(getI18n("Atletico de Madrid Vs Malaga"));
		match.setCompetition(getCompetition("La liga", new BigInteger("1"),
				new BigInteger("870865763"), new BigInteger("724")));
		return match;
	}

	/**
	 * Gets the competition.
	 * 
	 * @param name
	 *            the name
	 * @param idSport
	 *            the id sport
	 * @param idCompetition
	 *            the id competition
	 * @param idRegion
	 *            the id region
	 * @return the competition
	 */
	private CfgCompetition getCompetition(String name, BigInteger idSport,
			BigInteger idCompetition, BigInteger idRegion) {
		CfgCompetition competition = new CfgCompetition();
		competition.setName(name);
		competition.setSport(new CfgSport(idSport));
		competition.setRegion(new CfgRegion(idRegion));
		competition.setObjectId(idCompetition);
		return competition;
	}

	/**
	 * Gets the i18n.
	 * 
	 * @param name
	 *            the name
	 * @return the i18n
	 */
	private I18n getI18n(String name) {
		I18n i18n = new I18n();
		Set<I18nField> i18nFields = new HashSet<I18nField>();
		I18nField field = new I18nField();
		field.setString(name);
		i18nFields.add(field);
		i18n.setI18nFields(i18nFields);
		return i18n;
	}

	/**
	 * Gets the expectation.
	 * 
	 * @param value
	 *            the value
	 * @return the expectation
	 */
	private ValueBetMathematicalExpectation getExpectation(String value) {
		ValueBetMathematicalExpectation expectation = new ValueBetMathematicalExpectation();
		expectation.setValue(new Double(value));
		return expectation;
	}

	/**
	 * Gets the probability.
	 * 
	 * @param value
	 *            the value
	 * @return the probability
	 */
	private ValueBetProbability getProbability(String value) {
		ValueBetProbability probability = new ValueBetProbability();
		probability.setValue(new Double(value));
		return probability;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML
	 * #makeObject()
	 */
	@Override
	protected List<ValueBetData> makeObject() {
		List<ValueBetData> result;
		ValueBetData valueBetData;

		result = new ArrayList<ValueBetData>();

		valueBetData = new ValueBetData();
		valueBetData.setInfoMatch(getMatch("21229"));
		valueBetData.setBet(getBet("5.5"));
		valueBetData.setExpectation(getExpectation("1.1"));
		valueBetData.setProbability(getProbability("2.2"));
		RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
		betTypeEvent.setObjectId(new BigInteger("1"));
		valueBetData.setBetTypeEvent(betTypeEvent);

		result.add(valueBetData);

		valueBetData = new ValueBetData();
		valueBetData.setInfoMatch(getMatch("21212"));
		valueBetData.setBet(getBet("5.5"));
		valueBetData.setExpectation(getExpectation("1.1"));
		valueBetData.setProbability(getProbability("2.2"));
		betTypeEvent = new RtBetTypeEvent();
		betTypeEvent.setObjectId(new BigInteger("1"));
		valueBetData.setBetTypeEvent(betTypeEvent);

		result.add(valueBetData);

		valueBetData = new ValueBetData();
		valueBetData.setInfoMatch(getMatch("3225"));
		valueBetData.setBet(getBet("5.5"));
		valueBetData.setExpectation(getExpectation("1.1"));
		valueBetData.setProbability(getProbability("2.2"));
		betTypeEvent = new RtBetTypeEvent();
		betTypeEvent.setObjectId(new BigInteger("1"));
		valueBetData.setBetTypeEvent(betTypeEvent);

		result.add(valueBetData);

		valueBetData = new ValueBetData();
		valueBetData.setInfoMatch(getMatch("3224"));
		valueBetData.setBet(getBet("5.5"));
		valueBetData.setExpectation(getExpectation("1.1"));
		valueBetData.setProbability(getProbability("2.2"));
		betTypeEvent = new RtBetTypeEvent();
		betTypeEvent.setObjectId(new BigInteger("1"));
		valueBetData.setBetTypeEvent(betTypeEvent);

		result.add(valueBetData);

		return result;
	}

}
