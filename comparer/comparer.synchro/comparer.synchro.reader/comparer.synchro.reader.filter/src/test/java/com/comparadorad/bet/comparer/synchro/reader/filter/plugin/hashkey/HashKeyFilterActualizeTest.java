/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.plugin.hashkey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.FilterConfigurationBean;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.RtMatchFilterIdentificator;
import com.comparadorad.bet.comparer.synchro.reader.filter.config.AbstractFilterConfigTest;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterException;
import com.comparadorad.bet.comparer.synchro.reader.filter.plugin.PluginFilter;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Class HashKeyFilterTest.
 */
public class HashKeyFilterActualizeTest extends AbstractFilterConfigTest {
	
	/** The plugin filter. */
	@Inject
	@Resource(name="hashKeyFilter")
	private PluginFilter pluginFilter;
	
	@Test
	public final void stressTest() throws FilterException{
//		XmlMatch match = new XmlMatch();
//		CfgBookmaker cfgBookmaker = new CfgBookmaker();
//		cfgBookmaker.setObjectId( new BigInteger("11") );
//		assertNotNull(pluginFilter);
//		
//		pluginFilter.deleteElement(match, cfgBookmaker,new FilterConfigurationBean(1000));
//		RtMatchFilterIdentificator rtFid = pluginFilter.getRtMatchFilterIdentificator(cfgBookmaker);
//		assertNotNull(rtFid.getHashXmlMatchs());
//		
//		// Asigna unos hash de markets.
//		List<String> marketLists = new ArrayList<String>();
//		for(int i=0;i<3;++i) {
//			marketLists.add(Integer.toString(i+1000));
//		}
//		
//		rtFid.setHashMarkets(marketLists);
//		
//		// Pone en el fiter.
//		pluginFilter.pushElemenToCalculatedHashKey(cfgBookmaker, rtFid);
//		
//		// Recuperarlos
//		rtFid = pluginFilter.getRtMatchFilterIdentificator(cfgBookmaker);
//		
//		assertEquals(rtFid.getHashMarkets().size(), 3);
	}
		

}
