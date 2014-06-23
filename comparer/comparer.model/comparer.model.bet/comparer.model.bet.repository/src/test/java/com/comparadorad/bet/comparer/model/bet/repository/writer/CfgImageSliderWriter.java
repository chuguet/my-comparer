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

import com.comparadorad.bet.comparer.model.bet.bean.CfgImageSlider;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgImageSliderWriter.
 */
public class CfgImageSliderWriter extends
		AbstractWriterXML<List<CfgImageSlider>> {

	/** The Constant IMAGE_LOCATION_1. */
	private static final String IMAGE_LOCATION_1 = "/documents/10180/0/Evento2/63910dee-cd01-408e-bf14-ff11b98fd693?t=1373624078000";

	/** The Constant IMAGE_LOCATION_2. */
	private static final String IMAGE_LOCATION_2 = "/documents/10180/0/Evento1/393e6dc2-352a-4f23-82cd-23f67e7b19e1?t=1373623925000";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML
	 * #isExtended()
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML
	 * #makeObject()
	 */
	@Override
	protected List<CfgImageSlider> makeObject() {
		CfgImageSlider cfgImageSlider;
		CfgBetType betType;
		CfgBetTypeEvent betTypeEvent;
		List<CfgImageSlider> result = new ArrayList<CfgImageSlider>();

		cfgImageSlider = new CfgImageSlider();
		betType = new CfgBetType();
		betType.setObjectId(new BigInteger("1"));
		cfgImageSlider.setBetType(betType);
		betTypeEvent = new CfgBetTypeEvent();
		betTypeEvent.setObjectId(new BigInteger("1"));
		cfgImageSlider.setBetTypeEvent(betTypeEvent);
		cfgImageSlider.setIdMatch("1122");
		cfgImageSlider.setImageLocation(IMAGE_LOCATION_1);
		result.add(cfgImageSlider);

		cfgImageSlider = new CfgImageSlider();
		betType = new CfgBetType();
		betType.setObjectId(new BigInteger("1"));
		cfgImageSlider.setBetType(betType);
		betTypeEvent = new CfgBetTypeEvent();
		betTypeEvent.setObjectId(new BigInteger("1"));
		cfgImageSlider.setBetTypeEvent(betTypeEvent);
		cfgImageSlider.setIdMatch("2211");
		cfgImageSlider.setImageLocation(IMAGE_LOCATION_2);
		result.add(cfgImageSlider);

		return result;
	}

}
