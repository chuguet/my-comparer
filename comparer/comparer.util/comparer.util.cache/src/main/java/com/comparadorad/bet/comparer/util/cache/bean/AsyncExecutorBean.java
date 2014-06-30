/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.bean;

/**
 * The Class AsyncExecutorBean.
 */
public class AsyncExecutorBean {

	/** The core pool size. */
	private Integer corePoolSize;

	/** The max pool size. */
	private Integer maxPoolSize;

	/** The queue capacity. */
	private Integer queueCapacity;

	/** The thread name prefix. */
	private String threadNamePrefix;

	/**
	 * Gets the core pool size.
	 * 
	 * @return the core pool size
	 */
	public Integer getCorePoolSize() {
		return corePoolSize;
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
	 * Sets the core pool size.
	 * 
	 * @param corePoolSize
	 *            the new core pool size
	 */
	public void setCorePoolSize(Integer corePoolSize) {
		this.corePoolSize = corePoolSize;
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

	@Override
	public String toString() {
		return "AsyncExecutorBean [corePoolSize=" + corePoolSize
				+ ", maxPoolSize=" + maxPoolSize + ", queueCapacity="
				+ queueCapacity + ", threadNamePrefix=" + threadNamePrefix
				+ "]";
	}

}
