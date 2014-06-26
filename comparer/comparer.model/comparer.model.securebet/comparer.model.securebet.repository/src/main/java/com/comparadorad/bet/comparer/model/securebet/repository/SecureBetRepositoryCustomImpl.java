/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;

/**
 * The Class SecureBetRepositoryCustomImpl.
 * 
 * @param <T>
 *            the generic type
 */
class SecureBetRepositoryCustomImpl<T extends SecureBeanData> extends
		AbstractCfgRepository<T> implements SecureBetRepositoryCustom<T> {

	// /**
	// * Contains bet.
	// *
	// * @param bets2
	// * the bets2
	// * @param bet1
	// * the bet1
	// * @return the boolean
	// */
	// private Boolean containsBet(Set<RtBet> bets2, RtBet bet1) {
	// Boolean result = Boolean.FALSE;
	// for (RtBet bet2 : bets2) {
	// if (bet2.equals(bet1)) {
	// result = Boolean.TRUE;
	// break;
	// }
	// }
	// return result;
	// }
	//
	// /**
	// * Equals bets.
	// *
	// * @param bets1
	// * the bets1
	// * @param bets2
	// * the bets2
	// * @return the boolean
	// */
	// private Boolean equalsBets(Set<RtBet> bets1, Set<RtBet> bets2) {
	// Boolean result = Boolean.TRUE;
	// for (RtBet bet1 : bets1) {
	// if (!containsBet(bets2, bet1)) {
	// result = Boolean.FALSE;
	// break;
	// }
	// }
	// return result;
	// }

	/**
	 * Exist.
	 * 
	 * @param secureBeanData
	 *            the secure bean data
	 * @return the boolean {@inheritDoc}
	 */
	@Override
	public List<SecureBeanData> exist(T secureBeanData) {
		
		InfoMatch match = new InfoMatch();
		match.setObjectId(secureBeanData.getInfoMatch().getObjectId());
		
		
		Query query = new Query(where("infoMatch._id").is(getConvertedId(match))
				.and("betType.$id").is(secureBeanData.getBetType().getObjectId().toString())
				.and("betTypeEvent.betTypeEvent.$id").is(secureBeanData.getBetTypeEvent().getBetTypeEvent().getObjectId().toString())
				.andOperator(getBetsQuery(secureBeanData.getBets(),secureBeanData.getBetType())));
//		query.fields().include("bets");

		
		return getMongoTemplate().find(query,SecureBeanData.class);
	}

	private Criteria[] getBetsQuery(Set<RtBet> bets,CfgBetType betType) {
		Criteria[] criteria = null;
		if(betType.getNameId().equals(CfgBetType.CfgBetTypeId.UNO_X_DOS.nameId())){
			criteria = get1X2BetsQuery(bets);
		}
		else if(betType.getNameId().equals(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO.nameId())){
			criteria = getHABetsQuery(bets);
		}else if(betType.getNameId().equals(CfgBetType.CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())){
			criteria = get1X2HBetsQuery(bets);
		}
		else if(betType.getNameId().equals(CfgBetType.CfgBetTypeId.GANADOR_PARTIDO.nameId())){
			criteria = getGPBetsQuery(bets);
		}else if(betType.getNameId().equals(CfgBetType.CfgBetTypeId.MAS_MENOS.nameId())){
			criteria = getMMBetsQuery(bets);
		}
		
		return criteria;
	}

	private Criteria[] getMMBetsQuery(Set<RtBet> bets) {
		Criteria criteria = null;
		Criteria[] result = new Criteria[bets.size()];
		int i=0;
		for (RtBet rtBet : bets) {
			criteria = new Criteria();
			criteria.and("bets").elemMatch(where("attribute.masMenos").is(((RtMasMenosAttribute)rtBet.getAttribute()).getMasMenos().toString()).and("attribute.finalValue").is(rtBet.getAttribute().getFinalValue()).and("bookmaker.$id").is(rtBet.getBookmaker().getObjectId().toString()));
			result[i]=criteria;
			i++;
		}
		return result;
	}

	private Criteria[] getGPBetsQuery(Set<RtBet> bets) {
		Criteria criteria = null;
		Criteria[] result = new Criteria[bets.size()];
		int i=0;
		for (RtBet rtBet : bets) {
			criteria = new Criteria();
			criteria.and("bets").elemMatch(where("attribute.result").is(((RtGanadorPartidoAttribute)rtBet.getAttribute()).getResult().toString()).and("attribute.winnerName").is(((RtGanadorPartidoAttribute)rtBet.getAttribute()).getWinnerName()).and("bookmaker.$id").is(rtBet.getBookmaker().getObjectId().toString()));
			result[i]=criteria;
			i++;
		}
		return result;
	}

	private Criteria[] getHABetsQuery(Set<RtBet> bets) {
		Criteria criteria = null;
		Criteria[] result = new Criteria[bets.size()];
		int i=0;
		for (RtBet rtBet : bets) {
			criteria = new Criteria();
			criteria.and("bets").elemMatch(where("attribute.asianResult").is(((RtAsianHandicapAttribute)rtBet.getAttribute()).getAsianResult().toString()).and("attribute.finalValue").is(rtBet.getAttribute().getFinalValue()).and("bookmaker.$id").is(rtBet.getBookmaker().getObjectId().toString()));
			result[i]=criteria;
			i++;
		}
		return result;
	}

	private Criteria[] get1X2HBetsQuery(Set<RtBet> bets) {
		Criteria criteria = null;
		Criteria[] result = new Criteria[bets.size()];
		int i=0;
		for (RtBet rtBet : bets) {
			criteria = new Criteria();
			criteria.and("bets").elemMatch(where("attribute.result").is(((Rt1X2HandicapAttribute)rtBet.getAttribute()).getResult().toString()).and("attribute.finalValue").is(rtBet.getAttribute().getFinalValue()).and("bookmaker.$id").is(rtBet.getBookmaker().getObjectId().toString()));
			result[i]=criteria;
			i++;
		}
		return result;
	}

	private Criteria[] get1X2BetsQuery(Set<RtBet> bets) {
		Criteria criteria = null;
		Criteria[] result = new Criteria[bets.size()];
		int i=0;
		for (RtBet rtBet : bets) {
			criteria = new Criteria();
			criteria.and("bets").elemMatch(where("attribute.result").is(((Rt1X2Attribute)rtBet.getAttribute()).getResult().toString()).and("bookmaker.$id").is(rtBet.getBookmaker().getObjectId().toString()));
			result[i]=criteria;
			i++;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.securebet.repository.
	 * SecureBetRepositoryCustom#findAllLimit(java.lang.Integer)
	 */
	@Override
	public List<SecureBeanData> findAllLimit(Integer limit, Integer skip) {
		Query query = new Query();
		query.skip(skip);
		query.limit(limit);

		List<SecureBeanData> listResult = getMongoTemplate().find(query,
				SecureBeanData.class);
		return listResult;
	}

	/**
	 * Find one custom.
	 * 
	 * @param sureBetId
	 *            the sure bet id
	 * @return the secure bean data {@inheritDoc}
	 */
	@Override
	public SecureBeanData findOneCustom(String sureBetId) {
		SecureBeanData result = new SecureBeanData();

		SecureBeanData auxSecureBean = new SecureBeanData();
		auxSecureBean.setObjectId(new BigInteger(sureBetId));
		Criteria c = Criteria.where("_id").is(getConvertedId(auxSecureBean));
		Query query = new Query(c);

		result = getMongoTemplate().findOne(query, SecureBeanData.class);
		return result;

	}

	/**
	 * Gets the count.
	 * 
	 * @param coreDate
	 *            the core date
	 * @return the count {@inheritDoc}
	 */
	@Override
	public long getCount(CoreDate coreDate) {

		Criteria c = Criteria.where("createDate.zeroGmtMatchDate").lte(
				coreDate.getZeroGmtMatchDate());
		Query query = new Query(c);

		return getMongoTemplate().count(query, SecureBeanData.class);
	}

	/**
	 * Gets the sure bet page.
	 * 
	 * @param coreDate
	 *            the core date
	 * @param PageSize
	 *            the page size
	 * @param PageNumber
	 *            the page number
	 * @return the sure bet page {@inheritDoc}
	 */
	@Override
	public List<SecureBeanData> getSureBetPage(CoreDate coreDate, int PageSize,
			long PageNumber) {
		List<SecureBeanData> result = new ArrayList<SecureBeanData>();

		Criteria c = Criteria.where("createDate.zeroGmtMatchDate").lte(
				coreDate.getZeroGmtMatchDate());

		Query query = new Query(c);
		Order order = new Order(Direction.DESC, "benefit.value");
		Sort sort = new Sort(order);
		query.with(sort);
		query.skip((int) (PageSize * PageNumber));
		query.limit(PageSize);

		result = getMongoTemplate().find(query, SecureBeanData.class);
		return result;
	}

	/**
	 * Gets the sure bet page.
	 * 
	 * @param coreDate
	 *            the core date
	 * @param PageSize
	 *            the page size
	 * @param PageNumber
	 *            the page number
	 * @return the sure bet page {@inheritDoc}
	 */
	@Override
	public List<SecureBeanData> getSureBetPaginateForHistoric(int PageSize,
			long PageNumber) {
		List<SecureBeanData> result = new ArrayList<SecureBeanData>();

		Query query = new Query();
		query.skip((int) (PageSize * PageNumber));
		query.limit(PageSize);

		result = getMongoTemplate().find(query, SecureBeanData.class);
		return result;
	}
	
	/**
	 * Last date surebet.
	 * 
	 * @param secureBeanData
	 *            the secure bean data
	 * @return the secure bean data {@inheritDoc}
	 */
	@Override
	public SecureBeanData lastDateSurebet(SecureBeanData secureBeanData) {
		SecureBeanData result = new SecureBeanData();
		Boolean flag = Boolean.FALSE;
		List<Boolean> booleans = new ArrayList<Boolean>();

		InfoMatch match = new InfoMatch();
		if (secureBeanData != null && secureBeanData.getInfoMatch() != null
				&& secureBeanData.getInfoMatch().getObjectId() != null
				&& !secureBeanData.equals(new SecureBeanData())) {

			match.setObjectId(secureBeanData.getInfoMatch().getObjectId());
			Query query = new Query(where("infoMatch.competition.sport.$id")
					.is(secureBeanData.getInfoMatch().getCompetition()
							.getSport().getObjectId().toString())
					.and("infoMatch.competition.region.$id")
					.is(secureBeanData.getInfoMatch().getCompetition()
							.getRegion().getObjectId().toString())
					.and("betType.$id")
					.is(secureBeanData.getBetType().getObjectId().toString())
					.and("betTypeEvent.betTypeEvent.$id")
					.is(secureBeanData.getBetTypeEvent().getBetTypeEvent()
							.getObjectId().toString()).and("benefit.value")
					.nin(secureBeanData.getBenefit().getValue()).and("nameId")
					.is(secureBeanData.getNameId()));

			List<SecureBeanData> beanDatas = getMongoTemplate().find(query,
					SecureBeanData.class);

			for (SecureBeanData beanData : beanDatas) {
				if (beanData.getBets().size() == secureBeanData.getBets()
						.size()) {
					booleans = new ArrayList<Boolean>();
					for (RtBet rtBet : beanData.getBets()) {
						flag = Boolean.FALSE;
						for (RtBet bet : secureBeanData.getBets()) {
							if (bet.getAttribute().equals(rtBet.getAttribute())) {
								flag = Boolean.TRUE;
							}
							booleans.add(flag);
						}
						if (!booleans.contains(Boolean.FALSE)) {
							result = beanData;
							break;
						}
					}
				}
			}

		}
		return result;
	}

	// /**
	// * Some contains bets.
	// *
	// * @param secureBeanDatas
	// * the secure bean datas
	// * @param bets
	// * the bets
	// * @return the boolean
	// */
	// private Boolean someContainsBets(List<SecureBeanData> secureBeanDatas,
	// Set<RtBet> bets) {
	// Boolean result = Boolean.FALSE;
	// for (SecureBeanData secureBeanData : secureBeanDatas) {
	// if (equalsBets(secureBeanData.getBets(), bets)) {
	// result = Boolean.TRUE;
	// break;
	// }
	// }
	// return result;
	// }

	public void update(SecureBeanData surebetDB, Set<RtBet> bets,
			SecureBeanBenefit benefit){
		
		//TODO: Este sería el update correcto, pero no guarda el _class, solucionar cuando tengamos tiempo...
//		Query query = new Query(where("_id").is(getConvertedId(surebetDB)));
//		Update update = new Update();
//		update.set("bets", bets);
//		update.set("benefit", benefit);
//		getMongoTemplate().updateFirst(query, update, SecureBeanData.class);
		
		surebetDB.setBets(bets);
		surebetDB.setBenefit(benefit);
		
		getMongoTemplate().save(surebetDB);
		
	}
}
