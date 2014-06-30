package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;

public class AmericanFutbolResolver implements ISportResolver {

	@Override
	public MarketInfoWilliamHill resolve(String[] pSplitNames,AdicionalInfo info)
			throws  BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		AmericanLiteralsFirstStep literal = AmericanLiteralsFirstStep.getBasketballLiteral(pSplitNames[1]);
		
		switch(literal){

		case MoneyLine:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case Outright:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;	
		case DivisionWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case MatchSpread:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case TotalPoints:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case MinutesCorrectScore60:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PARTIDO_COMPLETO, false);
			break;
		case FirstHalfBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PRIMERA_PARTE, false);
			break;
		case SecondHalfBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.SEGUNDA_PARTE, false);
			break;
		case FirstQuarterBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.PRIMER_CUARTO, false);
			break;
		case SecondQuarterBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.SEGUNDO_CUARTO, false);
			break;	
		case ThirdQuarterBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.TERCER_CUARTO, false);
			break;
		case FourthQuarterBetting:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.UNO_X_DOS, BetEventWilliamHill.CUARTO_CUARTO, false);
			break;
		case FirstHalfSpread:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PRIMERA_PARTE, false);
			break;
		case FirstHalfTotalPoints:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PRIMERA_PARTE, false);
			break;
		case SecondHalfSpread:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.SEGUNDA_PARTE, false);
			break;
		case SecondHalfTotalPoints:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.SEGUNDA_PARTE, false);
			break;
		}
		
		return result;
	}

	public enum AmericanLiteralsFirstStep{

		DivisionWinner("Division Winner"),
		MatchSpread("Match Spread"),
		MoneyLine("Money Line"),
		Outright("Outright"),
		TotalPoints("Total Points"),
		MinutesCorrectScore60("60 Minutes Correct Score"),
		FirstHalfBetting("1st Half Betting"),
		SecondHalfBetting("2nd Half Betting"),
		FirstHalfSpread("1st Half Spread"),
		SecondHalfSpread("2nd Half Spread"),
		FirstHalfTotalPoints("1st Half Total Points"),
		SecondHalfTotalPoints("2nd Half Total Points"),
		FirstQuarterBetting("1st Quarter Betting"),
		SecondQuarterBetting("2nd Quarter Betting"),
		ThirdQuarterBetting("3rd Quarter Betting"),
		FourthQuarterBetting("4th Quarter Betting");

		AmericanLiteralsFirstStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static AmericanLiteralsFirstStep getBasketballLiteral(String name) throws BetTypeNotFoundException{
			AmericanLiteralsFirstStep result = null;

			AmericanLiteralsFirstStep[] values = AmericanLiteralsFirstStep.values();
			for (AmericanLiteralsFirstStep americanLiterals : values) {
				if(name.equals(americanLiterals.name)){
					result = americanLiterals;
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
