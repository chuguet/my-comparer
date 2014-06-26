/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmakerAuthorization;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;
import com.comparadorad.bet.comparer.util.commons.locale.LocaleUtil;

/**
 * The Class CfgCompetitionWriter.
 */
public class CfgBookmakerAuthorizationWriter extends
		AbstractWriterXML<List<CfgBookmakerAuthorization>> {

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
	protected List<CfgBookmakerAuthorization> makeObject() {
		List<CfgBookmakerAuthorization> result = new ArrayList<CfgBookmakerAuthorization>();
		CfgBookmakerAuthorization spainAgrupation = addCfgBookmakerAuthorization(
				"20000", "20000", "Agrupación de casas de apuestas (España)",
				"Bookmaker agrupation (Spain)", true, result);
		addCfgBookmakerAuthorization(spainAgrupation,
				CfgBookmakerId.BETCLIC_COM_ID);
		addCfgBookmakerAuthorization(spainAgrupation,
				CfgBookmakerId.BETDAQ_COM_ID);
		addCfgBookmakerAuthorization(spainAgrupation,
				CfgBookmakerId.NORDICBET_COM_ID);
		addCfgBookmakerAuthorization(spainAgrupation,
				CfgBookmakerId.NOXWIN_COM_ID);
		addCfgBookmakerAuthorization(spainAgrupation,
				CfgBookmakerId.PINNACLESPORTS_COM_ID);
		addCfgBookmakerAuthorization(spainAgrupation,
				CfgBookmakerId.TITANBET_COM_ID);
		addCfgBookmakerAuthorization(spainAgrupation,
				CfgBookmakerId.TRIOBET_COM_ID);
		addCfgBookmakerAuthorization(spainAgrupation,
				CfgBookmakerId.YOUWIN_COM_ID);
		return result;
	}

	/**
	 * Adds the cfg bookmaker authorization.
	 * 
	 * @param spainAgrupation
	 *            the spain agrupation
	 * @param bookmakerId
	 *            the bookmaker id
	 */
	private void addCfgBookmakerAuthorization(
			CfgBookmakerAuthorization spainAgrupation,
			CfgBookmakerId bookmakerId) {
		spainAgrupation.addBookmakers(new CfgBookmaker(bookmakerId));
	}

	/**
	 * Adds the cfg multi country agrupation.
	 * 
	 * @param idAgrupation
	 *            the id agrupation
	 * @param idMultyCountry
	 *            the id multy country
	 * @param nameSpanish
	 *            the name spanish
	 * @param nameEnglish
	 *            the name english
	 * @param defaultAgrupation
	 *            the default agrupation
	 * @param result
	 *            the result
	 * @return the cfg bookmaker authorization
	 */
	private CfgBookmakerAuthorization addCfgBookmakerAuthorization(
			String idAgrupation, String idMultyCountry, String nameSpanish,
			String nameEnglish, boolean defaultAgrupation,
			List<CfgBookmakerAuthorization> result) {
		CfgBookmakerAuthorization countryAgrupation = new CfgBookmakerAuthorization(
				idAgrupation);
		countryAgrupation.setName(nameSpanish, LocaleUtil.SPANISH);
		countryAgrupation.setName(nameEnglish, Locale.ENGLISH);

		result.add(countryAgrupation);
		return countryAgrupation;
	}
}
