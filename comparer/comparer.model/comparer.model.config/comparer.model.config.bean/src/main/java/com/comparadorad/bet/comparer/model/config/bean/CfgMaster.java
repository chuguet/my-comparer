/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractHistoricChangeActivable;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.bean.INameIdEnum;
import com.comparadorad.bet.comparer.model.core.bean.annotation.CollectionWithAtLeastOneElement;

/**
 * The Class Master.
 * 
 * @author imayoral
 * @version 1.0
 */
@Document
public class CfgMaster extends AbstractHistoricChangeActivable implements
		IDocument {

	/** The lista algoritmos. */
	List<CfgResolverAlgorithm> listaAlgoritmos = new ArrayList<CfgResolverAlgorithm>();

	/**
	 * The time to process. El tiempo minimo que ha de pasar para poder tratar
	 * un error
	 */
	long timeToProcess;

	/** The algorithm precission. */
	Double algorithmPrecission;

	/** The competition precission percent. */
	String competitionPrecissionPercent;

	/**
	 * Gets the competition precission percent.
	 * 
	 * @return the competition precission percent
	 */
	public String getCompetitionPrecissionPercent() {
		return competitionPrecissionPercent;
	}

	/**
	 * Sets the competition precission percent.
	 * 
	 * @param competitionPrecissionPercent
	 *            the new competition precission percent
	 */
	public void setCompetitionPrecissionPercent(
			String competitionPrecissionPercent) {
		this.competitionPrecissionPercent = competitionPrecissionPercent;
	}

	/**
	 * Gets the algorithm precission.
	 * 
	 * @return the algorithm precission
	 */
	public Double getAlgorithmPrecission() {
		return algorithmPrecission;
	}

	/**
	 * Sets the algorithm precission.
	 * 
	 * @param algorithmPrecission
	 *            the new algorithm precission
	 */
	public void setAlgorithmPrecission(Double algorithmPrecission) {
		this.algorithmPrecission = algorithmPrecission;
	}

	/**
	 * Gets the time to process.
	 * 
	 * @return the time to process
	 */
	public long getTimeToProcess() {
		return timeToProcess;
	}

	/**
	 * Sets the time to process.
	 * 
	 * @param timeToProcess
	 *            the new time to process
	 */
	public void setTimeToProcess(long timeToProcess) {
		this.timeToProcess = timeToProcess;
	}

	/**
	 * Gets the lista algoritmos.
	 * 
	 * @return the lista algoritmos
	 */
	public List<CfgResolverAlgorithm> getListaAlgoritmos() {
		if( listaAlgoritmos == null ){
			listaAlgoritmos = new ArrayList<CfgResolverAlgorithm>();
		}
		return listaAlgoritmos;
	}

	/**
	 * Sets the lista algoritmos.
	 * 
	 * @param listaAlgoritmos
	 *            the new lista algoritmos
	 */
	public void setListaAlgoritmos(List<CfgResolverAlgorithm> listaAlgoritmos) {
		this.listaAlgoritmos = listaAlgoritmos;
	}

	/**
	 * The Enum CfgMasterId.
	 */
	public enum CfgMasterId implements INameIdEnum {

		/** The BE t_ type. */
		BET_TYPE(CfgBetType.class.getSimpleName()), /** The COMPETITION. */
		COMPETITION(CfgCompetition.class.getSimpleName()), /** The PARTICIPANT. */
		PARTICIPANT(CfgParticipant.class.getSimpleName()), /** The REGION. */
		REGION("REGION"),
		/** The SPORT. */
		SPORT(CfgSport.class.getSimpleName()), ;

		/** The object id. */
		private final String nameId;

		/**
		 * Instantiates a new cfg bookmaker id.
		 * 
		 * @param nameId
		 *            the name id
		 */
		CfgMasterId(String nameId) {
			this.nameId = nameId;
		}

		/**
		 * Name id.
		 * 
		 * @return the string {@inheritDoc}
		 */

		@Override
		public String nameId() {
			return nameId;
		}
	}

	/**
	 * The Class StrikeConfig.
	 */
	/**
	 * @author jgpelaez
	 * 
	 */
	public static class StrikeConfig {

		/**
		 * The customized minimum strike. Este campo indicará para los casos
		 * "customized" que valor mínimo debemos tener. Estos casos son por
		 * ejemplo en los participantes, como tendremos la competición ya estará
		 * mucho más acotada la búsqueda y por lo tanto el porcentaje puede ser
		 * mucho meno
		 */
		@Field
		@Max(value = 1)
		private BigDecimal customizedMinimumStrike;

		/**
		 * The minimum strike. Indicates the minimum strike in the algorith to
		 * declarate as same record
		 */
		@Field
		@NotNull
		@Max(value = 1)
		private BigDecimal minimumStrike;

		/** The minimum strike normalized. */
		@Field
		@Max(value = 1)
		private BigDecimal minimumStrikeNormalized;

		/** The number of char. */
		@Field
		private Integer numberOfChar;

		/**
		 * Instantiates a new strike config.
		 */
		public StrikeConfig() {
			super();

		}

		/**
		 * Instantiates a new strike config.
		 * 
		 * @param pNumberOfChar
		 *            the number of char
		 * @param pMinimumStrike
		 *            the minimum strike
		 * @param pMinimumStrikeNormalized
		 *            the minimum strike normalized
		 */
		public StrikeConfig(Integer pNumberOfChar, BigDecimal pMinimumStrike,
				BigDecimal pMinimumStrikeNormalized) {
			super();
			numberOfChar = pNumberOfChar;
			minimumStrike = pMinimumStrike;
			minimumStrikeNormalized = pMinimumStrikeNormalized;
		}

		/**
		 * Instantiates a new strike config.
		 * 
		 * @param pNumberOfChar
		 *            the number of char
		 * @param pMinimumStrike
		 *            the minimum strike
		 * @param pMinimumStrikeNormalized
		 *            the minimum strike normalized
		 * @param pCustomizedMinimumStrike
		 *            the customized minimum strike
		 */
		public StrikeConfig(Integer pNumberOfChar, String pMinimumStrike,
				String pMinimumStrikeNormalized, String pCustomizedMinimumStrike) {
			super();
			numberOfChar = pNumberOfChar;
			minimumStrike = new BigDecimal(pMinimumStrike);
			minimumStrikeNormalized = new BigDecimal(pMinimumStrikeNormalized);
			customizedMinimumStrike = new BigDecimal(pCustomizedMinimumStrike);
		}

		/**
		 * Gets the customized minimum strike.
		 * 
		 * @return the customized minimum strike
		 */
		public BigDecimal getCustomizedMinimumStrike() {
			return customizedMinimumStrike;
		}

		/**
		 * Gets the minimum strike.
		 * 
		 * @return the minimum strike
		 */
		public BigDecimal getMinimumStrike() {
			return minimumStrike;
		}

		/**
		 * Gets the minimum strike normalized.
		 * 
		 * @return the minimum strike normalized
		 */
		public BigDecimal getMinimumStrikeNormalized() {
			return minimumStrikeNormalized;
		}

		/**
		 * Gets the number of char.
		 * 
		 * @return the number of char
		 */
		public Integer getNumberOfChar() {
			return numberOfChar;
		}

		/**
		 * Sets the customized minimum strike.
		 * 
		 * @param pCustomizedMinimumStrike
		 *            the new customized minimum strike
		 */
		public void setCustomizedMinimumStrike(
				BigDecimal pCustomizedMinimumStrike) {
			customizedMinimumStrike = pCustomizedMinimumStrike;
		}

		/**
		 * Sets the minimum strike.
		 * 
		 * @param pMinimumStrike
		 *            the new minimum strike
		 */
		public void setMinimumStrike(BigDecimal pMinimumStrike) {
			minimumStrike = pMinimumStrike;
		}

		/**
		 * Sets the minimum strike normalized.
		 * 
		 * @param pMinimumStrikeNormalized
		 *            the new minimum strike normalized
		 */
		public void setMinimumStrikeNormalized(
				BigDecimal pMinimumStrikeNormalized) {
			minimumStrikeNormalized = pMinimumStrikeNormalized;
		}

		/**
		 * Sets the number of char.
		 * 
		 * @param pNumberOfChar
		 *            the new number of char
		 */
		public void setNumberOfChar(Integer pNumberOfChar) {
			numberOfChar = pNumberOfChar;
		}

		/** {@inheritDoc} */ 
		@Override
		public String toString() {
			return "StrikeConfig [customizedMinimumStrike="
					+ customizedMinimumStrike + ", minimumStrike="
					+ minimumStrike + ", minimumStrikeNormalized="
					+ minimumStrikeNormalized + ", numberOfChar="
					+ numberOfChar + "]";
		}
		
		
	}

	/** The strike config list. */
	@Field
	@CollectionWithAtLeastOneElement
	@Valid
	private List<StrikeConfig> strikeConfigList;

	/**
	 * Instantiates a new cfg master.
	 */
	public CfgMaster() {
		super();

	}

	/**
	 * Instantiates a new cfg master.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgMaster(BigInteger pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg master.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgMaster(String pObjectId) {
		super(pObjectId);

	}
	
	/**
	 * Adds the.
	 *
	 * @param cfgResolverAlgorithm the cfg resolver algorithm
	 * @return true, if successful
	 */
	public boolean add(CfgResolverAlgorithm cfgResolverAlgorithm){
		return getListaAlgoritmos().add(cfgResolverAlgorithm);
	}

	/**
	 * Adds the.
	 * 
	 * @param pE
	 *            the p e
	 * @return true, if successful
	 */
	public boolean add(StrikeConfig pE) {
		return getStrikeConfigList().add(pE);
	}

	/**
	 * Gets the name id.
	 * 
	 * @return the name id {@inheritDoc}
	 */
	@Override
	@NotNull
	public String getNameId() {
		return super.getNameId();
	}

	/**
	 * Gets the strike config.
	 * 
	 * @param pNumberOfChar
	 *            the number of char
	 * @return the strike config
	 */
	public StrikeConfig getStrikeConfig(Integer pNumberOfChar) {
		StrikeConfig result = null;
		for (StrikeConfig strikeConfig : strikeConfigList) {
			if (strikeConfig.getNumberOfChar() == null) {
				if (result == null) {
					result = strikeConfig;
				}
			} else if (strikeConfig.getNumberOfChar().intValue() >= pNumberOfChar) {
				if (result == null) {
					result = strikeConfig;
				} else if (result.getNumberOfChar() == null
						|| result.getNumberOfChar() > strikeConfig
								.getNumberOfChar()) {
					result = strikeConfig;
				}
			}
		}
		return result;
	}

	/**
	 * Gets the strike config.
	 * 
	 * @param word
	 *            the word
	 * @return the strike config
	 */
	public StrikeConfig getStrikeConfig(String word) {
		return getStrikeConfig(word.length());
	}

	/**
	 * Gets the strike config list.
	 * 
	 * @return the strike config list
	 */
	public List<StrikeConfig> getStrikeConfigList() {
		if (strikeConfigList == null) {
			strikeConfigList = new ArrayList<CfgMaster.StrikeConfig>();
		}
		return strikeConfigList;
	}

	/**
	 * Sets the strike config list.
	 * 
	 * @param pStrikeConfigList
	 *            the new strike config list
	 */
	public void setStrikeConfigList(List<StrikeConfig> pStrikeConfigList) {
		strikeConfigList = pStrikeConfigList;
	}

	/** {@inheritDoc} */ 
	@Override
	public String toString() {
		return "CfgMaster [listaAlgoritmos=" + listaAlgoritmos
				+ ", timeToProcess=" + timeToProcess + ", algorithmPrecission="
				+ algorithmPrecission + ", competitionPrecissionPercent="
				+ competitionPrecissionPercent + ", strikeConfigList="
				+ strikeConfigList + "]";
	}
	
	

}