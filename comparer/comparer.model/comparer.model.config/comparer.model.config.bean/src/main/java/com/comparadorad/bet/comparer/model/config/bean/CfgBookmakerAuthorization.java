/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;

/**
 * The Class CfgBookmakerAuthorization.
 * 
 * Entity for the bookmaker authorization. See RQ 68
 * 
 * https://portalapp.factoriaetsia.com/wiki/index.php/RQ_Comparador_de_apuestas:
 * _RQ68:_Modelo_de_datos_para_multificaci%C3%B3n
 * 
 * No todas las casas de apuestas para todos los países. Por defecto se
 * mostrarán todas las casas de apuestas. La configuración se hará por
 * agrupaciones de países. Para un paí podremos definir las casas de apuestas a
 * mostrar, en caso de que estén definidas no serán todas. Ejemplo: - Uganda, no
 * la tenemos en la base de datos configurada. Mostramos todas las casas de
 * apuestas. - España
 * 
 * The bookmaker set could be in blank, it defines all the bookmakers have
 * authorization
 */
@SuppressWarnings("serial")
@Document
public class CfgBookmakerAuthorization extends AbstractI18nTableActivable {

	/** The bookmakers. */

	@DBRef
	private Set<CfgBookmaker> bookmakers;

	/** The super entity agrupation. */
	@NotNull
	@Valid
	@DBRef
	private CfgRegion region;

	/**
	 * Instantiates a new cfg bookmaker authorization.
	 */
	public CfgBookmakerAuthorization() {
		super();
	}

	/**
	 * Instantiates a new cfg bookmaker authorization.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgBookmakerAuthorization(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg bookmaker authorization.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgBookmakerAuthorization(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * Adds the bookmakers.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 */
	public void addBookmakers(CfgBookmaker bookmaker) {
		getBookmakers().add(bookmaker);
	}

	/**
	 * Gets the bookmakers.
	 * 
	 * @return the bookmakers
	 */
	public Set<CfgBookmaker> getBookmakers() {
		if (bookmakers == null) {
			bookmakers = new HashSet<CfgBookmaker>();
		}
		return bookmakers;
	}

	/**
	 * Gets the super entity agrupation.
	 * 
	 * @return the super entity agrupation
	 */


	/**
	 * Sets the bookmakers.
	 * 
	 * @param pBookmakers
	 *            the new bookmakers
	 */
	public void setBookmakers(Set<CfgBookmaker> pBookmakers) {
		bookmakers = pBookmakers;
	}

	public CfgRegion getRegion() {
		return region;
	}

	public void setRegion(CfgRegion region) {
		this.region = region;
	}


}
