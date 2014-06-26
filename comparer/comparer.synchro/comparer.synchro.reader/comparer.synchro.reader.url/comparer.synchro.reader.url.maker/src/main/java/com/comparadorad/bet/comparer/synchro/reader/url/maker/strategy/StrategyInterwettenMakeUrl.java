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
final class StrategyInterwettenMakeUrl extends AbstractStrategyGenericMakeUrl {

	/** The Constant ATRIBUTTE_NAME. */
	private final static String ATRIBUTTE_ID = "ID";

	private final static String ATRIBUTTE_NAME = "NAME";

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The date start. */
	private Date dateStart;

	/** The lastupdate. */
	private final Map<String, Date> lastupdate;

	/**
	 * Instantiates a new strategy betfred make url.
	 */
	public StrategyInterwettenMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
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
	public List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker) throws URLOutConfigurationException, TimeOutReaderURLException {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		List<BeanUrlMaker> urls;
		List<BeanUrlMaker> tmp;
		BeanUrlMaker baseUrl;
		BeanUrlMaker parametersUrl;
		Document doc;
		String id;
		String name;
		try {
			urls = super.getUrls(bookmaker);
			tmp = getBeanUrlMakerByUrlDataTypes(urls, UrlDataTypes.PARAMETERS);
			if (tmp.size() == 1) {
				parametersUrl = tmp.get(0);
			} else {
				throw new URLOutConfigurationException(
						"Por favor verificar configuracion de Interwetten. Es necesario añadir url de parametros.");
			}

			tmp = getBeanUrlMakerByUrlDataTypes(urls, UrlDataTypes.BASE);
			if (tmp.size() == 1) {
				baseUrl = tmp.get(0);
			} else {
				throw new URLOutConfigurationException("Por favor verificar configuracion de Interwetten. Es necesario añadir url base.");
			}
			doc = makeDocument(parametersUrl.getUrl());
			for (Element node : doc.getElementsByAttribute(ATRIBUTTE_ID)) {
				id = node.attr(ATRIBUTTE_ID);
				name = node.attr(ATRIBUTTE_NAME);
				if (contains(name, bookmaker.getBookmakerConfiguration())) {
					BeanUrlMaker beanUrlMaker = new BeanUrlMaker();
					beanUrlMaker.setUrl(new StringBuffer(baseUrl.getUrl()).append(id).toString());
					beanUrlMaker.setUrlDataTypes(UrlDataTypes.DATA);
					result.add(beanUrlMaker);
				}
			}

		} catch (URLOutConfigurationException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new URLOutConfigurationException(e);
		}

		return result;
	}

	/**
	 * Gets the strategy type.
	 * 
	 * @return the strategy type {@inheritDoc}
	 */
	@Override
	public StrategyType getStrategyType() {
		return StrategyType.INTERWETTEN;
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
