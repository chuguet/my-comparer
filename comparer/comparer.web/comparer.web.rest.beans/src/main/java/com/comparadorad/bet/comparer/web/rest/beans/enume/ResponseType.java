/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.rest.beans.enume;

/**
 * The Enum ResponseType.
 */
public enum ResponseType {

	/** The OK. */
	OK("Request completed sucessfully."),
	
	/** The KO. */
	KO("Request failed");
	
	
	/** The descripcion. */
	private String descripcion;
	
	/**
	 * Instantiates a new response type.
	 *
	 * @param descripcion the descripcion
	 */
	private ResponseType(String descripcion) {
		this.descripcion=descripcion;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
}
