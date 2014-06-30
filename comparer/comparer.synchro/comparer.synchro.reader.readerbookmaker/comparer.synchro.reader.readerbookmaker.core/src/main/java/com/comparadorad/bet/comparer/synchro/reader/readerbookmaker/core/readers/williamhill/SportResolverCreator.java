package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.williamhill;

public class SportResolverCreator {


	public ISportResolver getResolver(SportsWilliamHill sport){
		ISportResolver result = null;

		switch (sport) {
		
		case Futbol:
			result = new FutbolResolver();
			break;
		case Basketball:
			result = new BasketballResolver();
			break;
		case Tennis:
			result = new TennisResolver();
			break;
		case Hockey:
			result = new HockeyResolver();
			break;
		case Baseball:
			result = new BaseballResolver();
			break;
		case Cycling:
			result = new CyclingResolver();
			break;
		case American_football:
			result = new AmericanFutbolResolver();
			break;
		case Handball:
			result = new HandballResolver();
			break;
		default:
			break;
		}


		return result;

	}
}
