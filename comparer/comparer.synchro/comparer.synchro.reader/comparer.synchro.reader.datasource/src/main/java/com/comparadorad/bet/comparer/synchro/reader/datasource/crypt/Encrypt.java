/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.crypt;

/**
 * The Interface Encrypt.
 */
public interface Encrypt {

	/**
	 * Md5.
	 * 
	 * @param message
	 *            the message
	 * @return the string
	 */
	String md5(String message);

	/**
	 * Sha1.
	 * 
	 * @param message
	 *            the message
	 * @return the string
	 */
	String sha1(String message);

}
