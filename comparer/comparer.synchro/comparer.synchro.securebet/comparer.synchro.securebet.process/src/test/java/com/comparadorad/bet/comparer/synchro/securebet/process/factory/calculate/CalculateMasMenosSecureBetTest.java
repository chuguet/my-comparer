package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.securebet.process.AbstractTest;

public class CalculateMasMenosSecureBetTest extends AbstractTest{
	
	@Inject
	private CalculateMasMenosSecureBet calculateMasMenosSecureBet;
	@Inject
	private CfgBetTypeRepository betTypeRepository;
	@Inject
	private CfgBetTypeEventRepository betTypeEventRepository;
	@Inject
	private CfgBookmakerRepository bookmakerRepository;
	
	@Test
	public void CalculateMasMenosSecureBetTestGenerateSegureBetTest() {
		
		SureBetsMatch calculateSecureBetBean;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtMarket rtMarket = new RtMarket();
		CfgCompetition cfgCompetition = new CfgCompetition();
		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();
		
		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		CfgBetType cfgBetType = betTypeRepository.findOne(new BigInteger("6"));
		CfgBetTypeEvent betTypeEvent = betTypeEventRepository
				.findOne(new BigInteger("1"));
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		Set<RtBet> bets = new HashSet<RtBet>();

		RtBet bet;
		
		
		// BETBOO
		
				//goles 1
				bet = createBet("2.10", awayRtparticipant, "19", "www.betboo.com", "MAS", "0.5");
				bets.add(bet);

				bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", "MENOS", "0.5");
				bets.add(bet);

				//goles 2
				bet = createBet("2.03", awayRtparticipant, "19", "www.betboo.com", "MAS", "1.5");
				bets.add(bet);

				bet = createBet("1.02", homeRtparticipant, "19", "www.betboo.com", "MENOS", "1.5");
				bets.add(bet);

				//goles 3
				bet = createBet("2.07", awayRtparticipant, "19", "www.betboo.com", "MAS", "2.5");
				bets.add(bet);

				bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", "MENOS", "2.5");
				bets.add(bet);

				
				// BETCLICK
				
				//goles 1
				bet = createBet("1.03", awayRtparticipant, "17", "www.betclick.com", "MAS", "0.5");
				bets.add(bet);

				bet = createBet("2.20", homeRtparticipant, "17", "www.betclick.com", "MENOS", "0.5");
				bets.add(bet);

				//goles 2
				bet = createBet("1.33", awayRtparticipant, "17", "www.betclick.com", "MAS", "1.5");
				bets.add(bet);

				bet = createBet("2.09", homeRtparticipant, "17", "www.betclick.com", "MENOS", "1.5");
				bets.add(bet);

				//goles 3
				bet = createBet("1.03", awayRtparticipant, "17", "www.betclick.com", "MAS", "2.5");
				bets.add(bet);

				bet = createBet("2.21", homeRtparticipant, "17", "www.betclick.com", "MENOS", "2.5");
				bets.add(bet);
		
	
		cfgCompetition.setObjectId(BigInteger.ONE);

		matchId.setCompetition(cfgCompetition);
		matchId.setParticipiants(rtParticipants);

		rtMarket.setBetType(cfgBetType);
		rtMarket.setBetTypeEvent(rtBetTypeEvent);
		rtMarket.setBets(bets);
		
		match.setMatchId(matchId);
		match.add(rtMarket);
		
		calculateSecureBetBean = calculateMasMenosSecureBet.calculateSecureBetForRtMarket(match, rtMarket);
		assertNotNull(calculateSecureBetBean);
		assertEquals(3, calculateSecureBetBean.getSureBetsMarket().size());
		assertEquals(cfgBetType, calculateSecureBetBean.getSureBetsMarket().get(0).getBetType());
		assertEquals(rtBetTypeEvent, calculateSecureBetBean.getSureBetsMarket().get(0).getBetTypeEvent());
		assertEquals(cfgCompetition,calculateSecureBetBean.getSureBetsMarket().get(0).getMatch().getMatchId().getCompetition() );
		SureBetsMarket bean = calculateSecureBetBean.getSureBetsMarket().get(0); 
		for (SecureBeanBenefit beanBenefit : bean.getSecureBetAgrupation().keySet()) {
			Double number = Math.rint(beanBenefit.getValue()*100)/100;			
			if( 7.44d !=  number && 2.98d !=  number && 6.89d !=  number ){
				fail("Los beneficios no son los esperados") ;
			}
		}
		
		
	}
	
