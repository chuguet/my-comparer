/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.dbcore.dbinit;

/**
 * The Class MongoInitializerParams.
 */
public class MongoInitializerParams {

	/** The create data. */
	private boolean createData = true;

	/** The default behavior. */
	private boolean defaultBehavior = true;

	/** The drop database. */
	private boolean dropDatabase = true;

	/**
	 * Instantiates a new mongo initializer params.
	 */
	public MongoInitializerParams() {
		super();
	}
	
	/**
	 * Instantiates a new mongo initializer params.
	 *
	 * @param pDropDatabase the drop database
	 * @param pCreateData the create data
	 * @param pDefaultBehavior the default behavior
	 */
	public MongoInitializerParams(boolean pDropDatabase, boolean pCreateData, boolean pDefaultBehavior) {
		super();
		dropDatabase = pDropDatabase;
		createData = pCreateData;
		defaultBehavior = pDefaultBehavior;
	}

	/**
	 * Checks if is creates the data.
	 * 
	 * @return true, if is creates the data
	 */
	public boolean isCreateData() {
		return createData;
	}

	/**
	 * Checks if is default behavior.
	 *
	 * @return true, if is default behavior
	 */
	public boolean isDefaultBehavior() {
		return defaultBehavior;
	}

	/**
	 * Checks if is drop database.
	 * 
	 * @return true, if is drop database
	 */
	public boolean isDropDatabase() {
		return dropDatabase;
	}

	/**
	 * Sets the creates the data.
	 * 
	 * @param pCreateData
	 *            the new creates the data
	 */
	public void setCreateData(boolean pCreateData) {
		createData = pCreateData;
	}

	/**
	 * Sets the default behavior.
	 *
	 * @param defaultBehavior the new default behavior
	 */
	public void setDefaultBehavior(boolean defaultBehavior) {
		this.defaultBehavior = defaultBehavior;
	}

	/**
	 * Sets the drop database.
	 * 
	 * @param pDropDatabase
	 *            the new drop database
	 */
	public void setDropDatabase(boolean pDropDatabase) {
		dropDatabase = pDropDatabase;
	}
}
