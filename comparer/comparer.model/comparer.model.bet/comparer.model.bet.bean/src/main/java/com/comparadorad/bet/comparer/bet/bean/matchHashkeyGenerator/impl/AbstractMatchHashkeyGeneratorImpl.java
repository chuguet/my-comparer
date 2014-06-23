package com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.MatchHashkeyGenerator;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;

public abstract class AbstractMatchHashkeyGeneratorImpl implements MatchHashkeyGenerator{

	protected String result = "";
	protected Boolean flag = Boolean.TRUE;
	protected String resultParticipant = "";

	
	@Override 
	public String getHashKey(final RtMatch match) {
		if (match != null && match.getMatchId() != null
				&& match.getMatchId().getCompetition() != null
				&& match.getMatchId().getCompetition().getObjectId() != null
				&& match.getMatchId().getParticipiants() != null
				&& match.getMatchId().getStartDate() != null
				&& match.getMatchId().getCompetitionEvent() != null) {
			
			result += match.getMatchId().getCompetition().getObjectId();
		
			result += generateParticipantsHashKey(match);	
			
			result += generateDateHashKey(match);
			
			if (match.getMatchId().getCompetitionEvent().getLongTerm() != null
					&& match.getMatchId().getCompetitionEvent().getLongTerm()
							.getLongTerm() != null) {
				result += match.getMatchId().getCompetitionEvent()
						.getLongTerm().getLongTerm();
			} else {
				flag = Boolean.FALSE;
			}
		} else {
			flag = Boolean.FALSE;
		}
		
		

		return result;
	}

	protected abstract String generateDateHashKey(RtMatch match);

	protected abstract String generateParticipantsHashKey(RtMatch match);

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

//	protected String getDate(Date zeroGmtMatchDate, BigInteger sportId) {
//		String result = "";
//		int second;
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(zeroGmtMatchDate);
//		int eventDate = cal.get(Calendar.DAY_OF_YEAR);
//		boolean avoid = false;
//
//		for (AvoidSports element : AvoidSports.values()) {
//			if (element.id == sportId) {
//				avoid = true;
//			}
//		}
//		if (!avoid) {
//			if ((eventDate % 2) == 0) {// par
//				second = eventDate - 1;
//				result = second + "-" + eventDate;
//			} else {// impar
//				second = eventDate + 1;
//				result = eventDate + "-" + second;
//			}
//		} else {
//			result = "" + eventDate;
//		}
//
//		return result;
//	}

//	public enum AvoidSports {
//
//		Example(BigInteger.valueOf(1234561324));
//
//		private BigInteger id;
//
//		private AvoidSports(BigInteger id) {
//			this.id = id;
//		}
//	}
	
}
