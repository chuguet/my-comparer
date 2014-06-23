package com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;

@Component
public class MatchHashkeyGeneratorParticipants extends
		AbstractMatchHashkeyGeneratorImpl {

	@Override
	protected String generateParticipantsHashKey(final RtMatch match) {
		String hashkey = "";

		// Si el deporte no tiene configurado el hashkey por participantes
		// no lo hacemos
		resultParticipant = getListIdRtParticipant(match.getMatchId()
				.getParticipiants());
		if (!resultParticipant.equals("")) {
			hashkey += resultParticipant;
		} else {
			flag = Boolean.FALSE;
		}

		return hashkey;
	}

	@Override
	public List<String> getIds() {
		List<String> ids = new ArrayList<String>();
		ids.add(CfgSportId.AMERICAN_FOOTBALL.id());
		ids.add(CfgSportId.BASEBALL.id());
		ids.add(CfgSportId.BASKETBALL.id());
		ids.add(CfgSportId.FOOTBALL.id());
		ids.add(CfgSportId.HANDBALL.id());
		ids.add(CfgSportId.ICE_HOCKEY.id());
		ids.add(CfgSportId.RUGBY_LEAGUE.id());
		ids.add(CfgSportId.TENNIS.id());
		return ids;
	}

	@Override
	protected String generateDateHashKey(RtMatch match) {
		String hashKey = "";
		if (match.getMatchId().getStartDate().getZeroGmtMatchDate() != null) {
			hashKey = getDate(match.getMatchId().getStartDate()
					.getZeroGmtMatchDate(), match.getCompetition()
					.getSport().getObjectId());
		} else {
			flag = Boolean.FALSE;
		}
		return hashKey;
	}
	
	private String getDate(Date zeroGmtMatchDate, BigInteger sportId) {
		String result = "";
		int second;
		Calendar cal=Calendar.getInstance();
		cal.setTime(zeroGmtMatchDate);
		int eventDate = cal.get(Calendar.DAY_OF_YEAR);
		boolean avoid = false;
		
		for (AvoidSports element : AvoidSports.values()) {
			if(element.id==sportId){
				avoid = true;
			}
		}
		if(!avoid){
			if((eventDate%2)==0){//par
				second = eventDate-1;
				result = second + "-" + eventDate;
			}else{//impar
				second = eventDate+1;
				result = eventDate + "-" + second;
			}
		}else{
			result = ""+eventDate;
		}
		
		return result;
	}
	
	private enum AvoidSports {

		Example(BigInteger.valueOf(1234561324));

		private BigInteger id;

		private AvoidSports(BigInteger id) {
			this.id = id;
		}
	}

}
