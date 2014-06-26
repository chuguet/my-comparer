/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step3;

import javax.inject.Inject;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step2.BookmakerStep2Data;
import com.comparadorad.bet.comparer.synchro.reader.datasource.bookmaker.DsBookmakerDatasource;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class DownloadUrlReader.
 */
@Service
final class DownloadUrlReader extends AbstractBookmakerProcess implements ItemReader<StepProcessData<XmlDataFiles>> {

	@Inject
	private ComparerWrapperLog LOG;

	/** The ds bookmaker datasource. */
	@Inject
	private DsBookmakerDatasource dsBookmakerDatasource;

	/** {@inheritDoc} */
	@Override
	public StepProcessData<XmlDataFiles> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		LOG.debug(Thread.currentThread(), "Inicio del reader de descarga de xml");
		BookmakerStep2Data bookmakerStep2Data;
		StepProcessData<BeanUrlMaker> stepProcessData;
		StepProcessData<XmlDataFiles> result = null;

		bookmakerStep2Data = BookmakerStep2Data.getInstance(getExecutionContext());

		stepProcessData = bookmakerStep2Data.pop();

		if (stepProcessData != null) {
			XmlDataFiles xmldataFiles = null;
			try {
				xmldataFiles = dsBookmakerDatasource.getXmlDataFiles(stepProcessData.getData().getUrl());
				result = new StepProcessData<XmlDataFiles>(stepProcessData.getCfgBookmaker(), xmldataFiles, stepProcessData.getData()
						.getBeanAdditionalXmlInfoReader());
			} catch (XmlNotFoundException e) {
				LOG.error(Thread.currentThread(), e.getMessage(), e);
			}

		}
		LOG.debug(Thread.currentThread(), "Fin del reader de descarga de xml");
		return result;
	}
}
