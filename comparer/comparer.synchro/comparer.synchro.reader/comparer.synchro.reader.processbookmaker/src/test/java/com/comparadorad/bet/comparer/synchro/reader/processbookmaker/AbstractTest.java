/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.config.SynchroReaderProcessConfig;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.util.TestUtil;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl.IXmlToRtMatchResolver;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroReaderProcessConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

	/** The match resolver. */
	@Inject
	private IXmlToRtMatchResolver matchResolver;
	
	/** The tournament. */
	protected XmlTournament tournament = new XmlTournament("Liga Primera");
	
	/**
	 * Test.
	 */
	@Test
	public abstract void test();
	
	protected CfgBookmaker setBookmaker() {
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		cfgBookmaker.setObjectId(CfgBookmakerId.BETCLIC_COM_ID.objectId());
		CfgBookmakerConfiguration cfgBookmakerConfiguration = new CfgBookmakerConfiguration();
		CfgBookmakerWebUrl urls = new CfgBookmakerWebUrl();
		urls.setUrl("http://www.url.com");
		cfgBookmakerConfiguration.addBookmakerWebUrl(urls);
		CfgBookmakerDataUrl urlsData = new CfgBookmakerDataUrl();
		urlsData.setUrl("http://www.url.com");
		cfgBookmakerConfiguration.addBookmakerDataUrl(urlsData);
		cfgBookmaker.setBookmakerConfiguration(cfgBookmakerConfiguration);
		CfgBookmakerXmlReader bookmakerXmlReader = new CfgBookmakerXmlReader();
		
		bookmakerXmlReader.setXmlMarketBetEnabled(false);
		cfgBookmaker.setBookmakerXmlReader(bookmakerXmlReader);
		
		return cfgBookmaker;
	}
	

	protected RtMatch getRtMatch() throws BetBySportNotAllowedException {
		CfgBookmaker cfgBookmaker = this.setBookmaker();
		TestUtil util = new TestUtil();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		resolverData.setBetsNumber(2);
		XmlMatch xmlMatch = util.readXmlMatchFile("resolverMarketAndBet");
		XmlTournament torneo = new XmlTournament("Primera Liga");
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.GANADOR);
			//Añado atributos de apuesta a las apuestas.
			for (XmlMarketBet bet : market.getXmlMarketBets()) {
				XmlWinnerAttribute atributo = new XmlWinnerAttribute();
				atributo.setWinner(new XmlMatchParticipant("Ganador", torneo));
				bet.setXmlAttribute(atributo);
				bet.setXmlMatchParticipant(new XmlMatchParticipant("Real Madrid", torneo));
			}
		}
		

		xmlMatch.setStartDate(new XmlDate(new Date(), "GMT", new Date()));
		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		
		
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		xmlMatch.getXmlTournament().setXmlSport(deporte);

		lista.add(new XmlMatchParticipant("Real Madrid", torneo));
		lista.add(new XmlMatchParticipant("Barcelona", torneo));

		xmlMatch.setXmlMatchParticipants(lista);
		
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		RtMatch rtMatch = matchResolver.resolve(xmlMatch,null, resolverData);
		
		return rtMatch;
		
	}
}
