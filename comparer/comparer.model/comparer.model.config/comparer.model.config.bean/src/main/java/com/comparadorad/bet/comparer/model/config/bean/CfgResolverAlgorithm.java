/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import uk.ac.shef.wit.simmetrics.similaritymetrics.AbstractStringMetric;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Class CfgResolverAlgorithm.
 */
public class CfgResolverAlgorithm implements IDocument {

	/** The algorithm. */
	private AbstractStringMetric algorithm;

	/** The limit. */
	private Double limit;

	/**
	 * The Constructor.
	 */
	public CfgResolverAlgorithm() {
		super();
	}

	/**
	 * The Constructor.
	 * 
	 * @param algorithm
	 *            the algorithm
	 * @param limit
	 *            the limit
	 */
	public CfgResolverAlgorithm(AbstractStringMetric algorithm, Double limit) {
		super();
		this.algorithm = algorithm;
		this.limit = limit;
	}

	/**
	 * Gets the algorithm.
	 * 
	 * @return the algorithm
	 */
	public AbstractStringMetric getAlgorithm() {
		return algorithm;
	}

	/**
	 * Sets the algorithm.
	 * 
	 * @param algorithm
	 *            the algorithm
	 */
	public void setAlgorithm(AbstractStringMetric algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * Gets the limit.
	 * 
	 * @return the limit
	 */
	public Double getLimit() {
		return limit;
	}

	/**
	 * Sets the limit.
	 * 
	 * @param limit
	 *            the limit
	 */
	public void setLimit(Double limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "CfgResolverAlgorithm [algorithm=" + algorithm + ", limit="
				+ limit + "]";
	}	
	

}
