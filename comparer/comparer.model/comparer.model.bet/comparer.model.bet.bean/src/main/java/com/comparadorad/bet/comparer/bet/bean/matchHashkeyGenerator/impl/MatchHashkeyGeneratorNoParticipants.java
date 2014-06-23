package com.comparadorad.bet.comparer.bet.bean.matchHashkeyGenerator.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;

@Component
public class MatchHashkeyGeneratorNoParticipants extends
		AbstractMatchHashkeyGeneratorImpl {

	@Override
	protected String generateParticipantsHashKey(final RtMatch match) {
		String hashkey = "";

		return hashkey;
	}

	@Override
	public List<String> getIds() {
		List<String> ids = new ArrayList<String>();
		ids.add(CfgSportId.CYCLING.id());
		ids.add(CfgSportId.MOTOR.id());
		return ids;
	}

	@Override
	protected String generateDateHashKey(RtMatch match) {
		String hashKey = "";
		if (match.getMatchId().getStartDate().getZeroGmtMatchDate() != null) {
			hashKey = getDate(match.getMatchId().getStartDate()
					.getZeroGmtMatchDate());
		} else {
			flag = Boolean.FALSE;
		}
		return hashKey;
	}
	
	private String getDate(Date zeroGmtMatchDate) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		return dateFormat.format(zeroGmtMatchDate);
	}

}
