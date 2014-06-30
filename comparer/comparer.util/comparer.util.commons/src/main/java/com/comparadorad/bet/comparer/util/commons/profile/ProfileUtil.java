/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.profile;

import org.apache.commons.lang.ArrayUtils;

/**
 * The Class ProfileUtil.
 */
public class ProfileUtil {

	/**
	 * Contains profile.
	 * 
	 * @param profile
	 *            the profile
	 * @param profiles
	 *            the profiles
	 * @return true, if successful
	 */
	public static boolean containsProfile(String profile, String[] profiles) {
		return ArrayUtils.contains(profiles, profile);
	}
}