	@Test
	public void CalculateMasMenosSecureBetTestNoGenerateSegureBetTest() {
		
		SureBetsMatch calculateSecureBetBean;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtMarket rtMarket = new RtMarket();
		CfgCompetition cfgCompetition = new CfgCompetition();
		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();
		
		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		CfgBetType cfgBetType = betTypeRepository.findOne(new BigInteger("6"));
		CfgBetTypeEvent betTypeEvent = betTypeEventRepository
				.findOne(new BigInteger("1"));
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		Set<RtBet> bets = new HashSet<RtBet>();

		RtBet bet;
		
		
		// BETBOO
		
				//goles 1
				bet = createBet("1.10", awayRtparticipant, "19", "www.betboo.com", "MAS", "0.5");
				bets.add(bet);

				bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", "MENOS", "0.5");
				bets.add(bet);

				//goles 2
				bet = createBet("1.03", awayRtparticipant, "19", "www.betboo.com", "MAS", "1.5");
				bets.add(bet);

				bet = createBet("1.02", homeRtparticipant, "19", "www.betboo.com", "MENOS", "1.5");
				bets.add(bet);

				//goles 3
				bet = createBet("1.07", awayRtparticipant, "19", "www.betboo.com", "MAS", "2.5");
				bets.add(bet);

				bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", "MENOS", "2.5");
				bets.add(bet);

				
				// BETCLICK
				
				//goles 1
				bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com", "MAS", "0.5");
				bets.add(bet);

				bet = createBet("1.20", homeRtparticipant, "17", "www.betclick.com", "MENOS", "0.5");
				bets.add(bet);

				//goles 2
				bet = createBet("1.83", awayRtparticipant, "17", "www.betclick.com", "MAS", "1.5");
				bets.add(bet);

				bet = createBet("1.09", homeRtparticipant, "17", "www.betclick.com", "MENOS", "1.5");
				bets.add(bet);

				//goles 3
				bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com", "MAS", "2.5");
				bets.add(bet);

				bet = createBet("1.21", homeRtparticipant, "17", "www.betclick.com", "MENOS", "2.5");
				bets.add(bet);
		
	
		cfgCompetition.setObjectId(BigInteger.ONE);

		matchId.setCompetition(cfgCompetition);
		matchId.setParticipiants(rtParticipants);

		rtMarket.setBetType(cfgBetType);
		rtMarket.setBetTypeEvent(rtBetTypeEvent);
		rtMarket.setBets(bets);
		
		match.setMatchId(matchId);
		match.add(rtMarket);
		
		calculateSecureBetBean = calculateMasMenosSecureBet.calculateSecureBetForRtMarket(match, rtMarket);
		assertNotNull(calculateSecureBetBean);
		assertEquals(3, calculateSecureBetBean.getSureBetsMarket().size());
		assertEquals(cfgBetType, calculateSecureBetBean.getSureBetsMarket().get(0).getBetType());
		assertEquals(rtBetTypeEvent, calculateSecureBetBean.getSureBetsMarket().get(0).getBetTypeEvent());
		assertEquals(cfgCompetition,calculateSecureBetBean.getSureBetsMarket().get(0).getMatch().getMatchId().getCompetition() );
		
		
	}
	
	
	@Test
	public void CalculateMasMenosSecureBetTestAlmostGenerateSegureBetTest() {
		
		SureBetsMatch calculateSecureBetBean;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtMarket rtMarket = new RtMarket();
		CfgCompetition cfgCompetition = new CfgCompetition();
		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();
		
		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		CfgBetType cfgBetType = betTypeRepository.findOne(new BigInteger("6"));
		CfgBetTypeEvent betTypeEvent = betTypeEventRepository
				.findOne(new BigInteger("1"));
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		Set<RtBet> bets = new HashSet<RtBet>();

		RtBet bet;
		
		
		// BETBOO
		
				//goles 1
				bet = createBet("2.00", awayRtparticipant, "19", "www.betboo.com", "MAS", "0.5");
				bets.add(bet);

				bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", "MENOS", "0.5");
				bets.add(bet);

				//goles 2
				bet = createBet("2.00", awayRtparticipant, "19", "www.betboo.com", "MAS", "1.5");
				bets.add(bet);

				bet = createBet("1.02", homeRtparticipant, "19", "www.betboo.com", "MENOS", "1.5");
				bets.add(bet);

				//goles 3
				bet = createBet("2.00", awayRtparticipant, "19", "www.betboo.com", "MAS", "2.5");
				bets.add(bet);

				bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", "MENOS", "2.5");
				bets.add(bet);

				
				// BETCLICK
				
				//goles 1
				bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com", "MAS", "0.5");
				bets.add(bet);

				bet = createBet("2.00", homeRtparticipant, "17", "www.betclick.com", "MENOS", "0.5");
				bets.add(bet);

				//goles 2
				bet = createBet("1.83", awayRtparticipant, "17", "www.betclick.com", "MAS", "1.5");
				bets.add(bet);

				bet = createBet("2.00", homeRtparticipant, "17", "www.betclick.com", "MENOS", "1.5");
				bets.add(bet);

				//goles 3
				bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com", "MAS", "2.5");
				bets.add(bet);

				bet = createBet("2.00", homeRtparticipant, "17", "www.betclick.com", "MENOS", "2.5");
				bets.add(bet);
		
	
		cfgCompetition.setObjectId(BigInteger.ONE);

		matchId.setCompetition(cfgCompetition);
		matchId.setParticipiants(rtParticipants);

		rtMarket.setBetType(cfgBetType);
		rtMarket.setBetTypeEvent(rtBetTypeEvent);
		rtMarket.setBets(bets);
		
		match.setMatchId(matchId);
		match.add(rtMarket);
		
		calculateSecureBetBean = calculateMasMenosSecureBet.calculateSecureBetForRtMarket(match, rtMarket);
		assertNotNull(calculateSecureBetBean);
		assertEquals(3, calculateSecureBetBean.getSureBetsMarket().size());
		assertEquals(cfgBetType, calculateSecureBetBean.getSureBetsMarket().get(0).getBetType());
		assertEquals(rtBetTypeEvent, calculateSecureBetBean.getSureBetsMarket().get(0).getBetTypeEvent());
		assertEquals(cfgCompetition,calculateSecureBetBean.getSureBetsMarket().get(0).getMatch().getMatchId().getCompetition() );
		SureBetsMarket bean = calculateSecureBetBean.getSureBetsMarket().get(0); 
		for (SecureBeanBenefit beanBenefit : bean.getSecureBetAgrupation().keySet()) {
			Double number = Math.rint(beanBenefit.getValue()*100)/100;			
			assertEquals((Double) 0.00 , number);
		}
		
		
	}
	
