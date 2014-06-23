/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.hashkey;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

/**
 * The Class HashKeyRtBet.
 */
public class HashKeyRtBet extends AbstractHashKey<RtBet> {

	/**
	 * Instantiates a new hash key rt bet.
	 * 
	 * @param pObject
	 *            the object
	 */
	public HashKeyRtBet(RtBet pObject) {
		super(pObject);
	}

	/**
	 * Gets the hash key.
	 * 
	 * @return the hash key {@inheritDoc}
	 */
	@Override
	public String getHashKey() {
		String result = "";
		StringBuffer hashKey = new StringBuffer();
		RtBet bet = getRtData();

		if (bet != null && bet.getAttribute() != null
				&& bet.getBookmaker() != null
				&& bet.getBookmaker().getObjectId() != null
				&& bet.getParticipant() != null && bet.getAttribute() != null
				&& bet.getAttribute().getBetName() != null) {
			hashKey.append(bet.getBookmaker().getObjectId());
			hashKey.append(bet.getParticipant().isHomeParticipant());
			hashKey.append(bet.getParticipant().isAwayParticipant());
			if (bet.getParticipant().getCfgParticipant() != null) {
				hashKey.append(bet.getParticipant().getCfgParticipant()
						.getObjectId());
			}
			hashKey.append(bet.getAttribute().getBetName());
			hashKey.append(bet.getAttribute().getAttributeHashCode());
			result = encrypt(hashKey.toString());
		}

		return result;
	}

}
