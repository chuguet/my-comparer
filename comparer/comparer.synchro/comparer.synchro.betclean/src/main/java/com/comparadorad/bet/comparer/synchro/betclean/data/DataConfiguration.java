/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class DataConfiguration.
 */
@Component
public class DataConfiguration {

	/** The core pool size. */
	@Value("${async.draft.corePoolSize}")
	private Integer draftCorePoolSize;

	/** The max pool size. */
	@Value("${async.draft.maxPoolSize}")
	private Integer draftMaxPoolSize;

	/** The queue capacity. */
	@Value("${async.draft.queueCapacity}")
	private Integer draftQueueCapacity;

	/** The thread name prefix. */
	@Value("${async.draft.threadNamePrefix}")
	private String draftThreadNamePrefix;

	/** The limit query matchs. */
	@Value("${config.limitQueryMatchs}")
	private Integer limitQueryMatchs;

	/** The core pool size. */
	@Value("${async.update.corePoolSize}")
	private Integer updateCorePoolSize;

	/** The max pool size. */
	@Value("${async.update.maxPoolSize}")
	private Integer updateMaxPoolSize;

	/** The queue capacity. */
	@Value("${async.update.queueCapacity}")
	private Integer updateQueueCapacity;

	/** The thread name prefix. */
	@Value("${async.update.threadNamePrefix}")
	private String updateThreadNamePrefix;

	/**
	 * Gets the draft core pool size.
	 * 
	 * @return the draft core pool size
	 */
	public Integer getDraftCorePoolSize() {
		return draftCorePoolSize;
	}

	/**
	 * Gets the draft max pool size.
	 * 
	 * @return the draft max pool size
	 */
	public Integer getDraftMaxPoolSize() {
		return draftMaxPoolSize;
	}

	/**
	 * Gets the draft queue capacity.
	 * 
	 * @return the draft queue capacity
	 */
	public Integer getDraftQueueCapacity() {
		return draftQueueCapacity;
	}

	/**
	 * Gets the draft thread name prefix.
	 * 
	 * @return the draft thread name prefix
	 */
	public String getDraftThreadNamePrefix() {
		return draftThreadNamePrefix;
	}

	/**
	 * Gets the limit query matchs.
	 * 
	 * @return the limit query matchs
	 */
	public Integer getLimitQueryMatchs() {
		return limitQueryMatchs;
	}

	/**
	 * Gets the update core pool size.
	 * 
	 * @return the update core pool size
	 */
	public Integer getUpdateCorePoolSize() {
		return updateCorePoolSize;
	}

	/**
	 * Gets the update max pool size.
	 * 
	 * @return the update max pool size
	 */
	public Integer getUpdateMaxPoolSize() {
		return updateMaxPoolSize;
	}

	/**
	 * Gets the update queue capacity.
	 * 
	 * @return the update queue capacity
	 */
	public Integer getUpdateQueueCapacity() {
		return updateQueueCapacity;
	}

	/**
	 * Gets the update thread name prefix.
	 * 
	 * @return the update thread name prefix
	 */
	public String getUpdateThreadNamePrefix() {
		return updateThreadNamePrefix;
	}

	/**
	 * Sets the draft core pool size.
	 * 
	 * @param draftCorePoolSize
	 *            the new draft core pool size
	 */
	public void setDraftCorePoolSize(Integer draftCorePoolSize) {
		this.draftCorePoolSize = draftCorePoolSize;
	}

	/**
	 * Sets the draft max pool size.
	 * 
	 * @param draftMaxPoolSize
	 *            the new draft max pool size
	 */
	public void setDraftMaxPoolSize(Integer draftMaxPoolSize) {
		this.draftMaxPoolSize = draftMaxPoolSize;
	}

	/**
	 * Sets the draft queue capacity.
	 * 
	 * @param draftQueueCapacity
	 *            the new draft queue capacity
	 */
	public void setDraftQueueCapacity(Integer draftQueueCapacity) {
		this.draftQueueCapacity = draftQueueCapacity;
	}

	/**
	 * Sets the draft thread name prefix.
	 * 
	 * @param draftThreadNamePrefix
	 *            the new draft thread name prefix
	 */
	public void setDraftThreadNamePrefix(String draftThreadNamePrefix) {
		this.draftThreadNamePrefix = draftThreadNamePrefix;
	}

	/**
	 * Sets the limit query matchs.
	 * 
	 * @param limitQueryMatchs
	 *            the new limit query matchs
	 */
	public void setLimitQueryMatchs(Integer limitQueryMatchs) {
		this.limitQueryMatchs = limitQueryMatchs;
	}

	/**
	 * Sets the update core pool size.
	 * 
	 * @param updateCorePoolSize
	 *            the new update core pool size
	 */
	public void setUpdateCorePoolSize(Integer updateCorePoolSize) {
		this.updateCorePoolSize = updateCorePoolSize;
	}

	/**
	 * Sets the update max pool size.
	 * 
	 * @param updateMaxPoolSize
	 *            the new update max pool size
	 */
	public void setUpdateMaxPoolSize(Integer updateMaxPoolSize) {
		this.updateMaxPoolSize = updateMaxPoolSize;
	}

	/**
	 * Sets the update queue capacity.
	 * 
	 * @param updateQueueCapacity
	 *            the new update queue capacity
	 */
	public void setUpdateQueueCapacity(Integer updateQueueCapacity) {
		this.updateQueueCapacity = updateQueueCapacity;
	}

	/**
	 * Sets the update thread name prefix.
	 * 
	 * @param updateThreadNamePrefix
	 *            the new update thread name prefix
	 */
	public void setUpdateThreadNamePrefix(String updateThreadNamePrefix) {
		this.updateThreadNamePrefix = updateThreadNamePrefix;
	}

}
