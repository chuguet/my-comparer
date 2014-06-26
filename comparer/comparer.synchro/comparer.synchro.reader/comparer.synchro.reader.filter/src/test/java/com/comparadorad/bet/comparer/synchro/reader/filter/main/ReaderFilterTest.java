package com.comparadorad.bet.comparer.synchro.reader.filter.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.Calendar;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.FilterConfigurationBean;
import com.comparadorad.bet.comparer.synchro.reader.filter.config.AbstractFilterConfigTest;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterException;
import com.comparadorad.bet.comparer.synchro.reader.model.BmInternalId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

public class ReaderFilterTest extends AbstractFilterConfigTest {
	
	@Inject
	private IReaderFilter filter;
	
	
	@Test
	public final void stressTest() throws FilterException{
		XmlMatch match = new XmlMatch();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();
		Calendar before;
		Calendar after;
		Long different;
		cfgBookmaker.setObjectId( new BigInteger("1") );
		assertNotNull(filter);
		
		before = Calendar.getInstance();
		filter.isNew(match, cfgBookmaker,new FilterConfigurationBean(1000));
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
		cfgBookmaker.setObjectId( new BigInteger("2") );
		Boolean result;
		
		assertNotNull(filter);
		result = filter.isNew(match, cfgBookmaker,new FilterConfigurationBean(1000));
		assertTrue(result);		
		
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
		cfgBookmaker.setObjectId( new BigInteger("3") );
		Boolean result;
		
		assertNotNull(filter);
		result = filter.isNew(match, cfgBookmaker,new FilterConfigurationBean(1000));
		assertTrue(result);
		
		result = filter.isNew(match, cfgBookmaker,new FilterConfigurationBean(1000));
		
		assertFalse(result);
		
		
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
		cfgBookmaker.setObjectId( new BigInteger("4") );
		Boolean result;
		
		match.setBmInternalId(new BmInternalId("1"));
		
		assertNotNull(filter);
		result = filter.isNew(match, cfgBookmaker,new FilterConfigurationBean(1000));
		assertTrue(result);
		
		match.setBmInternalId(new BmInternalId("2"));
		result = filter.isNew(match, cfgBookmaker,new FilterConfigurationBean(1000));
		
		assertTrue(result);
	}

}
