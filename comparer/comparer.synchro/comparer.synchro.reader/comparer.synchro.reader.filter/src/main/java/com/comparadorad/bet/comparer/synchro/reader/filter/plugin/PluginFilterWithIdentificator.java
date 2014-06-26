/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.plugin;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.RtMatchFilterIdentificator;
import com.comparadorad.bet.comparer.synchro.reader.filter.exception.FilterException;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Interface PluginFilterWithIdentificator.
 */
public interface PluginFilterWithIdentificator{
	

	
	/**
	 * Complete rt match filter identificator with xml match hashkey.
	 *
	 * @param bookmaker the bookmaker
	 * @param hashkeyXmlMatch the hashkey xml match
	 * @param hashkeyRtMatch the hashkey rt match
	 * @param hashKeyMarkets the hash key markets
	 * @return the boolean
	 * @throws FilterException the filter exception
	 */
	public Boolean completeRtMatchFilterIdentificatorWithXmlMatchHashkey(
			CfgBookmaker bookmaker, String hashkeyXmlMatch, String hashkeyRtMatch,
			List<String> hashKeyMarkets) throws FilterException;
	
	/**
	 * Find rt match filter identificator.
	 *
	 * @param bookmaker the bookmaker
	 * @param hashXmlMatch the hash xml match
	 * @return the rt match filter identificator
	 * @throws FilterException the filter exception
	 */
	public RtMatchFilterIdentificator findRtMatchFilterIdentificator(
			CfgBookmaker bookmaker, String hashXmlMatch) throws FilterException;
	
	
	/**
	 * Creates the hash.
	 *
	 * @param match the match
	 * @return the string
	 * @throws FilterException the filter exception
	 */
	public String createHash(XmlMatch match) throws FilterException;

}
