/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step2;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step1.BookmakerStep1Data;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class MakerUrlReader.
 */
@Service
final class MakerUrlReader extends AbstractBookmakerProcess implements ItemReader<CfgBookmaker> {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Gets the bookmaker step data.
	 * 
	 * @return the bookmaker step data
	 */
	private BookmakerStep1Data getBookmakerStepData() {
		BookmakerStep1Data bookmakerStepData = BookmakerStep1Data.getInstance();

		return bookmakerStepData;
	}

	/** {@inheritDoc} */
	@Override
	public CfgBookmaker read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		CfgBookmaker bookmaker = null;
		if (getBookmakerStepData() != null) {
			bookmaker = getBookmakerStepData().pop();
			if (bookmaker != null) {
				LOG.info(Thread.currentThread(), new StringBuffer(getStepMessageChain(bookmaker)).append("BOOKMAKER READ: ").append(bookmaker.getName(Locale.ENGLISH))
						.toString());
			}
		}

		return bookmaker;

	}
}
