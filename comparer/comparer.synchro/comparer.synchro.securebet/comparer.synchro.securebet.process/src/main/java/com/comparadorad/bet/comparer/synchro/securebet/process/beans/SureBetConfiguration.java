/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.beans;

import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;
import com.comparadorad.bet.comparer.model.securebet.service.ICfgSureBetService;

/**
 * The Class SureBetConfiguration.
 */
@Component
public class SureBetConfiguration {

	/** The cfg sure bet config. */
	@Inject
	private ICfgSureBetService cfgSureBetConfig;

	/** The max benefit. */
	private Double maxBenefit;

	/** The max participant. */
	@Value("${configuration.process.max.participants}")
	private Integer maxParticipant;

	/** The min benefit. */
	private Double minBenefit;

	/** The core pool size. */
	@Value("${async.corePoolSize}")
	private Integer sureBetsCorePoolSize;
	/** The max pool size. */
	@Value("${async.maxPoolSize}")
	private Integer sureBetsMaxPoolSize;

	/** The queue capacity. */
	@Value("${async.queueCapacity}")
	private Integer sureBetsQueueCapacity;

	/** The thread name prefix. */
	@Value("${async.threadNamePrefix}")
	private String sureBetsThreadNamePrefix;

	/**
	 * Creates the filter.
	 */
	@PostConstruct
	public void createFilter() {
		Iterator<CfgSureBet> sureBetIterator = cfgSureBetConfig.findAll()
				.iterator();
		if (sureBetIterator.hasNext()) {
			CfgSureBet cfgSureBet = sureBetIterator.next();
			this.maxBenefit = cfgSureBet.getMaxBenefit().getValue();
			this.minBenefit = cfgSureBet.getMinBenefit().getValue();
		}
	}

	/**
	 * Gets the max benefit.
	 * 
	 * @return the max benefit
	 */
	public Double getMaxBenefit() {
		return maxBenefit;
	}

	/**
	 * Gets the max participant.
	 * 
	 * @return the max participant
	 */
	public Integer getMaxParticipant() {
		return maxParticipant;
	}

	/**
	 * Gets the min benefit.
	 * 
	 * @return the min benefit
	 */
	public Double getMinBenefit() {
		return minBenefit;
	}

	/**
	 * Gets the sure bets core pool size.
	 * 
	 * @return the sure bets core pool size
	 */
	public Integer getSureBetsCorePoolSize() {
		return sureBetsCorePoolSize;
	}

	/**
	 * Gets the sure bets max pool size.
	 * 
	 * @return the sure bets max pool size
	 */
	public Integer getSureBetsMaxPoolSize() {
		return sureBetsMaxPoolSize;
	}

	/**
	 * Gets the sure bets queue capacity.
	 * 
	 * @return the sure bets queue capacity
	 */
	public Integer getSureBetsQueueCapacity() {
		return sureBetsQueueCapacity;
	}

	/**
	 * Gets the sure bets thread name prefix.
	 * 
	 * @return the sure bets thread name prefix
	 */
	public String getSureBetsThreadNamePrefix() {
		return sureBetsThreadNamePrefix;
	}

	/**
	 * Sets the max participant.
	 * 
	 * @param maxParticipant
	 *            the new max participant
	 */
	public void setMaxParticipant(Integer maxParticipant) {
		this.maxParticipant = maxParticipant;
	}

	/**
	 * Sets the sure bets core pool size.
	 * 
	 * @param sureBetsCorePoolSize
	 *            the new sure bets core pool size
	 */
	public void setSureBetsCorePoolSize(Integer sureBetsCorePoolSize) {
		this.sureBetsCorePoolSize = sureBetsCorePoolSize;
	}

	/**
	 * Sets the sure bets max pool size.
	 * 
	 * @param sureBetsMaxPoolSize
	 *            the new sure bets max pool size
	 */
	public void setSureBetsMaxPoolSize(Integer sureBetsMaxPoolSize) {
		this.sureBetsMaxPoolSize = sureBetsMaxPoolSize;
	}

	/**
	 * Sets the sure bets queue capacity.
	 * 
	 * @param sureBetsQueueCapacity
	 *            the new sure bets queue capacity
	 */
	public void setSureBetsQueueCapacity(Integer sureBetsQueueCapacity) {
		this.sureBetsQueueCapacity = sureBetsQueueCapacity;
	}

	/**
	 * Sets the sure bets thread name prefix.
	 * 
	 * @param sureBetsThreadNamePrefix
	 *            the new sure bets thread name prefix
	 */
	public void setSureBetsThreadNamePrefix(String sureBetsThreadNamePrefix) {
		this.sureBetsThreadNamePrefix = sureBetsThreadNamePrefix;
	}

}
