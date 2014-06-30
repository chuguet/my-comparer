package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Games;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Result;

public class _MasMenosResolver implements IBetTypeResolver{

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
			value = value.replace(",",".");
			String[] participants = eventName.split("-");
			if(participants.length<2){
				participants = eventName.split("at");
			}
			if(participants.length<2){
				participants = eventName.split("en casa de");
				
			}
			bet1 = new XmlMarketBet();
			participant1 = new XmlMatchParticipant(participants[0], tournament);
			participant1.setHomeParticipant(true);
			participant1.setAwayParticipant(false);
			bet1.setXmlMatchParticipant(participant1);
			bet1.setXmlMarketBetOdd(new XmlMarketBetOdd(p1.getOdd().toString()));
			XmlMoreLessAttribute attribute1 = new XmlMoreLessAttribute();
			attribute1.setTotalGoal(Double.valueOf(value));
			attribute1.setMasMenos(MasMenos.MAS);
			bet1.setXmlAttribute(attribute1);
			result.add(bet1);

			//2
			Result p3 = game.getResult().get(1);

			bet2 = new XmlMarketBet();
			participant2 = new XmlMatchParticipant(participants[1], tournament);
			participant2.setHomeParticipant(false);
			participant2.setAwayParticipant(true);
			bet2.setXmlMatchParticipant(participant2);
			bet2.setXmlMarketBetOdd(new XmlMarketBetOdd(p3.getOdd().toString()));
			XmlMoreLessAttribute attribute2 = new XmlMoreLessAttribute();
			attribute2.setTotalGoal(Double.parseDouble(value));
			attribute2.setMasMenos(MasMenos.MENOS);
			bet2.setXmlAttribute(attribute2);
			result.add(bet2);


		}else{
			throw new InvalidNumberParticipantsException();
		}

		return result;
	}
}


