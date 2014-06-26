/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.datasource.crypt.impl;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.reader.datasource.crypt.Encrypt;

/**
 * The Class EncryptImpl.
 */
@Component
public class EncryptImpl implements Encrypt {

	/** The Constant MD5. */
	public final static String MD5 = "MD5";

	/** The Constant SHA1. */
	public final static String SHA1 = "SHA1";

	/**
	 * Encrypt.
	 *
	 * @param message the message
	 * @param type the type
	 * @return the string
	 */
	private static String encrypt(String message, String type) {
		MessageDigest messageDigest;
		byte[] buffer, digest;
		StringBuilder hash;
		hash = new StringBuilder();
		try {
			buffer = message.getBytes("UTF-8");
			messageDigest = MessageDigest.getInstance(type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		messageDigest.update(buffer);
		digest = messageDigest.digest();
		for (byte b : digest) {
			hash.append(String.format("%02x", b & 0xff));
		}
		return hash.toString();
	}

	/**
	 * Md5.
	 *
	 * @param message the message
	 * @return the string
	 * {@inheritDoc}
	 */
	@Override
	public String md5(String message) {
		return encrypt(message, MD5);
	}

	/**
	 * Sha1.
	 *
	 * @param message the message
	 * @return the string
	 * {@inheritDoc}
	 */
	@Override
	public String sha1(String message) {
		return encrypt(message, SHA1);
	}

}
