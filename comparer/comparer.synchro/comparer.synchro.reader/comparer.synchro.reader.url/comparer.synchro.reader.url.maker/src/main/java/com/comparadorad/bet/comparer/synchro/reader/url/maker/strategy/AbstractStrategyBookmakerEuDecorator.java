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

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.UrlFilterWord;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class AbstractStrategyBookmakerDecorator.
 */
public abstract class AbstractStrategyBookmakerEuDecorator extends AbstractStrategyGenericMakeUrl {

	/** The Constant LEAGUE_DESC_ATTRIBUTE. */
	private final static String LEAGUE_DESC_ATTRIBUTE = "desc";

	/** The Constant LEAGUE_ID_ATTRIBUTE. */
	private final static String LEAGUE_ID_ATTRIBUTE = "id";

	/** The Constant LEAGUE_TAG. */
	private final static String LEAGUE_TAG = "league";

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The Constant SPORT_NAME_ATTRIBUTE. */
	private final static String SPORT_NAME_ATTRIBUTE = "value";

	/** The Constant SPORT_TAG_NAME. */
	private final static String SPORT_TAG = "Index";

	/** {@inheritDoc} */
	@Override
	protected Boolean contains(String string, CfgBookmakerConfiguration bookmakerConfiguration) {
		for (UrlFilterWord urlFilterWord : bookmakerConfiguration.getFilterMakeUrl()) {
			if (string.contains(urlFilterWord.getString())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the date start.
	 * 
	 * @return the date start {@inheritDoc}
	 */
	@Override
	protected abstract Date getDateStart();

	/**
	 * Gets the lastupdate.
	 * 
	 * @return the lastupdate {@inheritDoc}
	 */
	@Override
	protected abstract Map<String, Date> getLastupdate();

	/**
	 * Gets the map leagues by sport.
	 * 
	 * @param url
	 *            the url
	 * @param bookmaker
	 *            the bookmaker
	 * @return the map leagues by sport
	 * @throws URLOutConfigurationException
	 *             the uRL out configuration exception
	 */
	private BeanAdditionalXmlInfoReader getMapLeaguesBySport(String url, CfgBookmaker bookmaker) throws URLOutConfigurationException {
		BeanAdditionalXmlInfoReader result = new BeanAdditionalXmlInfoReader(new HashMap<String, String>());

		Document doc = makeDocument(url);

		for (Element node : doc.getElementsByTag(SPORT_TAG)) {
			String sportName = node.attr(SPORT_NAME_ATTRIBUTE);
			for (Element subnode : node.getElementsByTag(LEAGUE_TAG)) {
				if (!contains(subnode.attr(LEAGUE_DESC_ATTRIBUTE), bookmaker.getBookmakerConfiguration())) {
					String idLeague = subnode.attr(LEAGUE_ID_ATTRIBUTE);
					result.getMapLeaguesBySport().put(idLeague, sportName);
				} else {
					LOG.warn(
							Thread.currentThread(),
							new StringBuffer().append("No se va a procesar la liga con descripcion: ")
									.append(subnode.attr(LEAGUE_DESC_ATTRIBUTE)).append(" ya que esta apuntada en la lista negra de la BD")
									.toString());
				}
			}
		}
		return result;
	}

	/**
	 * Gets the urls. Bookmaker.eu tiene una url donde asocia todas las
	 * competiciones con su deporte. Leemos esta url (guardado en BD como la url
	 * de tipo PARAMETER) y guardamos las relaciones entre competiciones y
	 * deportes en un mapa dentro del BeanAdditionalXmlInfoReader. Pasamos este
	 * bean junto con la url de tipo DATA al reader.
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
		BeanUrlMaker beanUrlData = new BeanUrlMaker();
		BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader;
		List<BeanUrlMaker> configUrls;
		List<BeanUrlMaker> parameterUrls;
		List<BeanUrlMaker> dataUrls;
		BeanUrlMaker parameterUrl;
		BeanUrlMaker dataUrl;

		try {
			configUrls = super.getUrls(bookmaker);
			parameterUrls = getBeanUrlMakerByUrlDataTypes(configUrls, UrlDataTypes.PARAMETERS);

			if (parameterUrls.size() == 1) {
				parameterUrl = parameterUrls.get(0);
			} else {
				throw new URLOutConfigurationException(new StringBuffer()
						.append("La configuracion del bookmaker esta mal. Se esperaba 1 url de tipo PARAMETERS pero se ha encontrado ")
						.append(parameterUrls.size()).toString());

			}

			beanAdditionalXmlInfoReader = getMapLeaguesBySport(parameterUrl.getUrl(), bookmaker);
			beanUrlData.setBeanAdditionalXmlInfoReader(beanAdditionalXmlInfoReader);

			dataUrls = getBeanUrlMakerByUrlDataTypes(configUrls, UrlDataTypes.DATA);
			if (dataUrls.size() == 1) {
				dataUrl = dataUrls.get(0);
			} else {
				throw new URLOutConfigurationException(new StringBuffer()
						.append("La configuracion del bookmaker esta mal. Se esperaba 1 url de tipo DATA pero se ha encontrado ")
						.append(dataUrls.size()).toString());
			}
			beanUrlData.setUrl(dataUrl.getUrl());

			result.add(beanUrlData);

		} catch (URLOutConfigurationException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new URLOutConfigurationException(e);
		}
		return result;
	}

}
