/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step2;

import java.io.Serializable;
import java.util.Stack;

import org.springframework.batch.item.ExecutionContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;

/**
 * The Class BookmakerStep3Data.
 */
@SuppressWarnings("serial")
public final class BookmakerStep2Data implements Serializable {

	/** The Constant ID. */
	public static final String ID = BookmakerStep2Data.class.getSimpleName();

	/** The bookmaker stack. */
	private Stack<StepProcessData<BeanUrlMaker>> urlFileStack = new Stack<StepProcessData<BeanUrlMaker>>();
	
	private volatile static BookmakerStep2Data instance;

	/**
	 * Instantiates a new bookmaker step2 data.
	 */
	private BookmakerStep2Data() {

	}
	
	public static BookmakerStep2Data getInstance(
			ExecutionContext pExecutionContext) {
		if (instance == null) {
			synchronized (BookmakerStep2Data.class) {
				if( instance == null ){
					instance = new BookmakerStep2Data();
				}				
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
	public boolean add(BeanUrlMaker url, CfgBookmaker pCfgBookmaker) {
		if (url != null) {
			urlFileStack.push(new StepProcessData<BeanUrlMaker>(pCfgBookmaker,
					url));

		}
		return true;
	}

	/**
	 * Peek.
	 * 
	 * @return the cfg bookmaker
	 */
	public StepProcessData<BeanUrlMaker> pop() {
		StepProcessData<BeanUrlMaker> result = null;
		if (!urlFileStack.isEmpty()) {
			result = urlFileStack.pop();
		}
		return result;
	}
}
