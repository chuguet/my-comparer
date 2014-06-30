package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import java.util.Arrays;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;


public class BasketballResolver implements ISportResolver {

	@Override
	public MarketInfoWilliamHill resolve(String[] pSplitNames,AdicionalInfo info)
			throws  BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		BasketballLiteralsFirstStep literal = BasketballLiteralsFirstStep.getBasketballLiteral(pSplitNames[1]);

		switch(literal){

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
		case MoneyLine:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR_PARTIDO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case ChampionshipWinner:
			if(pSplitNames.length>2){
				throw new BetTypeNotFoundException("No se ha encontrado el tipo de apuesta: "+Arrays.toString(pSplitNames));
			}else{
				result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			}
			break;
		case Spread:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap1:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap2:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap3:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap4:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap5:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap6:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap7:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap8:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap9:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case AlternativeHandicap10:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;
		case FirstHalfSpread:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PRIMERA_PARTE, false);
			break;	
		case SecondHalfSpread:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.SEGUNDA_PARTE, false);
			break;
		case FirstQuarterSpread:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.PRIMER_CUARTO, false);
			break;
		case SecondQuarterSpread:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.HANDICAP_ASIATICO, BetEventWilliamHill.SEGUNDO_CUARTO, false);
			break;	
		case TotalPoints:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;		
		case AlternativeTotalPoints1:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints2:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints3:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints4:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints5:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints6:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints7:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints8:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints9:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case AlternativeTotalPoints10:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PARTIDO_COMPLETO_PRORROGA, false);
			break;	
		case FirstHalf:
			result = proccessFirstHalf(pSplitNames[2]);
			break;	
		case SecondHalf:
			result = proccessSecondHalf(pSplitNames[2]);
			break;
		case FirstQuarter:
			result = proccessFirstQuarter(pSplitNames[2]);
			break;	
		case SecondQuarter:
			result = proccessSecondQuarter(pSplitNames[2]);
			break;
		case GroupWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
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

		BasketballLiteralsSecondStep literal = BasketballLiteralsSecondStep.getBasketballLiteral(pString);
		switch(literal){

		case TournamentWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case ChampionshipWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case ConferenceWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case RegularSeasonMVP:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case RookieoftheYear:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		case DivisionWinner:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		}

		return result;
	}

	private MarketInfoWilliamHill proccessSecondQuarter(String pString) throws BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		BasketballLiteralsSecondStep literal = BasketballLiteralsSecondStep.getBasketballLiteral(pString);
		if(literal.equals(BasketballLiteralsSecondStep.TotalPoints)){
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.SEGUNDO_CUARTO, true);
		}

		return result;
	}

	private MarketInfoWilliamHill proccessFirstQuarter(String pString) throws BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		BasketballLiteralsSecondStep literal = BasketballLiteralsSecondStep.getBasketballLiteral(pString);
		if(literal.equals(BasketballLiteralsSecondStep.TotalPoints)){
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PRIMER_CUARTO, true);
		}

		return result;
	}

	private MarketInfoWilliamHill proccessSecondHalf(String pString) throws BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		BasketballLiteralsSecondStep literal = BasketballLiteralsSecondStep.getBasketballLiteral(pString);
		if(literal.equals(BasketballLiteralsSecondStep.TotalPoints)){
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.SEGUNDA_PARTE, true);
		}

		return result;
	}

	private MarketInfoWilliamHill proccessFirstHalf(String pString) throws BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;

		BasketballLiteralsSecondStep literal = BasketballLiteralsSecondStep.getBasketballLiteral(pString);
		if(literal.equals(BasketballLiteralsSecondStep.TotalPoints)){
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.MAS_MENOS, BetEventWilliamHill.PRIMERA_PARTE, true);
		}

		return result;
	}

	public enum BasketballLiteralsFirstStep{

		FirstHalfBetting("1st Half Betting"),
		SecondHalfBetting("2nd Half Betting"),
		FirstQuarterBetting("1st Quarter Betting"),
		SecondQuarterBetting("2nd Quarter Betting"),
		MoneyLine("Money Line"),
		AlternativeHandicap1("Alternative Handicap 1"),
		AlternativeHandicap2("Alternative Handicap 2"),
		AlternativeHandicap3("Alternative Handicap 3"),
		AlternativeHandicap4("Alternative Handicap 4"),
		AlternativeHandicap5("Alternative Handicap 5"),
		AlternativeHandicap6("Alternative Handicap 6"),
		AlternativeHandicap7("Alternative Handicap 7"),
		AlternativeHandicap8("Alternative Handicap 8"),
		AlternativeHandicap9("Alternative Handicap 9"),
		AlternativeHandicap10("Alternative Handicap 10"),
		Spread("Spread"),
		FirstHalfSpread("1st Half Spread"),
		SecondHalfSpread("2nd Half Spread"),
		FirstQuarterSpread("1st Quarter Spread"),
		SecondQuarterSpread("2nd Quarter Spread"),
		TotalPoints("Total Points"),
		AlternativeTotalPoints1("Alternative Total Points 1"),
		AlternativeTotalPoints2("Alternative Total Points 2"),
		AlternativeTotalPoints3("Alternative Total Points 3"),
		AlternativeTotalPoints4("Alternative Total Points 4"),
		AlternativeTotalPoints5("Alternative Total Points 5"),
		AlternativeTotalPoints6("Alternative Total Points 6"),
		AlternativeTotalPoints7("Alternative Total Points 7"),
		AlternativeTotalPoints8("Alternative Total Points 8"),
		AlternativeTotalPoints9("Alternative Total Points 9"),
		AlternativeTotalPoints10("Alternative Total Points 10"),
		FirstHalf("1st Half"),
		SecondHalf("2nd Half"),
		FirstQuarter("1st Quarter"),
		SecondQuarter("2nd Quarter"),
		ChampionshipWinner("Championship Winner"),
		GroupWinner("Group Winner"),
		OTHER("nextstep");


		BasketballLiteralsFirstStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static BasketballLiteralsFirstStep getBasketballLiteral(String name){
			BasketballLiteralsFirstStep result = null;

			BasketballLiteralsFirstStep[] values = BasketballLiteralsFirstStep.values();
			for (BasketballLiteralsFirstStep basketLiterals : values) {
				if(name.equals(basketLiterals.name)){
					result = basketLiterals;
					break;
				}
			}

			if(result==null){
				result = BasketballLiteralsFirstStep.OTHER;
			}
			return result;

		}

	}
	public enum BasketballLiteralsSecondStep{

		TournamentWinner("Tournament Winner"),
		ChampionshipWinner("Championship Winner"),
		ConferenceWinner("Conference Winner"),
		RegularSeasonMVP("Regular Season MVP"),
		RookieoftheYear("Rookie of the Year"),
		DivisionWinner("Division Winner"),
		TotalPoints("Total Points");


		BasketballLiteralsSecondStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static BasketballLiteralsSecondStep getBasketballLiteral(String name) throws BetTypeNotFoundException{
			BasketballLiteralsSecondStep result = null;

			BasketballLiteralsSecondStep[] values = BasketballLiteralsSecondStep.values();
			for (BasketballLiteralsSecondStep basketLiterals : values) {
				if(name.equals(basketLiterals.name)){
					result = basketLiterals;
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
