/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.test.mongo;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.config.TestMongoConfigTest;
import com.mongodb.DBCollection;

/**
 * The Class AbstractTestMongoJSONTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestMongoConfigTest.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public class AbstractTestMongoJSONTest extends AbstractTestMongoJSON {

	/** The mongo template. */
	@Inject
	private MongoTemplate mongoTemplate;

	/** {@inheritDoc} */
	@Override
	public String getAditionalNameForLoad() {
		return "";
	}

	/** {@inheritDoc} */
	@Override
	protected HashMap<Class<? extends IDocument>, DBCollection> getCollections() {
		HashMap<Class<? extends IDocument>, DBCollection> result = new HashMap<Class<? extends IDocument>, DBCollection>();
		result.put(CfgParticipant.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgParticipant.class)));
		return result;
	}

	/** {@inheritDoc} */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getLoaderClass() {
		return TestMongoConfigTest.class;
	}

	/**
	 * Test.
	 */
	@Test
	public final void test() {

	}

}
