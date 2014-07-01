/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.util;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.HashNames;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IIpcEventUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.IpcEventFactory;

/**
 * The Class ResultsViewHashState.
 */
public class ResultsViewHashState {

	/** The hash. */
	private String hash = "";

	/** The inicial bet type event tab. */
	private String inicialBetTypeEventTab;

	/** The inicial bet type tab. */
	private String inicialBetTypeTab;

	/** The inicial head tab. */
	private String inicialHeadTab;

	/** The ipc event util. */
	private IIpcEventUtil ipcEventUtil = IpcEventFactory.getInstance().createIpcEventUtil();

	/** The old hash. */
	private String oldHash;

	/** The view responsible of fixating the hash. */
	private boolean viewResponsibleOfFixatingTheHash = true;

	/**
	 * Instantiates a new results view hash state.
	 */
	public ResultsViewHashState() {
		super();
	}

	/**
	 * Adds the hash.
	 * 
	 * @param parameterName
	 *            the parameter name
	 * @param parameterValue
	 *            the parameter value
	 * @param fixHash
	 *            the fix hash
	 */
	private void addHash(String parameterName, String parameterValue, boolean fixHash) {
		Log.debug("oldHash: " + oldHash);
		Log.debug("hashParameterName = " + parameterName + ", hashParameterValue = " + parameterValue);
		hash = new StringBuffer(hash).append(parameterName).append("=").append(parameterValue).append(";").toString();
		Log.debug("newHash: " + hash);
		Log.debug("viewResponsibleOfFixatingTheHash = " + viewResponsibleOfFixatingTheHash + ", fixHash = " + fixHash);
		if (fixHash && !oldHash.equalsIgnoreCase(hash)) {
			if (viewResponsibleOfFixatingTheHash) {
				Log.debug("Fixating hash: " + hash);
				ipcEventUtil.setHash(hash);
			}
			viewResponsibleOfFixatingTheHash = true;
		}
	}

	/**
	 * Clean hash from bet type event tab.
	 */
	protected void cleanHashFromBetTypeEventTab() {
		Log.debug("Se ejecuta cleanHashFromBetTypeEventTab");
		if (hash.contains(HashNames.TAB_BET_TYPE__EVENT_HASH)) {
			hash = hash.substring(0, hash.indexOf(HashNames.TAB_BET_TYPE__EVENT_HASH));
			inicialBetTypeEventTab = null;
		}
	}

	/**
	 * Método necesario para que la primera vez que accedemos a un evento de
	 * apuesta porque vengamos redirigidos de algun sitio se marque
	 * correctamente el evento de apuesta pero que inmediatamente se inicialice
	 * para el resto de apuestas.
	 */
	public void clearInitialBetEventTab() {
		inicialBetTypeEventTab = null;
	}

	/**
	 * Clean hash from bet type tab.
	 */
	protected void cleanHashFromBetTypeTab() {
		Log.debug("Se ejecuta cleanHashFromBetTypeTab");
		if (hash.contains(HashNames.TAB_BET_TYPE_HASH)) {
			hash = hash.substring(0, hash.indexOf(HashNames.TAB_BET_TYPE_HASH));
		}
	}

	/**
	 * Clean hash from head tab.
	 */
	protected void cleanHashFromHeadTab() {
		Log.debug("cleanHashFromHeadTab");
		if (hash.contains(HashNames.TAB_HEAD_HASH)) {
			hash = hash.substring(0, hash.indexOf(HashNames.TAB_HEAD_HASH));
		}
	}

	/**
	 * Fixate hash directly.
	 */
	public void fixateHashDirectly() {
		Log.debug("Fixating hash: " + hash);
		ipcEventUtil.setHash(hash);
	}

	/**
	 * Gets the hash.
	 * 
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * Gets the inicial bet type event tab.
	 * 
	 * @return the inicial bet type event tab
	 */
	public String getInicialBetTypeEventTab() {
		return inicialBetTypeEventTab;
	}

