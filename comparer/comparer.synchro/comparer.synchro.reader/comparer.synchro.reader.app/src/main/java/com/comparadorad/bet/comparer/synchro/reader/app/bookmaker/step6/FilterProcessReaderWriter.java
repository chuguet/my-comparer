/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step6;

import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.integration.producer.service.IProducerUpdaterBet;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.XmlMatchWithHash;
import com.comparadorad.bet.comparer.synchro.reader.app.config.AbstractSynchroReaderAppConfig;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.FilterConfigurationBean;
import com.comparadorad.bet.comparer.synchro.reader.filter.bean.RtMatchFilterIdentificator;
import com.comparadorad.bet.comparer.synchro.reader.filter.main.IReaderFilter;
import com.comparadorad.bet.comparer.synchro.reader.filter.plugin.PluginFilterWithIdentificator;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class FilterProcessReaderWriter.
 */
@Service
public class FilterProcessReaderWriter extends AbstractBookmakerProcess
		implements ItemWriter<StepProcessData<XmlMatch>> {

	/** The reader filter. */
	@Inject
	private IReaderFilter readerFilter;

	/** The app config. */
	@Inject
	private AbstractSynchroReaderAppConfig appConfig;

	/** The filters. */
	@Inject
	private PluginFilterWithIdentificator filterWithIdentificator;

	@Inject
	private IProducerUpdaterBet updaterBetsProducer;
	
	@Inject
	private ComparerWrapperLog LOG;

	/** {@inheritDoc} */
	@Override
	public void write(List<? extends StepProcessData<XmlMatch>> write)
			throws Exception {
		Boolean isNew;
		UpdaterBetsTO updaterBetsTO;
		RtMatchFilterIdentificator matchFilterIdentificator;
		XmlMatchWithHash xmlMatchWithHash;
		for (StepProcessData<XmlMatch> processData : write) {
			isNew = readerFilter
					.isNew(processData.getData(),
							processData.getCfgBookmaker(),
							new FilterConfigurationBean(appConfig
									.getMemorymaxElement()));
			xmlMatchWithHash = new XmlMatchWithHash(processData.getData(),
					filterWithIdentificator.createHash(processData.getData()));

			if (processData.getData() != null && isNew) {

				BookmakerStep6Data.getInstance().add(xmlMatchWithHash,
						processData.getCfgBookmaker());
			} else {

				try {
					matchFilterIdentificator = filterWithIdentificator
							.findRtMatchFilterIdentificator(
									processData.getCfgBookmaker(),
									xmlMatchWithHash.getHash());

					if (matchFilterIdentificator.getHashkeyRtMarkets().size() != 0
							|| matchFilterIdentificator.getHashkeyRtMarkets()
									.size() != 0) {

						updaterBetsTO = new UpdaterBetsTO(
								matchFilterIdentificator.getHashkeyRtMatch(),
								processData.getCfgBookmaker().getObjectId(),
								matchFilterIdentificator.getHashkeyRtMarkets());

						LOG.info(
								Thread.currentThread(),
								new StringBuffer(
										"Information complete to do an update. Queueed message: ")
										.append(updaterBetsTO).toString());
						updaterBetsProducer.send(updaterBetsTO);
					} else {
						LOG.info(Thread.currentThread(), new StringBuffer(
								"Information incomplete for send update")
								.toString());
					}

				} catch (Exception e) {
					LOG.info(Thread.currentThread(),
							new StringBuffer("Not is possible send update")
									.append(". Not found hash").toString());
				}

			}
		}
	}

}
