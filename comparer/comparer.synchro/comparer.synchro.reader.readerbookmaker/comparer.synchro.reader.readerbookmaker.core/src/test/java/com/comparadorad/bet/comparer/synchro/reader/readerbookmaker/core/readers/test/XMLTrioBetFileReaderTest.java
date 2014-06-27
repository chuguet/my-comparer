/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.util.Assert;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.triobet.XMLTrioBetFileReader;

/**
 * The Class XMLTrioBetFileReaderTest.
 */
public class XMLTrioBetFileReaderTest extends AbstractTest {

	private static final String TB_XML_LOCATION_GANADOR_BAD = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\triobet_ganadorBad.xml";

	/** The trio reader. */
	@Inject
	private XMLTrioBetFileReader trioReader;

	/**
	 * Gets the bookmaker id test.
	 * 
	 * @return the bookmaker id test
	 */
	@Test
	public void getBookmakerIdTest() {
		assertNotNull(trioReader.getBookmakerId());
		assertEquals(trioReader.getBookmakerId(), CfgBookmakerId.TRIOBET_COM_ID
				.objectId().toString());
	}

	/**
	 * Trio bet read test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void trioBetReadTest() throws Exception {
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone(TRIOBET_TIMEZONE);
		XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(TRIO_READER,
				TB_XML_LOCATION, bookmakerConfiguration, null);
		Collection<XmlMatch> result = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(result.size() > 0);
		for (XmlMatch game : result) {
			for (XmlMatchParticipant participant : game
					.getXmlMatchParticipants()) {
				if (participant.getName().equals("Besiktas")) {
					assertEquals(participant.getXmlTournament().getName(),
							"Turkey TBL");
					assertTrue(participant.isHomeParticipant());
					assertEquals(game.getXmlMarkets().size(), 3);
				}
			}
		}

		// Competicion sin participantes
		xmlrBetFileReaderResult = readXML(TRIO_READER,
				TB_XML_LOCATION_GANADOR_BAD, bookmakerConfiguration, null);
		Collection<XmlMatch> resultNoParticipants = xmlrBetFileReaderResult
				.getXmlBookmakerEvents().getXmlMatchs();
		Assert.isTrue(resultNoParticipants.size() == 0);

	}

}
