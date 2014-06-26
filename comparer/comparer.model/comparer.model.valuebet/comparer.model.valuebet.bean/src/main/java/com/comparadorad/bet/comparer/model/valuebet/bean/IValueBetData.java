package com.comparadorad.bet.comparer.model.valuebet.bean;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;

// TODO: Auto-generated Javadoc
/**
 * The Interface IValueBet.
 */
public interface IValueBetData extends IDocument {

	/**
	 * Gets the probability.
	 * 
	 * @return the probability
	 */
	ValueBetProbability getProbability();

	/**
	 * Sets the probability.
	 * 
	 * @param probability
	 *            the new probability
	 */
	void setProbability(ValueBetProbability probability);

	/**
	 * Gets the expectation.
	 * 
	 * @return the expectation
	 */
	ValueBetMathematicalExpectation getExpectation();

	/**
	 * Sets the expectation.
	 * 
	 * @param expectation
	 *            the new expectation
	 */
	void setExpectation(ValueBetMathematicalExpectation expectation);

}
