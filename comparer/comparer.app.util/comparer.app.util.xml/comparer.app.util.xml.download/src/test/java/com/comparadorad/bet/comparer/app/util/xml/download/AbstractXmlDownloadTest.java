/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.app.util.xml.download;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.app.util.xml.download.config.XmlDownloadAppConfig.XmlDownloadAppConfigDev;
import com.comparadorad.bet.comparer.synchro.reader.datasource.test.util.AbstractServerTest;
import com.comparadorad.bet.comparer.synchro.server.dummy.config.SynchroReaderServerDummyConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.TEST)
@ContextConfiguration(classes = { XmlDownloadAppConfigDev.class,
		SynchroReaderServerDummyConfig.class })
public abstract class AbstractXmlDownloadTest extends AbstractServerTest {

}
