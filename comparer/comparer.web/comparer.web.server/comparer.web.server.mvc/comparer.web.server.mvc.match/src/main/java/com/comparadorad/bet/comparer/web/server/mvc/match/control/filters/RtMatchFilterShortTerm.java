package com.comparadorad.bet.comparer.web.server.mvc.match.control.filters;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

/**
 * Filter to eliminate competition not Long Term
 * 
 * @author farce
 *
 */
public class RtMatchFilterShortTerm extends  AbstractRtMatchFilter<RtMatch> {
	
	/**
	 * Default Constructor
	 */
	public RtMatchFilterShortTerm() {
		
	}


	@Override
	/**
	 * {@inheritDoc}
	 */
	public List<RtMatch> applyFilter(List<RtMatch> resultQuery) {
		List<RtMatch> resultFilter = filterShortTerm(resultQuery);
		
		if(nextFilter!=null) {
			return nextFilter.applyFilter(resultFilter);
		}
		// Resultado final
		return resultFilter;

	}
	
	/**
	 * Function to filter data.
	 * 
	 * @param matchs
	 * @return
	 */
	protected List<RtMatch> filterShortTerm(List<RtMatch> matchs) {
		List<RtMatch> result = new ArrayList<RtMatch>();

		for (RtMatch aMatch : matchs) {
			if (aMatch.getMatchId().getCompetitionEvent() != null
					&& aMatch.getMatchId().getCompetitionEvent().getLongTerm() != null
					&& aMatch.getMatchId().getCompetitionEvent().getLongTerm()
							.getLongTerm().equals(Boolean.FALSE)) {
				result.add(aMatch);
			}
		}
		
		return result;
	}	
}
