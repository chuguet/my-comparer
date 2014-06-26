/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.step1;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;

/**
 * The Class BookmakerFilesWriter.
 */
@Service
public final class LogEventWriter extends AbstractBookmakerProcess
		implements ItemWriter<CfgBookmaker> {

	/**
	 * Instantiates a new factory writer.
	 */
	private LogEventWriter() {
		super();
	}

	/** {@inheritDoc} */
	@Override
	public void write(List<? extends CfgBookmaker> pBookmakers)
			throws Exception {
		BookmakerStep1Data bookmakerStepData = BookmakerStep1Data
				.getInstance(getExecutionContext());
		bookmakerStepData.addAll(pBookmakers);
	}

}
