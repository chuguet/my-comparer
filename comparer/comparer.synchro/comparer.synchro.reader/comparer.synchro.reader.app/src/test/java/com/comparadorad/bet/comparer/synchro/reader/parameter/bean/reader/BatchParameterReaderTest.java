/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.parameter.bean.reader;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.synchro.reader.app.config.SynchroReaderAppConfig;
import com.comparadorad.bet.comparer.synchro.reader.exception.BatchReaderAppParameterException;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BatchParameterReaderTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroReaderAppConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public class BatchParameterReaderTest {

	/** The batch parameter reader. */
//	@Inject
//	private BatchParameterReader batchParameterReader;

	
	/**
	 * Read parameter all test.
	 * 
	 * @throws BatchReaderAppParameterException
	 *             the batch reader app parameter exception
	 */
	@Test
	public final void readParameterAllTest()
			throws BatchReaderAppParameterException {
//		String[] args = new String[1];
//		args[0] = "--ALL";
//
//		BatchParameterReaderImpl batchParameterReader = new BatchParameterReaderImpl();
//		batchParameterReader.readParameter(args);
	}

	/**
	 * Read parameter book maker id test.
	 * 
	 * @throws BatchReaderAppParameterException
	 *             the batch reader app parameter exception
	 */
	@Test
	public final void readParameterBookMakerIdTest()
			throws BatchReaderAppParameterException {
//		String[] args = new String[2];
//		args[0] = "--BOOKMAKERID";
//		args[1] = "19";
//		BatchParameterReader batchParameterReader = new BatchParameterReaderImpl();
//		batchParameterReader = new BatchParameterReaderImpl();
//		batchParameterReader.readParameter(args);
	}

	/**
	 * Read parameter book maker several ids test.
	 * 
	 * @throws BatchReaderAppParameterException
	 *             the batch reader app parameter exception
	 */
	@Test
	public final void readParameterBookMakerSeveralIdsTest()
			throws BatchReaderAppParameterException {
//		String[] args = new String[2];
//		args[0] = "--BOOKMAKERID";
//		args[1] = "19,77,103,105";
//		BatchParameterReader batchParameterReader = new BatchParameterReaderImpl();
//		batchParameterReader.readParameter(args);
	}

	/**
	 * Read parameter book maker id error test.
	 * 
	 * @throws BatchReaderAppParameterException
	 *             the batch reader app parameter exception
	 */
	@Test
	public final void readParameterBookMakerIdErrorTest()
			throws BatchReaderAppParameterException {
//		String[] args = new String[2];
//		args[0] = "--BOOKMAKERID";
//		args[1] = "99999";
//		BatchParameterReader batchParameterReader = new BatchParameterReaderImpl();
//		batchParameterReader.readParameter(args);
	}

	/**
	 * Read parameter book maker several ids error test.
	 * 
	 * @throws BatchReaderAppParameterException
	 *             the batch reader app parameter exception
	 */
	@Test
	public final void readParameterBookMakerSeveralIdsErrorTest()
			throws BatchReaderAppParameterException {
//		String[] args = new String[2];
//		args[0] = "--BOOKMAKERID";
//		args[1] = "19,77,103,99999";
//		BatchParameterReader batchParameterReader = new BatchParameterReaderImpl();
//		batchParameterReader.readParameter(args);
	}

}
