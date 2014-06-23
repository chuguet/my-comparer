/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.app.util.xml.download.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.app.util.xml.download.config.XmlDownloadAppConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BatchXmlDownloadApp.
 */
public class BatchXmlDownloadApp {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(BatchXmlDownloadApp.class);

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		LOG.info("Batch app for obtaining xml");
		AnnotationConfigApplicationContext context;
		context = new AnnotationConfigApplicationContext();
		((ConfigurableApplicationContext) context).getEnvironment()
				.setActiveProfiles(ProfileConstant.DEV,
						ProfileConstant.DATASOURCEPROXY_ACTIVE_FALSE);
		context.register(XmlDownloadAppConfig.class);
		context.refresh();
	}
}
