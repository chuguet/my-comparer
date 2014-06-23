/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.UrlFilterWord;
import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.IDocumentField;
import com.comparadorad.bet.comparer.model.core.bean.annotation.SetWithAtLeastOneElement;

/**
 * The Class BookmakerConfiguration.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CfgBookmakerConfiguration extends AbstractId implements
		IDocumentField {

	/** The black list. */
	@Field
	private Set<String> blackList;

	/** The bookmaker master word config. */
	private CfgBookmakerMasterWordConfig bookmakerMasterWordConfig;

	/**
	 * The bookmaker url.
	 */
	@Field
	@SetWithAtLeastOneElement
	private Set<CfgBookmakerDataUrl> cfgBookmakerDataUrl;

	/** The bookmaker web url. */
	@Field
	@SetWithAtLeastOneElement
	private Set<CfgBookmakerWebUrl> cfgBookmakerWebUrl;

	/**
	 * The master.
	 */
	@DBRef
	private Set<CfgMaster> cfgMaster;

	/** The configuration resources. */
	@Field
	private Set<CfgBookmakerConfigurationResource> configurationResources;

	/** Lista de palabras para realizar un filtro en UrlMaker. */
	@Field
	private Set<UrlFilterWord> filterMakeUrl;

	/** The id afiliado. */
	@Field
	private String idAfiliado;

	/**
	 * The minimum time update.
	 */
	@Field
	private Long minimumTimeUpdate;

	/** The minutes for delete bets. */
	@Field
	private Long minutesForDeleteBets;
	
	/**
	 * The name.
	 */
	@Field
	private String name;
	/**
	 * The password.
	 */
	@Field
	private String password;

	/** The priority moda. */
	@Field
	private Integer priorityModa;

	/** The reboot url maker. */
	@Field
	private Long rebootUrlMaker;
	
	/** The reboot time. */
	@Field
	private Long rebootTime;

	/** The cacheable. */
	@Field
	private String timeZone;

	/**
	 * The user.
	 */
	@Field
	private String user;	

	/**
	 * Instantiates a new bookmaker configuration.
	 */
	public CfgBookmakerConfiguration() {
		super();
	}

	/**
	 * Instantiates a new bookmaker configuration.
	 * 
	 * @param name
	 *            the name
	 */
	public CfgBookmakerConfiguration(String name) {
		super();
		this.name = name;
	}

	/**
	 * Adds the.
	 * 
	 * @param urlFilterWord
	 *            the url filter word
	 * @return the boolean
	 */
	public Boolean add(UrlFilterWord urlFilterWord) {
		return getFilterMakeUrl().add(urlFilterWord);
	}
	
	

	/**
	 * Gets the reboot time.
	 *
	 * @return the reboot time
	 */
	public Long getRebootTime() {
		return rebootTime;
	}

	/**
	 * Sets the reboot time.
	 *
	 * @param rebootTime the new reboot time
	 */
	public void setRebootTime(Long rebootTime) {
		this.rebootTime = rebootTime;
	}

	/**
	 * Adds the.
	 * 
	 * @param word
	 *            the word
	 * @return true, if successful
	 */
	public boolean addBlackListWord(String word) {
		if (blackList == null) {
			blackList = new HashSet<String>();
		}
		return blackList.add(word);
	}

	/**
	 * Adds the.
	 * 
	 * @param dataUrl
	 *            the data url
	 * @return true, if successful
	 */
	public boolean addBookmakerDataUrl(CfgBookmakerDataUrl dataUrl) {
		if (cfgBookmakerDataUrl == null) {
			cfgBookmakerDataUrl = new HashSet<CfgBookmakerDataUrl>();
		}
		return cfgBookmakerDataUrl.add(dataUrl);
	}

	/**
	 * Adds the.
	 * 
	 * @param webUrl
	 *            the web url
	 * @return true, if successful
	 */
	public boolean addBookmakerWebUrl(CfgBookmakerWebUrl webUrl) {
		if (cfgBookmakerWebUrl == null) {
			cfgBookmakerWebUrl = new HashSet<CfgBookmakerWebUrl>();
		}
		return cfgBookmakerWebUrl.add(webUrl);
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
		if (!(object instanceof CfgBookmakerConfiguration)) {
			return false;
		}
		final CfgBookmakerConfiguration rhs = (CfgBookmakerConfiguration) object;
		return new EqualsBuilder().appendSuper(super.equals(object))
				.append(this.minimumTimeUpdate, rhs.minimumTimeUpdate)
				.append(this.name, rhs.name).append(this.user, rhs.user)
				.append(this.password, rhs.password)
				.append(this.cfgBookmakerDataUrl, rhs.cfgBookmakerDataUrl)
				.append(this.cfgBookmakerWebUrl, rhs.cfgBookmakerWebUrl)
				.append(this.cfgMaster, rhs.cfgMaster).isEquals();
	}

	/**
	 * Gets the black list.
	 * 
	 * @return the black list
	 */
	public Set<String> getBlackList() {
		return blackList;
	}

	/**
	 * Gets the bookmaker master word config.
	 * 
	 * @return the bookmaker master word config
	 */
	public CfgBookmakerMasterWordConfig getBookmakerMasterWordConfig() {
		if (bookmakerMasterWordConfig == null) {
			bookmakerMasterWordConfig = new CfgBookmakerMasterWordConfig();
		}
		return bookmakerMasterWordConfig;
	}

	/**
	 * Gets the bookmaker url.
	 * 
	 * @return the bookmaker url
	 */
	public Set<CfgBookmakerDataUrl> getBookmakerUrl() {
		return cfgBookmakerDataUrl;
	}

	/**
	 * Gets the bookmaker url.
	 * 
	 * @return the bookmaker url
	 */
	public Set<CfgBookmakerWebUrl> getBookmakerWebUrl() {
		return cfgBookmakerWebUrl;
	}

	/**
	 * Gets the configuration resources.
	 * 
	 * @return the configuration resources
	 */
	public Set<CfgBookmakerConfigurationResource> getConfigurationResources() {
		return configurationResources;
	}

	/**
	 * Gets the filter make url.
	 * 
	 * @return the filter make url
	 */
	public Set<UrlFilterWord> getFilterMakeUrl() {
		if (filterMakeUrl == null) {
			filterMakeUrl = new HashSet<UrlFilterWord>();
		}
		return filterMakeUrl;
	}

	/**
	 * Gets the id afiliado.
	 * 
	 * @return the id afiliado
	 */
	public String getIdAfiliado() {
		return idAfiliado;
	}

	/**
	 * Gets the master.
	 * 
	 * @return the master
	 */
	public Set<CfgMaster> getMaster() {
		return cfgMaster;
	}

	/**
	 * Gets the minimum time update.
	 * 
	 * @return the minimum time update
	 */
	public Long getMinimumTimeUpdate() {
		return minimumTimeUpdate;
	}

	/**
	 * Gets the minutes for delete bets.
	 * 
	 * @return the minutes for delete bets
	 */
	public Long getMinutesForDeleteBets() {
		return minutesForDeleteBets;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the priority moda.
	 * 
	 * @return the priority moda
	 */
	public Integer getPriorityModa() {
		return priorityModa;
	}

	/**
	 * Gets the reboot url maker.
	 *
	 * @return the reboot url maker
	 */
	public Long getRebootUrlMaker() {
		return rebootUrlMaker;
	}

	/**
	 * Gets the time zone.
	 * 
	 * @return the time zone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(499603411, 980712527)
				.appendSuper(super.hashCode()).append(this.minimumTimeUpdate)
				.append(this.name).append(this.user).append(this.password)
				.append(this.cfgBookmakerDataUrl)
				.append(this.cfgBookmakerWebUrl).append(this.cfgMaster)
				.toHashCode();
	}

	/**
	 * Sets the black list.
	 * 
	 * @param blackList
	 *            the new black list
	 */
	public void setBlackList(Set<String> blackList) {
		this.blackList = blackList;
	}

	/**
	 * Sets the bookmaker url.
	 * 
	 * @param pCfgBookmakerDataUrl
	 *            the new bookmaker url
	 */
	public void setBookmakerUrl(
			final Set<CfgBookmakerDataUrl> pCfgBookmakerDataUrl) {
		cfgBookmakerDataUrl = pCfgBookmakerDataUrl;
	}

	/**
	 * Sets the configuration resources.
	 * 
	 * @param pConfigurationResources
	 *            the new configuration resources
	 */
	public void setConfigurationResources(
			Set<CfgBookmakerConfigurationResource> pConfigurationResources) {
		configurationResources = pConfigurationResources;
	}

	/**
	 * Sets the could create master word.
	 * 
	 * @param pCouldCreateMasterWord
	 *            the could create master word
	 * @param pCreationPriority
	 *            the creation priority
	 */
	public void setCouldCreateMasterWord(Boolean pCouldCreateMasterWord,
			Integer pCreationPriority) {
		bookmakerMasterWordConfig = new CfgBookmakerMasterWordConfig(
				pCouldCreateMasterWord, pCreationPriority);
	}

	/**
	 * Sets the filter make url.
	 * 
	 * @param filterMakeUrl
	 *            the new filter make url
	 */
	public void setFilterMakeUrl(Set<UrlFilterWord> filterMakeUrl) {
		this.filterMakeUrl = filterMakeUrl;
	}

	/**
	 * Sets the id afiliado.
	 * 
	 * @param idAfiliado
	 *            the new id afiliado
	 */
	public void setIdAfiliado(String idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	/**
	 * Sets the master.
	 * 
	 * @param pCfgMaster
	 *            the new master
	 */
	public void setMaster(final Set<CfgMaster> pCfgMaster) {
		cfgMaster = pCfgMaster;
	}

	/**
	 * Sets the minimum time update.
	 * 
	 * @param pMinimumTimeUpdate
	 *            the new minimum time update
	 */
	public void setMinimumTimeUpdate(final Long pMinimumTimeUpdate) {
		minimumTimeUpdate = pMinimumTimeUpdate;
	}

	/**
	 * Sets the minutes for delete bets.
	 * 
	 * @param minutesForDeleteBets
	 *            the new minutes for delete bets
	 */
	public void setMinutesForDeleteBets(Long minutesForDeleteBets) {
		this.minutesForDeleteBets = minutesForDeleteBets;
	}

	/**
	 * Sets the name.
	 * 
	 * @param pName
	 *            the new name
	 */
	public void setName(final String pName) {
		name = pName;
	}

	/**
	 * Sets the password.
	 * 
	 * @param pPassword
	 *            the new password
	 */
	public void setPassword(final String pPassword) {
		password = pPassword;
	}

	/**
	 * Sets the priority moda.
	 * 
	 * @param priorityModa
	 *            the new priority moda
	 */
	public void setPriorityModa(Integer priorityModa) {
		this.priorityModa = priorityModa;
	}

	/**
	 * Sets the reboot url maker.
	 *
	 * @param rebootUrlMaker the new reboot url maker
	 */
	public void setRebootUrlMaker(Long rebootUrlMaker) {
		this.rebootUrlMaker = rebootUrlMaker;
	}

	/**
	 * Sets the time zone.
	 * 
	 * @param timeZone
	 *            the new time zone
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * Sets the user.
	 * 
	 * @param pUser
	 *            the new user
	 */
	public void setUser(final String pUser) {
		user = pUser;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * {@inheritDoc}
	 */ 
	@Override
	public String toString() {
		return "CfgBookmakerConfiguration [blackList=" + blackList
				+ ", bookmakerMasterWordConfig=" + bookmakerMasterWordConfig
				+ ", cfgBookmakerDataUrl=" + cfgBookmakerDataUrl
				+ ", cfgBookmakerWebUrl=" + cfgBookmakerWebUrl + ", cfgMaster="
				+ cfgMaster + ", configurationResources="
				+ configurationResources + ", filterMakeUrl=" + filterMakeUrl
				+ ", idAfiliado=" + idAfiliado + ", minimumTimeUpdate="
				+ minimumTimeUpdate + ", minutesForDeleteBets="
				+ minutesForDeleteBets + ", name=" + name + ", password="
				+ password + ", priorityModa=" + priorityModa + ", timeZone="
				+ timeZone + ", user=" + user + "]";
	}
	
	

}