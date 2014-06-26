/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.step1;

import java.util.Locale;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.datasource.bookmaker.DsBookmakerDatasource;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;

/**
 * The Class BookmakerFilesProcessor.
 */
@Service
public final class LogEventProcessor extends AbstractBookmakerProcess
		implements ItemProcessor<CfgBookmaker, StepProcessData<XmlDataFiles>> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(LogEventProcessor.class);

	/** The ds bookmaker datasource. */
	@Inject
	private DsBookmakerDatasource dsBookmakerDatasource;

	/**
	 * Instantiates a new factory processor.
	 */
	private LogEventProcessor() {
		super();
	}

	/**
	 * Process.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the object
	 * @throws Exception
	 *             the exception {@inheritDoc}
	 */
	@Override
	public StepProcessData<XmlDataFiles> process(CfgBookmaker bookmaker)
			throws Exception {
		LOG.info(getStepMessageChain(bookmaker) + "PROCESSING: "
				+ bookmaker.getName(Locale.ENGLISH));

		XmlDataFiles xmldataFiles = dsBookmakerDatasource
				.getXmlDataFiles(bookmaker);
		StepProcessData<XmlDataFiles> processData = new StepProcessData<XmlDataFiles>(
				bookmaker, xmldataFiles);

		if (processData.getData() != null
				&& processData.getData().getDataFiles() != null) {
			LOG.debug(getStepMessageChain(bookmaker) + "Obtained: "
					+ processData.getData().getDataFiles().size()
					+ " files for " + bookmaker.getName(Locale.ENGLISH));
		}
		return processData;
	}
}
