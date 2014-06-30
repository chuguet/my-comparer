package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMaximumGoalerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Games;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Result;

public class _MaximoGoleadorResolver implements IBetTypeResolver{

	@Override
	public List<XmlMarketBet> resolveBets(Games game,XmlTournament tournament,String eventName) throws LongTermException {
		List<XmlMarketBet> result = new ArrayList<XmlMarketBet>();
		XmlMarketBet bet;
		XmlMatchParticipant participant1;
		XmlMaximumGoalerAttribute attribute;
		for (Result bets : game.getResult()) {
			bet = new XmlMarketBet();
			participant1 = new XmlMatchParticipant(bets.getName(),
					tournament);
			bet.setXmlMatchParticipant(participant1);
			bet.setXmlMarketBetOdd(new XmlMarketBetOdd(bets.getOdd().toString()));
			attribute = new XmlMaximumGoalerAttribute();
			attribute.setGoaler(participant1);
			bet.setXmlAttribute(attribute);
			result.add(bet);
		}
		throw new LongTermException(result);
	}

}
