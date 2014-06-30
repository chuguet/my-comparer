package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;



public class HockeyResolver implements ISportResolver {

	@Override
	public MarketInfoWilliamHill resolve(String[] pSplitNames,AdicionalInfo info)
			throws  BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		HockeyLiteralsFirstStep literal = HockeyLiteralsFirstStep.getBasketballLiteral(pSplitNames[1]);

		switch(literal){

		case MinutesBetting60:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case FirstPeriodBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PRIMERA_PARTE, false);
			break;
		case MoneyLine:
//			if((info.getCompetition().equals(HockeyLiteralsFirstStep.NHL.name) || (info.getCompetition().equals(HockeyLiteralsFirstStep.NCAAH.name)))){
//				result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
//			}else{
//				result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
//			}	
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case Outright:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case ConferenceWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case SpreadBetting:
			if((info.getCompetition().equals(HockeyLiteralsFirstStep.NHL.name) || (info.getCompetition().equals(HockeyLiteralsFirstStep.NCAAH.name)))){
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			}else{
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			}
			break;
		case PuckLineHandicap:
			if((info.getCompetition().equals(HockeyLiteralsFirstStep.NHL.name) || (info.getCompetition().equals(HockeyLiteralsFirstStep.NCAAH.name)))){
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			}else{
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			}
			break;
		case TotalGoals:
			if((info.getCompetition().equals(HockeyLiteralsFirstStep.NHL.name) || (info.getCompetition().equals(HockeyLiteralsFirstStep.NCAAH.name)))){
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			}else{
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			}
			break;
		case TotalMatchGoals:
			if((info.getCompetition().equals(HockeyLiteralsFirstStep.NHL.name) || (info.getCompetition().equals(HockeyLiteralsFirstStep.NCAAH.name)))){
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			}else{
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			}
			break;
			
		}
		
			
		return result;
	}

	public enum HockeyLiteralsFirstStep{

		MinutesBetting60("60 Minutes Betting"),
		FirstPeriodBetting("1st Period Betting"),
		MoneyLine("Money Line"),
		Outright("Outright"),
		ConferenceWinner("Conference Winner"),
		SpreadBetting("Spread Betting"),
		PuckLineHandicap("Puck Line Handicap"),
		TotalMatchGoals("Total Match Goals"),
		TotalGoals("Total Goals"),
		NHL("NHL"),
		NCAAH("NCAAH");

		HockeyLiteralsFirstStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static HockeyLiteralsFirstStep getBasketballLiteral(String name) throws BetTypeNotFoundException{
			HockeyLiteralsFirstStep result = null;

			HockeyLiteralsFirstStep[] values = HockeyLiteralsFirstStep.values();
			for (HockeyLiteralsFirstStep tennisLiterals : values) {
				if(name.equals(tennisLiterals.name)){
					result = tennisLiterals;
					break;
				}
			}

			if(result==null){
				throw new BetTypeNotFoundException("No se ha encontrado el tipo de apuesta: " + name);
			}
			return result;

		}

	}

}
