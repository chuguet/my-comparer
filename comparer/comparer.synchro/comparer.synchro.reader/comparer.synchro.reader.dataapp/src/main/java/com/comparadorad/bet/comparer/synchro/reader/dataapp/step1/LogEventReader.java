/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.step1;

import java.util.Date;
import java.util.Stack;

import javax.annotation.Resource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.service.ICfgBookmakerService;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;

/**
 * The Class BookmakersObtainerReader.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class LogEventReader extends AbstractBookmakerProcess
		implements ItemReader<CfgBookmaker> {

	/** The bookmakers. */
	private Stack<CfgBookmaker> bookmakers = null;

	/** The bookmaker service. */
	@Resource
	private ICfgBookmakerService bookmakerService;

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
		if (bookmakers == null) {
			Iterable<CfgBookmaker> itbookmakers = bookmakerService.findAll();
			bookmakers = new Stack<CfgBookmaker>();
			for (CfgBookmaker cfgBookmaker : itbookmakers) {
				if (cfgBookmaker.isActive(new Date())) {
					bookmakers.push(cfgBookmaker);
				}
			}
		}
		CfgBookmaker bookmaker = null;
		if (!bookmakers.isEmpty()) {
			bookmaker = bookmakers.pop();
		}
		return bookmaker;
	}
}
