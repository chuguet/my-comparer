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

@Component
final class StrategyBetRedKingsMakeUrl extends AbstractStrategyGenericMakeUrl {

	@Inject
	private ComparerWrapperLog LOG;

	/** The Constant TAG_NAME. */
	private final static String TAG_NAME = "file";

	/** The date start. */
	private Date dateStart;

	/** The lastupdate. */
	private final Map<String, Date> lastupdate;

	/**
	 * Instantiates a new strategy betfred make url.
	 */
	public StrategyBetRedKingsMakeUrl() {
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
	 *             the uRL out configuration exception {@inheritDoc}
	 */
	@Override
	public List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker) throws TimeOutReaderURLException, URLOutConfigurationException {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		BeanUrlMaker beanUrlMaker;

		List<BeanUrlMaker> urls;
		List<BeanUrlMaker> ulrsParameters;
		BeanUrlMaker ulrParameters;
		List<BeanUrlMaker> urlsBase;
		BeanUrlMaker urlBase;

		try {
			urls = super.getUrls(bookmaker);
			ulrsParameters = super.getBeanUrlMakerByUrlDataTypes(urls, UrlDataTypes.PARAMETERS);
			if (ulrsParameters.size() == 1) {
				ulrParameters = ulrsParameters.get(0);
			} else {
				throw new URLOutConfigurationException("BetRedKings debe tener solo una URL de parametros");
			}
			urlsBase = super.getBeanUrlMakerByUrlDataTypes(urls, UrlDataTypes.BASE);
			if (urlsBase.size() == 1) {
				urlBase = urlsBase.get(0);
			} else {
				throw new URLOutConfigurationException("BetRedKings debe tener solo una URL base");
			}

			Document domParameters = makeDocument(ulrParameters.getUrl());

			for (Element node : domParameters.getElementsByTag(TAG_NAME)) {
				if (contains(node.html(), bookmaker.getBookmakerConfiguration())) {
					LOG.debug(Thread.currentThread(), new StringBuffer("XML a tratar: ").append(node.html().toString()).toString());
					beanUrlMaker = new BeanUrlMaker(new StringBuffer(urlBase.getUrl()).append(node.html()).toString(), UrlDataTypes.DATA);
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
		return StrategyType.BETREDKINGS;
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
