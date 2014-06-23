/**
 *

 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgCompetitionWriter.
 */
public class RtToolbarElementWriter extends
		AbstractWriterXML<List<RtToolbarElement>> {

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<RtToolbarElement> makeObject() {
		List<RtToolbarElement> result = new ArrayList<RtToolbarElement>();

		RtToolbarElement futbol = new RtToolbarElement(null, new CfgSport("1"),
				new CoreActiveElement(Boolean.TRUE), new BigInteger("1"));
		result.add(futbol);

		RtToolbarElement baloncesto = new RtToolbarElement(null, new CfgSport(
				"2"), new CoreActiveElement(Boolean.TRUE), new BigInteger("2"));
		result.add(baloncesto);

		RtToolbarElement espanaBaloncesto = new RtToolbarElement(baloncesto,
				new CfgRegion("724"), new CoreActiveElement(Boolean.TRUE),
				new BigInteger("3"));
		result.add(espanaBaloncesto);

		RtToolbarElement espanaFutbol = new RtToolbarElement(futbol,
				new CfgRegion("724"), new CoreActiveElement(Boolean.TRUE),
				new BigInteger("4"));
		result.add(espanaFutbol);

		RtToolbarElement ligaBBVA = new RtToolbarElement(espanaFutbol,
				new CfgCompetition("656935033"), new CoreActiveElement(
						Boolean.TRUE), new BigInteger("5"));
		result.add(ligaBBVA);

		RtToolbarElement ligaAdelante = new RtToolbarElement(espanaFutbol,
				new CfgCompetition("41"), new CoreActiveElement(Boolean.TRUE),
				new BigInteger("6"));
		result.add(ligaAdelante);

		RtToolbarElement ligaACB = new RtToolbarElement(espanaBaloncesto,
				new CfgCompetition("6"), new CoreActiveElement(Boolean.TRUE),
				new BigInteger("7"));
		result.add(ligaACB);

		return result;
	}
}
