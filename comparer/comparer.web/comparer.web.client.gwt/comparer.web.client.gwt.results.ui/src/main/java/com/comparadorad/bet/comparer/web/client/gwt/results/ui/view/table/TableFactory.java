/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table;

import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;

/**
 * A factory for creating Table objects.
 */
public class TableFactory {

	/**
	 * The Enum BetType.
	 */
	public enum BetType {

		/** The GANADOR. */
		GANADOR("3"),
		/** The GANADO r_ d e_ partido. */
		GANADOR_DE_PARTIDO("2"),
		/** The HANDICA p_ asiatico. */
		HANDICAP_ASIATICO("4"),
		/** The MA s_ menos. */
		MAS_MENOS("6"),
		/** The MAXIM o_ goleador. */
		MAXIMO_GOLEADOR("7"),
		/** The UN o_ x_ dos. */
		UNO_X_DOS("1"),
		/** The UN o_ x_ do s_ handicap. */
		UNO_X_DOS_HANDICAP("5");

		/**
		 * Gets the.
		 * 
		 * @param id
		 *            the id
		 * @return the bet type
		 */
		public static BetType get(String id) {
			for (BetType value : values()) {
				if (value.id.equalsIgnoreCase(id))
					return value;
			}
			return null;
		}

		/** The id. */
		private String id;

		/**
		 * Instantiates a new bet type.
		 * 
		 * @param id
		 *            the id
		 */
		private BetType(String id) {
			this.id = id;
		}

		/**
		 * Gets the id.
		 * 
		 * @return the id
		 */
		public String getId() {
			return id;
		}

	}

	/**
	 * The Enum BetTypeEvent.
	 */
	public enum BetTypeEvent {

		/** The FINA l_ partido. */
		FINAL_PARTIDO("2"),
		/** The FINA l_ primer a_ parte. */
		FINAL_PRIMERA_PARTE("0"),
		/** The FINA l_ segund a_ parte. */
		FINAL_SEGUNDA_PARTE("1");

		/**
		 * Gets the.
		 * 
		 * @param id
		 *            the id
		 * @return the bet type event
		 */
		public static BetTypeEvent get(String id) {
			for (BetTypeEvent value : values()) {
				if (value.id.equalsIgnoreCase(id))
					return value;
			}
			return null;
		}

		/** The id. */
		private String id;

		/**
		 * Instantiates a new bet type event.
		 * 
		 * @param id
		 *            the id
		 */
		private BetTypeEvent(String id) {
			this.id = id;
		}

		/**
		 * Gets the id.
		 * 
		 * @return the id
		 */
		public String getId() {
			return id;
		}
	}

	/**
	 * The Enum Type.
	 */
	public enum Type {

		/** The EVENTS. */
		EVENTS,
		/** The LON g_ term. */
		LONG_TERM,
		/** The QUOTAS. */
		QUOTAS;
	}

	/**
	 * The Enum View.
	 */
	public enum View {

		/** The COMPETICION. */
		COMPETICION,
		/** The COUNTRY. */
		COUNTRY,
		/** The EVENT. */
		EVENT,
		/** The SPORT. */
		SPORT;
	}

	/**
	 * Creates a new Table object.
	 * 
	 * @param view
	 *            the view
	 * @param type
	 *            the type
	 * @param betType
	 *            the bet type
	 * @return the generic table
	 */
	public GenericTable createTable(View view, Type type, BetType betType) {
		GenericTable table = null;
		if (view.equals(View.COMPETICION)
				&& type.equals(Type.LONG_TERM)
				&& (betType.equals(BetType.GANADOR) || betType
						.equals(BetType.MAXIMO_GOLEADOR))) {
			table = new LongTermTable();
		} else if (view.equals(View.COMPETICION) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.GANADOR)) {
			table = new ShortTermTableGanador();
		} else if (view.equals(View.COMPETICION) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.GANADOR_DE_PARTIDO)) {
			table = new ShortTermTableGanadorPartido();
		} else if (view.equals(View.COMPETICION) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.UNO_X_DOS)) {
			table = new ShortTermTableUnoXDos();
		} else if (view.equals(View.EVENT) && type.equals(Type.QUOTAS)
				&& betType.equals(BetType.UNO_X_DOS)) {
			table = new DetailedTableUnoXDos();
		} else if (view.equals(View.EVENT) && type.equals(Type.QUOTAS)
				&& betType.equals(BetType.GANADOR_DE_PARTIDO)) {
			table = new DetailedTableGanadorPartido();
		} else if (view.equals(View.EVENT)
				&& type.equals(Type.QUOTAS)
				&& ((betType.equals(BetType.GANADOR) || betType
						.equals(BetType.MAXIMO_GOLEADOR)))) {
			table = new DetailedTableGanador();
		} else if (view.equals(View.EVENT) && type.equals(Type.QUOTAS)
				&& betType.equals(BetType.UNO_X_DOS_HANDICAP)) {
			table = new DetailedTableUnoXDosHandicap();
		} else if (view.equals(View.EVENT) && type.equals(Type.QUOTAS)
				&& betType.equals(BetType.HANDICAP_ASIATICO)) {
			table = new DetailedTableHandicapAsiatico();
		} else if (view.equals(View.EVENT) && type.equals(Type.QUOTAS)
				&& betType.equals(BetType.MAS_MENOS)) {
			table = new DetailedTableMasMenos();
		} else if (view.equals(View.COUNTRY)
				&& type.equals(Type.LONG_TERM)
				&& (betType.equals(BetType.GANADOR) || betType
						.equals(BetType.MAXIMO_GOLEADOR))) {
			table = new LongTermTable();
		} else if (view.equals(View.COUNTRY) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.UNO_X_DOS)) {
			table = new ShortTermTableUnoXDos();
		} else if (view.equals(View.COUNTRY) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.GANADOR_DE_PARTIDO)) {
			table = new ShortTermTableGanadorPartido();
		} else if (view.equals(View.COUNTRY) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.GANADOR)) {
			table = new ShortTermTableGanador();
		} else if (view.equals(View.SPORT) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.UNO_X_DOS)) {
			table = new ShortTermTableUnoXDos();
		} else if (view.equals(View.SPORT) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.GANADOR_DE_PARTIDO)) {
			table = new ShortTermTableGanadorPartido();
		} else if (view.equals(View.SPORT) && type.equals(Type.EVENTS)
				&& betType.equals(BetType.GANADOR)) {
			table = new ShortTermTableGanador();
		} else {
			return null;
		}
		return table;
	}

}
