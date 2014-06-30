package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bwin;

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBwin;

public class ResolverFactory {

	public static IBetTypeResolver getInstance(BetTypeBwin betType) {
		IBetTypeResolver result = null;
		switch (betType) {

		case GANADOR:
			result = new _GanadorResolver();
			break;
		case GANADOR_PARTIDO:
			result = new _GanadorPartidoResolver();
			break;
		case HANDICAP_ASIATICO:
			result = new _HandicapAsiaticoResolver();
			break;
		case MAS_MENOS:
			result = new _MasMenosResolver();
			break;
		case MAXIMO_GOLEADOR:
			result = new _MaximoGoleadorResolver();
			break;
		case UNO_X_DOS:
			result = new _1X2Resolver();
			break;
		case UNO_X_DOS_HANDICAP:
			result = new _1X2HandicapResolver();
			break;

		}
		return result;
	}




}
