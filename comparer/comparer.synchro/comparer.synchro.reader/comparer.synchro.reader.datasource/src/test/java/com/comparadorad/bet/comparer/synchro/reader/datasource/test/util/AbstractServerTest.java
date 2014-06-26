/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.test.util;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.synchro.reader.datasource.config.SynchroReaderDatasourceConfig;
import com.comparadorad.bet.comparer.synchro.server.dummy.XmlBetDummyServerParams;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractServerTest.
 */
@ContextConfiguration(classes = { SynchroReaderDatasourceConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractServerTest {

	/** The xml bet dummy server params. */
	@Inject
	private XmlBetDummyServerParams xmlBetDummyServerParams;

	/**
	 * Gets the server url.
	 * 
	 * @return the server url
	 */
	public String getServerUrl() {
		return xmlBetDummyServerParams.getServerUrl();
	}

}
