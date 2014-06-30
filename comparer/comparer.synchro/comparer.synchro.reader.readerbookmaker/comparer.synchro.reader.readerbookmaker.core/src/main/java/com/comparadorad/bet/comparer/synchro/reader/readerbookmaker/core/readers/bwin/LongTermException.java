package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import java.util.List;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

@SuppressWarnings("serial")
public class LongTermException extends XmlReaderException {

	private XmlMarket market;
	
	private List<XmlMarketBet> bets;
	
	
	public LongTermException() {
		super();
	}

	public LongTermException(XmlMarket market) {
		super();
		this.market = market;
	}
	
	public LongTermException(List<XmlMarketBet> bets) {
		super();
		this.bets = bets;
	}
	
	
	public List<XmlMarketBet> getBets() {
		return bets;
	}

	public XmlMarket getMarket() {
		return market;
	}

	public LongTermException(String pMessage, Throwable pCause) {
		super(pMessage, pCause);
	}

	public LongTermException(String pMessage) {
		super(pMessage);
	}

	public LongTermException(Throwable pCause) {
		super(pCause);
	}

}
