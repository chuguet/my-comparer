/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.util.bookmaker;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.service.ICfgBookmakerService;

/**
 * Clase que se encarga de cargar inicialmente las casas de apuestas que se
 * encuentran activas.
 */
@Component
@Scope("singleton")
public final class ActiveBookmakers {

	/** The active bookmakers. */
	private static Long activeBookmakers;

	/** The init time. */
	private static Date initTime;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ActiveBookmakers.class);

	static {
		initTime = new Date();
	}

	/** The bookmaker service. */
	@Inject
	private ICfgBookmakerService bookmakerService;

	/** The participants competition separator. */
	@Value("${timeBetweenActiveBookmakers}")
	private int timeBetweenActiveBookmakers;

	/**
	 * Calculate minimal number of bookmakers.
	 * 
	 * @param percentOfValidEvents
	 *            the percent of valid events
	 * @return the int
	 */
	private int calculateMinimalNumberOfBookmakers(
			final int percentOfValidEvents) {
		LOG.debug(new StringBuffer()
				.append("Comprobamos cual es el numero minimo de casas de apuestas activas para el %: ")
				.append(percentOfValidEvents).toString());
		int result = 0;
		if (activeBookmakers == null
				|| activeBookmakers == 0
				|| (new Date().getTime() - initTime.getTime() >= timeBetweenActiveBookmakers)) {
			activeBookmakers = bookmakerService.getActiveBookmakers();
			initTime = new Date();
		}
		LOG.debug(new StringBuffer()
				.append("El numero total de bookmakers activos es: ")
				.append(activeBookmakers).toString());

		result = Math
				.round((activeBookmakers.floatValue() * (float) percentOfValidEvents)
						/ (float) 100);

		LOG.debug(new StringBuffer()
				.append("El numero minimo de casas de apuestas activas debe de ser: ")
				.append(result).toString());
		return result;
	}

	/**
	 * Gets the minimal number of bookmakers.
	 * 
	 * @param percentOfValidEvents
	 *            the percent of valid events
	 * @return the minimal number of bookmakers
	 */
	public int getMinimalNumberOfBookmakers(int percentOfValidEvents) {
		int result = 0;
		result = calculateMinimalNumberOfBookmakers(percentOfValidEvents);
		return result;
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		activeBookmakers = bookmakerService.getActiveBookmakers();
		initTime = new Date();
	}

}
