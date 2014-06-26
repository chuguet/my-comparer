/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step2;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTable;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.CfgCreatorData;
import com.comparadorad.bet.comparer.util.commons.locale.LocaleUtil;

/**
 * The Class CfgCreatorDataProcess.
 */
/**
 * @author Juan Carlos
 * 
 */
@SuppressWarnings("serial")
public class CfgCreatorDataProcess implements Serializable {

	/** The map creator data list. */
	private Map<String, CfgCreatorDataList> mapCreatorDataList = new HashMap<String, CfgCreatorDataList>();

	/**
	 * Adds the competition creator data.
	 * 
	 * @param pE
	 *            the p e
	 * @return true, if successful
	 */
	public boolean addCompetitionCreatorData(
			CfgCreatorData<CfgCompetition, CfgCompetitionSynonyms> pE) {
		return addCreatorData(pE, getCompetitionCreatorData(), pE.isDoubt());
	}

	/**
	 * Adds the creator data.
	 * 
	 * @param pE
	 *            the p e
	 * @param creatorDataList
	 *            the creator data list
	 * @param doubtList
	 *            the doubt list
	 * @return true, if successful
	 */
	@SuppressWarnings("rawtypes")
	private boolean addCreatorData(CfgCreatorData pE,
			CfgCreatorDataList creatorDataList, boolean doubtList) {
		if (pE != null) {
			if (existsInList(creatorDataList, pE)) {
				// if its in the list , put the flag for not to be added
				pE.setAddDataToDbreadFile(false);
			}
			return creatorDataList.add(pE);
		}
		return false;
	}

	/**
	 * Adds the match participant creator data.
	 * 
	 * @param pE
	 *            the p e
	 * @return true, if successful
	 */
	public boolean addMatchParticipantCreatorData(
			CfgCreatorData<CfgParticipant, CfgParticipantSynonyms> pE) {
		return addCreatorData(pE, getMatchParticipantCreatorData(),
				pE.isDoubt());
	}

	/**
	 * Adds the sport creator data.
	 * 
	 * @param pE
	 *            the p e
	 * @return true, if successful
	 */
	public boolean addSportCreatorData(
			CfgCreatorData<CfgSport, CfgSportSynonyms> pE) {
		return addCreatorData(pE, getSportCreatorData(), pE.isDoubt());
	}

	/**
	 * Adds the region creator data.
	 * 
	 * @param pE
	 *            the p e
	 * @return true, if successful
	 */
	public boolean addRegionCreatorData(
			CfgCreatorData<CfgRegion, CfgRegionSynonyms> pE) {
		return addCreatorData(pE, getRegionCreatorData(), pE.isDoubt());
	}

	/**
	 * Control if the name exists in the list Exists in list.
	 * 
	 * @param creatorDataList
	 *            the creator data list
	 * @param creatorData
	 *            the creator data
	 * @return true, if successful
	 */
	@SuppressWarnings({ "rawtypes" })
	private boolean existsInList(CfgCreatorDataList creatorDataList,
			CfgCreatorData<?, ?> creatorData) {
		boolean retorno = false;
		if (creatorDataList != null && creatorData != null
				&& creatorDataList.getCreatorDataList() != null) {
			for (CfgCreatorData tmpCreatorData : (List<CfgCreatorData>) creatorDataList
					.getCreatorDataList()) {

				if (tmpCreatorData.getModelData() instanceof AbstractI18nTable) {
					if (tmpCreatorData.getModelData() != null
							&& creatorData.getModelData() != null
							&& ((AbstractI18nTable) tmpCreatorData
									.getModelData())
									.getName(LocaleUtil.SPANISH) != null
							&& ((AbstractI18nTable) creatorData.getModelData())
									.getName(LocaleUtil.SPANISH) != null) {
						String tmpName = ((AbstractI18nTable) tmpCreatorData
								.getModelData()).getName(LocaleUtil.SPANISH);
						String name = ((AbstractI18nTable) creatorData
								.getModelData()).getName(LocaleUtil.SPANISH);
						if (name.equals(tmpName)) {
							retorno = true;
						}
					} else {
						retorno = false;
					}

				}
			}

		} else {
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Gets the competition creator data.
	 * 
	 * @return the competition creator data
	 */
	private CfgCreatorDataList getCompetitionCreatorData() {
		return getCreatorData("competitionCreatorData");
	}

	/**
	 * Gets the competition creator data doubt.
	 * 
	 * @return the competition creator data doubt
	 */
	private CfgCreatorDataList getCompetitionCreatorDataDoubt() {
		return getCreatorData("competitionCreatorDataDoubt");
	}

	/**
	 * Gets the creator data.
	 * 
	 * @param listId
	 *            the list id
	 * @return the creator data
	 */
	private CfgCreatorDataList getCreatorData(final String listId) {
		CfgCreatorDataList creatorDatas = mapCreatorDataList.get(listId);
		if (creatorDatas == null) {
			creatorDatas = new CfgCreatorDataList();
			mapCreatorDataList.put(listId, creatorDatas);
		}
		return creatorDatas;
	}

	/**
	 * Gets the map creator data list.
	 * 
	 * @return the map creator data list
	 */
	public Map<String, CfgCreatorDataList> getMapCreatorDataList() {
		return mapCreatorDataList;
	}

	/**
	 * Gets the match participant creator data.
	 * 
	 * @return the match participant creator data
	 */
	private CfgCreatorDataList getMatchParticipantCreatorData() {
		return getCreatorData("matchParticipantCreatorData");
	}

	/**
	 * Gets the sport creator data.
	 * 
	 * @return the sport creator data
	 */
	private CfgCreatorDataList getSportCreatorData() {
		return getCreatorData("sportCreatorData");
	}

	/**
	 * Gets the region creator data.
	 * 
	 * @return the region creator data
	 */
	private CfgCreatorDataList getRegionCreatorData() {
		return getCreatorData("regionCreatorData");
	}

	/**
	 * Gets the sport creator data.
	 * 
	 * @return the sport creator data
	 */
	private CfgCreatorDataList getSportCreatorDataDoubt() {
		return getCreatorData("sportCreatorDataDoubt");
	}
}
