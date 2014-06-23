/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;

/**
 * The Class SortedActionTypeByDate.
 */
public class SortedActionTypeByDate implements Comparator<UserAction> {

	/** {@inheritDoc} */ 
	@Override
	public int compare(UserAction userAction1, UserAction userAction2) {
		return userAction1.getCreationDate().compareTo(
				userAction2.getCreationDate());
	}

}
