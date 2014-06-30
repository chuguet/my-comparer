package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import java.util.Arrays;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;

public class FutbolResolver implements ISportResolver {

	@Override
	public MarketInfoWilliamHill resolve(String[] pSplitNames,AdicionalInfo info)
			throws  BetTypeNotFoundException {

		FutbolLiteralsFirstStep literal = FutbolLiteralsFirstStep.getFutbolLiteral(pSplitNames[1]);
		MarketInfoWilliamHill result = null;

		switch(literal){

		case FirstHalfHandicaps:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS_HANDICAP, BetEventWilliamHill.PRIMERA_PARTE, false);
			break;
		case FirstHalfOverUnderGoals:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PRIMERA_PARTE, false);
			break;
		case FirtsHalfBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PRIMERA_PARTE, false);
			break;
		case MatchBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case MatchHandicaps:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS_HANDICAP, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case MinutesBetting15:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.QUINCE_MINUTOS, false);
			break;
		case MinutesBetting30:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.TREINTA_MINUTOS, false);
			break;
		case SecondHalfBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.SEGUNDA_PARTE, false);
			break;
		case SecondHalfHandicaps:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS_HANDICAP, BetEventWilliamHill.SEGUNDA_PARTE, false);
			break;
		case SecondHalfOverUnderGoals:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.SEGUNDA_PARTE, false);
			break;
		case TopGoalscorer:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAXIMO_GOLEADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case TotalMatchGoalsUnderOver:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case OTHER:
			if(pSplitNames.length>3){
				throw new BetTypeNotFoundException("No se ha encontrado el tipo de apuesta: "+Arrays.toString(pSplitNames));
			}else{
				if(pSplitNames.length<3){
					throw new BetTypeNotFoundException("No se ha encontrado el tipo de apuesta: "+Arrays.toString(pSplitNames));
				}else{
					result = processSecondSplitName(pSplitNames[2]);
				}
				
			}
			break;

		}


		return result;
	}



	private MarketInfoWilliamHill processSecondSplitName(String pString) throws BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		FutbolLiteralsSecondStep literal = FutbolLiteralsSecondStep.getFutbolLiteral(pString);
		switch(literal){

		case Outright:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case GroupWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case TournamentWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		
		}
		return result;
	}



	public enum FutbolLiteralsFirstStep{

		MatchBetting("Match Betting"),
		FirtsHalfBetting("1st Half Betting"),
		SecondHalfBetting("2nd Half Betting"),
		MinutesBetting15("15 Minutes Betting"),
		MinutesBetting30("30 Minutes Betting"),
		MatchHandicaps("Match Handicaps"),
		FirstHalfHandicaps("1st Half Handicaps"),
		SecondHalfHandicaps("2nd Half Handicaps"),
		TotalMatchGoalsUnderOver("Total Match Goals Under/Over"),
		FirstHalfOverUnderGoals("1st Half Over/Under Goals"),
		SecondHalfOverUnderGoals("2nd Half Over/Under Goals"),
		TopGoalscorer("Top Goalscorer"),
		OTHER("nextstep");


		FutbolLiteralsFirstStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static FutbolLiteralsFirstStep getFutbolLiteral(String name){
			FutbolLiteralsFirstStep result = null;

			FutbolLiteralsFirstStep[] values = FutbolLiteralsFirstStep.values();
			for (FutbolLiteralsFirstStep futbolLiterals : values) {
				if(name.equals(futbolLiterals.name)){
					result = futbolLiterals;
					break;
				}
			}

			if(result==null){
				result = FutbolLiteralsFirstStep.OTHER;
			}
			return result;

		}

	}

	public enum FutbolLiteralsSecondStep{

		Outright("Outright"),
		TournamentWinner("Tournament Winner"),
		GroupWinner("Group Winner");


		FutbolLiteralsSecondStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static FutbolLiteralsSecondStep getFutbolLiteral(String name) throws BetTypeNotFoundException{
			FutbolLiteralsSecondStep result = null;

			FutbolLiteralsSecondStep[] values = FutbolLiteralsSecondStep.values();
			for (FutbolLiteralsSecondStep futbolLiterals : values) {
				if(name.equals(futbolLiterals.name)){
					result = futbolLiterals;
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
