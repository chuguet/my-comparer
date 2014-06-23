/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.test;

import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.autosender.core.facade.IAutosender;
import com.comparadorad.bet.comparer.autosender.core.responsebean.CampaignListBean;

/**
 * The Class CampaignListTest.
 */
public class CampaignListTest extends AbstractTest {
	
	/** The facade get response. */
	@Inject
	private IAutosender facadeGetResponse;
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(CampaignListTest.class);
	
	/**
	 * Gets the campaign test.
	 *
	 * @return the campaign test
	 * @throws Exception the exception
	 */
	@Test
	public void getCampaignTest() throws Exception{
		CampaignListBean campaignListBean = facadeGetResponse.getCampaignList();
		if( campaignListBean != null ){
		Iterator<?> iterator = campaignListBean.getCampaignNameAndcampaignId().entrySet().iterator();
			while ( iterator.hasNext() ) {
				Map.Entry<?,?> e = (Map.Entry<?,?>) iterator.next();
				LOG.info("clave: "+e.getKey()+" valor:"+e.getValue());
			}
		}
	}

}
