/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class XMLBetClickFileReaderTest.
 */
@ActiveProfiles(ProfileConstant.TEST)
public class XMLFileReaderTest extends AbstractTest {

	@Test
	public void getXMLFileTest() {
		try {
			assertNotNull(getXMLFile(0));
			getXMLFile(9999);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
