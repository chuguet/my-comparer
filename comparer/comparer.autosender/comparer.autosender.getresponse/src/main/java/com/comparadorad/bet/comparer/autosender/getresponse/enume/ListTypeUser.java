/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.enume;

/**
 * The Enum ListTypeUser.
 */
public enum ListTypeUser {
	
	/** The P_1_1. */
	P_1_1("Tabx"),
	
	/** The P_1_6. */
	P_1_6("TabS"),
	
	/** The P_1_12. */
	P_1_12("TabN"),
	
	/** The P_2_1. */
	P_2_1("TabA"),
	
	/** The P_2_6. */
	P_2_6("Tabv"),
	
	/** The P_2_12. */
	P_2_12("TabH"),
	
	/** The P_3_1. */
	P_3_1("TabY"),
	
	/** The P_3_6. */
	P_3_6("Tabb"),
	
	/** The P_3_12. */
	P_3_12("Tabd"),
	
	/** The P_ li m_1. */
	P_LIM_1("Tabs"),
	
	/** The P_ li m_2. */
	P_LIM_2("Tadc"),
	
	/** The P_ li m_3. */
	P_LIM_3("TadV"),
	
	/** The RE f_ s. */
	REF_S("Tadp"),
	
	/** The RE f_ n_ act. */
	REF_N_ACT("TadT"),
	
	/** The RE f_ n_ n_ act. */
	REF_N_N_ACT("Tadn"),
	
	/** The P_ ref. */
	P_REF("TabR"),
	
	/** The P_ prom o_ gr. */
	P_PROMO_GR("Tab2"),
	
	/** The P_ regi. */
	P_REGI("Tab0"),
	
	/** The P_ fi n_ gr. */
	P_FIN_GR("TabD"),
	
	/** The P_ fi n_ p. */
	P_FIN_P("Tabe"),
	
	/** The CON t_ blog. */
	CONT_BLOG("TaY2"),
	
	/** The CON t_ we b_ principal. */
	CONT_WEB_PRINCIPAL("TabM"),
	
	/** The CON t_ landin g_ sure. */
	CONT_LANDING_SURE("TabX"),
	
	/** The CON t_ referidos. */
	CONT_REFERIDOS("TabW"),
	
	/** The CON t_ sur e_ valu. */
	CONT_SURE_VALU("TabL"),
	
	/** The CON t_ landin g_ apuesta s_ mas. */
	CONT_LANDING_APUESTAS_MAS("TabI"),
	
	/** The CON t_ landin g_ toda s_ una. */
	CONT_LANDING_TODAS_UNA("Tab7"),
	
	/** The P_ premium. */
	P_PREMIUM("TAc5");
	
	
	/** The id. */
	private String id;
	
	/**
	 * Instantiates a new list type user.
	 *
	 * @param id the id
	 */
	private ListTypeUser(String id){
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
