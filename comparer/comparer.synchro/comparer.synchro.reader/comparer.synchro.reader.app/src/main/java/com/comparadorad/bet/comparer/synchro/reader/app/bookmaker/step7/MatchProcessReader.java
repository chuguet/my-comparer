/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step7;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.XmlMatchWithHash;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step6.BookmakerStep6Data;

/**
 * The Class MatchProcessReader.
 */
@Service
public class MatchProcessReader extends AbstractBookmakerProcess
implements ItemReader<StepProcessData<XmlMatchWithHash>> {
	
	/** {@inheritDoc} */ 
	@Override
	public StepProcessData<XmlMatchWithHash> read() throws Exception,
			UnexpectedInputException, ParseException,
			NonTransientResourceException {
		StepProcessData<XmlMatchWithHash> result = BookmakerStep6Data.getInstance().pop();
		return result;
	}

}
