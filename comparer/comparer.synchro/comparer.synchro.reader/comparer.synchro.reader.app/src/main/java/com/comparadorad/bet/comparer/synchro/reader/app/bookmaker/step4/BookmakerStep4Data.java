/**
*
* Copyright (C) FACTORIA ETSIA S.L.
* All Rights Reserved.
* www.factoriaetsia.com
*
*/
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step4;

import java.io.Serializable;
import java.util.Collection;
import java.util.Stack;

import org.springframework.batch.item.ExecutionContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
* The Class BookmakerStep3Data.
*/
@SuppressWarnings("serial")
public final class BookmakerStep4Data implements Serializable {

	/** The Constant ID. */
	public static final String ID = BookmakerStep4Data.class.getSimpleName();

	/** The bookmaker stack. */
	private Stack<StepProcessData<XmlMatch>> xmlMatchStack = new Stack<StepProcessData<XmlMatch>>();
	
	private volatile static BookmakerStep4Data instance;

	/**
	 * Instantiates a new bookmaker step2 data.
	 */
	private BookmakerStep4Data() {

	}

	/**
	 * Gets the single instance of BookmakerStep3Data.
	 * 
	 * @param pExecutionContext
	 *            the execution context
	 * @return single instance of BookmakerStep3Data
	 */
//	public static BookmakerStep4Data getInstance(
//			ExecutionContext pExecutionContext) {
//		BookmakerStep4Data instance = (BookmakerStep4Data) pExecutionContext
//				.get(BookmakerStep4Data.ID);
//		if (instance == null) {
//			synchronized (BookmakerStep4Data.class) {
//				instance = new BookmakerStep4Data();
//				pExecutionContext.put(BookmakerStep4Data.ID, instance);
//			}
//		}
//		return instance;
//	}
	
	public static BookmakerStep4Data getInstance() {
		if (instance == null) {
			synchronized (BookmakerStep4Data.class) {
				instance = new BookmakerStep4Data();
			}
		}
		return instance;
	}

	/**
	 * Adds the all.
	 * 
	 * @param pBookmakerEvents
	 *            the bookmaker events
	 * @param cfgBookmaker
	 *            the cfg bookmaker
	 * @return true, if successful
	 */
	public boolean addAll(Collection<XmlMatch> pBookmakerEvents,
			CfgBookmaker cfgBookmaker) {
		for (XmlMatch xmlMatch : pBookmakerEvents) {
			StepProcessData<XmlMatch> processData = new StepProcessData<XmlMatch>(
					cfgBookmaker, xmlMatch);
			if (xmlMatchStack != null) {
				xmlMatchStack.push(processData);
			}
		}
		return true;
	}

	/**
	 * Peek.
	 * 
	 * @return the cfg bookmaker
	 */
	public StepProcessData<XmlMatch> pop() {
		if (!xmlMatchStack.isEmpty()) {
			return xmlMatchStack.pop();
		}
		return null;
	}
}
