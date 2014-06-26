/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.util.commons.date.DateFormatUtil;

/**
 * The Class CfgCompetitionWriter.
 */
public class CfgCompetitionWriter extends
		AbstractSynonymsWriterXML<List<CfgCompetition>, CfgCompetitionSynonyms> {

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
	protected List<CfgCompetition> makeObject() {

		List<CfgCompetition> result = new ArrayList<CfgCompetition>();
		addCompetition("30000", "Roland Garros", "3", null, result,Boolean.TRUE);
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
	public CfgCompetition addCompetition(String objectId,
			String competitionName, String sportId, BigInteger regionId,
			List<CfgCompetition> result,Boolean active, String... synonyms) {
		// Competicion New
		CfgCompetition cfgCompetition = new CfgCompetition();
		// cfgCompetition.setStartDate(new CoreDate(dateFormatUtil
		// .getDate("2012-06-27 18:45:00")));
		cfgCompetition.setObjectId(objectId);
		cfgCompetition.setName(competitionName);
		CfgSport sport = new CfgSport(sportId);
		cfgCompetition.setSport(sport);
		if (regionId != null) {
			CfgRegion region = new CfgRegion(regionId);
			cfgCompetition.setRegion(region);
		}
		
//		if (countryId != null) {
//			CfgCountry country = new CfgCountry(countryId);
//			cfgCompetition.setSuperEntityAgrupation(country);
//		}
		// cfgCompetition.setHistoricCreationData("writerData");
		CoreActiveElement coreActiveElement = new CoreActiveElement(active);
		cfgCompetition.setCoreActiveElement(coreActiveElement);
		addCompetition(cfgCompetition, result, active, synonyms);
		return cfgCompetition;
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
	public void addCompetition(CfgCompetition competition,
			List<CfgCompetition> result,Boolean active, String... synonyms) {
		CfgCompetitionSynonyms competitionSynonyms = new CfgCompetitionSynonyms(
				competition.getObjectId());
		competitionSynonyms.setCompetition(new CfgCompetition(competition
				.getObjectId()));
		getSynonymsList().add(competitionSynonyms);
		competitionSynonyms.addSynonimWord(competition.getName(Locale.ENGLISH),
				getWriterAppUser());
		CoreActiveElement coreActiveElement = new CoreActiveElement(active);
		competitionSynonyms.setCoreActiveElement(coreActiveElement);
		for (String synonym : synonyms) {
			competitionSynonyms.addSynonimWord(synonym);
		}
		result.add(competition);
	}
}
