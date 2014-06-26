/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class StrategyBetfredMakeUrl.
 */
@Component
final class StrategyBetfredMakeUrl extends AbstractStrategyGenericMakeUrl {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The Constant ATRIBUTTE_NAME. */
	private final static String ATRIBUTTE_NAME = "name";

	/** The date start. */
	private Date dateStart;

	/** The lastupdate. */
	private Map<String, Date> lastupdate;

	/** The configuration extension. */
	@Value("${configuration.betfred.extension}")
	private String extension;

	/**
	 * Instantiates a new strategy betfred make url.
	 */
	public StrategyBetfredMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
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

	/**
	 * Gets the strategy type.
	 * 
	 * @return the strategy type {@inheritDoc}
	 */
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.BETFRED;
	}

	/**
	 * Gets the urls.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the urls
	 * @throws URLOutConfigurationException
	 *             the uRL out configuration exception {@inheritDoc}
	 * @throws TimeOutReaderURLException
	 *             the time out reader url exception
	 */
	@Override
	public List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker)
			throws URLOutConfigurationException, TimeOutReaderURLException {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		List<BeanUrlMaker> urls;
		List<BeanUrlMaker> tmp;
		BeanUrlMaker baseUrl;
		BeanUrlMaker parametersUrl;
		Document document;

		try {
			urls = super.getUrls(bookmaker);

			tmp = getBeanUrlMakerByUrlDataTypes(urls, UrlDataTypes.PARAMETERS);
			if (tmp.size() == 1) {
				parametersUrl = tmp.get(0);
			} else {
				throw new URLOutConfigurationException(
						"Por favor verificar configuracion de BetFred. Es necesario añadir url parametro.");
			}

			tmp = getBeanUrlMakerByUrlDataTypes(urls, UrlDataTypes.BASE);
			if (tmp.size() == 1) {
				baseUrl = tmp.get(0);
			} else {
				throw new URLOutConfigurationException(
						"Por favor verificar configuracion de BetFred. Es necesario añadir url base.");
			}

			document = makeDocument(parametersUrl.getUrl());
			for (Element node : document.getElementsByAttribute(ATRIBUTTE_NAME)) {
				String segURL = node.attr(ATRIBUTTE_NAME);
				if (contains(segURL, bookmaker.getBookmakerConfiguration())) {
					BeanUrlMaker beanUrlMaker = new BeanUrlMaker();
					beanUrlMaker.setUrl(new StringBuffer(baseUrl.getUrl())
							.append(segURL).append(extension).toString());
					result.add(beanUrlMaker);
				}
			}
		} catch (URLOutConfigurationException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new URLOutConfigurationException(e);
		}
		return result;
	}
}
