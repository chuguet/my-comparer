/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.hashkey;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;

/**
 * The Class HashKeyRtMarket.
 */
public class HashKeyRtMarket extends AbstractHashKey<RtMarket> {

	/**
	 * Instantiates a new hash key rt market.
	 * 
	 * @param pObject
	 *            the object
	 */
	public HashKeyRtMarket(RtMarket pObject) {
		super(pObject);
	}

	/**
	 * Gets the hash key.
	 *
	 * @return the hash key
	 * {@inheritDoc}
	 */
	@Override
	public String getHashKey() {
		String result = "";
		RtMarket market = getRtData();
		if (market != null && market.getBetType() != null
				&& market.getBetType().getObjectId() != null
				&& market.getBetTypeEvent() != null
				&& market.getBetTypeEvent().getBetTypeEvent().getObjectId() != null) {
			result += market.getBetType().getObjectId().toString();
			result += market.getBetTypeEvent().getBetTypeEvent().getObjectId().toString();
			result = encrypt(result);
		}
		return result;
	}

}
