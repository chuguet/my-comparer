package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Games;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Result;

public class _HandicapAsiaticoResolver implements IBetTypeResolver{

	private final Integer PARTICIPANTS = 2;
	
	
	@Override
	public List<XmlMarketBet> resolveBets(Games game,XmlTournament tournament,String eventName) throws InvalidNumberParticipantsException {

		
		
		List<XmlMarketBet> result = new ArrayList<XmlMarketBet>();
		XmlMarketBet bet1 = null;
		XmlMatchParticipant participant1 = null;
		XmlMarketBet bet2 = null;
		XmlMatchParticipant participant2 = null;


		if(game.getResult().size()==PARTICIPANTS){
			//1
			Result p1 = game.getResult().get(0);

			String[] splitName1 = p1.getName().split("\\s+");
			String value = splitName1[splitName1.length-1];
			value = value.replace(",", ".");
			
			bet1 = new XmlMarketBet();
			participant1 = new XmlMatchParticipant(p1.getName().replace(value, ""), tournament);
			participant1.setHomeParticipant(true);
			bet1.setXmlMatchParticipant(participant1);
			bet1.setXmlMarketBetOdd(new XmlMarketBetOdd(p1.getOdd().toString()));
			XmlAsianHandicapAttribute attribute1 = new XmlAsianHandicapAttribute();
			attribute1.setAsianResult(AsianResult.ONE);
			attribute1.setFirstValue(Double.parseDouble(value));
			bet1.setXmlAttribute(attribute1);
			result.add(bet1);

			//2
			Result p3 = game.getResult().get(1);
			
			String[] splitName2 = p3.getName().split("\\s+");
			String value2 = splitName2[splitName2.length-1];
			
			bet2 = new XmlMarketBet();
			participant2 = new XmlMatchParticipant(p3.getName().replace(value2, ""), tournament);
			participant2.setAwayParticipant(true);
			bet2.setXmlMatchParticipant(participant2);
			bet2.setXmlMarketBetOdd(new XmlMarketBetOdd(p3.getOdd().toString()));
			XmlAsianHandicapAttribute attribute2 = new XmlAsianHandicapAttribute();
			attribute2.setAsianResult(AsianResult.TWO);
			attribute2.setFirstValue(Double.parseDouble(value));
			bet2.setXmlAttribute(attribute2);
			result.add(bet2);


		}else{
			throw new InvalidNumberParticipantsException();
		}

		return result;
	}
		
		
		
		
		
		
	}


