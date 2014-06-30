/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.writer;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetHistoricService;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetService;
import com.comparadorad.bet.comparer.synchro.valuebet.writer.config.SynchroValueBetWriterConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongoJSON;
import com.mongodb.DBCollection;

/**
 * The Class AbstractValueBetWriterTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroValueBetWriterConfigTest.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractValueBetWriterTest extends AbstractTestMongoJSON {

	/** The value bet historic service. */
	@Inject
	protected IValueBetHistoricService valueBetHistoricService;

	/** The value bet service. */
	@Inject
	protected IValueBetService valueBetService;

	/** The value bet writer. */
	@Inject
	protected IWriterValueBet valueBetWriter;

	/** {@inheritDoc} */
	@Override
	protected HashMap<Class<? extends IDocument>, DBCollection> getCollections() {
		HashMap<Class<? extends IDocument>, DBCollection> result = new HashMap<Class<? extends IDocument>, DBCollection>();
		result.put(CfgBetType.class, mongoTemplate.getCollection(mongoTemplate
				.getCollectionName(CfgBetType.class)));
		result.put(CfgBetTypeEvent.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBetTypeEvent.class)));
		result.put(CfgParticipant.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgParticipant.class)));
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
