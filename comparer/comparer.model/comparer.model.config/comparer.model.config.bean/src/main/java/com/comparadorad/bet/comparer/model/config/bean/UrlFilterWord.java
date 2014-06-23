/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.io.Serializable;

/**
 * The Class UrlFilterWord.
 * Elemento para realizar el filtro en UrlMaker
 */
public class UrlFilterWord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The string. */
	private String string;
	
	public UrlFilterWord(){
		super();
	}
	
	public UrlFilterWord(String string){
		super();
		this.string = string;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlFilterWord other = (UrlFilterWord) obj;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

	/**
	 * Gets the string.
	 * 
	 * @return the string
	 */
	public String getString() {
		return string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((string == null) ? 0 : string.hashCode());
		return result;
	}

	/**
	 * Sets the string.
	 * 
	 * @param string
	 *            the new string
	 */
	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "UrlFilterWord [string=" + string + "]";
	}

}
