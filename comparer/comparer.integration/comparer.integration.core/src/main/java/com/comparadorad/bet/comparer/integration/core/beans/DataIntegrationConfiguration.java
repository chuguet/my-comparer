/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.integration.core.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class DataConfiguration.
 */
@Component
public class DataIntegrationConfiguration {

	/** The core pool size. */
	@Value("${async.integration.corePoolSize}")
	private Integer corePoolSize;

	/** The host rabbit. */
	@Value("${rabbit.host}")
	private String hostRabbit;

	/** The max pool size. */
	@Value("${async.integration.maxPoolSize}")
	private Integer maxPoolSize;

	/** The pass rabbit. */
	@Value("${rabbit.pass}")
	private String passRabbit;

	/** The queue capacity. */
	@Value("${async.integration.queueCapacity}")
	private Integer queueCapacity;

	/** The thread name prefix. */
	@Value("${async.integration.threadNamePrefix}")
	private String threadNamePrefix;

	/** The updater bets queue rabbit. */
	@Value("${rabbit.queue.updaterbets}")
	private String updaterBetsQueueRabbit;

	/** The user rabbit. */
	@Value("${rabbit.user}")
	private String userRabbit;

	/**
	 * Gets the core pool size.
	 * 
	 * @return the core pool size
	 */
	public Integer getCorePoolSize() {
		return corePoolSize;
	}

	/**
	 * Gets the host rabbit.
	 * 
	 * @return the host rabbit
	 */
	public String getHostRabbit() {
		return hostRabbit;
	}

	/**
	 * Gets the max pool size.
	 * 
	 * @return the max pool size
	 */
	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	/**
	 * Gets the pass rabbit.
	 * 
	 * @return the pass rabbit
	 */
	public String getPassRabbit() {
		return passRabbit;
	}

	/**
	 * Gets the queue capacity.
	 * 
	 * @return the queue capacity
	 */
	public Integer getQueueCapacity() {
		return queueCapacity;
	}

	/**
	 * Gets the thread name prefix.
	 * 
	 * @return the thread name prefix
	 */
	public String getThreadNamePrefix() {
		return threadNamePrefix;
	}

	/**
	 * Gets the updater bets queue rabbit.
	 * 
	 * @return the updater bets queue rabbit
	 */
	public String getUpdaterBetsQueueRabbit() {
		return updaterBetsQueueRabbit;
	}

	/**
	 * Gets the user rabbit.
	 * 
	 * @return the user rabbit
	 */
	public String getUserRabbit() {
		return userRabbit;
	}

	/**
	 * Sets the core pool size.
	 * 
	 * @param corePoolSize
	 *            the new core pool size
	 */
	public void setCorePoolSize(Integer corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	/**
	 * Sets the host rabbit.
	 * 
	 * @param hostRabbit
	 *            the new host rabbit
	 */
	public void setHostRabbit(String hostRabbit) {
		this.hostRabbit = hostRabbit;
	}

	/**
	 * Sets the max pool size.
	 * 
	 * @param maxPoolSize
	 *            the new max pool size
	 */
	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	/**
	 * Sets the pass rabbit.
	 * 
	 * @param passRabbit
	 *            the new pass rabbit
	 */
	public void setPassRabbit(String passRabbit) {
		this.passRabbit = passRabbit;
	}

	/**
	 * Sets the queue capacity.
	 * 
	 * @param queueCapacity
	 *            the new queue capacity
	 */
	public void setQueueCapacity(Integer queueCapacity) {
		this.queueCapacity = queueCapacity;
	}

	/**
	 * Sets the thread name prefix.
	 * 
	 * @param threadNamePrefix
	 *            the new thread name prefix
	 */
	public void setThreadNamePrefix(String threadNamePrefix) {
		this.threadNamePrefix = threadNamePrefix;
	}

	/**
	 * Sets the updater bets queue rabbit.
	 * 
	 * @param updaterBetsQueueRabbit
	 *            the new updater bets queue rabbit
	 */
	public void setUpdaterBetsQueueRabbit(String updaterBetsQueueRabbit) {
		this.updaterBetsQueueRabbit = updaterBetsQueueRabbit;
	}

	/**
	 * Sets the user rabbit.
	 * 
	 * @param userRabbit
	 *            the new user rabbit
	 */
	public void setUserRabbit(String userRabbit) {
		this.userRabbit = userRabbit;
	}

}
