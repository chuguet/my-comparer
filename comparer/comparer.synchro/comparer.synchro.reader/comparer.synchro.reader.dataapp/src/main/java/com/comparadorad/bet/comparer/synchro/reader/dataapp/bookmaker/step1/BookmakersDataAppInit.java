/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step1;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;

/**
 * The Class BookmakersDataAppInit.
 */
@SuppressWarnings("rawtypes")
@Component
public class BookmakersDataAppInit extends AbstractBookmakerProcess implements
		ItemReader, ItemWriter {

	/** {@inheritDoc} */
	@Override
	public Object read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		getExecutionContext().put("init", "true");
		return null;
	}

	@Override
	public void write(List pItems) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
