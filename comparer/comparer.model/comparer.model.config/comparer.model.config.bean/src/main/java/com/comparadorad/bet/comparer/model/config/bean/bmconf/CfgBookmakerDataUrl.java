/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.IDocumentField;

/**
 * The Class BookmakerUrl.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CfgBookmakerDataUrl extends AbstractId implements IDocumentField {

	/**
	 * The Enum UrlDataTypes.
	 */
	public enum UrlDataTypes {

		/** The DATA. 
		 *  URL de Datos. URL donde se encuentra los datos de apuestas.
		 * */
		DATA("data"), 
		/** The PARAMETERS. 
		 *  Url de Parametros. URL donde se encuentra los datos necesarios para crear una nueva URL de datos.
		 * */		
		PARAMETERS("parameters"),
		
		/** The BASE. 
		 * URL incompleta que necesita ser transformada. Normalmente con los datos obtenidos de una url de parametros.
		 * */
		BASE("base");

		/** The type. */
		private String type;

		/**
		 * Instantiates a new url data types.
		 *
		 * @param type the type
		 */
		
		private UrlDataTypes(String type) {
			this.type = type;
		}

		/**
		 * Gets the type.
		 *
		 * @return the type
		 */
		public String getType() {
			return type;
		}

	}

	/** The parameters. */
	@Field
	private List<String> parameters;
	
	/** The url. */
	@Field
	private String url;	

	/** The url data type. 
	 *  Especifica el tipo de url. Indica 
	 * */
	@Field
	private UrlDataTypes urlDataType;

	/**
	 * Instantiates a new bookmaker url.
	 */
	public CfgBookmakerDataUrl() {
		super();
	}

	/**
	 * Instantiates a new bookmaker url.
	 * 
	 * @param pUrl
	 *            the url
	 */
	public CfgBookmakerDataUrl(final String pUrl) {
		super();
		url = pUrl;
		
	}
	
	/**
	 * Instantiates a new cfg bookmaker data url.
	 *
	 * @param url the url
	 * @param urlDataTypes the url data types
	 */
	public CfgBookmakerDataUrl(final String url, final UrlDataTypes urlDataTypes ) {
		super();
		this.url = url;
		this.urlDataType = urlDataTypes;
	}
	
	

	/**
	 * Equals.
	 * 
	 * @param object
	 *            the object
	 * @return true, if successful
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(final Object object) {
		if (!(object instanceof CfgBookmakerDataUrl)) {
			return false;
		}
		final CfgBookmakerDataUrl rhs = (CfgBookmakerDataUrl) object;
		return new EqualsBuilder().appendSuper(super.equals(object))
				.append(this.url, rhs.url)
				.append(this.parameters, rhs.parameters).isEquals();
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Gets the url data type.
	 *
	 * @return the url data type
	 */
	public UrlDataTypes getUrlDataType() {
		return urlDataType;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(1033368571, -2056658453)
				.appendSuper(super.hashCode()).append(this.url).toHashCode();
	}

	/**
	 * Sets the url.
	 * 
	 * @param pUrl
	 *            the new url
	 */
	public void setUrl(final String pUrl) {
		try {
			new URL(pUrl);
			this.url = pUrl;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * Sets the url data type.
	 *
	 * @param urlDataType the new url data type
	 */
	public void setUrlDataType(UrlDataTypes urlDataType) {
		this.urlDataType = urlDataType;
	}
}