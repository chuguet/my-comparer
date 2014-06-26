/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import javax.inject.Inject;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.service.ICfgBookmakerService;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.config.AbstractSynchroReaderAppConfig;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class BookmakersObtainerReader.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BookmakersObtainerReader extends AbstractBookmakerProcess implements ItemReader<CfgBookmaker> {

	@Inject
	private ComparerWrapperLog LOG;

	/** The bookmakers. */
	private Stack<CfgBookmaker> bookmakers = null;

	/** The bookmaker service. */
	@Inject
	private ICfgBookmakerService bookmakerService;

	@Autowired(required = false)
	private AbstractSynchroReaderAppConfig appConfig;

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
	public CfgBookmaker read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		String init = (String) getExecutionContext().get("init");

		if (bookmakers == null || "true".equals(init)) {
			Iterable<CfgBookmaker> itbookmakers = getActiveCfgBookmaker();
			getExecutionContext().put("init", "false");
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

		if (bookmaker != null) {
			LOG.debug(Thread.currentThread(), new StringBuffer("Se va a leer la casa de apuesta: ").append(bookmaker.getNameId())
					.toString());
		}
		return bookmaker;
	}

	private Iterable<CfgBookmaker> getActiveCfgBookmaker() {
		Iterable<CfgBookmaker> result = new ArrayList<CfgBookmaker>();
		if (appConfig == null || appConfig.getReadAllBookmaker()) {
			result = bookmakerService.findAll();
		} else {
			List<CfgBookmaker> tmp = new ArrayList<CfgBookmaker>();
			for (CfgBookmaker cfgBookmaker : bookmakerService.findAll()) {
				for (BigInteger id : appConfig.getBookmakerId()) {
					if (cfgBookmaker.getObjectId().equals(id)) {
						tmp.add(cfgBookmaker);
					}
				}
				result = tmp;
			}
		}
		return result;
	}
}
