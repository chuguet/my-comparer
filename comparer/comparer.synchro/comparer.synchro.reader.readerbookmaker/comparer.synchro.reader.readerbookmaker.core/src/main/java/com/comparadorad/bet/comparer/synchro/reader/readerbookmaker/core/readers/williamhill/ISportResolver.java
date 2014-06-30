/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

/**
 * The Interface ISportResolver.
 */
public interface ISportResolver {

	/**
	 * Resolve.
	 *
	 * @param splitName the split name
	 * @return the market info william hill
	 * @throws WilliamHillAttributeException the william hill attribute exception
	 * @throws BetTypeNotFoundException 
	 */
	MarketInfoWilliamHill resolve(String[] splitNames, AdicionalInfo info) throws  BetTypeNotFoundException;
	
}
