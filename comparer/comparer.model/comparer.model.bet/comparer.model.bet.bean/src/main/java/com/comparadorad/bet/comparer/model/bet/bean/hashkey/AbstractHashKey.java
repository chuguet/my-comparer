/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.hashkey;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;

/**
 * The Class AbstractHasKey.
 * 
 * @param <T>
 *            the generic type
 * @author imayoral
 * @version 1.0
 */
public abstract class AbstractHashKey<T extends IRtData> {

	/**
	 * The Enum AvoidSports.
	 */
	public enum AvoidSports {

		/** The Example. */
		Example(BigInteger.valueOf(1234561324));

		/** The id. */
		private BigInteger id;

		/**
		 * Instantiates a new avoid sports.
		 * 
		 * @param id
		 *            the id
		 */
		private AvoidSports(BigInteger id) {
			this.id = id;
		}
	}

	/** The Constant SHA1. */
	private final static String SHA1 = "SHA1";

	/** The Constant TRANSFORMATION_FORMAT. */
	private final static String TRANSFORMATION_FORMAT = "UTF-8";

	/**
	 * Encrypt.
	 * 
	 * @param message
	 *            the message
	 * @return the string
	 */
	protected static String encrypt(String message) {
		MessageDigest messageDigest;
		byte[] buffer, digest;
		StringBuilder hash;
		hash = new StringBuilder();
		try {
			buffer = message.getBytes(TRANSFORMATION_FORMAT);
			messageDigest = MessageDigest.getInstance(SHA1);
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

	/** The rt data. */
	private final T rtData;

	/**
	 * Instantiates a new abstract hash key.
	 * 
	 * @param rtData
	 *            the rt data
	 */
	public AbstractHashKey(T rtData) {
		this.rtData = rtData;
	}

	/**
	 * Gets the date.
	 * 
	 * @param zeroGmtMatchDate
	 *            the zero gmt match date
	 * @param sportId
	 *            the sport id
	 * @return the date
	 */
	protected String getDate(Date zeroGmtMatchDate, BigInteger sportId) {
		String result = "";
		int second;
		Calendar cal = Calendar.getInstance();
		cal.setTime(zeroGmtMatchDate);
		int eventDate = cal.get(Calendar.DAY_OF_YEAR);
		boolean avoid = false;

		for (AvoidSports element : AvoidSports.values()) {
			if (element.id == sportId) {
				avoid = true;
			}
		}
		if (!avoid) {
			if ((eventDate % 2) == 0) {// par
				second = eventDate - 1;
				result = second + "-" + eventDate;
			} else {// impar
				second = eventDate + 1;
				result = eventDate + "-" + second;
			}
		} else {
			result = "" + eventDate;
		}

		return result;
	}

	/**
	 * Hash key.
	 * 
	 * @return the string
	 */
	public abstract String getHashKey();

	/**
	 * Gets the list id rt participant.
	 * 
	 * @param rtParticipants
	 *            the rt participants
	 * @return the list id rt participant
	 */
	protected String getListIdRtParticipant(Set<RtParticipant> rtParticipants) {
		List<RtParticipant> participants = new ArrayList<RtParticipant>(
				rtParticipants);
		String result = "";
		Collections.sort(participants);
		Boolean flag = Boolean.TRUE;
		for (RtParticipant rtParticipant : participants) {
			CfgParticipant participant = rtParticipant.getCfgParticipant();
			if (participant.getObjectId() != null) {
				result += participant.getObjectId();
			} else {
				flag = Boolean.FALSE;
			}
		}
		if (!flag) {
			result = "";
		}
		return result;
	}

	/**
	 * Gets the rt data.
	 * 
	 * @return the rt data
	 */
	protected T getRtData() {
		return rtData;
	}

}