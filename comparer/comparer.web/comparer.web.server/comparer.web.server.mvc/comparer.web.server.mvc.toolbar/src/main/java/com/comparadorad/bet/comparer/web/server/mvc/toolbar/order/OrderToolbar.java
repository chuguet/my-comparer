/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.toolbar.order;

import java.util.Comparator;
import java.util.Locale;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;

/**
 * The Class OrderToolbar.
 */
public class OrderToolbar implements Comparator<RtToolbarElement> {

	/** The locale. */
	private Locale locale;

	/**
	 * Instantiates a new order toolbar.
	 */
	public OrderToolbar() {

	}

	/**
	 * Instantiates a new order toolbar.
	 * 
	 * @param pLocale
	 *            the locale
	 */
	public OrderToolbar(Locale pLocale) {
		this.setLocale(pLocale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(RtToolbarElement o1, RtToolbarElement o2) {
		int result;

		if (o1.getToolbarConfigurable().getOrder() != null
				&& o2.getToolbarConfigurable().getOrder() != null) {
			result = o1.getToolbarConfigurable().getOrder()
					.compareTo(o2.getToolbarConfigurable().getOrder());
			if (result == 0) {
				result = o1.getToolbarConfigurable().getName(locale)
						.compareTo(o2.getToolbarConfigurable().getName(locale));
			}
		} else {
			result = o1.getToolbarConfigurable().getName(locale)
					.compareTo(o2.getToolbarConfigurable().getName(locale));
		}

		return result;
	}

	/**
	 * Gets the locale.
	 * 
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 * 
	 * @param locale
	 *            the new locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
