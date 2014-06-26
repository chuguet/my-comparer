/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;

/**
 * The Class XmlTournamentToCfgCompetition.
 */
@Component
public class XmlTournamentEventToCfgCompetitionEvent extends
		AbstractCustomConvertProcess implements CustomConvertProcess {

	/**
	 * Convert.
	 * 
	 * @param targetObject
	 *            the target object
	 * @param sourceObject
	 *            the source object
	 * @param pArg2
	 *            the arg2
	 * @param pArg3
	 *            the arg3
	 * @return the object {@inheritDoc}
	 */
	@Override
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3) {
		CfgCompetitionEvent result = new CfgCompetitionEvent();
		if (sourceObject instanceof XmlTournamentEvent) {
			XmlTournamentEvent xmlTournamentEvent = (XmlTournamentEvent) sourceObject;
			if (xmlTournamentEvent.getLongTerm() != null
					&& xmlTournamentEvent.getLongTerm().getLongTerm() != null) {
				result.setLongTerm(xmlTournamentEvent.getLongTerm());
				if (xmlTournamentEvent.getLongTerm().getLongTerm() == true) {
					result.setObjectId(new BigInteger("2"));
				} else {
					result.setObjectId(BigInteger.ONE);
				}

			}
		} else {
			result = new CfgCompetitionEvent();
			result.setObjectId(BigInteger.ONE);
			LongTerm longTerm = new LongTerm();
			longTerm.setLongTerm(Boolean.FALSE);
			result.setLongTerm(longTerm);
		}
		return result;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "xmlTournamentEventToCfgCompetitionEvent";
	}

}
