/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Class Competition.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
@Document
public class CfgRegion extends AbstractI18nTableActivable implements
		IToolbarConfigurable, IDocument {

	/** The Constant COUNTRY_SMALL_IMG_PATH. */
	public static final String COUNTRY_SMALL_IMG_PATH = "comparer/country/small/";
	/** The alfanumeric2 code. */
	@Field
	private String alfanumeric2Code;

	/** The alfanumeric3 code. */
	@Field
	private String alfanumeric3Code;

	/** The numeric code. */
	@Field
	private Integer numericCode;

	/** The order. */
	@Field
	private Integer order;

	/** The resource. */
	@Transient
	private transient CfgResource resource;

	/** The resources. */
	@DBRef
	private List<CfgResource> resources;

	/**
	 * Instantiates a new cfg competition.
	 */
	public CfgRegion() {
		super();
	}

	/**
	 * Instantiates a new cfg competition.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgRegion(BigInteger pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg competition.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgRegion(String pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg region.
	 * 
	 * @param pObjectId
	 *            the object id
	 * @param countryName
	 *            the country name
	 * @param locale
	 *            the locale
	 */
	public CfgRegion(String pObjectId, String countryName, final Locale locale) {
		super(pObjectId);
		super.setName(countryName, locale);
	}

	/**
	 * Adds the.
	 * 
	 * @param resource
	 *            the resource
	 */
	public void add(CfgResource resource) {
		if (resources == null) {
			resources = new ArrayList<CfgResource>();
		}
		resources.add(resource);
	}

	/**
	 * Gets the alfanumeric2 code.
	 * 
	 * @return the alfanumeric2 code
	 */
	public String getAlfanumeric2Code() {
		return alfanumeric2Code;
	}

	/**
	 * Gets the alfanumeric3 code.
	 * 
	 * @return the alfanumeric3 code
	 */
	public String getAlfanumeric3Code() {
		return alfanumeric3Code;
	}

	/**
	 * Gets the numeric code.
	 * 
	 * @return the numeric code
	 */
	public Integer getNumericCode() {
		return numericCode;
	}

	/**
	 * Gets the order.
	 * 
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource {@inheritDoc}
	 */
	@Override
	public CfgResource getResource() {
		if (resource == null) {
			if (this.getAlfanumeric2Code() != null) {
				resource = new CfgResource(new StringBuffer(
						COUNTRY_SMALL_IMG_PATH)
						.append(getAlfanumeric2Code().toLowerCase())
						.append(".png").toString());
			}
		}
		return resource;
	}

	/**
	 * Gets the resources.
	 * 
	 * @return the resources
	 */
	public List<CfgResource> getResources() {
		return resources;
	}

	/**
	 * Sets the alfanumeric2 code.
	 * 
	 * @param alfanumeric2Code
	 *            the new alfanumeric2 code
	 */
	public void setAlfanumeric2Code(String alfanumeric2Code) {
		this.alfanumeric2Code = alfanumeric2Code;
	}

	/**
	 * Sets the alfanumeric3 code.
	 * 
	 * @param alfanumeric3Code
	 *            the new alfanumeric3 code
	 */
	public void setAlfanumeric3Code(String alfanumeric3Code) {
		this.alfanumeric3Code = alfanumeric3Code;
	}

	/**
	 * Sets the numeric code.
	 * 
	 * @param numericCode
	 *            the new numeric code
	 */
	public void setNumericCode(Integer numericCode) {
		this.numericCode = numericCode;
	}

	/**
	 * Sets the order.
	 * 
	 * @param order
	 *            the new order
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * Sets the resources.
	 * 
	 * @param pResources
	 *            the new resources
	 */
	public void setResources(List<CfgResource> pResources) {
		resources = pResources;
	}

}