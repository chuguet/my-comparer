package com.comparadorad.bet.comparer.web.server.mvc.match.control.filters;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.mapreduce.CountryCompetitionEvent;

/**
 * Filter to Eliminate Coutns with zero value.
 * @author farce
 *
 */
public class CountryCompetionEventCountFilter extends  AbstractRtMatchFilter<CountryCompetitionEvent> {
	/**
	 * List to filter.
	 */
	private List<CountryCompetitionEvent> listCountryCompeitionEvent = new ArrayList<CountryCompetitionEvent>(); 
	
	/**
	 * Default Constructor.
	 * 
	 */
	public CountryCompetionEventCountFilter() {
		
	}
	
	/**
	 * Constructor with params.
	 * @param listCountryCompeitionEvent_
	 */
	public CountryCompetionEventCountFilter (List<CountryCompetitionEvent> listCountryCompeitionEvent_) {
		listCountryCompeitionEvent = listCountryCompeitionEvent_;
	}
	
	// Getters And Setters;
	/**
	 * Sets the List of CountryCompeitionEvent
	 * @param listCountryCompeitionEvent_
	 */
	public void setListCountryCompeitionEvent(List<CountryCompetitionEvent> listCountryCompeitionEvent_) {
		listCountryCompeitionEvent = listCountryCompeitionEvent_;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public List<CountryCompetitionEvent> applyFilter(List<CountryCompetitionEvent> resultQuery) {
		List<CountryCompetitionEvent> resultFilter = 
				selectElementsWithCountValues();
		
		if(nextFilter!=null) {
			return nextFilter.applyFilter(resultFilter);
		}
		// Resultado final
		return resultFilter;	
	}
	
	/**
	 * Filter elements with not counts.
	 * 
	 * @param resultQuery
	 * @return
	 */
	private List<CountryCompetitionEvent> selectElementsWithCountValues() {
		List<CountryCompetitionEvent> result = new ArrayList<CountryCompetitionEvent>();
		
		for (CountryCompetitionEvent listElement : listCountryCompeitionEvent) {
			if(listElement instanceof CountryCompetitionEvent) {
				CountryCompetitionEvent countryCompeitionEvent = (CountryCompetitionEvent)listElement;
				if (countryCompeitionEvent.getValue().getCounter() > 0) {
					result.add(listElement);
				}
			}
		}
		
		return result;
	}

}
