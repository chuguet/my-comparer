/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.UrlFilterWord;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XmlFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.director.XmlDirector;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class AbstractStrategyGenericMakeUrl.
 */
abstract class AbstractStrategyGenericMakeUrl implements StrategyMakeUrl {

	private final static String CODIFICATION = "UTF-8";

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	protected static String getCodification() {
		return CODIFICATION;
	}

	/** The feed builder. */
	@Inject
	private XmlFeedBuilder feedBuilder;

	/**
	 * Delete reserved characters in html.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	protected String deleteReservedCharactersInHTML(String string) {
		String result = string;
		String value;
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("&amp;", "&");

		for (String key : map.keySet()) {
			value = map.get(key);
			result = result.replace(key, value);
		}

		return result;
	}

	/**
	 * Donwload url.
	 * 
	 * @param url
	 *            the url
	 * @return the input stream
	 * @throws XmlNotFoundException
	 */
	protected InputStream downloadUrl(final String url)
			throws URLOutConfigurationException {
		InputStream inputStream = null;
		try {
			XmlDirector director = new XmlDirector();
			feedBuilder.setUrl(url);
			director.setBuilder(feedBuilder);
			XmlDataFiles xmlDataFiles;
			xmlDataFiles = director.makeXML();
			inputStream = xmlDataFiles.getDataFiles().get(0)
					.getDataFileInputStream();
		} catch (IOException e) {
			LOG.error(Thread.currentThread(), new StringBuffer(
					"Se ha producido un error leyendo la url: ").append(url)
					.toString(), e);
			throw new URLOutConfigurationException(e);
		} catch (XmlNotFoundException e) {
			LOG.error(Thread.currentThread(), new StringBuffer(
					"Se ha producido un error leyendo la url: ").append(url)
					.toString(), e);
			throw new URLOutConfigurationException(e);
		}
		return inputStream;
	}

	/**
	 * Gets the bean url maker by url data types.
	 * 
	 * @param beanUrlMakes
	 *            the bean url makes
	 * @param urlDataTypes
	 *            the url data types
	 * @return the bean url maker by url data types Devuelve una lista de
	 *         BeanUrlMaker que cumplen el tipo indicado en el parametro
	 *         urlDataTypes
	 */
	protected List<BeanUrlMaker> getBeanUrlMakerByUrlDataTypes(
			List<BeanUrlMaker> beanUrlMakes, UrlDataTypes urlDataTypes) {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		for (BeanUrlMaker beanUrlMaker : beanUrlMakes) {
			if (beanUrlMaker.getUrlDataTypes().equals(urlDataTypes)) {
				result.add(beanUrlMaker);
			}
		}
		return result;
	}

	/**
	 * Date start.
	 * 
	 * @return the date
	 */
	protected abstract Date getDateStart();

	/**
	 * Gets the lastupdate.
	 * 
	 * @return the lastupdate
	 */
	protected abstract Map<String, Date> getLastupdate();

	/**
	 * Gets the urls.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the urls
	 * @throws TimeOutReaderURLException
	 *             the time out reader url exception
	 * @throws URLOutConfigurationException
	 *             the uRL out configuration exception {@inheritDoc}
	 */
	@Override
	public List<BeanUrlMaker> getUrls(final CfgBookmaker bookmaker)
			throws TimeOutReaderURLException, URLOutConfigurationException {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		BeanUrlMaker beanUrlMaker;
		Long minimumTimeUpdate = bookmaker.getBookmakerConfiguration()
				.getMinimumTimeUpdate();
		for (CfgBookmakerDataUrl bookmakerDataUrl : bookmaker
				.getBookmakerConfiguration().getBookmakerUrl()) {
			try {
				beanUrlMaker = readUrl(bookmakerDataUrl.getUrl(),
						minimumTimeUpdate, bookmakerDataUrl.getUrlDataType());
				result.add(beanUrlMaker);
			} catch (TimeOutReaderURLException timeOutReaderURLException) {
				try {
					LOG.debug(
							Thread.currentThread(),
							new StringBuffer("Se para reader durante: ")
									.append(timeOutReaderURLException
											.getDateDifferences()).toString());
					Thread.sleep(timeOutReaderURLException.getDateDifferences());
					LOG.debug(Thread.currentThread(), new StringBuffer(
							"Se reanuda el reader").toString());
				} catch (InterruptedException e) {
					throw new URLOutConfigurationException(e);
				}
			}
		}
		return result;
	}

	/**
	 * Make document.
	 * 
	 * @param inputStream
	 *            the input stream
	 * @return the document Desde un InputStream se genera un objecto Doucument
	 *         que representa un XML
	 * 
	 */
	protected Document makeDocument(final InputStream inputStream)
			throws URLOutConfigurationException {
		String html;
		Document doc = null;
		try {
			html = IOUtils.toString(inputStream, getCodification());
			doc = Jsoup.parse(html);
		} catch (IOException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new URLOutConfigurationException(e);
		}
		return doc;
	}

	/**
	 * Make document.
	 * 
	 * @param url
	 *            the url
	 * @return the document Desde un string que representa una dirreccion url se
	 *         crea un Document que representa un XML
	 */
	protected Document makeDocument(final String url)
			throws URLOutConfigurationException {
		return makeDocument(downloadUrl(url));
	}

	/**
	 * Contains.
	 * 
	 * @param string
	 *            the string
	 * @param bookmakerConfiguration
	 *            the bookmaker configuration
	 * @return the boolean Indica si una cadena especifica esta presente en la
	 *         lista urlFilterWords
	 */
	protected Boolean contains(String string,
			CfgBookmakerConfiguration bookmakerConfiguration) {
		Boolean result = Boolean.FALSE;
		for (UrlFilterWord urlFilterWord : bookmakerConfiguration
				.getFilterMakeUrl()) {
			if (urlFilterWord.getString().equalsIgnoreCase(string)) {
				result = Boolean.TRUE;
			}
		}
		return result;
	}

	/**
	 * Read url.
	 * 
	 * @param url
	 *            the url
	 * @param minimumTimeUpdate
	 *            the minimum time update
	 * @param dataTypes
	 *            the data types
	 * @return the string
	 */
	protected BeanUrlMaker readUrl(final String url,
			final Long minimumTimeUpdate, final UrlDataTypes dataTypes)
			throws TimeOutReaderURLException {
		Date now = new Date();
		BeanUrlMaker result = null;
		Date lastReadWithRestrictionTime;
		Long dateDifferences;
		if (getLastupdate().containsKey(url) && minimumTimeUpdate != null) {
			lastReadWithRestrictionTime = new Date(getLastupdate().get(url)
					.getTime() + minimumTimeUpdate);
			if (lastReadWithRestrictionTime.before(now)
					|| lastReadWithRestrictionTime.equals(now)) {
			} else {
				dateDifferences = lastReadWithRestrictionTime.getTime()
						- now.getTime();
				throw new TimeOutReaderURLException(new StringBuffer(
						"No se puede acceder a la url hasta: ")
						.append(lastReadWithRestrictionTime)
						.append(" faltan: ").append(dateDifferences / 1000)
						.append(" sgs").toString(), dateDifferences);

			}
		}
		getLastupdate().put(url, now);
		result = new BeanUrlMaker();
		result.setUrlDataTypes(dataTypes);
		result.setUrl(url);
		return result;
	}

}
