/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step1;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class BookmakerFilesWriter.
 */
@Service
public class BookmakersObtainerWriter extends AbstractBookmakerProcess implements ItemWriter<CfgBookmaker> {

	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Instantiates a new factory writer.
	 */
	public BookmakersObtainerWriter() {
		super();
	}

	/** {@inheritDoc} */
	@Override
	public void write(List<? extends CfgBookmaker> pBookmakers) throws Exception {
		BookmakerStep1Data bookmakerStepData = BookmakerStep1Data.getInstance();
		bookmakerStepData.addAll(pBookmakers);
		LOG.info(Thread.currentThread(),
				new StringBuffer("Se finaliza el step 1. Hora: ")
						.append(new Date()).toString());
	}

}
