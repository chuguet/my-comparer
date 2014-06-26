/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;

/**
 * The Class XmlMatchWriter.
 */
public class XmlMatchWriter extends AbstractWriterXML<List<XmlMatch>> {

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<XmlMatch> makeObject() {
		List<XmlMatch> result = new ArrayList<XmlMatch>();
		Set<XmlMatchParticipant> setXmlMatchParticipant = new HashSet<XmlMatchParticipant>();
		XmlMatch xmlMatch = new XmlMatch();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		XmlTournament xmlTournament = new XmlTournament();
		XmlMarket xmlMarket = new XmlMarket();
		XmlMarketBet xmlMarketBet = new XmlMarketBet();
		XmlMatchParticipant xmlMatchParticipant = new XmlMatchParticipant();
		XmlBetType xmlBetType = new XmlBetType();
		XmlMarketBetOdd betOdd = new XmlMarketBetOdd("1", "1/5", "1.5");

		BmInternalId bmInternalId = new BmInternalId("1");
		cfgBookmaker.setObjectId(BigInteger.ONE);
		xmlMatchParticipant.setName("F.C. Barcelona");
		setXmlMatchParticipant.add(xmlMatchParticipant);

		xmlTournament.setName("Euro 2012");
		xmlMatch.setXmlTournament(xmlTournament);
		xmlMatch.setXmlMatchParticipants(setXmlMatchParticipant);
		xmlMatch.setBmInternalId(bmInternalId);
		xmlBetType.setName("Win-Win");
		xmlMarket.setXmlBetType(xmlBetType);
		xmlMarketBet.setName("Win-Win");
		xmlMarketBet.setXmlMarketBetOdd(betOdd);
		xmlMarket.addXmlBet(xmlMarketBet);

		xmlMatch.addXmlMarket(xmlMarket);

		result.add(xmlMatch);
		return result;
	}

}
