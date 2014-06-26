/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class AbstractWriterXML.
 * 
 * @param <T>
 *            the generic type
 * 
 *            Extends IDocument because ONLY can write object of type IDocument,
 *            not change
 * @param <I>
 *            the generic type
 */
public abstract class AbstractSynonymsWriterXML<T extends List<? extends IDocument>, I extends ICfgSynonyms>
		extends AbstractWriterXML<T> {

	/** The synonyms list. */
	private List<I> synonymsList = new ArrayList<I>();

	/**
	 * Gets the synonyms list.
	 * 
	 * @return the synonyms list
	 */
	protected List<I> getSynonymsList() {
		return synonymsList;
	}

	/**
	 * Sets the synonyms list.
	 * 
	 * @param pSynonymsList
	 *            the new synonyms list
	 */
	protected void setSynonymsList(List<I> pSynonymsList) {
		synonymsList = pSynonymsList;
	}

	@Override
	public void make() {
		super.make();
		// grabamos los sinónmos
		XStreamUtil.writeObject(getSynonymsList(), pathFile(getSynonymsList()));
	}
}
