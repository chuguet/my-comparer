/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.url.core;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.synchro.reader.url.core.bean.RemoteFileBean;
import com.comparadorad.bet.comparer.synchro.reader.url.core.bean.UriParameterBean;

/**
 * The Enum StrategyType.
 */
public enum StrategyType {

	/** The BETFRED. */
	BETFRED(CfgBookmakerId.BETFRED_COM_ID.nameId()),
	/** The GENERIC. */
	GENERIC(),

	/** The PINNACLE. */
	PINNACLE(CfgBookmakerId.PINNACLESPORTS_COM_ID.nameId()),

	/** The BLUESQUARE. */
	BLUESQUARE(CfgBookmakerId.BLUESQUARE_COM_ID.nameId()),

	/** The BETREDKINGS. */
	BETREDKINGS(CfgBookmakerId.BETREDKINGS_ID.nameId()),

	/** The BETGUN. */
	BETGUN(CfgBookmakerId.BETGUN_COM_ID.nameId()),

	/** The INTERWETTEN. */
	INTERWETTEN(CfgBookmakerId.INTERWETTEN_COM_ID.nameId()),

	/** The BOOKMAKER. */
	BOOKMAKER_EU(CfgBookmakerId.BOOKMAKER_EU_ID.nameId()),

	/** The BETDS i_ co m_ id. */
	BETDSI_COM_ID(CfgBookmakerId.BETDSI_COM_ID.nameId()),

	/** The BETCRI s_ co m_ id. */
	BETCRIS_COM_ID(CfgBookmakerId.BETCRIS_COM_ID.nameId()),

	UNIBET_COM_ID(CfgBookmakerId.UNIBET_COM_ID.nameId()),

	LUCKIA_ID(CfgBookmakerId.LUCKIA.nameId()),
	
	INTERTOPS(CfgBookmakerId.INTERTOPS_EU_ID.nameId());

	/** The files. */
	private List<RemoteFileBean> files;

	/** The bookmaker id. */
	private String nameId;

	/** The uri parameter. */
	private List<UriParameterBean> uriParameters;

	/**
	 * Instantiates a new strategy type.
	 */
	private StrategyType() {

	}

	/**
	 * Instantiates a new strategy type.
	 * 
	 * @param nameId
	 *            the name id
	 */
	private StrategyType(String nameId) {
		this.nameId = nameId;
	}

	/**
	 * Adds the.
	 * 
	 * @param remoteFileBean
	 *            the remote file bean
	 * @return the boolean
	 */
	public Boolean add(RemoteFileBean remoteFileBean) {
		return getFiles().add(remoteFileBean);
	}

	/**
	 * Adds the.
	 * 
	 * @param uriParameterBean
	 *            the uri parameter bean
	 * @return the boolean
	 */
	public Boolean add(UriParameterBean uriParameterBean) {
		return getUriParameter().add(uriParameterBean);
	}

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id
	 */
	public final String getBookmakerId() {
		return nameId;
	}

	/**
	 * Gets the files.
	 * 
	 * @return the files
	 */
	public final List<RemoteFileBean> getFiles() {
		return files;
	}

	/**
	 * Gets the uri parameter.
	 * 
	 * @return the uri parameter
	 */
	public final List<UriParameterBean> getUriParameter() {
		if (uriParameters == null) {
			uriParameters = new ArrayList<UriParameterBean>();
		}
		return uriParameters;
	}

	/**
	 * Sets the bookmaker id.
	 * 
	 * @param nameId
	 *            the new bookmaker id
	 */
	public final void setBookmakerId(String nameId) {
		this.nameId = nameId;
	}

	/**
	 * Sets the files.
	 * 
	 * @param files
	 *            the new files
	 */
	public final void setFiles(List<RemoteFileBean> files) {
		this.files = files;
	}

	/**
	 * Sets the uri parameter.
	 * 
	 * @param uriParameter
	 *            the new uri parameter
	 */
	public final void setUriParameter(List<UriParameterBean> uriParameter) {
		this.uriParameters = uriParameter;
	}

}
