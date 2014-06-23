/**
 *
Criteria. * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchMapReduce;
import com.comparadorad.bet.comparer.model.bet.mapreduce.beans.NextEventMapReduce;
import com.comparadorad.bet.comparer.model.bet.repository.exception.IsolatedSaveException;
import com.comparadorad.bet.comparer.model.bet.repository.updatelog.UpdateLog;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepository;
import com.comparadorad.bet.comparer.model.core.repository.exception.ObjectWithRecursiveDataException;
import com.comparadorad.bet.comparer.model.core.repository.exception.ValidationObjectException;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class RtMatchRepositoryCustomImpl. Esta clase hace las querys necesarias
 * a nivel de RtMatch, hay que tener en cuenta que para nuevos métodos hay que
 * añadir el filtro OBLIGATORIO (a no ser que queramos buscar fuera de lo
 * normal) que el coreActiveElement del rtMatch este a true
 * 
 * @param <T>
 *            the generic type
 */
class RtMatchRepositoryCustomImpl<T extends RtMatch> extends
		AbstractRepository<T> implements RtMatchRepositoryCustom<T> {

	@Inject
	private UpdateLog updateLog;
	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/** The validator. */
	@Inject
	@Resource(name = "getLocalValidatorFactoryBeanConfig")
	private Validator validator;

	 /** The Constant LOG. */
	 private static final Log LOG = LogFactory.getLog(RtMatchRepositoryCustomImpl.class);

	/**
	 * The Enum Fields.
	 */
	public enum Fields {

		/** The Bet_ atrritute. */
		Bet_Atrritute("markets.bets.attribute"), /** The Bet_ bet odd. */
		Bet_BetOdd("markets.bets.betOdd"), /** The Bet_ bet odd_odd. */
		Bet_BetOdd_odd("markets.bets.betOdd.odds"),

		/** The Bet_ bookmaker. */
		Bet_Bookmaker("markets.bets.bookmaker"), /** The Bet_ hash key. */
		Bet_HashKey("markets.bets.hashKey"),
		/** The Bet_ participant. */
		Bet_Participant("markets.bets.participant"),
		/** The Bet_ participant_ cfg participant. */
		Bet_Participant_CfgParticipant(
				"markets.bets.participant.cfgParticipant"),
		/** The Bet_ web url. */
		Bet_WebURL("markets.bets.webUrl"),
		/** The Bet_ actualizate date. */
		Bet_ActualizateDate("markets.bets.actualizeDate"),
		/** The Core active element_ active. */
		CoreActiveElement_Active("coreActiveElement.active"),
		/** The Market_ bet type. */
		Market_BetType("markets.betType"),
		/** The Market_ cfg bet type event. */
		Market_CfgBetTypeEvent("markets.betTypeEvent.betTypeEvent"),
		/** The Market_ hash key. */
		Market_HashKey("markets.hashKey"),
		/** The Market_ web url. */
		Market_WebURL("markets.webUrl"),
		/** The Match id. */
		MatchId("matchId"),
		/** The Match id_ competition. */
		MatchId_Competition("matchId.competition"),
		/** The Match id_ competition event. */
		MatchId_CompetitionEvent("matchId.competitionEvent"),
		/** The Match id_ participants. */
		MatchId_Participants("matchId.participiants"),
		/** The Rt match_ hash key. */
		RtMatch_HashKey("hashKey"),
		/** The Rt match_ i18n. */
		RtMatch_HashKeys("hashKeys"),
		/** The Rt match_ i18n. */
		RtMatch_I18n("i18n"),
		/** The Rt match_ id. */
		RtMatch_Id("_id"),
		/** The Rt match_ streaming. */
		RtMatch_Streaming("streaming"),
		/** The Start date. */
		StartDate("matchId.startDate"),
		/** The Start date_ provider date. */
		StartDate_ProviderDate("matchId.startDate.providerDate"),
		/** The Start date_ zero gmt match date. */
		StartDate_ZeroGmtMatchDate("matchId.startDate.zeroGmtMatchDate"),
		/** The Start date_ zero gmt match time zone str. */
		StartDate_ZeroGmtMatchTimeZoneStr(
				"matchId.startDate.zeroGmtMatchTimeZoneStr");

		/** The name id. */
		private final String nameId;

		/**
		 * Instantiates a new adds the Fields.
		 * 
		 * @param nameId
		 *            the name id
		 */
		Fields(String nameId) {
			this.nameId = nameId;
		}

		/**
		 * Gets the name id.
		 * 
		 * @return the name id
		 */
		public String getNameId() {
			return nameId;
		}

	}

	/** The Constant COLLECTION_NAME. */
	private static final String COLLECTION_NAME = "rtMatch";

	/** The Constant LIMIT_MATCHS. */
	private static final int LIMIT_MATCHS = 8;

	/**
	 * Convert matchs to json.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the map {@inheritDoc}
	 */
	@Override
	public Map<String, byte[]> convertMatchsToJSON(List<RtMatch> matchs) {
		Map<String, byte[]> result = new HashMap<String, byte[]>();
		for (RtMatch match : matchs) {
			result.put(match.getObjectId().toString(), getMongoTemplate()
					.getConverter().convertToMongoType(match).toString()
					.getBytes());
		}
		return result;
	}

	/**
	 * Exists custom.
	 * 
	 * @param idMatch
	 *            the id match
	 * @return the boolean {@inheritDoc}
	 */
	@Override
	public Boolean existsCustom(String idMatch) {
		RtMatch auxMatch = new RtMatch();
		auxMatch.setObjectId(new BigInteger(idMatch));

		Criteria criteria = new Criteria().andOperator(Criteria.where("_id")
				.is(getConvertedId(auxMatch)).and("coreActiveElement.active")
				.is(true));

		Query query = new Query(criteria);

		return getMongoTemplate().count(query, RtMatch.class) != 0;
	}

	/**
	 * Find all limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<RtMatch> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<RtMatch> listResult = getMongoTemplate()
				.find(query, RtMatch.class);
		return listResult;
	}

	/**
	 * Find match.
	 * 
	 * @param objectId
	 *            the object id
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch findMatch(ObjectId objectId) {

		Query query = new Query(where("_id").is(objectId)
				.and("coreActiveElement.active").is(true));

		query.fields().include(Fields.RtMatch_I18n.nameId);
		query.fields().include(Fields.StartDate_ZeroGmtMatchDate.nameId);
		query.fields().include(Fields.MatchId_Competition.nameId);
		query.fields().include(Fields.Market_CfgBetTypeEvent.nameId);
		query.fields().include(Fields.Market_BetType.nameId);
		query.fields().include(Fields.Bet_BetOdd_odd.nameId);
		query.fields().include(Fields.Bet_Bookmaker.nameId);
		query.fields().include(Fields.Bet_Participant.nameId);
		query.fields().include(Fields.Bet_WebURL.nameId);

		RtMatch match = getMongoTemplate().findOne(query, RtMatch.class);

		return match;
	}

	/**
	 * Busca un partido activo.
	 * 
	 * @param betType
	 *            the bet type
	 * @param betTypeEvent
	 *            the bet type event
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch findActiveMatch(String betType, String betTypeEvent) {
		Date today = new Date();
		RtMatch result = null;
		Random generator = new Random();

		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("coreActiveElement.active").is(true)
				.and("markets.betType.$id").is(betType)
				.and("markets.betTypeEvent.betTypeEvent.$id").is(betTypeEvent));
		Query query = new Query(criteria);
		query.fields().include(Fields.RtMatch_Id.nameId);
		// query.fields().include(Fields.Market_BetType.nameId);
		// query.fields().include(Fields.Market_CfgBetTypeEvent.nameId);
		List<RtMatch> matchs = getMongoTemplate().find(query, RtMatch.class);

		// List<RtMatch> matchs = new ArrayList<RtMatch>();
		// for (RtMatch match : matchsQuery) {
		// if (containsMarket(match, betType, betTypeEvent)) {
		// matchs.add(match);
		// }
		// }

		if (!matchs.isEmpty()) {
			query = new Query(where("_id")
					.is(getConvertedId(matchs.get(generator.nextInt(matchs
							.size())))));
			query.fields().include(Fields.RtMatch_I18n.nameId);
			query.fields().include(Fields.StartDate_ZeroGmtMatchDate.nameId);
			query.fields().include(Fields.MatchId_Competition.nameId);
			query.fields().include(Fields.Market_CfgBetTypeEvent.nameId);
			query.fields().include(Fields.Market_BetType.nameId);
			query.fields().include(Fields.Bet_BetOdd_odd.nameId);
			query.fields().include(Fields.Bet_Bookmaker.nameId);
			query.fields().include(Fields.Bet_Participant.nameId);
			query.fields().include(Fields.Bet_WebURL.nameId);

			result = getMongoTemplate().findOne(query, RtMatch.class);
		}

		return result;
	}

	// private Boolean containsMarket(RtMatch match, String betType,
	// String betTypeEvent) {
	// Boolean result = Boolean.FALSE;
	// for (RtMarket market : match.getRtMarkets()) {
	// if (market.getBetType().getObjectId().toString().equals(betType)
	// && market.getBetTypeEvent().getBetTypeEvent().getObjectId()
	// .toString().equals(betTypeEvent)) {
	// result = Boolean.TRUE;
	// break;
	// }
	// }
	// return result;
	// }

	/**
	 * Find one custom.
	 * 
	 * @param id
	 *            the id
	 * @return the rt match
	 */
	@Override
	public RtMatch findOneCustom(String id) {
		Date today = new Date();
		RtMatch auxMatch = new RtMatch();
		auxMatch.setObjectId(new BigInteger(id));
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("_id").is(getConvertedId(auxMatch))
				.and("coreActiveElement.active").is(true));
		Query query = new Query(criteria);
		RtMatch match = getMongoTemplate().findOne(query, RtMatch.class);
		return match;
	}

	/**
	 * Finds only markets in RthMatch.
	 * 
	 * To help in MongoVUE to do the query: {
	 * "matchId.startDate.zeroGmtMatchDate" : { "$exists" : true , "$gte" : new
	 * ISODate("2013-11-13T11:00:13.092Z") } , "_id" : "660756959",
	 * "coreActiveElement.active" : true }
	 * 
	 * @param id
	 *            the id
	 * @return the set {@inheritDoc}
	 */
	public Set<RtMarket> findOneCustomMarkets(String id) {
		Date today = new Date();
		// La hora debería comenzar a las 00
		/*
		 * Calendar calendar = Calendar.getInstance();
		 * calendar.set(Calendar.HOUR_OF_DAY, 0); calendar.set(Calendar.MINUTE,
		 * 0); calendar.set(Calendar.SECOND, 0);
		 * calendar.set(Calendar.MILLISECOND, 0); Date today =
		 * calendar.getTime();
		 */

		RtMatch auxMatch = new RtMatch();
		auxMatch.setObjectId(new BigInteger(id));

		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("_id").is(getConvertedId(auxMatch))
				.and("coreActiveElement.active").is(true));
		Query query = new Query(criteria);
		/*
		 * query.fields().include("matchId.startDate.zeroGmtMatchDate");
		 * query.fields().include("_id");
		 * query.fields().include("coreActiveElement.active");
		 */
		query.fields().include("markets");

		RtMatch match = getMongoTemplate().findOne(query, RtMatch.class);
		if (match != null) {
			return match.getRtMarkets();
		}

		return new HashSet<RtMarket>();

	}

	/**
	 * 1).
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @param idBetTypeEvent
	 *            the id bet type event
	 * @return the rt match
	 */
	public RtMatch findMarketByBetTypeBetTypeEvent(String idMatch,
			String idBetType, String idBetTypeEvent) {
		Date today = new Date();
		RtMatch auxMatch = new RtMatch();
		auxMatch.setObjectId(new BigInteger(idMatch));

		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate")
				.exists(true)
				.gte(today)
				.and("_id")
				.is(getConvertedId(auxMatch))
				.and("coreActiveElement.active")
				.is(true)
				.andOperator(
						where("markets").elemMatch(
								where("betType.$id").is(idBetType).andOperator(
										where("betTypeEvent.betTypeEvent.$id")
												.is(idBetTypeEvent)))));

		Query query = new Query(criteria);
		query.fields().include(Fields.Market_CfgBetTypeEvent.nameId);
		query.fields().include(Fields.Market_BetType.nameId);

		query.fields().include(Fields.Bet_Atrritute.nameId);
		query.fields().include(Fields.Bet_BetOdd.nameId);
		query.fields().include(Fields.Bet_Bookmaker.nameId);
		query.fields().include(Fields.Bet_Participant.nameId);
		query.fields().include(Fields.Bet_WebURL.nameId);

		RtMatch rtMatch = getMongoTemplate().findOne(query, RtMatch.class);

		return rtMatch;
	}

	/**
	 * Clase que para los proximos eventos recibe la.
	 * 
	 * @param listResult
	 *            : lista de eventos recuperados de BD
	 * @param minimalNumberOfBookmakers
	 *            : número mínimo de casas de apuestas que debe de tener la
	 *            apuesta
	 * @return finalMatch: lista de eventos filtrados por el número mínimo de
	 *         casas de apuestas
	 */
	private List<RtMatch> filterMatchesByMinimalBookmaker(
			final List<RtMatch> listResult, final int minimalNumberOfBookmakers) {
		Boolean agregarMatch = false;
		int MAX_EVENTS = 8;
		// Si la apuesta de de ganador partido el numero minimo de apuestas para
		// esa apuesta sera el del numero de casas de apuestas que queramos
		// comparar por 2
		int minSizeBetsMatchWinner = minimalNumberOfBookmakers * 2;

		// Si la apuesta de de 1x2 el numero minimo de apuestas para esa apuesta
		// sera el del numero de casas de apuestas que queramos comparar por 3
		int minSizeBets1x2 = minimalNumberOfBookmakers * 3;

		List<RtMatch> finalMatch = new ArrayList<RtMatch>();
		for (RtMatch rtMatch : listResult) {
			agregarMatch = false;
			for (RtMarket rtMarket : rtMatch.getRtMarkets()) {
				String marketBetType = rtMarket.getBetType().getNameId();
				if (marketBetType.equals(CfgBetTypeId.GANADOR_PARTIDO.nameId())) {
					if (rtMarket.getBets().size() >= minSizeBetsMatchWinner) {
						agregarMatch = true;
						break;
					}
				}

				// Si no hay eventos candidatos en ganador partido probamos con
				// 1x2
				if (marketBetType.equals(CfgBetTypeId.UNO_X_DOS.nameId())) {
					if (rtMarket.getBets().size() >= minSizeBets1x2) {
						agregarMatch = true;
						break;
					}
				}
			}
			if (agregarMatch && finalMatch.size() < MAX_EVENTS) {
				finalMatch.add(rtMatch);
			} else if (finalMatch.size() == MAX_EVENTS) {
				break;
			}
		}
		return finalMatch;
	}

	/*
	 * public RtMatch findMarketByBetType(String idMatch, String idBetType) {
	 * RtMatch auxMatch = new RtMatch(); Date today = new Date();
	 * auxMatch.setObjectId(new BigInteger(idMatch));
	 * 
	 * Criteria criteria = new Criteria().andOperator(Criteria
	 * .where("matchId.startDate.zeroGmtMatchDate").exists(true)
	 * .gte(today).and("_id").is(getConvertedId(auxMatch))
	 * .and("coreActiveElement.active").is(true) .andOperator(
	 * where("markets").elemMatch( where("betType.$id").is(idBetType) ) ) );
	 * 
	 * Query query = new Query(criteria);
	 * query.fields().include("markets.$");//.getType.$ref
	 * 
	 * RtMatch rtMatch = getMongoTemplate().findOne(query, RtMatch.class);
	 * 
	 * return rtMatch; }
	 */

	/**
	 * Find the market and his betTypes.
	 * 
	 * @param idMatch
	 *            the id match
	 * @return the rt match
	 */
	public RtMatch findMarketAndBetType(String idMatch) {
		Date today = new Date();
		RtMatch auxMatch = new RtMatch();
		auxMatch.setObjectId(new BigInteger(idMatch));

		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("_id").is(getConvertedId(auxMatch))
				.and("coreActiveElement.active").is(true));

		Query query = new Query(criteria);

		query.fields().include(Fields.Market_BetType.getNameId());

		RtMatch result = getMongoTemplate().findOne(query, RtMatch.class);

		return result;
	}

	/**
	 * Find all market with bet Type.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @return the rt match
	 */
	public RtMatch findMarketByBetType(String idMatch, String idBetType) {
		Date today = new Date();
		RtMatch auxMatch = new RtMatch();
		auxMatch.setObjectId(new BigInteger(idMatch));

		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate")
				.exists(true)
				.gte(today)
				.and("_id")
				.is(getConvertedId(auxMatch))
				.and("coreActiveElement.active")
				.is(true)
				.andOperator(
						Criteria.where("markets").elemMatch(
								where("betType.$id").is(idBetType))));

		Query query = new Query(criteria);
		query.fields().include("markets");
		RtMatch result = getMongoTemplate().findOne(query, RtMatch.class);

		return result;
	}

	/**
	 * Gets the bet types competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the bet types competition matchs {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getBetTypesCompetitionMatchs(
			CfgCompetition pCompetition) {

		Date today = new Date();
		
		
		
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("matchId.competition.$id")
				.is(getConvertedId(pCompetition))
				.and("matchId.competition.$ref").is("cfgCompetition")
				.and("coreActiveElement.active").is(true));

		Query query = new Query(criteria);

		// Query query = new Query(where("matchId.competition.$id")
		// .is(getConvertedId(pCompetition))
		// .and("matchId.competition.$ref").is("cfgCompetition"));

		query.fields().include(Fields.Market_BetType.nameId);
		query.fields().include(Fields.MatchId_CompetitionEvent.nameId);
		query.fields().include(Fields.Market_CfgBetTypeEvent.nameId);

		List<RtMatch> listResult = getMongoTemplate()
				.find(query, RtMatch.class);

		return listResult;
	}

	/**
	 * Gets the competition matchs.
	 * 
	 * @param pCompetition
	 *            the competition
	 * @return the competition matchs
	 */
	@Override
	public List<RtMatch> getCompetitionMatchs(CfgCompetition pCompetition) {
		Date today = new Date();
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("matchId.competition.$id")
				.is(getConvertedId(pCompetition))
				.and("matchId.competition.$ref").is("cfgCompetition")
				.and("coreActiveElement.active").is(true));

		Query query = new Query(criteria);

		// Query query = new Query(where("matchId.competition.$id")
		// .is(getConvertedId(pCompetition))
		// .and("matchId.competition.$ref").is("cfgCompetition"));

		query.fields().include(Fields.RtMatch_I18n.nameId);
		query.fields().include(Fields.StartDate.nameId);
		query.fields().include(Fields.MatchId_Competition.nameId);
		query.fields().include(Fields.MatchId_Participants.nameId);
		query.fields().include(Fields.MatchId_CompetitionEvent.nameId);
		query.fields().include(Fields.Market_CfgBetTypeEvent.nameId);
		query.fields().include(Fields.Market_BetType.nameId);
		query.fields().include(Fields.Bet_BetOdd_odd.nameId);
		query.fields().include(Fields.Bet_Atrritute.nameId);
		query.fields().include(Fields.Bet_Bookmaker.nameId);
		query.fields().include(Fields.Bet_Participant.nameId);
		query.fields().include(Fields.Bet_WebURL.nameId);
		List<RtMatch> listResult = getMongoTemplate()
				.find(query, RtMatch.class);

		return listResult;
	}

	/**
	 * Gets the events for value bet limit.
	 * 
	 * @param limit
	 *            the limit
	 * @param skip
	 *            the skip
	 * @param minNumBets
	 *            the min num bets
	 * @return the events for value bet limit {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getEventsForValueBetLimit(Integer limit, Integer skip,
			Integer minNumBets) {

		Date today = new Date();

		Query query = new Query(where("matchId.startDate.zeroGmtMatchDate")
				.exists(true).gte(today).and("coreActiveElement.active")
				.is(true));

		query.skip(skip);
		query.limit(limit);

		query.fields().include(Fields.Market_HashKey.getNameId());
		query.fields().include(Fields.Market_BetType.getNameId());
		query.fields().include(Fields.Bet_HashKey.getNameId());
		query.fields().include(Fields.StartDate_ZeroGmtMatchDate.getNameId());
		query.fields().include(Fields.RtMatch_I18n.getNameId());
		query.fields().include(Fields.MatchId_Competition.getNameId());
		query.fields().include(Fields.Bet_Bookmaker.getNameId());
		query.fields().include(Fields.Bet_Atrritute.getNameId());
		query.fields().include(Fields.Bet_BetOdd.getNameId());
		query.fields().include(Fields.Bet_Participant.getNameId());
		query.fields().include(Fields.Bet_WebURL.getNameId());

		List<RtMatch> listResult = getMongoTemplate()
				.find(query, RtMatch.class);
		return listResult;
	}

	/**
	 * Gets the matchs by bet type and competition.
	 * 
	 * @param idCompetition
	 *            the id competition
	 * @param idBetType
	 *            the id bet type
	 * @return the matchs by bet type and competition {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getMatchsByBetTypeAndCompetition(
			BigInteger idCompetition, BigInteger idBetType) {

		CfgBetType betType = new CfgBetType();
		betType.setObjectId(idBetType);
		CfgCompetition competition = new CfgCompetition();
		competition.setObjectId(idCompetition);

		Date today = new Date();
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("matchId.competition.$id")
				.is(getConvertedId(competition))
				.and("matchId.competition.$ref").is("cfgCompetition")
				.and("markets.betType.$id").is(getConvertedId(betType))
				.and("coreActiveElement.active").is(true));

		Query query = new Query(criteria);

		// Query query = new Query(where("matchId.competition.$id")
		// .is(getConvertedId(competition))
		// .and("matchId.competition.$ref").is("cfgCompetition")
		// .and("markets.betType.$id").is(getConvertedId(betType)));

		query.fields().include(Fields.RtMatch_I18n.nameId);
		query.fields().include(Fields.StartDate.nameId);
		query.fields().include(Fields.MatchId_Competition.nameId);
		query.fields().include(Fields.MatchId_Participants.nameId);
		query.fields().include(Fields.MatchId_CompetitionEvent.nameId);
		query.fields().include(Fields.Market_CfgBetTypeEvent.nameId);
		query.fields().include(Fields.Market_BetType.nameId);
		query.fields().include(Fields.Bet_BetOdd_odd.nameId);
		query.fields().include(Fields.Bet_Atrritute.nameId);
		query.fields().include(Fields.Bet_Bookmaker.nameId);
		query.fields().include(Fields.Bet_Participant.nameId);
		query.fields().include(Fields.Bet_WebURL.nameId);

		List<RtMatch> listResult = getMongoTemplate()
				.find(query, RtMatch.class);

		return listResult;
	}

	/**
	 * Gets the matchs by competition filtered by bet type.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the matchs by competition filtered by bet type
	 */
	@Override
	public List<RtMatch> getMatchsByCompetitionFilteredByBetType(
			String competitionId) {
		Date today = new Date();
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("matchId.competition.$id").is(competitionId)
				.and("coreActiveElement.active").is(true));
		Query query = new Query(criteria);

		query.fields().include(Fields.RtMatch_I18n.nameId);
		query.fields().include(Fields.Market_BetType.nameId);
		query.fields().include(Fields.RtMatch_HashKey.nameId);
		query.fields().include(Fields.MatchId_Competition.nameId);
		query.fields().include(Fields.MatchId_CompetitionEvent.nameId);

		List<RtMatch> matchs = getMongoTemplate().find(query, RtMatch.class);
		return matchs;
	}

	/**
	 * Gets the matchs by hash key.
	 * 
	 * @param pMatchHashKey
	 *            the p match hash key
	 * @return the matchs by hash key
	 * 
	 */

	@Override
	public List<RtMatch> getMatchsByHashKey(String pMatchHashKey) {

		List<RtMatch> result;

		Query query = new Query(where("hashKey").is(pMatchHashKey));
		// .and("coreActiveElement.active").is(true));

		result = getMongoTemplate().find(query, RtMatch.class);

		return result;
	}

	/**
	 * Gets the matchs by hash keys.
	 * 
	 * @param pMatchHashKey
	 *            the match hash key
	 * @return the matchs by hash keys {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getMatchsByHashKeys(String pMatchHashKey) {

		List<RtMatch> result;

		Query query = new Query(where(Fields.RtMatch_HashKeys.nameId).is(
				pMatchHashKey));
		// .and(Fields.CoreActiveElement_Active.nameId)
		// .is(true));

		result = getMongoTemplate().find(query, RtMatch.class);

		return result;
	}

	/**
	 * Gets the num matchs by competition.
	 * 
	 * @param competition
	 *            the competition
	 * @param betType
	 *            the bet type
	 * @return the num matchs by competition {@inheritDoc}
	 */
	@Override
	public Long getNumMatchsByCompetition(CfgCompetition competition,
			String betType) {
		Date today = new Date();
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("matchId.competition.$id")
				.is(getConvertedId(competition))
				.and("matchId.competition.$ref").is("cfgCompetition")
				.and("markets.betType.$id").is(betType)
				.and("coreActiveElement.active").is(true));

		Query query = new Query(criteria);
		query.fields().include("matchId.startDate.zeroGmtMatchDate");
		query.fields().include("matchId.competition.$id");
		query.fields().include("matchId.competition.$ref");
		query.fields().include("markets.betType.$id");
		query.fields().include("coreActiveElement.active");

		// Query query = new Query(where("matchId.competition.$id")
		// .is(getConvertedId(competition))
		// .and("matchId.competition.$ref").is("cfgCompetition"));

		Long result = getMongoTemplate().count(query, RtMatch.class);

		return result;
	}

	/**
	 * Gets the rt match by competition and competition event.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param competitionEventId
	 *            the competition event id
	 * @return the rt match by competition and competition event {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getRtMatchByCompetitionAndCompetitionEvent(
			BigInteger competitionId, BigInteger competitionEventId) {

		Date today = new Date();
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("matchId.competition.$id")
				.is(competitionId.toString())
				.and("matchId.competitionEvent.$id")
				.is(competitionEventId.toString())
				.and("coreActiveElement.active").is(true));

		Query query = new Query(criteria);

		// Query query = new Query(where("matchId.competition.$id")
		// .is(competitionId).and("matchId.competitionEvent.$id")
		// .is(competitionEventId));

		query.fields().include(Fields.RtMatch_I18n.nameId);
		query.fields().include(Fields.StartDate.nameId);
		query.fields().include(Fields.MatchId_Competition.nameId);
		query.fields().include(Fields.MatchId_Participants.nameId);
		query.fields().include(Fields.MatchId_CompetitionEvent.nameId);
		query.fields().include(Fields.Market_CfgBetTypeEvent.nameId);
		query.fields().include(Fields.Market_BetType.nameId);
		query.fields().include(Fields.Bet_BetOdd_odd.nameId);
		query.fields().include(Fields.Bet_Atrritute.nameId);
		query.fields().include(Fields.Bet_Bookmaker.nameId);
		query.fields().include(Fields.Bet_Participant.nameId);
		query.fields().include(Fields.Bet_WebURL.nameId);

		List<RtMatch> listResult = getMongoTemplate()
				.find(query, RtMatch.class);

		return listResult;
	}

	/**
	 * Gets the upcoming events.
	 * 
	 * @param currentDate
	 *            the current date
	 * @param limitDate
	 *            the limit date
	 * @param minimalNumberOfBookmakers
	 *            the minimal number of bookmakers
	 * @return the upcoming events {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getUpcomingEvents(Date currentDate, Date limitDate,
			final int minimalNumberOfBookmakers) {
		List<RtMatch> result = new ArrayList<RtMatch>();
		List<NextEventMapReduce> nextEventMapReduces = getAllNextEvents(
				currentDate, limitDate, minimalNumberOfBookmakers);

		Query query = new Query();

		query.fields().include(Fields.Market_CfgBetTypeEvent.getNameId());
		query.fields().include(Fields.Market_BetType.getNameId());
		query.fields().include(Fields.StartDate_ZeroGmtMatchDate.getNameId());
		query.fields().include(Fields.RtMatch_I18n.getNameId());
		query.fields().include(Fields.RtMatch_Id.getNameId());
		query.fields().include(Fields.MatchId_Competition.getNameId());
		query.fields().include(Fields.Bet_Bookmaker.getNameId());
		query.fields().include(Fields.Bet_BetOdd.getNameId());
		query.fields().include(Fields.Bet_Participant.getNameId());
		query.fields().include(Fields.Bet_WebURL.getNameId());

		List<Criteria> orCriteria = new ArrayList<Criteria>();
		for (NextEventMapReduce nextEventMapReduce : nextEventMapReduces) {
			orCriteria.add(where(Fields.RtMatch_Id.getNameId()).is(
					nextEventMapReduce.getId()));
		}
		Criteria criteria = new Criteria();
		criteria.orOperator(orCriteria.toArray(new Criteria[orCriteria.size()]));
		query.addCriteria(criteria);
		if (!orCriteria.isEmpty()) {
			result = getMongoTemplate().find(query, RtMatch.class);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepositoryCustom
	 * #getAllNextEvents(java.util.Date, java.util.Date, int)
	 */
	@Override
	public List<NextEventMapReduce> getAllNextEvents(Date currentDate,
			Date limitDate, final int minimalNumberOfBookamkers) {
		Query query = new Query(where("matchId.startDate.zeroGmtMatchDate")
				.gte(currentDate)
				.and(Fields.CoreActiveElement_Active.getNameId())
				.is(true)
				.andOperator(
						new Criteria(Fields.StartDate_ZeroGmtMatchDate
								.getNameId()).lt(limitDate)));

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("minimalNumberOfBookamkers", minimalNumberOfBookamkers);
		MapReduceOptions options = new MapReduceOptions();
		options.scopeVariables(variables);
		options.outputTypeInline();

		MapReduceResults<NextEventMapReduce> resultQuery = getMongoTemplate()
				.mapReduce(query, COLLECTION_NAME,
						"classpath:mapreduce/MapGetAllNextEvents.js",
						"classpath:mapreduce/ReduceGetAllNextEvents.js",
						options, NextEventMapReduce.class);

		List<NextEventMapReduce> listEvents = new ArrayList<NextEventMapReduce>();
		for (NextEventMapReduce nextEventMapReduce : resultQuery) {
			listEvents.add(nextEventMapReduce);
		}
		Collections.sort(listEvents);
		List<NextEventMapReduce> result = new ArrayList<NextEventMapReduce>();
		int i = 0;
		for (NextEventMapReduce nextEventMapReduce : listEvents) {
			if (i == LIMIT_MATCHS) {
				break;
			}
			if (!nextEventMapReduce.getValue().getMarkets().isEmpty()) {
				result.add(nextEventMapReduce);
				i++;
			}
		}

		return result;
	}

	/**
	 * Gets the upcoming events for sure bet.
	 * 
	 * @param zeroGmtMatchDate
	 *            the zero gmt match date
	 * @param limitDate
	 *            the limit date
	 * @param page
	 *            the page
	 * @return the upcoming events for sure bet {@inheritDoc}
	 */
	@Override
	public List<RtMatch> getUpcomingEventsForSureBet(Date zeroGmtMatchDate,
			Date limitDate, int page) {
		Query query = new Query(
		// where("matchId.startDate.zeroGmtMatchDate")
		// .gte(zeroGmtMatchDate)
				where("coreActiveElement.active")
						.is(true)
						// .and(Fields.MatchId_Participants.getNameId())
						// .size(s)
						.andOperator(
								new Criteria(
										"matchId.startDate.zeroGmtMatchDate")
										.lt(limitDate))
						.and("matchId.startDate.zeroGmtMatchDate")
						.gte(zeroGmtMatchDate));

		query.fields().include(Fields.Market_CfgBetTypeEvent.getNameId());
		query.fields().include(Fields.Market_BetType.getNameId());
		query.fields().include(Fields.MatchId_Participants.getNameId());
		query.fields().include(Fields.MatchId_Competition.getNameId());
		query.fields().include(Fields.StartDate_ZeroGmtMatchDate.getNameId());
		query.fields().include(Fields.RtMatch_I18n.getNameId());
		query.fields().include(Fields.RtMatch_Id.getNameId());
		query.fields().include(Fields.Bet_Bookmaker.getNameId());
		query.fields().include(Fields.Bet_BetOdd.getNameId());
		query.fields().include(Fields.Bet_Atrritute.getNameId());
		query.fields().include(Fields.Bet_Participant.getNameId());
		query.fields().include(Fields.Bet_WebURL.getNameId());

		// Order order = new Order(Direction.ASC,
		// Fields.StartDate_ZeroGmtMatchDate.getNameId());
		// Sort sort = new Sort(order);

		// query.with(sort);
		query.skip(page * 10);
		query.limit(10);
		List<RtMatch> listResult = getMongoTemplate()
				.find(query, RtMatch.class);
		return listResult;
	}

	/**
	 * Map reduce get matchs by competition.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId
	 *            the bet type id
	 * @param betTypeEventIdPC
	 *            the bet type event id
	 * @param betTypeEventIdPCP
	 *            the bet type event id pcp
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<RtMatch> mapReduceGetMatchsByCompetition(
			BigInteger competitionId, String betTypeId,
			String betTypeEventIdPC, String betTypeEventIdPCP) {

		Criteria pcOrPcp = new Criteria()
				.orOperator(
						Criteria.where("markets.betTypeEvent.betTypeEvent.$id")
								.is("1"),
						Criteria.where("markets.betTypeEvent.betTypeEvent.$id")
								.is("17"));

		Query query = new Query(where("matchId.competition.$id")
				.is(competitionId.toString())
				.and("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(new Date()).and("coreActiveElement.active")
				.is(new Boolean(true)));
		
		if(!betTypeId.equals(CfgBetTypeId.UNO_X_DOS.id())) {
			query.addCriteria(pcOrPcp);
		}		
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("betTypeId", betTypeId);
		
		if(!betTypeId.equals(CfgBetTypeId.UNO_X_DOS.id())) {
			variables.put("betTypeEventId", betTypeEventIdPC);
			variables.put("betTypeEventIdPCP", betTypeEventIdPCP);
		} else {
			variables.put("betTypeEventId", betTypeEventIdPC);
			variables.put("betTypeEventIdPCP", null);			
		}

		MapReduceOptions options = new MapReduceOptions();
		options.scopeVariables(variables);
		options.outputTypeInline();

		MapReduceResults<RtMatchMapReduce> resultQuery = getMongoTemplate()
				.mapReduce(query, COLLECTION_NAME,
						"classpath:mapreduce/MapGetMatchsByCompetition.js",
						"classpath:mapreduce/ReduceGetMatchsByCompetition.js",
						options, RtMatchMapReduce.class);

		List<RtMatch> result = new ArrayList<RtMatch>();
		for (RtMatchMapReduce matchMapReduce : resultQuery) {
			if (matchMapReduce.getValue() != null) {
				result.add(matchMapReduce.getValue());
			}
		}
		return result;
	}

	/**
	 * Save.
	 * 
	 * @param match
	 *            the match {@inheritDoc}
	 */
	@Override
	public void save(T match) {
		Boolean validate = Boolean.TRUE;
		if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.TEST)) {
			if (ArrayUtils.contains(applicationContext.getEnvironment()
					.getActiveProfiles(),
					ProfileConstant.TEST_SAVE_RTMATCH_VALIDATION_ENABLED)) {
				validate = Boolean.TRUE;
			} else {
				validate = Boolean.FALSE;
			}
		}

		if (validate) {
			Set<ConstraintViolation<T>> constraintViolations;
			constraintViolations = validator.validate(match);

			getMongoTemplate().save(match);
			if (constraintViolations.size() == 0) {
				try {
					getMongoTemplate().save(match);
					LOG.debug(new StringBuffer("Se ha validado y se ha guardado el objeto: ").append(match));
				} catch (StackOverflowError e) {
					throw new ObjectWithRecursiveDataException(e);
				}
			} else {
				throw new ValidationObjectException(constraintViolations);
			}

		} else {
			LOG.debug(new StringBuffer("se ha guardado el objeto: ").append(match));
			getMongoTemplate().save(match);
		}
		
	}

	public void saveWithoutValidation(RtMatch match) {
		getMongoTemplate().save(match);
	}
	
	/**
	 * Find by name.
	 * 
	 * @param name
	 *            the name
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch findByName(String name) {
		Date today = new Date();
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("coreActiveElement.active").is(true)
				.and("i18n.i18nFields.string").is(name));
		Query query = new Query(criteria);

		query.fields().include(Fields.RtMatch_Id.nameId);
		query.fields().include(Fields.MatchId_Competition.getNameId());

		RtMatch match = getMongoTemplate().findOne(query, RtMatch.class);

		return match;
	}

	/**
	 * Find name and competition.
	 * 
	 * @param idRtMatch
	 *            the id rt match
	 * @return the rt match {@inheritDoc}
	 */
	public RtMatch findNameAndCompetition(String idRtMatch) {
		Date today = new Date();
		RtMatch auxMatch = new RtMatch();
		auxMatch.setObjectId(new BigInteger(idRtMatch));
		Criteria criteria = new Criteria().andOperator(Criteria
				.where("matchId.startDate.zeroGmtMatchDate").exists(true)
				.gte(today).and("_id").is(getConvertedId(auxMatch))
				.and("coreActiveElement.active").is(true));

		Query query = new Query(criteria);

		query.fields().include(Fields.RtMatch_I18n.getNameId());
		query.fields().include(Fields.MatchId_Competition.getNameId());
		query.fields().include(Fields.StartDate_ZeroGmtMatchDate.getNameId());

		RtMatch match = getMongoTemplate().findOne(query, RtMatch.class);

		return match;

	}

	/**
	 * Find market by bet type and bet type event.
	 * 
	 * @param idMatch
	 *            the id match
	 * @param idBetType
	 *            the id bet type
	 * @param idBetTypeEvent
	 *            the id bet type event
	 * @return the rt match {@inheritDoc}
	 */
	public RtMatch findMarketByBetTypeAndBetTypeEvent(String idMatch,
			String idBetType, String idBetTypeEvent) {
		RtMatch result = null;
		RtMatch auxMatch = new RtMatch();
		auxMatch.setObjectId(new BigInteger(idMatch));

		Criteria criteria = where("_id")
				.is(getConvertedId(auxMatch))
				.and("coreActiveElement.active")
				.is(true)
				.and("markets")
				.elemMatch(
						where("betType.$id").is(idBetType)
								.and("betTypeEvent.betTypeEvent.$id")
								.is(idBetTypeEvent));

		Query query = new Query(criteria);
		query.fields().include("markets.$");
		query.limit(1);

		List<RtMatch> matchs = getMongoTemplate().find(query, RtMatch.class);
		if (matchs.size() > 0) {
			result = matchs.get(0);
		}
		return result;
	}

	/**
	 * Removes the bets by update date.
	 * 
	 * @param match
	 *            the match
	 * @param date
	 *            the date
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch removeBetsByUpdateDate(RtMatch match, Date date) {
		List<RtMatch> matchs;
		Criteria criteria;
		Query query;
		Update update;

		criteria = where("_id").is(getConvertedId(match));

		query = new Query(criteria);

		update = new Update();
		update.unset("markets.bets");

		getMongoTemplate().updateFirst(query, update, RtMatch.class);

		matchs = getMongoTemplate().find(query, RtMatch.class);

		return matchs.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepositoryCustom
	 * #findAllLimitBetClean(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<RtMatch> findAllLimitBetClean(Integer limit, Integer skip) {
		Query query = new Query();

//		query.fields().include(Fields.RtMatch_Id.getNameId());
//		query.fields().include(Fields.RtMatch_HashKey.getNameId());
//		query.fields().include(Fields.Market_HashKey.getNameId());
//		query.fields().include(Fields.Bet_HashKey.getNameId());
//		query.fields().include(Fields.Bet_Bookmaker.getNameId());

		query.skip(skip);
		query.limit(limit);

		List<RtMatch> listResult = getMongoTemplate()
				.find(query, RtMatch.class);
		return listResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepositoryCustom
	 * #getMatchsByHashKeyBetClean(java.lang.String)
	 */
	@Override
	public List<RtMatch> getMatchsByHashKeyBetClean(String pMatchHashKey) {
		List<RtMatch> result;
		Query query = new Query(where("hashKey").is(pMatchHashKey));

//		query.fields().include(Fields.RtMatch_Id.getNameId());
//		query.fields().include(Fields.RtMatch_HashKey.getNameId());
//		query.fields().include(Fields.Market_HashKey.getNameId());
//		query.fields().include(Fields.Bet_HashKey.getNameId());
//		query.fields().include(Fields.Bet_Bookmaker.getNameId());
//		query.fields().include(Fields.Bet_ActualizateDate.getNameId());

		result = getMongoTemplate().find(query, RtMatch.class);

		return result;
	}

	@Override
	public Boolean exists(String hashKey) {
		Query query = new Query(where("hashKey").is(hashKey));

		return getMongoTemplate().count(query, RtMatch.class) !=0;
	}

	@Override
	public RtMatch isolatedFindByHashKey(String matchHashKey) {
		RtMatch result ;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MINUTE, c.get(Calendar.MINUTE)-1);
		
		Query query = new Query(where("hashKey").is(matchHashKey).
				orOperator(Criteria.where("lastLock").is(null),Criteria.where("lastLock").lt(c.getTime())));
		Update update = new Update();
		update.set("lastLock", new Date());
		
		
		result = getMongoTemplate().findAndModify(query, update,new FindAndModifyOptions().returnNew(true), RtMatch.class);
		if(result==null){
			query = new Query(where("hashKeys").is(matchHashKey).
					orOperator(Criteria.where("lastLock").is(null),Criteria.where("lastLock").gt(c.getTime())));
			result = getMongoTemplate().findAndModify(query, update,new FindAndModifyOptions().returnNew(true), RtMatch.class);
			
			if(result ==null){
				try {
					updateLog.errorLog(new StringBuffer().append("Otro proceso está modificando el partido con hashKey: ")
							.append(matchHashKey).append(". Esperamos a que lo libere").toString());
					Thread.sleep(500);
				} catch (InterruptedException e) {
					updateLog.errorLog(new StringBuffer().append("El hilo que se había bloqueado, ha recibido una Interrupción").toString());
				}
				result = isolatedFindByHashKey(matchHashKey);
			}
		}
		
		return result;
	}

	@Override
	public void isolateSave(RtMatch match) throws IsolatedSaveException {
		RtMatch result;
		Query query = new Query(where("hashKey").is(match.getAbstractKey().getHashKey())
				.and("lastLock").is(match.getLastLock()));
		Update update = new Update();
		update.set("coreActiveElement", match.getCoreActiveElement());
		update.set("markets", match.getRtMarkets());
		update.set("matchId", match.getMatchId());
		
		
		result = getMongoTemplate().findAndModify(query, update, RtMatch.class);
		if(result==null){
			throw new IsolatedSaveException();
		}
		
	}

	// /**
	// * Counts events types on markets of type Complete or Override from
	// Matches, and
	// * return the List<Match> with more events of one or other type.
	// *
	// * In draw case, default Complete.
	// *
	// * @param resultQuery, query's result's matchs.
	// *
	// * @return
	// */
	// private List<RtMatch> getMatchOverCountCompleteOrOverrideTypeEvent(
	// List<RtMatchMapReduce> resultQuery) {
	//
	// List<RtMatch> resultNormal = new ArrayList<RtMatch>();
	// List<RtMatch> resultProrroga = new ArrayList<RtMatch>();
	//
	// for (RtMatchMapReduce matchMapReduce : resultQuery) {
	// // Inicializar la cuenta para los mercados del Match.
	// int countComplete = 0;
	// int countCompleteOverride = 0;
	//
	// // getValue devuelve el RtMatch.
	// for(RtMarket market : matchMapReduce.getValue().getRtMarkets()){
	// if(market.getBetTypeEvent().getBetTypeEvent().getObjectId().toString().equals(
	// CfgBetTypeEventId.PARTIDO_COMPLETO.objectId())) {
	// ++countComplete;
	// }
	// else
	// if(market.getBetTypeEvent().getBetTypeEvent().getObjectId().toString().equals(
	// CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.objectId())){
	// ++countCompleteOverride;
	// }
	// }
	//
	// if(countComplete>=countCompleteOverride) {
	// resultNormal.add(matchMapReduce.getValue());
	// } else {
	// resultProrroga.add(matchMapReduce.getValue());
	// }
	// }
	//
	// if(resultNormal.size() >= resultProrroga.size()){
	// return resultNormal;
	// }
	//
	// return resultProrroga;
	// }

}
