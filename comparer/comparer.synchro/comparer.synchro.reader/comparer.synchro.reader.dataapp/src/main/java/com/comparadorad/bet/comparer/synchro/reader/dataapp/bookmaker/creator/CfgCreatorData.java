/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator;

import com.comparadorad.bet.comparer.model.config.bean.CfgHistoricUser;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.AbstractHistoricChange;
import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmaker;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;

/**
 * The Class CfgCreatorData.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
public class CfgCreatorData<T extends AbstractI18nTableActivable, I extends ICfgSynonyms> {

	/** The add data. */
	private boolean addDataToDbreadFile = true;

	/** The is doubt. */
	private boolean isDoubt = false;

	/**
	 * Checks if is doubt.
	 * 
	 * @return true, if is doubt
	 */
	public boolean isDoubt() {
		return isDoubt;
	}

	/**
	 * Sets the doubt.
	 * 
	 * @param pIsDoubt
	 *            the new doubt
	 */
	public void setDoubt(boolean pIsDoubt) {
		isDoubt = pIsDoubt;
	}

	public LogEventBookmakerMasterWords getLogEventBookmakerMasterWords() {
		return logEventBookmakerMasterWords;
	}

	public void setLogEventBookmakerMasterWords(
			LogEventBookmakerMasterWords logEventBookmakerMasterWords) {
		this.logEventBookmakerMasterWords = logEventBookmakerMasterWords;
	}

	/** The log event bookmaker master words. */
	private LogEventBookmakerMasterWords logEventBookmakerMasterWords;

	/** The model data. */
	private T modelData;

	/** The synonyms. */
	private I synonyms;

	/**
	 * Checks if is adds the data.
	 * 
	 * @return true, if is adds the data
	 */
	public boolean isAddDataToDbreadFile() {
		return addDataToDbreadFile;
	}


	/**
	 * Gets the model data.
	 * 
	 * @return the model data
	 */
	public T getModelData() {
		return modelData;
	}

	/**
	 * Gets the synonyms.
	 * 
	 * @return the synonyms
	 */
	public I getSynonyms() {
		return synonyms;
	}

	/**
	 * Sets the adds the data.
	 * 
	 * @param pAddData
	 *            the new adds the data
	 */
	public void setAddDataToDbreadFile(boolean pAddData) {
		addDataToDbreadFile = pAddData;
	}

	/**
	 * Sets the historic creation data.
	 * 
	 * @param abstractHistoricChange
	 *            the new historic creation data
	 */
	protected void setHistoricCreationData(
			AbstractHistoricChange abstractHistoricChange) {
		abstractHistoricChange
				.setHistoricCreationData(CfgHistoricUser.APP_VERIFIED.nameId());
	}


	/**
	 * Sets the model data.
	 * 
	 * @param pModelData
	 *            the new model data
	 */
	public void setModelData(T pModelData) {
		if (pModelData instanceof AbstractHistoricChange) {
			setHistoricCreationData((AbstractHistoricChange) pModelData);
		}
		modelData = pModelData;
	}

	/**
	 * Sets the synonyms.
	 * 
	 * @param pSynonyms
	 *            the new synonyms
	 */
	public void setSynonyms(I pSynonyms) {
		if (pSynonyms instanceof AbstractHistoricChange) {
			setHistoricCreationData((AbstractHistoricChange) pSynonyms);
		}
		synonyms = pSynonyms;
	}
}
