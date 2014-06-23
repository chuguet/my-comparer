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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;

/**
 * The Class Competition.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
@Document
public class CfgCompetition extends AbstractI18nTableActivable implements
		IToolbarConfigurable {

	/** The competition events. */
	@Field
	private Set<CfgCompetitionEvent> competitionEvents;

	/**
	 * The end date.
	 */
	@Field
	// @CorrectCoreDate
	private CoreDate endDate;

	/** The order. */
	@Field
	private Integer order;

	/**
	 * The participant.
	 */
	// @NotNull
	private Set<CfgParticipant> participant;

	/** The participant names. */
	@Field
	private Set<String> participantNames;

	/** The region. */
	@DBRef
	@NotNull
	@Valid
	private CfgRegion region;

	/** The resource. */
	@Field
	private CfgResource resource;

	/** The resources. */
	@Field
	private List<CfgCompetitionResource> resources;

	/**
	 * The sport.
	 */
	@DBRef
	@NotNull
	@Valid
	private CfgSport sport;

	/**
	 * The start date.
	 */
	@Field
	// @CorrectCoreDate
	private CoreDate startDate;

	/**
	 * Instantiates a new cfg competition.
	 */
	public CfgCompetition() {
		super();

	}

	/**
	 * Instantiates a new cfg competition.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgCompetition(BigInteger pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg competition.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgCompetition(String pObjectId) {
		super(pObjectId);

	}

	/**
	 * Adds the.
	 * 
	 * @param competitionResource
	 *            the competition resource
	 */
	public void add(CfgCompetitionResource competitionResource) {
		if (resources == null) {
			resources = new ArrayList<CfgCompetitionResource>();
		}
		resources.add(competitionResource);
	}

	/**
	 * Adds the competition events.
	 * 
	 * @param pCompetitionEvent
	 *            the competition event
	 */
	public void addCompetitionEvent(CfgCompetitionEvent pCompetitionEvent) {
		if (competitionEvents == null) {
			this.competitionEvents = new HashSet<CfgCompetitionEvent>();
		}
		competitionEvents.add(pCompetitionEvent);
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
		if (!(object instanceof CfgCompetition)) {
			return false;
		}
		final CfgCompetition rhs = (CfgCompetition) object;
		return new EqualsBuilder().appendSuper(super.equals(object))
				.append(this.startDate, rhs.startDate)
				.append(super.getI18n(), rhs.getI18n())
				.append(this.sport, rhs.sport)
				.append(this.endDate, rhs.endDate)
				.append(this.participant, rhs.participant).isEquals();
	}

	/**
	 * Gets the competition events.
	 * 
	 * @return the competition events
	 */
	public Set<CfgCompetitionEvent> getCompetitionEvents() {
		return competitionEvents;
	}

	/**
	 * Gets the end date.
	 * 
	 * @return the end date
	 */
	public CoreDate getEndDate() {
		return endDate;
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
	 * Gets the participant.
	 * 
	 * @return the participant
	 */
	public Set<CfgParticipant> getParticipant() {
		return participant;
	}

	/**
	 * Gets the participant names.
	 * 
	 * @return the participant names
	 */
	public Set<String> getParticipantNames() {
		return participantNames;
	}

	/**
	 * Gets the region.
	 * 
	 * @return the region
	 */
	public CfgRegion getRegion() {
		return region;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource {@inheritDoc}
	 */
	@Override
	public CfgResource getResource() {
		return resource;
	}

	/**
	 * Gets the resources.
	 * 
	 * @return the resources
	 */
	public List<CfgCompetitionResource> getResources() {
		return resources;
	}

	/**
	 * Gets the sport.
	 * 
	 * @return the sport
	 */
	public CfgSport getSport() {
		return sport;
	}

	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public CoreDate getStartDate() {
		return startDate;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1328253151, -1586409917)
				.appendSuper(super.hashCode()).append(this.startDate)
				.append(this.getI18n()).append(this.sport).append(this.endDate)
				.append(this.participant).toHashCode();
	}

	/**
	 * Sets the competition events.
	 * 
	 * @param pCompetitionEvents
	 *            the new competition events
	 */
	public void setCompetitionEvents(Set<CfgCompetitionEvent> pCompetitionEvents) {
		competitionEvents = pCompetitionEvents;
	}

	/**
	 * Sets the end date.
	 * 
	 * @param pEndDate
	 *            the new end date
	 */
	public void setEndDate(final CoreDate pEndDate) {
		endDate = pEndDate;
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
	 * Sets the participant.
	 * 
	 * @param pCfgParticipant
	 *            the new participant
	 */
	public void setParticipant(final Set<CfgParticipant> pCfgParticipant) {
		participant = pCfgParticipant;
	}

	/**
	 * Sets the participant names.
	 * 
	 * @param participantNames
	 *            the new participant names
	 */
	public void setParticipantNames(Set<String> participantNames) {
		this.participantNames = participantNames;
	}

	/**
	 * Sets the region.
	 * 
	 * @param region
	 *            the new region
	 */
	public void setRegion(CfgRegion region) {
		this.region = region;
	}

	/**
	 * Sets the resource.
	 * 
	 * @param pResource
	 *            the new resource
	 */
	public void setResource(CfgResource pResource) {
		resource = pResource;
	}

	/**
	 * Sets the resources.
	 * 
	 * @param pResources
	 *            the new resources
	 */
	public void setResources(List<CfgCompetitionResource> pResources) {
		resources = pResources;
	}

	/**
	 * Sets the sport.
	 * 
	 * @param pCfgSport
	 *            the new sport
	 */
	public void setSport(final CfgSport pCfgSport) {
		sport = pCfgSport;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param pStartDate
	 *            the new start date
	 */
	public void setStartDate(final CoreDate pStartDate) {
		startDate = pStartDate;
	}

}