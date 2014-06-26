/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.plugin.hashkey;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.FilterConfigurationBean;
import com.comparadorad.bet.comparer.synchro.reader.filter.config.AbstractFilterConfigTest;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterException;
import com.comparadorad.bet.comparer.synchro.reader.filter.plugin.PluginFilter;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Class HashKeyFilterTest.
 */
public class HashKeyFilterTest extends AbstractFilterConfigTest {
	
	/** The plugin filter. */
	@Inject
	@Resource(name="hashKeyFilter")
	private PluginFilter pluginFilter;
	
	@Test
	public final void stressTest() throws FilterException{
		XmlMatch match = new XmlMatch();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		Calendar before;
		Calendar after;
		Long different;
		cfgBookmaker.setObjectId( new BigInteger("11") );
		assertNotNull(pluginFilter);
		
		before = Calendar.getInstance();
		pluginFilter.deleteElement(match, cfgBookmaker,new FilterConfigurationBean(1000));
		after = Calendar.getInstance();
		
		different = after.getTimeInMillis() - before.getTimeInMillis();
		if( different >= 20 ){
			fail("Tarda demasiado el calculo de hashKey");
		}
		
		
		
	}
	
	/**
	 * Delete element one element test.
	 *
	 * @throws FilterException the filter exception
	 */
	@Test
	public final void deleteElementOneElementTest() throws FilterException{
		XmlMatch match = new XmlMatch();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		cfgBookmaker.setObjectId( new BigInteger("12") );
		Boolean result;
		
		assertNotNull(pluginFilter);
		result = pluginFilter.deleteElement(match, cfgBookmaker,new FilterConfigurationBean(1000));
		assertFalse(result);		
		
	}
	
	/**
	 * Delete element one element equal test.
	 *
	 * @throws FilterException the filter exception
	 */
	@Test
	public final void deleteElementOneElementEqualTest() throws FilterException{
		
		XmlMatch match = new XmlMatch();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		cfgBookmaker.setObjectId( new BigInteger("13") );
		Boolean result;
		
		assertNotNull(pluginFilter);
		result = pluginFilter.deleteElement(match, cfgBookmaker,new FilterConfigurationBean(1000));
		assertFalse(result);
		
		result = pluginFilter.deleteElement(match, cfgBookmaker,new FilterConfigurationBean(1000));
		
		assertTrue(result);
		
		
	}
	
	/**
	 * Delete element one element different test.
	 *
	 * @throws FilterException the filter exception
	 */
	@Test
	public final void deleteElementOneElementDifferentTest() throws FilterException{
		
		XmlMatch match = new XmlMatch();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		cfgBookmaker.setObjectId( new BigInteger("14") );
		Boolean result;
		
		match.setBmInternalId(new BmInternalId("1"));
		
		assertNotNull(pluginFilter);
		result = pluginFilter.deleteElement(match, cfgBookmaker,new FilterConfigurationBean(1000));
		assertFalse(result);
		
		match.setBmInternalId(new BmInternalId("2"));
		result = pluginFilter.deleteElement(match, cfgBookmaker,new FilterConfigurationBean(1000));
		
		assertFalse(result);
	}
	
	

}
