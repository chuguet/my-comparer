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
import org.jsoup.nodes.TextNode;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class StrategyBetfredMakeUrl.
 */
@Component
final class StrategyBetgunMakeUrl extends AbstractStrategyGenericMakeUrl {

	@Inject
	private ComparerWrapperLog LOG;

	/** The date start. */
	private Date dateStart;

	/** The lastupdate. */
	private final Map<String, Date> lastupdate;

	/**
	 * Instantiates a new strategy betfred make url.
	 */
	public StrategyBetgunMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws NumberOfUrlParameterIncorrectException
	 */
	@Override
	public List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker) throws URLOutConfigurationException, TimeOutReaderURLException {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		List<BeanUrlMaker> urls;

		urls = super.getUrls(bookmaker);
		urls = getBeanUrlMakerByUrlDataTypes(urls, UrlDataTypes.PARAMETERS);
		if (urls.size() != 1) {
			throw new URLOutConfigurationException("La configuración del bookmaker no contiene la URL necesaria");
		}

		String urlTemplate = null;

		for (BeanUrlMaker urlBean : urls) {
			urlTemplate = urlBean.getUrl();
			break;
		}
		LOG.debug(Thread.currentThread(),
				new StringBuffer().append("Utilizamos la URL: ").append(urlTemplate).append(" para obtener las competiciones").toString());
		Document doc = makeDocument(urlTemplate);

		String segURL = "";
		String tournamentName = "";
		for (Element node : doc.getElementsByTag("discipline")) {
			List<TextNode> textos = node.textNodes();
			int contador = 0;
			for (Element subnode : node.getAllElements()) {
				if (!subnode.hasAttr("name")) {
					segURL = subnode.attr("href");
					tournamentName = textos.get(contador).text();
					BeanUrlMaker beanUrlMaker = new BeanUrlMaker();
					beanUrlMaker.setUrlDataTypes(UrlDataTypes.DATA);
					beanUrlMaker.setUrl(segURL);
					BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader = new BeanAdditionalXmlInfoReader("", tournamentName, "");
					beanUrlMaker.setBeanAdditionalXmlInfoReader(beanAdditionalXmlInfoReader);
					result.add(beanUrlMaker);
					contador++;
				}
			}
			node = node.child(0);
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
		return StrategyType.BETGUN;
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
