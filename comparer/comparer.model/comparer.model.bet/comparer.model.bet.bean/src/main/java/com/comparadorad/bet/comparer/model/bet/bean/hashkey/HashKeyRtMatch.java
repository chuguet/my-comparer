/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.hashkey;

import com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.MatchHashkeyGenerator;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.matchHashkeyFactory.impl.MatchHasykeyFactoryImpl;

/**
 * The Class HashKeyRtMatch.
 */
public class HashKeyRtMatch extends AbstractHashKey<RtMatch> {

	/**
	 * Instantiates a new hash key rt match.
	 * 
	 * @param pObject
	 *            the object
	 */
	public HashKeyRtMatch(RtMatch pObject) {
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
		// String resultParticipant = "";
		RtMatch match = getRtData();

		if (match.getCompetition() != null) {
			MatchHasykeyFactoryImpl factory = new MatchHasykeyFactoryImpl();
			MatchHashkeyGenerator generator = factory
					.makeHashKeyGenerator(match.getMatchId().getCompetition()
							.getSport().getObjectId().toString());
			result = generator.getHashKey(match);
		}

		// Boolean flag = Boolean.TRUE;
		// if (match != null && match.getMatchId() != null
		// && match.getMatchId().getCompetition() != null
		// && match.getMatchId().getCompetition().getObjectId() != null
		// && match.getMatchId().getParticipiants() != null
		// && match.getMatchId().getStartDate() != null
		// && match.getMatchId().getCompetitionEvent() != null) {
		// result += match.getMatchId().getCompetition().getObjectId();
		//
		// // Solo si el deporte esta configurado para que tengamos en cuenta
		// // sus participantes ejecutamos esto
		// if (match.getCompetition().getSport().getHashKeyParticipants()
		// .equals(Boolean.TRUE)) {
		// resultParticipant = getListIdRtParticipant(match.getMatchId()
		// .getParticipiants());
		// if (!resultParticipant.equals("")) {
		// result += resultParticipant;
		// } else {
		// flag = Boolean.FALSE;
		// }
		// }
		//
		// if (match.getMatchId().getStartDate().getZeroGmtMatchDate() != null)
		// {
		// result += getDate(match.getMatchId().getStartDate()
		// .getZeroGmtMatchDate(), match.getCompetition()
		// .getSport().getObjectId());
		// } else {
		// flag = Boolean.FALSE;
		// }
		// if (match.getMatchId().getCompetitionEvent().getLongTerm() != null
		// && match.getMatchId().getCompetitionEvent().getLongTerm()
		// .getLongTerm() != null) {
		// result += match.getMatchId().getCompetitionEvent()
		// .getLongTerm().getLongTerm();
		// } else {
		// flag = Boolean.FALSE;
		// }
		// } else {
		// flag = Boolean.FALSE;
		// }
		// if (flag) {
		// result = encrypt(result);
		// } else {
		// result = "";
		// }

		if (!result.equals("")) {
			result = encrypt(result);
		} else {
			result = "";
		}
		return result;
	}

}
