/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.comparer.impl;

import org.junit.Test;

import uk.ac.shef.wit.simmetrics.similaritymetrics.TagLink;

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.CfgResolverAlgorithm;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.bean.StrikeAMatchData;

/**
 * The Class DataComparerImplTest.
 */
public class DataComparerImplTest {
	
	/** The data comparer impl. */
	private DataComparerImpl dataComparerImpl = new  DataComparerImpl();
	

	/**
	 * Compare strings without character ascii test.
	 */
	@Test
	public void compareStringsWithoutCharacterASCIITest(){
		CfgMaster cfgMaster = new CfgMaster();
		TagLink tagLink = new TagLink();
		CfgResolverAlgorithm algorithm = new CfgResolverAlgorithm();
				
		algorithm.setAlgorithm(tagLink);
		algorithm.setLimit(0.91d);		
		cfgMaster.add(algorithm);
		
		StrikeAMatchData<ICfgSynonyms> data = new StrikeAMatchData<ICfgSynonyms>("rc lens", "st. etienne");
		
		dataComparerImpl.compareStrings(cfgMaster, data);
	}

}
