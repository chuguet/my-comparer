package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;

public class HandballResolver implements ISportResolver {

	@Override
	public MarketInfoWilliamHill resolve(String[] pSplitNames,AdicionalInfo info)
			throws  BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		HandballLiteralsFirstStep literal = HandballLiteralsFirstStep.getBasketballLiteral(pSplitNames[1]);
		
		switch(literal){

		case MatchBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case Outright:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case HandicapBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case TotalGoals:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
			
		}
		
		return result;
	}

	public enum HandballLiteralsFirstStep{

		MatchBetting("Match Betting"),
		Outright("Outright"),
		HandicapBetting("Handicap Betting"),
		TotalGoals("Total Goals");

		HandballLiteralsFirstStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static HandballLiteralsFirstStep getBasketballLiteral(String name) throws BetTypeNotFoundException{
			HandballLiteralsFirstStep result = null;

			HandballLiteralsFirstStep[] values = HandballLiteralsFirstStep.values();
			for (HandballLiteralsFirstStep handballLiterals : values) {
				if(name.equals(handballLiterals.name)){
					result = handballLiterals;
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
