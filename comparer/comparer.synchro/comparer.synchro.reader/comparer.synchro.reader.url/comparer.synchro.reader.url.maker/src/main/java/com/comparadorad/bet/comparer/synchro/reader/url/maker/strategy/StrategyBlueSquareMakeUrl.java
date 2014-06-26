/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XmlFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.director.XmlDirector;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;

/**
 * The Class StrategyBlueSquareMakeUrl.
 */
@Component
final class StrategyBlueSquareMakeUrl extends AbstractStrategyGenericMakeUrl {

	/** The Constant TAG_NAME. */
	private final static String TAG_NAME = "URL";

	/** The date start. */
	private Date dateStart;

	/** The lastupdate. */
	private final Map<String, Date> lastupdate;

	@Inject
	private XmlFeedBuilder feedBuilder;

	/**
	 * Instantiates a new strategy betfred make url.
	 */
	public StrategyBlueSquareMakeUrl() {
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
	public List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker)
			throws URLOutConfigurationException, TimeOutReaderURLException {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();

		BeanUrlMaker urlBookmaker = super.getUrls(bookmaker).get(0);

		try {
			XmlDirector director = new XmlDirector();
			feedBuilder.setUrl(urlBookmaker.getUrl());
			director.setBuilder(feedBuilder);
			XmlDataFiles xmlDataFiles = director.makeXML();
			StringWriter writer = new StringWriter();
			IOUtils.copy(xmlDataFiles.getDataFiles().get(0)
					.getDataFileInputStream(), writer, "UTF-8");
			String htmlString = writer.toString();
			Document html = Jsoup.parse(htmlString);
			for (Element node : html.getElementsByTag(TAG_NAME)) {
				BeanUrlMaker beanUrlMaker = new BeanUrlMaker();
				beanUrlMaker
						.setUrl(deleteReservedCharactersInHTML(node.html()));
				result.add(beanUrlMaker);
			}
		} catch (IOException e) {
			throw new URLOutConfigurationException(e);
		} catch (XmlNotFoundException e) {
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
		return StrategyType.BLUESQUARE;
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
