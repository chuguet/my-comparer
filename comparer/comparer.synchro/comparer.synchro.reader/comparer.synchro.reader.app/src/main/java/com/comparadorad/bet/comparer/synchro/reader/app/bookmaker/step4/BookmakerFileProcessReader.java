package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step4;


import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step3.BookmakerStep3Data;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBookmakerEvents;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.IXmlBetFileReaderBookMakerService;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderData;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderRuntimeException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class BookmakerEventsReader.
 */
@Service
public final class BookmakerFileProcessReader extends AbstractBookmakerProcess
		implements ItemReader<StepProcessData<XmlBookmakerEvents>> {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;
	
	/** The xml bet file reader service. */
	@Inject
	private IXmlBetFileReaderBookMakerService xmlBetFileReaderService;

	/**
	 * Read.
	 * 
	 * @return the step process data
	 * @throws Exception
	 *             the exception
	 * @throws UnexpectedInputException
	 *             the unexpected input exception
	 * @throws ParseException
	 *             the parse exception
	 * @throws NonTransientResourceException
	 *             the non transient resource exception {@inheritDoc}
	 */
	@Override
	public StepProcessData<XmlBookmakerEvents> read() throws Exception,
			UnexpectedInputException, ParseException,
			NonTransientResourceException {
		
		LOG.info(Thread.currentThread(), "Se inicia el step 4. Hora: "+ new Date() );

		BookmakerStep3Data bookmakerStep3Data = BookmakerStep3Data
				.getInstance();

		StepProcessData<XmlDataFile> processData = bookmakerStep3Data.pop();
		LOG.info(Thread.currentThread(), getStepMessageChain(processData)
				+ "Converting bookmaker file to generic XML objects");
		if (processData != null && processData.getData() != null) {
			XmlBetFileReaderData xmlBetFileReaderData = new XmlBetFileReaderData(
					processData.getData(), processData.getCfgBookmaker(), processData.getBeanAdditionalXmlInfoReader());
			XmlBetFileReaderResult result = null;
			try {
				LOG.info(Thread.currentThread(), "Se llama al lector de la casa de apuestas");
				result = xmlBetFileReaderService.read(xmlBetFileReaderData);
			} catch (XmlReaderException e) {
				LOG.warn(Thread.currentThread(), processData.getCfgBookmaker().getName(Locale.ENGLISH)
						+ " " + e.getMessage(), e);
			} catch (XmlReaderRuntimeException e) {
				LOG.warn(Thread.currentThread(), processData.getCfgBookmaker().getName(Locale.ENGLISH)
						+ " " + e.getMessage(), e);
			} 
			if (result != null && result.getXmlBookmakerEvents() != null
					&& result.getXmlBookmakerEvents().getXmlMatchs() != null) {
				LOG.info(Thread.currentThread(), getStepMessageChain(processData)
						+ "Obtained the XML objects. Number of objects:"
						+ result.getXmlBookmakerEvents().getXmlMatchs().size());
			} else {
				LOG.info(Thread.currentThread(), getStepMessageChain(processData)
						+ "No results obtained");
			}
			if (result != null) {
				return new StepProcessData<XmlBookmakerEvents>(
						processData.getCfgBookmaker(),
						result.getXmlBookmakerEvents());
			} else {
				return new StepProcessData<XmlBookmakerEvents>(
						processData.getCfgBookmaker(), null);
			}
		}
		LOG.debug(Thread.currentThread(), "Se finaliza el reader del step 4");
		return null;
	}
}
