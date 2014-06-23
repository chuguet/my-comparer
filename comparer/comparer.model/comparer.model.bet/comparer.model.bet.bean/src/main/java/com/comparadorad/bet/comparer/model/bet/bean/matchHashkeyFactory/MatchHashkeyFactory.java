/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.matchHashkeyFactory;

import com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.MatchHashkeyGenerator;

/**
 * A factory for creating MatchHashkey objects.
 */
public interface MatchHashkeyFactory {

	/**
	 * Make hash key generator.
	 *
	 * @param sportId the sport id
	 * @return the match hashkey generator
	 */
	MatchHashkeyGenerator makeHashKeyGenerator(String sportId);
	
}
