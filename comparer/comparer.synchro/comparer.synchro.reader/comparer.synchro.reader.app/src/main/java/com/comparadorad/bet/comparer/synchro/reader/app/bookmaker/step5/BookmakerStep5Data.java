package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step5;

import java.io.Serializable;
import java.util.Collection;
import java.util.Stack;

import org.springframework.batch.item.ExecutionContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

@SuppressWarnings("serial")
public class BookmakerStep5Data implements Serializable {
	

	/** The Constant ID. */
	public static final String ID = BookmakerStep5Data.class.getSimpleName();

	/** The bookmaker stack. */
	private Stack<StepProcessData<XmlMatch>> xmlMatchStack = new Stack<StepProcessData<XmlMatch>>();
	
	private volatile static BookmakerStep5Data instance;

	/**
	 * Instantiates a new bookmaker step2 data.
	 */
	private BookmakerStep5Data() {

	}

	/**
	 * Gets the single instance of BookmakerStep3Data.
	 * 
	 * @param pExecutionContext
	 *            the execution context
	 * @return single instance of BookmakerStep3Data
	 */
//	public static BookmakerStep5Data getInstance(
//			ExecutionContext pExecutionContext) {
//		BookmakerStep5Data instance = (BookmakerStep5Data) pExecutionContext
//				.get(BookmakerStep5Data.ID);
//		if (instance == null) {
//			synchronized (BookmakerStep5Data.class) {
//				instance = new BookmakerStep5Data();
//				pExecutionContext.put(BookmakerStep5Data.ID, instance);
//			}
//		}
//		return instance;
//	}
	
	public static BookmakerStep5Data getInstance() {
		if (instance == null) {
			synchronized (BookmakerStep5Data.class) {
				instance = new BookmakerStep5Data();
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
	
	public boolean add(XmlMatch xmlMatch, CfgBookmaker cfgBookmaker){
		StepProcessData<XmlMatch> processData = new StepProcessData<XmlMatch>(
				cfgBookmaker, xmlMatch);
		if (xmlMatchStack != null) {
			xmlMatchStack.push(processData);
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
