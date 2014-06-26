/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.ObjectState.ObjectStateEnum;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.exception.CfgFromXmlCreatorException;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppConfig;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppTestConfig;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class CfgCompetitionCreatorTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SynchroReaderDataAppConfig.class, SynchroReaderDataAppTestConfig.class })
@ActiveProfiles(value = { ProfileConstant.TEST, ProfileConstant.TEST_NO_JOB_EXECUTION })
public class CfgParticipantCreatorTest extends AbstractCreatorTest {

	/** The cfg competition creator. */
	@Inject
	private CfgParticipantCreator cfgParticipantCreator;

	/**
	 * Test.
	 * 
	 * @throws CfgFromXmlCreatorException
	 *             the cfg from xml creator exception
	 */
	@Test
	public void test() throws CfgFromXmlCreatorException {

		XmlSport sport = new XmlSport("Tenis");
		XmlTournament tournament = new XmlTournament();
		tournament.setCfgObjectId(new BigInteger("30000"));
		tournament.setXmlSport(sport);
		XmlMatchParticipant matchParticipant = new XmlMatchParticipant("R Federer", tournament);

		CfgCreatorData<CfgParticipant, CfgParticipantSynonyms> creatorData = cfgParticipantCreator.create(matchParticipant, getBookmaker(),
				null);
		assertNotNull(creatorData);
		assertTrue(creatorData.getModelData().getObjectState().getObjectState().equals(ObjectStateEnum.NOT_MODIFIED));
	}

	/**
	 * Test nuevo participante.
	 * 
	 * @throws CfgFromXmlCreatorException
	 *             the cfg from xml creator exception
	 */
	@Test
	public void testNuevoParticipante() throws CfgFromXmlCreatorException {

		XmlTournament tournament = new XmlTournament();
		tournament.setCfgObjectId(new BigInteger("30000"));
		tournament.setName("torneo");
		XmlSport sport = new XmlSport("Deporte");
		tournament.setXmlSport(sport);
		XmlMatchParticipant matchParticipant = new XmlMatchParticipant("Raticulin", tournament);

		CfgCreatorData<CfgParticipant, CfgParticipantSynonyms> creatorData = cfgParticipantCreator.create(matchParticipant, getBookmaker(),
				null);
		assertNotNull(creatorData);
		assertTrue(creatorData.getModelData().getObjectState().getObjectState().equals(ObjectStateEnum.NEW));
		assertTrue(creatorData.getModelData().getName(null).equals("Raticulin"));
		assertTrue(creatorData.getSynonyms().getSynonimWords().get(0).getWord().equals("Raticulin"));
		assertTrue(creatorData.getModelData().getCfgName().equals("Raticulin"));
	}

	/**
	 * Gets the cfg creator.
	 * 
	 * @return the cfg creator {@inheritDoc}
	 */
	@Override
	protected AbstractCfgCreator getCfgCreator() {
		return cfgParticipantCreator;
	}
}
