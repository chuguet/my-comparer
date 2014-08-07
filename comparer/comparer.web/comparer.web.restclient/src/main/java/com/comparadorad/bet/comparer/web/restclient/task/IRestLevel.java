package com.comparadorad.bet.comparer.web.restclient.task;

/**
 * Niveles de profundidad
 * @author rdomingo
 *
 */
public interface IRestLevel {

	// Toolbar nivel 1 (deporte), head-deporte
	public static Integer LEVEL_1 = 1;
	
	// Toolbar nivel 2 (pais), head-pais
	public static Integer LEVEL_2 = 2;
	
	// Toolbar nivel 3 (competicion), tipos de evento, tipos de apuesta
	public static Integer LEVEL_3 = 3;
	
	// Detalle evento
	public static Integer LEVEL_4 = 4;
	
	// Value Bets & Sure Bets
	public static Integer LEVEL_5 = 5;

}
