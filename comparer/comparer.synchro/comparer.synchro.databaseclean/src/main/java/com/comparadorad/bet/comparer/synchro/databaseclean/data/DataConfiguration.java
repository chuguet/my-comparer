/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.databaseclean.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class DataConfiguration.
 */
@Component
public class DataConfiguration {

	/** The generic path. */
	@Value("${path.zip}")
	private String genericPath;

	/** The limit query. */
	@Value("${limit.query}")
	private Integer limitQuery;
	
	@Value("${limit.logEventSize}")
	private Integer logEventSize;

	/**
	 * Gets the generic path.
	 * 
	 * @return the generic path
	 */
	public String getGenericPath() {
		return genericPath;
	}

	/**
	 * Gets the limit query.
	 * 
	 * @return the limit query
	 */
	public Integer getLimitQuery() {
		return limitQuery;
	}

	/**
	 * Sets the generic path.
	 * 
	 * @param genericPath
	 *            the new generic path
	 */
	public void setGenericPath(String genericPath) {
		this.genericPath = genericPath;
	}

	/**
	 * Sets the limit query.
	 * 
	 * @param limitQuery
	 *            the new limit query
	 */
	public void setLimitQuery(Integer limitQuery) {
		this.limitQuery = limitQuery;
	}
	
	/**
	 * Gets the limit query.
	 * 
	 * @return the limit query
	 */
	public Integer getLogEventSize() {
		return logEventSize;
	}

}
