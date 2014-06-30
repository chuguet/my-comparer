/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.luckia;


/**
 * The Enum BetType.
 */
public enum BetsInvalidLuckia {

	
	otro(),
	
	ganador_partido("Primer equipo en marcar", "Primer gol", "Ultimo gol", "primero", "Primero", "Ultimo punto", "Equipo que se clasificar�", "Primer gol. 0-0 sin apuesta", "Ultimo Gol. 0-0 sin apuesta", "Romper� un servicio en primer lugar"),
	
	mas_menos("Total de goles marcados por el equipo local", "Total de goles marcados por el equipo visitante", "Total de puntos del equipo local", "Total de puntos del equipo visitante", "equipo local", "equipo visitante", "C�rners", "c�rners", "jugador", "Jugador", "total de juegos", "Total de juegos", "n�mero total de tiebreaks", "n�mero total de Tiebreaks", "N�mero total de Tiebreaks", "N�mero total de tiebreaks", "Total de aces", "total de aces"),
	
	handicap_asiatico("El servicio m�s r�pido", "Para golpear la mayor�a de los Ases", "handicap de juegos", "Handicap de juegos");


	private final String[] id;


	BetsInvalidLuckia(String... pValue) {
		this.id = pValue;
	}


	public String[] getSportId() {
		return id;
	}


	public static BetsInvalidLuckia getMarketByValue(String pValue) {
		BetsInvalidLuckia[] values = BetsInvalidLuckia.values();
		for (int i = 0; i < values.length; i++) {
			String[] types = values[i].getSportId();
			for (int j = 0; j < types.length; j++) {
				if (pValue.contains(types[j])) {
					return values[i];
				}
			}
		}
		return values[0];
	}


}
