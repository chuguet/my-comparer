/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean.enume;

/**
 * The Enum LiferayRoles.
 */
public enum LiferayRoles {
	
	
	/** The EXPECIAL. */
	SPECIAL_LEVEL_0(0),
	
	/** The LEVE l_1. */
	LEVEL_1(1),
	
	/** The LEVE l_2. */
	LEVEL_2(2),
	
	/** The LEVE l_3. */
	LEVEL_3(3),
	
	/** The FRE e_4. */
	FREE(4),
	
	/** The UNREGISTERED. */
	UNREGISTERED(5);
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/** The id. */
	private int id;
	
	/**
	 * Instantiates a new liferay roles.
	 *
	 * @param id the id
	 */
	private LiferayRoles(int id) {
		this.id = id;
	}

}
