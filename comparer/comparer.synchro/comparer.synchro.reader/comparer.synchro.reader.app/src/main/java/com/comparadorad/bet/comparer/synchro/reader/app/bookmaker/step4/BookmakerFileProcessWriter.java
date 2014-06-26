package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step4;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

@Service
public final class BookmakerFileProcessWriter extends AbstractBookmakerProcess
		implements ItemWriter<StepProcessData<XmlBookmakerEvents>> {

	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Write.
	 * 
	 * @param pBookmakerEvents
	 *            the bookmaker events
	 * @throws Exception
	 *             the exception {@inheritDoc}
	 */
	@Override
	public void write(
			List<? extends StepProcessData<XmlBookmakerEvents>> pBookmakerEvents)
			throws Exception {
		LOG.info(Thread.currentThread(),
				"Se inicializa el writer del step 4. Hora: " + new Date());
		for (StepProcessData<XmlBookmakerEvents> processData : pBookmakerEvents) {
			if (processData.getData() != null) {
				BookmakerStep4Data.getInstance().addAll(
						processData.getData().getXmlMatchs(),
						processData.getCfgBookmaker());
			}
		}
		LOG.info(Thread.currentThread(),
				"Se finaliza el writer del step 4. Hora: " + new Date());
	}
}