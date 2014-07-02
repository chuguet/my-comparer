/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.util;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.service.ICfgBookmakerService;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongoJSON;
import com.comparadorad.bet.comparer.web.server.util.bookmaker.ActiveBookmakers;
import com.comparadorad.bet.comparer.web.server.util.config.WebServerUtilCoreConfigTest;
import com.mongodb.DBCollection;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebServerUtilCoreConfigTest.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractTest extends AbstractTestMongoJSON {

	/** The active bookmakers. */
	@Inject
	protected ActiveBookmakers activeBookmakers;

	/** The bookmaker service. */
	@Inject
	protected ICfgBookmakerService bookmakerService;

	/** The mongo template. */
	@Inject
	protected MongoTemplate mongoTemplate;

	/** {@inheritDoc} */
	@Override
	protected HashMap<Class<? extends IDocument>, DBCollection> getCollections() {
		HashMap<Class<? extends IDocument>, DBCollection> result = new HashMap<Class<? extends IDocument>, DBCollection>();
		result.put(CfgBookmaker.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBookmaker.class)));
		return result;
	}

	/** {@inheritDoc} */
	@Override
	protected Class<?> getLoaderClass() {
		return this.getClass();
	}

}
