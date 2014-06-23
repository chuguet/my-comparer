/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.core.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * The Class AbstractQueueCoreConfig.
 */
public abstract class AbstractQueueCoreConfig {

	/** The first surebest queue. */
	@Value("${config.queue.surebet.one}")
	private String firstSurebestQueue;

	/** The fourth surebets queue. */
	@Value("${config.queue.surebet.four}")
	private String fourthSurebetsQueue;

	/** The host. */
	@Value("${config.server.host}")
	private String host;

	/** The password. */
	@Value("${config.server.password}")
	private String password;

	/** The second surebets queue. */
	@Value("${config.queue.surebet.two}")
	private String secondSurebetsQueue;

	/** The third surebets queue. */
	@Value("${config.queue.surebet.three}")
	private String thirdSurebetsQueue;

	/** The updater bets queue. */
	@Value("${config.queue.updater.bets}")
	private String updaterBetsQueue;

	/** The user. */
	@Value("${config.server.user}")
	private String user;

	/** The valuebet queue. */
	@Value("${config.queue.valuebet}")
	private String valuebetQueue;

	/**
	 * Gets the first surebest queue.
	 * 
	 * @return the first surebest queue
	 */
	public String getFirstSurebestQueue() {
		return firstSurebestQueue;
	}

	/**
	 * Gets the fourth surebets queue.
	 * 
	 * @return the fourth surebets queue
	 */
	public String getFourthSurebetsQueue() {
		return fourthSurebetsQueue;
	}

	/**
	 * Gets the host.
	 * 
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the second surebets queue.
	 * 
	 * @return the second surebets queue
	 */
	public String getSecondSurebetsQueue() {
		return secondSurebetsQueue;
	}

	/**
	 * Gets the third surebets queue.
	 * 
	 * @return the third surebets queue
	 */
	public String getThirdSurebetsQueue() {
		return thirdSurebetsQueue;
	}

	/**
	 * Gets the updater bets queue.
	 * 
	 * @return the updater bets queue
	 */
	public String getUpdaterBetsQueue() {
		return updaterBetsQueue;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Gets the valuebet queue.
	 * 
	 * @return the valuebet queue
	 */
	public String getValuebetQueue() {
		return valuebetQueue;
	}


}
