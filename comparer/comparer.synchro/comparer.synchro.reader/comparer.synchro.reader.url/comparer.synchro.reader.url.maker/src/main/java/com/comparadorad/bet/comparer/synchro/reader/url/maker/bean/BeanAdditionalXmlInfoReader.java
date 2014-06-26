/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.maker.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The Class BeanAdditionalXmlInfoReader.
 */
public class BeanAdditionalXmlInfoReader {

	/** The sport name. */
	private String sportName;

	/** The competition name. */
	private String competitionName;

	/** The region name. */
	private String regionName;
	
	/** The map leagues by sport. */
	private Map<String, String> mapLeaguesBySport;
	
	/** From step 6 the hashkey of match must be passed */
	private Stack<String> actualHashKeyOfMatchInProcess = null;
	
//	private com.comparadorad.bet.comparer.communication.core.beans.UpdaterBetsTO ubTO = null;
	
	/**
	 * Instantiates a new bean additional xml info reader.
	 *
	 * @param map the map
	 */
	public BeanAdditionalXmlInfoReader(Map<String, String> map) {
		super();
		this.mapLeaguesBySport= map;
	}
	
	/**
	 * Instantiates a new bean additional xml info reader.
	 * 
	 * @param sportName
	 *            the sport name
	 * @param competitionName
	 *            the competition name
	 * @param regionName
	 *            the region name
	 */
	public BeanAdditionalXmlInfoReader(String sportName,
			String competitionName, String regionName) {
		super();
		this.sportName 			= sportName;
		this.competitionName 	= competitionName;
		this.regionName 		= regionName;
	}

	/**
	 * Gets the sport name.
	 * 
	 * @return the sport name
	 */
	public String getSportName() {
		return sportName;
	}

	/**
	 * Sets the sport name.
	 * 
	 * @param sportName
	 *            the new sport name
	 */
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	/**
	 * Gets the competition name.
	 * 
	 * @return the competition name
	 */
	public String getCompetitionName() {
		return competitionName;
	}

	/**
	 * Sets the competition name.
	 * 
	 * @param competitionName
	 *            the new competition name
	 */
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	/**
	 * Gets the region name.
	 * 
	 * @return the region name
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * Sets the region name.
	 * 
	 * @param regionName
	 *            the new region name
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	
	/**
	 * Gets the map leagues by sport.
	 *
	 * @return the map leagues by sport
	 */
	public Map<String, String> getMapLeaguesBySport() {
		if (mapLeaguesBySport== null){
			mapLeaguesBySport= new HashMap<String,String>();
		}
		return mapLeaguesBySport;
	}

	/**
	 * Sets the map leagues by sport.
	 *
	 * @param mapLeaguesBySport the map leagues by sport
	 */
	public void setMapLeaguesBySport(Map<String, String> mapLeaguesBySport) {
		this.mapLeaguesBySport = mapLeaguesBySport;
	}

	/** {@inheritDoc} */ 
	@Override
	public String toString() {
		return "BeanAdditionalXmlInfoReader [sportName=" + sportName
				+ ", competitionName=" + competitionName + ", regionName="
				+ regionName + ", mapLeaguesBySport=" + mapLeaguesBySport + "]";
	}

	public Stack<String> getActualHashKeyOfMathInProcess() {
		return actualHashKeyOfMatchInProcess;
	}

	public void setActualHashKeyOfMathInProcess(
			Stack<String> actualHashKeyOfMathProcessing) {
		this.actualHashKeyOfMatchInProcess = actualHashKeyOfMathProcessing;
	}
	
}
