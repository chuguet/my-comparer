package com.comparadorad.bet.comparer.web.server.mvc.match.control.filters;

import java.util.List;

/**
 * Manager to apply the responsibility Chain.
 * <T> is the data. List<T> is the list to apply filter to:
 * 	List<T> applyFiltersChain(List<T> resultQuery), receives resultQuery
 *  returns List<T> reduced.
 * 
 * @author farce
 *
 */
public class RtMatchFilterManager<T>  {
	// Responsibility Chain is mounted with a Filter pointing to next filter.
	private IRtMatchControllerFilter<T> firstFilter   = null;
		
	/**
	 * Method to do the Filtration
	 */
	public List<T> applyFiltersChain(List<T> resultQuery) {
		if(firstFilter!=null) {
			return firstFilter.applyFilter(resultQuery);
		}
		
		return resultQuery;
	}

	/**
	 * Adds filters an returns itself to append more filters.
	 * 
	 * @param newSecFilter
	 */
	public RtMatchFilterManager<T> addFilter(IRtMatchControllerFilter<T> newSecFilter) {
		if(firstFilter == null) {
			firstFilter = newSecFilter;
			return this;
		} 
		
		// Sino, hay que encontrar el siguiente, que esté al final
		// de la cadena de filtros.
		getLastFilter(firstFilter).setNextFilet(newSecFilter);
		return this;
	}

	/**
	 * Return last filter.
	 * 
	 * @param newSecFilter
	 * @return
	 */
	private IRtMatchControllerFilter<T> getLastFilter(IRtMatchControllerFilter<T> newSecFilter) {
		if(newSecFilter.getNextFilter()==null) {
			return newSecFilter;
		}

		return getLastFilter(newSecFilter.getNextFilter());
	}
	
}
