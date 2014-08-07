package com.comparadorad.bet.comparer.web.server.mvc.match.control.filters;

import java.util.List;

/**
 * Interface to append filters to apply to lists of <T> data.
 * 
 * @author farce
 *
 */
public interface IRtMatchControllerFilter<T> {
	
	/**
	 * Apply the filter operation and calls applyFilter for the
	 * nextFilter (if any)
	 * 
	 * @return
	 */
	public List<T> applyFilter(List<T> resultQuery);	
	
	// Funciones para alcanzar el siguiente filtro.
	/**
	 * Returns next filter in responsability chain.
	 * 
	 * @param rtMatchFilterController
	 */
	public void setNextFilet(IRtMatchControllerFilter<T> rtMatchFilterController);
	public IRtMatchControllerFilter<T> getNextFilter();
}
