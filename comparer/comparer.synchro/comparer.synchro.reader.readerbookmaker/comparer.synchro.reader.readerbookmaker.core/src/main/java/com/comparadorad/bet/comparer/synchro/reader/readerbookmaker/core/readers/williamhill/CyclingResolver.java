package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

import com.comparadorad.bet.comparer.model.bet.bean.BetEventWilliamHill;
import com.comparadorad.bet.comparer.model.bet.bean.BetTypeWilliamHill;

public class CyclingResolver implements ISportResolver {

	@Override
	public MarketInfoWilliamHill resolve(String[] pSplitNames,AdicionalInfo info)
			throws  BetTypeNotFoundException {
		MarketInfoWilliamHill result = null;
		CyclingLiteralsFirstStep literal;
		if(pSplitNames.length<3){
			literal = CyclingLiteralsFirstStep.getBasketballLiteral(pSplitNames[1]);
		}else{
			literal = CyclingLiteralsFirstStep.getBasketballLiteral(pSplitNames[2]);
		}
		
		switch(literal){

		case Outright:
			result = new MarketInfoWilliamHill(BetTypeWilliamHill.GANADOR, BetEventWilliamHill.PARTIDO_COMPLETO, true);
			break;
		}
		
		return result;
	}

	public enum CyclingLiteralsFirstStep{

		Outright("Outright");

		CyclingLiteralsFirstStep(String pName) {
			this.name = pName;
		}
		private final String name;

		public static CyclingLiteralsFirstStep getBasketballLiteral(String name) throws BetTypeNotFoundException{
			CyclingLiteralsFirstStep result = null;

			CyclingLiteralsFirstStep[] values = CyclingLiteralsFirstStep.values();
			for (CyclingLiteralsFirstStep cyclingLiterals : values) {
				if(name.equals(cyclingLiterals.name)){
					result = cyclingLiterals;
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
