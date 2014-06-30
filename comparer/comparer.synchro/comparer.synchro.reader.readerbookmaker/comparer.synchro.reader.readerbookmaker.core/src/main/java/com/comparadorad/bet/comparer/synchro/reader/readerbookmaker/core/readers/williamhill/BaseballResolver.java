package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;


public class BaseballResolver implements ISportResolver {

	@Override
	public MarketInfoWilliamHill resolve(String[] pSplitNames,AdicionalInfo info)
			throws  BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		BaseballLiteralsFirstStep literal = BaseballLiteralsFirstStep.getBasketballLiteral(pSplitNames[1]);
		
		switch(literal){

		case MoneyLine:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case Outright:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;	
		case SeriesWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case RunLine:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case TotalRuns:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case FirstInningsBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PRIMERA_ENTRADA, false);
			break;
		case FirstInningsTotalRuns:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PRIMERA_ENTRADA, false);
			break;
			
		}
		
		return result;
	}

	public enum BaseballLiteralsFirstStep{

		SeriesWinner("Series Winner"),
		RunLine("Run Line"),
		MoneyLine("Money Line"),
		Outright("Outright"),
		TotalRuns("Total Runs"),
		FirstInningsBetting("1st Innings Betting"),
		FirstInningsTotalRuns("1st Innings Total Runs");

		BaseballLiteralsFirstStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static BaseballLiteralsFirstStep getBasketballLiteral(String name) throws BetTypeNotFoundException{
			BaseballLiteralsFirstStep result = null;

			BaseballLiteralsFirstStep[] values = BaseballLiteralsFirstStep.values();
			for (BaseballLiteralsFirstStep baseballLiterals : values) {
				if(name.equals(baseballLiterals.name)){
					result = baseballLiterals;
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
