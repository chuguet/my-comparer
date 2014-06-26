/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step3;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class DownloadUrlWriter.
 */
@Service
final class DownloadUrlWriter extends AbstractBookmakerProcess implements
		ItemWriter<StepProcessData<XmlDataFiles>> {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The size file. */
	private static Float sizeFile;

	/** The calculation date. */
	private static Date calculationDate;

	/**
	 * Instantiates a new download url writer.
	 */
	public DownloadUrlWriter() {
		sizeFile = 0F;
		calculationDate = new Date();
	}

	/**
	 * Write.
	 * 
	 * @param processData
	 *            the process data
	 * @throws Exception
	 *             the exception {@inheritDoc}
	 */
	@Override
	public void write(List<? extends StepProcessData<XmlDataFiles>> processData)
			throws Exception {

		LOG.debug(Thread.currentThread(),
				new StringBuffer(
						"Se inicio el calculo del tamaño del fichero en: ")
						.append(calculationDate).toString());
		LOG.debug(Thread.currentThread(), new StringBuffer(
				"El tamaño del fichero acumulado es: ").toString());

		CfgBookmaker cfgBookmaker;
		for (StepProcessData<XmlDataFiles> stepProcessData : processData) {
			cfgBookmaker = stepProcessData.getCfgBookmaker();
			XmlDataFiles xmlDataFiles = stepProcessData.getData();
			BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader = stepProcessData
					.getBeanAdditionalXmlInfoReader();

			BookmakerStep3Data.getInstance().addAll(xmlDataFiles, cfgBookmaker,
					beanAdditionalXmlInfoReader);

			Float megabyteFilesize;
			for (XmlDataFile xmlDataFile : xmlDataFiles) {
				sizeFile += xmlDataFile.getDataFile().length;
				megabyteFilesize = (sizeFile / 1048576);
				LOG.debug(Thread.currentThread(), new StringBuffer(
						"Se inicio el calculo de la descarga acumulada en : ")
						.append(calculationDate).toString());
				LOG.debug(
						Thread.currentThread(),
						new StringBuffer("El tamaño del fichero acumulado es: ")
								.append(megabyteFilesize).append(" Mb")
								.toString());
			}

		}

	}

}
