/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step2;

import java.io.Serializable;
import java.util.Stack;

import org.springframework.batch.item.ExecutionContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFile;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;

/**
 * The Class BookmakerStep3Data.
 */
@SuppressWarnings("serial")
public final class BookmakerStep2Data implements Serializable {

	/** The Constant ID. */
	public static final String ID = BookmakerStep2Data.class.getSimpleName();

	/** The bookmaker stack. */
	private Stack<StepProcessData<XmlDataFile>> xmlDataFileStack = new Stack<StepProcessData<XmlDataFile>>();

	/**
	 * Instantiates a new bookmaker step2 data.
	 */
	private BookmakerStep2Data() {

	}

	/**
	 * Gets the single instance of BookmakerStep3Data.
	 * 
	 * @param pExecutionContext
	 *            the execution context
	 * @return single instance of BookmakerStep3Data
	 */
	public static BookmakerStep2Data getInstance(
			ExecutionContext pExecutionContext) {
		BookmakerStep2Data instance = (BookmakerStep2Data) pExecutionContext
				.get(BookmakerStep2Data.ID);
		if (instance == null) {
			synchronized (BookmakerStep2Data.class) {
				instance = new BookmakerStep2Data();
				pExecutionContext.put(BookmakerStep2Data.ID, instance);
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
	public boolean addAll(XmlDataFiles xmlDataFiles, CfgBookmaker pCfgBookmaker) {
		if (xmlDataFiles != null && xmlDataFiles.getDataFiles() != null) {
			for (XmlDataFile xmlDataFile : xmlDataFiles.getDataFiles()) {
				xmlDataFileStack.push(new StepProcessData<XmlDataFile>(
						pCfgBookmaker, xmlDataFile));
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
