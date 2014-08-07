package com.comparadorad.bet.comparer.web.server.mvc.match.control.filters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;

/**
 * Filter to reduce by Complete Match and Override Match.
 * 
 * @author farce
 *
 */
public class RtMatchReduceByPCAndPCPFilter extends  AbstractRtMatchFilter<RtMatch> {

	/**
	 * Default Constructor.
	 */
	public RtMatchReduceByPCAndPCPFilter() {
		super();
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public List<RtMatch> applyFilter(List<RtMatch> resultQuery) {
		List<RtMatch> resultFilter = 
				reduceMatchSelectingOnlyMatchCompleteOrMatchOverrideTypeEvent(resultQuery);
		
		if(nextFilter!=null) {
			return nextFilter.applyFilter(resultFilter);
		}
		// Resultado final
		return resultFilter;
	}

	
	/**
	 * Counts events types on markets of type Complete or Override from Matches, and 
	 * return the List<Match> with more events of one or other type.
	 * 
	 * In draw case, default Complete.
	 * 
	 * @param resultQuery, query's result's matchs.
	 * 
	 * @return
	 */
	private List<RtMatch> reduceMatchSelectingOnlyMatchCompleteOrMatchOverrideTypeEvent(
			List<RtMatch> resultQuery) {
		
		List<RtMatch> resultNormal		= new ArrayList<RtMatch>();
		List<RtMatch> resultProrroga	= new ArrayList<RtMatch>();
		
		int countComplete = 0;
		int countCompleteOverride = 0;


		for (RtMatch aMatch : resultQuery) {
			Set<RtMarket> pcMarkets		= new HashSet<RtMarket>();
			Set<RtMarket> pcpMarkets 	= new HashSet<RtMarket>();
//			Set<RtMarket> _1x2Markets 	= new HashSet<RtMarket>();			
			
			for(RtMarket market : aMatch.getRtMarkets()){
				if(market.getBetType().getObjectId().toString().equals(CfgBetTypeId.UNO_X_DOS.id())) {
//					_1x2Markets.add(market);
//					pcMarkets.add(market);//Nothing (Al borrar los que no corresponden, estos no se borrarán)
//					pcpMarkets.add(market);
					; // Luego se resta los que no van...y estos no se restan.
				} else {				
					if(market.getBetTypeEvent().getBetTypeEvent().getObjectId().toString().equals(
							CfgBetTypeEventId.PARTIDO_COMPLETO.objectId())) {
						pcMarkets.add(market);
						++countComplete;
					} else if(market.getBetTypeEvent().getBetTypeEvent().getObjectId().toString().equals(
							CfgBetTypeEventId.PARTIDO_COMPLETO_PRORROGA.objectId())){
						pcpMarkets.add(market);
						++countCompleteOverride;
					}
				}
			}
			
				
			// Si existen datos.
			if(countComplete>0||countCompleteOverride>0) {
				// Elimnar del Match los mercados porque, se van a insertar los reducidos para ese Match:
				// aMatch.getRtMarkets().clear();
				
				// Si hay más datos (o igual) de Partido Completo.
				if(countComplete>=countCompleteOverride) {
					for(RtMarket aMarket : pcpMarkets) {
						if(aMatch.getRtMarkets().contains(aMarket)) {
							aMatch.getRtMarkets().remove(aMarket);
						}
						//aMatch.getRtMarkets().add(aMarket);
					}					
					resultNormal.add(aMatch);
				} else {
					for(RtMarket aMarket : pcMarkets) {
						//aMatch.getRtMarkets().add(aMarket);
						if(aMatch.getRtMarkets().contains(aMarket)) {
							aMatch.getRtMarkets().remove(aMarket);
						}						
					}
					resultProrroga.add(aMatch);
				}
			} else {
				resultNormal.add(aMatch);
				resultProrroga.add(aMatch);
			}
			
		}
	
		if(resultNormal.size() >= resultProrroga.size()){
			return resultNormal;
		}
		
		return resultProrroga;
	}	
}
