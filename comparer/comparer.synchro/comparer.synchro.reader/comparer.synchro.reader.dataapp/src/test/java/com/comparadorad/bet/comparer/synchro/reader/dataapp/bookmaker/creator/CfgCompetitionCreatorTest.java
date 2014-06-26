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

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.ObjectState.ObjectStateEnum;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.exception.CfgFromXmlCreatorException;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppConfig;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppTestConfig;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class CfgCompetitionCreatorTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SynchroReaderDataAppConfig.class, SynchroReaderDataAppTestConfig.class })
@ActiveProfiles(value = { ProfileConstant.TEST, ProfileConstant.TEST_NO_JOB_EXECUTION })
public class CfgCompetitionCreatorTest extends AbstractCreatorTest {

	/** The cfg competition creator. */
	@Inject
	private CfgCompetitionCreator cfgCompetitionCreator;

	/**
	 * Test.
	 * 
	 * @throws CfgFromXmlCreatorException
	 *             the cfg from xml creator exception
	 */
	@Test
	public void testWithSynonyms() throws CfgFromXmlCreatorException {

		XmlTournament tournament = new XmlTournament();
		XmlSport xmlSport = new XmlSport();
		xmlSport.setCfgObjectId(new BigInteger("1"));
		tournament.setXmlSport(xmlSport);
		tournament.setName("Euro 2012.");
		CfgCreatorData<CfgCompetition, CfgCompetitionSynonyms> creatorData = cfgCompetitionCreator.create(tournament, getBookmaker(), null);
		assertNotNull(creatorData);
		assertTrue(creatorData.getModelData().getObjectState().getObjectState().equals(ObjectStateEnum.NOT_MODIFIED));
	}

	/**
	 * Test without synonyms.
	 * 
	 * @throws CfgFromXmlCreatorException
	 *             the cfg from xml creator exception
	 */
	@Test
	public void testWithoutSynonyms() throws CfgFromXmlCreatorException {

		XmlTournament tournament = new XmlTournament();
		XmlSport xmlSport = new XmlSport();
		xmlSport.setCfgObjectId(new BigInteger("666"));
		xmlSport.setName("nombreDeporte");
		tournament.setXmlSport(xmlSport);
		tournament.setName("Premier League");
		CfgCreatorData<CfgCompetition, CfgCompetitionSynonyms> creatorData = cfgCompetitionCreator.create(tournament, getBookmaker(), null);
		assertNotNull(creatorData);
		assertTrue(creatorData.getModelData().getObjectState().getObjectState().equals(ObjectStateEnum.NEW));
		assertTrue(creatorData.getModelData().getName(null).equals("Premier League"));
		assertTrue(creatorData.getSynonyms().getSynonimWords().get(0).getWord().equals("Premier League"));
		assertTrue(creatorData.getModelData().getCfgName().equals("Premier League"));
	}

	/**
	 * Prueba la creación de una nueva competicion con su sinonimo asociado en
	 * la que no tenemos nombre del deporte con lo que devuelve una excepcion
	 */
	@Test
	public void test_WithoutSynonyms_Exception() {
		XmlTournament tournament = new XmlTournament();
		XmlSport xmlSport = new XmlSport();
		xmlSport.setCfgObjectId(new BigInteger("666"));
		tournament.setXmlSport(xmlSport);
		tournament.setName("Premier League");
		CfgCreatorData<CfgCompetition, CfgCompetitionSynonyms> creatorData;
		try {
			creatorData = cfgCompetitionCreator.create(tournament, getBookmaker(), null);
		} catch (Exception e) {
			assertTrue(e instanceof CfgFromXmlCreatorException);
		}
	}

	/**
	 * Gets the cfg creator.
	 * 
	 * @return the cfg creator {@inheritDoc}
	 */
	@Override
	protected AbstractCfgCreator getCfgCreator() {
		return cfgCompetitionCreator;
	}
}
