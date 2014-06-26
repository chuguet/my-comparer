/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step6;

import java.io.Serializable;
import java.util.Collection;
import java.util.Stack;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.XmlMatchWithHash;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;

/**
 * The Class BookmakerStep6Data.
 */
@SuppressWarnings("serial")
public class BookmakerStep6Data implements Serializable {

	/** The Constant ID. */
	public static final String ID = BookmakerStep6Data.class.getSimpleName();

	/** The bookmaker stack. */
	private Stack<StepProcessData<XmlMatchWithHash>> xmlMatchStack = new Stack<StepProcessData<XmlMatchWithHash>>();

	private volatile static BookmakerStep6Data instance;

	/**
	 * Instantiates a new bookmaker step6 data.
	 */
	private BookmakerStep6Data() {

	}

	public static BookmakerStep6Data getInstance() {
		if (instance == null) {
			synchronized (BookmakerStep6Data.class) {
				instance = new BookmakerStep6Data();
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
	public boolean addAll(Collection<XmlMatchWithHash> pBookmakerEvents,
			CfgBookmaker cfgBookmaker) {
		for (XmlMatchWithHash xmlMatchWithHash : pBookmakerEvents) {
			StepProcessData<XmlMatchWithHash> processData = new StepProcessData<XmlMatchWithHash>(
					cfgBookmaker, xmlMatchWithHash);
			if (xmlMatchStack != null) {
				xmlMatchStack.push(processData);
			}
		}
		return true;
	}

	/**
	 * Adds the.
	 * 
	 * @param xmlMatch
	 *            the xml match
	 * @param cfgBookmaker
	 *            the cfg bookmaker
	 * @return true, if successful
	 */
	public boolean add(XmlMatchWithHash xmlMatch, CfgBookmaker cfgBookmaker) {
		StepProcessData<XmlMatchWithHash> processData = new StepProcessData<XmlMatchWithHash>(
				cfgBookmaker, xmlMatch);
		if (xmlMatchStack != null) {
			xmlMatchStack.push(processData);
		}
		return true;
	}

	/**
	 * Pop.
	 * 
	 * @return the step process data
	 */
	public StepProcessData<XmlMatchWithHash> pop() {
		if (!xmlMatchStack.isEmpty()) {
			return xmlMatchStack.pop();
		}
		return null;
	}

	/**
	 * Adds the hashkey (because access to an stack is eliminate data), pop and
	 * push operations.
	 * 
	 * @param stackHashKeys
	 */
	public void addStackHashKeyBookMaker(Stack<String> stackHashKeys) {
		StepProcessData<XmlMatchWithHash> spd = null;
		if (!xmlMatchStack.isEmpty()) {
			spd = xmlMatchStack.peek(); // Busca en el stack sin borrarlo
			if (spd.getBeanAdditionalXmlInfoReader() == null) {
				spd.setBeanAdditionalXmlInfoReader(new BeanAdditionalXmlInfoReader(
						"", "", ""));
			}
			spd.getBeanAdditionalXmlInfoReader()
					.setActualHashKeyOfMathInProcess(stackHashKeys);
		}
	}

}
