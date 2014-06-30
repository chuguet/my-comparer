package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Games;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Result;

public class _1X2Resolver implements IBetTypeResolver{

	private final String DRAW = "X";
	private final Integer PARTICIPANTS = 3;


	@Override
	public List<XmlMarketBet> resolveBets(Games game,XmlTournament tournament,String eventName) throws InvalidNumberParticipantsException {
		List<XmlMarketBet> result = new ArrayList<XmlMarketBet>();
		XmlMarketBet bet1 = null;
		XmlMatchParticipant participant1 = null;
		XmlMarketBet betX = null;
		XmlMatchParticipant participantX = null;
		XmlMarketBet bet2 = null;
		XmlMatchParticipant participant2 = null;


		if(game.getResult().size()==PARTICIPANTS){
			//1
			Result p1 = game.getResult().get(0);

			bet1 = new XmlMarketBet();
			participant1 = new XmlMatchParticipant(p1.getName(), tournament);
			participant1.setHomeParticipant(true);
			participant1.setAwayParticipant(false);
			bet1.setXmlMatchParticipant(participant1);
			bet1.setXmlMarketBetOdd(new XmlMarketBetOdd(p1.getOdd().toString()));
			Xml1X2Attribute attribute1 = new Xml1X2Attribute();
			attribute1.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.ONE);
			bet1.setXmlAttribute(attribute1);
			result.add(bet1);

			//X
			Result p2 = game.getResult().get(1);

			betX = new XmlMarketBet();
			betX.setXmlMarketBetOdd(new XmlMarketBetOdd(p2.getOdd().toString()));
			Xml1X2Attribute attributeX = new Xml1X2Attribute();
			attributeX.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.DRAW);
			betX.setXmlAttribute(attributeX);
			result.add(betX);


			//2
			Result p3 = game.getResult().get(2);

			bet2 = new XmlMarketBet();
			participant2 = new XmlMatchParticipant(p3.getName(), tournament);
			participant2.setHomeParticipant(false);
			participant2.setAwayParticipant(true);
			bet2.setXmlMatchParticipant(participant2);
			bet2.setXmlMarketBetOdd(new XmlMarketBetOdd(p3.getOdd().toString()));
			Xml1X2Attribute attribute2 = new Xml1X2Attribute();
			attribute2.setResult(com.comparadorad.bet.comparer.model.bet.bean.Result.TWO);
			bet2.setXmlAttribute(attribute2);
			result.add(bet2);


		}else{
			throw new InvalidNumberParticipantsException();
		}

		return result;
	}

}