	@Test
	public void calculateSecureBetForRtMarketTest(){	
		RtMarket market = new RtMarket();
		RtMatch match = new RtMatch();
		SureBetsMatch calculateSecureBetBean;
		RtBet bet;
		RtMasMenosAttribute attribute;
		RtBetOdd betOdd;
		RtParticipant realMadrid;
		RtParticipant barcelona;
		RtParticipant draw;
		CfgBookmaker betAtHome;
		CfgBookmaker betClick;
		List<RtBet> rtBets;
		SecureBeanBenefit moreBenefitBean = new SecureBeanBenefit(7.441858737516455d);
		SecureBeanBenefit lessBenefitBean = new SecureBeanBenefit(49.999995529651756d);
		
		/*
		 * Se crea los bookmaker
		 */
		betAtHome = new CfgBookmaker();
		betAtHome.setObjectId(BigInteger.ONE);
		betAtHome.setName("Bet-At-Home");
		
		betClick = new CfgBookmaker();
		betClick.setObjectId(BigInteger.TEN);
		betClick.setName("BetClick");
		
		/*
		 * Se finaliza los bookmaker
		 */
		
		/*
		 * Se crea los participantes
		 */		
		realMadrid = new RtParticipant();
		realMadrid.setAwayParticipant(false);
		realMadrid.setHomeParticipant(true);
		realMadrid.setCfgParticipant(new CfgParticipant(BigInteger.ONE));
		
		draw = new RtParticipant();
		draw.setAwayParticipant(false);
		draw.setHomeParticipant(false);		
		
		barcelona = new RtParticipant();
		barcelona.setAwayParticipant(true);
		barcelona.setHomeParticipant(false);
		barcelona.setCfgParticipant(new CfgParticipant(BigInteger.TEN));
		
		/*
		 * Se finaliza los participantes
		 */
		
		/*
		 *  Se inicia la construccion del mercado Mas / Menos
		 *  
		 */
		
		/*
		 *  Inicio mercado de tipo 2
		 */
		
		/*
		 * Mercado 2
		 */
		
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(1.5);
		attribute.setMasMenos(MasMenos.MAS);		
		
		betOdd = new RtBetOdd();
		betOdd.setOdds("2.1");
		
		bet = new RtBet();
		bet.setBookmaker(betAtHome);
		bet.setBetOdd(betOdd);
		bet.setAttribute(attribute);
		bet.setParticipant(realMadrid);
		
		market.add(bet);
		
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(1.5);
		attribute.setMasMenos(MasMenos.MENOS);		
		
		betOdd = new RtBetOdd();
		betOdd.setOdds("1.2");
		
		bet = new RtBet();
		bet.setBookmaker(betAtHome);
		bet.setBetOdd(betOdd);
		bet.setAttribute(attribute);
		bet.setParticipant(realMadrid);
		
		market.add(bet);
		
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(1.5);
		attribute.setMasMenos(MasMenos.MAS);		
		
		betOdd = new RtBetOdd();
		betOdd.setOdds("1.2");
		
		bet = new RtBet();
		bet.setBookmaker(betClick);
		bet.setBetOdd(betOdd);
		bet.setAttribute(attribute);
		bet.setParticipant(realMadrid);
		
		market.add(bet);
		
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(1.5);
		attribute.setMasMenos(MasMenos.MENOS);		
		
		betOdd = new RtBetOdd();
		betOdd.setOdds("2.2");
		
		bet = new RtBet();
		bet.setBookmaker(betClick);
		bet.setBetOdd(betOdd);
		bet.setAttribute(attribute);
		bet.setParticipant(realMadrid);
		
		market.add(bet);
		
		/*
		 * Mercado 3
		 */
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(2.5);
		attribute.setMasMenos(MasMenos.MAS);		
		
		betOdd = new RtBetOdd();
		betOdd.setOdds("1.2");
		
		bet = new RtBet();
		bet.setBookmaker(betAtHome);
		bet.setBetOdd(betOdd);
		bet.setAttribute(attribute);
		bet.setParticipant(realMadrid);
		
		market.add(bet);
		
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(2.5);
		attribute.setMasMenos(MasMenos.MENOS);		
		
		betOdd = new RtBetOdd();
		betOdd.setOdds("1.2");
		
		bet = new RtBet();
		bet.setBookmaker(betAtHome);
		bet.setBetOdd(betOdd);
		bet.setAttribute(attribute);
		bet.setParticipant(realMadrid);
		
		market.add(bet);
		
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(2.5);
		attribute.setMasMenos(MasMenos.MAS);		
		
		betOdd = new RtBetOdd();
		betOdd.setOdds("3");
		
		bet = new RtBet();
		bet.setBookmaker(betClick);
		bet.setBetOdd(betOdd);
		bet.setAttribute(attribute);
		bet.setParticipant(realMadrid);
		
		market.add(bet);
		
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(2.5);
		attribute.setMasMenos(MasMenos.MENOS);		
		
		betOdd = new RtBetOdd();
		betOdd.setOdds("3");
		
		bet = new RtBet();
		bet.setBookmaker(betClick);
		bet.setBetOdd(betOdd);
		bet.setAttribute(attribute);
		bet.setParticipant(realMadrid);
		
		market.add(bet);
		
		assertNotNull(calculateMasMenosSecureBet);
		
		calculateSecureBetBean = calculateMasMenosSecureBet.calculateSecureBetForRtMarket(match, market);
		
		assertNotNull(calculateSecureBetBean);
		assertEquals(2, calculateSecureBetBean.getSureBetsMarket().size());
		
		for (SureBetsMarket secureBetBean : calculateSecureBetBean.getSureBetsMarket()) {
			
			if( secureBetBean.getSecureBetAgrupation().containsKey( moreBenefitBean ) ){
				rtBets = secureBetBean.getSecureBetAgrupation().get(moreBenefitBean);
				for (RtBet rtBet : rtBets) {
					if(  !"2.1".equals(rtBet.getBetOdd().getOdds()) &&  !"2.2".equals(rtBet.getBetOdd().getOdds()) ){
						fail("Los valores para generar una apuesta segura son incorrectos");
					}
				}
			}else if( secureBetBean.getSecureBetAgrupation().containsKey( lessBenefitBean )){
				rtBets = secureBetBean.getSecureBetAgrupation().get(lessBenefitBean);
				for (RtBet rtBet : rtBets) {
					assertEquals("3", rtBet.getBetOdd().getOdds() );
				}
			}
		}
		
		
	}
	
	
	private RtBet createBet(String odd, RtParticipant participant,
			String idBookmaker, String urlBookamker, String masMenos, String totalGoles) {
		RtBet bet = new RtBet();
		RtBetOdd betOdd = new RtBetOdd();
		RtMasMenosAttribute attribute = new RtMasMenosAttribute();
		
		attribute = new RtMasMenosAttribute();
		attribute.setFinalValue(Double.valueOf(totalGoles));
		attribute.setMasMenos(MasMenos.valueOf(masMenos));		
		
		betOdd.setOdds(odd);
		bet.setBetOdd(betOdd);
		bet.setParticipant(participant);
		bet.setAttribute(attribute);
		bet.setBookmaker(this.bookmakerRepository.findOne(new BigInteger(
				idBookmaker)));
		return bet;
	}
	
	
}
