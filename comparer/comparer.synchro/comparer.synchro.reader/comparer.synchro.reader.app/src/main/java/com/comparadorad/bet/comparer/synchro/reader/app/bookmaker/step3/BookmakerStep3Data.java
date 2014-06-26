package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step3;

import java.io.Serializable;
import java.util.Stack;

import org.springframework.batch.item.ExecutionContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

@SuppressWarnings("serial")
public class BookmakerStep3Data implements Serializable {
	
	/** The Constant ID. */
	public static final String ID = BookmakerStep3Data.class.getSimpleName();

	/** The bookmaker stack. */
	private Stack<StepProcessData<XmlDataFile>> xmlDataFileStack = new Stack<StepProcessData<XmlDataFile>>();
	
	private volatile static BookmakerStep3Data instance;

	/**
	 * Instantiates a new bookmaker step2 data.
	 */
	private BookmakerStep3Data() {

	}

	/**
	 * Gets the single instance of BookmakerStep3Data.
	 * 
	 * @param pExecutionContext
	 *            the execution context
	 * @return single instance of BookmakerStep3Data
	 */
//	public static BookmakerStep3Data getInstance(
//			ExecutionContext pExecutionContext) {
//		BookmakerStep3Data instance = (BookmakerStep3Data) pExecutionContext
//				.get(BookmakerStep3Data.ID);
//		if (instance == null) {
//			synchronized (BookmakerStep3Data.class) {
//				instance = new BookmakerStep3Data();
//				pExecutionContext.put(BookmakerStep3Data.ID, instance);
//			}
//		}
//		return instance;
//	}
	
	
	public static BookmakerStep3Data getInstance() {
		if (instance == null) {
			synchronized (BookmakerStep3Data.class) {
				instance = new BookmakerStep3Data();
			}
		}
		return instance;
	}

	/**
	 * Adds the all.
	 * 
	 * @param xmlDataFiles
	 *            the xml data files
	 * @param pCfgBookmaker
	 *            the cfg bookmaker
	 * @return true, if successful
	 */
	public boolean addAll(XmlDataFiles xmlDataFiles, CfgBookmaker pCfgBookmaker, BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader) {
		if (xmlDataFiles != null && xmlDataFiles.getDataFiles() != null) {
			for (XmlDataFile xmlDataFile : xmlDataFiles.getDataFiles()) {
				xmlDataFileStack.push(new StepProcessData<XmlDataFile>(
						pCfgBookmaker, xmlDataFile, pBeanAdditionalXmlInfoReader));
			}
		}
		return true;
	}

	/**
	 * Peek.
	 * 
	 * @return the cfg bookmaker
	 */
	public StepProcessData<XmlDataFile> pop() {
		if (!xmlDataFileStack.isEmpty()) {
			return xmlDataFileStack.pop();
		}
		return null;
	}

}
