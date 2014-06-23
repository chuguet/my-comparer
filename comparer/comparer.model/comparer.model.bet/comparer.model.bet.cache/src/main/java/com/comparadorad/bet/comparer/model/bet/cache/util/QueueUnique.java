/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.cache.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * The Class QueueUnique.
 * 
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("serial")
@Component
public class QueueUnique<T> extends ArrayList<T> implements Queue<T> {

	/**
	 * Instantiates a new queue unique.
	 */
	public QueueUnique() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.cache.util.Queue#push(java.lang
	 * .Object)
	 */
	public synchronized void push(T t) throws AlreadyContains {
		if (!this.contains(t)) {
			this.add(this.size(), t);
		} else {
			throw new AlreadyContains("La cola ya contiene este elemento");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.cache.util.Queue#pop()
	 */
	public synchronized T pop() throws IsEmpty {
		T result = null;
		if (this.isEmpty()) {
			throw new IsEmpty("La cola esta vacia");
		} else {
			result = this.remove(0);
		}
		return result;
	}
}
