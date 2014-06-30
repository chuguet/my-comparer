/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process;

import java.util.HashMap;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.synchro.valuebet.process.config.SynchroValueBetProcessConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongoJSON;
import com.mongodb.DBCollection;

/**
 * The Class AbstractProcessValueBetTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroValueBetProcessConfigTest.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractProcessValueBetTest extends AbstractTestMongoJSON {

	/** {@inheritDoc} */
	@Override
	protected HashMap<Class<? extends IDocument>, DBCollection> getCollections() {
		HashMap<Class<? extends IDocument>, DBCollection> result = new HashMap<Class<? extends IDocument>, DBCollection>();
		return result;
	}

	/** {@inheritDoc} */
	@Override
	protected Class<?> getLoaderClass() {
		return this.getClass();
	}

}
