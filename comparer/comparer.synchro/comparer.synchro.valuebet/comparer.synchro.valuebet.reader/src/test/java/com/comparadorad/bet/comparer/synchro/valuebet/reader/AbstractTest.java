/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.reader;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.synchro.valuebet.bean.DataConfiguration;
import com.comparadorad.bet.comparer.synchro.valuebet.reader.config.SynchroValueBetReaderConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongoJSON;
import com.mongodb.DBCollection;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroValueBetReaderConfigTest.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractTest extends AbstractTestMongoJSON {

	/** The Constant PREFIX. */
	protected static final String PREFIX = "-ReaderValueBetTest";

	/** The data configuration. */
	@Inject
	protected DataConfiguration dataConfiguration;

	/** The mongo template. */
	@Inject
	protected MongoTemplate mongoTemplate;

	/** The reader value bet. */
	@Inject
	protected IReaderValueBet readerValueBet;

	/** The rt match service. */
	@Inject
	protected IRtMatchService rtMatchService;

	/** {@inheritDoc} */
	@Override
	protected String getAditionalNameForLoad() {
		return PREFIX;
	}

	/** {@inheritDoc} */
	@Override
	protected HashMap<Class<? extends IDocument>, DBCollection> getCollections() {
		HashMap<Class<? extends IDocument>, DBCollection> result = new HashMap<Class<? extends IDocument>, DBCollection>();
		result.put(RtMatch.class, mongoTemplate.getCollection(mongoTemplate
				.getCollectionName(RtMatch.class)));
		result.put(CfgBookmaker.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBookmaker.class)));
		result.put(CfgBetType.class, mongoTemplate.getCollection(mongoTemplate
				.getCollectionName(CfgBetType.class)));
		return result;
	}

	/** {@inheritDoc} */
	@Override
	protected Class<?> getLoaderClass() {
		return getClass();
	}

}
