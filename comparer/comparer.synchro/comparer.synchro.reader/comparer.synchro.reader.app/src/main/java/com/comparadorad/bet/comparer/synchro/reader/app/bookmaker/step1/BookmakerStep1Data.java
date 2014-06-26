/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step1;

import java.io.Serializable;
import java.util.Stack;

import org.springframework.batch.item.ExecutionContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step2.BookmakerStep2Data;

/**
 * The Class BookmakerStep3Data.
 */
@SuppressWarnings("serial")
public final class BookmakerStep1Data implements Serializable {

	/** The Constant ID. */
	public static final String ID = BookmakerStep1Data.class.getSimpleName();

	/** The bookmaker stack. */
	private Stack<CfgBookmaker> bookmakerStack = new Stack<CfgBookmaker>();
	
	private volatile static BookmakerStep1Data instance;

	/**
	 * Instantiates a new bookmaker step1 data.
	 */
	private BookmakerStep1Data() {

	}

	/**
	 * Gets the single instance of BookmakerStep1Data.
	 * 
	 * @param pExecutionContext
	 *            the execution context
	 * @return single instance of BookmakerStep1Data
	 */
//	public static BookmakerStep1Data getInstance(
//			ExecutionContext pExecutionContext) {
//		BookmakerStep1Data instance = (BookmakerStep1Data) pExecutionContext
//				.get(BookmakerStep1Data.ID);
//		if (instance == null) {
//			synchronized (BookmakerStep1Data.class) {
//				instance = new BookmakerStep1Data();
//				pExecutionContext.put(BookmakerStep1Data.ID, instance);
//			}
//		}
//		return instance;
//	}
	
	
	public static BookmakerStep1Data getInstance() {
		if (instance == null) {
			synchronized (BookmakerStep1Data.class) {
				instance = new BookmakerStep1Data();
			}
		}
		return instance;
	}

	/**
	 * Adds the all.
	 * 
	 * @param bookmakerIterable
	 *            the bookmaker iterable
	 * @return true, if successful
	 */
	public boolean addAll(Iterable<? extends CfgBookmaker> bookmakerIterable) {
		for (CfgBookmaker tmpBookmaker : bookmakerIterable) {
			bookmakerStack.push(tmpBookmaker);
		}
		return true;
	}

	/**
	 * Peek.
	 * 
	 * @return the cfg bookmaker
	 */
	public CfgBookmaker pop() {
		if (!bookmakerStack.isEmpty()) {
			return bookmakerStack.pop();
		}
		return null;
	}
}
