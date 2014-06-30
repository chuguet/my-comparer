/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers;

import java.util.Collection;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;

/**
 * The Interface MarketType.
 */
public interface MarketType {

	/**
	 * Gets the market ganador.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketGanador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException;

	/**
	 * Gets the market ganador partido.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market ganador partido
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketGanadorPartido(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException;

	/**
	 * Gets the market handicap asiatico.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market handicap asiatico
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketHandicapAsiatico(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException;

	/**
	 * Gets the market mas menos.
	 * 
	 * @param market
	 *            the market
	 * @return the market mas menos
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketMasMenos(Object market) throws XmlReaderException;

	/**
	 * Gets the market uno x dos.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market uno x dos
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketUnoXDos(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException;

	/**
	 * Gets the market uno x dos handicap.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market uno x dos handicap
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketUnoXDosHandicap(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException;

	/**
	 * Gets the market maximo goleador.
	 * 
	 * @param market
	 *            the market
	 * @param xmlMatchParticipants
	 *            the xml match participants
	 * @return the market maximo goleador
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	public XmlMarket getMarketMaximoGoleador(Object market,
			Collection<XmlMatchParticipant> xmlMatchParticipants)
			throws XmlReaderException;

}
