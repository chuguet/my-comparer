package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import java.util.List;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin.Games;

public interface IBetTypeResolver {

	public List<XmlMarketBet> resolveBets(Games game,XmlTournament tournament, String eventName)  
			throws InvalidNumberParticipantsException, LongTermException;
}
