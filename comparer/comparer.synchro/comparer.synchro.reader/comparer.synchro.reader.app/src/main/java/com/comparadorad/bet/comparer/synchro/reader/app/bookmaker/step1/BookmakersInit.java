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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;

/**
 * The Class BookmakersInit.
 */
@SuppressWarnings("rawtypes")
@Component
public class BookmakersInit extends AbstractBookmakerProcess implements
		ItemReader, ItemWriter {

	private static final Log LOG = LogFactory
			.getLog(AbstractBookmakerProcess.class);

	/** {@inheritDoc} */
	@Override
	public Object read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		LOG.info(new StringBuffer("Se inicia el step 1. Hora: ")
				.append(new Date()));
		getExecutionContext().put("init", "true");
		return null;
	}

	@Override
	public void write(List pItems) throws Exception {
		// TODO Auto-generated method stub

	}

}
