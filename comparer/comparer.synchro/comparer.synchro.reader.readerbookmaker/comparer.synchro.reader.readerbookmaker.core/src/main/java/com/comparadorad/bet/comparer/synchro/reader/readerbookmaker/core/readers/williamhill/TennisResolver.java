package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;


public class TennisResolver implements ISportResolver {

	@Override
	public MarketInfoWilliamHill resolve(String[] pSplitNames,AdicionalInfo info)
			throws  BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		TennisLiteralsFirstStep literal = TennisLiteralsFirstStep.getBasketballLiteral(pSplitNames[1]);


		switch(literal){

		case MatchBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case FirstSetBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.PRIMER_SET, false);
			break;
		case SecondSetBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.SEGUNDO_SET, false);
			break;	
		case ThirdSetBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.TERCER_SET, false);
			break;	
		case TournamentWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		}


		return result;
	}

	public enum TennisLiteralsFirstStep{

		TournamentWinner("Tournament Winner"),
		MatchBetting("Match Betting"),
		FirstSetBetting("1st Set Betting"),
		SecondSetBetting("2nd Set Betting"),
		ThirdSetBetting("3rd Set Betting");


		TennisLiteralsFirstStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static TennisLiteralsFirstStep getBasketballLiteral(String name) throws BetTypeNotFoundException{
			TennisLiteralsFirstStep result = null;

			TennisLiteralsFirstStep[] values = TennisLiteralsFirstStep.values();
			for (TennisLiteralsFirstStep tennisLiterals : values) {
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
