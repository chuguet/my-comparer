/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetEvent;

/**
 * The Class BetEventBookmaker.
 */
class BetEventBookmaker {

	/**
	 * The Enum BaseballBetEvent. Baseball tiene su propio enum ya que utiliza
	 * los mismos identificadores que en otros deportes pero para beisbol
	 * tenemos que interpretar por ejemplo 'first half' como 'las cinco primeras
	 * entradas' y no como 'primera parte'
	 */
	private enum BaseballBetEvent implements IBetEvent {

		/** The CINC o_ primera s_ entradas. */
		CINCO_PRIMERAS_ENTRADAS(CfgBetTypeEventId.CINCO_PRIMERAS_ENTRADAS
				.nameId(), "first half"),

		/** The PARTID o_ completo. */
		PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(), "game"),

		/** The PRIMER a_ entrada. */
		PRIMERA_ENTRADA(CfgBetTypeEventId.PRIMERA_ENTRADA.nameId()),

		/** The SEGUND a_ parte. */
		SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "second half");

		/**
		 * Gets the type by value. Se transforma primero a lower case antes de
		 * comparar.
		 * 
		 * @param pValue
		 *            the value
		 * @return the type by value
		 * @throws BookmakerEuBetEventNotFoundException
		 *             the bookmaker eu bet event not found exception
		 */
		public static IBetEvent getEventByValue(String pValue)
				throws BookmakerEuBetEventNotFoundException {
			pValue = pValue.toLowerCase();
			BaseballBetEvent[] values = BaseballBetEvent.values();
			for (int i = 0; i < values.length; i++) {
				String[] types = values[i].getEvents();
				for (int j = 1; j < types.length; j++) {
					if (pValue.toLowerCase().contains(types[j].toLowerCase())) {
						return values[i];
					}
				}
			}
			throw new BookmakerEuBetEventNotFoundException(new StringBuffer()
					.append("El string: '").append(pValue)
					.append("' no corresponde a ningun betTypeEvent conocido")
					.toString());
		}

		/** The events. */
		private final String[] events;

		/**
		 * Instantiates a new bet event bookmaker.
		 * 
		 * @param pValue
		 *            the value
		 */
		BaseballBetEvent(String... pValue) {
			this.events = pValue;
		}

		/**
		 * Gets the events.
		 * 
		 * @return the events {@inheritDoc}
		 */
		@Override
		public String[] getEvents() {
			return events;
		}

		/**
		 * Gets the id.
		 * 
		 * @return the id {@inheritDoc}
		 */
		@Override
		public String getId() {
			return events[0];
		}

	}

	/**
	 * The Enum OtherSportsBetEvent.
	 */
	private enum OtherSportsBetEvent implements IBetEvent {

		/** The CUART o_ cuarto. */
		CUARTO_CUARTO(CfgBetTypeEventId.CUARTO_CUARTO.nameId(),
				"fourth quarter"),

		/** The PARTID o_ completo. */
		PARTIDO_COMPLETO(CfgBetTypeEventId.PARTIDO_COMPLETO.nameId(), "game"),

		/** The PARTID o_ complet o_ prorroga. */
		PARTIDO_COMPLETO_PRORROGA(CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA
				.nameId()),

		/** The PRIME r_ cuarto. */
		PRIMER_CUARTO(CfgBetTypeEventId.PRIMER_CUARTO.nameId(), "first quarter"),

		/** The PRIMER a_ parte. */
		PRIMERA_PARTE(CfgBetTypeEventId.PRIMERA_PARTE.nameId(), "first half",
				"first period"),

		/** The SEGUND a_ parte. */
		SEGUNDA_PARTE(CfgBetTypeEventId.SEGUNDA_PARTE.nameId(), "second half",
				"second period"),

		/** The SEGUND o_ cuarto. */
		SEGUNDO_CUARTO(CfgBetTypeEventId.SEGUNDO_CUARTO.nameId(),
				"second quarter"),

		/** The TERCE r_ cuarto. */
		TERCER_CUARTO(CfgBetTypeEventId.TERCER_CUARTO.nameId(), "third quarter"),

		/** The TERCER a_ parte. */
		TERCERA_PARTE(CfgBetTypeEventId.TERCERA_PARTE.nameId(), "third part",
				"third period");

		/**
		 * Gets the type by value. Se transforma primero a lower case antes de
		 * comparar.
		 * 
		 * @param pValue
		 *            the value
		 * @return the type by value
		 * @throws BookmakerEuBetEventNotFoundException
		 *             the bookmaker eu bet event not found exception
		 */
		public static IBetEvent getEventByValue(String pValue)
				throws BookmakerEuBetEventNotFoundException {
			pValue = pValue.toLowerCase();
			OtherSportsBetEvent[] values = OtherSportsBetEvent.values();
			for (int i = 0; i < values.length; i++) {
				String[] types = values[i].getEvents();
				for (int j = 1; j < types.length; j++) {
					if (pValue.toLowerCase().contains(types[j].toLowerCase())) {
						return values[i];
					}
				}
			}
			throw new BookmakerEuBetEventNotFoundException(new StringBuffer()
					.append("El string: '").append(pValue)
					.append("' no corresponde a ningun betTypeEvent conocido")
					.toString());
		}

		/** The events. */
		private final String[] events;

		/**
		 * Instantiates a new bet event bookmaker.
		 * 
		 * @param pValue
		 *            the value
		 */
		OtherSportsBetEvent(String... pValue) {
			this.events = pValue;
		}

		/**
		 * Gets the events.
		 * 
		 * @return the events {@inheritDoc}
		 */
		@Override
		public String[] getEvents() {
			return events;
		}

		/**
		 * Gets the id.
		 * 
		 * @return the id {@inheritDoc}
		 */
		@Override
		public String getId() {
			return events[0];
		}

	}

	/**
	 * Gets the bet event.
	 * 
	 * @param sport
	 *            the sport
	 * @param pValue
	 *            the value
	 * @return the bet event
	 * @throws BookmakerEuBetEventNotFoundException
	 *             the bookmaker eu bet event not found exception
	 */
	public static IBetEvent getBetEvent(String sport, String pValue)
			throws BookmakerEuBetEventNotFoundException {
		IBetEvent result = null;

		if (SportNameResolver.isBaseball(sport)) {
			result = BaseballBetEvent.getEventByValue(pValue);
		} else {
			// Lleva la prórroga.
			result = OtherSportsBetEvent.getEventByValue(pValue);
		}
		if (SportNameResolver.isOvertimeSport(sport)
				&& (result == null || result == OtherSportsBetEvent.PARTIDO_COMPLETO)) {
			result = OtherSportsBetEvent.PARTIDO_COMPLETO_PRORROGA;
		}

		return result;
	}
	

	/**
	 * Filter bet event for draw event.
	 *
	 * @param xmlBetEvent the xml bet event
	 * @return the xml bet event
	 */
	public static XmlBetEvent filterBetEventForDrawEvent(XmlBetEvent xmlBetEvent) {
		
		// Para el caso de evento de empate no se tendra en cuenta el partido con prorroga
		if (xmlBetEvent.getBetEvent() == OtherSportsBetEvent.PARTIDO_COMPLETO_PRORROGA) {
			return new XmlBetEvent(OtherSportsBetEvent.PARTIDO_COMPLETO);
		}
		return xmlBetEvent;
	}

}