	/**
	 * Gets the inicial bet type tab.
	 * 
	 * @return the inicial bet type tab
	 */
	public String getInicialBetTypeTab() {
		return inicialBetTypeTab;
	}

	/**
	 * Gets the inicial head tab.
	 * 
	 * @return the inicial head tab
	 */
	public String getInicialHeadTab() {
		return inicialHeadTab;
	}

	/**
	 * Gets the old hash.
	 * 
	 * @return the old hash
	 */
	public String getOldHash() {
		return oldHash;
	}

	/**
	 * Checks if is view responsible of fixating the hash.
	 * 
	 * @return true, if is view responsible of fixating the hash
	 */
	public boolean isViewResponsibleOfFixatingTheHash() {
		return viewResponsibleOfFixatingTheHash;
	}

	/**
	 * Sets the bet type event hash.
	 * 
	 * @param id
	 *            the id
	 * @param fixHash
	 *            the fix hash
	 */
	public void setBetTypeEventHash(String id, boolean fixHash) {
		oldHash = hash;
		addHash(HashNames.TAB_BET_TYPE__EVENT_HASH, id, fixHash);
		cleanHashFromBetTypeEventTab();

	}

	/**
	 * Sets the bet type hash.
	 * 
	 * @param id
	 *            the id
	 * @param fixHash
	 *            the fix hash
	 */
	public void setBetTypeHash(String id, boolean fixHash) {
		oldHash = hash;
		cleanHashFromBetTypeTab();
		addHash(HashNames.TAB_BET_TYPE_HASH, id, fixHash);
	}

	/**
	 * Sets the hash.
	 * 
	 * @param pHash
	 *            the new hash
	 */
	public void setHash(String pHash) {
		hash = pHash;
	}

	/**
	 * Sets the head hash.
	 * 
	 * @param id
	 *            the id
	 * @param fixHash
	 *            the fix hash
	 */
	public void setHeadHash(String id, boolean fixHash) {
		oldHash = hash;
		cleanHashFromHeadTab();
		addHash(HashNames.TAB_HEAD_HASH, id, fixHash);
	}

	/**
	 * Sets the inicial bet type event tab.
	 * 
	 * @param pInicialBetTypeEventTab
	 *            the new inicial bet type event tab
	 */
	public void setInicialBetTypeEventTab(String pInicialBetTypeEventTab) {
		inicialBetTypeEventTab = pInicialBetTypeEventTab;
	}

	/**
	 * Sets the inicial bet type tab.
	 * 
	 * @param pInicialBetTypeTab
	 *            the new inicial bet type tab
	 */
	public void setInicialBetTypeTab(String pInicialBetTypeTab) {
		inicialBetTypeTab = pInicialBetTypeTab;
	}

	/**
	 * Sets the inicial head tab.
	 * 
	 * @param pInicialHeadTab
	 *            the new inicial head tab
	 */
	public void setInicialHeadTab(String pInicialHeadTab) {
		inicialHeadTab = pInicialHeadTab;
	}

	/**
	 * Sets the old hash.
	 * 
	 * @param pOldHash
	 *            the new old hash
	 */
	public void setOldHash(String pOldHash) {
		oldHash = pOldHash;
	}

	/**
	 * Sets the result view hash.
	 * 
	 * @param hashName
	 *            the hash name
	 * @param id
	 *            the id
	 * @param fixHash
	 *            the fix hash
	 */
	public void setResultViewHash(String hashName, String id, boolean fixHash) {
		oldHash = hash;
		cleanHashFromHeadTab();
		addHash(hashName, id, fixHash);
	}

	/**
	 * Sets the view responsible of fixating the hash.
	 * 
	 * @param pViewResponsibleOfFixatingTheHash
	 *            the new view responsible of fixating the hash
	 */
	public void setViewResponsibleOfFixatingTheHash(boolean pViewResponsibleOfFixatingTheHash) {
		Log.debug("La vista va a construir el hash inicial? " + pViewResponsibleOfFixatingTheHash);
		viewResponsibleOfFixatingTheHash = pViewResponsibleOfFixatingTheHash;
	}

}
