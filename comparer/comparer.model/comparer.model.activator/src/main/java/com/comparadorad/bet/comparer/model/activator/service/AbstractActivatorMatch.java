/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;

/**
 * The Class AbstractActivatorMatch.
 */
abstract class AbstractActivatorMatch implements IEnvironmentActivatorMatch {

	private static final Log LOG = LogFactory
			.getLog(AbstractActivatorMatch.class);

	/** The active bet type events. */
	private Set<String> activeBetTypeEvents;

	/** The active bet types. */
	private Set<String> activeBetTypes;
	/**
	 * Instantiates a new abstract activator match.
	 */
	public AbstractActivatorMatch() {
		super();
		activeBetTypeEvents = getActiveBetTypeEvents();
		activeBetTypes = getActiveBetTypes();
	}

	/**
	 * Gets the active bet type events.
	 * 
	 * @return the active bet type events
	 */
	protected Set<String> getActiveBetTypeEvents() {
		Set<String> result = new HashSet<String>();

		result = new HashSet<String>();
		result.add(CfgBetTypeEventId.PARTIDO_COMPLETO.objectId());
		result.add(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.objectId());

		return result;
	}

	/**
	 * Gets the active bet types.
	 * 
	 * @return the active bet types
	 */
	protected Set<String> getActiveBetTypes() {
		Set<String> result = new HashSet<String>();

		result.add(CfgBetTypeId.GANADOR_PARTIDO.id());
		result.add(CfgBetTypeId.UNO_X_DOS.id());
		result.add(CfgBetTypeId.GANADOR.id());

		return result;

	}

	/**
	 * Checks if is market active.
	 * 
	 * @param market
	 *            the market
	 * @return true, if is market active
	 */
	protected Boolean isMarketActive(RtMarket market) {
		Boolean result = Boolean.FALSE;
		String betType = market.getBetType().getObjectId().toString();
		String betTypeEvent = market.getBetTypeEvent().getBetTypeEvent()
				.getObjectId().toString();
		if (activeBetTypes.contains(betType)
				&& activeBetTypeEvents.contains(betTypeEvent)) {
			result = Boolean.TRUE;
			LOG.debug(new StringBuffer()
					.append("Existe un mercado activo con tipo de apuesta: ")
					.append(betType).append(", y el evento de apuesta: ")
					.append(betTypeEvent).toString());
			
		}
		return result;
	}

	/**
	 * Checks if is match active.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @return true, if is match active
	 */
	public Boolean isMatchActive(RtMatch rtMatch) {
		Boolean result = Boolean.FALSE;
		LOG.debug("Inicio activacion/desactivacion del partido");

		if (matchHasAtLeastOneActiveMarket(rtMatch.getRtMarkets())) {
			LOG.debug("El partido es activo");
			result = Boolean.TRUE;
		}
		LOG.debug("El partido NO es activo");

		LOG.debug("Fin activacion/desactivacion del partido");
		return result;
	}

	/**
	 * Match has at least one active market.
	 * 
	 * @param rtMarkets
	 *            the rt markets
	 * @return true, if successful
	 */
	private Boolean matchHasAtLeastOneActiveMarket(Set<RtMarket> rtMarkets) {
		Boolean result = Boolean.FALSE;
		for (RtMarket market : rtMarkets) {
			if (isMarketActive(market)) {
				result = Boolean.TRUE;
			}
		}
		return result;
	}

	/**
	 * Execute.
	 * 
	 * @param match
	 *            the match
	 * @param isNew
	 *            the is new
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch execute(final RtMatch match, final Boolean isNew) {
		RtMatch result = match;

		LOG.info("Se entra en el metodo execute");

		match.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));

		LOG.info("Se sale en el metodo execute");

		return result;
	}

	/**
	 * Execute.
	 * 
	 * @param matchs
	 *            the matchs
	 * @param isNew
	 *            the is new
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<RtMatch> execute(List<RtMatch> matchs, final Boolean isNew) {
		List<RtMatch> result = new ArrayList<RtMatch>();

		LOG.info("Se entra en el metodo execute");

		for (RtMatch rtMatch : matchs) {
			result.add(execute(rtMatch, isNew));
		}

		LOG.info("Se sale en el metodo execute");

		return result;
	}

}
