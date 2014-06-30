/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache;

/**
 * The Enum CacheRegion.
 */
public enum CacheRegion {

	/** The CONTROLLE r_ match. */
	BETODDS_COMPETITIONEVENTCONTROLLER("betOdds_competitionEventController"),
	BETTYPES_COMPETITIONTABEVENTCONTROLLER("bettypes_competitiontabeventcontroller"),
	HEAD_COMPETITIONTABEVENTCONTROLLER("head_competitiontabeventcontroller"),
	BETODDS_COMPETITIONTABLTCONTROLLER("betodds_competitiontabltcontroller"),
	BETTYPES_COMPETITIONTABLTCONTROLLER("bettypes_competitiontabltcontroller"),
	HEAD_COMPETITIONTABLTCONTROLLER("head_competitiontabltcontroller"),
	MATCHS_COMPETITIONTABLTCONTROLLER("matchs_competitiontabltcontroller"),
	COUNTRYEVENTSCOMPETITION_COUNTRYTABEVENTCONTROLLER("countryEventsCompetition_countryTabEventController"),
	COUNTRYEVENTSEVENT_COUNTRYTABEVENTCONTROLLER("countryeventsevent_countrytabeventcontroller"),
	HEAD_COUNTRYTABEVENTCONTROLLER("head_countrytabeventcontroller"),
	COUNTRYLONGTERMBETTYPE_COUNTRYTABLTCONTROLLER("countryLongTermBetType_CountryTabLTController"),
	COUNTRYLONGTERMCOMPETITION_COUNTRYTABLTCONTROLLER("countryLongTermCompetition_countryTabLTController"),
	COUNTRYLONGTERMEVENT_COUNTRYTABLTCONTROLLER("countryLongTermEvent_countryTabLTController"),
	HEAD_COUNTRYTABLTCONTROLLER("head_countrytabltcontroller"),
	BETODDS_EVENTTABEVENTCONTROLLER("betodds_eventtabeventcontroller"),
	BETTYPESEVENT_EVENTTABEVENTCONTROLLER("bettypesevent_eventtabeventcontroller"),
	BETTYPES_EVENTTABEVENTCONTROLLER("bettypes_eventtabeventcontroller"),
	HEAD_EVENTTABEVENTCONTROLLER("head_eventtabeventcontroller"),
	HEAD_SPORTTABEVENTCONTROLLER("head_sporttabeventcontroller"),
	SPORTCOUNTRIESCOMPETITIONS_SPORTTABEVENTCONTROLLER("sportCountriesCompetitions_sportTabEventController"),
	SPORTCOUNTRIESCOUNTRIES_SPORTTABEVENTCONTROLLER("sportcountriescountries_sporttabeventcontroller"),
	SPORTCOUNTRIESEVENTS_SPORTTABEVENTCONTROLLER("sportcountriesevents_sporttabeventcontroller"),
	LIVEBET_LIVEBETCONTROLLER("livebet_livebetcontroller"),
	IMAGESLIDER("imageSliderController_getEventData"),
	IMAGESLIDER_UPDATE("imageSliderController_getEventDataUpdate"),
	toolbarLVL1("toolbarLVL1"), toolbarLVL2("toolbarLVL2"), toolbarLVL3(
			"toolbarLVL3"),
	RTMATCH_EVENTTABEVENTCONTROLLER("rtMatch_eventTabEventController");

	/** The name. */
	private String name;

	/**
	 * Instantiates a new cache region.
	 * 
	 * @param name
	 *            the name
	 */
	private CacheRegion(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

}
