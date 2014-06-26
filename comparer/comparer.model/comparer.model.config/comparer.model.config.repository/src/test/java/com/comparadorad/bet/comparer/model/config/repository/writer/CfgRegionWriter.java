/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.util.commons.date.DateFormatUtil;

/**
 * The Class CfgCompetitionWriter.
 */
public class CfgRegionWriter extends
		AbstractSynonymsWriterXML<List<CfgRegion>, CfgRegionSynonyms> {

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<CfgRegion> makeObject() {

		List<CfgRegion> result = new ArrayList<CfgRegion>();
		addRegion("1", "Otros", result,
				Boolean.TRUE);
		addRegion("2", "Internacional", result,
				Boolean.TRUE);
		addRegion("3", "Europa", result,
				Boolean.TRUE);
		addRegion("4", "Asia", result,
				Boolean.TRUE);
		addRegion("5", "África", result,
				Boolean.TRUE);
		addRegion("6", "Oceanía", result,
				Boolean.TRUE);
		addRegion("7", "Norteamérica", result,
				Boolean.TRUE);
		addRegion("8", "Sudamérica", result,
				Boolean.TRUE);
		addRegion("9", "España", result,
				Boolean.TRUE);
		addRegion("10", "Alemania", result,
				Boolean.TRUE);
		addRegion("11", "Reino Unido", result,
				Boolean.TRUE);
		addRegion("12", "USA", result,
				Boolean.TRUE);
		addRegion("13", "Australia", result,
				Boolean.TRUE);
		addRegion("14", "Paraguay", result,
				Boolean.TRUE);
		addRegion("15", "Francia", result,
				Boolean.TRUE);
		addRegion("16", "Polonia", result,
				Boolean.TRUE);
		addRegion("17", "Portugal", result,
				Boolean.TRUE);
		addRegion("18", "Italia", result,
				Boolean.TRUE);
		addRegion("19", "Turquía", result,
				Boolean.TRUE);
		
		
		return result;
	}

	/**
	 * Adds the competition.
	 * 
	 * @param objectId
	 *            the object id
	 * @param competitionName
	 *            the competition name
	 * @param sportId
	 *            the sport id
	 * @param countryId
	 *            the country id
	 * @param result
	 *            the result
	 */
	public CfgRegion addRegion(String objectId,
			String regionName,
			List<CfgRegion> result, Boolean active, String... synonyms) {
		// Region New
		CfgRegion cfgRegion = new CfgRegion();
		cfgRegion.setObjectId(objectId);
		cfgRegion.setName(regionName);
		
		CoreActiveElement coreActiveElement = new CoreActiveElement(active);
		cfgRegion.setCoreActiveElement(coreActiveElement);
		addRegion(cfgRegion, result, active, synonyms);
		return cfgRegion;
	}

	private Date getDate(final String strDate) {
		try {
			return new SimpleDateFormat(DateFormatUtil.DEFAULT_FORMAT)
					.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * Adds the competition.
	 * 
	 * @param competition
	 *            the competition
	 * @param result
	 *            the result
	 */
	public void addRegion(CfgRegion region,
			List<CfgRegion> result, Boolean active, String... synonyms) {
		CfgRegionSynonyms regionSynonyms = new CfgRegionSynonyms(
				region.getObjectId());
		regionSynonyms.setRegion(new CfgRegion(region
				.getObjectId()));
		getSynonymsList().add(regionSynonyms);
		regionSynonyms.addSynonimWord(region.getName(Locale.ENGLISH),
				getWriterAppUser());
		CoreActiveElement coreActiveElement = new CoreActiveElement(active);
		regionSynonyms.setCoreActiveElement(coreActiveElement);
		for (String synonym : synonyms) {
			regionSynonyms.addSynonimWord(synonym);
		}
		result.add(region);
	}
}
