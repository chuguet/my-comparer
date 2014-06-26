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
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.url.core.bean.UriParameterBean;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;

/**
 * The Class AbstractStrategyRebootUrlMaker.
 */
public abstract class AbstractStrategyRebootUrlMaker extends
		AbstractStrategyGenericMakeUrl {

	/** The Constant FIRST_SEPARATOR. */
	private final static String FIRST_SEPARATOR = "?";

	/** The Constant SEPARATOR. */
	private final static String SEPARATOR = "&";

	/** The Constant ASSIGNED. */
	private final static String ASSIGNED = "=";

	/** The next reboot url maker. */
	private Date nextRebootUrlMaker;

	/** The reboot time. */
	private Date rebootTime;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(StrategyPinnacleMakeUrl.class);

	/**
	 * Make uri.
	 * 
	 * @param parameters
	 *            the parameters
	 * @param urls
	 *            the urls
	 * @param milliseconds
	 *            the milliseconds
	 * @return the list
	 */
	protected List<BeanUrlMaker> makeURI(
			final List<UriParameterBean> parameters,
			final List<BeanUrlMaker> urls,
			CfgBookmakerConfiguration cfgBookmakerConfiguration)
			throws URLOutConfigurationException {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		StringBuffer uri = new StringBuffer();
		Boolean flag = Boolean.TRUE;
		BeanUrlMaker beanUrlMaker;
		StringBuffer URL;

		for (UriParameterBean parameter : parameters) {
			if (flag) {
				uri.append(FIRST_SEPARATOR);
			}

			uri.append(parameter.getName());
			uri.append(ASSIGNED);
			uri.append(parameter.getValue());
			uri.append(SEPARATOR);

			flag = Boolean.FALSE;
		}

		for (BeanUrlMaker url : urls) {
			beanUrlMaker = new BeanUrlMaker();
			URL = new StringBuffer();
			if (!isRebootUrlMaker(url, cfgBookmakerConfiguration)) {
				URL.append(url.getUrl());
			} else {
				URL.append(url.getUrl()).append(uri);
			}
			beanUrlMaker.setUrl(URL.toString());
			result.add(beanUrlMaker);
		}

		return result;
	}

	/**
	 * Checks if is reboot url maker.
	 * 
	 * @param beanUrlMaker
	 *            the bean url maker
	 * @param milliseconds
	 *            the milliseconds
	 * @return the boolean
	 */
	protected Boolean isRebootUrlMaker(final BeanUrlMaker beanUrlMaker,
			final CfgBookmakerConfiguration cfgBookmakerConfiguration)
			throws URLOutConfigurationException {
		Boolean result = Boolean.FALSE;
		Date lastUpdate;

		if (cfgBookmakerConfiguration.getRebootUrlMaker() != null
				&& cfgBookmakerConfiguration.getRebootTime() != null) {
			if (getLastupdate().containsKey(beanUrlMaker.getUrl())) {
				lastUpdate = getLastupdate().get(beanUrlMaker.getUrl());

				LOG.info(new StringBuffer("La ultima descarga de la URL: ")
						.append(beanUrlMaker.getUrl())
						.append(". Se realizo el: ").append(lastUpdate).append(
						" La fecha del proximo reinicio es: ").append(nextRebootUrlMaker));

				if (nextRebootUrlMaker == null) {
					
					nextRebootUrlMaker = new Date(lastUpdate.getTime()
							+ cfgBookmakerConfiguration.getRebootUrlMaker());
					
				} 
				if (nextRebootUrlMaker.before(lastUpdate)) {
					if (rebootTime == null) {
						rebootTime = new Date(lastUpdate.getTime()
								+ cfgBookmakerConfiguration.getRebootTime());
						
						LOG.info(new StringBuffer(
								"El tiempo que va a permanecer reiniciada: ")
								.append(nextRebootUrlMaker));
						
					} 
					if (rebootTime.before(lastUpdate)) {
						
						LOG.info(new StringBuffer(
								"Se reinicia el tiempo de reinicio"));
						
						result = Boolean.TRUE;
						nextRebootUrlMaker = null;
						rebootTime = null;
					}
				}
			}

		} else {
			throw new URLOutConfigurationException(
					"Es necesario rellenar rebootUrlMaker y rebootTime");
		}

		return result;
	}

}
