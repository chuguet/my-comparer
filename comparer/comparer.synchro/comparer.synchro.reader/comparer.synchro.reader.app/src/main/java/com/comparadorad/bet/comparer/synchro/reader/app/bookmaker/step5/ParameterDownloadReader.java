package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step5;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step4.BookmakerStep4Data;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

@Service
public final class ParameterDownloadReader extends AbstractBookmakerProcess implements ItemReader<StepProcessData<XmlMatch>> {

	@Override
	public StepProcessData<XmlMatch> read() throws Exception,
			UnexpectedInputException, ParseException,
			NonTransientResourceException {
		StepProcessData<XmlMatch> result = BookmakerStep4Data.getInstance().pop();
		return result;
	}

}
