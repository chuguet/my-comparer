/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.mapper.enums;

/**
 * The Enum MapperId.
 */
public enum MapperId {
	
	/** The VALUEBETDAT a_ t o_ valuebetto. */
	VALUEBETDATA_TO_VALUEBETTO("valueBetDataToValueBetTo"), SUREBETDATA_TO_SUREBETTO("surebetdataToSurebetTo");
	
	/** The name id. */
	private String nameId;
	
	/**
	 * Instantiates a new mapper id.
	 *
	 * @param nameId the name id
	 */
	private MapperId(String nameId){
		this.nameId = nameId;
	}

	/**
	 * Gets the name id.
	 *
	 * @return the name id
	 */
	public String getNameId() {
		return nameId;
	}
	
	

}
