/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;

import org.springframework.data.mongodb.core.mapping.Document;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.bean.IObjectIdEnum;

/**
 * The Class CfgAppConfiguration.
 */
@SuppressWarnings("serial")
@Document
public class CfgAppConfiguration extends AbstractI18nTableActivable implements
		IDocument {

	/**
	 * Instantiates a new cfg app configuration.
	 */
	public CfgAppConfiguration() {
		super();
	}

	/**
	 * Instantiates a new cfg app configuration.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgAppConfiguration(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg app configuration.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgAppConfiguration(IObjectIdEnum pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg app configuration.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgAppConfiguration(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * The Class CfgClientAppConfiguration.
	 */
	public static class CfgClientAppConfiguration extends CfgAppConfiguration {

		/** The table refresh time. */
		private Integer tableRefreshTime;

		/**
		 * Gets the table refresh time.
		 * 
		 * @return the table refresh time
		 */
		public Integer getTableRefreshTime() {
			return tableRefreshTime;
		}

		/**
		 * Sets the table refresh time.
		 * 
		 * @param pTableRefreshTime
		 *            the new table refresh time
		 */
		public void setTableRefreshTime(Integer pTableRefreshTime) {
			tableRefreshTime = pTableRefreshTime;
		}
	}

}
