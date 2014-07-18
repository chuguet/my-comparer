/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.rest.beans.enume;

/**
 * The Enum UserTypes.
 */
public enum UserTypes {

	/** The NIVE l_1. */
	NIVEL_1(1),
	
	/** The NIVE l_2. */
	NIVEL_2(2),
	
	/** The NIVE l_3. */
	NIVEL_3(3),
	
	/** The GRATUITO. */
	GRATUITO(4);
	
	/** The id. */
	@SuppressWarnings("unused")
	private int id;
	
	/**
	 * Instantiates a new user types.
	 *
	 * @param id the id
	 */
	UserTypes(int id){
		this.id = id;
		
	}
	
	
}
