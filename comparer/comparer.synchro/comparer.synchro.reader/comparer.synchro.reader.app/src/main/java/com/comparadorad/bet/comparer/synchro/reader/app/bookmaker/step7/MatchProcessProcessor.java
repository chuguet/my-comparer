package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step7;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.RtMatchWithHash;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.XmlMatchWithHash;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.ProcessXmlMarketToRtMarket;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.ConvertException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

@Service
public class MatchProcessProcessor extends AbstractBookmakerProcess
		implements
		ItemProcessor<StepProcessData<XmlMatchWithHash>, StepProcessData<RtMatchWithHash>> {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The generic process xml market to rt market. */
	@Inject
	private ProcessXmlMarketToRtMarket processXmlMarketToRtMarket;

	/**
	 * Process.
	 * 
	 * @param processData
	 *            the process data
	 * @return the step process data {@inheritDoc}
	 */
	@Override
	public StepProcessData<RtMatchWithHash> process(
			StepProcessData<XmlMatchWithHash> processData) {
		RtMatch rtMatch = null;
		LOG.info(Thread.currentThread(), "Se inicia el step 7. Hora: "
				+ new Date());
		try {
			LOG.debug(Thread.currentThread(), getStepMessageChain(processData)
					+ "Converting XML object to RT objects");
			rtMatch = processXmlMarketToRtMarket.process(processData.getData()
					.getXmlMatch(), processData.getCfgBookmaker());

			if (rtMatch == null || rtMatch.getRtMarkets() == null
					|| rtMatch.getRtMarkets().isEmpty()
					|| rtMatch.getRtMarkets().size() == 0) {
				LOG.error(Thread.currentThread(),
						getStepMessageChain(processData)
								+ "Match is not retrieved");
			}
		} catch (ConvertException e) {
			LOG.warn(Thread.currentThread(), getStepMessageChain(processData)
					+ e.getMessage(), e);
			rtMatch = null;
		} catch (Throwable e) {
			LOG.error(Thread.currentThread(), getStepMessageChain(processData)
					+ e.getMessage());
		}
		if (rtMatch != null && rtMatch.getRtMarkets() != null
				&& !rtMatch.getRtMarkets().isEmpty()) {
			return new StepProcessData<RtMatchWithHash>(
					processData.getCfgBookmaker(), new RtMatchWithHash(rtMatch,
							processData.getData().getHash()));
		} else {
			return null;
		}
	}
}
