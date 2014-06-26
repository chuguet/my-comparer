/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step5;

import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.UrlParameter;

/**
 * The Class ParameterDownloadWriter.
 */
@Service
public final class ParameterDownloadWriter extends AbstractBookmakerProcess
implements ItemWriter<StepProcessData<XmlMatch>> {
	
	/** The url parameter. */
	@Inject
	private UrlParameter urlParameter;	
	
	/** {@inheritDoc} */ 
	@Override
	public void write(List<? extends StepProcessData<XmlMatch>> processDatas)	
			throws Exception {
		
		CfgBookmaker cfgBookmaker;
		XmlMatch xmlMatch;
		for (StepProcessData<XmlMatch> processData : processDatas) {
		
			cfgBookmaker = processData.getCfgBookmaker();
			xmlMatch = processData.getData();
		
			urlParameter.readParameter(xmlMatch, cfgBookmaker);
			
			BookmakerStep5Data.getInstance().add(
					xmlMatch, cfgBookmaker);
		}
		
	}

}
