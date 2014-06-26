/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import java.math.BigInteger;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.ConvertException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.MultipleTournamentEventException;
import com.comparadorad.bet.comparer.synchro.reader.process.exception.TournamentEventNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.process.synonyms.ISynonymsComponent;

/**
 * The Class XmlTournamentToCfgCompetition.
 */
@Component
public class XmlTournamentEventToCfgCompetitionEvent extends
		AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The synonyms component. */
	@Inject
	private ISynonymsComponent synonymsComponent;

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
		CfgCompetitionEvent result = null;
		if (sourceObject instanceof XmlTournamentEvent) {
			XmlTournamentEvent xmlTournamentEvent = (XmlTournamentEvent) sourceObject;
			try {
				if (xmlTournamentEvent.getName() != null) {
					result = synonymsComponent
							.findByNameCompetitionEvent(xmlTournamentEvent
									.getName());
					if (result != null) {
						xmlTournamentEvent.setCfgObjectId(result.getObjectId());
					}
				}
			} catch (TournamentEventNotFoundException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e,
						xmlTournamentEvent, getCfgBookmaker());
				throw new ConvertException(e);
			} catch (MultipleTournamentEventException e) {
				getSynchroErrorEvent().errorLog(e.getMessage(), e,
						xmlTournamentEvent, getCfgBookmaker());
				throw new ConvertException(e);
			}
			// TODO hay que ver si es necesario generar un competition event
		} else {
			result = new CfgCompetitionEvent();
			result.setObjectId(BigInteger.ONE);
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
