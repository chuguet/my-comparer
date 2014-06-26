/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step6;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step5.BookmakerStep5Data;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Class FilterProcessReader.
 */
@Service
public class FilterProcessReader extends AbstractBookmakerProcess implements ItemReader<StepProcessData<XmlMatch>> {

	/** {@inheritDoc} */ 
	@Override
	public StepProcessData<XmlMatch> read() throws Exception,
			UnexpectedInputException, ParseException,
			NonTransientResourceException {
		StepProcessData<XmlMatch> result = BookmakerStep5Data.getInstance().pop();
		return result;
	}
	
	

}
