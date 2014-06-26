/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;

/**
 * The Class StrategyPinnacleMakeUrl.
 */
@Component
final class StrategyPinnacleMakeUrl extends AbstractStrategyRebootUrlMaker {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(StrategyPinnacleMakeUrl.class);

	/** The date start. */
	private Date dateStart;

	/** The lastupdate. */
	private final Map<String, Date> lastupdate;

	/**
	 * Instantiates a new strategy pinnacle make url.
	 */
	public StrategyPinnacleMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
	}

	/**
	 * Gets the strategy type.
	 * 
	 * @return the strategy type {@inheritDoc}
	 */
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.PINNACLE;
	}

	/**
	 * Gets the urls.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the urls
	 * @throws URLOutConfigurationException
	 *             the uRL out configuration exception
	 * @throws TimeOutReaderURLException
	 *             the time out reader url exception {@inheritDoc}
	 */
	@Override
	public List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker)
			throws URLOutConfigurationException, TimeOutReaderURLException {
		List<BeanUrlMaker> result;
		List<BeanUrlMaker> urls;

		urls = super.getUrls(bookmaker);
		result = makeURI(getStrategyType().getUriParameter(), urls,
				bookmaker.getBookmakerConfiguration());

		return result;
	}

	/**
	 * Gets the date start.
	 * 
	 * @return the date start {@inheritDoc}
	 */
	@Override
	protected Date getDateStart() {
		return dateStart;
	}

	/**
	 * Gets the lastupdate.
	 * 
	 * @return the lastupdate {@inheritDoc}
	 */
	@Override
	protected Map<String, Date> getLastupdate() {
		return lastupdate;
	}

}
