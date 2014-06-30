/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.filter;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.synchro.valuebet.bean.DataConfiguration;
import com.comparadorad.bet.comparer.synchro.valuebet.reader.config.SynchroValueBetReaderConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongoJSON;
import com.mongodb.DBCollection;

/**
 * The Class AbstractValueBetFilterTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroValueBetReaderConfigTest.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractValueBetFilterTest extends AbstractTestMongoJSON {

	/** The data configuration. */
	@Inject
	protected DataConfiguration dataConfiguration;

	/** The mongo template. */
	@Inject
	protected MongoTemplate mongoTemplate;

	/** {@inheritDoc} */
	@Override
	protected String getAditionalNameForLoad() {
		return "-FilterValueBetTest";
	}

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
		return getClass();
	}

	/**
	 * Checks if is market of type.
	 * 
	 * @param market
	 *            the market
	 * @param betType
	 *            the bet type
	 * @param betTypeEvent
	 *            the bet type event
	 * @return the boolean
	 */
	protected Boolean isMarketOfType(final RtMarket market,
			final CfgBetTypeId betType, final CfgBetTypeEventId betTypeEvent) {
		return market.getBetType().getObjectId().toString()
				.equals(betType.id())
				&& market.getBetTypeEvent().getBetTypeEvent().getObjectId()
						.toString().equals(betTypeEvent.objectId());
	}

}
