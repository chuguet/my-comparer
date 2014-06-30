/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

/**
 * The Class RtMatchWriter.
 */
public class RtMatchWriter extends AbstractWriterXML<List<RtMatch>> {

	 /** {@inheritDoc} */ 
	@Override
	protected boolean isExtended() {
		return false;
	}

	 /** {@inheritDoc} */ 
	@Override
	protected List<RtMatch> makeObject() {
		List<RtMatch> result = new ArrayList<RtMatch>();
		return result;
	}

}
