/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step2;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step1.BookmakerStep1Data;

/**
 * The Class BookmakerFilesReader.
 */
@Service
public final class BookmakerDataAppFilesReader extends AbstractBookmakerProcess
		implements ItemReader<CfgBookmaker> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(BookmakerDataAppFilesReader.class);

	/**
	 * Gets the bookmaker step data.
	 * 
	 * @return the bookmaker step data
	 */
	private BookmakerStep1Data getBookmakerStepData() {
		BookmakerStep1Data bookmakerStepData = BookmakerStep1Data.getInstance();
		return bookmakerStepData;
	}

	/**
	 * Read.
	 * 
	 * @return the list
	 * @throws Exception
	 *             the exception
	 * @throws UnexpectedInputException
	 *             the unexpected input exception
	 * @throws ParseException
	 *             the parse exception
	 * @throws NonTransientResourceException
	 *             the non transient resource exception {@inheritDoc}
	 */
	@Override
	public CfgBookmaker read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		CfgBookmaker bookmaker = null;
		if (getBookmakerStepData() != null) {
			bookmaker = getBookmakerStepData().pop();
			if (bookmaker != null) {
				LOG.info(getStepMessageChain(bookmaker) + "BOOKMAKER READ: "
						+ bookmaker.getName(Locale.ENGLISH));
			}
		}
		return bookmaker;
	}

}
