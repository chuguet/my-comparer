/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.app.util.xml.download.app.task;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.synchro.reader.datasource.config.ProxyPassConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;

/**
 * The Class XmlDownloadScheduledProcessor.
 */
@Service
public class XmlDownloadScheduledProcessor implements Processor {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlDownloadScheduledProcessor.class);

	/** The bookmaker repository. */
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	@Inject
	private ProxyPassConfig proxyPassConfig;

	/** {@inheritDoc} */
	@Scheduled(fixedDelay = 900000)
	public void process() {
		LOG.info("processing next 10 at " + new Date());
		Iterable<CfgBookmaker> bookmakers = bookmakerRepository.findAll();
		Date date = new Date();
		for (CfgBookmaker cfgBookmaker : bookmakers) {

			try {
				Set<CfgBookmakerDataUrl> bookmakerDataUrls = cfgBookmaker
						.getBookmakerConfiguration().getBookmakerUrl();
				for (CfgBookmakerDataUrl cfgBookmakerDataUrl : bookmakerDataUrls) {
					DownloadXmlTasklet downloadXmlTasklet = new DownloadXmlTasklet();
					downloadXmlTasklet.setDate(date);
					downloadXmlTasklet.setName(cfgBookmaker.getName(null));
					downloadXmlTasklet.setUrl(new URL(cfgBookmakerDataUrl
							.getUrl()));
					downloadXmlTasklet.setProxyPassConfig(proxyPassConfig);
					LOG.info("Reading: [" + downloadXmlTasklet.getName()
							+ "] URL: [" + downloadXmlTasklet.getUrl() + "]");
					downloadXmlTasklet.execute();
				}

			} catch (IOException e) {
				LOG.error(e.getMessage(), e);
			}
			catch (XmlNotFoundException e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}
}
